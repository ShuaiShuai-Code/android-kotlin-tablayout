package com.fenboshi.fboshi.network.rx;


import com.fenboshi.fboshi.network.exception.ServerException;
import com.fenboshi.fboshi.network.model.NoDataResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxTransformer {

    private static final int SUCCESS = 0;

    /**
     * 切换到子线程 + 错误处理 + 回调OnError
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> errorHandle() {
        return new ObservableTransformer<BaseResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .map(new Function<BaseResponse<T>, T>() {
                            @Override
                            public T apply(BaseResponse<T> tBaseResponse) throws Exception {
                                //成功码
                                if (tBaseResponse.getRetCode() == SUCCESS) {
                                    if (tBaseResponse.getData() != null) {
                                        //成功，有data数据
                                        return tBaseResponse.getData();
                                    } else {
                                        //成功，无data数据
                                        NoDataResponse response = new NoDataResponse();
                                        response.setCode(tBaseResponse.getRetCode());
                                        response.setMsg(tBaseResponse.getErrorMsg());
                                        return (T) response;
                                    }
                                } else {
                                    //失败，抛异常
                                    throw new ServerException(tBaseResponse.getRetCode(), tBaseResponse.getErrorMsg());
                                }
                            }
                        });
            }
        };
    }


    /**
     * 切换到子线程 + 错误处理 + 回调OnError
     * 如果返回的数据data不确定有没有  那么用这个转换器
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> errorHandleWithEquivocal() {
        return new ObservableTransformer<BaseResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .map(new Function<BaseResponse<T>, T>() {
                            @Override
                            public T apply(BaseResponse<T> tBaseResponse) throws Exception {
                                int responseCode = SUCCESS;
                                //成功码
                                if (responseCode == SUCCESS) {
                                    return tBaseResponse.getData();
                                } else {
                                    //失败，抛异常
                                    throw new ServerException(responseCode, tBaseResponse.getErrorMsg());
                                }
                            }
                        });
            }
        };
    }

}

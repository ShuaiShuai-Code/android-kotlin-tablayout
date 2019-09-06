package com.fenboshi.fboshi.network.rx;

import android.os.Looper;


import com.fenboshi.fboshi.network.exception.ExceptionHandler;
import com.fenboshi.fboshi.network.exception.ResponeThrowable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {

    @Override
    public void onError(Throwable e) {
        ResponeThrowable throwable;

        if (e instanceof ResponeThrowable) {
            throwable = (ResponeThrowable) e;
        } else {
            throwable = ExceptionHandler.handleException(e);
        }
        if (throwable.getCode() != ExceptionHandler.ERROR.UNKNOWN) {
            //将错误原因展示给用户
            if (Looper.myLooper() == Looper.getMainLooper()) {

            } else {
                Looper.prepare();
                Looper.loop();
            }
            if (throwable.getCode() == ExceptionHandler.UNSET_PAY_PASSWORD
                    || throwable.getCode() == ExceptionHandler.UNUPLOAD_PRODUCT) {
                //需特殊处理的错误，不用Toast提示

            } else {
               // ToastUtil.showToast(throwable.getMessage());

            }

        } else {
            //ToastUtil.showToast(throwable.getMessage());

        }
        onFailure(throwable);
        onFinish();
    }

    @Override
    public void onComplete() {
        onFinish();
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
        onFinish();
    }

    /**
     * 成功
     *
     * @param data
     */
    protected abstract void onSuccess(T data);

    /**
     * 失败
     *
     * @param throwable
     */
    public void onFailure(ResponeThrowable throwable) {
    }

    /**
     * 完成
     */
    public void onFinish() {
    }

}
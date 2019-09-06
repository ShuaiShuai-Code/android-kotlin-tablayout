package com.fenboshi.fboshi.network.exception;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.socks.library.KLog;

import org.json.JSONException;

import java.net.ConnectException;

import retrofit2.HttpException;

public class ExceptionHandler {

    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int TOKEN_REFUSE = 501;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    public static final int UNSET_PAY_PASSWORD = 30007;//支付密码不正确
    public static final int LOGIN = 10002;
    public static final int UNUPLOAD_PRODUCT = 20003;

    public static ResponeThrowable handleException(Throwable e) {
       // Log.i("接到一个异常:" + e.getMessage());
        ResponeThrowable exception = null;
        //通过类型分类,再进行Code和Message处理
        if (e instanceof HttpException) {             //HTTP错误,如404等,均视为网络错误
            HttpException httpException = (HttpException) e;
            exception = new ResponeThrowable(e, httpException.code());
            switch (httpException.code()) {
                case UNAUTHORIZED:
                    exception.setMessage("网络授权错误:" + UNAUTHORIZED);
                    break;
                case FORBIDDEN:
                    exception.setMessage("链接禁止访问:" + FORBIDDEN);
                    break;
                case NOT_FOUND:
                    exception.setMessage("无效的网络链接:" + NOT_FOUND);
                    break;
                case REQUEST_TIMEOUT:
                    exception.setMessage("网络请求超时:" + REQUEST_TIMEOUT);
                    break;
                case GATEWAY_TIMEOUT:
                    exception.setMessage("网关超时:" + GATEWAY_TIMEOUT);
                    break;
                case INTERNAL_SERVER_ERROR:
                    exception.setMessage("服务器发生异常:" + INTERNAL_SERVER_ERROR);
                    break;
                case BAD_GATEWAY:
                    exception.setMessage("网关错误:" + BAD_GATEWAY);
                    break;
                case SERVICE_UNAVAILABLE:
                    exception.setMessage("服务器正在维护中:" + SERVICE_UNAVAILABLE);
                    break;
                default:
                    exception.setMessage("网络错误");
                    break;
            }
        } else if (e instanceof ServerException) {    //服务器返回的错误,如20001等
            ServerException serverException = (ServerException) e;
            exception = new ResponeThrowable(serverException, serverException.getCode());
            switch (serverException.getCode()) {
                case LOGIN:
//                    DaoManager.getInstance().logout();
//                    exception.setMessage("登录超时,请重新登录");
//                    Intent intent = new Intent(MyApplication.getApplication(), LoginActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    MyApplication.getInstance().startActivity(intent);
//                    break;
                default:
                    exception.setMessage(serverException.getMessage());
                    break;
            }
        } else if (e instanceof JsonParseException  //均视为解析错误
                || e instanceof JSONException
                || e instanceof JsonSyntaxException
                || e instanceof ParseException) {
            exception = new ResponeThrowable(e, ERROR.PARSE_ERROR);
            exception.setMessage("数据解析错误");
        } else if (e instanceof ConnectException) { //连接错误
            exception = new ResponeThrowable(e, ERROR.CONNECT_ERROR);
            exception.setMessage("连接失败");
        } else if (e.getMessage() != null && (e.getMessage().contains("after 10000ms") || e.getMessage().contains("Unable to resolve host"))) {
            exception = new ResponeThrowable(e, ERROR.TIMEOUT_ERROR);
            exception.setMessage("服务器连接超时");
        } else if (e.getMessage() != null && e.getMessage().contains("failed to connect to")) {
            exception = new ResponeThrowable(e, ERROR.CONNECT_ERROR);
            exception.setMessage("服务器连接失败");
        } else {
            exception = new ResponeThrowable(e, ERROR.UNKNOWN);
            exception.setMessage("连接服务器超时");
        }
        KLog.i("处理完毕之后:" + exception.getMessage());
        return exception;
    }

    /**
     * 约定异常
     */
    public interface ERROR {
        /**
         * 未知错误
         */
        int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        int CONNECT_ERROR = 1002;
        /**
         * 协议出错
         */
        int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        int SSL_ERROR = 1005;

        /**
         * 连接超时
         */
        int TIMEOUT_ERROR = 1006;

    }

}

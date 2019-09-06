package com.fenboshi.fboshi.network.api;

import com.fenboshi.fboshi.network.ApiConstant;
import com.fenboshi.fboshi.network.interceptor.HeaderInterceptor;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ApiCreator {

    public static Api getApi() {
        return ApiHolder.API_SERVICE;
    }

    private static final class RetrofitHolder {

        private static  String BASE_URL = "";
               //动态设置url
       public  static void  baseUrl(boolean IS_RELEASE_URL){
           BASE_URL=IS_RELEASE_URL? ApiConstant.BASE_RELEASE_URL: ApiConstant.BASE_DEBUG_URL;
       }

        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static final class OkHttpHolder {
        private static final int TIME_OUT = ApiConstant.DEFAULT_TIMEOUT;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
//                .followRedirects(true)//支持重定向
//                .hostnameVerifier(new HostnameVerifier() {//https支持
//                    @Override
//                    public boolean verify(String hostname, SSLSession session) {
//                        return true;
//                    }
//                })
//                .sslSocketFactory()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new HeaderInterceptor())
                .build();
    }

    private static final class ApiHolder {
        private static final Api API_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(Api.class);
    }

    private static SSLContext getSSLContext() {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");

            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        return sslContext;
    }

    public static X509TrustManager xtm = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            X509Certificate[] x509Certificates = new X509Certificate[0];
            return x509Certificates;
        }
    };
}

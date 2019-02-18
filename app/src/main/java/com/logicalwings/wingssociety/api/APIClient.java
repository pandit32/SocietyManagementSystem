package com.logicalwings.wingssociety.api;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logicalwings.wingssociety.BuildConfig;
import com.logicalwings.wingssociety.utils.LibFile;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static String BASE_URL = "http://smqaapi.webindemo.com/api/";

    private static Retrofit retrofit = null;

    public static APIInterface getClient(final Context context) {

        /*if (AppConstants.DEBUG)
            Log.e(AppConstants.DEBUG_TAG, "getClient: "+ BASE_URL);*/

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(200, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)
                .writeTimeout(200, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Log.e("token", LibFile.getInstance(context).getString(LibFile.KEY_TOKEN));
                        String authorizationHeaderToken = LibFile.getInstance(context).getString(LibFile.KEY_TOKEN,"");
                        request = request.newBuilder()
                                .addHeader("Authorization", authorizationHeaderToken)
                                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                                .build();

                        return chain.proceed(request);
                    }
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(new StringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(APIInterface.class);

    }

    private static class StringConverterFactory extends Converter.Factory {
        @Override
        public Converter<okhttp3.ResponseBody, String> responseBodyConverter(Type inType,
                                                                             Annotation[] inAnnotations,
                                                                             Retrofit inRetrofit) {
            if (String.class.equals(inType)) {
                return new Converter<okhttp3.ResponseBody, String>() {
                    @Override
                    public String convert(okhttp3.ResponseBody inValue) throws IOException {
                        return inValue.string().replace("\"", "");
                    }
                };
            }
            return null;
        }
    }
}

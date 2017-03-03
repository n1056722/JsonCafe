package com.example.asuper.json;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by asus on 2016/10/21.
 */

public class OkHttpHelper {
    public static final String TAG = "OkHttpManager$TAG";
    // const
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    // instance
    private static OkHttpHelper manager;
    // client
    private OkHttpClient client;

    private OkHttpHelper() {
        client = new OkHttpClient();
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpHelper getInstance() {
        if (manager == null) {
            manager = new OkHttpHelper();
        }
        return manager;
    }

    public String postJSON(String url, JSONObject j) {
        return postJSON(url, j.toString());
    }

    public String postJSON(String url, String json) {
        try {
            Log.d(TAG, json);
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            String str = response.body().string();
            Log.d(TAG, str);
            return str;
        } catch (SocketTimeoutException se) {
            return "{\"success\":" + ApiResultHelper.TIME_OUT + "}";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String get(String url){
       try {
           Request request = new Request.Builder()
                   .url(url)
                   .build();
           Response response = client.newCall(request).execute();
           String str = response.body().string();
           Log.d(TAG, str);
           return str;
       }
       catch (IOException e) {
           e.printStackTrace();
           return null;
       }
    }

}

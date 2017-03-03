package com.example.asuper.json;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by asus on 2016/12/8.
 */

public class ApiResultHelper {
    // pre
    public static final int NO_NETWORK = -10;
    // in server
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;
    public static final int EMPTY = 0;
    // response
    public static final int TIME_OUT = -3;
    public static final int PARSER_ERROR = -4;
    public static final int NO_RESPONSE = -5;

    // common
    public static int common(Context context, String response) {
        if (response == null) {
            ToastHelper.t(context, "伺服器沒有回應");
            return NO_RESPONSE;
        }
        try {
            JSONObject j = new JSONObject(response);
            int result = j.getInt("success");
            switch (result) {
                case NO_NETWORK:
                    ToastHelper.t(context, "目前沒有網路連線");
                    break;
                case TIME_OUT:
                    ToastHelper.t(context, "連線逾時");
                    break;
            }
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
            ToastHelper.t(context, "JSON剖析失敗");
            return PARSER_ERROR;
        }
    }


}

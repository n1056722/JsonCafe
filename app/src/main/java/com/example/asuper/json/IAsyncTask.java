package com.example.asuper.json;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by asus on 2016/7/12.
 */
public abstract class IAsyncTask extends AsyncTask<JSONObject, Integer, String> {
    // progress dialog
    private static final String MSG = "Loading...";
    private ProgressDialog pd;
    private boolean isShow = true;
    // content
    private final Context context;
    // params
    private JSONObject json;
    // target url
    private String url;
    // result code
    private int result;

    public IAsyncTask(Context context, JSONObject json, String url) {
        this.context = context;
        this.json = json;
        this.url = url;
    }

    public void setMessage(String message) {
        pd.setMessage(message);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (isShow) {
            pd = new ProgressDialog(context);
            pd.setIndeterminate(true);
            pd.setCancelable(false);
            pd.setMessage(MSG);
            pd.show();
        }
    }

    public JSONObject getJSONObject() {
        return json;
    }

    public int getResult() {
        return result;
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    @Override
    protected String doInBackground(JSONObject... params) {
        if (!EnvironmentHelper.isNetWork(context)) {
            JSONObject j = new JSONObject();
            try {
                j.put("success", ApiResultHelper.NO_NETWORK);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return j.toString();
        }
        return OkHttpHelper.getInstance().get(url);
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        if (isShow) {
            pd.dismiss();
        }
        //result = ApiResultHelper.common(context, response);
    }
}
package com.example.asuper.json;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import okhttp3.Request;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        JSONObject j =new JSONObject();
    new GetCafe(JsonActivity.this,j,"https://cafenomad.tw/api/v1.2/cafes").execute();





    }

    class GetCafe extends IAsyncTask{

        public GetCafe(Context context, JSONObject json, String url) {
            super(context, json, url);
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            ToastHelper.t(JsonActivity.this,response);



        }
    }


}

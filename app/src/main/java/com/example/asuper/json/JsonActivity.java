package com.example.asuper.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class JsonActivity extends AppCompatActivity {
private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        lv= (ListView) findViewById(R.id.lv);

        GitHubService service = GitHubService.retrofit.create(GitHubService.class);
        Call<List<Cafe>> cafe = service.listCafes1();


        cafe.enqueue(new Callback<List<Cafe>>() {
            @Override
            public void onResponse(Call<List<Cafe>> call, Response<List<Cafe>> response) {
                List<Cafe>data=response.body();
                lv.setAdapter(new JsonAdapter());
            }

            @Override
            public void onFailure(Call<List<Cafe>> call, Throwable t) {
               lv.setText(t.toString());
            }
        });
    }


}

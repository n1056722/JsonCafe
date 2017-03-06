package com.example.asuper.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class JsonActivity extends AppCompatActivity {
private TextView tv;
    private TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        tv= (TextView) findViewById(R.id.tv);
        tv2= (TextView) findViewById(R.id.tv2);
        GitHubService service = GitHubService.retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos("octocat");

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo>data=response.body();
                tv.setText(data.toString());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
               tv.setText(t.toString());
            }
        });
    }


}

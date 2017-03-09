package com.example.asuper.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
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
        lv = (ListView) findViewById(R.id.lv);


        GitHubService service = GitHubService.retrofit.create(GitHubService.class);
        Call<List<Cafe>> cafe = service.listCafes1();


        cafe.enqueue(new Callback<List<Cafe>>() {
            @Override
            public void onResponse(Call<List<Cafe>> call, Response<List<Cafe>> response) {
                List<Cafe> data = response.body();

                lv.setAdapter(new JsonAdapter(data));
            }

            @Override
            public void onFailure(Call<List<Cafe>> call, Throwable t) {
                Toast.makeText(JsonActivity.this, "錯誤", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class Json {
        String Cafe;

        public Json(String cafe) {
            this.Cafe = cafe;
        }
    }

    private class JsonAdapter extends BaseAdapter {
        List<Cafe> list;

        public JsonAdapter(List<Cafe> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {

                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.json_item, null);
                holder = new Holder();
                holder.name = (TextView) convertView.findViewById(R.id.tv_id);
                holder.assress= (TextView) convertView.findViewById(R.id.tv_ad);
                holder.tasty= (RatingBar) convertView.findViewById(R.id.rb_tasty);

                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            holder.name.setText(list.get(position).getName());
            holder.assress.setText(list.get(position).getAddress());
            holder.tasty.setRating(list.get(position).getTasty());



            return convertView;
        }

        class Holder {
            TextView assress;
            TextView  name;
            RatingBar tasty;


        }
    }

}

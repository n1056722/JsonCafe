package com.example.asuper.json;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Switch;
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

public class JsonActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView lv;
    private ImageView iv;
    ArrayList<Cafe> cafe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        lv = (ListView) findViewById(R.id.lv);
        iv= (ImageView) findViewById(R.id.iv);
        iv.setOnClickListener(this);
        cafe=new ArrayList<>();
        lv.setAdapter(new JsonAdapter(cafe));



    }
    public void getTaipei(){
        GitHubService service = GitHubService.retrofit.create(GitHubService.class);
        Call<List<Cafe>> call = service.listCafes1();



        call.enqueue(new Callback<List<Cafe>>() {
            @Override
            public void onResponse(Call<List<Cafe>> call, Response<List<Cafe>> response) {
                List<Cafe> data = response.body();
                cafe.clear();
            cafe.addAll(data);
                ((JsonAdapter) lv.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Cafe>> call, Throwable t) {
                Toast.makeText(JsonActivity.this, "錯誤", Toast.LENGTH_SHORT).show();
            }
        });

    }

   public void geThsinchu(){
       GitHubService service = GitHubService.retrofit.create(GitHubService.class);
       Call<List<Cafe>> call = service.listCafes();


       call.enqueue(new Callback<List<Cafe>>() {
           @Override
           public void onResponse(Call<List<Cafe>> call, Response<List<Cafe>> response) {
               List<Cafe> data = response.body();
               cafe.clear();
               cafe.addAll(data);

               ((JsonAdapter) lv.getAdapter()).notifyDataSetChanged();
           }

           @Override
           public void onFailure(Call<List<Cafe>> call, Throwable t) {
               Toast.makeText(JsonActivity.this, "錯誤", Toast.LENGTH_SHORT).show();
           }
       });

   }

    @Override
    public void onClick(View v) {
        final String[] dinner = {"台北","新竹"};

        AlertDialog.Builder dialog_list = new AlertDialog.Builder(JsonActivity.this);
        dialog_list.setTitle("選擇地區");
        dialog_list.setItems(dinner, new DialogInterface.OnClickListener(){
            @Override

            //只要你在onClick處理事件內，使用which參數，就可以知道按下陣列裡的哪一個了
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                switch (which){
                    case 0:
                        getTaipei();
                    break;
                    case 1:
                        geThsinchu();
                     break;
                }



                Toast.makeText(JsonActivity.this, "你選的是" + dinner[which], Toast.LENGTH_SHORT).show();
            }
        });
        dialog_list.show();


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

package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends Activity {

    private  static  final String API_KEY = "81e6c487f3a246d4b497b886b0f182e8";
    ArrayList<HeadingDataModel> headingDataModelArrayList;
    public static RecyclerView recyclerView ;
    HeadingAdapter headingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        NewsAPIInterface newsAPIInterface = NewsAPIClient.getClient().create(NewsAPIInterface.class);

        Call<DataModel> call = newsAPIInterface.getNews("in", API_KEY);
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if (response.body().getStatus().equals("ok")){
                    ArrayList<HeadingDataModel> model = response.body().getArticles();

                    recyclerView = findViewById(R.id.heading_recyclerView);
                    headingDataModelArrayList = new ArrayList<>();
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    headingAdapter = new HeadingAdapter(getApplicationContext(), model);
                    recyclerView.setAdapter(headingAdapter);
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });

    }


}
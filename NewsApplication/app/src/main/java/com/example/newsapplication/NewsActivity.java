package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewsActivity extends Activity {

    TextView textView_title;
    ImageView imgUrl;
    TextView textView_content;
    TextView textView_author;
    TextView textView_publishedAt;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        textView_title = findViewById(R.id.news_title);
        imgUrl = findViewById(R.id.img_url);
        textView_content = findViewById(R.id.content_text);
        textView_author = findViewById(R.id.author_text);
        textView_publishedAt = findViewById(R.id.publishedat_text);

        String Heading = getIntent().getStringExtra("title");
        String Url = getIntent().getStringExtra("url");
        String Content = getIntent().getStringExtra("content");
        String Author = getIntent().getStringExtra("author");
        String PublishedAt = getIntent().getStringExtra("published");

        textView_title.setText(Heading);
        textView_content.setText(Content);
        textView_author.setText("Author: " + Author);
        textView_publishedAt.setText("PublishedAt: " + PublishedAt);

        Glide.with(this).load(Url).into(imgUrl);

    }


}
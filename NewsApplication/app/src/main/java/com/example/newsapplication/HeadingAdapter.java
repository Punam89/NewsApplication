package com.example.newsapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeadingAdapter extends RecyclerView.Adapter<HeadingAdapter.ViewHolder> {
    Context context;
    ArrayList<HeadingDataModel> model;
    public HeadingAdapter(Context context, ArrayList<HeadingDataModel> model) {
        this.context =context;
        this.model = model;
    }

    @NonNull
    @Override
    public HeadingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heading_layout, null, false);
        return  new HeadingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadingAdapter.ViewHolder holder, int position) {

        final HeadingDataModel headingDataModel = model.get(position);
        holder.textView_heading.setText(headingDataModel.getTitle());

        holder.textView_heading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsActivity.class);
                intent.putExtra("title", headingDataModel.getTitle());
                intent.putExtra("url", headingDataModel.getUrlToImage());
                intent.putExtra("content", headingDataModel.getContent());
                intent.putExtra("author", headingDataModel.getAuthor());
                intent.putExtra("published", headingDataModel.getPublishedAt());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView_heading;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_heading = itemView.findViewById(R.id.headingText);
        }
    }
}

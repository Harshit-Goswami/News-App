package com.harshit.goswami.newsupdate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.harshit.goswami.newsupdate.Modas.ItemModal;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    ArrayList<ItemModal> newsList;
    Context context;

    public NewsAdapter(ArrayList<ItemModal> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(newsList.get(position).getUrlToImage())
                .placeholder(R.drawable.news_img2)
                .into(holder.imageView);

        holder.heading.setText(newsList.get(position).getTitle());
        //holder.mainContant.setText(newsList.get(position).getContent());
        //holder.author.setText(" -Publish by:"+newsList.get(position).getAuthor());
        holder.publishDate.setText(newsList.get(position).getPublishedAt());

        holder.cardView.setOnClickListener(View->{
            try
            {
                Intent intent=new Intent(context,NewsContent.class);
                intent.putExtra("newsUrl",newsList.get(position).getUrl());
                context.startActivity(intent);
            }catch (Exception e){}

        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView heading,publishDate;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.newsImg);
           heading=itemView.findViewById(R.id.heading);
         //mainContant=itemView.findViewById(R.id.main_content);
          // author=itemView.findViewById(R.id.author);
         publishDate=itemView.findViewById(R.id.publishDate);
         cardView =itemView.findViewById(R.id.cardView);
        }
    }
}

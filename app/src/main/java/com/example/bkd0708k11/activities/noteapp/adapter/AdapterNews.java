package com.example.bkd0708k11.activities.noteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.models.Article;

import java.util.ArrayList;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.StatementItemViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    ArrayList<Article> articles;

    public AdapterNews(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.articles = articles;
    }


    @NonNull
    @Override
    public StatementItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.news_item, parent, false);
        AdapterNews.StatementItemViewHolder myViewHolder = new StatementItemViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StatementItemViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvDescription.setText(article.getDescription());
        Glide.with(context).load(article.getUrlToImage()).into(holder.imgThumb);
    }

    @Override
    public int getItemCount() {
        return this.articles.size();
    }

    public class StatementItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvDescription;
        public ImageView imgThumb;

        public StatementItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imgThumb = itemView.findViewById(R.id.imgThumb);
        }
    }
}


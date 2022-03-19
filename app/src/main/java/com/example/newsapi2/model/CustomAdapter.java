package com.example.newsapi2.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.newsapi2.MainActivity;
import com.example.newsapi2.R;
import com.example.newsapi2.SelectListener;
import com.example.newsapi2.onFetchDataListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private Context context;
    private List<NewsHeadlines> newsHeadlines;
    private SelectListener listener;



    public CustomAdapter(Context context, List<NewsHeadlines> newsHeadlines,SelectListener listener ) {
        this.context = context;
        this.newsHeadlines = newsHeadlines;
        this.listener = listener;

    }




    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
      holder.text_title.setText(newsHeadlines.get(position).getTitle());
      holder.text_source.setText(newsHeadlines.get(position).getSource().getName());

      if(newsHeadlines.get(position).getUrlToImage()!=null){
          Picasso.get().load(newsHeadlines.get(position).getUrlToImage()).into(holder.img_headline);
      }

      holder.cardView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              listener.OnNewsClicked(newsHeadlines.get(position));
          }
      });

    }

    @Override
    public int getItemCount() {
        return newsHeadlines.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView text_title,text_source;
        ImageView img_headline;
        CardView cardView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            text_title = itemView.findViewById(R.id.text_title);
            text_source=itemView.findViewById(R.id.text_source);
            img_headline= itemView.findViewById(R.id.img_headline);
            cardView = itemView.findViewById(R.id.card);



        }
    }
}

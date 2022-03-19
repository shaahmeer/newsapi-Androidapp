package com.example.newsapi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapi2.model.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {

    NewsHeadlines headlines;
    private TextView title;
    private ImageView image;
    private TextView textDetailsAuthor;
    private TextView textDetailsTime;
    private TextView textDetailsDetail;
    private TextView textDetailsContent;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.title);
        image = findViewById(R.id.image);
        textDetailsAuthor = findViewById(R.id.text_details_author);
        textDetailsTime = findViewById(R.id.text_details_time);
        textDetailsDetail = findViewById(R.id.text_details_detail);
        textDetailsContent = findViewById(R.id.text_details_content);



        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        title.setText(headlines.getTitle());
        textDetailsTime.setText(headlines.getPublishedAt());
        textDetailsAuthor.setText(headlines.getAuthor());
        textDetailsDetail.setText(headlines.getDescription());
        textDetailsContent.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(image);

    }
}
package com.example.android.newsfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<News> news = QueryUtils.extractNews();

        ListView newsListView = findViewById(R.id.list);

        NewsAdapter adapter = new NewsAdapter(this, news);

        newsListView.setAdapter(adapter);
    }
}

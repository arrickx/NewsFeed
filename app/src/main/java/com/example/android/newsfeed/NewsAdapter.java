package com.example.android.newsfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView titleView = listItemView.findViewById(R.id.article_title);
        titleView.setText(currentNews.getmTitle());

        TextView sectionView = listItemView.findViewById(R.id.article_section);
        sectionView.setText(currentNews.getmSection());

        TextView authorView = listItemView.findViewById(R.id.article_author);
        authorView.setText(currentNews.getmAuthor());

        TextView publishTimeView = listItemView.findViewById(R.id.article_date);
        publishTimeView.setText(currentNews.getmPublishTime());

        return listItemView;
    }
}

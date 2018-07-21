package com.example.android.newsfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        //find the date and time of it;
        String originalTime = currentNews.getPublishTime();
        DateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date currentTime = null;
        try {
            currentTime = currentFormat.parse(originalTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TextView titleView = listItemView.findViewById(R.id.article_title);
        titleView.setText(currentNews.getTitle());

        TextView sectionView = listItemView.findViewById(R.id.article_section);
        sectionView.setText(currentNews.getSection());

        TextView authorView = listItemView.findViewById(R.id.article_author);
        authorView.setText(currentNews.getAuthor());

        TextView publishDateView = listItemView.findViewById(R.id.article_date);
        String articleDate = formatDate(currentTime);
        publishDateView.setText(articleDate);

        TextView publishTimeView = listItemView.findViewById(R.id.article_time);
        String articleTime = formatTime(currentTime);
        publishTimeView.setText(articleTime);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Aug 1, 2018") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "1:23 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}

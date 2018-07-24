package com.example.android.newsfeed;

import android.content.Context;
import android.util.Log;
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

    /** Tag for the log messages */
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

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
            Log.e(LOG_TAG, "Error with parsing current time", e);
        }

        TextView titleView = listItemView.findViewById(R.id.article_title);
        titleView.setText(currentNews.getTitle());

        TextView sectionView = listItemView.findViewById(R.id.article_section);
        sectionView.setText(currentNews.getSection());

        TextView publishDateView = listItemView.findViewById(R.id.article_date);
        String articleDate = formatDate(currentTime);
        publishDateView.setText(articleDate);

        TextView authorView = listItemView.findViewById(R.id.article_author);
        authorView.setText(currentNews.getAuthor());

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Aug 1  12:34 PM") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("   LLL dd h:mm a");
        return dateFormat.format(dateObject);
    }

}

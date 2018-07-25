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

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends ArrayAdapter<News> {

    /** Bind View using Butter Knife for better readability */
    @BindView(R.id.article_title) TextView title;
    @BindView(R.id.article_author) TextView author;
    @BindView(R.id.article_date) TextView date;
    @BindView(R.id.article_section) TextView section;

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

        // Access Bind View for this View*
        ButterKnife.bind(this, listItemView);

        // Get current position of the news
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

        // Set the title
        title.setText(currentNews.getTitle());

        // Set the section name
        section.setText(currentNews.getSection());

        // Get the formatted date and use it
        String articleDate = formatDate(currentTime);
        date.setText(articleDate);

        // Set the author name
        author.setText(currentNews.getAuthor());

        // Return the ListItem for display
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

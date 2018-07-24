package com.example.android.newsfeed;
/**
 * An {@link News} object contains information related to a single news.
 */
public class News {

    /** Title of the news article */
    private String mTitle;

    /** Section of the news article */
    private String mSection;

    /** Publish time of the news article */
    private String mPublishTime;

    /** Url of the news article */
    private String mUrl;

    /** Author of the news article */
    private String mAuthor;

    /**
     * Constructs a new {@link News} object.
     *
     * @param title       is the title of the news article
     * @param section     is the section of the news article
     * @param publishTime is the publish time of the news article
     * @param url         is the website URL to find more details about the earthquake
     * @param author      is the author of the news article
     */
    public News(String title, String section, String publishTime, String url, String author){
        mTitle = title;
        mSection = section;
        mPublishTime = publishTime;
        mUrl = url;
        mAuthor = author;
    }

    /** Return the title of the news article */
    public String getTitle() {
        return mTitle;
    }

    /** Return the section of the news article */
    public String getSection() {
        return mSection;
    }

    /** Return the publish time of the news article */
    public String getPublishTime() {
        return mPublishTime;
    }

    /** Return the url of the news article */
    public String getUrl() {
        return mUrl;
    }

    /** Return the author of the news article */
    public String getAuthor() {
        return mAuthor;
    }
}

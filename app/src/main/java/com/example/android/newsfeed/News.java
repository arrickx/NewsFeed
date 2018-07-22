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

    /**
     * Constructs a new {@link News} object.
     *
     * @param title       is the title of the news article
     * @param section     is the section of the news article
     * @param publishTime is the publish time of the news article
     * @param url         is the website URL to find more details about the earthquake
     */
    public News(String title, String section, String publishTime, String url){
        mTitle = title;
        mSection = section;
        mPublishTime = publishTime;
        mUrl = url;
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
}

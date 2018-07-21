package com.example.android.newsfeed;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public final class QueryUtils {
    private static final String SAMPLE_JSON_RESPONSE = "{\n" +
            "    \"response\": {\n" +
            "        \"status\": \"ok\",\n" +
            "        \"userTier\": \"developer\",\n" +
            "        \"total\": 2049484,\n" +
            "        \"startIndex\": 1,\n" +
            "        \"pageSize\": 10,\n" +
            "        \"currentPage\": 1,\n" +
            "        \"pages\": 204949,\n" +
            "        \"orderBy\": \"newest\",\n" +
            "        \"results\": [\n" +
            "            {\n" +
            "                \"id\": \"commentisfree/2018/jul/21/designer-babies-gene-editing-curing-disease\",\n" +
            "                \"type\": \"article\",\n" +
            "                \"sectionId\": \"commentisfree\",\n" +
            "                \"sectionName\": \"Opinion\",\n" +
            "                \"webPublicationDate\": \"2018-07-22T08:00:00Z\",\n" +
            "                \"webTitle\": \"Fear of dystopian change should not blind us to the potential of gene editing | Kenan Malik\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/commentisfree/2018/jul/21/designer-babies-gene-editing-curing-disease\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/commentisfree/2018/jul/21/designer-babies-gene-editing-curing-disease\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/opinion\",\n" +
            "                \"pillarName\": \"Opinion\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"sport/live/2018/jul/21/the-open-2018-third-round-live\",\n" +
            "                \"type\": \"liveblog\",\n" +
            "                \"sectionId\": \"sport\",\n" +
            "                \"sectionName\": \"Sport\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T17:29:14Z\",\n" +
            "                \"webTitle\": \"The Open 2018: third round: birdies fly in on moving day – live!\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/sport/live/2018/jul/21/the-open-2018-third-round-live\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/sport/live/2018/jul/21/the-open-2018-third-round-live\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/sport\",\n" +
            "                \"pillarName\": \"Sport\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"us-news/2018/jul/21/donald-trump-michael-cohen-tape-playboy-model\",\n" +
            "                \"type\": \"article\",\n" +
            "                \"sectionId\": \"us-news\",\n" +
            "                \"sectionName\": \"US news\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T17:15:41Z\",\n" +
            "                \"webTitle\": \"Trump claims Cohen tape may be illegal and insists he did nothing wrong\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/us-news/2018/jul/21/donald-trump-michael-cohen-tape-playboy-model\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/us-news/2018/jul/21/donald-trump-michael-cohen-tape-playboy-model\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/news\",\n" +
            "                \"pillarName\": \"News\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"world/2018/jul/21/women-travelling-from-northern-ireland-to-england-for-abortions\",\n" +
            "                \"type\": \"article\",\n" +
            "                \"sectionId\": \"world\",\n" +
            "                \"sectionName\": \"World news\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T17:02:17Z\",\n" +
            "                \"webTitle\": \"Rise in women travelling from Northern Ireland to England for abortions\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/world/2018/jul/21/women-travelling-from-northern-ireland-to-england-for-abortions\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/world/2018/jul/21/women-travelling-from-northern-ireland-to-england-for-abortions\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/news\",\n" +
            "                \"pillarName\": \"News\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"society/2018/jul/21/may-2bn-council-housing-pledge-not-enough-council-leaders-warn\",\n" +
            "                \"type\": \"article\",\n" +
            "                \"sectionId\": \"society\",\n" +
            "                \"sectionName\": \"Society\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T17:00:42Z\",\n" +
            "                \"webTitle\": \"May’s housing cash pledge is not enough, council leaders warn\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/society/2018/jul/21/may-2bn-council-housing-pledge-not-enough-council-leaders-warn\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/society/2018/jul/21/may-2bn-council-housing-pledge-not-enough-council-leaders-warn\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/news\",\n" +
            "                \"pillarName\": \"News\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"football/2018/jul/21/shahid-khan-wembley-mark-lamping-england-nfl\",\n" +
            "                \"type\": \"article\",\n" +
            "                \"sectionId\": \"football\",\n" +
            "                \"sectionName\": \"Football\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T17:00:42Z\",\n" +
            "                \"webTitle\": \"Shahid Khan keen for Wembley to be a key player either side of the Atlantic\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/football/2018/jul/21/shahid-khan-wembley-mark-lamping-england-nfl\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/football/2018/jul/21/shahid-khan-wembley-mark-lamping-england-nfl\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/sport\",\n" +
            "                \"pillarName\": \"Sport\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"books/2018/jul/21/book-interview-gabriel-tallent-q-and-a\",\n" +
            "                \"type\": \"article\",\n" +
            "                \"sectionId\": \"books\",\n" +
            "                \"sectionName\": \"Books\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T17:00:42Z\",\n" +
            "                \"webTitle\": \"Gabriel Tallent: ‘I follow my inspiration, however difficult’\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/books/2018/jul/21/book-interview-gabriel-tallent-q-and-a\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/books/2018/jul/21/book-interview-gabriel-tallent-q-and-a\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/arts\",\n" +
            "                \"pillarName\": \"Arts\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"commentisfree/2018/jul/21/yes-plastic-is-an-eco-nightmare-but-its-also-tired-old-technology\",\n" +
            "                \"type\": \"article\",\n" +
            "                \"sectionId\": \"commentisfree\",\n" +
            "                \"sectionName\": \"Opinion\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T17:00:41Z\",\n" +
            "                \"webTitle\": \"Yes, plastic is an eco nightmare. But it’s also tired, old technology | Lucy Siegle\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/commentisfree/2018/jul/21/yes-plastic-is-an-eco-nightmare-but-its-also-tired-old-technology\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/commentisfree/2018/jul/21/yes-plastic-is-an-eco-nightmare-but-its-also-tired-old-technology\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/opinion\",\n" +
            "                \"pillarName\": \"Opinion\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"sport/live/2018/jul/21/tour-de-france-2018-stage-14-live\",\n" +
            "                \"type\": \"liveblog\",\n" +
            "                \"sectionId\": \"sport\",\n" +
            "                \"sectionName\": \"Sport\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T16:29:00Z\",\n" +
            "                \"webTitle\": \"Tour de France 2018: Omar Fraile wins stage 14 – as it happened\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/sport/live/2018/jul/21/tour-de-france-2018-stage-14-live\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/sport/live/2018/jul/21/tour-de-france-2018-stage-14-live\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/sport\",\n" +
            "                \"pillarName\": \"Sport\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"business/2018/jul/21/philip-hammond-tax-rises-social-care-health-funding\",\n" +
            "                \"type\": \"article\",\n" +
            "                \"sectionId\": \"business\",\n" +
            "                \"sectionName\": \"Business\",\n" +
            "                \"webPublicationDate\": \"2018-07-21T16:22:34Z\",\n" +
            "                \"webTitle\": \"Everyone’s bound to be caught in Hammond’s tax rise net | Phillip Inman\",\n" +
            "                \"webUrl\": \"https://www.theguardian.com/business/2018/jul/21/philip-hammond-tax-rises-social-care-health-funding\",\n" +
            "                \"apiUrl\": \"https://content.guardianapis.com/business/2018/jul/21/philip-hammond-tax-rises-social-care-health-funding\",\n" +
            "                \"isHosted\": false,\n" +
            "                \"pillarId\": \"pillar/news\",\n" +
            "                \"pillarName\": \"News\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    private QueryUtils() {
    }

    public static ArrayList<News> extractNews(){
        ArrayList<News> news = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONObject thisArray = baseJsonResponse.getJSONObject("response");
            JSONArray newsArray = thisArray.getJSONArray("results");
            for (int i = 0; i < newsArray.length(); i++) {
                JSONObject currentNews = newsArray.getJSONObject(i);
                String title = currentNews.getString("webTitle");
                String section = currentNews.getString("sectionName");
                String author = currentNews.getString("pillarName");
                String time = currentNews.getString("webPublicationDate");
                String url = currentNews.getString("webUrl");

                News item = new News(title, section, author, time, url);
                news.add(item);
            }
        } catch (JSONException e){
            Log.e("QueryUtils","Problem parsing JSON results", e);
        }

        return news;
    }
}

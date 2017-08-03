package com.denghb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    static Map<String, String> cookies = new HashMap<String, String>();
    static List<String> urls = new ArrayList<String>();

    static String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36";

    static {

        urls.add("http://www.deepaso.com/app/requestdata?appid=1260929533&lang=cn");
        urls.add("https://aso114.com/json-appupdate.html?appid=3018369");
//        urls.add("https://aso100.com/app/manualRefreshByAppid/appid/1260929533/countryid/1");
//        urls.add("https://www.chandashi.com/update/app/appId/1260929533/country/cn.html");
        // urls.add("http://aso.aizhan.com/all/open-app-info/?appid=4160201&appleid=1260929533&rn=1501755305&cc=ded4d5c649ab7828082ba04d8c7c84ec");
        urls.add("http://rest.appbk.com/app/update_app_info?app_id=1260929533");
//        urls.add("http://www.guoaso.com/manualrefreshapp?country=cn&appid=1260929533");
    }


    static String accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";

    public static void main(String[] args) {
        System.out.println("Hello World!");


        for (String url : urls) {
            try {
                Document document = Jsoup.connect(url).header("Accept", accept).userAgent(userAgent).cookies(cookies).get();

                System.out.println(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

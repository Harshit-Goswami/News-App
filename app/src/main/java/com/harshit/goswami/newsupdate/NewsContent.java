package com.harshit.goswami.newsupdate;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;

public class NewsContent extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        Intent intent=getIntent();
//        String newsUrl =intent.getStringExtra("newsUrl");
//try{
//    webView=findViewById(R.id.webView);
//    webView.setWebViewClient(new WebViewClient());
//    webView.loadUrl(newsUrl);
//}catch (Exception exception){ }

    }
}
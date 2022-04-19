package com.harshit.goswami.newsupdate;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.harshit.goswami.newsupdate.Modas.ItemModal;
import com.harshit.goswami.newsupdate.Modas.MainModal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView recyclerViewsearch;
    ArrayList<ItemModal> searchNewsList;

   NewsAdapter Sadapter;
    String ApiKey="4f4023536ae14b40af4913dd68dcad18";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerViewsearch= findViewById(R.id.recyclerSearch);
        searchNewsList=new ArrayList<>();

        recyclerViewsearch.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Sadapter = new NewsAdapter( searchNewsList, getApplicationContext());

        recyclerViewsearch.setAdapter(Sadapter);

        Intent intent =getIntent();
       String query = intent.getStringExtra("query");

       ApiUtilities.getapiInterface().getSearchNews(query,ApiKey).enqueue(new Callback<MainModal>() {
           @Override
           public void onResponse(Call<MainModal> call, Response<MainModal> response) {
               if(response.isSuccessful()){
                   searchNewsList.addAll(response.body().getArticles());
                   Sadapter.notifyDataSetChanged();

               }
           }
           @Override
           public void onFailure(Call<MainModal> call, Throwable t) {

           }
       });
    }

}
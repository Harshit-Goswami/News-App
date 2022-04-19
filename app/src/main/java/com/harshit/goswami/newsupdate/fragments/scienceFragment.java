package com.harshit.goswami.newsupdate.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.harshit.goswami.newsupdate.ApiUtilities;
import com.harshit.goswami.newsupdate.Modas.ItemModal;
import com.harshit.goswami.newsupdate.Modas.MainModal;
import com.harshit.goswami.newsupdate.NewsAdapter;
import com.harshit.goswami.newsupdate.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class scienceFragment extends Fragment {
    RecyclerView recyclerViewScience;
    ArrayList<ItemModal> scienceNewsList;
    NewsAdapter ScNadapter;
    String ApiKey="4f4023536ae14b40af4913dd68dcad18";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.sciencefragment,null);
        recyclerViewScience =v.findViewById(R.id.sciencefragment);
        recyclerViewScience.setLayoutManager(new LinearLayoutManager(getContext()));
        scienceNewsList =new ArrayList<>();
        ScNadapter =new NewsAdapter(scienceNewsList,getContext());
        recyclerViewScience.setAdapter(ScNadapter);

        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities.getapiInterface().getCategoryNews("in",100,ApiKey,"science").enqueue(new Callback<MainModal>() {
            @Override
            public void onResponse(Call<MainModal> call, Response<MainModal> response) {
                if(response.isSuccessful()) {
                    scienceNewsList.addAll(response.body().getArticles());
                    ScNadapter.notifyDataSetChanged();
                }else
                { Toast.makeText(getContext(), "Not able to get", Toast.LENGTH_SHORT).show();}
            }


            @Override
            public void onFailure(Call<MainModal> call, Throwable t) {
                Toast.makeText(getContext(), "Check your Internet Connection !", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

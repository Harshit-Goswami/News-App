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

public class sportFragment extends Fragment {
    RecyclerView recyclerViewSport;
    ArrayList<ItemModal> sportNewsList;
    NewsAdapter SpNadapter;
    String ApiKey="4f4023536ae14b40af4913dd68dcad18";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.sportfragment,null);
    recyclerViewSport =v.findViewById(R.id.sportfragment);
    recyclerViewSport.setLayoutManager(new LinearLayoutManager(getContext()));
    sportNewsList =new ArrayList<>();
    SpNadapter =new NewsAdapter(sportNewsList,getContext());
    recyclerViewSport.setAdapter(SpNadapter);

    findNews();

        return v;
    }

    private void findNews() {
        ApiUtilities.getapiInterface().getCategoryNews("in",100,ApiKey,"sport").enqueue(new Callback<MainModal>() {
            @Override
            public void onResponse(Call<MainModal> call, Response<MainModal> response) {
                if(response.isSuccessful()) {
                    sportNewsList.addAll(response.body().getArticles());
                    SpNadapter.notifyDataSetChanged();
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

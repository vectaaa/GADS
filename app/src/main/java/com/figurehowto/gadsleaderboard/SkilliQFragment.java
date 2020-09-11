package com.figurehowto.gadsleaderboard;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.figurehowto.gadsleaderboard.model.LearnersLeadersInfo;
import com.figurehowto.gadsleaderboard.model.SkillIqLeadersInfo;
import com.figurehowto.gadsleaderboard.services.LearningLeaders;
import com.figurehowto.gadsleaderboard.services.SkillIq;

import java.util.List;


public class SkilliQFragment extends Fragment {


    public SkilliQFragment() {
        // Required empty public constructor
    }
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skill_iq, container, false);
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.learning_skill_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        SkillIq skilliqLeadersApi  =  retrofit.create(SkillIq.class);
        skilliqLeadersApi.getLearners().enqueue(new Callback<List<SkillIqLeadersInfo>>() {
            @Override
            public void onResponse(Call<List<SkillIqLeadersInfo>> call, Response<List<SkillIqLeadersInfo>> response) {
                Log.e("response",response.body().toString());
                recyclerView.setAdapter(new SkillRecyclerViewAdapter(getContext(),response.body()));

            }

            @Override
            public void onFailure(Call<List<SkillIqLeadersInfo>> call, Throwable t) {

            }
        });





        return view;
    }

}

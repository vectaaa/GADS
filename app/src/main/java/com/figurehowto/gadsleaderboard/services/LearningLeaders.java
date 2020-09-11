package com.figurehowto.gadsleaderboard.services;

import com.figurehowto.gadsleaderboard.model.LearnersLeadersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeaders {


    @GET("/api/hours")
    Call<List<LearnersLeadersInfo>> getLearners();
}

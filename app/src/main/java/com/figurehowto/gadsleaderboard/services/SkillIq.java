package com.figurehowto.gadsleaderboard.services;

import com.figurehowto.gadsleaderboard.model.LearnersLeadersInfo;
import com.figurehowto.gadsleaderboard.model.SkillIqLeadersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillIq {


    @GET("/api/skilliq")
    Call<List<SkillIqLeadersInfo>> getLearners();
}

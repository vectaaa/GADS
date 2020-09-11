package com.figurehowto.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.figurehowto.gadsleaderboard.model.LearnersLeadersInfo;
import com.figurehowto.gadsleaderboard.model.SkillIqLeadersInfo;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.ViewHolder> {
    Context context;
    private List<SkillIqLeadersInfo> learnersInfo;
    //ImageView imageView;

    private View view;

    public SkillRecyclerViewAdapter(Context context , List<SkillIqLeadersInfo> learnersInfo) {
        this.context = context;
       // this.imageView = imageView;
        this.learnersInfo = learnersInfo;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_format, parent, false);
        return new SkillRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String imageUrl = learnersInfo.get(position).getBadgeUrl();
        String studentDetails = learnersInfo.get(position).getScore() +
                " skill IQ Score, " +
                learnersInfo.get(position).getCountry();

        Glide.with(context)
                .load(imageUrl)
                .into(holder.badge);
        holder.name.setText(learnersInfo.get(position).getName());

        holder.subtitle.setText(studentDetails);


    }

    @Override
    public int getItemCount() {
        return learnersInfo.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView badge;
        TextView name, subtitle;

        public ViewHolder(View itemView) {
            super(itemView);

            badge = (ImageView) itemView.findViewById(R.id.badge);
            name =(TextView) itemView.findViewById(R.id.name);
            subtitle =(TextView) itemView.findViewById(R.id.subtitle);

        }

    }



}

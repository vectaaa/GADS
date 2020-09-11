package com.figurehowto.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class LeaderboardActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    private String[] tabTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        //Link XML to Java Code
        tabTitles = getResources().getStringArray(R.array.tab_titles);
        tabLayout = findViewById(R.id.tabLayoutHome);
        viewPager = findViewById(R.id.viewPagerHome);
        Button submit = (Button)findViewById(R.id.submit);
        //Attach OnClickListener to our submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitActivity = new Intent(LeaderboardActivity.this, ProjectSubmissionActivity.class);
                startActivity(submitActivity);
            }
        });
        //Add 2 tabs to the TabLayout
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Viewpager Adapter and attach to ViewPager2
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this, 2);
        viewPager.setAdapter(adapter);
        // TabLayoutMediator to link the TabLayout to the ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        Log.e("Tab", String.valueOf(position));
                        tab.setText(tabTitles[position]);
                    }
                }
        ).attach();
    }


}

class MyViewPagerAdapter extends FragmentStateAdapter {
    int totalTabs;

    public MyViewPagerAdapter(@NonNull FragmentActivity fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                LearningLeadersFragment learningLeadersFragment = new LearningLeadersFragment();
                return learningLeadersFragment;
            case 1:
                SkilliQFragment skilliQFragment = new SkilliQFragment();
                return skilliQFragment;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {

        return totalTabs;
    }

}

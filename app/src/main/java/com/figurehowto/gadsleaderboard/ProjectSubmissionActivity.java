package com.figurehowto.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectSubmissionActivity extends AppCompatActivity {
    EditText firstName,lastName,emailAddress,githubLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Link Android XML to java class
        Button submitProject;
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        emailAddress = findViewById(R.id.email_address);
        githubLink = findViewById(R.id.github_link);
        submitProject = findViewById(R.id.submit_project);
        submitProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Convert Edittext Values to string
                String fName,lName,eMail,gitLink;
                fName =firstName.getText().toString();
                lName = lastName.getText().toString();
                eMail = emailAddress.getText().toString();
                gitLink = githubLink.getText().toString();
                //Send String data into the PopUp activity
                Intent intent = new Intent(ProjectSubmissionActivity.this,AreYouSure.class);
                intent.putExtra("fname",fName);
                intent.putExtra("lName",lName);
                intent.putExtra("eMail",eMail);
                intent.putExtra("gitLink",gitLink);
                startActivity(intent);
            }
        });


    }
    //To handle back pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

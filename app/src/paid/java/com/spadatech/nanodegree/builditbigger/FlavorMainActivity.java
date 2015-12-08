package com.spadatech.nanodegree.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.spadatech.nanodegree.jokeviewer.JokeViewerActivity;

public class FlavorMainActivity extends AppCompatActivity implements EndpointsAsyncTask.OnJokeRetrievedListener{

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavor_main);

        spinner = (ProgressBar)findViewById(R.id.progressBar);
    }

    public void tellJoke(View view){
        new EndpointsAsyncTask(this, spinner).execute();
    }

    @Override
    public void OnJokeRetrieved(String joke) {
        Intent intent = new Intent(this, JokeViewerActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}

package com.spadatech.nanodegree.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class JokeViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        String joke = getIntent().getStringExtra("joke");
        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
    }
}

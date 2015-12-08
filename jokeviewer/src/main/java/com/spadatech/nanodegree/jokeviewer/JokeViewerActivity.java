package com.spadatech.nanodegree.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokeViewerActivity extends AppCompatActivity {

    private TextView mTvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        mTvJoke = (TextView) findViewById(R.id.tv_joke);
        mTvJoke.setText("");

        String joke = getIntent().getStringExtra("joke");
        mTvJoke.setText(joke);
    }
}

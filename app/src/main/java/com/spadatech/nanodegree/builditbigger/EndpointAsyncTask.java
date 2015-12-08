package com.spadatech.nanodegree.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.spadatech.nanodegree.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Ludens Machina on 12/6/2015.
 */
class EndpointsAsyncTask extends AsyncTask<EndpointsAsyncTask.OnJokeRetrievedListener, ProgressBar, String> {
    private MyApi myApiService = null;
    private ProgressBar spinner;
    private EndpointsAsyncTask.OnJokeRetrievedListener listener;

    public EndpointsAsyncTask(OnJokeRetrievedListener listener, ProgressBar spinner) {
        this.listener = listener;
        this.spinner = spinner;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (spinner != null) {
            spinner.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(OnJokeRetrievedListener... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1152.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(spinner != null & spinner.getVisibility() == View.VISIBLE){
            spinner.setVisibility(View.GONE);
        }
        listener.OnJokeRetrieved(result);
    }

    public interface OnJokeRetrievedListener{
        void OnJokeRetrieved(String joke);
    }
}

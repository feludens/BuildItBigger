package com.spadatech.nanodegree.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.spadatech.nanodegree.jokeviewer.JokeViewerActivity;

public class FlavorMainActivity extends AppCompatActivity implements EndpointsAsyncTask.OnJokeRetrievedListener {

    private ProgressBar mSpinner;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavor_main);

        mSpinner = (ProgressBar)findViewById(R.id.progressBar);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    public void tellJoke(View view){
        new EndpointsAsyncTask(this, mSpinner).execute();
    }

    @Override
    public void OnJokeRetrieved(final String joke) {
        final String fJoke = joke;

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (mSpinner != null) {
                    mSpinner.setVisibility(View.GONE);
                }
                mInterstitialAd.show();
            }

            @Override
            public void onAdClosed() {
                goToJokeViewer(joke);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                if (mSpinner != null) {
                    mSpinner.setVisibility(View.GONE);
                }
                goToJokeViewer(joke);
            }
        });

        AdRequest ar = new AdRequest
                .Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(ar);

    }

    private void goToJokeViewer(String joke){
        Intent intent = new Intent(this, JokeViewerActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}

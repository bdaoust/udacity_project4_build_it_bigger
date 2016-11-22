package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.networking.FetchRandomJokeTask;

import org.bdaoust.funnyjokesui.JokeViewerActivity;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private ProgressBar mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                showJokeActivity();
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();

        mSpinner = (ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    private void showJokeActivity(){
        FetchRandomJokeTask fetchRandomJokeTask;

        fetchRandomJokeTask = new FetchRandomJokeTask(new FetchRandomJokeTask.OnFetchedRandomJokeListener() {
            @Override
            public void onFetchedRandomJoke(String randomJoke) {
                Intent intent;

                intent = new Intent(getApplicationContext(), JokeViewerActivity.class);
                intent.putExtra(JokeViewerActivity.EXTRA_JOKE, randomJoke);
                startActivity(intent);

                mSpinner.setVisibility(View.GONE);
            }
        });

        fetchRandomJokeTask.execute();
        mSpinner.setVisibility(View.VISIBLE);
    }

}
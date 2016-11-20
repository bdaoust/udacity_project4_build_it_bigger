package com.udacity.gradle.builditbigger.networking;


import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.jokes.backend.funnyJokesApi.FunnyJokesApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class FetchRandomJokeTask extends AsyncTask<Void, Void, String>{

    private OnFetchedRandomJokeListener mOnFetchedRandomJokeListener;
    private static FunnyJokesApi funnyJokesApiService = null;

    public FetchRandomJokeTask(@NonNull OnFetchedRandomJokeListener onFetchedRandomJokeListener){
        mOnFetchedRandomJokeListener = onFetchedRandomJokeListener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(funnyJokesApiService == null){
            FunnyJokesApi.Builder builder;

            builder = new FunnyJokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            funnyJokesApiService = builder.build();
        }

        try{
            return funnyJokesApiService.sayRandomJoke().execute().getData();
        } catch (IOException e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(mOnFetchedRandomJokeListener != null){
            mOnFetchedRandomJokeListener.onFetchedRandomJoke(result);
        }
    }

    public interface OnFetchedRandomJokeListener{
        void onFetchedRandomJoke(String randomJoke);
    }
}

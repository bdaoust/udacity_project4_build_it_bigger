package com.udacity.gradle.builditbigger.networking;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class FetchRandomJokeTaskTests {

    @Test
    public void testDoInBackground_ReturnsNonEmptyString(){
        FetchRandomJokeTask fetchRandomJokeTask;
        String randomJoke;

        fetchRandomJokeTask = new FetchRandomJokeTask(new FetchRandomJokeTask.OnFetchedRandomJokeListener() {
            @Override
            public void onFetchedRandomJoke(String randomJoke) {
            }
        });

        randomJoke = fetchRandomJokeTask.doInBackground();
        assertNotNull(randomJoke);
        assertFalse(randomJoke.isEmpty());

        //Ensure that the retrieved "randomJoke" is not a connection error
        assertFalse(randomJoke.contains("isConnected failed: ECONNREFUSED (Connection refused)"));
    }

    @Test
    public void testOnPostExecute_CallsOnFetchedRandomJoke(){
        FetchRandomJokeTask fetchRandomJokeTask;
        final String joke = "This is a joke";
        final boolean[] onFetchedRandomJokeCalled = new boolean[1];

        onFetchedRandomJokeCalled[0] = false;

        fetchRandomJokeTask = new FetchRandomJokeTask(new FetchRandomJokeTask.OnFetchedRandomJokeListener() {
            @Override
            public void onFetchedRandomJoke(String randomJoke) {
                assertEquals(joke,randomJoke);
                onFetchedRandomJokeCalled[0] = true;
            }
        });

        fetchRandomJokeTask.onPostExecute(joke);
        assertTrue(onFetchedRandomJokeCalled[0]);
    }

}
package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class JokeProviderTests {

    private JokeProvider mJokeProvider;

    @Before
    public void setup() {
        mJokeProvider = new JokeProvider();
    }

    @Test
    public void testConstructors(){
        ArrayList<String> jokesList;

        //I want the JokeProvider to contain at least 25 jokes by default
        assertTrue(mJokeProvider.size() >= 25);

        jokesList = new ArrayList<>();
        jokesList.add("Joke1");
        jokesList.add("Joke2");
        jokesList.add("Joke3");

        mJokeProvider = new JokeProvider(jokesList);
        assertEquals(3, mJokeProvider.size());
    }

    @Test
    public void testGetRandomJoke(){
        ArrayList<String> jokesList;
        String randomJoke1;
        String randomJoke2;

        jokesList = new ArrayList<>();

        for(int i=0; i<10000; i++){
            jokesList.add("Joke " + i);
        }

        mJokeProvider = new JokeProvider(jokesList);

        randomJoke1 = mJokeProvider.getRandomJoke();
        randomJoke2 = mJokeProvider.getRandomJoke();

        assertTrue(jokesList.contains(randomJoke1));
        assertTrue(jokesList.contains(randomJoke2));

        assertFalse(randomJoke1.equals(randomJoke2));
    }
}

package org.bdaoust.funnyjokesui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewerActivity extends AppCompatActivity {

    public final static String EXTRA_JOKE = "org.bdaoust.funnyjokesui.EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView jokeTextView;
        Intent intent;
        Bundle extras;
        String joke;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        intent = getIntent();
        extras = intent.getExtras();
        joke = extras.getString(EXTRA_JOKE);

        jokeTextView = (TextView)findViewById(R.id.jokeTextView);
        jokeTextView.setText(joke);
    }
}

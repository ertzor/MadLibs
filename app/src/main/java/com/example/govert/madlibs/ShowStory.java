package com.example.govert.madlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowStory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

        // get story
        Story story = (Story) getIntent().getSerializableExtra("chosen_story");

        // get textView
        TextView storyView = (TextView) findViewById(R.id.story);

        // set text to story
        storyView.setText(story.toString());
    }

    public void playAgain() {
        onBackPressed();
    }
}

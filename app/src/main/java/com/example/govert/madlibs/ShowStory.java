package com.example.govert.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowStory extends AppCompatActivity {

    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

        // get story
        story = (Story) getIntent().getSerializableExtra("chosen_story");

        TextView storyView = (TextView) findViewById(R.id.story);

        storyView.setText(story.toString());
    }

    public void playAgain() {
        // clear story
        story.clear();

        // go back to starting screen
        Intent intent = new Intent(ShowStory.this, MainActivity.class);
        startActivity(intent);
    }
}

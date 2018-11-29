package com.example.govert.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class GetWords extends AppCompatActivity {
    private Story story;
    private EditText inputField;
    private TextView wordsLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_words);

        // get input field
        inputField = (EditText) findViewById(R.id.input);

        // get story
        story = (Story) getIntent().getSerializableExtra("chosen_story");

        // set amount of words left
        wordsLeft = (TextView) findViewById(R.id.wordsLeft);
        wordsLeft.setText(String.format("%s word(s) left", story.getPlaceholderRemainingCount()));

        // set typeOfWord hint
        inputField.setHint(String.format("Enter %s", story.getNextPlaceholder().toLowerCase()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // set wordsLeft
        wordsLeft.setText(String.format("%s word(s) left", story.getPlaceholderRemainingCount()));
    }

    public void enterWord(View view) {
        // fill in word
        story.fillInPlaceholder(inputField.getText().toString());

        // clear inputField
        inputField.setText("");

        // set new typeOfWord hint
        inputField.setHint(String.format("Enter %s", story.getNextPlaceholder().toLowerCase()));

        // set new amount of words left
        wordsLeft.setText(String.format("%s word(s) left", story.getPlaceholderRemainingCount()));

        // make intent
        Intent intent = new Intent(GetWords.this, ShowStory.class);
        intent.putExtra("chosen_story", story);

        // if no next placeholder, show story
        if (story.getNextPlaceholder() == "") {
            finish();
            startActivity(intent);
        }
    }
}

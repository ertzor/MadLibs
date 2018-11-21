package com.example.govert.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.icu.lang.UProperty.INT_START;

public class GetWords extends AppCompatActivity {
    private Story story;
    private String word;
    private EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_words);

        // get input field
        inputField = (EditText) findViewById(R.id.input);

        // set listener
        inputField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                word = v.getText().toString();
                return false;
            }
        });

        // get story
        story = (Story) getIntent().getSerializableExtra("chosen_story");

        // set amount of words left
        TextView wordsLeft = (TextView) findViewById(R.id.wordsLeft);
        int nOfWordsLeft = story.getPlaceholderCount();
        String text = String.format("%s word(s) left", nOfWordsLeft);
        wordsLeft.setText(text);

        // set typeOfWord hint
        String typeOfWord = story.getNextPlaceholder().toLowerCase();
        String hint = String.format("Enter %s", typeOfWord);
        inputField.setHint(hint);
    }

    public void enterWord(View view) {
        // fill in word
        story.fillInPlaceholder(word);

        // clear inputField
        inputField.setText("");

        // set new typeOfWord hint
        String typeOfWord = story.getNextPlaceholder().toLowerCase();
        String hint = String.format("Enter %s", typeOfWord);
        inputField.setHint(hint);

        // set new amount of words left
        TextView wordsLeft = (TextView) findViewById(R.id.wordsLeft);
        int nOfWordsLeft = story.getPlaceholderRemainingCount();
        String text = String.format("%s word(s) left", nOfWordsLeft);
        wordsLeft.setText(text);

        // make intent
        Intent intent = new Intent(GetWords.this, ShowStory.class);
        intent.putExtra("chosen_story", story);

        if (typeOfWord == "") {
            startActivity(intent);
        }
    }
}

package com.example.govert.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // initialize story
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create story options
        String[] stories = new String[]{"Simple", "Tarzan", "University", "Clothes", "Dance"};

        // create spinner
        Spinner spinner = (Spinner) findViewById(R.id.chooseStory);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                R.layout.spinner_item, stories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        // set listener for spinner
        spinner.setOnItemSelectedListener(this);
    }

    /** Open words interface with intent */
    public void playClicked(View view) {
        // make intent
        Intent intent = new Intent(MainActivity.this, GetWords.class);
        intent.putExtra("chosen_story", story);

        // start GetWords with intent
        startActivity(intent);
    }

    /** Creates story instance based on user selection */
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(position) {
            case 0:
                newStory("madlib0_simple");
                break;
            case 1:
                newStory("madlib1_tarzan");
                break;
            case 2:
                newStory("madlib2_university");
                break;
            case 3:
                newStory("madlib3_clothes");
                break;
            case 4:
                newStory("madlib4_dance");
                break;
        }
    }

    public void newStory(String storyName) {
        // create story
        story = new Story(getResources().openRawResource(getResources().getIdentifier(storyName,
                "raw", getPackageName())));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // auto generated method stub
    }
}

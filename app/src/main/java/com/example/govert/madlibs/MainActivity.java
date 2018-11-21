package com.example.govert.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // create story options
    private static final String[] stories = new String[]{"Simple", "Tarzan", "University", "Clothes", "Dance"};

    // create story with inputStream fileName
    private InputStream stream;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create spinner
        Spinner spinner = (Spinner) findViewById(R.id.chooseStory);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item, stories);
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
                // set stream for story
                stream = getResources().openRawResource(getResources().getIdentifier("madlib0_simple",
                        "raw", getPackageName()));

                // make story instance
                story = new Story(stream);
                break;
            case 1:
                // set stream for story
                stream = getResources().openRawResource(getResources().getIdentifier("madlib1_tarzan",
                        "raw", getPackageName()));

                // make story instance
                story = new Story(stream);
                break;
            case 2:
                // set stream for story
                        stream = getResources().openRawResource(getResources().getIdentifier("madlib2_university",
                        "raw", getPackageName()));

                // make story instance
                story = new Story(stream);
                break;
            case 3:
                // set stream for story
                stream = getResources().openRawResource(getResources().getIdentifier("madlib3_clothes",
                        "raw", getPackageName()));

                // make story instance
                story = new Story(stream);
                break;
            case 4:
                // set stream for story
                stream = getResources().openRawResource(getResources().getIdentifier("madlib4_dance",
                        "raw", getPackageName()));

                // make story instance
                story = new Story(stream);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // auto generated method stub
    }
}

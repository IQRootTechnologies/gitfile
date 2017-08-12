package com.yschi.castscreen;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Dell on 07-08-2017.
 */

public class Grocery extends iqute
{

    public ImageButton groButton;
    public ListView groList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);


        groButton = (ImageButton) findViewById(R.id.groButton);
        groList = (ListView) findViewById(R.id.groList);


        voiceInputButton();
        groButton.setOnClickListener(this);

    }

    private void voiceInputButton()
    {
        groButton = (ImageButton) findViewById(R.id.groButton);
        groList = (ListView) findViewById(R.id.groList);
    }

    @Override
    public void onClick(View view) {
        //super.onClick(view);
        startRecognitionActivity();
    }

    private void startRecognitionActivity()
    {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Up");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK)
        {
            ArrayList matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            mList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, matches));

            if (matches.contains("back"))
            {
                back();
            }

        }
    }

    private void back()
    {
        Intent groBackPage = new Intent(this, iqute.class);
        startActivity(groBackPage);

    }
}


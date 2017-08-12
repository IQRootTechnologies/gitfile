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

public class Watches extends iqute
{
    public ImageButton watButton;
    public ListView watList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watches);

        watButton = (ImageButton) findViewById(R.id.watButton);
        watList = (ListView) findViewById(R.id.watList);


        voiceInputButton();
        watButton.setOnClickListener(this);


    }

    private void voiceInputButton()
    {
        watButton = (ImageButton) findViewById(R.id.watButton);
        watList = (ListView) findViewById(R.id.watList);

    }

    @Override
    public void onClick(View v) {
        //super.onClick(v);
        startVoiceRecognitionactivity();

    }

    private void startVoiceRecognitionactivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Up");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
        Intent watBackPage = new Intent(this, iqute.class);
        startActivity(watBackPage);
    }
}

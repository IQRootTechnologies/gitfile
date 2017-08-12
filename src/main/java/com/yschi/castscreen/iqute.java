package com.yschi.castscreen;

/**
 * Created by Dell on 07-08-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class iqute extends MainActivity implements View.OnClickListener
{
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    ImageButton ib;
    public ImageButton speakButton;
    public ListView mList;
    public TextView tView;

    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqute);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        ib = (ImageButton) findViewById(R.id.btn_speak);
//        iv = (ImageView) findViewById(R.id.imageView);
        // imgButton = (ImageButton) findViewById(R.id.imageBtn);
        // imgButton.setOnClickListener(this);

        speakButton = (ImageButton) findViewById(R.id.btn_speak);
        // next = (Button) findViewById(R.id.next);
       // tView = (TextView) findViewById(R.id.tView);

        speakButton.setOnClickListener(this);
        voiceInputButtons();
    }

    private void voiceInputButtons()
    {
        speakButton = (ImageButton) findViewById(R.id.btn_speak);
        mList = (ListView) findViewById(R.id.list);
    }


    public  void startElectronics(View v)
    {
        Toast.makeText(iqute.this, "Electronics", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Electronics.class));
    }
    public  void startGrocery(View v)
    {
        Toast.makeText(iqute.this, "Grocery", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Grocery.class));
    }
    public  void startBook(View v)
    {
        Toast.makeText(iqute.this, "Books", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Books.class));
    }
    public  void startFashion(View v)
    {
        Toast.makeText(iqute.this, "Fashion", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Fashion.class));
    }
    public  void startLaptop(View v)
    {
        Toast.makeText(iqute.this, "Laptop", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Laptop.class));
    }
    public  void startWatch(View v)
    {
        Toast.makeText(iqute.this, "Watch", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Watches.class));
    }
    public  void startNext(View v)
    {
        Toast.makeText(iqute.this, "Next", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Next.class));
    }
    public  void startOthers(View v)
    {
        Toast.makeText(iqute.this, "Others", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Others.class));
    }
    public  void startCamera(View v)
    {
        Toast.makeText(iqute.this, "Camera Started", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(iqute.this,Camera.class));
    }
    public  void clickCast(View v)
    {
        Toast.makeText(iqute.this, "Welcome to Easy2Buy", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(MainActivity.this,Camera.class));
    }


    @Override
    public void onClick(View view)

    {
        startVoiceRecognitionActivity ();
    }

       public void startVoiceRecognitionActivity ()
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

            if (matches.contains("one"))
            {
                one();
            }

            else if (matches.contains("two"))
            {
                two();
            }
            else if (matches.contains("three"))
            {
                three();
            }
            else if (matches.contains("four"))
            {
                four();
            }
            else if (matches.contains("five"))
            {
                five();
            }
            else if (matches.contains("six"))
            {
                six();
            }
        }
    }

    public void one()
    {
        Intent firstPage = new Intent(this, Electronics.class);
        startActivity(firstPage);
    }
    public void two()
    {
        Intent secondPage = new Intent(this, Grocery.class);
        startActivity(secondPage);
    }

    public void three()
    {
        Intent thirdPage = new Intent(this, Books.class);
        startActivity(thirdPage);
    }

    public void four()
    {
        Intent fourthPage = new Intent(this, Fashion.class);
        startActivity(fourthPage);
    }

    public void five()
    {
        Intent fifthPage = new Intent(this, Laptop.class);
        startActivity(fifthPage);
    }

    public void six()
    {
        Intent sixthPage = new Intent(this, Watches.class);
        startActivity(sixthPage);
    }

}


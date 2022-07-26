package com.example.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText et;
Button b;
TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        b = (Button) findViewById(R.id.b);
        b.setOnClickListener(this);
      tts = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
          @Override
          public void onInit(int i) {
              if(i!=TextToSpeech.ERROR){
                  Toast.makeText(getBaseContext(), "Type to spell", Toast.LENGTH_LONG).show();
              }
          }
      });

    }
    @Override
    public void onClick(View v){
        String data = et.getText().toString();
        tts.speak(data, TextToSpeech.QUEUE_FLUSH, null);
    }

}
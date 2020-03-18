package com.example.alfabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    //Metoda otwierajaca nowa intencje
    public void send_layout(){
        Intent i = new Intent(this, Send.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton send_button = (ImageButton) findViewById(R.id.imageButton);
        View.OnClickListener send_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send_layout();
            }
        };
        send_button.setOnClickListener(send_listener);

    }
}

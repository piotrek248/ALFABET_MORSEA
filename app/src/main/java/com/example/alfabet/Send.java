package com.example.alfabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Send extends AppCompatActivity {

    //metoda przypisujaca znaki ASCI do odpowiednika w alfabecie morse'a

    public String decode(char znak){
        if(znak=='A'){
            return "• —";
        }
        else if(znak=='B'){
            return "— • • •";
        }
        else if(znak=='C'){
            return "— • — •";
        }
        else if(znak=='D'){
            return "— • •";
        }
        else if(znak=='E'){
            return "•";
        }
        else if(znak=='F'){
            return "• • — •";
        }
        else if(znak=='G'){
            return "— — •";
        }
        else if(znak=='H'){
            return "• • • •";
        }
        else if(znak=='I'){
            return "• •";
        }
        else if(znak=='J'){
            return "• — — —";
        }
        else if(znak=='K'){
            return "— • —";
        }
        else if(znak=='L'){
            return "• — • •";
        }
        else if(znak=='M'){
            return "— —";
        }
        else if(znak=='N'){
            return "— •";
        }
        else if(znak=='O'){
            return "— — —";
        }
        else if(znak=='P'){
            return "• — — •";
        }
        else if(znak=='Q'){
            return "— — • —";
        }
        else if(znak=='R'){
            return "• — •";
        }
        else if(znak=='S'){
            return "• • •";
        }
        else if(znak=='T'){
            return "—";
        }
        else if(znak=='U'){
            return "• • —";
        }
        else if(znak=='V'){
            return "• • • —";
        }
        else if(znak=='W'){
            return "• — —";
        }
        else if(znak=='X'){
            return "— • • —";
        }
        else if(znak=='Y'){
            return "— • — —";
        }
        else if(znak=='Z'){
            return "— — • •";
        }
        return " ";
    }

    ImageButton button_ok, button_cancel, button_volume_on, button_volume_off;
    TextView wyswietlanie;
    EditText oknoEdycyjne;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        button_ok = (ImageButton) findViewById(R.id.imageButton3);
        button_cancel = (ImageButton) findViewById(R.id.imageButton4);
        button_volume_on = (ImageView) findViewById(R.id.imageButton5);
        button_volume_off = (ImageButton) findViewById(R.id.imageButton6);
        wyswietlanie = (TextView) findViewById(R.id.textView);
        oknoEdycyjne = (EditText) findViewById(R.id.editText);
        context = getApplicationContext();
        View.OnClickListener klik = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zdanie = oknoEdycyjne.getText().toString().toUpperCase();
                char [] ch = zdanie.toCharArray();
                StringBuilder mors = new StringBuilder();
                for (int i = 0; i < zdanie.length() ; ++i) {
                    mors.append("  "+decode(ch[i]));
                }
                wyswietlanie.setText(mors);
            }
        };
        button.setOnClickListener(klik);

        View.OnClickListener odtworz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer kropka = MediaPlayer.create(context, R.raw.kropka);
                MediaPlayer kreska = MediaPlayer.create(context, R.raw.kreska);

                String zdanie = oknoEdycyjne.getText().toString().toUpperCase();
                char [] ch = zdanie.toCharArray();
                StringBuilder mors = new StringBuilder();
                for (int i = 0; i < zdanie.length() ; ++i) {
                    mors.append(decode(ch[i]));
                }

                char [] znakiMors = mors.toString().toCharArray();
                for (int j = 0; j < mors.length(); ++j){
                    if (znakiMors[j]=='•')
                        kropka.start();
                    else if (znakiMors[j]=='—')
                        kreska.start();
                    try{
                        Thread.sleep(300);
                    } catch (InterruptedException e){}
                }
            }
        };
        button2.setOnClickListener(odtworz);
    }
}

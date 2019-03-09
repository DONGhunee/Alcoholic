package com.example.lee.sulgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class show2Activity extends AppCompatActivity {
    ArrayList<String> kk = new ArrayList<>();
    Button button1;
    Button button2;
    TextView textView;

    ImageButton imageButton5;
    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        parsing_data("mid.csv");
        final int[] ee = {0};
        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.middle);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ee[0] =1;
                if(ee[0] == 1){
                    button1.setText("RESTART");
                    int idx = new Random().nextInt(kk.size());
                    textView.setText(kk.get(idx));
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void parsing_data(String file_name){
        try{
            CSVReader reader = new CSVReader(new InputStreamReader(getResources().getAssets().open(file_name)));

            String [] nextLine;

            while((nextLine = reader.readNext()) != null){
                kk.add(nextLine[1]);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}

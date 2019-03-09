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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShowActivity extends AppCompatActivity {
    ArrayList<String> mm = new ArrayList<>();
    Button button1;
    Button button2;
    ImageButton imageButton5;
    TextView textView;

    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        parsing_data("row.csv");
        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.low);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);



        final int[] ee = {0};

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
                    int idx = new Random().nextInt(mm.size());
                    textView.setText(mm.get(idx));
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);

            }
        });



    }
    public void parsing_data(String file_name){
        try{
            CSVReader reader = new CSVReader(new InputStreamReader(getResources().getAssets().open(file_name)));

            String [] nextLine;

            while((nextLine = reader.readNext()) != null){
                mm.add(nextLine[1]);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();;
        }
    }


}

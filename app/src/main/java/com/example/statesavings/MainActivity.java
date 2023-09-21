package com.example.statesavings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout screenBackground;
    private TextView screenText;
    private MaterialButton blackBtn;
    private MaterialButton redBtn;
    private MaterialButton blueBtn;
    private MaterialButton greenBtn;
    private MaterialButton countBtn;
    private MaterialButton resetBtn;
    int count;
    int currenColor = Color.LTGRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenBackground = (RelativeLayout) findViewById(R.id.screen_background);
        screenText = (TextView) findViewById(R.id.screen_text);
        blackBtn = (MaterialButton) findViewById(R.id.black_button);
        redBtn = (MaterialButton) findViewById(R.id.red_button);
        blueBtn = (MaterialButton) findViewById(R.id.blue_button);
        greenBtn = (MaterialButton) findViewById(R.id.green_button);
        countBtn = (MaterialButton) findViewById(R.id.count_button);
        resetBtn = (MaterialButton) findViewById(R.id.reset_button);

        count = Integer.parseInt(screenText.getText().toString());

        SharedPreferences sharedPreferences = this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);
        screenBackground.setBackgroundColor(sharedPreferences.getInt("backgroundColor", Color.LTGRAY));
        count = sharedPreferences.getInt("countNumber", count);
        screenText.setText(String.valueOf(count));



        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;

                screenText.setText(String.valueOf(count));
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                screenText.setText(String.valueOf(count));
                currenColor = Color.LTGRAY;
                screenBackground.setBackgroundColor(currenColor);
            }
        });

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currenColor = Color.RED;
                screenBackground.setBackgroundColor(currenColor);
            }
        });
        blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currenColor = Color.BLACK;
                screenBackground.setBackgroundColor(currenColor);
            }
        });
        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currenColor = Color.BLUE;
                screenBackground.setBackgroundColor(currenColor);
            }
        });
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currenColor = Color.GREEN;
                screenBackground.setBackgroundColor(currenColor);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);

        sharedPreferences.edit().putInt("backgroundColor", currenColor).apply();
        sharedPreferences.edit().putInt("countNumber", count).apply();
        Log.d("Enter", String.valueOf(count));
    }
}
package com.example.working_with_threads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declaring Runnable object in the other function
                //and here we will add it
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        //let's get current time
                        Calendar c = Calendar.getInstance();
                        int h = c.get(Calendar.HOUR_OF_DAY);
                        int m = c.get(Calendar.MINUTE);
                        int secs = c.get(Calendar.SECOND);
                        //show in textview
                        String time = h + ":" + m + ":" + secs;
                        textView.setText(time);
                    }
                };

                //new thread object - new thread
                Thread thread = new Thread(runnable);
                //enabling thread
                thread.start();
            }
        });
    }
}

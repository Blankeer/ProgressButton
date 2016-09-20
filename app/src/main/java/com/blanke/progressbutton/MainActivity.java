package com.blanke.progressbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressButton progressbutton;
    private ProgressButton progressbutton2;
    private ProgressButton progressbutton3;
    private ProgressButton progressbutton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressbutton = (ProgressButton) findViewById(R.id.progressbutton);
        progressbutton2 = (ProgressButton) findViewById(R.id.progressbutton2);
        progressbutton3 = (ProgressButton) findViewById(R.id.progressbutton3);
        progressbutton4 = (ProgressButton) findViewById(R.id.progressbutton4);
        progressbutton.setOnClickListener(this);
        progressbutton2.setOnClickListener(this);
        progressbutton3.setOnClickListener(this);
        progressbutton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ProgressButton) {
            final ProgressButton pb = (ProgressButton) v;
            pb.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pb.setLoading(false);
                }
            }, 5000);
        }
    }
}

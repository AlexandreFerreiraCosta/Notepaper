package com.example.alexandre.notepaper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected boolean _active = true;
    protected int _splashTime = 5000;
    private ProgressBar progressBar;
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.getProgressDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

        TextView txt = (TextView) findViewById(R.id.textView);
        Typeface font = Typeface.createFromAsset(getAssets(), "bb.ttf");
        txt.setTypeface(font);

        TextView txt1 = (TextView) findViewById(R.id.textView2);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "bb.ttf");
        txt1.setTypeface(font1);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        progressStatus += 2;
                        progressBar.setProgress(progressStatus);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (InterruptedException e) {

                } finally {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
        splashTread.start();
    }
}

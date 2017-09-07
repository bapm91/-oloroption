package com.example.slava.coloroption;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textRed;
    private TextView textGreen;
    private TextView textBlue;
    private SeekBar seekGreen;
    private SeekBar seekBlue;
    private SeekBar seekRed;
    private int valueRed;
    private int valueGreen;
    private int valueBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        valueRed = 128;
        valueGreen = 128;
        valueBlue = 128;
        findViews();


        seekRed.setOnSeekBarChangeListener(seekBarListenerRed);
        seekGreen.setOnSeekBarChangeListener(seekBarListenerGreen);
        seekBlue.setOnSeekBarChangeListener(seekBarListenerBlue);

    }

    private void findViews() {
        imageView = (ImageView) findViewById(R.id.color_image);

        textRed = (TextView) findViewById(R.id.value_red);
        textGreen = (TextView) findViewById(R.id.value_green);
        textBlue = (TextView) findViewById(R.id.value_blue);

        seekRed = (SeekBar) findViewById(R.id.seekBarRed);
        seekGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        seekBlue = (SeekBar) findViewById(R.id.seekBarBlue);
    }

    private String getColorValue() {
        String result = "#"
                + Integer.toHexString(valueRed)
                + Integer.toHexString(valueGreen)
                + Integer.toHexString(valueBlue);
        return result.toUpperCase();
    }

    private final SeekBar.OnSeekBarChangeListener seekBarListenerRed =
            new SeekBar.OnSeekBarChangeListener() {
                // Обновление процента чаевых и вызов calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    valueRed = progress;
                    textRed.setText(String.valueOf(valueRed));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        imageView.setBackgroundColor(Color.argb(255, valueRed, valueGreen, valueBlue));
                    } else {
                        imageView.setBackgroundColor(Color.parseColor(getColorValue()));
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

    private final SeekBar.OnSeekBarChangeListener seekBarListenerGreen =
            new SeekBar.OnSeekBarChangeListener() {
                // Обновление процента чаевых и вызов calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    valueGreen = progress;
                    textGreen.setText(String.valueOf(valueGreen));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        imageView.setBackgroundColor(Color.argb(255, valueRed, valueGreen, valueBlue));
                    } else {
                        imageView.setBackgroundColor(Color.parseColor(getColorValue()));
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

    private final SeekBar.OnSeekBarChangeListener seekBarListenerBlue =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    valueBlue = progress;
                    textBlue.setText(String.valueOf(valueBlue));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        imageView.setBackgroundColor(Color.argb(255, valueRed, valueGreen, valueBlue));
                    } else {
                        imageView.setBackgroundColor(Color.parseColor(getColorValue()));
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };
}

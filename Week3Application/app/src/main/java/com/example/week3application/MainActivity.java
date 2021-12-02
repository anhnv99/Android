package com.example.week3application;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppColor;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppColor {

    Map<Integer, Character> mp = new HashMap<Integer, Character>();
    Map<Character, Integer> mpR = new HashMap<Character, Integer>();
    SeekBar skC, skR, skG, skB;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init()
    {
        skC = (SeekBar) findViewById(R.id.skC);
        skR = (SeekBar) findViewById(R.id.seekBar4);
        skG = (SeekBar) findViewById(R.id.seekBar5);
        skB = (SeekBar) findViewById(R.id.seekBar6);
        txt = (TextView) findViewById(R.id.txt);
        skC.setMax(16777215);
        skR.setMax(255);
        skG.setMax(255);
        skB.setMax(255);

        mp.put(0,'0'); mp.put(1,'1'); mp.put(2,'2'); mp.put(3,'3'); mp.put(4,'4');
        mp.put(5,'5'); mp.put(6,'6'); mp.put(7,'7'); mp.put(8,'8'); mp.put(9,'9');
        mp.put(10,'A'); mp.put(11,'B'); mp.put(12,'C'); mp.put(13,'D'); mp.put(14,'E');
        mp.put(15,'F');

        mpR.put('0', 0); mpR.put('1', 1); mpR.put('2', 2); mpR.put('3', 3); mpR.put('4', 4);
        mpR.put('5', 5); mpR.put('6', 6); mpR.put('7', 7); mpR.put('8', 8); mpR.put('9', 9);
        mpR.put('A', 10); mpR.put('B', 11); mpR.put('C', 12); mpR.put('D', 13); mpR.put('E', 14);
        mpR.put('F', 15);

        txt.setTextColor(Color.parseColor("#000000"));
        seekBar(); seekBarR(); seekBarG(); seekBarB();
    }

    void seekBarR()
    {
        skR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Integer color = skR.getProgress();
                int i = 2;
                StringBuilder colorString = new StringBuilder(txt.getText().toString());
                if (color == 0){
                    colorString.setCharAt(1, '0');
                    colorString.setCharAt(2, '0');
                }
                while ((i == 1 || i == 2) && color != 0)
                {
                    colorString.setCharAt(i, mp.get(color%16).charValue());
                    i--;
                    color /= 16;
                }
                txt.setText(colorString.toString());
                txt.setTextColor(Color.parseColor(colorString.toString()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    void seekBarG()
    {
        skG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Integer color = skG.getProgress();
                int i = 4;
                StringBuilder colorString = new StringBuilder(txt.getText().toString());
                if (color == 0){
                    colorString.setCharAt(3, '0');
                    colorString.setCharAt(4, '0');
                }
                while ((i == 3 || i == 4) && color != 0)
                {
                    colorString.setCharAt(i, mp.get(color%16).charValue());
                    i--;
                    color /= 16;
                }
                txt.setText(colorString.toString());
                txt.setTextColor(Color.parseColor(colorString.toString()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    void seekBarB()
    {
        skB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Integer color = skB.getProgress();
                int i = 6;
                StringBuilder colorString = new StringBuilder(txt.getText().toString());
                if (color == 0){
                    colorString.setCharAt(5, '0');
                    colorString.setCharAt(6, '0');
                }
                while ((i == 5 || i == 6) && color != 0)
                {
                    colorString.setCharAt(i, mp.get(color%16).charValue());
                    i--;
                    color /= 16;
                }
                txt.setText(colorString.toString());
                txt.setTextColor(Color.parseColor(colorString.toString()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    void seekBar()
    {
        skC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Integer color = skC.getProgress();
                int i = 6;
                StringBuilder colorString = new StringBuilder("#000000");
                while (i != 0 && color != 0)
                {
                    colorString.setCharAt(i, mp.get(color%16).charValue());
                    i--;
                    color /= 16;
                }
                txt.setText(colorString.toString());
                txt.setTextColor(Color.parseColor(colorString.toString()));
                String sR = txt.getText().toString();
                Integer red = 16*mpR.get(sR.charAt(1)) + mpR.get(sR.charAt(2));
                skR.setProgress(red);
                String sG = txt.getText().toString();
                Integer green = 16*mpR.get(sG.charAt(3)) + mpR.get(sG.charAt(4));
                skG.setProgress(green);
                String sB = txt.getText().toString();
                Integer blue = 16*mpR.get(sB.charAt(5)) + mpR.get(sB.charAt(6));
                skB.setProgress(blue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Thay đổi màu!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Dừng thay đổi màu!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.usman.myproject;

import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Created by Ance on 01/10/2017.
 */

public class AgeListener implements SeekBar.OnSeekBarChangeListener {


    private int progressChangedValue =0;
    private SeekBar seekBar;
    private TextView text;

    public AgeListener(SeekBar levelSeek, TextView t) {

        seekBar = levelSeek;
        text = t;
    }


    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        progressChangedValue = progress;
        Log.d(TAG,"Age = "+progressChangedValue);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        //Toast.makeText(this., "Seek bar progress is :" + progressChangedValue,
          //      Toast.LENGTH_SHORT).show();
              //  editAge.setText(progressChangedValue);
        //text.setText(progressChangedValue);
    }
}

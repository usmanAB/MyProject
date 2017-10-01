package com.example.usman.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText lastnameEditText;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastnameEditText = (EditText) findViewById(R.id.editable_name);

    }

    public void onAddButtonClick(View view) {
        String lastname = lastnameEditText.getText().toString();
        int d = Log.d(TAG, "onAddButtonClick() called with: view = [" + view + "]");
        Log.d(TAG,"Nom : "+lastname);
    }
}

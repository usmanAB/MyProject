package com.example.usman.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.usman.myproject.model.Client;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        int id = intent.getIntExtra(ListClientActivity.ID_CLIENT,0);
        Client client = Client.getClient().get(id);
        TextView tw = (TextView) findViewById(R.id.tw);

        tw.setText(client.getLastname());
    }
}

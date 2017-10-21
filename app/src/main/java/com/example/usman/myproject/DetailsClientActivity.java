package com.example.usman.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_client);
        int id = getIntent().getIntExtra(HomeActivity.ID_CLIENT,0);
        DetailsClientFragment fragment = (DetailsClientFragment) getSupportFragmentManager().findFragmentById(R.id.list_clients_fragment);
        fragment.updateClient(id);
    }
}

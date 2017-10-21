package com.example.usman.myproject;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity implements ListClientFragment.OnSelectedListener{

    public static final String ID_CLIENT = "ID_CLIENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    @Override
    public void onClientSelected(int id) {
        if(findViewById(R.id.details_client_fragment)==null){
            Intent intent = new Intent(this,DetailsClientActivity.class);
            intent.putExtra(ID_CLIENT,id);
            startActivity(intent);
        }else{
            DetailsClientFragment fragment = (DetailsClientFragment) getSupportFragmentManager().findFragmentById(R.id.list_clients_fragment);
            fragment.updateClient(id);
        }

    }
}

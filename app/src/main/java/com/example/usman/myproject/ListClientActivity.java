package com.example.usman.myproject;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.usman.myproject.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ListClientActivity extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Client> clients = Client.getClient();
        ArrayAdapter<Client> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,clients);
        setListAdapter(adapter);
    }



}

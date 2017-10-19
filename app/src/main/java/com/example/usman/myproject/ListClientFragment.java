package com.example.usman.myproject;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.usman.myproject.model.Client;
import com.example.usman.myproject.model.ClientAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListClientFragment extends ListFragment {

    public static final String ID_CLIENT = "idClient";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Client> clients = Client.getClient();
       // ArrayAdapter<Client> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,clients);
        ClientAdapter CustomAdapter = new ClientAdapter(getActivity(),clients);
        setListAdapter(CustomAdapter);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(),DetailsClientActivity.class);
        intent.putExtra(ID_CLIENT,position);
        startActivity(intent);
    }


}
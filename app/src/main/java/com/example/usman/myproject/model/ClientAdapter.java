package com.example.usman.myproject.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usman.myproject.R;
import com.example.usman.myproject.model.Client;

import java.util.List;

/**
 * Created by Ance on 05/10/2017.
 */

public class ClientAdapter extends ArrayAdapter<Client> {
    public ClientAdapter(Context context, List<Client> clients) {
        super(context,0,clients);
    }


    public View getView(int position, View view, ViewGroup parent) {
        if(view== null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.client_entry, parent, false);
        }
        Client c = getItem(position);

        TextView nom = (TextView) view.findViewById(R.id.nomClient);
        nom.setText(c.getLastname());

        TextView prenom = (TextView) view.findViewById(R.id.prenomClient);
        prenom.setText(c.getFirstname());


        return view;
    }

}

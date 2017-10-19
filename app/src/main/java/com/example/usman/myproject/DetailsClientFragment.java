package com.example.usman.myproject;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usman.myproject.model.Client;

import org.w3c.dom.Text;

import java.util.Date;

public class DetailsClientFragment extends Fragment {

    private TextView nom, prenom, birthdate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_details,container,true);
        nom = view.findViewById(R.id.nomClient);
        prenom = view.findViewById(R.id.nomClient);
        birthdate = view.findViewById(R.id.naissanceClient);

        return view;
    }


    public void updateClient(int id){
        Client client = Client.getClient().get(id);
        String name = client.getLastname();
        nom.setText(name);
        Date birthdate = client.getAge();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    }
}

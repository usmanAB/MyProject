package com.example.usman.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usman.myproject.model.Client;

import java.util.Date;

public class DetailsClientFragment extends Fragment {

    private TextView nom;
    private Client client;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_client,container,true);
        nom = view.findViewById(R.id.name_fragment);
        setHasOptionsMenu(true);
        //nom.setText("test");

        return view;
    }


    public void updateClient(int id){
        client = Client.getClient().get(id);
        String name = client.getLastname();
        nom.setText("toto");
/*
        Date birthdate = client.getAge();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
*/

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.details_client,menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_delete){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Confirmation");
            builder.setMessage("Voulez-vous vraiment supprimer ?");
            builder.setNegativeButton("Oui", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Client.getClient().remove(client);
                    getActivity().sendBroadcast(new Intent(AddActivity.ADD_CLIENT_ACTION));
                }
            });

            builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        builder.show();
        }


        return super.onOptionsItemSelected(item);
    }
}

package com.example.usman.myproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usman.myproject.model.Client;

import java.util.Date;

public class DetailsClientFragment extends Fragment {

    private TextView nom;
    private TextView prenom;
    private TextView naissanceClient;
    private Client client;
    private ImageView image;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_client,container,true);
        nom = view.findViewById(R.id.name_fragment);
        prenom = view.findViewById(R.id.prenom);
        naissanceClient = view.findViewById(R.id.naissanceClient);
        image = (ImageView) view.findViewById(R.id.customImage);

        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,666);
            }
        });

        setHasOptionsMenu(true);
        //nom.setText("test");




        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==666 && resultCode == Activity.RESULT_OK){
            Bitmap bitmap = data.getParcelableExtra("data");
            image.setImageBitmap(bitmap);
        }
    }

    public void updateClient(int id){
        client = Client.getClient().get(id);
        String name = client.getFirstname();
        nom.setText(name);
        prenom.setText(client.getLastname());
        naissanceClient.setText(String.valueOf(client.getAge()));
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
            builder.setPositiveButton("Oui",new DialogInterface.OnClickListener() {

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

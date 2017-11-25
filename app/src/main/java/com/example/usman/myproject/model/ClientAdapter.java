package com.example.usman.myproject.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usman.myproject.R;
import com.example.usman.myproject.SettingActivity;
import com.example.usman.myproject.model.Client;

import java.util.List;
import java.util.prefs.PreferenceChangeListener;

/**
 * Created by Ance on 05/10/2017.
 */

public class ClientAdapter extends ArrayAdapter<Client> implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String NAMING_MODE_PREFERENCE = "NAMING_MODE_PREFERENCE";
    private static final String PRENOM_NOM = "PRENOM_NOM";
    private SharedPreferences pref;
    private String namingMode;

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

        TextView prenom = (TextView) view.findViewById(R.id.prenomClient);

        pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        namingMode = pref.getString("preference_key","PRENOM_NOM");

        if("PRENOM_NOM".equals(namingMode)){
            nom.setText(c.getLastname()+" "+c.getFirstname());
        }
        else {
            nom.setText(c.getFirstname()+" "+c.getLastname());
        }

        return view;
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if(s.equals(NAMING_MODE_PREFERENCE)){
            namingMode = sharedPreferences.getString(NAMING_MODE_PREFERENCE,PRENOM_NOM);
            notifyDataSetChanged();
        }
    }
}

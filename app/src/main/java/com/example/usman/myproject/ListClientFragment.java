package com.example.usman.myproject;

import android.app.ListActivity;
import android.app.ListFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.usman.myproject.model.Client;
import com.example.usman.myproject.model.ClientAdapter;

import java.util.List;

public class ListClientFragment extends ListFragment {

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            customAdapter.notifyDataSetChanged();
        }
    };

    public static final String ID_CLIENT = "idClient";
    private IntentFilter filter;
    private ClientAdapter customAdapter;

    public interface OnSelectedListener{
        void onClientSelected(int id);
    }
    private OnSelectedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Client> clients = Client.getClient();
       // ArrayAdapter<Client> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,clients);
        customAdapter = new ClientAdapter(getActivity(),clients);
        setListAdapter(customAdapter);
        setHasOptionsMenu(true);
        filter = new IntentFilter(AddActivity.ADD_CLIENT_ACTION);
        getActivity().registerReceiver(receiver,filter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(getActivity() instanceof OnSelectedListener){
            listener = (OnSelectedListener) getActivity();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (listener!=null){
            listener.onClientSelected(position);

        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.list_clients,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_add_client){
            Intent intent = new Intent(getActivity(),AddActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId() == R.id.action_settings){
            Intent intent = new Intent(getActivity(),SettingActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.action_refresh){
            getActivity().startService(item);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}

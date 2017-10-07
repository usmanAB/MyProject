package com.example.usman.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    private EditText lastnameEditText, firstNameEditText, mailEditText;
    private static final String TAG = "AddActivity";
    private RadioGroup rg1;
    private RadioGroup rg2;
    private ListView mylist;
    private Switch s;
    private SeekBar levelSeek;
    private int age;
    private TextView labelAge;

    private int progressChangedValue = 0;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastnameEditText = (EditText) findViewById(R.id.editable_name);
        firstNameEditText = (EditText) findViewById(R.id.editable_prenom);
        mailEditText = (EditText) findViewById(R.id.editable_mail);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
       // mylist = (ListView) findViewById(R.id.listView);

        //final ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddActivity.this,android.R.layout.simple_list_item_1,prenoms);
        //mylist.setAdapter(adapter);
        labelAge = (TextView) findViewById(R.id.editAge);

        s = (Switch) findViewById(R.id.sampleSwitch);
        s.setTextOn("Oui");
        s.setTextOff("Non");

        levelSeek = (SeekBar) findViewById(R.id.levelSeek);

        //editAge.setText(levelSeek.getProgress());

        labelAge.setText(String.valueOf(levelSeek.getProgress()));

        levelSeek.setOnSeekBarChangeListener(new AgeListener(levelSeek, labelAge));
    }


    public void onAddButtonClick(View view) {
        String lastname = lastnameEditText.getText().toString();
        String firstname = firstNameEditText.getText().toString();
        String mail = mailEditText.getText().toString();


        int d = Log.d(TAG, "onAddButtonClick() called with: view = [" + view + "]");
        Log.d(TAG,"Nom : "+lastname);
        Log.d(TAG,"Prénom : "+firstname);
        Log.d(TAG,"Mail : "+mail);

        if (rg1.getCheckedRadioButtonId() == R.id.radio_h)
            Log.d(TAG,"Sexe : Homme");
        else
            Log.d(TAG,"Sexe : Femme");

        Log.d(TAG,"Age = "+levelSeek.getProgress());
        Log.d(TAG,"Actif  = "+s.getId());

        Intent appel = new Intent(AddActivity.this, SecondActivity.class);
        startActivity(appel);



    }
    public void onRadioButtonClick(View view) {
        int radio = Log.d(TAG, "onRadioButtonClick() called with: view = [" + view + "]");
        boolean checked = ((RadioButton) view).isChecked();
    }

}

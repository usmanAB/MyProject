package com.example.usman.myproject;

import android.app.DatePickerDialog;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.usman.myproject.model.Client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    private EditText lastnameEditText, firstNameEditText, mailEditText;
    private static final String TAG = "AddActivity";
    private RadioGroup rg1;
    private RadioGroup rg2;
    private ListView mylist;
    private Switch s;
    private SeekBar levelSeek;
    private Date age;
    private TextView labelAge;
    private Button addDateButton;
    private Calendar calendar;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
        setContentView(R.layout.activity_add);
        lastnameEditText = (EditText) findViewById(R.id.editable_name);
        firstNameEditText = (EditText) findViewById(R.id.editable_prenom);
        mailEditText = (EditText) findViewById(R.id.editable_mail);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
       // mylist = (ListView) findViewById(R.id.listView);
        addDateButton = (Button) findViewById(R.id.addDateButton);
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

        calendar = Calendar.getInstance();

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

        Intent appel = new Intent(AddActivity.this, HomeActivity.class);
        startActivity(appel);


        Client c = new Client();
        c.setLastname(lastname);
        c.setAge(calendar.getTime());
        Client.setClient(c);

    }
    public void onRadioButtonClick(View view) {
        int radio = Log.d(TAG, "onRadioButtonClick() called with: view = [" + view + "]");
        boolean checked = ((RadioButton) view).isChecked();
    }

    public void onAddDateButtonClick(View view) {
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar = Calendar.getInstance();
                calendar.set(calendar.YEAR,year);
                calendar.set(calendar.MONTH,month);
                calendar.set(calendar.DAY_OF_MONTH,day);
                String date = dateFormat.format(calendar.getTime());
                addDateButton.setText(date);
            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_WEEK));
        dialog.show();


    }
}

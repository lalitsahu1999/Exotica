package com.example.exotica;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.santalu.maskedittext.MaskEditText;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class spell extends AppCompatActivity {

    String branch ;
    String fname ;
    String fregid ;
    String fmobile ;
    String femail;
    String fevents ;
    String year ;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        final Button mShowDialog = (Button) findViewById(R.id.button);



        mShowDialog.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(spell.this);
                View mView= getLayoutInflater().inflate(R.layout.register_education,null);
                mBuilder.setTitle("Registration Form:");
                mBuilder.setIcon(R.drawable.form);


                final EditText mFname = (EditText) mView.findViewById(R.id.fname);
                final EditText mRegno= (EditText) mView.findViewById(R.id.regno);
                final Spinner spinner1 = (Spinner) mView.findViewById(R.id.spinner1);
                final Spinner spinner2 = (Spinner) mView.findViewById(R.id.spinner2);
                final MaskEditText mphone = (MaskEditText) mView.findViewById(R.id.phone);
                final EditText memail = (EditText) mView.findViewById(R.id.email);



                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(spell.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.branch));
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);

                spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        switch (position){
                            case 1:
                                branch= "Mech";
                                break;

                            case 2:
                                branch= "Cse";
                                break;
                            case 3:
                                branch= "Civil";
                                break;
                            case 4:
                                branch= "Ece";
                                break;
                            case 5:
                                branch= "Eee";
                                break;

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(spell.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.year));
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter2);


                spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        switch (position){
                            case 1:
                                year= "1st";
                                break;

                            case 2:
                                year= "2nd";
                                break;
                            case 3:
                                year= "3rd";
                                break;
                            case 4:
                                year= "4rth";
                                break;

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });





                mBuilder.setPositiveButton("Register", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                    }
                });
                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();


                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View v) {




                        String Events ="";
                        String validemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                        String validphone = "\\+91\\s\\([6-9]\\d{2}\\)-\\d{3}-\\d{4}";
                        String validname = "^[a-zA-Z\\s]*$";
                        String validregno = "[1]{1}[5-8]{1}[0-9]{8}";
                        String email= memail.getText().toString();
                        String name = mFname.getText().toString();
                        String regno = mRegno.getText().toString();
                        String phone = mphone.getText().toString();

                        for (String Selection : selection){
                            Events = Selection + "," + " " + Events ;
                        }

                        fname= name;
                        femail=email;
                        fregid= regno;
                        fmobile= phone;
                        fevents = Events;


                        databaseReference = FirebaseDatabase.getInstance().getReference("Education");


                        if(!mFname.getText().toString().isEmpty() && !mRegno.getText().toString().isEmpty() && !spinner1.getSelectedItem().toString().equalsIgnoreCase("Branch") && !spinner2.getSelectedItem().toString().equalsIgnoreCase("Year") && !mphone.getText().toString().isEmpty() && !mRegno.getText().toString().isEmpty() && !mFname.getText().toString().isEmpty() && !memail.getText().toString().isEmpty() && !mFname.getText().toString().isEmpty() && !Events.isEmpty() ){

                            Matcher namematcher = Pattern.compile(validname,Pattern.CASE_INSENSITIVE).matcher(name);
                            if (namematcher.matches()){

                                Matcher regnomatcher = Pattern.compile(validregno).matcher(regno);

                                if (regnomatcher.matches()){
                                    Matcher phonematcher = Pattern.compile(validphone).matcher(phone);

                                    if (phonematcher.matches()){

                                        Matcher emailmatcher = Pattern.compile(validemail).matcher(email);

                                        if (emailmatcher.matches()){

                                            String id = databaseReference.push().getKey();
                                            Students students = new Students(id,fname,fregid,branch,year,fmobile,femail,fevents);
                                            databaseReference.child(id).setValue(students);

                                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();

                                            dialog.dismiss();
                                        }
                                        else{
                                            Toast.makeText(getApplicationContext(), "Enter valid email", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),"Enter valid Phone no.", Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Enter valid Registration no.", Toast.LENGTH_SHORT).show();
                                }



                            }else{
                                Toast.makeText(getApplicationContext(), "Enter valid Name", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(spell.this, "Please fill empty fields", Toast.LENGTH_SHORT).show();

                        }

                    }



                });
            }



        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }






    ArrayList<String> selection = new ArrayList<String>();
    public void selectIem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){

            case R.id.checkBox1:
                if (checked) {

                    selection.add("Essay-writting");
                }
                else {
                    selection.remove("Essay-writting");
                }
                break;

            case R.id.checkBox2:
                if (checked) {

                    selection.add("Just-a-minute");
                }
                else {
                    selection.remove("Just-a-minute");
                }
                break;

            case R.id.checkBox3:
                if (checked) {

                    selection.add("Spell-Bee");
                }
                else {
                    selection.remove("Spell-Bee");
                }
                break;

            case R.id.checkBox4:
                if (checked) {

                    selection.add("Turn-Coat");
                }
                else {
                    selection.remove("Turn-Coat");
                }
                break;

            case R.id.checkBox5:
                if (checked) {

                    selection.add("Mind-Portal");
                }
                else {
                    selection.remove("Mind-Portal");
                }
                break;


        }


    }
}

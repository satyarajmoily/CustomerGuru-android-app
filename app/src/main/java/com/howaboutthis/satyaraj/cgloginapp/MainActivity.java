package com.howaboutthis.satyaraj.cgloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private String selectedCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name = findViewById(R.id.name);
        final EditText phone = findViewById(R.id.phone);
        final EditText email = findViewById(R.id.email);
        final Spinner city = findViewById(R.id.city);
        Button submit = findViewById(R.id.submit);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name.setBackgroundResource(R.drawable.edit_text_background);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phone.setBackgroundResource(R.drawable.edit_text_background);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                email.setBackgroundResource(R.drawable.edit_text_background);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)
                    selectedCity = null;
                else {
                    selectedCity = city.getItemAtPosition(position).toString();
                    city.setBackgroundResource(R.drawable.edit_text_background);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredName = name.getText().toString();
                String enteredPhone = phone.getText().toString();
                String enteredEmail = email.getText().toString();
                int count = 0;

                if (enteredName.matches("") || !checkName(enteredName)) {
                    name.setBackgroundResource(R.drawable.edit_text_alert);
                    count++;
                }
                if (enteredPhone.matches("") || !checkPhone(enteredPhone)) {
                    phone.setBackgroundResource(R.drawable.edit_text_alert);
                    count++;
                }
                if (enteredEmail.matches("") || !isEmailValid(enteredEmail)) {
                    email.setBackgroundResource(R.drawable.edit_text_alert);
                    count++;
                }
                if (selectedCity == null) {
                    city.setBackgroundResource(R.drawable.edit_text_alert);
                    count++;
                }

                if(count == 0){
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username",enteredName);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(),"Please check the fields again",Toast.LENGTH_SHORT).show();
            }
        });

    }
    boolean checkName (String string) {
        return Pattern.matches("[a-zA-Z]+.*[a-zA-Z]",string);
    }

    boolean checkPhone (String string) {
        return Pattern.matches("[0-9]+",string);
    }

    public  boolean isEmailValid(String email) {
        String expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

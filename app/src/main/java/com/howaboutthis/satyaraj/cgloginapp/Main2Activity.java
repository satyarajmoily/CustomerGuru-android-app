package com.howaboutthis.satyaraj.cgloginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        TextView user = findViewById(R.id.user_name);

        if (bundle != null) {
            String username = bundle.getString("username");
            user.setText(username);
        }
    }
}

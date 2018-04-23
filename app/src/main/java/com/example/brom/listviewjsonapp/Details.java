package com.example.brom.listviewjsonapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String mountainName = intent.getStringExtra("Name");
        String mountainLocation = intent.getStringExtra("Location");

        TextView textView = (TextView) findViewById(R.id.info_name);
        TextView textView1 = (TextView) findViewById(R.id.info_location);
        textView.setText(mountainName);
        textView1.setText(mountainLocation);
    }

}

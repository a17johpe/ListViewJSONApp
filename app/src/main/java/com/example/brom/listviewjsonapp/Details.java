package com.example.brom.listviewjsonapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class Details extends AppCompatActivity {
    protected ImageView bmImage;

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
        String mountainHeight = intent.getStringExtra("Height");
        String imageUrl = intent.getStringExtra("Image");

        TextView textView1 = (TextView) findViewById(R.id.textview1);
        TextView textView2 = (TextView) findViewById(R.id.textview2);
        TextView textView3 = (TextView) findViewById(R.id.textview3);
        textView1.setText(mountainName);
        textView2.setText(mountainLocation);
        textView3.setText(mountainHeight);

        new DownloadImageTask((ImageView) findViewById(R.id.mountain_image))
                .execute(imageUrl);
        Log.d("olle1", imageUrl);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {


        public DownloadImageTask(ImageView bmImageIn) {
            bmImage = bmImageIn;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

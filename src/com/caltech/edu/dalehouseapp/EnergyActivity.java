package com.caltech.edu.dalehouseapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EnergyActivity extends Activity {
	
	 
    public void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.energy_layout);
        
        TextView textview = new TextView(this);
        String responseString = "asd";
		RequestTask r = new RequestTask(this);
		r.execute("http://www.google.com");
		//responseString = r.getstr();
        textview.setText(responseString);
        setContentView(textview);
    }
}

package com.caltech.edu.dalehouseapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LightsActivity extends Activity {
    
    private Button b1;
    private Button b2;
    private Button b3;
    private Boolean b1_b = false;
    private Boolean b2_b = false;
    private Boolean b3_b = false;
    
    @Override
    public void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lights_layout);
        
      b1 = (Button) findViewById(R.id.button1);
      b2 = (Button) findViewById(R.id.button2);
      b3 = (Button) findViewById(R.id.button3);
      b1.setBackgroundResource(R.drawable.lights_off);
      b2.setBackgroundResource(R.drawable.lights_off);
      b3.setBackgroundResource(R.drawable.lights_off);
      b1.setOnClickListener(new OnClickListener() {
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            if (b1_b == false) {
                b1.setBackgroundResource(R.drawable.lights_on);
                Toast.makeText(getApplicationContext(), "light1 is on", Toast.LENGTH_SHORT).show();
                b1_b = true;
            } else {
                b1.setBackgroundResource(R.drawable.lights_off);
                Toast.makeText(getApplicationContext(), "light1 is off", Toast.LENGTH_SHORT).show();
                b1_b = false;
            }
        }
      });
      
      
      b2.setOnClickListener(new OnClickListener() {
          public void onClick(View arg0) {
              // TODO Auto-generated method stub
              if (b2_b == false) {
                  b2.setBackgroundResource(R.drawable.lights_on);
                  Toast.makeText(getApplicationContext(), "light2 is on", Toast.LENGTH_SHORT).show();
                  b2_b = true;
              } else {
                  b2.setBackgroundResource(R.drawable.lights_off);
                  Toast.makeText(getApplicationContext(), "light2 is off", Toast.LENGTH_SHORT).show();
                  b2_b = false;
              }
          }
      });
      
      b3.setOnClickListener(new OnClickListener() {
          public void onClick(View arg0) {
              // TODO Auto-generated method stub
              if (b3_b == false) {
                  b3.setBackgroundResource(R.drawable.lights_on);
                  Toast.makeText(getApplicationContext(), "light3 is on", Toast.LENGTH_SHORT).show();
                  b3_b = true;
              } else {
                  b3.setBackgroundResource(R.drawable.lights_off);
                  Toast.makeText(getApplicationContext(), "light3 is off", Toast.LENGTH_SHORT).show();
                  b3_b = false;
              }
          }
      });
    }
}

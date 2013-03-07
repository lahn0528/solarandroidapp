package com.caltech.edu.dalehouseapp;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_main);
 
		Resources resources = getResources(); 
		TabHost tabHost = getTabHost(); 
		
		// Apple tab
		Intent intentItem = new Intent().setClass(this, ItemActivity.class);
		TabSpec tabSpecItem = tabHost
		  .newTabSpec("Items")
		  .setIndicator("Items")
		  .setContent(intentItem); 
		
		// Android tab
		Intent intentEnergy = new Intent().setClass(this, EnergyActivity.class);
		TabSpec tabSpecEnergy = tabHost
		  .newTabSpec("Energy")
		  .setIndicator("Energy")
		  .setContent(intentEnergy);
 
		tabHost.addTab(tabSpecItem);
		tabHost.addTab(tabSpecEnergy);
		
		tabHost.setCurrentTab(0);
	}
}

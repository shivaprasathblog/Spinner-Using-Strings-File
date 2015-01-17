package com.example.spinnerusingstrings;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity 
{
//String of data is declared in values folder in strings file	
String[] cars;
//Defining Spinner
Spinner sp;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Referring the Spinner
		sp=(Spinner)findViewById(R.id.spinner1);
		//Binding the value from strings file 
		cars=getResources().getStringArray(R.array.cars);
		//Adapter to used to adapt the value from datasource(here data source is from array), so we are using ArrayAdapter the array is of type string 		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, cars);
		//Setting the adapter to spinner
		sp.setAdapter(adapter);
		//Creating listener for spinner , we are going to select a item from spinner so we are using itemselect listener
		sp.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) 

			{
				// TODO Auto-generated method stub
				//Getting the value of item 
				String itemselected = arg0.getItemAtPosition(arg2).toString();
				//Showing the selected item from in Toast
				Toast.makeText(MainActivity.this,"Your favourite is "+itemselected , Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) 
			{
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

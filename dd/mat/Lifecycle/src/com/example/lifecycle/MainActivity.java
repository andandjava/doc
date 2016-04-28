package com.example.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	final String TAG = "States";
	Button b1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d(TAG, "MainActivity: onCreate()");
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
	}
	 @Override
	  protected void onRestart() {
	    super.onRestart();
	    Log.d(TAG, "MainActivity: onRestart()");
	  }

	  @Override
	  protected void onStart() {
	    super.onStart();
	    Log.d(TAG, "MainActivity: onStart()");
	  }

	  @Override
	  protected void onResume() {
	    super.onResume();
	    Log.d(TAG, "MainActivity: onResume()");
	  }

	  @Override
	  protected void onPause() {
	    super.onPause();
	    Log.d(TAG, "MainActivity: onPause()");
	  }

	  @Override
	  protected void onStop() {
	    super.onStop();
	    Log.d(TAG, "MainActivity: onStop()");
	  }

	  @Override
	  protected void onDestroy() {
	    super.onDestroy();
	    Log.d(TAG, "MainActivity: onDestroy()");
	  }
	@Override
	public void onClick(View v) {
		
		Intent i=new Intent(this,ActivityTwo.class);
		startActivity(i);
	}
}

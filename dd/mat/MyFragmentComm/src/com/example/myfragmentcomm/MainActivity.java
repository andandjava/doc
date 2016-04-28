package com.example.myfragmentcomm;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements Communicator{

	FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	@Override
	public void respond(String data)
	{
		FragmentManager manager=getFragmentManager();
		FragmentTwo f2=(FragmentTwo) manager.findFragmentById(R.id.fragment2);
		
		//FragmentTwo f2=(FragmentTwo) manager.findFragmentById(R.id.fragment2);
		f2.changeText(data);
		
	}
}

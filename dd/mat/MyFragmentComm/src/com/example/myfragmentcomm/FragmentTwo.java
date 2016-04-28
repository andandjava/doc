package com.example.myfragmentcomm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment{
	
	TextView text;
	String data;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		View view= inflater.inflate(R.layout.fragment_two, container, false);
		if(savedInstanceState==null)
		{
			
		}
		else
		{
			data=savedInstanceState.getString("text");
			TextView myText=(TextView)view.findViewById(R.id.textView1);
			myText.setText(data);
		}
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	
		super.onActivityCreated(savedInstanceState);
		text=(TextView)getActivity().findViewById(R.id.textView1);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		
	outState.putString("text", data);
	
	}
	public void changeText(String data)
	{
		this.data=data;
		text.setText(data);
	}

}

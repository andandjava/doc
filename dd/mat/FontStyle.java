package com.example.taskimage2;

import android.content.Context;
import android.graphics.Typeface;

public class FontStyle {

	public static Typeface arialn;

	public static Typeface getArialn(Context context) {
		return Typeface.createFromAsset(context.getAssets(), "Arialn.TTF");
	}

	public static void setArialn(Typeface arialn) {
		FontStyle.arialn = arialn;
	}

}
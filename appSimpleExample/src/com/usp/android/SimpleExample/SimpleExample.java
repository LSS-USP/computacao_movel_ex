package com.usp.android.SimpleExample;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.app.Activity;
import android.os.Bundle;

public class SimpleExample extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void storeDataAndUpdate(View pView)
    {
      setContentView(R.layout.list_name);
    }
}

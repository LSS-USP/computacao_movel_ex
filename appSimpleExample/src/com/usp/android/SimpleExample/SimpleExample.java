package com.usp.android.SimpleExample;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class SimpleExample extends Activity
{
    ArrayList<String> names = new ArrayList<String>();
    ListView listName;
    ArrayAdapter adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void storeDataAndUpdate(View pView)
    {
      EditText enteredName = (EditText) findViewById(R.id.name);
      String newName = enteredName.getText().toString();

      setContentView(R.layout.list_name);
      this.listName = (ListView) findViewById(R.id.name_list);

      names.add(newName);
      this.setAdapterToList();
    }

    public void back(View pView)
    {
      setContentView(R.layout.main);
    }

    private void setAdapterToList()
    {
      this.adapter = new ArrayAdapter<String>(this, R.layout.row,
                                              R.id.nameText, this.names);
      this.listName.setAdapter(this.adapter);
    }
}

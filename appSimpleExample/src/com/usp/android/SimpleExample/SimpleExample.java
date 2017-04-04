package com.usp.android.SimpleExample;

import android.view.View;

import android.content.res.Resources;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.app.Activity;
import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

import android.util.Log;

import java.util.ArrayList;


public class SimpleExample extends Activity
{
    private ArrayList<String> names = new ArrayList<String>();
    private ListView listName;
    private ArrayAdapter adapter;
    private final static String LOG = "appExample";
    private SQLiteDatabase database;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.database = (new DatabaseHelper(this)).getWritableDatabase();
        Log.d(LOG, "Create activity");
    }

    public void storeDataAndUpdate(View pView)
    {
      EditText enteredName = (EditText) findViewById(R.id.name);
      String newName = enteredName.getText().toString();

      setContentView(R.layout.list_name);
      this.listName = (ListView) findViewById(R.id.name_list);

      this.insertNameToDb(newName);
      this.setAdapterToList();
    }

    public void back(View pView)
    {
      setContentView(R.layout.main);
    }

    private void setAdapterToList()
    {
      this.getAllNamesFromDb();
      this.adapter = new ArrayAdapter<String>(this, R.layout.row,
                                              R.id.nameText, this.names);
      this.listName.setAdapter(this.adapter);
    }

    public void getAllNamesFromDb()
    {
      Cursor result = this.database.rawQuery("SELECT name FROM names", null);
      result.moveToFirst();
      while (!result.isAfterLast())
      {
        String name = result.getString(0);
        this.names.add(name);
        result.moveToNext();
      }
    }

    public void insertNameToDb(String pName)
    {
      ContentValues value = new ContentValues();
      value.put("name", pName);

      this.database.insert("names", "name", value);
    }
}

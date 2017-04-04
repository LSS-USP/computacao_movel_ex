package com.usp.android.SimpleExample;

import android.content.res.Resources;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.io.InputStream;

import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper
{
  private String rawSql = "";
  private final static String DATABASE_NAME = "DATABASE_NAMEs";
  private final static String NAME_COL = "name";
  private final static String TABLE_NAME = "names";

  private final static String LOG_DB = "db";
  private Context context;

  public DatabaseHelper(Context pContext)
  {
    super (pContext, DATABASE_NAME, null, 1);
    this.context = pContext;
    Log.d(LOG_DB, "Create an instance of SQLiteHelper");
  }

  @Override
  public void onCreate(SQLiteDatabase pDb)
  {
    Log.d(LOG_DB, "OnCreate database.");
    this.createDatabase(pDb);
  }

  @Override
  public void onUpgrade(SQLiteDatabase pDb, int pOldVersion, int pNewVerion)
  {
    pDb.execSQL("DROP TABLE IF EXISTS names");
    onCreate(pDb);
  }

  private void createDatabase(SQLiteDatabase pDb)
  {
    this.readDatabaseSQL();
    pDb.execSQL(this.rawSql);
  }

  private void readDatabaseSQL()
  {
    try
    {
      Resources resource = this.context.getResources();
      InputStream dbDDL = resource.openRawResource(R.raw.simple_db);

      byte[] byteStream = new byte[dbDDL.available()];
      dbDDL.read(byteStream);
      this.rawSql = new String(byteStream);
      Log.d(LOG_DB, this.rawSql);
    }
    catch(Exception e)
    {
      Log.e(LOG_DB, "Something wrong when try to read SQL code: ", e);
    }
  }
}

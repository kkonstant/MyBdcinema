package com.example.konstant.mybdcinema;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SQLiteDatabase db = openOrCreateDatabase("CINEMA", MODE_PRIVATE, null);
        String a = db.getPath();

        Log.d("PATH", a);
        db.execSQL("CREATE TABLE IF NOT EXISTS MyTable (Number Int, Name VARCHAR, Data Int, Directed VARCHAR, Company VARCHAR, Genre VARCHAR);");
        db.execSQL("INSERT INTO MyTable VALUES(1,'Terminator',1984,'J.Cameron','Hemdale Film','Fantasy');");
        Cursor c = db.rawQuery("SELECT* FROM MyTable", null);
        c.moveToFirst();
        Log.d("ME", c.getString(c.getColumnIndex("Name")));
        db.close();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

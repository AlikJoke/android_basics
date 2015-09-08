package com.example.root.androidmodule23;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btnAdd, btnClear, btnRead;
    EditText editText1, editText2;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        dbHelper = new DBHelper(this);
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

    @Override
    public void onClick(View v) {

        String name = editText1.getText().toString();
        String email = editText2.getText().toString();

        ContentValues cv = new ContentValues();

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (v.getId()) {

            case R.id.btnAdd:
                System.out.println("Insert in table:" + name + " " + email);
                cv.put("name", name);
                cv.put("email", email);

                long rowID = db.insert("mytable", null, cv);
                System.out.println("ID " + rowID);
                break;
            case R.id.btnClear:
                int count = db.delete("mytable", null, null);
                System.out.println(count);
                break;
            case R.id.btnRead:
                Cursor cursor = db.query("mytable", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {

                    int idColumnRows = cursor.getColumnIndex("id");
                    int nameColumnRows = cursor.getColumnIndex("name");
                    int emailColumnRows = cursor.getColumnIndex("email");

                    do {

                        System.out.println("ID" + cursor.getInt(idColumnRows));
                        System.out.println("Name" + cursor.getString(nameColumnRows));
                        System.out.println("Email" + cursor.getString(emailColumnRows));
                    } while (cursor.moveToNext());
                }
                else {

                    System.out.println("0 rows");
                }
                cursor.close();
                break;
        }
        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {

            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("create table mytable ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "email text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

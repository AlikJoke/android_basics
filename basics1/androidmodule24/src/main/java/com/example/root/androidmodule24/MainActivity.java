package com.example.root.androidmodule24;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btnAdd, btnDelete, btnUpdate, btnClear, btnRead;
    EditText editTextName, editTextEmail, editTextID;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);

        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextID = (EditText) findViewById(R.id.editTextID);
        editTextName = (EditText) findViewById(R.id.editTextName);

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

        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String id = editTextID.getText().toString();
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();

        switch (v.getId()) {

            case R.id.btnAdd:
                System.out.println("Insert in table:" + name + " " + email);
                cv.put("name", name);
                cv.put("email", email);

                long rowID = db.insert("mytable1", null, cv);
                System.out.println("ID " + rowID);
                break;
            case R.id.btnClear:
                int count = db.delete("mytable1", null, null);
                System.out.print("Delete rows:" + count);
                break;
            case R.id.btnRead:
                Cursor cursor = db.query("mytable1", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {

                    int idColumnRows = cursor.getColumnIndex("id");
                    int nameColumnRows = cursor.getColumnIndex("name");
                    int emailColumnRows = cursor.getColumnIndex("email");

                    do {

                        System.out.println("ID" + cursor.getInt(idColumnRows));
                        System.out.println("Name" + cursor.getString(nameColumnRows));
                        System.out.println("Email" + cursor.getString(emailColumnRows));
                    } while (cursor.moveToNext());
                } else {

                    System.out.println("0 rows");
                }
                cursor.close();
                break;
            case R.id.btnUpdate:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                cv.put("name", name);
                cv.put("email", email);

                int updCount = db.update("mytable1", cv, "id = ?", new String[]{ id });
                System.out.println("Update: " + updCount);
                break;
            case R.id.btnDelete:
                if (id.equalsIgnoreCase("")) {
                    break;
                }
                int delCount = db.delete("mytable1", "id = " + id, null);
                System.out.println("Delete: " + delCount);
                break;
        }
        dbHelper.close();
        
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {

            super(context, "MyDB1", null ,1);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("create table mytable1 ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "email text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        }
    }
}

package com.example.androidmodule8;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{

    TextView myTV;
    Button myBtn1, myBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myTV = (TextView) findViewById(R.id.myTV);
        myBtn1 = (Button) findViewById(R.id.myBtn1);
        myBtn2 = (Button) findViewById(R.id.myBtn2);

        myBtn1.setOnClickListener(this);
        myBtn2.setOnClickListener(this);
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

        switch (v.getId()) {

            case R.id.myBtn1:
                myTV.setText("OK");
                Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
                break;

            case R.id.myBtn2:
                myTV.setText("Cancel");
                Toast.makeText(this, "Cancel", Toast.LENGTH_LONG).show();
                break;
        }
    }
}

package com.example.androidmodule6;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView myTV;
    Button myBtn1, myBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myTV = (TextView) findViewById(R.id.myTV);
        myBtn1 = (Button) findViewById(R.id.myBtn1);
        myBtn2 = (Button) findViewById(R.id.myBtn2);

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myTV.setText("Нажата кнопка OK");
            }
        };
        myBtn1.setOnClickListener(oclBtnOk);

        View.OnClickListener oclBtnOk2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myTV.setText("Нажата кнопка Canlcel");
            }
        };
        myBtn2.setOnClickListener(oclBtnOk2);
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

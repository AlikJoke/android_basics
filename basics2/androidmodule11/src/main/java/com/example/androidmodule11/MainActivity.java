package com.example.androidmodule11;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    final int COLOR_RED = 1;
    final int COLOR_GREEN = 2;
    final int COLOR_BLUE = 3;

    final int SIZE_22 = 4;
    final int SIZE_26 = 5;
    final int SIZE_30 = 6;

    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        textView1.setOnCreateContextMenuListener(this);
        textView2.setOnCreateContextMenuListener(this);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {

            case R.id.textView1:
                menu.add(0, COLOR_RED, 0, "RED");
                menu.add(0, COLOR_BLUE, 0, "BLUE");
                menu.add(0, COLOR_GREEN, 0, "GREEN");
                break;
            case R.id.textView2:
                menu.add(0, SIZE_22, 0, "22");
                menu.add(0, SIZE_26, 0, "26");
                menu.add(0, SIZE_30, 0, "30");
                break;
        }
    }

    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case COLOR_RED:
                textView1.setText("Text is red");
                textView1.setTextColor(Color.RED);
                break;
            case COLOR_BLUE:
                textView1.setText("Text is blue");
                textView1.setTextColor(Color.BLUE);
                break;
            case COLOR_GREEN:
                textView1.setText("Text is green");
                textView1.setTextColor(Color.GREEN);
                break;
            case SIZE_22:
                textView2.setText("Text size is 22");
                textView2.setTextSize(22);
                break;
            case SIZE_26:
                textView2.setText("Text size is 26");
                textView2.setTextSize(26);
                break;
            case SIZE_30:
                textView2.setText("Text size is 30");
                textView2.setTextSize(30);
                break;
        }

        return super.onContextItemSelected(item);
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

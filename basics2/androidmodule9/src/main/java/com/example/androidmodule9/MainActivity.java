package com.example.androidmodule9;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView textView;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView) findViewById(R.id.textView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(0, 1, 0, "azaz");
        menu.add(0, 5, 2, "hoho");
        menu.add(0, 2, 4, "VA!");
        menu.add(1, 3, 1, "raduga");
        menu.add(1, 4, 3, "mishka");
        menu.add(1, 6, 5, "suchka");

        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.setGroupVisible(1, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        StringBuilder sb = new StringBuilder();

        sb.append("Item menu");
        textView.setText(sb.toString());
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

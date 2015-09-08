package com.example.androidmodule15;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class SecondActivity extends Activity {

    private final String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
    public void onStart() {

        super.onStart();
        Log.d(TAG, "start OnStart()");
    }

    @Override
    public void onStop() {

        super.onStop();
        Log.d(TAG, "start OnStop()");
    }

    @Override
    public void onPause() {

        super.onPause();
        Log.d(TAG, "start OnPause()");
    }

    @Override
    public void onResume() {

        super.onResume();
        Log.d(TAG, "start OnResume()");
    }

    @Override
    public void onRestart() {

        super.onRestart();
        Log.d(TAG, "start OnRestart()");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        Log.d(TAG, "start OnDestroy()");
    }
}

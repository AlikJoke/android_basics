package com.example.androidmodule15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btn;
    private final String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}

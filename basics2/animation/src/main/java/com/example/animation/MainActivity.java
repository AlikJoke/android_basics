package com.example.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends Activity {

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANS_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setOnCreateContextMenuListener(this);
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

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {

            case R.id.textView:
                menu.add(0, MENU_ALPHA_ID, 0, "alpha");
                menu.add(0, MENU_SCALE_ID, 0, "scale");
                menu.add(0, MENU_TRANS_ID, 0, "trans");
                menu.add(0, MENU_ROTATE_ID, 0, "rotate");
                menu.add(0, MENU_COMBO_ID, 0, "combo");
                break;
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public boolean onContextItemSelected(MenuItem item) {

        Animation anim = null;

        switch (item.getItemId()) {

            case MENU_ALPHA_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
                break;

            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.scale);
                break;

            case MENU_TRANS_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.trans);
                break;

            case MENU_ROTATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;

            case MENU_COMBO_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.combo);
                break;
        }
        textView.startAnimation(anim);

        return super.onContextItemSelected(item);
    }
}

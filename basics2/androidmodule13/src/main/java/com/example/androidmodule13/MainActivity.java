package com.example.androidmodule13;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    LinearLayout linearLayout;
    RadioGroup radioGroup;
    EditText editText;
    Button btnCreate, btnClear;

    int wrap_content = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        editText = (EditText) findViewById(R.id.editText);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnCreate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
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

            case R.id.btnCreate:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wrap_content,
                        wrap_content);
                int btnGravity = Gravity.LEFT;

                switch (radioGroup.getCheckedRadioButtonId()) {

                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                layoutParams.gravity = btnGravity;

                Button btnNew = new Button(this);
                btnNew.setText(editText.getText().toString());
                linearLayout.addView(btnNew, layoutParams);

                break;

            case R.id.btnClear:
                linearLayout.removeAllViews();
                Toast.makeText(this, "Удалено", Toast.LENGTH_LONG).show();
                break;
        }
    }
}

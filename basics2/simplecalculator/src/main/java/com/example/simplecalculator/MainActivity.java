package com.example.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    EditText editText1, editText2;
    Button btnAdd, btnMin, btnMult, btnDiv;
    TextView textView;
    LinearLayout linearLayout1, linearLayout2;

    final int MENU_QIET_ID = 1;
    final int MENU_CLEAR_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        textView = (TextView) findViewById(R.id.textView);

        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnMin = (Button) findViewById(R.id.btnMin);
        btnMin.setOnClickListener(this);

        btnMult = (Button) findViewById(R.id.btnMult);
        btnMult.setOnClickListener(this);

        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(0, MENU_CLEAR_ID, 0, "CLEAR");
        menu.add(0, MENU_QIET_ID, 0, "QUIET");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case MENU_CLEAR_ID:
                editText1.setText("");
                editText2.setText("");
                textView.setText("");
                break;

            case MENU_QIET_ID:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {

        float number1 = Float.parseFloat(editText1.getText().toString());
        float number2 = Float.parseFloat(editText2.getText().toString());
        String operand = "";
        float result = 0;

        switch (v.getId()) {

            case R.id.btnAdd:
                if(TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())) {

                    Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show();
                }
                result = number1 + number2;
                operand = "+";
                break;
            case R.id.btnMin:
                if(TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())) {

                    Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show();
                }
                result = number1 - number2;
                operand = "-";
                break;
            case R.id.btnMult:
                if(TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())) {

                    Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show();
                }
                result = number1 * number2;
                operand = "*";
                break;
            case R.id.btnDiv:
                if(TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())) {

                    Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show();
                }
                operand = "/";
                if (number2 == 0) {

                    result = 0;
                    Toast.makeText(this, "Деление на ноль невозможно", Toast.LENGTH_LONG).show();
                }
                else result = number1/number2;
                break;
        }

        textView.setText(String.valueOf(number1) + operand + String.valueOf(number2) + "=" + String.valueOf(result));
    }
}

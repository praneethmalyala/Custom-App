package com.malyalapraneeth.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Map<String, String> map;
    TextView displayText;
    Integer [] values;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = pref.edit();
        values  = new Integer[4];
        for(int x = 0; x < 4; x++)
            values[x] = pref.getInt(""+x, 0);

    }

    public void clickCount(View view) {
        String num = view.getResources().getResourceName(view.getId()).trim();
        String str = num.charAt(num.length() -1) + "";
        int val = Integer.parseInt(str) - 1;
        values[val]++;
        editor.putInt(str, values[val]);
        editor.commit();
        Context context = getApplicationContext();
        CharSequence output = num.charAt(num.length()-1)  + ":" + values[val];
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, output, duration);
        toast.show();
    }
}

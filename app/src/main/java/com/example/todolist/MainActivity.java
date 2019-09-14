package com.example.todolist;

import android.graphics.Color;
import android.graphics.Typeface;
import android.provider.FontsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //ListView listview;
    ArrayList<SpannableString> sheet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText item =  findViewById(R.id.editText);
        ListView list2 = findViewById(R.id.list);
        final ArrayAdapter<SpannableString> adapt = new ArrayAdapter<>(this,android.R.layout.select_dialog_multichoice, sheet);
        list2.setAdapter(adapt);
        Button add2 = findViewById(R.id.button);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString x = new SpannableString(item.getText());
                ForegroundColorSpan textcolor = new ForegroundColorSpan(Color.WHITE);
                StyleSpan bold = new StyleSpan(Typeface.BOLD);

                x.setSpan(textcolor,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                x.setSpan(bold,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                sheet.add(x);
                adapt.notifyDataSetChanged();
            }
        });
        Button alpha = findViewById(R.id.alpha);
        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Collections.sort(sheet);
                adapt.notifyDataSetChanged();

            }
        });



    }
}

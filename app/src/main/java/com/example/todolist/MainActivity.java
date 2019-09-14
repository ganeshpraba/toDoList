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
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
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
    ListView list2 = findViewById(R.id.list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText item =  findViewById(R.id.editText);

        final ArrayAdapter<SpannableString> adapt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice, sheet);

//        Button add2 = findViewById(R.id.button);
//        add2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SpannableString x = new SpannableString(item.getText());
//                ForegroundColorSpan textcolor = new ForegroundColorSpan(Color.WHITE);
//                StyleSpan bold = new StyleSpan(Typeface.BOLD);
//
//                x.setSpan(textcolor,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                x.setSpan(bold,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//                sheet.add(x);
//                adapt.notifyDataSetChanged();
//            }
//        });
        item.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    SpannableString x = new SpannableString(item.getText());
                    ForegroundColorSpan textColor = new ForegroundColorSpan(Color.WHITE);
                    StyleSpan bold = new StyleSpan(Typeface.BOLD);

                    x.setSpan(textColor,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    x.setSpan(bold,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    sheet.add(0,x);
                    adapt.notifyDataSetChanged();
                    return true;

                }

                return false;
            }
        });
        list2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray postionchecker = list2.getCheckedItemPositions();
                int count = list2.getCount();
                for (int i = count - 1;i >= 0;i--) {
                    if (postionchecker.get(i)) {
                        adapt.remove(sheet.get(i));

                    }
                }
                postionchecker.clear();
                adapt.notifyDataSetChanged();

                return false;
            }
        });
        list2.setAdapter(adapt);


//        SparseBooleanArray postionchecker = list2.getCheckedItemPositions();
//        int count = list2.getCount();
//        for (int item = count - 1;item >= 0;item--) {
//            if (postionchecker.get(item)) {
//                adapt.remove(sheet.get(item));
//
//            }
//        }
//        postionchecker.clear();
//        adapt.notifyDataSetChanged();
//        return false;


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

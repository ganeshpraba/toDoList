package com.example.todolist;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.provider.FontsContract;
import android.support.v7.app.AlertDialog;
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
import android.widget.TextView;

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
        final ListView list2 = findViewById(R.id.list);


        final ArrayAdapter<SpannableString> adapt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice, sheet);
        list2.setAdapter(adapt);


        item.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP)&&(keyCode == KeyEvent.KEYCODE_ENTER)) {
                    SpannableString x = new SpannableString(item.getText());
                    ForegroundColorSpan textColor = new ForegroundColorSpan(Color.WHITE);
                    StyleSpan bold = new StyleSpan(Typeface.BOLD);

                    x.setSpan(textColor,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    x.setSpan(bold,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    sheet.add(0,x);
                    adapt.notifyDataSetChanged();
                    item.getText().clear();
                    return true;

                }

                return false;
            }
        });
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String d = ((TextView) view).getText().toString();
            }
        });
        list2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int wh_item = position;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_menu_delete)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sheet.remove(wh_item);
                                adapt.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();

                return true;
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

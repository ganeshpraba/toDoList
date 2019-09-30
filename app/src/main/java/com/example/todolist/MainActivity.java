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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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
        list2.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        CustomAdapter customAdapter = new CustomAdapter();
        list2.setAdapter(customAdapter);
        final ArrayAdapter<SpannableString> adapt = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice, sheet);
        list2.setAdapter(adapt);

        // Listener to see when enter is pressed
        item.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP)&&(keyCode == KeyEvent.KEYCODE_ENTER)) {
                    SpannableString x = new SpannableString(item.getText());
                    ForegroundColorSpan textColor = new ForegroundColorSpan(Color.WHITE);
                    StyleSpan bold = new StyleSpan(Typeface.BOLD);

                    x.setSpan(textColor,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    x.setSpan(bold,0,item.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    sheet.add(x);
                    adapt.notifyDataSetChanged();
                    item.getText().clear();
                    return true;

                }

                return false;
            }
        });
        final ArrayList<SpannableString> sheet2 = new ArrayList<>();
//        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                SpannableString d = new SpannableString(((TextView) view).getText());
//                if(sheet2.contains(d)){
//                    //sheet2.remove(d);
//                }
//                else{
//                    //sheet2.add(d);
//                }
//            }
//        });
        // long click to delete
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
    class CustomAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return sheet.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout, null);
            TextView text = (TextView)convertView.findViewById(R.id.textView_text);
            CheckBox check = (CheckBox)convertView.findViewById(R.id.checkBox_check);
            text.setText(sheet.get(position));

            return null;
        }
    }


}

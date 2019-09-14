package com.example.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //ListView listview;
    ArrayList<String> sheet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final EditText item =  findViewById(R.id.editText);
        //

        Button add2 = findViewById(R.id.button);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sheet.add(item.getText().toString());
            }
        });
        ListView list2 = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,android.R.layout.select_dialog_multichoice, sheet);
        list2.setAdapter(adapt);
    }
}

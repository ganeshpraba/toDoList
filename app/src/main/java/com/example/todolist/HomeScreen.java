package com.example.todolist;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {
    ArrayList<SpannableString> sheet = new ArrayList<>();
    int num = 0;
    RecyclerView list2;
    RecyclerView.LayoutManager layoutM;
    MainAdapter mAdapter;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        list2 = findViewById(R.id.list);
        layoutM = new LinearLayoutManager(this);
        mAdapter = new MainAdapter(sheet);
        list2.setLayoutManager(layoutM);
        list2.setAdapter(mAdapter);
        for(int i = 1; i <= 7; i++){
            SpannableString temp = new SpannableString("List "+i);
            sheet.add(temp);
        }
        mAdapter.notifyDataSetChanged();







        button = findViewById(R.id.toList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });
    }
    public void openMain(){
        Intent intent = new Intent(this, ListScreen.class);
        startActivity(intent);

    }
}

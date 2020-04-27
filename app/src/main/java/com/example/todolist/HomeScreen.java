package com.example.todolist;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.Log;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.todolist.Adapters.HomeAdapter;

import java.util.ArrayList;


public class HomeScreen extends AppCompatActivity implements HomeAdapter.OnListListener {
    private static final String TAG="HomeScreen";
    ArrayList<SpannableString> sheet = new ArrayList<>();
    ArrayList<List> motherList = new ArrayList<>();
    int num = 0;
    RecyclerView list2;
    RecyclerView.LayoutManager layoutM;
    HomeAdapter mAdapter;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        list2 = findViewById(R.id.list);
        layoutM = new LinearLayoutManager(this);
        mAdapter = new HomeAdapter(sheet, this);
        list2.setLayoutManager(layoutM);
        list2.setAdapter(mAdapter);
        SpannableString temp2 = new SpannableString("Camping Trip");
        sheet.add(temp2);
        mAdapter.notifyDataSetChanged();
        temp2 = new SpannableString("Grocery List");
        sheet.add(temp2);
        mAdapter.notifyDataSetChanged();
        temp2 = new SpannableString("Moving Checklist");
        sheet.add(temp2);
        mAdapter.notifyDataSetChanged();
        temp2 = new SpannableString("Mexico Trip");
        sheet.add(temp2);
        mAdapter.notifyDataSetChanged();

        for(int i = 5; i <= 12; i++){
            SpannableString temp = new SpannableString("List "+i);
            sheet.add(temp);
        }
        mAdapter.notifyDataSetChanged();


    }


    @Override
    public void OnListClick(int position) {
        Log.d(TAG, "Clicked: "+position);
        Intent intent = new Intent(this, ListScreen.class);
        intent.putExtra("pos clicked",position);
        startActivity(intent);
    }
}

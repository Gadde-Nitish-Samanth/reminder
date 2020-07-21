package com.example.reminder;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reminder.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDialog();
            }
        });
    }

    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");

    }

    @Override
    public void applyTexts(String notename, String note, String date, String time) {
        adddata(notename,note,date,time);
    }

    void adddata(String note_name , String note,String date,String time){
        boolean isinserted = myDb.insertData(note_name, note, date, time);

        if (isinserted)
            Toast.makeText(MainActivity.this,"Data Not Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
    }
}
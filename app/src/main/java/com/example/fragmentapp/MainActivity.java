package com.example.fragmentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentapp.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity implements Fragment1.OnItemSelectedListener {

    private FragmentTransaction ft;
    private FragmentTransaction ft2;
    private Fragment2 fdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fragment initialse programatically

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        ft.replace(R.id.frame2, new Fragment1());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        ft.commit();


        ft2 = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        fdd = new Fragment2();
        ft2.replace(R.id.frame1, fdd);
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        ft2.commit();


    }


    public void setTextOnSecdFrag(String value){
        Toast.makeText(MainActivity.this, "inside main:"+value, Toast.LENGTH_SHORT).show();

        // Begin the transaction
        ft = getSupportFragmentManager().beginTransaction();

//        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.frag2);
//        fragment2.setTextStatus(value);

        fdd.setTextStatus(value);
        ft.replace(R.id.frame1, fdd);
        ft.commit();

    }

    @Override
    public void onItemSelect(String link) {
        Toast.makeText(MainActivity.this, "inside on item select:"+link, Toast.LENGTH_SHORT).show();
        ft = getSupportFragmentManager().beginTransaction();

//        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.frag2);
//        fragment2.setTextStatus(value);

        fdd.setTextStatus(link);
        ft.replace(R.id.frame1, fdd);
        ft.commit();

    }

    @Override
    public void tellThisToFrag2() {

    }
}

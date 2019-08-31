package com.example.fragmentapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fragmentapp.adapter.MyAdapter;


public class Fragment1 extends Fragment {

    private OnItemSelectedListener mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_fragment1, container, false);

        final String[] lists = {"Item 1", "Item 2", "Item 3"};

        ListView listView = fragmentView.findViewById(R.id.list_view);

        MyAdapter myAdapter = new MyAdapter(getActivity(), lists);

        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity mainActivity = (MainActivity) getActivity();
                //mainActivity.setTextOnSecdFrag(lists[position]);
                mContext.onItemSelect(lists[position]);
                mContext.tellThisToFrag2();
            }
        });

        return fragmentView;
    }


    // Define the events that the fragment will use to communicate
    public interface OnItemSelectedListener {
        // This can be any number of events to be sent to the activity
        public void onItemSelect(String link);
        public  void tellThisToFrag2();
    }

    // Store the listener (activity) that will have events fired once the fragment is attached
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            mContext = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }
}

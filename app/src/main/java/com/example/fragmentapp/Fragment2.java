package com.example.fragmentapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment2 extends Fragment {

    private TextView singleRow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragView = inflater.inflate(R.layout.fragment_fragment2, container, false);
        return fragView;
    }


    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        singleRow = getView().findViewById(R.id.singleRowText);

    }

    public void setTextStatus(String param) {
//        singleRow = getView().findViewById(R.id.singleRowText);


        singleRow.setText(param);

    }
}

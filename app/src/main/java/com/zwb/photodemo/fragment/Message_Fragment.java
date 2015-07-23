package com.zwb.photodemo.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zwb.photodemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Message_Fragment extends Fragment {


    public Message_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_, container, false);
    }


}

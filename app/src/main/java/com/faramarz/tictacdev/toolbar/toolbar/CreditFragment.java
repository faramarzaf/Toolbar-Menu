package com.faramarz.tictacdev.toolbar.toolbar;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.faramarz.tictacdev.toolbar.R;


public class CreditFragment extends Fragment {


    public CreditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit, container, false);
        return view;
    }


}

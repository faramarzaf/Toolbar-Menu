package com.faramarz.tictacdev.toolbar.toolbar;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faramarz.tictacdev.toolbar.R;


public class CreditFragment extends Fragment {
    TextView txtCash;

    public CreditFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_credit, container, false);
        txtCash = view.findViewById(R.id.txtCash);
        receiveData();
        return view;
    }


    private void receiveData() {
        Bundle bundle = this.getArguments();
        String myInt ;
        if (bundle != null) {
            myInt = bundle.getString("myCash", "");
            txtCash.setText(myInt);
        }
    }


}

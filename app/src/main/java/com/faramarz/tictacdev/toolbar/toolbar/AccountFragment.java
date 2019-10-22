package com.faramarz.tictacdev.toolbar.toolbar;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.faramarz.tictacdev.toolbar.R;

public class AccountFragment extends Fragment implements View.OnClickListener {

    EditText edtCash;
    Button btnPassCash;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);
        edtCash = view.findViewById(R.id.edtCash);
        btnPassCash = view.findViewById(R.id.btnPassCash);
        btnPassCash.setOnClickListener(this);
        return view;

    }


    @Override
    public void onClick(View v) {
        CreditFragment fragment = new CreditFragment();
        Bundle bundle = new Bundle();
        String myCash = edtCash.getText().toString();
        bundle.putString("myCash", myCash);
        fragment.setArguments(bundle);
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
        }

    }
}

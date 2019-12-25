package com.faramarz.tictacdev.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.faramarz.tictacdev.toolbar.menu.MenuActivity;
import com.faramarz.tictacdev.toolbar.toolbar.ToolbarActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMenu, btnToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMenu = findViewById(R.id.btnMenu);
        btnToolbar = findViewById(R.id.btnToolbar);

        btnMenu.setOnClickListener(this);
        btnToolbar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnMenu:
                startActivity(new Intent(this, MenuActivity.class));
                break;

            case R.id.btnToolbar:
                startActivity(new Intent(this, ToolbarActivity.class));

                break;
        }

    }
}

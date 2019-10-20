package com.faramarz.tictacdev.toolbar.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.faramarz.tictacdev.toolbar.R;

public class ToolbarActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    ImageButton btnCredit, btnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        setSupportActionBar(toolbar);
        bind();
        clickEvents();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnCredit:
                Toast.makeText(this, "Get your credit!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnMore:
                onPopupButtonClick(btnMore);
                break;
        }
    }

    private void bind() {
        toolbar = findViewById(R.id.toolbar);
        btnCredit = findViewById(R.id.btnCredit);
        btnMore = findViewById(R.id.btnMore);

    }

    private void clickEvents() {
        btnCredit.setOnClickListener(this);
        btnMore.setOnClickListener(this);
    }

    public void onPopupButtonClick(View button) {
        Context myContext = new ContextThemeWrapper(ToolbarActivity.this,R.style.menuStyle);
        PopupMenu popup = new PopupMenu(myContext, button);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(ToolbarActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popup.show();
    }

}

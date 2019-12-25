package com.faramarz.tictacdev.toolbar.toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.faramarz.tictacdev.toolbar.R;
import com.google.android.material.navigation.NavigationView;

public class ToolbarActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    ImageButton btnCredit, btnMore, btnDrawer;
    DrawerLayout drawerLayout;
    NavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        setSupportActionBar(toolbar);
        bind();
        clickEvents();


        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment f = null;
                int itemId = menuItem.getItemId();
                if (itemId == R.id.creditItem) {
                    f = new CreditFragment();
                } else if (itemId == R.id.bankAccount) {
                    f = new AccountFragment();
                }
                if (f != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, f);
                    transaction.commit();
                    drawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });

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

            case R.id.btnDrawer:
                if (!drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
                break;


        }
    }

    private void bind() {
        toolbar = findViewById(R.id.toolbar);
        btnCredit = findViewById(R.id.btnCredit);
        btnMore = findViewById(R.id.btnMore);
        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.navigation);
        btnDrawer = findViewById(R.id.btnDrawer);
    }

    private void clickEvents() {
        btnCredit.setOnClickListener(this);
        btnMore.setOnClickListener(this);
        btnDrawer.setOnClickListener(this);
    }

    public void onPopupButtonClick(View button) {
        Context myContext = new ContextThemeWrapper(ToolbarActivity.this, R.style.menuStyle);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_items, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            // Android home
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.RIGHT);
                return true;
        }
        return true;
    }


}

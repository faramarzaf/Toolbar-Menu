package com.faramarz.tictacdev.toolbar.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import com.faramarz.tictacdev.toolbar.R;
import com.faramarz.tictacdev.toolbar.toolbar.ToolbarActivity;

public class MenuActivity extends AppCompatActivity {
    private static final int FILE = 0;
    private static final int NEW_MENU_ITEM = Menu.FIRST;
    private static final int SAVE_MENU_ITEM = NEW_MENU_ITEM + 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sample1, menu);
        SubMenu fileMenu = menu.addSubMenu("حساب من");
        fileMenu.add(FILE, SAVE_MENU_ITEM, 1, menuIconWithText(getResources().getDrawable(R.drawable.ic_account), getResources().getString(R.string.credit)));
        menu.add(0, 1, 1, menuIconWithText(getResources().getDrawable(R.drawable.ic_system_update), getResources().getString(R.string.updates)));
        menu.add(0, 2, 2, menuIconWithText(getResources().getDrawable(R.drawable.ic_money), getResources().getString(R.string.price)));
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options:
                break;

            case R.id.about:
                break;

            case R.id.upload:
                break;

            case R.id.download:
                break;

            case R.id.news:
                break;

        }
        return true;
    }

    private CharSequence menuIconWithText(Drawable r, String title) {
        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
        SpannableString sb = new SpannableString("    " + title);
        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }

}

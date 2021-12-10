package com.example.bkd0708k11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Session10 extends AppCompatActivity {
    Button btnShowContextMenu, btnOpenContextActionBarMenu, btnOpenPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session10);
        btnShowContextMenu = findViewById(R.id.btnShowContextMenu);
        btnOpenContextActionBarMenu = findViewById(R.id.btnOpenContextActionBarMenu);

        btnOpenContextActionBarMenu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Session10.this.startActionMode(new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        MenuInflater menuInflater = getMenuInflater();
                        menuInflater.inflate(R.menu.context_actionbar_menu, menu);
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.itemShare:
                                Toast.makeText(Session10.this, "Bạn đã chọn share item", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.itemEdit:
                                Toast.makeText(Session10.this, "Bạn đã chọn edit item", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {

                    }
                });
                return false;
            }
        });

        registerForContextMenu(btnShowContextMenu);//khi ấn và giữ vào button thì sẽ show ra cái menu
        btnOpenPopupMenu = findViewById(R.id.btnOpenPopupMenu);
        btnOpenPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Session10.this, v);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_item_1:
                                Toast.makeText(Session10.this, "Bạn đã chọn item 1", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu_item_2:
                                Toast.makeText(Session10.this, "Bạn đã chọn item 2", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });
    }


    //tạo ra menu trong activity khi người dùng ấn và giữ vào button
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(Session10.this, "Bạn đã chọn item 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_2:
                Toast.makeText(Session10.this, "Bạn đã chọn item 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
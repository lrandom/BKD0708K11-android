package com.example.bkd0708k11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Session10 extends AppCompatActivity {
    Button btnShowContextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session10);
        btnShowContextMenu = findViewById(R.id.btnShowContextMenu);
        registerForContextMenu(btnShowContextMenu);//khi ấn và giữ vào button thì sẽ show ra cái menu
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
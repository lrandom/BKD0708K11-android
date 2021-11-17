package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {
    Button btnStartActivity2, btnOpenLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //intent tường minh (explicit)
        btnStartActivity2 = findViewById(R.id.btnStartActivity);
        //Intent intent = new Intent(this, Activity2.class);
        btnStartActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, Activity2.class);
                //intent.putExtra("NAME", "Nguyen Thanh Luan");
                //intent.putExtra("ADDRESS", "QN");

                Bundle bundle = new Bundle();
                bundle.putString("NAME","Nguyen Thanh Luan");
                bundle.putString("ADDRESS", "QN");

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });


        //intent ngầm định (implicit)
        btnOpenLink = findViewById(R.id.btnOpenLink);
        btnOpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://google.com.vn");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
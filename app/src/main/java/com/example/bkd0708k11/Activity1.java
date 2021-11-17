package com.example.bkd0708k11;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {
    Button btnStartActivity2, btnOpenLink, btnStartActivityForResult;
    public static final int REQUEST_CODE_FOR_ACTIVITY_2 = 100;
    public static final int REQUEST_CODE_FOR_ACTIVITY_3 = 101;

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
                //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });


        ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            String subject = data.getStringExtra("SUBJECT");
                            Log.i("SUBJECT", subject);
                        }
                    }
                }
        );



        btnStartActivityForResult = findViewById(R.id.btnStartActivityForResult);
        btnStartActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, Activity2.class);
                //startActivityForResult(intent,REQUEST_CODE_FOR_ACTIVITY_2);
                startActivityForResult.launch(intent);
            }
        });
    }


/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("TEST");
        switch (requestCode) {
            case REQUEST_CODE_FOR_ACTIVITY_2:
                if (resultCode == RESULT_OK) {
                    //lấy dữ liệu ra
                    String subject = data.getStringExtra("SUBJECT");
                    Log.i("SUBJECT", subject);
                }
                break;

            case REQUEST_CODE_FOR_ACTIVITY_3:
                break;
        }
    }*/
}
package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityCheckNetworkState extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_network_state);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        /*NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(ActivityCheckNetworkState.this, "Bạn đã kết nối đến mạng internet", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ActivityCheckNetworkState.this, "Bạn chưa kết nối đến mạng internet", Toast.LENGTH_SHORT).show();
        }*/

        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo.isConnected()) {
            Toast.makeText(ActivityCheckNetworkState.this, "Bạn đã kết nối bằng WIFI", Toast.LENGTH_SHORT).show();
        }

        NetworkInfo networkInfo1 = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo1.isConnected()) {
            Toast.makeText(ActivityCheckNetworkState.this, "Bạn đã kết nối bằng internet mobile", Toast.LENGTH_SHORT).show();
        }
    }
}
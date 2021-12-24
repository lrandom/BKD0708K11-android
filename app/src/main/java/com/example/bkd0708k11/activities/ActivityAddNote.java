package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.services.ApiService;
import com.example.bkd0708k11.services.RestClient;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAddNote extends AppCompatActivity {
    EditText edtTitle, edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        edtContent = findViewById(R.id.edtContent);
        edtTitle = findViewById(R.id.edtTitle);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String content = edtContent.getText().toString();
                if (title.equalsIgnoreCase("") || content.equalsIgnoreCase("")) {
                    //display thông báo
                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityAddNote.this);
                    builder.setMessage(R.string.validate_alert_message);
                    builder.setPositiveButton(R.string.agree, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    return;
                }

                ApiService apiService = RestClient.getApiService();
                Call<JSONObject> call = apiService.addNote(title, content);
                call.enqueue(new Callback<JSONObject>() {
                    @Override
                    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                        Toast.makeText(ActivityAddNote.this, R.string.add_successfully,
                                Toast.LENGTH_SHORT).show();
                        edtTitle.setText("");
                        edtContent.setText("");
                    }

                    @Override
                    public void onFailure(Call<JSONObject> call, Throwable t) {

                    }
                });
            }
        });
    }
}
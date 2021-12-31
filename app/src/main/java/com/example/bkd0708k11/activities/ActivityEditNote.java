package com.example.bkd0708k11.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.domains.Note;
import com.example.bkd0708k11.services.ApiService;
import com.example.bkd0708k11.services.RestClient;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityEditNote extends AppCompatActivity {
    EditText edtTitle, edtContent;
    String idOfUpdateNote;
    Note note = new Note();
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_note);
        idOfUpdateNote = getIntent().getStringExtra("ID");
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        btnSubmit = findViewById(R.id.btnSubmit);

        ApiService apiService = RestClient.getApiService();
        Call<Note> call = apiService.findById(idOfUpdateNote);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                Toast.makeText(ActivityEditNote.this, R.string.load_success,
                        Toast.LENGTH_SHORT).show();
                Note note = response.body();
                edtTitle.setText(note.getTitle());
                edtContent.setText(note.getContent());
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<JSONObject> callUpdate = apiService.editNote(idOfUpdateNote, edtTitle.getText().toString(), edtContent.getText().toString());
                callUpdate.enqueue(new Callback<JSONObject>() {
                    @Override
                    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                        Toast.makeText(ActivityEditNote.this, R.string.update_success,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<JSONObject> call, Throwable t) {

                    }
                });
            }
        });

    }
}
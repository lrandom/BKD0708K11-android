package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.dals.DalNote;

public class AddNoteActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText edtTitle, edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DalNote dalNote = new DalNote(AddNoteActivity.this);
                dalNote.addNote(edtTitle.getText().toString(), edtContent.getText().toString());
                edtTitle.setText("");
                edtContent.setText("");
            }
        });
    }
}
package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.dals.DalNote;
import com.example.bkd0708k11.activities.noteapp.models.Note;

public class UpdateNoteActivity extends AppCompatActivity {
    Long id;
    Button btnSubmit;
    TextView edtTitle, edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);
        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        btnSubmit = findViewById(R.id.btnSubmit);
        id = getIntent().getLongExtra("id", 0);
        DalNote dalNote = new DalNote(UpdateNoteActivity.this);
        Note note = dalNote.getNoteById(id);
        edtTitle.setText(note.getTitle());
        edtContent.setText(note.getContent());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dalNote.updateNote(id, edtTitle.getText().toString(), edtContent.getText().toString());
            }
        });
    }


}
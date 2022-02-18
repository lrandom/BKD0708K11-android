package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.adapter.AdapterNote;
import com.example.bkd0708k11.activities.noteapp.dals.DalNote;
import com.example.bkd0708k11.activities.noteapp.models.Note;

import java.util.ArrayList;

public class ListNoteActivity extends AppCompatActivity {
    AdapterNote adapterNote;
    RecyclerView rcListNote;
    Button btnGoAddNote;
    DalNote dalNote;
    ArrayList<Note> notes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_note);
        btnGoAddNote = findViewById(R.id.btnGoToAddNote);
        btnGoAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListNoteActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });
        rcListNote = findViewById(R.id.rcListNote);
        adapterNote = new AdapterNote(ListNoteActivity.this, notes);
        rcListNote.setAdapter(adapterNote);
        rcListNote.setLayoutManager(new LinearLayoutManager(ListNoteActivity.this,
                RecyclerView.VERTICAL, false));

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.notes.clear();
        dalNote = new DalNote(ListNoteActivity.this);
        ArrayList<Note> notes = dalNote.getNotes();
        for (Note note : notes
        ) {
            this.notes.add(note);
        }
        adapterNote.notifyDataSetChanged();
    }
}
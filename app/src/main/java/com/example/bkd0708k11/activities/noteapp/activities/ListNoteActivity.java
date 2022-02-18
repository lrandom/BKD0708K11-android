package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
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
        adapterNote.setOnDeleteItem(new AdapterNote.OnDeleteItem() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void deleteItem(Long id) {
                dalNote.deleteNote(id);
                Note note = notes.stream().filter(item -> item.getId() == id).findFirst().get();//stream api and lambda
                notes.remove(note);
                adapterNote.notifyDataSetChanged();
            }
        });
        adapterNote.setOnEditItem(new AdapterNote.OnEditItem() {
            @Override
            public void editItem(Long id) {
                Intent intent = new Intent(ListNoteActivity.this, UpdateNoteActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
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
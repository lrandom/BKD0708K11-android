package com.example.bkd0708k11.activities.noteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.models.Note;

import java.util.ArrayList;

public class AdapterNote
        extends RecyclerView.Adapter<AdapterNote.NoteViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Note> notes = new ArrayList<>();
    public static String TAG = "NoteAdapter";

    public AdapterNote(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.notes = notes;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder,
                                 int position) {
        Note note = notes.get(position);
        holder.tvTitle.setText(note.getTitle());

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.note_item, parent, false);
        NoteViewHolder myViewHolder = new NoteViewHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}


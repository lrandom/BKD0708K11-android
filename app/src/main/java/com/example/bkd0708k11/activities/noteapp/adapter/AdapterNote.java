package com.example.bkd0708k11.activities.noteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    OnDeleteItem onDeleteItem;
    OnEditItem onEditItem;

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
        holder.btnDelete.setTag(note.getId());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteItem.deleteItem((Long) v.getTag());
            }
        });

        holder.btnEdit.setTag(note.getId());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEditItem.editItem((Long) v.getTag());
            }
        });
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.note_item, parent, false);
        NoteViewHolder myViewHolder = new NoteViewHolder(v);
        return myViewHolder;
    }

    public void setOnDeleteItem(OnDeleteItem onDeleteItem) {
        this.onDeleteItem = onDeleteItem;
    }

    public interface OnDeleteItem {
        public void deleteItem(Long id);
    }

    public void setOnEditItem(OnEditItem onEditItem) {
        this.onEditItem = onEditItem;
    }

    public interface OnEditItem {
        public void editItem(Long id);
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageButton btnDelete;
        ImageButton btnEdit;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnEdit = itemView.findViewById(R.id.btnEdit);
        }
    }
}


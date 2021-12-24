package com.example.bkd0708k11.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.domains.Note;
import com.example.bkd0708k11.services.ApiService;
import com.example.bkd0708k11.services.RestClient;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterNote extends RecyclerView.Adapter<AdapterNote.EmployeeViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Note> notes = new ArrayList<>();
    public static String TAG = "AdapterNote";
    //public AdapterCountry.MyItemClickListener myItemClickListener;

    public AdapterNote(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.notes = notes;
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterNote.EmployeeViewHolder holder,
                                 int position) {
        Note note = notes.get(position);
        holder.tvName.setText(note.getTitle());
        holder.btnMenu.setTag(note);
        holder.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note restoreNote = (Note) v.getTag();
                String id = restoreNote.getId();
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_delete:
                                //goi api xoa
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setMessage(R.string.confirm_delete);
                                builder.setPositiveButton(R.string.agree, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ApiService apiService = RestClient.getApiService();
                                        Call<JSONObject> call = apiService.deleteNote(id);
                                        call.enqueue(new Callback<JSONObject>() {
                                            @Override
                                            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                                                Toast.makeText(context, R.string.delete_successfully,
                                                        Toast.LENGTH_SHORT).show();
                                                AdapterNote.this.notes.remove(restoreNote);
                                                notifyDataSetChanged();
                                            }

                                            @Override
                                            public void onFailure(Call<JSONObject> call, Throwable t) {

                                            }
                                        });
                                    }
                                });
                                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();

                                break;

                            case R.id.item_edit:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();

            }
        });
    }

    @NonNull
    @Override
    public AdapterNote.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item_note, parent, false);
        AdapterNote.EmployeeViewHolder myViewHolder = new AdapterNote.EmployeeViewHolder(v);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageButton btnMenu;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvTitle);
            this.btnMenu = itemView.findViewById(R.id.btnMenu);
        }
    }
}


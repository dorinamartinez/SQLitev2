package com.example.demosqlite02;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecord extends RecyclerView.Adapter<AdapterRecord.HolderRecord> {

    private Context context;
    private ArrayList<ModelRecord> recordArrayList;
    private ImageButton btnMore;

    public AdapterRecord(Context context, ArrayList<ModelRecord> recordArrayList) {
        this.context = context;
        this.recordArrayList = recordArrayList;
    }

    @NonNull
    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_record, parent, false);
        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {
        ModelRecord modelRecord = recordArrayList.get(position);

        String id = modelRecord.getId();
        String nombre = modelRecord.getNombre();
        String image = modelRecord.getImage();
        String artista = modelRecord.getArtista();
        String genero = modelRecord.getGenero();
        String pais = modelRecord.getPais();
        String anio = modelRecord.getAnio();


        holder.ivCancion.setImageURI(Uri.parse(image));
        holder.tvCancion.setText(nombre);
        holder.tvArtista.setText(artista);

        if (image.equals("null")) {
            holder.ivCancion.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            holder.ivCancion.setImageURI(Uri.parse(image));
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecordDetailActivity.class);
                intent.putExtra("RECORD_ID", id);
                context.startActivity(intent);
            }
        });

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return recordArrayList.size();
    }


    class HolderRecord extends RecyclerView.ViewHolder {

        ImageView ivCancion;
        TextView tvCancion, tvArtista;
        ImageButton btnMore;


        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            ivCancion = itemView.findViewById(R.id.civImage2);
            tvCancion = itemView.findViewById(R.id.tvNombre);
            tvArtista = itemView.findViewById(R.id.tvArtista);
            btnMore = itemView.findViewById(R.id.btnMore);

        }
    }

}

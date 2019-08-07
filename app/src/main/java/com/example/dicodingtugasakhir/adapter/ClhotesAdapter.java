package com.example.dicodingtugasakhir.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dicodingtugasakhir.R;
import com.example.dicodingtugasakhir.models.ClothesModel;

import java.util.ArrayList;

public class ClhotesAdapter extends RecyclerView.Adapter<ClhotesAdapter.MyViewHolder> {
    private ArrayList<ClothesModel> listModel;

    public ClhotesAdapter(ArrayList<ClothesModel> listModel) {
        this.listModel = listModel;
    }
    private onClickListenerCallback onClickListenerCallback;

    public void setOnClickListenerCallback(onClickListenerCallback onClickListenerCallback) {
        this.onClickListenerCallback = onClickListenerCallback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clothes,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        ClothesModel clothesModel = listModel.get(position);
        holder.imageView.setImageResource(clothesModel.getGambar());
        holder.textViewHarga.setText(clothesModel.getHarga());
        holder.textViewNama.setText(clothesModel.getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListenerCallback.onClick(listModel.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewNama, textViewHarga;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_clothe);
            textViewNama = itemView.findViewById(R.id.tv_name_clothe);
            textViewHarga = itemView.findViewById(R.id.tv_harga_clhote);
        }
    }

    public interface onClickListenerCallback{
        void onClick(ClothesModel clothesModel);
    }
}

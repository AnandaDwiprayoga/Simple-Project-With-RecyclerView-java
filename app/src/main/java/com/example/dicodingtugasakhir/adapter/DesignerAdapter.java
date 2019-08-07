package com.example.dicodingtugasakhir.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dicodingtugasakhir.R;
import com.example.dicodingtugasakhir.models.DesignerModels;

import java.util.ArrayList;

public class DesignerAdapter extends RecyclerView.Adapter<DesignerAdapter.MyViewHolder> {
    private ArrayList<DesignerModels> listModel;
    private onItemClickCallback mOnClickListener;

    public void setmOnClickListener(onItemClickCallback mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    public DesignerAdapter(ArrayList<DesignerModels> listModel) {
        this.listModel = listModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_designer, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final DesignerModels designerModels = listModel.get(position);
        holder.imageViewDesigner.setImageResource(designerModels.getPhoto());
        holder.textViewNama.setText(designerModels.getNama());
        holder.textViewFollower.setText(designerModels.getFollowers());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClickListener.onClick(listModel.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewDesigner;
        TextView textViewFollower, textViewNama;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewDesigner = itemView.findViewById(R.id.ci_img_designer);
            textViewNama = itemView.findViewById(R.id.tv_name_designer);
            textViewFollower = itemView.findViewById(R.id.tv_follower);
        }
    }

    public interface onItemClickCallback{
        void onClick(DesignerModels data);
    }
}

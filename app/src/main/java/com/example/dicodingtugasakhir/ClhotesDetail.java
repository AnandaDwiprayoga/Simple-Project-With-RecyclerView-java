package com.example.dicodingtugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dicodingtugasakhir.models.ClothesModel;

public class ClhotesDetail extends AppCompatActivity {

    public static final String KEY_CLOTHES = "key_clothes";
    private ClothesModel clothesModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clhotes_detail);

        ImageView imageViewClhotes = findViewById(R.id.iv_detail_clothes);
        TextView namaBaju = findViewById(R.id.tv_nama_clothes_detail);
        TextView hargaBaju = findViewById(R.id.tv_harga_detail);
        TextView stock = findViewById(R.id.tv_stock_clothes);
        TextView desk = findViewById(R.id.tv_desc_clothes);
        ImageView imageViewDesigner = findViewById(R.id.iv_designer_in_clothes);
        TextView namaDesigner = findViewById(R.id.tv_namaDesigner_detail);

        clothesModel = getIntent().getParcelableExtra(KEY_CLOTHES);
        if(clothesModel!=null){
            imageViewClhotes.setImageResource(clothesModel.getGambar());
            namaBaju.setText(clothesModel.getNama());
            hargaBaju.setText(clothesModel.getHarga());
            stock.setText(clothesModel.getStock());
            desk.setText(clothesModel.getDescClothes());
            imageViewDesigner.setImageResource(clothesModel.getPhotoDesigner());
            namaDesigner.setText(clothesModel.getNamaDesigner());
        }
    }

    public void backClicked(View view) {
        this.finish();
    }

    public void addToWishListClicked(View view) {
        if (clothesModel != null) {
            Toast.makeText(this, clothesModel.getNama() + " Telah ditambahkan di wishlist", Toast.LENGTH_SHORT).show();
        }
    }

}

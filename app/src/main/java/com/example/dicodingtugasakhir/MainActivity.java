package com.example.dicodingtugasakhir;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.dicodingtugasakhir.adapter.ClhotesAdapter;
import com.example.dicodingtugasakhir.adapter.DesignerAdapter;
import com.example.dicodingtugasakhir.data.DataClothes;
import com.example.dicodingtugasakhir.data.DataDesigner;
import com.example.dicodingtugasakhir.models.ClothesModel;
import com.example.dicodingtugasakhir.models.DesignerModels;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ClothesModel> clothesModels = new ArrayList<>();
    private ArrayList<DesignerModels> designerModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        costumActionBar();

        if(getSupportActionBar() != null) {
            View view = getSupportActionBar().getCustomView();
            ImageButton buttonFinish = view.findViewById(R.id.ib_finish);

            buttonFinish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

            ImageView imageViewFotoSaya = findViewById(R.id.img_me);
            imageViewFotoSaya.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, AboutMe.class));
                }
            });
        }

        RecyclerView recyclerViewClothes = findViewById(R.id.recyclerViewBaju);
        RecyclerView recyclerViewDesigner = findViewById(R.id.recyclerViewDesigner);

        clothesModels.addAll(DataClothes.getClothes());
        designerModels.addAll(DataDesigner.getModel());

        ClhotesAdapter clhotesAdapter = new ClhotesAdapter(clothesModels);
        DesignerAdapter designerAdapter = new DesignerAdapter(designerModels);

        recyclerViewClothes.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerViewClothes.setAdapter(clhotesAdapter);

        recyclerViewDesigner.setAdapter(designerAdapter);
        recyclerViewDesigner.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        designerAdapter.setmOnClickListener(new DesignerAdapter.onItemClickCallback() {
            @Override
            public void onClick(DesignerModels data) {
                Intent intent = new Intent(MainActivity.this, DetailDesigner.class);
                intent.putExtra(DetailDesigner.KEY_DESIGNER,data);
                startActivity(intent);
            }
        });

        clhotesAdapter.setOnClickListenerCallback(new ClhotesAdapter.onClickListenerCallback() {
            @Override
            public void onClick(ClothesModel clothesModel) {
                Intent intent = new Intent(MainActivity.this, ClhotesDetail.class);
                intent.putExtra(ClhotesDetail.KEY_CLOTHES, clothesModel);
                startActivity(intent);
            }
        });
    }

    public void costumActionBar(){
        if(getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setCustomView(R.layout.costum_action_bar);
        }
    }
}

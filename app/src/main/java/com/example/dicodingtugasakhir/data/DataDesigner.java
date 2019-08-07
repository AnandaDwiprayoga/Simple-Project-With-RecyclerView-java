package com.example.dicodingtugasakhir.data;

import android.util.Log;

import com.example.dicodingtugasakhir.R;
import com.example.dicodingtugasakhir.models.DesignerModels;

import java.util.ArrayList;

public class DataDesigner {
    private static ArrayList<DesignerModels> listModel = new ArrayList<>();
    private static String[][] designer = new String[][]{
            {"Anya Justin", "18K Followers", "77 Applegate Drive Lawrenceville","(715)635-8250"},
            {"Alex Smith", "10k Followers","Lexington Street Queensbury, NY", "(601)405-5800"},
            {"Gerald Marlino", "5K Followers", "Poplar Street East Meadow, NY", "(307)356-0882"},
            {"Angel cintya", "100K Followers", "South Overlook St.Aiken, SC", "(904)713-6064"},
            {"Bunga Sasmita", "58K Followers", "Bellevue Street Johnston, RI", "(901)415-7566"},
            {"Putri cantika", "200K Followers", "Henry St. Clover, SC", "(714)254-0079"},
            {"Monalisa gurlin", "118K Followers", "West Willow Drive Tucker, GA","(815)792-6346"},
            {"Risca Nissa", "33K Followers", "Durham Ave. Los Angeles, CA","(817)405-1975"},
            {"Madam Bernad", "69K Followers", "Jockey Hollow St.Beltsville, MD", "(404)760-7028"},
            {"Adam corlas", "300K Followers", "Glenridge Court Williamsburg, VA","(920)773-7350"}
    };


    private static int[][] designerImg = new int[][]{
            {R.drawable.designer1,R.drawable.lans12},
            {R.drawable.designer2,R.drawable.lans4},
            {R.drawable.designer3,R.drawable.lans3},
            {R.drawable.designer4,R.drawable.lans6},
            {R.drawable.designer5,R.drawable.lans11},
            {R.drawable.designer6,R.drawable.lans10},
            {R.drawable.designer7,R.drawable.lans9},
            {R.drawable.designer8,R.drawable.lans8},
            {R.drawable.designer9,R.drawable.lans7},
            {R.drawable.designer10,R.drawable.lans5}
    };

    public static int getPhotoDesigner(int index){
        return designerImg[index][0];
    }

    public static String getNamaDesigner(int index){
        return designer[index][0];
    }

    public static ArrayList<DesignerModels> getModel(){
        for (int i =0; i < designer.length; i++){
            DesignerModels designerModels = new DesignerModels();
            designerModels.setNama(designer[i][0]);
            designerModels.setFollowers(designer[i][1]);
            designerModels.setPhoto(designerImg[i][0]);
            designerModels.setPhotoBelakang(designerImg[i][1]);
            designerModels.setDesc(designer[i][0]);
            designerModels.setAlamat(designer[i][2]);
            designerModels.setEmail(designer[i][0]);
            designerModels.setNomer(designer[i][3]);

            listModel.add(designerModels);
        }
        return listModel;
    }
}

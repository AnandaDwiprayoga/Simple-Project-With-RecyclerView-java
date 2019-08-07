package com.example.dicodingtugasakhir.data;

import com.example.dicodingtugasakhir.R;
import com.example.dicodingtugasakhir.models.ClothesModel;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DataClothes {
    private static ArrayList<ClothesModel> list = new ArrayList<>();
    private static int[] gambar = new int[] {R.drawable.produk1,R.drawable.produk2,R.drawable.produk3,R.drawable.produk4,R.drawable.produk5,R.drawable.produk6,R.drawable.produk7,R.drawable.produk8,R.drawable.produk9,R.drawable.produk10,R.drawable.produk11,R.drawable.produk12};
    private static String[][] detailChlotes = new String[][]{
            {"Oui Hoodie" , "IDR 1.500.000","120","Dengan warna putih yang membuat hari hari anda semakin kece. Jacket ini sangat tebal dan nyaman digunakan. cocok digunakan pada musim dingin"},
            {"Black Hoodie", "IDR 2.000.000","50", "Dengan warna hitam pekat cocok untuk anda yang suka gaya simple. Warna jacket ini tidak mudah luntur"},
            {"Pink Jacket", "IDR 800.000", "70", "Untuk wanita yang menyukai warna elegant jacket ini sangat oocok untuk anda. Jacket ini dibuat dengan kain pilihan"},
            {"Black zombie" ,"IDR 500.000", "200", "Kaos ini unisex. Cocok untuk kamu yang suka baju baju metal. Bahan yang digunakan tidak akan membuat badan anda panas"},
            {"Dark Blue Jacket", "IDR 4.500.000","40","Jcket ini unisex. bahan cotton fleece Standar Distro  "},
            {"Clasic Jacket", "IDR 6.000.000", "120", "jaket kulit asli berbahan kulit domba yang memiliki tekstur lembut dan nyaman di gunakan Lentur, lembut, tidak mudah timbul crack atau pecah apabila sering terkena sinar panas UV (Matahari)"},
            {"Tomato Hoodie", "IDR 2.500.000","140","Bahan yang digunakan hoodie ini adalah  Cotton Fleece. Hoodie ini unisex"},
            {"Sweater Grey", "IDR 3.000.000", "200","Bahan Halus & tidak kasar Bahan yang digunakan adalah 100% Cotton Fleece tidak mudah rusak"},
            {"Levi\'s T-shirt", "IDR 2.000.000","300","Kain yang terbuat dari 100% Cotton teksturnya pasti lembut, adem, tidak lengket di kulit karena mudah menyerap keringat Combed 24s bahan yang paling recomended di pakai oleh para Distro terkemuka, karena gramasinya tidak tebal dan juga tidak terlalu tipis."},
            {"Sweater Aloisius" ,"IDR 3.000.000","45", "Bahan tebal, nyaman dipakai, tidak mudah berbulu serta tidak panas dipakai. Cocok untuk santai, kuliah, ngantor hingga hangout bareng temen."},
            {"Red Tomato" ,"IDR 2.000.000","80","Gaun ini kualitas premium dengan bahan 100% Cotton Serat lebih halus dan mudah menyerap keringat dan tidak panas digunakan"},
            {"Bomber Jacket" ,"IDR 4.000.000","166","Jaket ini unisex nyaman digunakan dan tidak panas. Kualitas bahan iternational "}
    };

    public static ArrayList<ClothesModel> getClothes(){
        for (int i = 0; i < gambar.length;i++){
            ClothesModel cm = new ClothesModel();
            cm.setGambar(gambar[i]);
            cm.setNama(detailChlotes[i][0]);
            cm.setHarga(detailChlotes[i][1]);
            cm.setStock(detailChlotes[i][2]);
            cm.setDescClothes(detailChlotes[i][3]);

            int random = ThreadLocalRandom.current().nextInt(0,10+1);
            cm.setPhotoDesigner(DataDesigner.getPhotoDesigner(random));
            cm.setNamaDesigner(DataDesigner.getNamaDesigner(random));
            list.add(cm);
        }
        return list;
    }
}

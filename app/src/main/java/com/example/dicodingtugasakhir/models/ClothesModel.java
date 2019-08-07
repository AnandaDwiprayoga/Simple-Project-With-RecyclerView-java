package com.example.dicodingtugasakhir.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ClothesModel implements Parcelable {
    private int gambar,photoDesigner;
    private String nama,harga , stock, descClothes,namaDesigner;

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public int getPhotoDesigner() {
        return photoDesigner;
    }

    public void setPhotoDesigner(int photoDesigner) {
        this.photoDesigner = photoDesigner;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDescClothes() {
        return descClothes;
    }

    public void setDescClothes(String descClothes) {
        this.descClothes = descClothes;
    }

    public String getNamaDesigner() {
        return namaDesigner;
    }

    public void setNamaDesigner(String namaDesigner) {
        this.namaDesigner = namaDesigner;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.gambar);
        dest.writeInt(this.photoDesigner);
        dest.writeString(this.nama);
        dest.writeString(this.harga);
        dest.writeString(this.stock);
        dest.writeString(this.descClothes);
        dest.writeString(this.namaDesigner);
    }

    public ClothesModel() {
    }

    private ClothesModel(Parcel in) {
        this.gambar = in.readInt();
        this.photoDesigner = in.readInt();
        this.nama = in.readString();
        this.harga = in.readString();
        this.stock = in.readString();
        this.descClothes = in.readString();
        this.namaDesigner = in.readString();
    }

    public static final Parcelable.Creator<ClothesModel> CREATOR = new Parcelable.Creator<ClothesModel>() {
        @Override
        public ClothesModel createFromParcel(Parcel source) {
            return new ClothesModel(source);
        }

        @Override
        public ClothesModel[] newArray(int size) {
            return new ClothesModel[size];
        }
    };
}

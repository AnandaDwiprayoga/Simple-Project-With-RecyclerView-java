package com.example.dicodingtugasakhir.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.concurrent.ThreadLocalRandom;

public class DesignerModels implements Parcelable {
    private String nama, desc, alamat, email, nomer, followers;
    private int photo, photoBelakang;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        desc = desc.trim();
        String[] nama = desc.split(" ");
        String namaPanggilan = nama[0];

        int umur = ThreadLocalRandom.current().nextInt(20, 34+1);

        this.desc = "Hello my name is " + desc + ",you can call me " + namaPanggilan + ", Now i'm " + umur + " years old";
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();
        String[] nama = email.split(" ");

        int randomNomer1 = ThreadLocalRandom.current().nextInt(0, 9);
        int ranomNomer2 = ThreadLocalRandom.current().nextInt(0, 9);
        int ranomNomer3 = ThreadLocalRandom.current().nextInt(0, 9);

        this.email = nama[0] + nama[1] + randomNomer1 + ranomNomer2 + ranomNomer2 + ranomNomer3 + "@gmail.com";
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getPhotoBelakang() {
        return photoBelakang;
    }

    public void setPhotoBelakang(int photoBelakang) {
        this.photoBelakang = photoBelakang;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.desc);
        dest.writeString(this.alamat);
        dest.writeString(this.email);
        dest.writeString(this.nomer);
        dest.writeString(this.followers);
        dest.writeInt(this.photo);
        dest.writeInt(this.photoBelakang);
    }

    public DesignerModels() {
    }

    private DesignerModels(Parcel in) {
        this.nama = in.readString();
        this.desc = in.readString();
        this.alamat = in.readString();
        this.email = in.readString();
        this.nomer = in.readString();
        this.followers = in.readString();
        this.photo = in.readInt();
        this.photoBelakang = in.readInt();
    }

    public static final Parcelable.Creator<DesignerModels> CREATOR = new Parcelable.Creator<DesignerModels>() {
        @Override
        public DesignerModels createFromParcel(Parcel source) {
            return new DesignerModels(source);
        }

        @Override
        public DesignerModels[] newArray(int size) {
            return new DesignerModels[size];
        }
    };
}

package com.fakhrunnisaa.pmob_1.room;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User{

    @PrimaryKey()
    @NonNull
    private String nim;
    private String nama;
    private String password ;

    public User(String nim, String nama, String password) {
        this.nim = nim;
        this.nama = nama;
        this.password = password;
    }

    @NonNull
    public String getNim() {
        return nim;
    }

    public void setNim(@NonNull String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "nim =" + nim +
                ", Nama='" + nama + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


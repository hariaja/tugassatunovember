package com.kelompoktiga.tugaspertemuantiga.model;

import com.google.gson.annotations.SerializedName;

public class GolonganBarang {

  @SerializedName("kode_barang")
  private String kode_barang;
  @SerializedName("nama_barang")
  private String nama_barang;
  @SerializedName("barang_golongan")
  private String golongan_barang;

  public GolonganBarang(String kode_barang, String nama_barang, String golongan_barang) {
    this.kode_barang = kode_barang;
    this.nama_barang = nama_barang;
    this.golongan_barang = golongan_barang;
  }

  public String getKode_barang() {
    return kode_barang;
  }

  public void setKode_barang(String kode_barang) {
    this.kode_barang = kode_barang;
  }

  public String getNama_barang() {
    return nama_barang;
  }

  public void setNama_barang(String nama_barang) {
    this.nama_barang = nama_barang;
  }

  public String getGolongan_barang() {
    return golongan_barang;
  }

  public void setGolongan_barang(String golongan_barang) {
    this.golongan_barang = golongan_barang;
  }

  @Override
  public String toString() {
    return "semuabarang{" +
        "kode_barang = '" + kode_barang + '\'' +
        ",nama_barang = '" + nama_barang + '\'' +
        ",barang_golongan = '" + golongan_barang + '\'' +
        "}";
  }
}

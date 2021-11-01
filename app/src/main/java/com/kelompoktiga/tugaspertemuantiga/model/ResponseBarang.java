package com.kelompoktiga.tugaspertemuantiga.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBarang {
  @SerializedName("semuabarang")
  private List<SemuaBarang> semuabarang;

  @SerializedName("semuagolonganbarang")
  private List<GolonganBarang> golonganBarangs;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public ResponseBarang(List<SemuaBarang> semuabarang, List<GolonganBarang> golonganBarangs, boolean error, String message) {
    this.semuabarang = semuabarang;
    this.golonganBarangs = golonganBarangs;
    this.error = error;
    this.message = message;
  }

  public List<SemuaBarang> getSemuabarang() {
    return semuabarang;
  }

  public void setSemuabarang(List<SemuaBarang> semuabarang) {
    this.semuabarang = semuabarang;
  }

  public List<GolonganBarang> getGolonganBarangs() {
    return golonganBarangs;
  }

  public void setGolonganBarangs(List<GolonganBarang> golonganBarangs) {
    this.golonganBarangs = golonganBarangs;
  }

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString(){
    return "ResponseBarang{" +
        "semuabarang = '" + semuabarang + '\'' +
        "semuagolongan = '" + golonganBarangs + '\'' +
        ",error = '" + error + '\'' +
        ",message = '" + message + '\'' +
        "}";
  }
}

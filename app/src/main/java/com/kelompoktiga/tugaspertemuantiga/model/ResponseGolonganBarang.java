package com.kelompoktiga.tugaspertemuantiga.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGolonganBarang {
  @SerializedName("semuabarang")
  private List<GolonganBarang> golonganBarangs;

  @SerializedName("error")
  private boolean error;

  @SerializedName("message")
  private String message;

  public ResponseGolonganBarang(List<GolonganBarang> golonganBarangs, boolean error, String message) {
    this.golonganBarangs = golonganBarangs;
    this.error = error;
    this.message = message;
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
        "semuabrang = '" + golonganBarangs + '\'' +
        ",error = '" + error + '\'' +
        ",message = '" + message + '\'' +
        "}";
  }
}

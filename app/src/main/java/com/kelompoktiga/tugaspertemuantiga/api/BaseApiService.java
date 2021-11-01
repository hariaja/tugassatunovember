package com.kelompoktiga.tugaspertemuantiga.api;

import com.kelompoktiga.tugaspertemuantiga.model.ResponseBarang;
import com.kelompoktiga.tugaspertemuantiga.model.ResponseGolonganBarang;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {
  @GET("barang")
  Call<ResponseBarang> fetchemuabarang();

  @GET("barang_golongan")
  Call<ResponseGolonganBarang> fetchgolonganBarang();
}

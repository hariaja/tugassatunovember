package com.kelompoktiga.tugaspertemuantiga;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kelompoktiga.tugaspertemuantiga.adapter.BarangAdapter;
import com.kelompoktiga.tugaspertemuantiga.api.RetrofitClient;
import com.kelompoktiga.tugaspertemuantiga.model.ResponseBarang;
import com.kelompoktiga.tugaspertemuantiga.model.SemuaBarang;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SemuaDataFragment extends Fragment {

  RecyclerView recyclerView;
  List<SemuaBarang> barangList;

  public SemuaDataFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_semua_data, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recyclerView = view.findViewById(R.id.recyclerview);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    // retrofit
    Call<ResponseBarang> call = RetrofitClient.getInstance().getApi().fetchemuabarang();
    call.enqueue(new Callback<ResponseBarang>() {
      @Override
      public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
        if (response.isSuccessful()) {
          barangList = response.body().getSemuabarang();
          recyclerView.setAdapter(new BarangAdapter(getActivity(), barangList));
        }
        else {
          Toast.makeText(getActivity(), response.body().getMessage(),Toast.LENGTH_SHORT).show();
        }
       }

      @Override
      public void onFailure(Call<ResponseBarang> call, Throwable t) {
        Toast.makeText(getActivity(),t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
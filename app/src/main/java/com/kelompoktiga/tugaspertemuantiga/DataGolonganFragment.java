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

import com.kelompoktiga.tugaspertemuantiga.adapter.GolonganBarangAdapter;
import com.kelompoktiga.tugaspertemuantiga.api.RetrofitClient;
import com.kelompoktiga.tugaspertemuantiga.model.GolonganBarang;
import com.kelompoktiga.tugaspertemuantiga.model.ResponseGolonganBarang;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataGolonganFragment extends Fragment {

  RecyclerView recyclerView;
  List<GolonganBarang> golonganBarangs;

  public DataGolonganFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_data_golongan, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recyclerView = view.findViewById(R.id.recyclerviewGolongan);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    Call<ResponseGolonganBarang> call = RetrofitClient.getInstance().getApi().fetchgolonganBarang();
    call.enqueue(new Callback<ResponseGolonganBarang>() {
      @Override
      public void onResponse(Call<ResponseGolonganBarang> call, Response<ResponseGolonganBarang> response) {
        if (response.isSuccessful()) {
          golonganBarangs = response.body().getGolonganBarangs();
          recyclerView.setAdapter(new GolonganBarangAdapter(getActivity(), golonganBarangs));
        }
        else {
          Toast.makeText(getActivity(), response.body().getMessage(),Toast.LENGTH_SHORT).show();
        }
      }
      @Override
      public void onFailure(Call<ResponseGolonganBarang> call, Throwable t) {
        Toast.makeText(getActivity(),t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
    }
  }
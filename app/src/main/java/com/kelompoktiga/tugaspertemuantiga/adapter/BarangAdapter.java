package com.kelompoktiga.tugaspertemuantiga.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompoktiga.tugaspertemuantiga.R;
import com.kelompoktiga.tugaspertemuantiga.model.SemuaBarang;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangHolder>{

  List<SemuaBarang> barangList;
  Context context;

  public BarangAdapter(Context context, List<SemuaBarang> barangList) {
    this.context = context;
    this.barangList = barangList;
  }

  @NonNull
  @Override
  public BarangAdapter.BarangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_semua_data, parent,false);
    return new BarangHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull BarangAdapter.BarangHolder holder, int position) {
    holder.txtnama.setText(barangList.get(position).getNama_barang());
    holder.txtkode.setText(barangList.get(position).getKode_barang());
  }

  @Override
  public int getItemCount() {
    return barangList.size();
  }

  public class BarangHolder extends RecyclerView.ViewHolder {
    TextView txtkode, txtnama;
    public BarangHolder(@NonNull View itemView) {
      super(itemView);
      txtnama = itemView.findViewById(R.id.tvNamaBarang);
      txtkode = itemView.findViewById(R.id.tvKodeBarang);
    }
  }
}

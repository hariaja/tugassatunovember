package com.kelompoktiga.tugaspertemuantiga.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompoktiga.tugaspertemuantiga.R;
import com.kelompoktiga.tugaspertemuantiga.model.GolonganBarang;

import java.util.List;

public class GolonganBarangAdapter extends RecyclerView.Adapter<GolonganBarangAdapter.GolonganBarangHolder>{

  List<GolonganBarang> golonganBarangs;
  Context context;

  public GolonganBarangAdapter(Context context, List<GolonganBarang> golonganBarangs) {
    this.golonganBarangs = golonganBarangs;
    this.context = context;
  }

  @NonNull
  @Override
  public GolonganBarangAdapter.GolonganBarangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_golongan_barang, parent, false);
    return new GolonganBarangHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull GolonganBarangAdapter.GolonganBarangHolder holder, int position) {
    holder.txtNama.setText(golonganBarangs.get(position).getNama_barang());
    holder.txtKode.setText(golonganBarangs.get(position).getKode_barang());
    holder.txtGolongan.setText(golonganBarangs.get(position).getGolongan_barang());
  }

  @Override
  public int getItemCount() {
    return golonganBarangs.size();
  }
  
  public class GolonganBarangHolder extends RecyclerView.ViewHolder{
    TextView txtKode, txtNama, txtGolongan;
    public GolonganBarangHolder(@NonNull View itemView) {
      super(itemView);
      txtKode = itemView.findViewById(R.id.tvKodeBarang);
      txtNama = itemView.findViewById(R.id.tvNamaBarang);
      txtGolongan = itemView.findViewById(R.id.tvNamaGolongan);
    }
  }
}

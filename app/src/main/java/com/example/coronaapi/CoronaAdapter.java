package com.example.coronaapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronaapi.model.CountriesItem;

import java.util.List;

public class CoronaAdapter extends RecyclerView.Adapter<CoronaAdapter.ViewHolder> {
    List<CountriesItem> Items;
    Context context;

    public CoronaAdapter(List<CountriesItem> items, Context context) {
        Items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CountriesItem item = Items.get(position);
        holder.tvCountyName.setText(item.getCountry());
        holder.tvConfirmed.setText(String.valueOf(item.getTotalConfirmed()));
        holder.tvDeaths.setText(String.valueOf(item.getTotalDeaths()));
        holder.tvRecovered.setText(String.valueOf(item.getTotalRecovered()));
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountyName, tvConfirmed, tvDeaths, tvRecovered;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountyName = itemView.findViewById(R.id.country_name);
            tvConfirmed = itemView.findViewById(R.id.confirmed_value);
            tvDeaths = itemView.findViewById(R.id.deaths_value);
            tvRecovered = itemView.findViewById(R.id.recovery_value);
        }
    }
}

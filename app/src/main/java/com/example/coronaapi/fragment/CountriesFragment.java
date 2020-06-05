package com.example.coronaapi.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coronaapi.CoronaAdapter;
import com.example.coronaapi.CoronaListener;
import com.example.coronaapi.R;
import com.example.coronaapi.model.CountriesItem;
import com.example.coronaapi.model.Global;
import com.example.coronaapi.service.CoronaService;

import java.util.List;

public class CountriesFragment extends Fragment {

    public CountriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false);
    }

    RecyclerView rvRecyclerView;
    TextView tvDate;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvRecyclerView = view.findViewById(R.id.rv_recyclerview);
        tvDate = view.findViewById(R.id.dates);
        new CoronaService().getCountries(CountryListener);

    }

    CoronaListener<List<CountriesItem>> CountryListener = new CoronaListener<List<CountriesItem>>() {
        @Override
        public void onSuccess(List<CountriesItem> items) {
            String value = String.valueOf(items.get(0).getDate());
            String month;
            int checkMonth = Integer.parseInt(value.substring(5,7));
            switch (checkMonth){
                case 1 : month = "January"; break;
                case 2 : month = "February"; break;
                case 3 : month = "March"; break;
                case 4 : month = "April"; break;
                case 5 : month = "May"; break;
                case 6 : month = "June"; break;
                case 7 : month = "July"; break;
                case 8 : month = "August"; break;
                case 9 : month = "September"; break;
                case 10 : month = "October"; break;
                case 11 : month = "November"; break;
                case 12 : month = "December"; break;
                default: month = "Month";
            }
            String date = "Last Update : " + value.substring(8,10) + " " + month + " " + value.substring(0,4);
            tvDate.setText(date);

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvRecyclerView.setLayoutManager(linearLayoutManager);
            rvRecyclerView.setAdapter(new CoronaAdapter(items,getContext()));
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);
        }
    };
}
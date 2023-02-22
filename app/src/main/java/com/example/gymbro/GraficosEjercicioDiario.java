package com.example.gymbro;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gymbro.databinding.FragmentGraficosEjercicioDiarioBinding;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class GraficosEjercicioDiario extends Fragment {

    private FragmentGraficosEjercicioDiarioBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentGraficosEjercicioDiarioBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PieChart mPieChart = (PieChart) view.findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("% Movimiento / KCAL", 99, Color.parseColor("#ff004c")));
        mPieChart.addPieSlice(new PieModel("% Ejercicio / MIN", 137 , Color.parseColor("#62fc03")));
        mPieChart.addPieSlice(new PieModel("% De pie / HORAS", 110, Color.parseColor("#FF03DAC5")));

        mPieChart.startAnimation();
    }
}
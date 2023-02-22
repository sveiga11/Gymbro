package com.example.gymbro;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gymbro.databinding.FragmentGraficosActividadSemanalBinding;
import com.example.gymbro.databinding.FragmentGraficosEjercicioDiarioBinding;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

public class GraficosActividadSemanal extends Fragment {

    private FragmentGraficosActividadSemanalBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentGraficosActividadSemanalBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Grafico seccion De pie
        ValueLineChart mCubicValueLineChart = (ValueLineChart) view.findViewById(R.id.cubiclinechart);

        ValueLineSeries series = new ValueLineSeries();
        series.setColor(0xFF03DAC5);

        series.addPoint(new ValueLinePoint(" ", 0));
        series.addPoint(new ValueLinePoint("L", 14));
        series.addPoint(new ValueLinePoint("M", 15));
        series.addPoint(new ValueLinePoint("X", 11));
        series.addPoint(new ValueLinePoint("J", 13));
        series.addPoint(new ValueLinePoint("V", 15));
        series.addPoint(new ValueLinePoint("S", 19));
        series.addPoint(new ValueLinePoint("D", 9));
        series.addPoint(new ValueLinePoint(" ", 0));


        mCubicValueLineChart.addSeries(series);
        mCubicValueLineChart.startAnimation();

        //Grafico Ejercicio
        BarChart mBarChartEjercicio = (BarChart) view.findViewById(R.id.barchartEjercicio);

        mBarChartEjercicio.addBar(new BarModel("L",136, 0xFF62FC03));
        mBarChartEjercicio.addBar(new BarModel("M", 99,  0xFF62FC03));
        mBarChartEjercicio.addBar(new BarModel("X", 188, 0xFF62FC03));
        mBarChartEjercicio.addBar(new BarModel("J", 167, 0xFF62FC03));
        mBarChartEjercicio.addBar(new BarModel("V", 132, 0xFF62FC03));
        mBarChartEjercicio.addBar(new BarModel("S", 112,  0xFF62FC03));
        mBarChartEjercicio.addBar(new BarModel("D", 12, 0xFF62FC03));


        mBarChartEjercicio.startAnimation();

        //Grafcio Actividad
        BarChart mBarChartActividad = (BarChart) view.findViewById(R.id.barchartActividad);

        mBarChartActividad.addBar(new BarModel("L",1105, 0xFFFF004C));
        mBarChartActividad.addBar(new BarModel("M", 967,  0xFFFF004C));
        mBarChartActividad.addBar(new BarModel("X", 1270, 0xFFFF004C));
        mBarChartActividad.addBar(new BarModel("J", 1112, 0xFFFF004C));
        mBarChartActividad.addBar(new BarModel("V", 865, 0xFFFF004C));
        mBarChartActividad.addBar(new BarModel("S", 791,  0xFFFF004C));
        mBarChartActividad.addBar(new BarModel("D", 508, 0xFFFF004C));


        mBarChartActividad.startAnimation();
    }
}
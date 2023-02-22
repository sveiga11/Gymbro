package com.example.gymbro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.gymbro.databinding.FragmentMostrarEjerciciosBinding;

public class mostrarEjercicios extends Fragment {

    private FragmentMostrarEjerciciosBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMostrarEjerciciosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EjerciciosViewModel ejerciciosViewModel = new ViewModelProvider(requireActivity()).get(EjerciciosViewModel.class);

        ejerciciosViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Ejercicio>() {
            @Override
            public void onChanged(Ejercicio ejercicio) {
                binding.nombre.setText(ejercicio.nombre);
                binding.descripcion.setText(ejercicio.descripcion);
                binding.zona.setText(ejercicio.zona);
                binding.imagenEjercicio.setImageResource(ejercicio.imagenEjercicio);
                binding.imagenPortada.setImageResource(ejercicio.imagenPortada);

            }
        });
    }
}
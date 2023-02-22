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

import com.example.gymbro.databinding.FragmentCalculadoraMasaBinding;

public class CalculadoraMasa extends Fragment {
    private FragmentCalculadoraMasaBinding binding;
    private float peso;
    private int estatura;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCalculadoraMasaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final IMCViewModel imcViewModel = new ViewModelProvider(this).get(IMCViewModel.class);

        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean error = false;

                try {

                    peso = Float.parseFloat(binding.peso.getText().toString());
                } catch (Exception e){
                    binding.peso.setError("Debe introducir un valor. Ejemplo: 68.5");
                    error = true;
                }

                try {

                    estatura = Integer.parseInt(binding.estatura.getText().toString());
                } catch (Exception e){
                    binding.estatura.setError("Debe introducir un valor. Ejemplo: 172");
                    error = true;
                }

                if (!error){
                    imcViewModel.calcular(peso, estatura);
                }
            }
        });

        imcViewModel.imc.observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double imc) {
                binding.imc.setText(String.format("%.2f",imc));
            }
        });

        imcViewModel.errorPeso.observe(getViewLifecycleOwner(), new Observer<Float>() {
            @Override
            public void onChanged(Float pesoMinimo) {
                if (pesoMinimo != null) {
                    binding.peso.setError("El peso introducido no puede ser menor de " + pesoMinimo + " KG");
                } else {
                    binding.peso.setError(null);
                }
            }
        });

        imcViewModel.errorEstatura.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer estaturaMinimo) {
                if (estaturaMinimo != null) {
                    binding.estatura.setError("La estatura introducida no puede ser inferior a " + estaturaMinimo + " CM");
                } else {
                    binding.estatura.setError(null);
                }
            }
        });
        imcViewModel.calculando.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean calculando) {
                if (calculando) {
                    binding.calculando.setVisibility(View.VISIBLE);
                    binding.imc.setVisibility(View.GONE);
                } else {
                    binding.calculando.setVisibility(View.GONE);
                    binding.imc.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
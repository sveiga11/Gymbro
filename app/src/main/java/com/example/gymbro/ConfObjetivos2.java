package com.example.gymbro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gymbro.databinding.FragmentConfObjetivos1Binding;
import com.example.gymbro.databinding.FragmentConfObjetivos2Binding;

public class ConfObjetivos2 extends Fragment {

    int contador = 30;

    NavController navController;
    private FragmentConfObjetivos2Binding binding;

    TextView num;
    ImageButton botonMas, botonMenos, botonAtras, botonSiguiente;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentConfObjetivos2Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        num = view.findViewById(R.id.num);
        botonMenos = view.findViewById(R.id.botonMenos);
        botonMas = view.findViewById(R.id.botonMas);
        botonAtras = view.findViewById(R.id.botonAtras);
        botonSiguiente = view.findViewById(R.id.botonSiguiente);

        botonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (contador > 0){
                    contador = contador - 5;
                    num.setText("" + contador);
                } else {
                    contador = 0;
                    num.setText("" + contador);
                }
            }
        });
        botonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador = contador + 5;
                num.setText("" + contador);
            }
        });
        botonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_confObjetivos2_to_confObjetivos1);
            }
        });
        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_confObjetivos2_to_confObjetivos3);
            }
        });
    }
}
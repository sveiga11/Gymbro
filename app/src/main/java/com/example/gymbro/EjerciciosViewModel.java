package com.example.gymbro;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class EjerciciosViewModel extends AndroidViewModel {
    EjerciciosRepositorio ejerciciosRepositorio;

    MutableLiveData<List<Ejercicio>> listEjerciciosMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Ejercicio> ejercicioSeleccionado = new MutableLiveData<>();

    public EjerciciosViewModel(@NonNull Application application) {
        super(application);

        ejerciciosRepositorio = new EjerciciosRepositorio();

        listEjerciciosMutableLiveData.setValue(ejerciciosRepositorio.obtener());
    }


    MutableLiveData<List<Ejercicio>> obtener(){
        return listEjerciciosMutableLiveData;
    }

    void insertar(Ejercicio ejercicio){
        ejerciciosRepositorio.insertar(ejercicio, new EjerciciosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Ejercicio> ejercicios) {
                listEjerciciosMutableLiveData.setValue(ejercicios);
            }
        });
    }

    void eliminar(Ejercicio ejercicio){
        ejerciciosRepositorio.eliminar(ejercicio, new EjerciciosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Ejercicio> ejercicios) {
                listEjerciciosMutableLiveData.setValue(ejercicios);
            }
        });
    }

    void actualizar(Ejercicio ejercicio, float valoracion){
        ejerciciosRepositorio.actualizar(ejercicio, valoracion, new EjerciciosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Ejercicio> ejercicios) {
                listEjerciciosMutableLiveData.setValue(ejercicios);
            }
        });
    }


    void seleccionar(Ejercicio ejercicio){
        ejercicioSeleccionado.setValue(ejercicio);
    }

    MutableLiveData<Ejercicio> seleccionado(){
        return ejercicioSeleccionado;
    }
}

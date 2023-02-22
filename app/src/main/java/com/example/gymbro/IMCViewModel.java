package com.example.gymbro;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class IMCViewModel extends AndroidViewModel {
    Executor executor;

    SimuladorIMC simuladorIMC;

    MutableLiveData<Double> imc = new MutableLiveData<>();
    MutableLiveData<Float> errorPeso = new MutableLiveData<>();
    MutableLiveData<Integer> errorEstatura = new MutableLiveData<>();
    MutableLiveData<Boolean> calculando = new MutableLiveData<>();

    public IMCViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simuladorIMC = new SimuladorIMC();
    }



    public void calcular(float peso, int estatura) {

        final SimuladorIMC.Solicitud solicitud = new SimuladorIMC.Solicitud(peso, estatura);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                simuladorIMC.calcular(solicitud, new SimuladorIMC.Callback() {
                    @Override
                    public void cuandoEsteCalculadoElIMC(double IMCResultante) {
                        errorPeso.postValue(null);
                        errorEstatura.postValue(null);
                        imc.postValue(IMCResultante);
                    }

                    @Override
                    public void cuandoHayaErrorDePesoInferiorAlMinimo(float pesoMinimo) {
                        errorPeso.postValue(pesoMinimo);
                    }

                    @Override
                    public void cuandoHayaErrorDeEstaturaInferiorAlMinimo(int estaturaMinimo) {
                        errorEstatura.postValue(estaturaMinimo);
                    }
                    @Override
                    public void cuandoEmpieceElCalculo() {
                        calculando.postValue(true);
                    }

                    @Override
                    public void cuandoFinaliceElCalculo() {
                        calculando.postValue(false);
                    }
                });
            }
        });
    }
}

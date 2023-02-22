package com.example.gymbro;

public class SimuladorIMC {

        public static class Solicitud {
            public float peso;
            public int estatura;

            public Solicitud(float peso, int estatura) {
                this.peso = peso;
                this.estatura = estatura;
            }
        }

        interface Callback {
            void cuandoEsteCalculadoElIMC(double imc);
            void cuandoHayaErrorDePesoInferiorAlMinimo(float pesoMinimo);
            void cuandoHayaErrorDeEstaturaInferiorAlMinimo(int estaturaMinimo);

            void cuandoEmpieceElCalculo();
            void cuandoFinaliceElCalculo();
        }

        public void calcular(Solicitud solicitud, Callback callback) {

            callback.cuandoEmpieceElCalculo();

            float pesoMinimo = 0;
            int estaturaMinimo = 0;

            double numero = 2;
            double elevado = Math.pow(solicitud.estatura/100.f, numero);

            try {
                Thread.sleep(5000);   // simular operacion de larga duracion (5s)
                pesoMinimo = 40.0f;
                estaturaMinimo = 140;
            } catch (InterruptedException e) {}

            boolean error = false;

            if (solicitud.peso < pesoMinimo) {
                callback.cuandoHayaErrorDePesoInferiorAlMinimo(pesoMinimo);
                error = true;
            }

            if (solicitud.estatura < estaturaMinimo) {
                callback.cuandoHayaErrorDeEstaturaInferiorAlMinimo(estaturaMinimo);
                error = true;
            }

            if(!error) {
                callback.cuandoEsteCalculadoElIMC(solicitud.peso/elevado);
            }

            callback.cuandoFinaliceElCalculo();

        }
}

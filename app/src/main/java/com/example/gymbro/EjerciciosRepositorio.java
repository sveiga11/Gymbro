package com.example.gymbro;

import java.util.ArrayList;
import java.util.List;

public class EjerciciosRepositorio {

    List<Ejercicio> ejercicios = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Ejercicio> elementos);
    }

    EjerciciosRepositorio(){
        ejercicios.add(new Ejercicio("Press Banca", "El press de banca, press de pecho, fuerza en banco, fuerza acostado o press banca, es un ejercicio de peso libre que trabaja principalmente la zona superior del cuerpo.\n" +
                "\n" +
                "Este ejercicio físico es uno de los tres realizados en powerlifting (peso muerto, sentadillas, y press de banca), y también se utiliza en el culturismo como un ejercicio para el pecho, (principalmente músculos pectorales) el tríceps y el fascículo anterior del deltoides. El levantador se tumba sobre su espalda en un banco, levantando y bajando la barra directamente por encima del pecho. Está pensado para el desarrollo de los músculos del pecho, los deltoides anterior y los serratos anteriores, existe una variación para el tríceps, denominado press francés. En este ejercicio hay muchas variantes: en el ángulo de la banca, pudiendo realizarse en un banco horizontal, declinado o inclinado; y también con el equipamiento utilizado, pudiendo hacerse con barra, mancuernas o máquina Smith.", "Pecho", R.drawable.pectorales

        , R.drawable.pecho2));

        ejercicios.add(new Ejercicio("Curl Biceps", "Curl de bíceps son los ejercicios que implican la ejercitación de dicho músculo. Como el bíceps trabaja en el giro de muñeca o contracción del brazo, es fácil inducir que los diferentes tipos de curls incluyan flexiones de brazos así como giros de muñeca.", "Biceps", R.drawable.biceps, R.drawable.biceps2));

        ejercicios.add(new Ejercicio("Press Militar", "El press de hombros (también llamado ''press militar'') es un ejercicio de entrenamiento con pesas para la parte superior del cuerpo en el que el aprendiz presiona un peso por encima de la cabeza mientras está sentado o de pie. Se utiliza principalmente para desarrollar los músculos deltoides anteriores del hombro.  La versión de pie fue una vez un componente del deporte del levantamiento de pesas olímpico como parte del movimiento de carga y presión , pero se eliminó en 1972 debido a dificultades para juzgar la técnica adecuada.", "Hombro", R.drawable.hombro, R.drawable.hombro2));

        ejercicios.add(new Ejercicio("Extension de cuadriceps","La Extensión de cuadriceps es un tipo de entrenamiento con pesas de aislamiento cuyo músculo objetivo es el entrenamiento del cuádriceps de la pierna. Este es el músculo más potente y voluminoso de toda la pierna, ocupando casi un tercio de su volumen. Es el que soporta el peso del cuerpo y permite la función de andar. Se denomina cuádriceps debido a que tiene cuatro cabezas musculares. Se encuentra en la cara anterior del fémur.", "Cuadriceps", R.drawable.cuadriceps, R.drawable.cuadriceps2));

        ejercicios.add(new Ejercicio("Curl de femoral","El curl femoral tumbado es un tipo de entrenamiento con pesas de aislamiento cuyo músculo-objetivo es el entrenamiento del femoral de la pierna (músculos de la parte posterior de los muslos, denominados también isquiotibiales). Este ejercicio se suele complementar con la extensión de pierna.", "Femorales", R.drawable.pierna, R.drawable.femoral2));

        ejercicios.add(new Ejercicio("Remo","Remar es un ejercicio en el que se involucra todo el cuerpo. Requiere un esfuerzo muscular por parte de las piernas, los glúteos, la parte baja y alta de la espalda, los hombros, los brazos y el torso. Hacer remo es una forma muy eficiente de entrenar, ya que pone a trabajar simultáneamente muchos músculos. Esto permite ejercitar todo el cuerpo en unperiodo de tiempo relativamente corto. Implica, además, un gasto de calorías muy alto. Por esta razón, hacer remo es una gran manera de mejorar la composición corporal a través la reducción de grasa y el adelgazamiento.", "Espalda", R.drawable.lats, R.drawable.espalda2));

        ejercicios.add(new Ejercicio("Press frances","El press francés o español, es un ejercicio de fuerza utilizado de muchas formas diferentes de levantamiento de pesas. Es uno de los ejercicios más estimulantes para todo el grupo muscular del tríceps, en la parte superior del brazo. Se trabaja los tríceps del codo y todo el recorrido hasta el músculo dorsal ancho. Debido a su pleno uso del grupo muscular del tríceps, las extensiones de tríceps son utilizados por muchos como parte de su régimen de entrenamiento.", "Triceps", R.drawable.triceps, R.drawable.triceps2));

        ejercicios.add(new Ejercicio("Hip trust","El hip thrust es un movimiento de empuje de cadera en el que los músculos con una mayor implicación son el glúteo mayor y el glúteo medio. Además, a través de este ejercicio de empuje también trabajamos tanto los cuádriceps como los isquiosurales, mientras que la musculatura de nuestra zona central o core nos ayuda a mantener una buena postura y a elevar la espalda.\n" +
                "\n" +
                "Comparado con otros ejercicios que tradicionalmente se han utilizado para trabajar los glúteos, como la sentadilla con barra trasera o la sentadilla con barra hexagonal, el hip thrust ha demostrado una mayor activación de la musculatura del glúteo a través de la EMG (electromiografía: un método que se utiliza para poder conocer la activación neuromuscular).", "Gluteo", R.drawable.gluteo, R.drawable.gluteo2));

        ejercicios.add(new Ejercicio("Encogimiento","El encogimiento de hombros es un ejercicio destinado a trabajar la zona del trapecio. Es un ejercicio necesario para mantener fuerte toda esta zona y así evitar futuras lesiones. Con un trapecio fortalecido estarás predispuesto a realizar otros ejercicios con mayor facilidad y con una mayor carga.\n" +
                "\n" +
                "Para realizar este ejercicio de un modo correcto, es necesario utilizar tensores que ejerzan un poco de peso para dificultar el ejercicio. Hacerlo sin peso no supondría ningún tipo de beneficio, recuerda que la intención es muscular el trapecio.", "Trapecio", R.drawable.trapecio, R.drawable.trapecio2));

        ejercicios.add(new Ejercicio("Felxiones de muñeca","Sentado en un banco con una mancuerna, apoyamos el brazo en el muslo con la palma hacia arriba y flexionamos la muñeca arriba y abajo ralentizando el movimiento tanto como podamos. También se puede realizar con la palma hacia abajo, pero con mucho menos peso para no hacerte daño con cada repetición. Busca más peso con el primer movimiento, y menos y más repeticiones con el segundo.", "Antebrazo", R.drawable.brazo, R.drawable.antebrazo2));
    }

    List<Ejercicio> obtener() {
        return ejercicios;
    }

    void insertar(Ejercicio ejercicio, Callback callback){
        ejercicios.add(ejercicio);
        callback.cuandoFinalice(ejercicios);
    }

    void eliminar(Ejercicio ejercicio, Callback callback) {
        ejercicios.remove(ejercicio);
        callback.cuandoFinalice(ejercicios);
    }

    void actualizar(Ejercicio ejercicio, float valoracion, Callback callback) {
        ejercicio.valoracion = valoracion;
        callback.cuandoFinalice(ejercicios);
    }
}


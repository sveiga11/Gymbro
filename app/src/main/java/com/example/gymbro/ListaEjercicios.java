package com.example.gymbro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.gymbro.databinding.FragmentListaEjerciciosBinding;
import com.example.gymbro.databinding.ViewholderEjercicioBinding;

import java.util.List;


public class ListaEjercicios extends Fragment {

    private FragmentListaEjerciciosBinding binding;
    private EjerciciosViewModel ejerciciosViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListaEjerciciosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ejerciciosViewModel = new ViewModelProvider(requireActivity()).get(EjerciciosViewModel.class);
        navController = Navigation.findNavController(view);

        /*binding.irANuevoElemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEjercicios_to_nuevoEjercicio);
            }
        });*/

        EjerciciosAdapter ejerciciosAdapter = new EjerciciosAdapter();

        binding.recyclerView.setAdapter(ejerciciosAdapter);

        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT  | ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int posicion = viewHolder.getAdapterPosition();
                Ejercicio ejercicio = ejerciciosAdapter.obtenerEjercicio(posicion);
                ejerciciosViewModel.eliminar(ejercicio);

            }
        }).attachToRecyclerView(binding.recyclerView);

        ejerciciosViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Ejercicio>>() {
            @Override
            public void onChanged(List<Ejercicio> ejercicios) {
                ejerciciosAdapter.establecerLista(ejercicios);
            }
        });
    }

    class EjerciciosAdapter extends RecyclerView.Adapter<EjercicioViewHolder> {

        List<Ejercicio> ejercicios;

        @NonNull
        @Override
        public EjercicioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EjercicioViewHolder(ViewholderEjercicioBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull EjercicioViewHolder holder, int position) {

            Ejercicio ejercicio = ejercicios.get(position);

            holder.binding.nombre.setText(ejercicio.nombre);
            holder.binding.zona.setText(ejercicio.zona);
            holder.binding.imagenEjercicio.setImageResource(ejercicio.imagenEjercicio);

//            holder.binding.valoracion.setRating(ejercicio.valoracion);

            /*holder.binding.valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if(fromUser) {
                        ejerciciosViewModel.actualizar(ejercicio, rating);
                    }
                }
            });*/

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ejerciciosViewModel.seleccionar(ejercicio);
                    navController.navigate(R.id.action_listaEjercicios_to_mostrarEjercicios);
                }
            });
        }

        @Override
        public int getItemCount() {
            return ejercicios != null ? ejercicios.size() : 0;
        }

        public void establecerLista(List<Ejercicio> ejercicios){
            this.ejercicios = ejercicios;
            notifyDataSetChanged();
        }

        public Ejercicio obtenerEjercicio(int posicion){
            return ejercicios.get(posicion);
        }
    }

    static class EjercicioViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderEjercicioBinding binding;

        public EjercicioViewHolder(ViewholderEjercicioBinding    binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
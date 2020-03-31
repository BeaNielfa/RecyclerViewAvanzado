package com.example.recyclerviewavanzado;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;


public class AnimalFragment extends Fragment {

   OnAnimalesInteractionListener mListener;
   List<Animales> animalesList;

    public AnimalFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            animalesList = new ArrayList<>();
            animalesList.add(new Animales("Aquiles","Marrón","https://misanimales.com/wp-content/uploads/2019/10/perros-arrugas.jpg","Shar pei"));
            animalesList.add(new Animales("Dana", "Negro","https://d2devwt40at1e2.cloudfront.net/api/file/wSXTJACZT2i7mTZoESYA/convert?width=600&fit=max&quality=80","Salchica"));
            animalesList.add(new Animales("Titan","Marrón","https://www.hola.com/imagenes/estar-bien/20191004150785/pastor-aleman-raza-de-perro-caracteristicas/0-728-57/raza-de-perro-pastor-aleman-m.jpg","Pastor Aleman"));
            animalesList.add(new Animales("Layka","Blanco y Negro" ,"https://www.petclic.es/wikipets/wp-content/uploads/sites/default/files/library/dalmata_-_razas_de_perro.jpg","Dalmata"));


            recyclerView.setAdapter(new MyAnimalRecyclerViewAdapter(getActivity(),animalesList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAnimalesInteractionListener) {
            mListener = (OnAnimalesInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}

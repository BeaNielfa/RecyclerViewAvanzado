package com.example.recyclerviewavanzado;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;


public class MyAnimalRecyclerViewAdapter extends RecyclerView.Adapter<MyAnimalRecyclerViewAdapter.ViewHolder> {

    private final List<Animales> mValues;
    private final OnAnimalesInteractionListener mListener;
    private Context ctx;
    public MyAnimalRecyclerViewAdapter(Context context,List<Animales> items, OnAnimalesInteractionListener listener) {
        mValues = items;
        mListener = listener;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.animal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.txtNombre.setText(holder.mItem.getNombre());
        holder.txtColor.setText(holder.mItem.getColor());
        holder.txtRaza.setText(holder.mItem.getRaza());

        Glide.with(ctx)
                .load(holder.mItem.getUrlFoto())
                .into(holder.imgFoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onAnimalClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtNombre;
        public final TextView txtRaza;
        public final TextView txtColor;
        public final ImageView imgFoto;
        public Animales mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtNombre = (TextView) view.findViewById(R.id.textViewNombre);
            txtColor = (TextView) view.findViewById(R.id.textViewColor);
            txtRaza = (TextView) view.findViewById(R.id.textViewRaza);
            imgFoto = (ImageView) view.findViewById(R.id.imageViewFoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtNombre.getText() + "'";
        }
    }
}

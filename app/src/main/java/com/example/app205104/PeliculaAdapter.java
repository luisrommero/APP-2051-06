package com.example.app205104;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PeliculaAdapter extends ArrayAdapter<Pelicula>
{
    Pelicula[] Peliculas;

    public PeliculaAdapter(Context context, Pelicula[] datos)
    {
        super(context, R.layout.listitem_pelicula, datos);
        this.Peliculas = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_pelicula, null);

        TextView LblTitulo = (TextView) item.findViewById(R.id.LblTitulo);
        TextView LblSubtitulo = (TextView) item.findViewById(R.id.LblSubtitulo);

        LblTitulo.setText(this.Peliculas[position].getTitulo());
        LblSubtitulo.setText(this.Peliculas[position].getEstudio());

        return (item);
    }

}

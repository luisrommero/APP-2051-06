package com.example.app205104;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView ListaOpciones;
    ListView ListaPeliculas;
    TextView LblMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaOpciones = (ListView)findViewById(R.id.ListaOpciones);
        ListaPeliculas = (ListView)findViewById(R.id.ListaPeliculas);
        LblMensaje = (TextView)findViewById(R.id.LblMensaje);

        //Cargar la lista 1
        final String[] Datos = new String[]{"Elemento 1", "Elemento 2", "Elemento 3"};//{"Elemento":"Elemento 1", "Elemento":"Elemento 2", "Elemento":"Elemento 3"}
        ArrayAdapter<String> Adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Datos);
        ListaOpciones.setAdapter(Adaptador);

        //Cargar la lista 2 (Películas) //[{"Pelicula":"Avengers", "Estudio":"Marvel Studios"},{"Pelicula":"XXXXXX", "Estudio":"YYYYYYY"},{"Pelicula":"XXXXXX", "Estudio":"YYYYYYY"}]
        final Pelicula[] Peliculas = new Pelicula[]{
                new Pelicula("Avengers", "Marvel Studios"),
                new Pelicula("Pocahontas", "Disney"),
                new Pelicula("Shrek", "Dreamworks"),
                new Pelicula("Shazam", "DC Studios")
        };

        PeliculaAdapter AdaptadorDePeliculas = new PeliculaAdapter(this, Peliculas);
        ListaPeliculas.setAdapter(AdaptadorDePeliculas);

        AdapterView.OnItemClickListener ListenerLista = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada = ((Pelicula)a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                //String opcionSeleccionada =
                //      ((TextView)v.findViewById(R.id.LblTitulo))
                //          .getText().toString();

                LblMensaje.setText("Opción seleccionada: " + opcionSeleccionada);
            }
        };

        ListaPeliculas.setOnItemClickListener(ListenerLista);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

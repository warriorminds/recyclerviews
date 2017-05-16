package com.warriorminds.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Actividad principal. Contiene la recyclerView.
 *
 * @author warrior.minds
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos el recycler view del layout.
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // Asignamos el layout manager. Es el encargado de la forma en que se muestra el recycler view (vertical, grid, staggered)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Agregamos un item decoration para que se muestra un divisor entre elementos.
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // Indicamos el adaptador que se va a utilizar.
        recyclerView.setAdapter(new Adapter(generarElementos(), this));
        // Agregamos un OnItemTouchListener para saber si un elemento se ha presionado.
        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(this, new RecyclerViewClickListener.ElementoPresionadoListener() {
            @Override
            public void enElementoPresionado(View view, int position) {
                // Mostramos el elemento que se presionó.
                Adapter.ViewHolder holder = (Adapter.ViewHolder) recyclerView.getChildViewHolder(view);
                Toast.makeText(MainActivity.this, holder.getElemento().toString(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    /**
     * Método que genera una lista de 20 elementos con URL, título y subtítulo.
     * @return
     */
    private List<Elemento> generarElementos() {
        List<Elemento> elementos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Elemento elemento = new Elemento("http://lorempixel.com/70/70/", "Elemento #" + i, "Subtitulo #" + (i + 10));
            elementos.add(elemento);
        }
        return elementos;
    }
}

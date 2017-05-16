package com.warriorminds.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador de los elementos para la RecyclerView.
 * Esta clase obtiene el elemento en la posición proporcionada y establece sus valores
 * en la interfaz gráfica.
 *
 * @author warrior.minds
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    /**
     * Lista de elementos que tendrá el RecyclerView.
     */
    private List<Elemento> elementos = new ArrayList<>();
    private Context contexto;

    public Adapter(List<Elemento> elementos, Context contexto) {
        this.elementos = elementos;
        this.contexto = contexto;
    }

    /**
     * Este método se utiliza para crear el ViewHolder de cada elemento.
     *
     * @param padre
     * @param tipoDeVista
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup padre, int tipoDeVista) {
        View vista = LayoutInflater.from(padre.getContext()).inflate(R.layout.recycler_view_item, padre, false);
        return new ViewHolder(vista);
    }

    /**
     * Este método se utiliza para obtener el elemento en la posición proporcionada y utilizar sus
     * datos en la interfaz gráfica.
     *
     * @param holder
     * @param posicion
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int posicion) {
        Elemento elemento = elementos.get(posicion);
        holder.elemento = elemento;
        // Utilizamos Picasso para descargar la imagen.
        Picasso.with(contexto).load(elemento.getUrlImagen()).into(holder.imagen);
        holder.titulo.setText(elemento.getTitulo());
        holder.subtitulo.setText(elemento.getSubtitulo());
    }

    /**
     * Este método debe devolver el tamaño de la lista de Elementos.
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return elementos.size();
    }

    /**
     * La clase ViewHolder mantiene la referencia del elemento que se muestra. En esta clase
     * se obtienen los elementos gráficos que se utilizan en el método onBindViewHolder().
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Elemento elemento;
        private ImageView imagen;
        private TextView titulo;
        private TextView subtitulo;

        public ViewHolder(View padre) {
            super(padre);
            imagen = (ImageView) padre.findViewById(R.id.imagen);
            titulo = (TextView) padre.findViewById(R.id.titulo);
            subtitulo = (TextView) padre.findViewById(R.id.subtitulo);
        }

        public Elemento getElemento() {
            return elemento;
        }
    }
}

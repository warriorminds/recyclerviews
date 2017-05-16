package com.warriorminds.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Clase que se encarga de detectar que un elemento de la lista fue presionado.
 *
 * @author warrior.minds
 */

public class RecyclerViewClickListener implements RecyclerView.OnItemTouchListener {

    private final GestureDetector detectorDeGestos;
    private final ElementoPresionadoListener elementoPresionadoListener;

    /**
     * Interfas que se utilizará para ejecutar código cuando se detecte que se presionó algún elemento.
     */
    public interface ElementoPresionadoListener {
        void enElementoPresionado(View vista, int posicion);
    }

    public RecyclerViewClickListener(Context contexto, ElementoPresionadoListener elementoPresionadoListener) {
        this.elementoPresionadoListener = elementoPresionadoListener;
        /**
         * Necesitamos crear un GestureDetector para detectar que se presionó el elemento.
         */
        this.detectorDeGestos = new GestureDetector(contexto, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    /**
     * Este método intercepta el touch event y si el Gesture Detector detecta que el elemento fue presionado
     * se manda ejecutar el método enElementoPresionado del ElementoPresionadoListener.
     *
     * @param vista
     * @param evento
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(RecyclerView vista, MotionEvent evento) {
        // Se obtiene la vista que se presionó.
        View vistaHija = vista.findChildViewUnder(evento.getX(), evento.getY());
        if (vistaHija != null && elementoPresionadoListener != null && detectorDeGestos.onTouchEvent(evento)) {
            elementoPresionadoListener.enElementoPresionado(vistaHija, vista.getChildAdapterPosition(vistaHija));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}

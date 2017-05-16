package com.warriorminds.recyclerview;

/**
 * Clase muestra que contiene una URl de imagen, un título y un subtítulo.
 * El recycler view mostrará una lista de estos elementos.
 *
 * @author warrior.minds
 */
public class Elemento {
    private final String urlImagen;
    private final String titulo;
    private final String subtitulo;

    public Elemento(String urlImagen, String titulo, String subtitulo) {
        this.urlImagen = urlImagen;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "; Subtitulo: " + subtitulo;
    }
}

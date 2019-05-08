package com.example.app205104;

public class Pelicula
{
    private String Titulo;
    private String Estudio;

    public Pelicula(String Titulo, String Estudio)
    {
        this.Titulo = Titulo;
        this.Estudio = Estudio;
    }

    public String getTitulo()
    {
        return (this.Titulo);
    }

    public String getEstudio()
    {
        return (this.Estudio);
    }
}

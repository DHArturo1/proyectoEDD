package p2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arturo Díaz
 */
public class Nodo
{

    private Object elemento;
    private Nodo siguiente = null;

    public Nodo(Object elemento, Nodo siguiente)
    {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }

    public Object getElemento()
    {
        return elemento;
    }

    public void setElemento(Object elemento)
    {
        this.elemento = elemento;
    }

    public Nodo getSiguiente()
    {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }

    @Override
    public String toString()
    {
        return elemento + "\n";
    }
}

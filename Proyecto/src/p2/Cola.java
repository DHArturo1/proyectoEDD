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
public class Cola 
{
    String completo = "";

    class Nodo 
    {

        String info;
        Nodo sig;
    }

    private Nodo raiz, fondo;

    Cola() 
    {
        raiz = null;
        fondo = null;
    }

    boolean vacia() 
    {
        if (raiz == null) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    void insertar(String info) 
    {
        Nodo nuevo = new Nodo();
        nuevo.info = info;
        nuevo.sig = null;
        if (vacia()) 
        {
            raiz = nuevo;
            fondo = nuevo;
        } 
        else 
        {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    String extraer() 
    {
        String informacion = raiz.info;
        if (!vacia()) 
        {
            if (raiz == fondo) 
            {
                raiz = null;
                fondo = null;
            } 
            else 
            {
                raiz = raiz.sig;
            }
        }
        return informacion;
    }

    public void imprimir(int persona) 
    {
        Nodo reco = raiz;
        completo = "";
        if (persona == 1)
        {
            System.out.println("Mostrando conversacion reciente de persona " + persona);
            while (reco != null) 
            {
                completo = completo + Archivo.sinFormatoA(reco.info.toString());
                reco = reco.sig;
            }
        } else
        {
            System.out.println("Mostrando conversacion reciente de persona " + persona);
            while (reco != null) 
            {
                completo = completo + Archivo.sinFormatoB(reco.info.toString());
                reco = reco.sig;
            }
        }
    }
    
    public void imprimir() 
    {
        System.out.println("Mostrando conversacion reciente");
        Nodo reco = raiz;
        completo = "";
        while (reco != null) 
        {
            completo = completo + Archivo.sinFormato(reco.info.toString());
            reco = reco.sig;
        }
        
    }
    
    String colaTextoCompleto(){
        
        return completo;
    }
}

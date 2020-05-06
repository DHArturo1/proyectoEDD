

import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class Nodo implements Serializable
{

    private Object obj;
    private String etq="null";
    private Nodo siguiente = null;
    private Nodo abajo=null;
    private Nodo anterior = null;
    
    public Nodo(Object obj)
    {
        this.obj = obj;
    }

    public Nodo(Object obj, String etq)
    {
        this.obj = obj;
        this.etq = etq;
    }

    /**
     * @return the obj
     */
    public Object getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    /**
     * @return the sig
     */
    public Nodo getSiguiente()
    {
        return siguiente;
    }

    /**
     * @param sig the sig to set
     */
    public void setSiguiente(Nodo sig)
    {
        this.siguiente = sig;
    }

    /**
     * @return the etq
     */
    public String getEtq()
    {
        return etq;
    }

    /**
     * @param etq the etq to set
     */
    public void setEtq(String etq)
    {
        this.etq = etq;
    }

    /**
     * @return the ant
     */
    public Nodo getAnterior()
    {
        return anterior;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnterior(Nodo ant)
    {
        this.anterior = ant;
    }

    /**
     * @return the abj
     */
    public Nodo getAbajo()
    {
        return abajo;
    }

    /**
     * @param abj the abj to set
     */
    public void setAbajo(Nodo abj)
    {
        this.abajo = abj;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LCR-22
 */
public class Colas
{
 
    private Object[] c = null;
    private int atras = -1;
    
    
    public Colas()
    {
        c = new Object[5];
    }
    public Colas(int n)
    {
        c = new Object[n];
    }

    /**
     * @return the c
     */
    public Object[] getPila()
    {
        return c;
    }

    /**
     * @param pila the c to set
     */
    public void setPila(Object[] pila)
    {
        this.c = pila;
    }

    /**
     * @return the atras
     */
    public int getAtras() 
    {
        return atras;
    }

    /**
     * @param tope the atras to set
     */
    public void setAtras(int tope) 
    {
        this.atras = atras;
    }
    
    
    public  boolean insertar(Object obj)
    {
        if (atras + 1 == c.length)
        {
            return false;
        } else 
        {
            c[++atras]= obj;
            return true;
        }
    }
    
    public  Object eliminar()
    {
        if (atras == -1)
        {
            return null;
        }else
            {
                Object o = c[0];
                for(int i=0; i<atras; i++)
                {
                    c[i] = c[i+1];
                }
                atras--;
                return o;
            }
    }
    
    public Object voltearPila()
    {
        Colas tmp = new Colas();
        while(atras != -1)
        {
          c[atras] = tmp.insertar(eliminar());
           
        }  
        return c[atras];
    }

}

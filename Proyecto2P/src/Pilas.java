/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LCR-1
 */
public class Pilas 
{
    private Object p[]= null;
    private int tope=-1;
    
    public Pilas()
    {
        p= new Object[5];
    }
    public Pilas(int n)
    {
        p= new Object[n];
    }

    /**
     * @return the p
     */
    public Object[] getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Object[] p) {
        this.p = p;
    }

    /**
     * @return the tope
     */
    public int getTope() {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(int tope) {
        this.tope = tope;
    }
    public boolean insertar(Object obj)
    {
        if (tope +1 == p.length) 
        {
            return false;
        } else
        {
            p[++ tope]=obj;
            return true;
        }
    }
    public Object eliminar()
    {
        if (tope== -1) 
        {
            return null;
        } else 
        {
            return p[tope--];
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hp
 */
public class LSL 
{
    private Nodo r = null;

    /**
     * @return the r
     */
    public Nodo getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r) {
        this.r = r;
    }
    
    public boolean inserta(Nodo n)
    {
        if (n == null) 
        {
            return false;
        } else 
        {
            //El dato a insertar es el primero de la lista
            if (r == null) 
            {
                r = n;
            } else 
            {
                //El dato es menor al primer elemento de la lista
                if (n.getEtq().compareTo(r.getEtq())<0) 
                {
                    n.setSiguiente(r);
                    r = n;
                } else 
                {
                    //El dato a insertar va en medio de la lista
                    Nodo aux = r;
                    boolean b = true;
                    while (aux.getSiguiente() != null && b) 
                    {                        
                        if (n.getEtq().compareTo(aux.getSiguiente().getEtq())<0) 
                        {
                            n.setSiguiente(aux.getSiguiente());
                            aux.setSiguiente(n);
                            b = false;
                        } else 
                        {
                            aux = aux.getSiguiente();
                        }
                    }
                    //El dato a insertar va al final de la lista
                    if (b) 
                    {
                        aux.setSiguiente(n);
                    }
                }
            }
            return true;
        }
    }
    
    public Nodo eliminar(String etq)
    {
        if (r == null) 
        {
            return null;
        } else 
        {
            Nodo aux = null;
            if(etq.compareTo(r.getEtq())>=0)
            {

                if (r.getEtq().equals(etq)) 
                {
                    aux = r;
                    r = aux.getSiguiente();
                    aux.setSiguiente(null);
                } else 
                {
                    Nodo aux2 = r;
                    boolean b = true;
                    while (aux2.getSiguiente() != null && b) 
                    {               
                        if(etq.compareTo(aux2.getSiguiente().getEtq())>=0)
                        {
                            if (aux2.getSiguiente().getEtq().equals(etq))
                            {
                                aux = aux2.getSiguiente();
                                aux2.setSiguiente(aux.getSiguiente());
                                aux.setSiguiente(null);
                                b = false;
                            } else 
                            {
                                aux2 = aux2.getSiguiente();
                            }
                        }else
                         {
                             break;
                         }
                    }
                }
            }
            return aux;
        }
    }
    
    public String desp(Nodo aux)
    {
        String s = "";
        Nodo aux2 = null;
        while (aux != null) 
        {            
            s += aux.getEtq();
            aux2 = aux;
            aux = aux.getSiguiente();
        }
        s += "\nLista inversa:\n";
        //Codigo para conexiones a la inversa
//        while (aux2 != null) 
//        {            
//            s += aux.getEtq();
//            aux2 = aux2.getAnterior();
//        }
        return s;
    }
    public int can()
    {
        int cont=0;
        while (r != null)
        {            
            cont++;
            r=r.getSiguiente();
        }
        return cont;
    }
}

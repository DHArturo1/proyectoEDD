
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hp
 */
public class Multilistas 
{
    private static Nodo mover = null;
    public static Nodo inserta(Nodo r, Nodo n, int nivel, String etqs[])
    {
        if (nivel == etqs.length-1) 
        {
            LSL ls = new LSL();
            ls.setR(r);
            ls.inserta(n);
            r = ls.getR();
            return r;
        } else
        {
            Nodo aux = busca(r, etqs[nivel]);
            if (aux != null) 
            {
                aux.setAbajo(inserta(aux.getAbajo(), n, nivel+1, etqs));
            } else
            {
                System.out.println("No encontre " + etqs[nivel] + "en el nivel " + nivel);
            }
            return r;
        }
    }
    
    public static Nodo busca(Nodo r, String e)
    {
        Nodo aux = null;
        while (r != null) 
        {            
            if (r.getEtq().equals(e)) 
            {
                aux = r;
                break;
            } else
            {
                r =r.getSiguiente();
            }
        }
        return aux;
    }
    
    public static String desp(Nodo r, int nivel)
    {
        String s="";
         while(r!= null)
         {
             String ss="";
             for (int i = 0; i < nivel; i++) 
             {
                 ss+="\t";
             }
             s+=ss+"Nivel - "+String.valueOf(nivel)+"\n";
             s+=ss+r.getEtq()+"\n";
             s+=desp(r.getAbajo(), nivel+1);
             r=r.getSiguiente();
             
         }
        return s;
    }
    public static Nodo rec(Nodo r, String etq, int nivel, String etqs[], Nodo ar)
    {
         if(nivel == etqs.length-1)
        {

            while (r!= null) 
            { 
                if(r.getEtq().compareTo(etq)==0)
                {
                    r.setAbajo(ar);
                    r=null;
                }else
                {
                    r= r.getSiguiente();
                }
                
            }
           
        }else
        {
             Nodo aux = busca(r, etqs[nivel]);
            if (aux != null) 
            {
                rec(aux.getAbajo(), etq, nivel+1, etqs, ar);
            } else
            {
                System.out.println("No encontre " + etqs[nivel] + "en el nivel " + nivel);
            }
        }
         return r;
    }
    public static Nodo[] elimina(Nodo r,String etq, int nivel, String etqs[], Nodo arr[])
    {
        if(nivel == etqs.length-1)
        {
            LSL ls= new LSL();
            ls.setR(r);
            arr[0]=ls.eliminar(etq);
            r= ls.getR();
            arr[1]=r;
           
        }else
        {
             Nodo aux = busca(r, etqs[nivel]);
            if (aux != null) 
            {
                arr=elimina(aux.getAbajo(), etq, nivel+1, etqs, arr);
            } else
            {
                System.out.println("No encontre " + etqs[nivel] + "en el nivel " + nivel);
            }
            return arr;
        }
        
        return arr;
    }
    public static Nodo elimina2(Nodo r, int nivel, String etqs[])
    {
        if (nivel == etqs.length - 1)
        {
            LSL ls = new LSL();
            ls.setR(r);
            Nodo aux = ls.eliminar(etqs[nivel]);
            mover = aux;
            if (aux == null)
            {
                JOptionPane.showMessageDialog(null, "No se encontro el dato", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            } else
            {
                r = ls.getR();
            }
            return r;
        } else
        {
            Nodo aux = busca(r, etqs[nivel]);
            if (aux != null)
            {
                aux.setAbajo(elimina2(aux.getAbajo(), nivel + 1, etqs));
            } else
            {
                System.out.println("No se encontro " + etqs[nivel] + " En el nivel " + nivel);
            }
            return r;
        }
    
}
    public static Nodo mueve (Nodo r, int nivel, String etqsE[], String etqsI[])
    {
        r = elimina2(r, nivel, etqsE);
        if (mover != null)
        {
            r = inserta(r, mover, nivel, etqsI);
        }
        return r;
    }

}

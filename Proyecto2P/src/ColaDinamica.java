
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author yo mero palomero
 */
public class ColaDinamica implements Serializable
{
    private Nodo frente=null;
    private Nodo atras=null;
    private int tamano;
    int con=0;

    /**
     * @return the frete
     */
    public Nodo getFrente()
    {
        return frente;
    }

    /**
     * @param frete the frete to set
     */
    public void setFrente(Nodo frete)
    {
        this.frente = frete;
    }

    /**
     * @return the atras
     */
    public Nodo getAtras()
    {
        return atras;
    }

    /**
     * @param atras the atras to set
     */
    public void setAtras(Nodo atras)
    {
        this.atras = atras;
    }
    public boolean inserta(Nodo n)
    {
 
        if(n==null)
        { 
            return false;
        }else
        {
            if(frente == null)
            {
                frente = atras=n;
                tamano++;
            }else
            {
                atras.setSiguiente(n);
                atras=n;
                tamano++;
                
            }
            return true;
        }
    }
    public Nodo elimina()
    {
        if(frente==null)
        {
            return null;
        }else
        {
            Nodo aux = frente;
            if(frente == atras)
            {
                frente= atras = null;
                tamano--;
            }else
            {
                frente=aux.getSiguiente();
                aux.setSiguiente(null);
                tamano--;
            }
            return aux;
        }
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamano;
    }
    public String espacios(String cad)
    {
         for (int j = 0; j < 64; j++) 
        {
           cad=cad+" ";
        }
         return cad;
    }
    public String cadena()
    {
        String cad="";
        if(frente==null)
        {
           cad=""; 
        }else
        {
            Nodo aux;
            String cad2="";
            int t= tamano;
            while(t!=con)
            {
                aux=elimina();
                cad2=""+aux.getObj();
                cad2=escribe(cad2);
                cad=cad2+"\n"+cad;
                inserta(aux);
                con++;
            }
            
        }
        con=0;
        return cad;
    }

      public String escribe(String cad)
    {
        String cad2="";
        int m2=0;
        int m=1;
        int n=0;
        int ju;
        if(cad.length()>30)
        {
            cad=cad+" ";
            char t[]=cad.toCharArray();
            if(t[t.length-2]!='2')
            {
                    if(t.length>30)
                   {

                       while(m!=0)
                       {
                           cad2=cad2+"\n";
                           n=n+30;
                           if(t[n+(m-1)]==' ' | t[n]==' ')
                           {
                               for (int j = n-30; j <=n; j++) 
                               {
                                   cad2=cad2+t[j];
                               } 
                               
                               n=n+1;
                           }else
                           {
                               ju=n;
                               while(m2==0)
                               {
                                   ju=ju-1;
                                   if(t[ju]==' ')
                                   {
                                       m2=1;
                                   }
                                   if(ju== 0 | ju==n-30)
                                   {

                                       ju=n;
                                       m2=1;
                                   }

                               }
                               m2=0;

                               for (int j = n-30; j <=ju; j++) 
                               {
                                   cad2=cad2+t[j];
                               }
                               
                               m=m+1;
                               n=ju;
                           }

                           if((t.length-1)-n<=30+(m-1))
                           {
                               cad2=cad2+"\n";

                               for (int i = n; i < t.length-1; i++) 
                               {
                                   cad2=cad2+t[i];
                               }
                               cad2=cad2+"\n";
                               m=0;

                           }
                       }
                       n=0;
                       m=1;
                       cad=cad2+"\n";
                    }
            }else
            {
                while(m!=0)
               {
                   cad2=cad2+"\n";
                   n=n+30;
                   cad2=espacios(cad2);
                   if(t[n+(m-1)]==' ' | t[n]==' ')
                   {
                       for (int j = n-30; j <=n; j++) 
                       {
                           cad2=cad2+t[j];
                       } 
                       n=n+1;
                   }else
                   {
                       ju=n;
                       while(m2==0)
                       {
                           ju=ju-1;
                           if(t[ju]==' ')
                           {
                               m2=1;
                           }
                           if(ju== 0 | ju==n-30)
                           {

                               ju=n;
                               m2=1;
                           }

                       }
                       m2=0;

                       for (int j = n-30; j <=ju; j++) 
                       {
                           cad2=cad2+t[j];
                       }
                       m=m+1;
                       n=ju;
                   }

                   if((t.length-1)-n<=30+(m-1))
                   {
                       for (int j = 0; j < 64; j++) 
                       {
                           cad2=cad2+" ";
                        }

                       for (int i = n; i < t.length-2; i++) 
                       {
                            if(t[i]=='\n')
                            {
                               cad2=cad2+t[i];
                               cad2=espacios(cad2);
                            }else
                            {
                                cad2=cad2+t[i];
                            }
                       }
                       m=0;

                   }
               }
               n=0;
               m=1;
               cad=cad2+"\n";
            }
        }else
        {
            char t[]=cad.toCharArray();
            if(t[t.length-1]!='2')
            {
                cad=cad+"\n";
            }else
            {
                cad="";
                cad=espacios(cad);
                for (int i = 0; i < t.length-1; i++) 
                {
                    if(t[i]=='\n')
                    {
                       cad=cad+t[i];
                      
                        cad=espacios(cad);

                    }else
                    {
                        cad=cad+t[i];
                    }
                    
                }
                cad=cad+"\n"; 
            }
        }
        return cad;
    }
      
    public String ordena()
    {
        String cad="";
        if(frente==null)
        {
           cad=""; 
        }else
        {
            Nodo aux;
            String cad2="";
            int t= tamano;
            Colas obj= new Colas(tamano);
            Colas caux= new Colas(tamano);
            while(t!=con)
            {
                aux=elimina();
                cad2=""+aux.getObj();
                obj.insertar(cad2);
                inserta(aux);
                con++;
            }
            String or;
            String pc;
            Pilas p1= new Pilas(tamano);
            Pilas p2= new Pilas(tamano);
            boolean b= true;
            while(obj.getAtras() != -1)
            {
                or=(String)obj.eliminar();
                if(p1.getTope()==-1)
                {
                    p1.insertar(or);
                }else
                {
                    pc=(String)p1.eliminar();
                    if(or.compareTo(pc)<=0)
                    {
                        p1.insertar(pc);
                        p1.insertar(or);
                    }else
                    {
                        p2.insertar(pc);
                        while(b)
                        {
                            if(p1.getTope() ==-1)
                           {
                               p1.insertar(or);
                               b=false;
                           }else
                           {
                               pc=(String)p1.eliminar();
                               if(or.compareTo(pc)<=0)
                               {

                                   p1.insertar(pc);
                                   p1.insertar(or);
                                   b=false;
                               }else
                               {
                                   p2.insertar(pc);
                               }
                           }
                        }
                        b=true;
                    }
                }
                while(p2.getTope()!=-1)
                {

                   p1.insertar(p2.eliminar());
                }
                
            }
            while(p1.getTope()!=-1)
            {
               obj.insertar(p1.eliminar());
            }
            char[]com;
            while(obj.getAtras()!=-1)
            {
                cad2=(String)obj.eliminar();
                
                com=cad2.toCharArray();
                if(com[com.length-1]=='2')
                {
                    caux.insertar(cad2);
                }else
                {
                    cad2=escribe(cad2);
                    cad=cad+"\n"+cad2;
                }
            }
            while(caux.getAtras() !=-1)
            {
                cad2=(String)caux.eliminar();
                cad2=escribe(cad2);
                cad=cad+"\n"+cad2;
            }
        }
        con=0;
        return cad;
    }
    
    
}

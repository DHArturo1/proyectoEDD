
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author yo mero palomero
 */
public class PilaDinamica 
 implements Serializable
{
    public static final long SerialVersionUID =1L;
    private Nodo tope=null;
    private int tamano;

    /**
     * @return the tope
     */
    public Nodo getTope()
    {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(Nodo tope)
    {
        this.tope = tope;
    }
    public boolean inserta(Nodo n)
    {
        if(n== null)
        {
            return false;
        }else
        {
           n.setSiguiente(tope);
            tope=n;
            tamano++;
            return true;
            
        }
    }
    public Nodo elimina()
    {
        if(tope== null)
        {
            return null;
        }else
        {
            Nodo aux= tope;//= por que auxiliar se mueve a donde esta tope
            tope=aux.getSiguiente();// = por que tope se mueve a lo enlazado
            aux.setSiguiente(null);//set por que se va a modificar a auxiliar desconetandolo
            tamano--;
            return aux;
        }
    }
    public String cadena()
    {
        String cad="";
        if(tope==null)
        {
           cad=""; 
        }else
        {
            Nodo aux;
            String cad2="";
            Pilas obj= new Pilas(tamano);
            while(tope!=null)
            {
                aux=elimina();
                cad2=(String)aux.getObj();
                obj.insertar(cad2);
                cad2=escribep(cad2);
                cad=cad2+"\n"+cad;
                cad2="";
            }
            while(obj.getTope()!=-1)
            {
                cad2=(String)obj.eliminar();
                Nodo l= new Nodo(cad2);
                inserta(l);
                
            }
            
        }
        return cad;
    }
    public String escribep(String cad)
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
                               m=0;
                           }
                       }
                       n=0;
                       m=1;
                       cad=cad2;
                }
            }else
            {
                while(m!=0)
               {
                   cad2=cad2+"\n";
                   n=n+30;
                   cad2=espaciosp(cad2);
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
                       for (int j = 0; j < 64; j++) 
                       {
                           cad2=cad2+" ";
                        }

                       for (int i = n; i < t.length-2; i++) 
                       {
                            if(t[i]=='\n')
                            {
                               cad2=cad2+t[i];

                                cad2=espaciosp(cad2);

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
               cad=cad2;
            }
        }else
        {
            char t[]=cad.toCharArray();
            if(t[t.length-1]!='2')
            {
                cad=cad;
            }else
            {
                cad="";
                cad=espaciosp(cad);
                for (int i = 0; i < t.length-1; i++) 
                {
                    if(t[i]=='\n')
                    {
                       cad=cad+t[i];
                      
                        cad=espaciosp(cad);

                    }else
                    {
                        cad=cad+t[i];
                    }
                      
                }
            }
        }
        return cad;

    }
    public String espaciosp(String cad)
    {
         for (int j = 0; j < 64; j++) 
        {
           cad=cad+" ";
        }
         return cad;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamano;
    }
    public String busca(String bus)
    {
        String cad="";
        if(tope==null)
        {
           cad=""; 
        }else
        {
            Nodo aux;
            String cad2="";
            Pilas obj= new Pilas(tamano);
            int com;
            while(tope!=null)
            {
                aux=elimina();
                cad2=(String)aux.getObj();
                obj.insertar(cad2);
                com=cad2.indexOf(bus);
                if(com>-1)
                {
                   cad2=escribep(cad2);
                   cad=cad2+"\n"+cad; 
                }
                
                cad2="";
            }
            while(obj.getTope()!=-1)
            {
                cad2=(String)obj.eliminar();
                Nodo l= new Nodo(cad2);
                inserta(l);
                
            }
            
        }
        return cad;
    }

}

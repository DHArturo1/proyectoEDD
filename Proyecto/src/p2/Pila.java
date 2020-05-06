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
public class Pila
{

    private Nodo tope;
    private int tamanio;

    public Pila()
    {
        tope = null;
        this.tamanio = 0;
    }

    public boolean vacia()
    {
        return tope == null;
    }

    public int size()
    {
        return this.tamanio;
    }

    public Object top()
    {
        if (vacia())
        {
            return null;
        } else
        {
            return tope.getElemento();
        }
    }

    public Object elimina()
    {
        if (vacia())
        {
            return null;
        } else
        {
            Object elemento = tope.getElemento();
            Nodo aux = tope.getSiguiente();
            tope = null;
            tope = aux;
            this.tamanio--;
            return elemento;
        }
    }

    public Object insertar(Object elemento)
    {
        Nodo aux = new Nodo(elemento, tope);
        tope = aux;
        this.tamanio++;
        return aux.getElemento();
    }

    public Object buscar(Object referencia)
    {
        Nodo aux = tope;
        while (aux != null)
        {
            String texto = limpiarTexto(aux.getElemento().toString());

            if (referencia.equals(texto))
            {
                texto = limpiarFormato(aux.getElemento().toString());
                return texto;
            } else
            {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public String limpiarTexto(String input)
    {
        String extraerTexto = "";

        int asterisco;
        int guionmedio;
        int contador = 0;

        char c = input.charAt(contador);

        if (c == '1' || c == '2')
        {
            asterisco = input.indexOf("**") + 1;
            c = input.charAt(asterisco);
            guionmedio = input.indexOf("--") + 1;
            c = input.charAt(guionmedio);
            extraerTexto = input.substring(asterisco + 1, guionmedio - 1);
        }
        return extraerTexto;
    }

    public static String limpiarFormato(String input)
    {
        String extraerTexto = "";
        String extraerFecha = "";

        int asterisco;
        int guionmedio;
        int pleca;

        String texto = "";
        int contador = 0;

        char c = input.charAt(contador);

        if (c == '1')
        {
            asterisco = input.indexOf("**") + 1;
            c = input.charAt(asterisco);
            guionmedio = input.indexOf("--") + 1;
            c = input.charAt(guionmedio);
            pleca = input.indexOf("||") + 1;
            c = input.charAt(pleca);
            extraerTexto = input.substring(asterisco + 1, guionmedio - 1);
            extraerFecha = input.substring(guionmedio + 1, pleca - 1);
            texto = texto + "\n" + extraerTexto + "\n" + extraerFecha;
        } else
        {
            asterisco = input.indexOf("**") + 1;
            c = input.charAt(asterisco);
            guionmedio = input.indexOf("--") + 1;
            c = input.charAt(guionmedio);
            pleca = input.indexOf("||") + 1;
            c = input.charAt(pleca);
            extraerTexto = input.substring(asterisco + 1, guionmedio - 1);
            extraerFecha = input.substring(guionmedio + 1, pleca - 1);
            texto = texto + "\n\t" + extraerTexto + "\n\t" + extraerFecha;
        }
        return texto;
    }

    public String toString(int persona)
    {
        if (vacia())
        {
            return "La pila esta vacia";
        } else
        {
            String resultado = "";
            if (persona == 1)
            {
                Nodo aux = tope;
                while (aux != null)
                {
                    resultado += "\n" + limpiarTexto(aux.toString());
                    aux = aux.getSiguiente();
                }
            } else if (persona == 2)
            {
                Nodo aux = tope;
                while (aux != null)
                {
                    resultado += "\n\t" + limpiarTexto(aux.toString());
                    aux = aux.getSiguiente();
                }
            }
            return resultado;
        }
    }

    public boolean ordena()
    {
        String textoIn, textoCo;
        char contenido1, contenido2;
        int ascii1, ascii2;

        System.out.println("Ordenando datos");

        if (vacia())
        {
            return false;
        } else
        {
            String array[] = new String[tamanio];
            int contador = 0;
            while (!vacia())
            {
                array[contador] = limpiarTexto(elimina().toString());
                contador += 1;
            }
            if (vacia())
            {
                for (int i = 0; i < array.length - 1; i++)
                {
                    for (int j = 0; j < array.length - 1; j++)
                    {
                        contenido1 = array[j].charAt(0);
                        ascii1 = (int) contenido1;
                        contenido2 = array[j + 1].charAt(0);
                        ascii2 = (int) contenido2;
                        if (ascii1 < ascii2)
                        {
                            String tmp = array[j + 1];
                            array[j + 1] = array[j];
                            array[j] = tmp;
                        }
                    }
                }
                for (int i = 0; i < array.length; i++)
                {
                    insertar("1**" + array[i] + "--||");
                }

            }
            return true;
        }
    }
}

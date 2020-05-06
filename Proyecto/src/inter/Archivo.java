package inter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author Usuario
 */
public class Archivo
{

    static String b = "Conversacion.txt";
    static File miArchivo = new File("Conversacion.txt");
    static PrintWriter escribir;
    int i = 0, j = 0;

    String[] cFecha, cNombre;

    public void nuevoArchivo()
    {

        if (!miArchivo.exists())
        {
            System.out.println("Archivo creado correctamente");
            try
            {
                miArchivo.createNewFile();
            } catch (Exception e)
            {
            }
        } else
        {
            System.out.println("Archivo existente");
        }

    }

    public String lecturaArchivo()
    {
        String extraerTexto = "";
        String extraerFecha = "";

        System.out.println("Mostrando conversacion completa y guardada en " + b);
        String d1 = "";
        String d2 = "";
        int contador;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(b));
            String linea = "";
            String bfRead;
            contador = 0;
            while (linea != null)
            {

                try
                {
                    linea = bf.readLine();
                    if (linea != null)
                    {
                        contador = contador + 1;

                    }
                    cFecha = new String[contador];
                    cNombre = new String[contador];
                } catch (Exception e)
                {
                }
            }
        } catch (Exception e)
        {
            System.err.println("No se encontro el archivo");
        }

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(b));
            String linea = "";
            String bfRead;
            contador = 0;
            while (linea != null)
            {

                try
                {
                    linea = bf.readLine();
                    if (linea != null)
                    {
                        d1 = fecha(linea);
//                        System.out.println("- fecha: " + d1);
//                        cFecha[contador] = String.valueOf(d1);
                        d2 = nombre(linea);
//                        System.out.println("- nombre: " + d2);
                        cadenaFecha(d1);
                        cadenaNombre(d2);
                    }

                } catch (Exception e)
                {
                }
            }
        } catch (Exception e)
        {
            System.err.println("No se encontro el archivo");
        }
        return d1;
    }

    public String[] buscarContactoArchivoFecha(String contacto)
    {
//        System.out.println("" +  contacto);
        String extraerTexto = "";
        String extraerFecha = "";
//
//        System.out.println("Mostrando conversacion completa y guardada en " + b);

        int contador;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(b));
            String linea = "";
            String bfRead;
            contador = 0;
            while (linea != null)
            {

                try
                {
                    linea = bf.readLine();
                    if (linea != null)
                    {
                        contador = contador + 1;

                    }
                    cFecha = new String[contador];
                    cNombre = new String[contador];
                } catch (Exception e)
                {
                }
            }
        } catch (Exception e)
        {
            System.err.println("No se encontro el archivo");
        }

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(b));
            String linea = "";
            String bfRead;
            contador = 1;
            while (linea != null)
            {

                try
                {
                    linea = bf.readLine();
                    if (linea != null)
                    {
                        cFecha[0] = String.valueOf("Seleccione una fecha");
                        bfRead = buscarContactoFecha(linea, contacto);
//                        System.out.println("-*- " + bfRead);
                        if (bfRead != null)
                        {
                            if (contador == 1)
                            {
                                cFecha[contador] = bfRead;
//                                System.out.println("* fecha: " + cFecha[contador] + " contador " + contador);
                                contador = contador + 1;
                            } else
                            {
                                if (contador > 1 && cFecha[contador - 1].compareTo(bfRead) < 0)
//                                if (contador > 0 && cFecha[contador - 1] != bfRead)
                                {
                                    cFecha[contador] = bfRead;
//                                    System.out.println("* fecha: " + cFecha[contador] + " contador " + contador);
                                    contador = contador + 1;
                                }
                            }
                        }

                    }
                } catch (Exception e)
                {
                }

            }
        } catch (Exception e)
        {
            System.err.println("No se encontro el archivo");
        }
        return cFecha;
    }

    public String fecha(String linea)
    {
        char c;
        int guionmedio;
        int pleca;
        String extraerFecha;

        guionmedio = linea.indexOf("--") + 1;
        c = linea.charAt(guionmedio);
        pleca = linea.indexOf("||") + 1;
        c = linea.charAt(pleca);
        extraerFecha = linea.substring(guionmedio + 10, pleca - 1);
        return extraerFecha;
    }

    public String buscarContactoFecha(String linea, String contacto)
    {
        char c;
        int guionmedio;
        int pleca;
        int and;
        String extraerFecha, extraerNombre;

        guionmedio = linea.indexOf("--") + 1;
        c = linea.charAt(guionmedio);
        pleca = linea.indexOf("||") + 1;
        c = linea.charAt(pleca);
        and = linea.indexOf("&&") + 1;
        c = linea.charAt(and);
        extraerNombre = linea.substring(pleca + 1, and - 1);
        extraerFecha = linea.substring(guionmedio + 10, pleca - 1);
//        System.out.println(contacto + "4. " + extraerNombre + " " + extraerFecha);
        if (extraerNombre.equals(contacto))
        {
//            System.out.println("5. " + extraerNombre + " " + extraerFecha);
//            System.out.println("con" + extraerFecha);
            return extraerFecha;
        }
        return null;
    }

    public String nombre(String linea)
    {
        char c;
        int pleca;
        int and;
        String extraerNombre;
        pleca = linea.indexOf("||") + 1;
        c = linea.charAt(pleca);
        and = linea.indexOf("&&") + 1;
        c = linea.charAt(and);
        //System.out.println(c + " " + pleca);
        extraerNombre = linea.substring(pleca + 1, and - 1);
        return extraerNombre;
    }

    public void cadenaFecha(String input)
    {

//        System.out.println("" + cFecha.length + " " + i);
        if (cFecha[0] == null)
        {
            cFecha[0] = input;
//            System.out.println(">\t" + cFecha[0]);
            i = i + 1;
        } else
        {
            if (input.equals(cFecha[i - 1]))
            {
//                System.out.println(">\t" + input.equals(cFecha[i - 1]));
            } else
            {
                cFecha[i] = input;
//                System.out.println(">\t" + cFecha[i]);
                i = i + 1;
            }
        }
    }

    public void cadenaNombre(String input)
    {

//        System.out.println("" + cNombre.length + " " + j);
        if (cNombre[0] == null)
        {
            cNombre[0] = input;
//            System.out.println(">\t" + cNombre[0]);
            j = j + 1;
        } else
        {
            if (input.equals(cNombre[j - 1]))
            {
//                System.out.println(">\t" + cNombre[j]);
            } else
            {
                cNombre[i] = input;
//                System.out.println(">\t" + cNombre[j]);
                j = j + 1;
            }
        }
    }

    public static String mostrarConversacion(String emisor, String fecha, String receptor)
    {
        String extraerNombre = "";
        String extraerFecha = "";
        String extraerTexto = "";
        String conversacion = "";
        char c;
        int asterisco, guionmedio, pleca, and;
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(b));
            String linea = "";
            String bfRead;
            while (linea != null)
            {
                try
                {
                    
                    linea = bf.readLine();
                    System.out.println("linea: " + linea);
                    if (linea != null)
                    {
                        

                        asterisco = linea.indexOf("**") + 1;
                        c = linea.charAt(asterisco);
                        guionmedio = linea.indexOf("--") + 1;
                        c = linea.charAt(guionmedio);
                        pleca = linea.indexOf("||") + 1;
                        c = linea.charAt(pleca);
                        and = linea.indexOf("&&") + 1;
                        c = linea.charAt(and);
                        extraerNombre = linea.substring(pleca + 1, and - 1);
                        extraerFecha = linea.substring(guionmedio + 10, pleca - 1);
                        extraerTexto = linea.substring(asterisco + 1, guionmedio - 1);
                        System.out.println(receptor + " 4. " + extraerNombre + " " + extraerFecha);
                        conversacion = extraerNombre + extraerFecha + conversacion;
                        System.out.println("5. " + conversacion);
                        if (extraerNombre.equals(receptor))
                        {
//            System.out.println("5. " + extraerNombre + " " + extraerFecha);
//            System.out.println("con" + extraerFecha);
                            return extraerFecha;
                        }
                        return null;
                    }
                } catch (Exception e)
                {
                }

            }
        } catch (Exception e)
        {
            System.err.println("No se encontro el archivo");
        }
        return conversacion;
    }

}

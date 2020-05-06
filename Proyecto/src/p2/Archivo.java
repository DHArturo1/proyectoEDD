package p2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Arturo Díaz
 */
public class Archivo
{

    static String b = "Conversacion.txt";
    static File miArchivo = new File("Conversacion.txt");
    static PrintWriter escribir;

    public static void nuevoArchivo()
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

    public static String lecturaArchivo()
    {
        String extraerTexto = "";
        String extraerFecha = "";

        int asterisco;
        int guionmedio;
        int pleca;

        Archivo a = new Archivo();
        System.out.println("Mostrando conversacion completa y guardada en " + b);
        String texto = "";
        int contador = 0;

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
                    if (linea != null)
                    {
                        char c = linea.charAt(contador);

                        if (c == '1')
                        {
                            //System.out.println(linea);
                            asterisco = linea.indexOf("**") + 1;
                            c = linea.charAt(asterisco);
                            //System.out.println(c + " " + asterisco);
                            guionmedio = linea.indexOf("--") + 1;
                            c = linea.charAt(guionmedio);
                            //System.out.println(c + " " + guionmedio);
                            pleca = linea.indexOf("||") + 1;
                            c = linea.charAt(pleca);
                            //System.out.println(c + " " + pleca);
                            extraerTexto = linea.substring(asterisco + 1, guionmedio - 1);
                            extraerFecha = linea.substring(guionmedio + 1, pleca - 1);
                            //System.out.println(extraerTexto + "\n" + extraerFecha);
                            texto = texto + "\n" + extraerTexto + "\n" + extraerFecha;

                        } else
                        {
                            //System.out.println("\t"+linea);
                            asterisco = linea.indexOf("**") + 1;
                            c = linea.charAt(asterisco);
                            //System.out.println(c + " " + asterisco);
                            guionmedio = linea.indexOf("--") + 1;
                            c = linea.charAt(guionmedio);
                            //System.out.println(c + " " + guionmedio);
                            pleca = linea.indexOf("||") + 1;
                            c = linea.charAt(pleca);
                            //System.out.println(c + " " + pleca);
                            extraerTexto = linea.substring(asterisco + 1, guionmedio - 1);
                            extraerFecha = linea.substring(guionmedio + 1, pleca - 1);
                            //System.out.println("\t" + extraerTexto + "\n\t" + extraerFecha);
                            texto = texto + "\n\t" + extraerTexto + "\n\t" + extraerFecha;
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
        return texto;
    }

    public static String lecturaArchivoA()
    {
        String extraerTexto = "";
        String extraerFecha = "";

        int asterisco;
        int guionmedio;
        int pleca;

        Archivo a = new Archivo();
        System.out.println(b);
        String texto = "";
        int contador = 0;

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
                    if (linea != null)
                    {
                        char c = linea.charAt(contador);

                        if (c == '1')
                        {
                            asterisco = linea.indexOf("**") + 1;
                            c = linea.charAt(asterisco);
                            guionmedio = linea.indexOf("--") + 1;
                            c = linea.charAt(guionmedio);
                            pleca = linea.indexOf("||") + 1;
                            c = linea.charAt(pleca);
                            extraerTexto = linea.substring(asterisco + 1, guionmedio - 1);
                            extraerFecha = linea.substring(guionmedio + 1, pleca - 1);
                            texto = texto + "\n" + extraerTexto + "\n" + extraerFecha;

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
        return texto;
    }

    public static String lecturaArchivoB()
    {
        String extraerTexto = "";
        String extraerFecha = "";

        int asterisco;
        int guionmedio;
        int pleca;

        Archivo a = new Archivo();
        System.out.println(b);
        String texto = "";
        int contador = 0;

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
                    if (linea != null)
                    {
                        char c = linea.charAt(contador);

                        if (c == '2')
                        {
                            asterisco = linea.indexOf("**") + 1;
                            c = linea.charAt(asterisco);
                            guionmedio = linea.indexOf("--") + 1;
                            c = linea.charAt(guionmedio);
                            pleca = linea.indexOf("||") + 1;
                            c = linea.charAt(pleca);
                            extraerTexto = linea.substring(asterisco + 1, guionmedio - 1);
                            extraerFecha = linea.substring(guionmedio + 1, pleca - 1);
                            texto = texto + "\n\t" + extraerTexto + "\n\t" + extraerFecha;

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
        return texto;
    }

    public static void escrituraArchivo(String resultado)
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
            try
            {

                BufferedReader bf = new BufferedReader(new FileReader(b));
                String temp = "";
                String texto = "";
                while (temp != null)
                {
                    try
                    {
                        temp = bf.readLine();
                        if (temp != null)
                        {
                            texto = texto + "\n" + temp;
                        }
                    } catch (Exception e)
                    {
                    }
                }

                escribir = new PrintWriter(miArchivo, "UTF-8");
                escribir.println(resultado + texto);
                escribir.close();
                System.out.println("Se guardo en el archivo");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    public static String fecha()
    {
        Date date = new Date();
        String completo;
        DateFormat hourdateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        completo = hourdateFormat.format(date);
        return completo;
    }

    public static String sinFormato(String input)
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

    public static String sinFormatoA(String input)
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
        }
        return texto;
    }

    public static String sinFormatoB(String input)
    {
        String extraerTexto = "";
        String extraerFecha = "";

        int asterisco;
        int guionmedio;
        int pleca;

        String texto = "";
        int contador = 0;

        char c = input.charAt(contador);

        if (c == '2')
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

}

package p1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/**
 *
 * @author Usuario
 */
public class Archivo
{

    String nombre = "multilista.dat";

    public void Guardar()
    {

        File archivo = new File(nombre);
        FileOutputStream fos;
        ObjectOutputStream oos;
        try
        {
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);

//            Multilista m = new Multilista();
//            m.agregarNodoPadre("AMIGO");
//            m.agregarNodoPadre("FAMILIA");
//            m.agregarNodoPadre("CONOCIDOS");
//
//            m.agregarNodoHijo("AMIGOS", "A", "1");
//            m.agregarNodoHijo("AMIGOS", "B", "2");
//            m.agregarNodoHijo("AMIGOS", "C", "3");
//            m.agregarNodoHijo("AMIGOS", "D", "4");
//
//            m.agregarNodoHijo("FAMILIA", "E", "5");
//            m.agregarNodoHijo("FAMILIA", "F", "6");
//            m.agregarNodoHijo("FAMILIA", "G", "7");
//            m.agregarNodoHijo("FAMILIA", "H", "8");
//
//            m.agregarNodoHijo("CONOCIDOS", "I", "8");
//            m.agregarNodoHijo("CONOCIDOS", "J", "1");
//            m.agregarNodoHijo("CONOCIDOS", "K", "3");
//            m.agregarNodoHijo("CONOCIDOS", "L", "4");
//            oos.writeObject(m);
        } catch (FileNotFoundException e)
        {
            System.out.println("No se encontro el archivo");
        } catch (IOException e)
        {
            System.out.println("No se modifico el archivo");
        }
    }

    public void Leer()
    {
        File archivo = new File(nombre);
        FileInputStream fls;
        ObjectInputStream ols;
        try
        {
            fls = new FileInputStream(archivo);
            ols = new ObjectInputStream(fls);
            while(true){
                Object data = ols.readObject();
                
                Multilista m = (Multilista) data;
                System.out.println("---------" + m.toString());
            }
        } catch (Exception e)
        {
        }
    }
}

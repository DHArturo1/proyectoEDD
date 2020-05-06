package inter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Principal3
{
    static Archivo a = new Archivo();
    /**
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        String fecha;
        
        a.lecturaArchivo();
        for (int i = 0; i < a.cFecha.length; i++)
        {
            if(a.cFecha[i]!=null){
//                System.out.println("> " +  a.cFecha[i]);
            }
            
        }
        for (int i = 0; i < a.cNombre.length; i++)
        {
            if(a.cNombre[i]!=null){
//                System.out.println("> " +  a.cNombre[i]);
            }
            
        }
    }
    
    public String[] contacto (String contacto){
        String[] fecha;
//        System.out.println("1. " + contacto);
        fecha = a.buscarContactoArchivoFecha(contacto);
        
        return fecha;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hp
 */
public class PrbMultilista {

    public static void main() {
        Nodo r = null;
        Nodo arr[] = new Nodo[2];
        Nodo p1 = new Nodo(null, "Francia");
        Nodo p2 = new Nodo(null, "Afganistan");
        Nodo p3 = new Nodo(null, "Mexico");

        Nodo e1 = new Nodo(null, "Edo Mexico");
        Nodo e2 = new Nodo(null, "Jalisco");
        Nodo e3 = new Nodo(null, "Guerrero");

        Nodo m1 = new Nodo(null, "Xonacatlan");
        Nodo m2 = new Nodo(null, "Toluca");
        Nodo m3 = new Nodo(null, "Valle de Bravo");

        //Inserta los paises
        String etqs[] = new String[1];
        etqs[0] = "Francia";
        r = Multilistas.inserta(r, p1, 0, etqs);
        etqs[0] = "Afganistan";
        r = Multilistas.inserta(r, p2, 0, etqs);
        etqs[0] = "Mexico";
        r = Multilistas.inserta(r, p3, 0, etqs);
        //Inserta los estados
        etqs = new String[2];
        etqs[0] = "Mexico";
        etqs[1] = "Edo Mexico";
        r = Multilistas.inserta(r, e1, 0, etqs);
        etqs[1] = "Jalisco";
        r = Multilistas.inserta(r, e2, 0, etqs);
        etqs[1] = "Guerrero";
        r = Multilistas.inserta(r, e3, 0, etqs);

        //Inserta municipios
        etqs = new String[3];
        etqs[0] = "Mexico";
        etqs[1] = "Edo Mexico";
        etqs[2] = "Xonacatlan";
        r = Multilistas.inserta(r, m1, 0, etqs);
        etqs[2] = "Toluca";
        r = Multilistas.inserta(r, m2, 0, etqs);
        etqs[2] = "Valle de Bravo";
        r = Multilistas.inserta(r, m3, 0, etqs);

        //Inserta las colonias
        Nodo c = new Nodo(null, "Ocho Cedros");
        etqs = new String[4];
        etqs[0] = "Mexico";
        etqs[1] = "Edo Mexico";
        etqs[2] = "Toluca";
        etqs[3] = "Ocho Cedros";
        r = Multilistas.inserta(r, c, 0, etqs);

        System.out.println(Multilistas.desp(r, 0));

        etqs = new String[2];
        etqs[0] = "Mexico";
        etqs[1] = "Edo Mexico";

        arr = Multilistas.elimina(r, "Edo Mexico", 0, etqs, arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        if(arr[0]!= null)
        {
        if(etqs.length == 1)
        {
                r=arr[1];
            }else
            {
                String aux[] = new String[etqs.length-1];
                System.arraycopy(etqs, 0, aux, 0, etqs.length-1);
                Multilistas.rec(r, aux[aux.length-1], 0, aux, arr[1]);
            }
        }
        etqs = new String[2];
        etqs[0] = "Francia";
        etqs[1] = "Edo Mexico";
        System.out.println(r.getEtq()+arr[0].getEtq());
        Multilistas.inserta(r, arr[0], 0, etqs);
        System.out.println(Multilistas.desp(r, 0));

    }
}

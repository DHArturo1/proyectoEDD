package p1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Multilista
{

    private NodoPadre INICIO;
    private NodoPadre FINAL;

    int tGrupo, tEmisor, tReceptor;

    String[] cGrupo;
    String[] cEmisor;
    String[] cReceptor;

    public Multilista()
    {

    }

    public void agregarNodoPadre(String info)
    {
        NodoPadre np = new NodoPadre(info);
        try
        {
            if (INICIO == null)
            {
                INICIO = np;
                FINAL = np;
//                System.out.println(" 1- " + np.getGrupo().toString());
                tGrupo = tGrupo + 1;

            } else
            {
                FINAL.setSig(np);
                FINAL = np;
//                System.out.println(" 2- " + np.getGrupo().toString());
                tGrupo = tGrupo + 1;
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        cGrupo = new String[tGrupo + 1];
    }

    public NodoPadre BuscarNodoPadre(String info)
    {
        NodoPadre nodoPadre = INICIO;
        try
        {
            while (nodoPadre != null)
            {
                if (nodoPadre.getGrupo().equalsIgnoreCase(info))
                {
                    return nodoPadre;
                }
                nodoPadre = nodoPadre.getSig();
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }

    public void agregarNodoHijo(String grupo, String emisor, String receptor)
    {
        try
        {
            NodoPadre np = BuscarNodoPadre(grupo);
            if (np != null)
            {
                NodoHijo nodoHijo = np.getAbajo();

                NodoHijo nodoHijoNuevo = new NodoHijo(grupo, emisor, receptor);

                if (np.getAbajo() == null && np.getGrupo() == grupo)
                {

                    np.setAbajo(nodoHijoNuevo);
                    tEmisor = tEmisor + 1;
                    tReceptor = tReceptor + 1;
                } else
                {
                    System.out.println(nodoHijoNuevo.getReceptor().toString());
                    while (nodoHijo.getAbajo() != null)
                    {
                        nodoHijo = nodoHijo.getAbajo();

                    }
                    nodoHijo.setAbajo(nodoHijoNuevo);
                    tEmisor = tEmisor + 1;
                    tReceptor = tReceptor + 1;
                }
            } else
            {
                System.out.println("No se encontro el nodo " + grupo);
            }
            cEmisor = new String[tEmisor + 1];
            cReceptor = new String[tReceptor + 1];
        } catch (Exception e)
        {
        }
    }

    public void mostrarMultilista()
    {
        try
        {
            NodoPadre np = INICIO;
            while (np != null)
            {
                System.out.println(np.getGrupo());
                NodoHijo nodoHijo = np.getAbajo();
                if (nodoHijo != null)
                {
                    while (nodoHijo != null)
                    {
                        System.out.println("" + nodoHijo.getGrupo() + " - " + nodoHijo.getEmisor() + " - " + nodoHijo.getReceptor());
                        nodoHijo = nodoHijo.getAbajo();
                    }
                }
                np = np.getSig();
            }
        } catch (Exception e)
        {
        }
    }

    public void mostrarGrupo()
    {
        int i = 0;
        cGrupo[i] = "Elija un grupo";
        i++;
        try
        {
            NodoPadre np = INICIO;
            while (np != null)
            {
                cGrupo[i] = String.valueOf(np.getGrupo());
                System.out.println("" + cGrupo[i]);
                np = np.getSig();
                i++;
            }
        } catch (Exception e)
        {
        }
    }

    public void mostrarGrupo1(String grupo)
    {

        NodoPadre ej = BuscarNodoPadre(grupo);
        System.out.println("" + ej.getGrupo());
        NodoHijo nodoHijo = ej.getAbajo();

        ej = ej.getSig();
    }

    public void mostrarEmisor()
    {
        int i = 0;
        cEmisor[i] = "Elija un emisor";
        i++;
        try
        {
            NodoPadre np = INICIO;
            while (np != null)
            {

                System.out.println(np.getGrupo());
                NodoHijo nodoHijo = np.getAbajo();
                if (nodoHijo != null)
                {
                    while (nodoHijo != null)
                    {
                        cEmisor[i] = String.valueOf(nodoHijo.getEmisor());
                        System.out.println("" + cEmisor[i]);
                        nodoHijo = nodoHijo.getAbajo();
                        i++;
                    }
                }
                np = np.getSig();
            }
        } catch (Exception e)
        {
        }
    }

    public void mostrarEmisor1(String grupo)
    {
        System.out.println("---" + grupo);

        NodoPadre ej = BuscarNodoPadre(grupo);
        System.out.println("" + ej.getGrupo());
        NodoHijo nodoHijo = ej.getAbajo();
        int i = 0;
        cEmisor[i] = "Elija un emisor";
        i++;
        if (nodoHijo != null)
        {
            while (nodoHijo != null)
            {
//                System.out.println("---" + nodoHijo.getGrupo());
                if (nodoHijo.getEmisor() != null && nodoHijo.getGrupo() == grupo)
                {
                    cEmisor[i] = String.valueOf(nodoHijo.getEmisor());
                    System.out.println("" + cEmisor[i]);
                    nodoHijo = nodoHijo.getAbajo();
                    i++;
                }

            }
            ej = ej.getSig();
        }
        
    }

    public void mostrarReceptor()
    {
        int i = 1;
       
        try
        {
            NodoPadre np = INICIO;
            while (np != null)
            {
                System.out.println(np.getGrupo());
                NodoHijo nodoHijo = np.getAbajo();
                if (nodoHijo != null)
                {
                    while (nodoHijo != null)
                    {
                        cReceptor[i] = String.valueOf(nodoHijo.getReceptor());
                        System.out.println(" - " + cReceptor[i]);
                        nodoHijo = nodoHijo.getAbajo();
                        i++;
                    }
                }
                np = np.getSig();
            }
        } catch (Exception e)
        {
        }
    }

    public void mostrarReceptor1(String grupo, String emisor)
    {
        NodoPadre np = BuscarNodoPadre(grupo);
        System.out.println(" - " + np.getGrupo());
        NodoHijo nodoHijo = np.getAbajo();

        int i = 1;

        if (nodoHijo != null)
        {
            System.out.println("\t" + nodoHijo.getEmisor());
            cReceptor[i] = String.valueOf(nodoHijo.getReceptor());
            System.out.println(" - " + cReceptor[i]);
            i++;
            while (nodoHijo != null)
            {

                nodoHijo = nodoHijo.getAbajo();
                if (nodoHijo.getEmisor() != null)
                {

                    while (nodoHijo != null)
                    {
                        cReceptor[0] = String.valueOf("Elija un contacto");
                        cReceptor[i] = String.valueOf(nodoHijo.getReceptor());
                        System.out.println(" - " + cReceptor[i]);
                        nodoHijo = nodoHijo.getAbajo();
                        i++;

                    }
                }

            }
        }
        np = np.getSig();
    }
}

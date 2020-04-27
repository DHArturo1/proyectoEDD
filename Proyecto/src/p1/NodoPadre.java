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
public class NodoPadre
{
    private String grupo;
    private NodoPadre sig;
    private NodoHijo abajo;
    
    public NodoPadre(){
        sig = null;
        abajo = null;
    }
    
    public NodoPadre(String grupo){
        this.grupo = grupo;
        this.sig = null;
        this.abajo = null;
    }

    /**
     * @return the grupo
     */
    public String getGrupo()
    {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo)
    {
        this.grupo = grupo;
    }

    /**
     * @return the sig
     */
    public NodoPadre getSig()
    {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoPadre sig)
    {
        this.sig = sig;
    }

    /**
     * @return the abajo
     */
    public NodoHijo getAbajo()
    {
        return abajo;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(NodoHijo abajo)
    {
        this.abajo = abajo;
    }

    
    
}

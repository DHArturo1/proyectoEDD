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
public class NodoHijo
{
    private String grupo;
    private String emisor;
    private String receptor;
    private NodoHijo abajo;
    
    public NodoHijo(){
        abajo = null;
    }
    
    public NodoHijo(String grupo, String emisor, String receptor){
        this.grupo = grupo;
        this.emisor = emisor;
        this.receptor = receptor;
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
     * @return the emisor
     */
    public String getEmisor()
    {
        return emisor;
    }

    /**
     * @param emisor the emisor to set
     */
    public void setEmisor(String emisor)
    {
        this.emisor = emisor;
    }

    /**
     * @return the receptor
     */
    public String getReceptor()
    {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(String receptor)
    {
        this.receptor = receptor;
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

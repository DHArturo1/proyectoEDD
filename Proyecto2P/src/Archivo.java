
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
public class Archivo implements Serializable
{
    private ColaDinamica col=new ColaDinamica();
    private PilaDinamica p1= new PilaDinamica();
    private PilaDinamica p2= new PilaDinamica();
    private int num = 0;

    public Archivo() 
    {
        
    }
    public Archivo(ColaDinamica col, PilaDinamica p1, PilaDinamica p2, int num) 
    {
        this.col=col;
        this.p1=p1;
        this.p2=p2;
        this.num= num;
    }
    
    
    /**
     * @return the col
     */
    public ColaDinamica getCol() 
    {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(ColaDinamica col) 
    {
        this.col = col;
    }

    /**
     * @return the p1
     */
    public PilaDinamica getP1() 
    {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(PilaDinamica p1) 
    {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public PilaDinamica getP2() 
    {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(PilaDinamica p2) 
    {
        this.p2 = p2;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }
    
}

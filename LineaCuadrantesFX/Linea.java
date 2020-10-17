/**
 * Un ejemplo que modela un Linea usando POO
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co)
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 */
public class Linea {

    //COMPLETE las cuatro propiedades de la linea, las coordenadas de sus dos puntos
    protected float x1;
    protected float y1;
    protected float x2;
    protected float y2;

    public Linea() {
    }

    public Linea(float x1, float y1, float x2, float y2) {
        //COMPLETE
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /*complete GET/SET*/
    public float getX1()
    {
        return this.x1;
    }

    public void setX1(float x1)
    {
        this.x1 = x1;
    }

    public float getY1()
    {
        return this.y1;
    }

    public void setY1(float y1)
    {
        this.y1 = y1;
    }

    public float getX2()
    {
        return this.x2;
    }

    public void setX2(float x2)
    {
        this.x2 = x2;
    }

    public float getY2()
    {
        return this.y2;
    }

    public void setY2(float y2)
    {
        this.y2 = y2;
    }
    
    public float xMayor()
    {
        float mayor = 0;
        if(getX1()>getX2()) mayor = getX1();
        else mayor = getX2();
        return mayor;
    }

        

    public String getUbicacion() {
        String ubicacion = "La línea se encuentra en lo(s) cuadrante(s) ";
        if(estaEnCuadranteI()) ubicacion += "I ";
        if(estaEnCuadranteII()) ubicacion += "II ";
        if(estaEnCuadranteIII()) ubicacion += "III ";
        if(estaEnCuadranteIV()) ubicacion += "IV ";
        return ubicacion;
    }//fin getUbicacion

    public int getCuantosCuadrantes() {
        int num = 0;
        if(estaEnCuadranteI()) num++;
        if(estaEnCuadranteII()) num++;
        if(estaEnCuadranteIII()) num++;
        if(estaEnCuadranteIV()) num++;
        return num;
    }//fin getCuantosCuadrantes

    public boolean estaEnCuadranteI() {
        boolean c1= false;
        if(xMayor() == getX1())
        {
            if(getX1() > 0 && getY1()>0) c1 = true;
            if(getIntersectoY()>0 && getX1()>0) c1 = true;
            if(getX2() > 0 && getY2()>0) c1 = true;
        }
        else
        {
            if(getX2() > 0 && getY2()>0) c1 = true;
            if(getIntersectoY()>0 && getX2()>0) c1 = true;
            if(getX1() > 0 && getY1()>0) c1 = true;
        }
        return c1;

    }//fin estaEnCuadranteI

    public boolean estaEnCuadranteII() {
        boolean c2= false;
        if(xMayor() == getX1())
        {
            if(getX2() < 0 && getY2()>0) c2 = true;
            if(getIntersectoY()>0 && getX1()>0) c2 = true;
            if(getX1() < 0 && getY1()>0) c2 = true;
        }
        else
        {
            if(getX1() < 0 && getY1()>0) c2 = true;
            if(getIntersectoY()>0 && getX2()>0) c2 = true;
            if(getX2() < 0 && getY2()>0) c2 = true;
        }
        
        return c2;
    }//fin estaEnPrimerCuadranteII

    public boolean estaEnCuadranteIII() {
        boolean c3= false;
        if(xMayor() == getX1())
        {
            if(getX2() < 0 && getY2()<0) c3 = true;
            if(getIntersectoY()<0 && getX1()>0) c3 = true;
            if(getX1() < 0 && getY1()<0) c3 = true;
        }
        else
        {
            if(getX1() < 0 && getY1()<0) c3 = true;
            if(getIntersectoY()<0 && getX2()>0) c3 = true;
            if(getX2() < 0 && getY2()<0) c3 = true;
        }
        return c3;      
    }//fin estaEnCuadranteIII

    public boolean estaEnCuadranteIV() {
        boolean c4= false;
        if(xMayor() == getX1())
        {
            if(getX1() > 0 && getY1()<0) c4 = true;
            if(getIntersectoY()<0 && getX1()>0) c4 = true;
            if(getX2() > 0 && getY2()<0) c4 = true;
        }
        else
        {
            if(getX2() > 0 && getY2()<0) c4 = true;
            if(getIntersectoY()<0 && getX2()>0) c4 = true;
            if(getX1() > 0 && getY1()<0) c4 = true;
        }
        return c4;
    }//fin estaEnCuadranteIV

    public float getPendiente() {
        return (getY2()-getY1())/(getX2()-getX1());
    }

    public float getIntersectoY() {
        return getY2()-getPendiente()*getX2();
    }
}//fin clase Linea


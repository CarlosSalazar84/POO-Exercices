/**
 * Un ejemplo que modela un Circulo usando POO
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co)
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 */
public class Circulo {

    //COMPLETE las tres propiedades mínimas de un Circulo
    protected float origenX;
    protected float origenY;
    protected float radio;

    public Circulo() {
    }

    public Circulo(float origenX, float origenY, float radio) {
        //COMPLETE
        this.origenX=origenX;
        this.origenY=origenY;
        this.radio=radio;
    }
    
    public float getOrigenX()
    {
        return origenX;
    }
    public void setCentroX(float origenX)
    {
        this.origenX=origenX;
    }
    
    public float getOrigenY()
    {
        return origenY;
    }
    public void setCentroY(float origenY)
    {
        this.origenY=origenY;
    }
    
    public float getRadio()
    {
        return radio;
    }
    public void setRadio(float radio)
    {
        this.radio=radio;
    }


    /*complete GET / SET*/
    
    /**
     * 
     * @param x coordenada x del punto
     * @param y coordenada y del punto
     * @return
     */
    public String getPosicionPunto(float x, float y) {
        String ubicacion = "Ubicación Desconocida";

        if (puntoEstaDentro(x, y)) {
            ubicacion = "Punto Dentro del Círculo";
        } else if (puntoEstaEnBorde(x, y)) {
            ubicacion = "Punto En Borde de Círculo";
        } else {
            ubicacion = "Punto Fuera del Círculo";
        }

        return ubicacion;
    }//fin método getPosiciónPunto

    
    public boolean puntoEstaDentro(float x, float y) {
        boolean dentro = false;
        float distancia = (float)Math.sqrt(Math.pow(getOrigenX()-x,2)+Math.pow(getOrigenY()-y,2));
        if(distancia < getRadio()) dentro = true;
        
        
        return dentro;
    }//fin método puntoEstaDentro 
    
    public boolean puntoEstaFuera(float x, float y) {
        boolean fuera = false;
        float distancia = (float)Math.sqrt(Math.pow(getOrigenX()-x,2)+Math.pow(getOrigenY()-y,2));
        if(distancia > getRadio()) fuera = true;
        
        
        return fuera;
    }//fin método puntoEstaFuera
    
    public boolean puntoEstaEnBorde(float x, float y) {
        boolean borde = false;
        float distancia = (float)Math.sqrt(Math.pow(getOrigenX()-x,2)+Math.pow(getOrigenY()-y,2));
        if(distancia == getRadio()) borde = true;
        
        
        return borde;
    }//fin puntoEstaEnBordeSuperior
    
}//fin clase Circulo


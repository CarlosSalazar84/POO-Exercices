/**
 * Un sencillo ejercicio geométrico con un único objeto Rectangulo.
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co) 
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 */
class Rectangulo {

    /**Coordenada x del punto correspondiente a la esquina superior izquierda del Rectangulo*/
    protected float origenX;
    /**Coordenada y del punto correspondiente a la esquina superior izquierda del Rectangulo*/
    protected float origenY;
    /**Ancho del Rectangulo*/
    protected float ancho;
    /**Alto del Rectangulo*/
    protected float alto;


    /**
     * Constructor default
     */
    public Rectangulo(){

    }

    /**
     * Constructor con parámetros
     * @x el valor inicial para origenX
     * @y el valor inicial para origenY
     * @w el valor inicial para el ancho
     * @h el valor inicial para el alto
     */
    public Rectangulo(float x, float y, float w, float h){
        //COMPLETE para inicializar el Rectangulo con los valores de los parámetros
        origenX= x;
        origenY=y;
        ancho=w;
        alto= h;
        
    }

    /**
     * Determina la ubicación de unpunto con coordenadas x, y respecto al Rectangulo.
     * Las posibles salidas son:
     * "Punto Dentro del Rectángulo"
     * "Punto En Borde Superior"
     * "Punto en Borde Inferior"
     * "Punto en Borde Izquierdo"
     * "Punto en Borde Derecho"
     * "Punto Fuera del Rectángulo"
     * 
     * @param x coordenada x del punto para el cual se requiere determinar la ubicación
     * @param y coordenada y del punto para el cual se requiere determinar la ubicación
     * @return Un String indicando la ubicacion
     */
    public String getPosicionPunto(float x, float y) {
        String ubicacion = "Ubicación Desconocida";
        
        if(puntoEstaDentro(x, y)) ubicacion= "Punto Dentro del Rectángulo";
        else if(puntoEstaEnBordeSuperior(x, y)) ubicacion= "Punto En Borde Superior";
        else if(puntoEstaEnBordeInferior(x, y)) ubicacion="Punto en Borde Inferior";
        else if(puntoEstaEnBordeIzquierdo(x, y)) ubicacion= "Punto en Borde Izquierdo";
        else if(puntoEstaEnBordeDerecho(x, y)) ubicacion= "Punto en Borde Derecho";
        else if(puntoEstaFuera(x, y)) ubicacion = "Punto Fuera del Rectángulo";
        else{}

        return ubicacion;
    }//fin método getPosiciónPunto

    /**
     * Determina si un punto de coordenadas x,y se encuentran dentro de este Rectangulo
     * @param x coordenada x del punto para el cual se requiere determinar si está dentro del Rectanculo
     * @param y coordenada y del punto para el cual se requiere determinar si está dentro del Rectanculo
     * @return false  o true según corresponda
     */
    public boolean puntoEstaDentro(float x, float y) {
        float x2=getOrigenX()+getAncho();
        float y2= getOrigenY()-getAlto();
        
        return x>getOrigenX() && x<x2 && y<getOrigenY() && y>y2;
    }//fin método puntoEstaDentro 

    
    /**
     * Determina si un punto de coordenadas x,y se encuentran en el Borde Superior de este Rectangulo
     * @param x coordenada x del punto para el cual se requiere determinar si está en el Borde Superior del Rectanculo
     * @param y coordenada y del punto para el cual se requiere determinar si está en el Borde Superior del Rectanculo
     * @return false  o true según corresponda
     */
    public boolean puntoEstaEnBordeSuperior(float x, float y) {
        float x2=getOrigenX()+getAncho();
        return getOrigenY()== y && x>= getOrigenX() && x<= x2;
    }//fin puntoEstaEnBordeSuperior

    /**
     * Determina si un punto de coordenadas x,y se encuentran en el Borde Inferior de este Rectangulo
     * @param x coordenada x del punto para el cual se requiere determinar si está en el Borde Inferior del Rectanculo
     * @param y coordenada y del punto para el cual se requiere determinar si está en el Borde Inferior del Rectanculo
     * @return false  o true según corresponda
     */
    public boolean puntoEstaEnBordeInferior(float x, float y) {
        float x2=getOrigenX()+getAncho();
        float y2= getOrigenY()-getAlto();
        return y2== y && x>= getOrigenX() && x<= x2;
    }//fin puntoEstaEnBordeInferior

    /**
     * Determina si un punto de coordenadas x,y se encuentran en el Borde Izquierdo de este Rectangulo
     * @param x coordenada x del punto para el cual se requiere determinar si está en el Borde Izquierdo  del Rectanculo
     * @param y coordenada y del punto para el cual se requiere determinar si está en el Borde Izquierdo  del Rectanculo
     * @return false  o true según corresponda
     */
    public boolean puntoEstaEnBordeIzquierdo(float x, float y) {
        float y2= getOrigenY()-getAlto();
        return getOrigenX()==x && y<=getOrigenY() && y>=y2;
    }//fin puntoEstaEnBordeIzquierdo

    /**
     * Determina si un punto de coordenadas x,y se encuentran en el Borde Derecho de este Rectangulo
     * @param x coordenada x del punto para el cual se requiere determinar si está en el Borde Derecho del Rectanculo
     * @param y coordenada y del punto para el cual se requiere determinar si está en el Borde Derecho del Rectanculo
     * @return false  o true según corresponda
     */
    public boolean puntoEstaEnBordeDerecho(float x, float y) {
        float x2=getOrigenX()+getAncho();
        float y2= getOrigenY()-getAlto();
        return x2==x && y<=getOrigenY() && y>=y2;
    }//fin puntoEstaEnBordeDerecho

    /**
     * Determina si un punto de coordenadas x,y se encuentran fuera de este Rectangulo
     * @param x coordenada x del punto para el cual se requiere determinar si estáfuera del Rectanculo
     * @param y coordenada y del punto para el cual se requiere determinar si fuera del Rectanculo
     * @return false  o true según corresponda
     */
    public boolean puntoEstaFuera(float x, float y) {
        float x2=getOrigenX()+getAncho();
        float y2= getOrigenY()-getAlto();
        
        return x<getOrigenX() || x>x2  ||y>getOrigenY() || y<y2;
    }//fin puntoEstaFuera

    /**Metodo de acceso a la propiedad origenX*/
    public float getOrigenX(){
        return origenX;//Complete algoritmo
    }//end method getOrigenX

    /**Metodo de modificación a la propiedad origenX*/
    public void setOrigenX(float newOrigenX){
        //Complete algoritmo
        this.origenX= newOrigenX;
    }//end method setOrigenX

    /**Metodo de acceso a la propiedad origenY*/
    public float getOrigenY(){
        return origenY;//Complete algoritmo
    }//end method getOrigenY

    /**Metodo de modificación a la propiedad origenY*/
    public void setOrigenY(float origenY){
        this.origenY= origenY;
        //Complete algoritmo
    }//end method setOrigenY

    /**Metodo de acceso a la propiedad ancho*/
    public float getAncho(){
        return ancho;//Complete algoritmo
    }//end method getAncho

    /**Metodo de modificación a la propiedad ancho*/
    public void setAncho(float ancho){
        //Complete algoritmo
        this.ancho=ancho;
    }//end method setAncho

    /**Metodo de acceso a la propiedad alto*/
    public float getAlto(){
        return alto;//Complete algoritmo
    }//end method getAlto

    /**Metodo de modificación a la propiedad alto*/
    public void setAlto(float alto){
        this.alto=alto;
        //Complete algoritmo
    }//end method setAlto
    

}//fin clase Rectangulo
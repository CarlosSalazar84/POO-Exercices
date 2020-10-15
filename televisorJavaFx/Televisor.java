
/**
 * Un ejemplo que modela un Televisor simple usando POO
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co)
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 */
public class Televisor
{
    /**
     * Tipo de entrada
     *   0 = Apagado
     *   1 = Antena (maximo 13 canales)
     *   2 = Cable (el maximo de canales es 100)
     *   3 = Auxiliar (DVD, VH, etc), un canal
     **/
    protected int tipoDeEntrada;

    /**Volumen del televisor*/
    protected int volumen;

    /**
     * Canal sintonizado, si la entrada es auxiliar, el canal es el 1, 2 ó 3
     **/
    protected int canal;

    /**Constante maximo volumen*/
    public static final int maximoVolumen = 20;

    /**Constante tipo de entarda apagado*/
    public static final int apagado = 0;

    /**Constante tipo de entarda antena*/
    public static final int antena = 1;

    /**Constante tipo de entarda cable*/
    public static final int cable = 2;

    /**Constante tipo de entarda auxiliar*/
    public static final int auxiliar = 3;

    /**Arreglo constante con máximo de canales por tipo de entrada*/
    public static final int [] cantidadDeCanales = {0, 13, 100, 3};

    /**Arreglo constante con nombres de cada entrada*/
    public static final String [] tiposDeEntrada = {"Apagado", "Antena", "Cable", "Auxiliar"};

    /**Constructor que inicializa con valores por defecto*/
    public Televisor(){

    }//Fin constructor default

    /***
     * Construye un televisor inicializando sus propiedades con los parámetros recibidos
     * @param    tipoDeEntrada valor inicial de la propiedad tipoDeEntrada
     * @param    volumen valor inicial de la propiedad volumen
     * @param    canal valor inicial de la propiedad canal
     */
    public Televisor(int tipoDeEntrada, int volumen, int canal){
        this.tipoDeEntrada = tipoDeEntrada;
        this.canal = canal;
        this.volumen = volumen;
    }//Fin constructor con parámetros

    /***
     * Sube el volumen del televisor
     * @return  true si pudo subirlo, false si llegó al máximo
     */
    public boolean subirVolumen(){
        boolean sePuedeSubir = false;
        if(getVolumen() < maximoVolumen){
            this.volumen++;
            sePuedeSubir = true;
        }
        return sePuedeSubir;
    }//fin método subirVolumen

    /***
     * Baja el volumen del televisor
     * @return  true si pudo bajar, false si llegó al mínimo (0)
     */
    public boolean bajarVolumen(){
        boolean sePuedeBajar = false;
        if(getVolumen() > 0){
            this.volumen--;
            sePuedeBajar = true;
        }
        return sePuedeBajar;
    }//fin método bajarVolumen

    /***
     * Avanza el canal del televisor, si llega al máximo regresa al mínimo
     */
    public void avanzarCanal(){
        if(this.canal != 0){
            if(this.canal < getMaximoCanal()){
                this.canal++;
            }
            else{
                this.canal = 1;
            }
        }
    }//fin método subirVolumen

    /***
     * Retrocede el canal del televisor, si llega al mínimo pasa al máximo
     */
    public void retrocederCanal(){
        if(this.canal != 0){
            if(this.canal > 1){
                this.canal--;
            }
            else{
                this.canal = getMaximoCanal();
            }
        }
    }//fin método subirVolumen        

    /**
     * Método de acceso al canal máximo según la entrada
     * @return el valor del máximo canal
     */
    public int getMaximoCanal(){
        int maximoCanal= 0;
        maximoCanal = cantidadDeCanales[tipoDeEntrada];
        return maximoCanal;
    }//fin getVolumen

    /**
     * Método de acceso a la propiedad volumen
     * @return el valor de volumen para éste objeto Televisor
     */
    public int getVolumen(){
        return this.volumen;
    }//fin getVolumen
    
    public int getNumTipoDeEntrada(){
        return this.tipoDeEntrada;
    }

    /***
     * Método para modificación de la propiedad volumen
     * @param   volumen el nuevo valor de la propiedad volumen
     */
    public void setVolumen(int volumen){
        this.volumen = volumen;
    }//fin setVolumen   

    /**
     * Método de acceso a la propiedad canal
     * @return el valor de canal para éste objeto Televisor
     */
    public int getCanal(){
        return this.canal;
    }//fin getCanal

    /***
     * Método para modificación de la propiedad canal
     * @param   canal el nuevo valor de la propiedad canal
     */
    public void setCanal(int canal){
        this.canal = canal;
    }//fin setCanal

    /**
     * Método de acceso a la propiedad tipoDeEntrada
     * @return el valor de tipoDeEntrada para éste objeto Televisor
     */
    public String getTipoDeEntrada(){
        String rta = null;
        rta = tiposDeEntrada[tipoDeEntrada];
        return rta;
    }//fin getTipoDeEntrada

    /***
     * Método para modificación de la propiedad tipoDeEntrada
     * @param   tipoDeEntrada el nuevo valor de la propiedad tipoDeEntrada
     */
    public void setTipoDeEntrada(int tipoDeEntrada){
        tipoDeEntrada %= 4;
        this.tipoDeEntrada = tipoDeEntrada;
        this.canal = cantidadDeCanales[tipoDeEntrada];
    }//fin setTipoDeEntrada

    /***
     * Regresa una cadena String con los datos del Televisor
     * @override java.lang.Object.toString
     */
    public String toString(){
        String str = "\n**********Televisor**********\n";
        str = str + "Entrada: " + this.getTipoDeEntrada()+"\n";
        str = str + "Canal: "  + this.getCanal()+"\n";
        str = str + "Volumen: "  + this.getVolumen()+"\n";
        return str;
    }//fin toString

}//fin clase Televisor

/**
 * Un ejemplo que modela un Televisor simple usando POO
 * 
 * @author (Carlos Alberto Salazar Meza - carlosalbertosame@ufps.edu.co)
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 */
public class Televisor
{
    protected int tipoDeEntrada;

    protected int volumen;

    protected int canal;

    public static final int maximoVolumen = 20;

    public static final int apagado = 0;

    public static final int antena = 1;

    public static final int cable = 2;

    public static final int auxiliar = 3;

    public static final int [] cantidadDeCanales = {0, 13, 100, 3};

    public static final String [] tiposDeEntrada = {"Apagado", "Antena", "Cable", "Auxiliar"};

    public Televisor(){

    }//Fin constructor default

    public Televisor(int tipoDeEntrada, int volumen, int canal){
        this.tipoDeEntrada = tipoDeEntrada;
        this.canal = canal;
        this.volumen = volumen;
    }//Fin constructor con parámetros

    public boolean subirVolumen(){
        boolean sePuedeSubir = false;
        if(getVolumen() < maximoVolumen){
            this.volumen++;
            sePuedeSubir = true;
        }
        return sePuedeSubir;
    }//fin método subirVolumen

    public boolean bajarVolumen(){
        boolean sePuedeBajar = false;
        if(getVolumen() > 0){
            this.volumen--;
            sePuedeBajar = true;
        }
        return sePuedeBajar;
    }//fin método bajarVolumen

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

    public int getMaximoCanal(){
        int maximoCanal= 0;
        maximoCanal = cantidadDeCanales[tipoDeEntrada];
        return maximoCanal;
    }//fin getVolumen

    public int getVolumen(){
        return this.volumen;
    }//fin getVolumen
    
    public int getNumTipoDeEntrada(){
        return this.tipoDeEntrada;
    }

    public void setVolumen(int volumen){
        this.volumen = volumen;
    }//fin setVolumen   

    public int getCanal(){
        return this.canal;
    }//fin getCanal

    public void setCanal(int canal){
        this.canal = canal;
    }//fin setCanal

    public String getTipoDeEntrada(){
        String rta = null;
        rta = tiposDeEntrada[tipoDeEntrada];
        return rta;
    }//fin getTipoDeEntrada

    public void setTipoDeEntrada(int tipoDeEntrada){
        tipoDeEntrada %= 4;
        this.tipoDeEntrada = tipoDeEntrada;
        this.canal = cantidadDeCanales[tipoDeEntrada];
    }//fin setTipoDeEntrada

    public String toString(){
        String str = "\n**********Televisor**********\n";
        str = str + "Entrada: " + this.getTipoDeEntrada()+"\n";
        str = str + "Canal: "  + this.getCanal()+"\n";
        str = str + "Volumen: "  + this.getVolumen()+"\n";
        return str;
    }//fin toString

}//fin clase Televisor
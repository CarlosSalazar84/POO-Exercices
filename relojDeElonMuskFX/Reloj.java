/**
 * Un ejemplo que modela un Reloj simple usando POO
 * 
 * @author (Milton Jesús Vera Contreras - miltonjesusvc@ufps.edu.co)
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 */
public class Reloj 
{
    //COMPLETE   
    protected int segundos;
    protected int minutos;
    protected int horas;   

    /**Debe inicializar a la media noche o medio dia 12:00:00*/
    public Reloj(){
        //COMPLETE   
        this.segundos=0;
        this.minutos=0;
        this.horas=12;
    }

    /**Inicializa de acuerdo con los parametros*/
    public Reloj(int segundos, int minutos, int horas){
        //COMPLETE   
        this.segundos = segundos;
        this.minutos = minutos;
        this.horas = horas;
    }

    /**Metodo de acceso a la propiedad segundos*/
    public int getSegundos(){
        return this.segundos;
    }//end method getSegundos

    /**Metodo de modificaci�n a la propiedad segundos*/
    public void setSegundos(int segundos){
        this.segundos = segundos;
    }//end method setSegundos

    /**Metodo de acceso a la propiedad minutos*/
    public int getMinutos(){
        return this.minutos;
    }//end method getMinutos

    /**Metodo de modificaci�n a la propiedad minutos*/
    public void setMinutos(int minutos){
        this.minutos = minutos;
    }//end method setMinutos

    /**Metodo de acceso a la propiedad horas*/
    public int getHoras(){
        return this.horas;
    }//end method getHoras

    /**Metodo de modificaci�n a la propiedad horas*/
    public void setHoras(int horas){
        this.horas = horas;
    }//end method setHoras

    /*De aqui en adelante Ud. debe completar los algoritmos para que el programa funcione*/
    //COMPLETE GETTER Y SETTER
    /**Metodo para avanzar el segundero*/ 
    public void avanzarSegundero(){
        //COMPLETE
        if(segundos < 59) segundos++;
        else
        {
            segundos=0;
            avanzarMinutero();
        }
        
    }

    /**Metodo para retroceder el segundero*/ 
    public void retrocederSegundero(){
        //COMPLETE
        if(segundos>0) segundos--;
        else
        {
            segundos=59;
            retrocederMinutero();
        }

        //COMPLETE EL ALGORITMO

    }
    /**Metodo para avanzar el minutero*/ 
    public void avanzarMinutero(){
        //COMPLETE    
        if(minutos < 59) minutos++;
        else
        {
            minutos=0;
            avanzarHorario();
        }
    }

    /**Metodo para avanzar el minutero*/ 
    public void retrocederMinutero(){
        //COMPLETE    
        if(minutos>0) minutos--;
        else
        {
            minutos=59;
            retrocederHorario();
        }
    }

    /**Metodo para avanzar el horario*/ 
    public void avanzarHorario(){
        //COMPLETE
        if(horas < 12) horas++;
        else horas=1;
    }

    /**Metodo para avanzar el horario*/ 
    public void retrocederHorario(){
        if(horas>1)horas--;
        else horas=12;
        //COMPLETE
    }

}

/**
 * @author: Andrés Camilo Castellanos andrescamilocasa@ufps.edu.co
 * @version: 0.01
 */
public class ModelReloj
{
   protected int segundos;
   protected int minutos;
   protected int horas;   
   
   public ModelReloj(){

   }
   
   public ModelReloj(int segundos, int minutos, int horas){
     this.segundos = segundos;
     this.minutos = minutos;
     this.horas = horas;
   }

   /**Metodo de acceso a la propiedad segundos*/
    public int getSegundos(){
        return this.segundos;
    }//end method getSegundos

    /**Metodo de modificación a la propiedad segundos*/
    public void setSegundos(int segundos){
        this.segundos = segundos;
    }//end method setSegundos

    /**Metodo de acceso a la propiedad minutos*/
    public int getMinutos(){
        return this.minutos;
    }//end method getMinutos

    /**Metodo de modificación a la propiedad minutos*/
    public void setMinutos(int minutos){
        this.minutos = minutos;
    }//end method setMinutos

    /**Metodo de acceso a la propiedad horas*/
    public int getHoras(){
        return this.horas;
    }//end method getHoras

    /**Metodo de modificación a la propiedad horas*/
    public void setHoras(int horas){
        this.horas = horas;
    }//end method setHoras

   /*De aqui en adelante Ud. debe completar los algoritmos para que el programa funcione*/
   
   /**Metodo para mover le segundero*/ 
   public void moverSegundero(){
     segundos = (segundos+1) % 60;
     if(segundos==0) moverMinutero(); 
   }

   /**Metodo para mover le minutero*/ 
   public void moverMinutero(){
     minutos = (minutos+1) % 60;
     if(minutos==0) moverHorario();
   }

   /**Metodo para mover le horario*/ 
   public void moverHorario(){  
     horas = (horas+1) % 12;
   }
    

}
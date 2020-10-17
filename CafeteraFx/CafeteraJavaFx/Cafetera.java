
/**
 * Complete
 * @author: Andrés Camilo Castellanos andrescamilocasa@ufps.edu.co
 * @version: 0.01
 */
class Cafetera { 

    private int cafe;
    private int azucar;
    private int vasos;
    private int precioBaseCafe;
    private int egresos;
    private int ingresos;
    private int gananciasBrutas;
    private int impuestos;
    private int gananciasNetas;
    private int cafeDeseado;
    private int azucarDeseada;
    
    /*No requiere propiedades adicionales, pero es libre de usarlas*/

    Cafetera(){
        cafe = 0;
        azucar = 0;
        vasos = 0;
        precioBaseCafe = 0;
        egresos = 0;
        ingresos = 0;
        gananciasBrutas = 0;
        impuestos = 0;
        gananciasNetas = 0;
    }

    Cafetera(int cantidadInicialCafe, int cantidadInicialAzucar, int cantidadInicialVasos){
        cafe = cantidadInicialCafe;
        azucar = cantidadInicialAzucar;
        vasos = cantidadInicialVasos;
    }

    //complete metodos GET / SET

    public int calcularPrecio(){
        int precioCalculado = 0;
        if(this.cafeDeseado != 0 && this.azucarDeseada != 0){
            precioCalculado += precioBaseCafe * getGramosCafe(this.cafeDeseado);
            precioCalculado += (precioCalculado * getGramosAzucar(this.azucarDeseada))/100;
            precioCalculado += (precioCalculado * 15) / 100;
        }
        return precioCalculado;
    }

    public void recargarCafe(int cantidadCafe, int costoCompraCafe){
        egresos += costoCompraCafe;
        cafe += cantidadCafe;
    }

    public void recargarAzucar(int cantidadAzucar, int costoCompraAzucar){
        egresos += cantidadAzucar* costoCompraAzucar;
        azucar += cantidadAzucar;
    }

    public void recargarVasos(int cantidadVasos, int costoCompraVasos){
        egresos += cantidadVasos*costoCompraVasos;
        vasos += cantidadVasos;
    }

    public boolean prepararCafe(){
        boolean trial = false;
        if(this.cafe >= getGramosCafe(this.cafeDeseado) && this.azucar >= getGramosAzucar(this.azucarDeseada) && this.vasos > 0){
            this.cafe -= getGramosCafe(this.cafeDeseado);
            this.azucar -= getGramosAzucar(this.azucarDeseada);
            this.vasos--;
            trial = true;
        }
        return trial;
    }

    public void registrarFactura(int valorFactura){
        ingresos += valorFactura;
        gananciasBrutas = ingresos - egresos;
        impuestos = ingresos * 16/100;
        gananciasNetas = gananciasBrutas - impuestos;
    }
    
    public int getGramosCafe(int cafeDeseado){
        int gramos=0;
        switch(cafeDeseado){
            case 1: 
                gramos = 55;
                break;
            case 2:
                gramos = 110;
                break;
            case 3:
                gramos = 165;
                break;
        }
        return gramos;
    }
    
    public int getGramosAzucar(int azucarDeseada){
        int gramos=0;
        switch(azucarDeseada){
            case 2:
                gramos = 5;
                break;
            case 3:
                gramos = 10;
                break;
        }
        return gramos;
    }
    
    //Start GetterSetterExtension Code
    /**Getter method cafe*/
    public int getCafe(){
        return this.cafe;
    }//end method getCafe

    /**Getter method azucar*/
    public int getAzucar(){
        return this.azucar;
    }//end method getAzucar

    /**Getter method vasos*/
    public int getVasos(){
        return this.vasos;
    }//end method getVasos

    /**Getter method precioBaseCafe*/
    public int getPrecioBaseCafe(){
        return this.precioBaseCafe;
    }//end method getPrecioBaseCafe

    /**Setter method precioBaseCafe*/
    public void setPrecioBaseCafe(int precioBaseCafe){
        this.precioBaseCafe = precioBaseCafe;
    }//end method setPrecioBaseCafe

    /**Getter method egresos*/
    public int getEgresos(){
        return this.egresos;
    }//end method getEgresos

    /**Setter method egresos*/
    public void setEgresos(int egresos){
        this.egresos = egresos;
    }//end method setEgresos

    /**Getter method ingresos*/
    public int getIngresos(){
        return this.ingresos;
    }//end method getIngresos

    /**Setter method ingresos*/
    public void setIngresos(int ingresos){
        this.ingresos = ingresos;
    }//end method setIngresos

    /**Getter method gananciasBrutas*/
    public int getGananciasBrutas(){
        return this.gananciasBrutas;
    }//end method getGananciasBrutas

    /**Setter method gananciasBrutas*/
    public void setGananciasBrutas(int gananciasBrutas){
        this.gananciasBrutas = gananciasBrutas;
    }//end method setGananciasBrutas

    /**Getter method impuestos*/
    public int getImpuestos(){
        return this.impuestos;
    }//end method getImpuestos

    /**Setter method impuestos*/
    public void setImpuestos(int impuestos){
        this.impuestos = impuestos;
    }//end method setImpuestos

    /**Getter method gananciasNetas*/
    public int getGananciasNetas(){
        return this.gananciasNetas;
    }//end method getGananciasNetas

    /**Setter method gananciasNetas*/
    public void setGananciasNetas(int gananciasNetas){
        this.gananciasNetas = gananciasNetas;
    }//end method setGananciasNetas

    /**Setter method cafe*/
    public void setCafe(int cafe){
        this.cafe = cafe;
    }//end method setCafe

    /**Setter method azucar*/
    public void setAzucar(int azucar){
        this.azucar = azucar;
    }//end method setAzucar

    /**Setter method vasos*/
    public void setVasos(int vasos){
        this.vasos = vasos;
    }//end method setVasos

    /**Getter method cafeDeseado*/
    public int getCafeDeseado(){
        return this.cafeDeseado;
    }//end method getCafeDeseado

    /**Setter method cafeDeseado*/
    public void setCafeDeseado(int cafeDeseado){
        this.cafeDeseado = cafeDeseado;
    }//end method setCafeDeseado

    /**Getter method azucarDeseada*/
    public int getAzucarDeseada(){
        return this.azucarDeseada;
    }//end method getAzucarDeseada

    /**Setter method azucarDeseada*/
    public void setAzucarDeseada(int azucarDeseada){
        this.azucarDeseada = azucarDeseada;
    }//end method setAzucarDeseada

    //End GetterSetterExtension Code
//!
}

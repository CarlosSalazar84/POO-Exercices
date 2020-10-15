
/**
 * Un ejemplo que modela una Casa de Cambio de Bolívares usando POO
 * 
 * @author (Carlos Alberto Salazar Meza)
 * @version 0.000000000000001 :) --> Math.sin(Math.PI-Double.MIN_VALUE)
 * History: Septiembre 2020 / Octubre 2020
 */
public class CasaDeCambio{

    protected float precioDeCompra;
    protected float precioDeVenta;
    protected int bolivaresComprados;
    protected int bolivaresVendidos;
    protected float bolivaresEnCaja;
    protected float pesosEnCaja;
    protected float impuestos;
    protected float ganancias;

    public CasaDeCambio(){
    }

    public float getPrecioDeCompra(){
        return this.precioDeCompra;
    } 

    public float getPrecioDeVenta(){
        return this.precioDeVenta;
    }

    public int getBolivaresComprados(){
        return this.bolivaresComprados;
    }

    public int  getBolivaresVendidos(){
        return this.bolivaresVendidos;
    }

    public float getBolivaresEnCaja(){
        return this.bolivaresEnCaja;
    }

    public float getPesosEnCaja(){
        return this.pesosEnCaja;
    }

    public float getGananciaEnUnBolivar(){
        return precioDeVenta - this.precioDeCompra;
    }

    public boolean cambiarPrecioDelBolivar(float precioDeCompra, float precioDeVenta){
        boolean precioValido = false;
        if(precioDeCompra > 0 && precioDeVenta > 0 && precioDeVenta > precioDeCompra){
            this.precioDeCompra = precioDeCompra;
            this.precioDeVenta = precioDeVenta;
            precioValido = true;
        }
        return precioValido;
    }//fin cambiarPrecioDelBolivar

    public boolean comprarBolivares(int cantidad){
        boolean puedeComprar = false;
        if(this.pesosEnCaja > 0 && this.pesosEnCaja - this.impuestos >= cantidad * precioDeCompra){
            if(this.pesosEnCaja - this.ganancias < cantidad * precioDeCompra){
                this.ganancias -= (cantidad * precioDeCompra) - (this.pesosEnCaja - this.ganancias);
            }
            this.pesosEnCaja -= cantidad * precioDeCompra;
            this.bolivaresEnCaja += cantidad;
            this.bolivaresComprados += cantidad;
            puedeComprar = true;
        }
        return puedeComprar;
    }//fin comprarBolivares

    public boolean venderBolivares(int cantidad){
        boolean puedeVender = false;
        if(this.bolivaresEnCaja >= cantidad){
            this.pesosEnCaja +=  cantidad * precioDeVenta;
            this.bolivaresVendidos += cantidad;
            this.ganancias += cantidad * precioDeVenta;
            this.bolivaresEnCaja -= cantidad;
            calcularImpuestos(cantidad);
            puedeVender = true;
        }
        return puedeVender;
    }//fin venderBolivares

    public float getImpuestos(){
        return this.impuestos;
    }//fin getImpuestos

    private void calcularImpuestos(int cantidadVendida){
        this.impuestos += (cantidadVendida * precioDeVenta * 16)/100;
    }//fin getImpuestos

    public float getGanancias(){
        return this.ganancias - getImpuestos();
    }//fin getGanancias

    public void inyectarPesos(int cantidad){
        if(cantidad > 0){
            pesosEnCaja += cantidad;
        }
    }//fin inyectarPesos

    public void inyectarBolivares(int cantidad){
        if(cantidad > 0){
            bolivaresEnCaja += cantidad;
        }
    }

}//End class


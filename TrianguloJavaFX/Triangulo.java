/**
 * Un ejemplo que modela un Triangulo usando POO
 * 
 * @author: Andrés Camilo Castellanos andrescamilocasa@ufps.edu.co
 * @version: 0.01
 */
public class Triangulo {

    float lado1,lado2,lado3;

    public Triangulo() {
        lado1=0;
        lado2=0;
        lado3=0;
    }

    public Triangulo(float lado1, float lado2, float lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    /*complete GET/SET*/
    public void setLado1(float lado1){
        this.lado1 = lado1;
    }
    
    public void setLado2(float lado2){
        this.lado2 = lado2;
    }
    
    public void setLado3(float lado3){
        this.lado3 = lado3;
    }
    
    public String getTipo() {
     String tipo = "Desconocido";

     if(lado1==lado2 && lado2==lado3)
      tipo = "Equilatero";
     else {
      if(lado1!=lado2 && lado1!=lado3 && lado2!=lado3)
        tipo = "Escaleno";
      else
        tipo = "Isosceles";
      /*if(esRectangulo())
       tipo = tipo + " Rectángulo";*/
     }//fin else
     
     return tipo;
    }//fin método getTipo
    
    public boolean esRectangulo()
    {
      boolean trial;
      trial= lado1*lado1 == (lado2*lado2 + lado3*lado3) ||
             lado2*lado2 == (lado1*lado1 + lado3*lado3) ||
             lado3*lado3 == (lado2*lado2 + lado1*lado1);
      return trial;//complete
    }//fin método esRectangulo
    
}//fin clase Triangulo
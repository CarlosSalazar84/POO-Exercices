public class Libro
{

    protected String titulo;

    protected String editorial;

    protected String autores;

    protected int anioEdicion;

    protected int numeroDeHojas;

    protected int precio;

    protected int numeroDeCopias;

    protected int numeroDeCopiasPrestadas;

    public Libro(){

    }//Fin constructor default

    public Libro(int anioEdicion, int numeroDePaginas,int precio, String titulo, String editorial,String autores, int numeroDeCopias){
        this.anioEdicion = anioEdicion;
        this.numeroDeHojas = numeroDePaginas;
        this.precio = precio;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autores = autores;
        this.numeroDeCopias = numeroDeCopias;

    }//Fin constructor con par�metros

    public String getTitulo(){
        return this.titulo;
    }//fin getTitulo

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }//fin setTitulo

    public String getEditorial(){
        return this.editorial;
    }//fin getEditorial

    public void setEditorial(String editorial){
        this.editorial = editorial;
    }//fin setEditorial

    public String getAutores(){
        return this.autores;
    }//fin getAutores

    public void setAutores(String autores){
        this.autores = autores;
    }//fin setAutores

    public int getAnioEdicion(){
        return this.anioEdicion;
    }//fin getAñoEdicion

    public void setAnioEdicion(int anioEdicion){
        this.anioEdicion = anioEdicion;
    }//fin setAñoEdicion

    public int getNumeroDePaginas(){
        return this.numeroDeHojas;
    }//fin getNumeroDePaginas

    public void setNumeroDePaginas(int numeroDePaginas){
        this.numeroDeHojas = numeroDePaginas;
    }//fin setNumeroDePaginas

    public int getPrecio(){
        return this.precio;
    }//fin getPrecio

    public void setPrecio(int precio){
        this.precio = precio;
    }//fin setPrecio

    public int getNumeroDeCopias(){
        return this.numeroDeCopias;
    }//fin getNumeroDeCopias

    public int getNumeroDeCopiasPrestadas(){
        return this.numeroDeCopiasPrestadas;
    }//fin getNumeroDeCopiasPestadas

    public int getNumeroDeCopiasDisponibles(){
        return this.numeroDeCopias - this.numeroDeCopiasPrestadas;
    }//fin getNumeroDeCopiasDisponibles

    public boolean prestar(){
        boolean accionCompleta = false;;
        if(getNumeroDeCopiasDisponibles() > 0){
            this.numeroDeCopiasPrestadas++;
            accionCompleta = true;
        }
        return accionCompleta;
    }//fin m�todo prestar

    public boolean devolver(){
        boolean accionCompleta = false;
        if(getNumeroDeCopiasPrestadas() > 0){
            this.numeroDeCopiasPrestadas--;
            accionCompleta = true;
        }
        return accionCompleta;
    }//fin m�todo devolver

    public boolean cambiarNumeroDeCopias(int numeroDeCopias){
        boolean accionCompleta = false;
        if(numeroDeCopias >= getNumeroDeCopiasPrestadas()){
            this.numeroDeCopias = numeroDeCopias;
            accionCompleta = true;
        }
        return accionCompleta;
    }//fin setNumeroDeCopias

    public String toString(){
        String str = "\n**********Libro**********\n";
        str = str + "Titulo: " + this.getTitulo()+"\n";
        str = str + "Autores: "  + this.getAutores()+"\n";
        str = str + "Editorial: "  + this.getEditorial()+"\n";
        str = str + "Año: "  + this.getAnioEdicion()+"\n";
        str = str + "Paginas: "  + this.getNumeroDePaginas()+"\n";
        str = str + "Precio: "  + this.getPrecio()+"\n";      
        str = str + "Copias: "  + this.getNumeroDeCopias()+"\n";
        str = str + "Copias Disponibles: "  + this.getNumeroDeCopiasDisponibles()+"\n";
        str = str + "Copias Prestadas: "  + this.getNumeroDeCopiasPrestadas()+"\n";
        return str;
    }

}
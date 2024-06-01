public class Comentario{
    private String mensaje;

    private double critica;


    public Comentario(String mensaje, double critica ) {
        this.mensaje = mensaje;
        this.critica = critica;
    }

    public String getMensaje(){
        return mensaje;
    }
    public double getCritica(){
        return critica;
    }
}

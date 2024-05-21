public class Comentario extends CodigoManga{

    private int cantidadComentarios;

    private String comentario;

    private String mensaje;

    private double critica;


    public Comentario(int isbn,int cantidadComentarios,String comentario, String mensaje, double critica ) {
        super(isbn);
        this.cantidadComentarios = cantidadComentarios;
        this.comentario = comentario;
        this.mensaje = mensaje;
        this.critica = critica;
    }
    public int getCantidadComentarios(){
        return cantidadComentarios;
    }
    public String getComentario(){
        return comentario;
    }
    public String getMensaje(){
        return mensaje;
    }
    public double getCritica(){
        return critica;
    }
}

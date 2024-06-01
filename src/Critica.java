import java.util.ArrayList;

public class Critica extends CodigoManga{

    private int cantidad_Comentarios;

    private ArrayList<Comentario> comentarios;

    public Critica(int isbn, int cantidad_Comentarios, ArrayList<Comentario> comentarios){
        super(isbn);
        this.cantidad_Comentarios = cantidad_Comentarios;
        this.comentarios = new ArrayList<>();
    }

    public int getCantidad_Comentarios(){
        return cantidad_Comentarios;
    }

    public ArrayList<Comentario> comentarios(){
        return comentarios;
    }






}

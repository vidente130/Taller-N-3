public class Compra extends CodigoManga {

    private int idNumero;
    private int id_usuario;

    private String estado;

    private String fecha;

    private int cantidadCompra;


    public Compra(String isbn,int idNumero,int id_usuario, String estado, String fecha, int cantidadCompra) {
        super(isbn);
        this.idNumero = idNumero;
        this.id_usuario = id_usuario;
        this.estado = estado;
        this.fecha = fecha;
        this.cantidadCompra = cantidadCompra;
    }

    public int getIdNumero(){ return idNumero; }
    public int getId_usuario(){
        return id_usuario;
    }
    public String getEstado(){
        return estado;
    }
    public String getFecha(){
        return fecha;
    }
    public int getCantidadCompra(){
        return cantidadCompra;
    }

    public void setIdNumero(int idNumero){
        this.idNumero = idNumero;
    }
    public void setId_usuario(int id_usuario){
        this.id_usuario = id_usuario;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setFecha (String fecha){
        this.fecha = fecha;
    }
    public void setCantidadCompra(int cantidadCompra){
        this.cantidadCompra = cantidadCompra;
    }
}

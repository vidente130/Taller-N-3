public class Usuario {

    private String tipoDeUsuario;

    private String nombreDeUsuario;

    private int id;

    private String contrasenia;

    private int administrador_id;


    public Usuario(String tipoDeUsuario, String nombreDeUsuario,int id, String contrasenia, int administrador_id){
        this.tipoDeUsuario = tipoDeUsuario;
        this.nombreDeUsuario = nombreDeUsuario;
        this.id = id;
        this.contrasenia = contrasenia;
        this.administrador_id = administrador_id;
    }

    public String getTipoDeUsuario(){
        return tipoDeUsuario;
    }
    public String getNombreDeUsuario(){
        return nombreDeUsuario;
    }
    public int getId(){
        return id;
    }
    public String getContrasenia(){
        return contrasenia;
    }
    public int getAdministrador_id(){
        return administrador_id;
    }


}

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaImpl implements Sistema{

    private ArrayList<Usuario> usuarios;

    private ArrayList<Manga> mangas;

    private ArrayList<Comentario> comentarios;

    private ArrayList<Compra> compras;

    public SistemaImpl() {
        this.usuarios = new ArrayList<>();
        this.mangas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.compras = new ArrayList<>();
    }
    Scanner opcion = new Scanner(System.in);

    @Override
    public void menu() {

        cargarArchivos();

        mensajeMenu1();
        String pregunta = opcion.nextLine();
        while (true){
            switch(pregunta){
                case "1":

                    break;
                case "2":

                    break;

                default:
                    return;


            }

            mensajeMenu1();
            pregunta = opcion.nextLine();
        }


    }

    public void iniciarUsuario(){

    }

    @Override
    public void mensajeMenu1() {

        System.out.println("-----Bienvenido a FUente Manga-----");
        System.out.println("1.- Iniciar sesion como usuario");
        System.out.println("2.- Iniciar sesion como administrador");
        System.out.println("Elija una opcion");
    }

    @Override
    public void mensajeMenu2() {

    }

    @Override
    public void mensajeMenu3() {

    }

    @Override
    public void mensajeMenu4() {

    }

    @Override
    public void mensajeMenu5() {

    }

    @Override
    public void cargarArchivos() {
        In in = new In("users.csv");
        int tamanio1 = 0;

        String linea = in.readLine();

        while (linea != null){

            System.out.println(linea);
            String[] campos = linea.split(",");

            String usuarios = campos[0];
            String nombres = campos[1];
            int id = Integer.parseInt(campos[2]);
            String contrasenias = campos[3];
            int id_administrador = Integer.parseInt(campos[4]);
            if (id_administrador != null){
            }


            Usuario usuario = new Usuario(usuarios,nombres,id,contrasenias,id_administrador);
            linea = in.readLine();

        }



    }

    @Override
    public void registrarManga(String titulo, int isbn, int stock, String descripcion, int precio) {

    }

    @Override
    public void verUltimosMangas() {

    }

    @Override
    public void actualizarCompra(int isbn) {

    }

    @Override
    public void estadisticas() {

    }

    @Override
    public void salir1() {

    }

    @Override
    public void buscarManga(String titulo) {

    }

    @Override
    public void mangasComprados() {

    }

    @Override
    public void valorarManga(int isbn) {

    }

    @Override
    public void verComentarios(int isbn) {

    }

    @Override
    public void comprarManga(int isbn) {

    }

    @Override
    public void salir2() {

    }
}

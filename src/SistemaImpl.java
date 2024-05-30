import java.util.ArrayList;
import java.util.Scanner;
import edu.princeton.cs.stdlib.In;

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

        System.out.println(usuarios.get(1).getNombreDeUsuario());
        mensajeMenu1();
        String pregunta = opcion.nextLine();
        while (true){
            switch(pregunta){
                case "1":
                    iniciarUsuario();
                    break;
                case "2":
                    iniciarUsuario2();

                    break;
                case "3" :

                    return;
            }

            mensajeMenu1();
            pregunta = opcion.nextLine();
        }


    }

    public void iniciarUsuario(){

        System.out.println("Escriba su nombre de usuario:");
        String nombre = opcion.nextLine();
        System.out.println("Escriba su contraseña:");
        String contrasenia = opcion.nextLine();
        iniciarUsuario(nombre, contrasenia);
    }

    public void iniciarUsuario(String nombre, String contrasenia) {
        System.out.println("Buenos dias señor/señorita " + nombre);
        mensajeMenu2();
        String pregunta = opcion.nextLine();
        switch (pregunta){
            case "1":

            case "2":

            case "3":

            case "4":

            case "5":

            case "6":
                System.out.println("Saliendo del sistema");
                return;
        }
    }

    public void iniciarUsuario2(){
        System.out.println("Escriba su nombre de Id de Administrador:");
        int admin = opcion.nextInt();
        System.out.println("Escriba su nombre de Usuario:");
        String usuario = opcion.nextLine();
        System.out.println("Escriba su contrasenia:");
        String contrasenia2 = opcion.nextLine();
        iniciarUsuario2(admin,usuario, contrasenia2);

    }

    public void iniciarUsuario2(int administradorID, String nombre, String contrasenia) {
        System.out.println("Buenos dias administrador " + nombre);
        mensajeMenu2();
        String pregunta2 = opcion.nextLine();
        switch (pregunta2){
            case "1":

            case "2":

            case "3":

            case "4":

            case "5":

            case "6":
                System.out.println("Saliendo del sistema");
                return;
        }

    }

    @Override
    public void mensajeMenu1() {

        System.out.println("-----Bienvenido a Fuente Manga-----");
        System.out.println("1.- Iniciar sesion como usuario.");
        System.out.println("2.- Iniciar sesion como administrador.");
        System.out.println("3.- Salir.");
        System.out.println("Elija una opcion:");
    }

    @Override
    public void mensajeMenu2() {
        System.out.println("------ Bienvenido a su cuenta -----");
        System.out.println("1.- Buscar manga.");
        System.out.println("2.- Ver mangas comprados.");
        System.out.println("3.- Valorar manga.");
        System.out.println("4.- Ver comentarios de mangas");
        System.out.println("5.- Comprar manga");
        System.out.println("6.- Salir");
        System.out.println("Elija una opcion:");

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
            String[] campos = linea.split(",");

            if (linea.length() == 5) {
                String usuarios = campos[0];
                String nombres = campos[1];
                int id = Integer.parseInt(campos[2]);
                String contrasenias = campos[3];
                int id_administrador = Integer.parseInt(campos[4]);
                Usuario usuario1 = new Usuario(usuarios,nombres,id,contrasenias,id_administrador);
            }
            else if(linea.length() == 4){
                String usuarios = campos[0];
                String nombres = campos[1];
                int id = Integer.parseInt(campos[2]);
                String contrasenias = campos[3];
                Usuario usuario2 = new Usuario(usuarios,nombres,id,contrasenias);
            }
            linea = in.readLine();
        }

    }

    public void cargarMangas(){

        In in2 = new In("mangas.csv");
        int tamanio2 = 0;

        String linea = in2.readLine();

        while (!linea.isEmpty()){
            System.out.println(linea);
            String[] campos = linea.split(";");
            int isbn = Integer.parseInt(campos[0]);
            String nombre = campos[1];
            int stock = Integer.parseInt(campos[2]);
            String descripcion = campos[3];
            int precio = Integer.parseInt(campos[4]);

            Manga manga = new Manga(isbn,nombre,stock,descripcion,precio);
            linea = in2.readLine();



        }
    }

    public void cargarComentarios(){
        In in3 = new In("comentarios.csv");
        int tamanio3 = 0;

        String linea = in3.readLine();

        while (!linea.isEmpty()){

            System.out.println(linea);
            String[] campos = linea.split(";");
        }

    }
    public void cargarCompras(){
        In in4 = new In("compras.csv");

        int tamanio3 = 0;
        String linea = in4.readLine();
        while (!linea.isEmpty()){
            System.out.println(linea);
            String[] campos = linea.split(",");
            int idCompra = Integer.parseInt(campos[0]);
            int idUsuario = Integer.parseInt(campos[1]);
            String estado = campos[2];
            String fecha = campos[3];
            int cantidadCompra = Integer.parseInt(campos[4]);
            Compra compra = new Compra(idCompra,idUsuario,estado,fecha,cantidadCompra);
            linea = in4.readLine();

        }

    }


    @Override
    public void registrarManga(String titulo, int isbn, int stock, String descripcion, int precio) {

        System.out.println("ingrese el titulo del manga ha agregar ");
        String Titulo = opcion.nextLine();
        System.out.println("ingrese el ISBN del manga ha agregar ");
        int Isbn = opcion.nextInt();
        System.out.println("ingrese el stock del manga ha agregar ");
        int Stock = opcion.nextInt();
        System.out.println("ingrese el descripcion del manga ha agregar ");
        String Descripcion = opcion.nextLine();
        System.out.println("ingrese el precio del manga ha agregar ");
        int Precio = opcion.nextInt();

        Manga manga = new Manga(Isbn,Titulo,Stock,Descripcion,Precio);
        mangas.add(manga);




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
        System.out.println("adiosito señor administrador ");

    }

    @Override
    public void buscarManga(String titulo) {
        System.out.println("ingrese el titulo del manga ");
        String nombre = opcion.nextLine();
        

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
        cargarMangas();

    }

    @Override
    public void salir2() {
        System.out.println("adios ");
        return;

    }
}

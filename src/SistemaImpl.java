import java.util.ArrayList;
import java.util.Scanner;
//import edu.princeton.cs.stdlib.In;

public class SistemaImpl implements Sistema{

    private ArrayList<Usuario> usuarios;

    private ArrayList<Manga> mangas;

    private ArrayList<Comentario> comentarios;

    private ArrayList<Compra> compras;

    private ArrayList<Critica> criticas;

    public SistemaImpl() {
        this.usuarios = new ArrayList<>();
        this.mangas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.criticas = new ArrayList<>();
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
        if (nombre.equals("francisca") || nombre.equals("personaAmarilla") || nombre.equals("elMatador")){
            System.out.println("Escriba su contraseña:");
            String contrasenia = opcion.nextLine();
            if (contrasenia.equals("lafranx") || contrasenia.equals("soyamarillo2") || contrasenia.equals("soymatador5")){
                mensajeMenu2();
                String pregunta = opcion.nextLine();
                switch (pregunta) {

                    case "1":

                    case "2":

                    case "3":

                    case "4":

                    case "5":

                    case "6":

                }
            }
            else{
                System.out.println("Disculpe no puso bien su contraseña");
            }
        }
        else{
            System.out.println("Disculpe no posu su nombre bien");
        }

    }

    public void iniciarUsuario2(){
        System.out.println("Escriba su nombre de Id de Administrador:");
        int admin = opcion.nextInt();
        try{
            if (admin == usuarios.get(1).getAdministrador_id()){
                System.out.println("Escriba su nombre de administrador:");
                String usuario = opcion.nextLine();
                usuario = opcion.nextLine();
                if(usuario.equals("bxnjadev")){
                    System.out.println("Escriba su contrasenia:");
                    String contrasenia2 = opcion.nextLine();
                    if (contrasenia2.equals("hola123")){
                        System.out.println("Entrando a la cuenta");
                        mensajeMenu3();
                        String pregunta = opcion.nextLine();

                    }
                    else{
                        System.out.println("Disculpe no es su contraseña");
                    }
                }
                else{
                    System.out.println("Disculpe, no es su nombre de administrador");
                }
            }
            else{
                System.out.println("Disculpe no es su Id de administrador");

            }
        }

        catch(Exception e){
            System.out.println("Porfavor, escriba li Id de administrador con numeros");
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
        System.out.println("4.- Ver comentarios de mangas.");
        System.out.println("5.- Comprar manga.");
        System.out.println("6.- Salir.");
        System.out.println("Elija una opcion:");

    }

    @Override
    public void mensajeMenu3() {
        System.out.println("-----Bienvenido a su cuenta administrador-----");
        System.out.println("1.- Registrar manga.");
        System.out.println("2.- Ver ultimas compras.");
        System.out.println("3.- Ver el estado de una compra.");
        System.out.println("4.- Estadisticas.");
        System.out.println("5.- Salir.");
        System.out.println("Elija una opcion: ");
        String pregunta = opcion.nextLine();


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
            if (campos.length == 5) {
                String usuarios1 = campos[0];
                String nombres = campos[1];
                int id = Integer.parseInt(campos[2]);
                String contrasenias = campos[3];
                int id_administrador = Integer.parseInt(campos[4]);
                Usuario usuario = new Usuario(usuarios1,nombres,id,contrasenias,id_administrador);
                usuarios.add(usuario);
            }
            else if(campos.length == 4){
                String usuarios1 = campos[0];
                String nombres = campos[1];
                int id = Integer.parseInt(campos[2]);
                String contrasenias = campos[3];
                Usuario usuario = new Usuario(usuarios1,nombres,id,contrasenias);
                usuarios.add(usuario);
            }
            linea = in.readLine();
        }

    }

    public void cargarMangas(){

        In in2 = new In("mangas.csv");
        int tamanio2 = 0;

        String linea = in2.readLine();

        while (linea != null){
            System.out.println(linea);
            String[] campos = linea.split(";");
            int isbn = Integer.parseInt(campos[0]);
            String nombre = campos[1];
            int stock = Integer.parseInt(campos[2]);
            String descripcion = campos[3];
            int precio = Integer.parseInt(campos[4]);

            Manga manga = new Manga(isbn,nombre,stock,descripcion,precio);
            mangas.add(manga);
            linea = in2.readLine();



        }
    }

    public void cargarComentarios(){
        In in3 = new In("comments.csv");

        String linea = in3.readLine();
        String linea2 = in3.readLine();
        while (linea != null) {
            String[] campos = linea.split(":");
            int isbn = Integer.parseInt(campos[0]);
            int cantidad_comentario = Integer.parseInt(campos[1]);
            ArrayList<Comentario> comentariosLista = new ArrayList<>();

            if (cantidad_comentario != 0) {
                String comentarioContenido = campos[2];
                comentarioContenido = comentarioContenido.substring(1, comentarioContenido.length() - 1);

                String[] comentarios1 = comentarioContenido.split("#");
                for(String comentario : comentarios1) {
                    String[] campos2 = linea2.split(";");
                    String mensaje = campos2[0];
                    int critica = Integer.parseInt(campos2[1]);
                    Comentario comentario1 = new Comentario(mensaje,critica);
                    comentarios.add(comentario1);
                    // Separo el comentario por ;
                    // Obtengo el mensaje y la critica
                    // Lo agrego a la lista
                }
            }

        }
    }
    public void cargarCompras(){
        In in4 = new In("compras.csv");
        String linea = in4.readLine();
        while (linea != null){
            String[] campos = linea.split(",");
            int idCompra = Integer.parseInt(campos[0]);
            int idUsuario = Integer.parseInt(campos[1]);
            String estado = campos[2];
            String fecha = campos[3];
            int cantidadCompra = Integer.parseInt(campos[4]);
            Compra compra = new Compra(idCompra,idUsuario,estado,fecha,cantidadCompra);
            compras.add(compra);
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

    public void buscarManga(){
        System.out.println("ingrese el titulo del manga ");
        String nombre = opcion.nextLine();
        buscarManga(nombre);
    }

    @Override
    public void buscarManga(String titulo) {
       

    }

    @Override
    public void mangasComprados() {



    }

    public void valorarManga(){
        System.out.println("Escriba el isbn del manga que desea valorar ");

        int isbn = opcion.nextInt();

        valorarManga(isbn);
    }

    @Override
    public void valorarManga(int isbn) {

    }

    @Override
    public void verComentarios(int isbn) {
        cargarComentarios();



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

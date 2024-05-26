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

        while (!linea.isEmpty()){

            System.out.println(linea);
            String[] campos = linea.split(",");

            if (campos.length() ==4) {
            }
            String usuarios = campos[0];
            String nombres = campos[1];
            int id = Integer.parseInt(campos[2]);
            String contrasenias = campos[3];
            int id_administrador = Integer.parseInt(campos[4]);




            Usuario usuario = new Usuario(usuarios,nombres,id,contrasenias,id_administrador);
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
        if (nombre.equals()){

        }

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

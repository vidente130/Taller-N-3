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
        cargarMangas();
        cargarComentarios();
        cargarCompras();
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
                while (true){
                    switch (pregunta) {

                        case "1":
                            buscarManga();

                            break;
                        case "2":
                            mangasComprados(nombre);

                            break;
                        case "3":
                            valorarManga();
                            break;
                        case "4":

                            verComentarios();
                            break;
                        case "5":
                            comprarManga();

                            break;
                        case "6":
                            salir2();
                            System.out.println("Saliendo ");
                            return;
                    }
                    mensajeMenu2();
                    pregunta = opcion.nextLine();
                }
            }
            else{
                System.out.println("Disculpe no puso bien su contraseña");
            }
        }
        else{
            System.out.println("Disculpe no puso su nombre bien");
        }

    }

    public void iniciarUsuario2(){
        System.out.println("Escriba su nombre de Id de Administrador:");
        int admin = opcion.nextInt();
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
                        while (true){
                            switch (pregunta){

                                case "1" :
                                    registrarManga();
                                    break;
                                case "2" :

                                    verUltimosMangas();
                                    break;
                                case "3" :
                                    actualizarCompra();

                                    break;
                                case "4" :
                                    estadisticas();

                                    break;
                                case "5" :
                                    salir1();
                                    System.out.println("Saliendo ");
                                    return;
                            }
                            mensajeMenu3();
                            pregunta = opcion.nextLine();
                        }
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
    }

    @Override
    public void cargarArchivos() {
        In in = new In("users.csv");

        int tamanio = 0;
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

            tamanio ++;
            linea = in.readLine();
        }

    }

    public void cargarMangas(){

        In in2 = new In("mangas.csv");
        int tamanio2 = 0;
        String linea = in2.readLine();
        while (linea != null){
            String[] campos = linea.split(";");
            String isbn = campos[0];
            String nombre = campos[1];
            int stock = Integer.parseInt(campos[2]);
            String descripcion = campos[3];
            int precio = Integer.parseInt(campos[4]);

            Manga manga = new Manga(isbn,nombre,stock,descripcion,precio);
            mangas.add(manga);
            tamanio2++;
            linea = in2.readLine();
        }
    }

    public void cargarComentarios(){
        In in3 = new In("comments.csv");
        int tamanio3 = 0;

        String linea = in3.readLine();
        String linea2 = in3.readLine();
        while (linea != null) {
            String[] campos = linea.split(":");
            String isbn = campos[0];
            int cantidad_comentario = Integer.parseInt(campos[1]);
            ArrayList<Comentario> comentariosLista = new ArrayList<>();

            if (cantidad_comentario != 0) {
                String comentarioContenido = campos[2];
                comentarioContenido = comentarioContenido.substring(1, comentarioContenido.length() - 1);

                String[] comentarios1 = comentarioContenido.split("#");
                for(String comentario : comentarios1) {
                    String[] campos2 = comentario.split(";");
                    String mensaje = campos2[0];
                    double critica = Double.parseDouble(campos2[1]);
                    Comentario comentario1 = new Comentario(mensaje,critica);
                    comentarios.add(comentario1);
                    Critica critica1 = new Critica(isbn,cantidad_comentario,comentariosLista);
                    criticas.add(critica1);
                }

            }
            tamanio3++;
            linea = in3.readLine();
        }
    }
    public void cargarCompras(){
        In in4 = new In("compras.csv");
        int tamanio4 = 0;
        String linea = in4.readLine();
        while (linea != null){
            String[] campos = linea.split(",");
            int idNumero = Integer.parseInt(campos[0]);
            String idCompra = campos[1];
            int idUsuario = Integer.parseInt(campos[2]);
            String estado = campos[3];
            String fecha = campos[4];
            int cantidadCompra = Integer.parseInt(campos[5]);
            Compra compra = new Compra(idCompra,idNumero,idUsuario,estado,fecha,cantidadCompra);
            compras.add(compra);
            tamanio4 ++;
            linea = in4.readLine();

        }

    }

    public void registrarManga(){
        System.out.println("ingrese el titulo del manga ha agregar ");
        String Titulo = opcion.nextLine();
        if (!Titulo.equals("")){
            System.out.println("ingrese el ISBN del manga ha agregar ");
            String Isbn = opcion.nextLine();
            if (!Isbn.equals("")){
                System.out.println("ingrese el stock del manga ha agregar ");
                int Stock = opcion.nextInt();
                if(Stock >= 0){
                    System.out.println("ingrese el descripcion del manga ha agregar ");
                    String Descripcion = opcion.nextLine();
                    Descripcion = opcion.nextLine();
                    if(!Descripcion.equals("")){
                        System.out.println("ingrese el precio del manga ha agregar ");
                        int Precio = opcion.nextInt();
                        if (Precio > 0){
                            registrarManga(Titulo,Isbn,Stock,Descripcion, Precio);

                        }
                        else{
                            System.out.println("Porfavor, elija un precio mayor a 0");
                        }
                    }
                    else{
                        System.out.println("Disculpe, no puso nada en la descripcion del manga");
                    }

                }
                else{
                    System.out.println("Porfavor, elija un stock mayor a 0");
                }
            }
            else{
                System.out.println("Porfavor elija un isbn de numero mayores a 0");
            }
        }
        else{
            System.out.println("Disculpe no puso un titulo al manga");
        }
    }

    @Override
    public void registrarManga(String titulo, String isbn, int stock, String descripcion, int precio) {
        Manga manga = new Manga(isbn,titulo,stock,descripcion,precio);
        mangas.add(manga);
    }

    @Override
    public void verUltimosMangas() {
        for (int i = 0; i < compras.size(); i++) {
            String isbn1 = compras.get(i + (compras.size() - 1)).getIsbn();
            String isbn2 = compras.get(i + (compras.size() - 2)).getIsbn();
            String isbn3 = compras.get(i + (compras.size() - 3)).getIsbn();
            int idu1 = compras.get(i + (compras.size() - 1)).getId_usuario();
            int idu2 = compras.get(i + (compras.size() - 2)).getId_usuario();
            int idu3 = compras.get(i + (compras.size() - 3)).getId_usuario();
            int posicion1 = compras.indexOf(isbn1) + 3;
            int posicion2 = compras.indexOf(isbn2) + 2;
            int posicion3 = compras.indexOf(isbn3) + 1;
            System.out.println(" --- Comprador 1 ---");
            for (int j = 0; j < mangas.size(); j++){
                if (isbn1.equals(mangas.get(j).getIsbn())){
                    System.out.println(mangas.get(j).getNombre());
                    System.out.println(mangas.get(j).getPrecio());
                }
            }

            for(int j = 0; j < usuarios.size(); j++){
                if (idu1 == usuarios.get(j).getId()){
                    System.out.println(usuarios.get(j).getNombreDeUsuario());
                    break;
                }
            }
            System.out.println(compras.get(posicion1).getFecha());
            System.out.println(compras.get(posicion1).getEstado());
            System.out.println("-----------");
            System.out.println(" --- Comprador 2 --- ");
            for (int j = 0; j < mangas.size(); j++){
                if(isbn2.equals(mangas.get(j).getIsbn())){
                    System.out.println(mangas.get(j).getNombre());
                    System.out.println(mangas.get(j).getPrecio());
                    break;
                }
            }
            for(int j = 0; j < usuarios.size(); j++){
                if (idu2 == usuarios.get(j).getId()){
                    System.out.println(usuarios.get(j).getNombreDeUsuario());
                    break;
                }
            }
            System.out.println(compras.get(posicion2).getFecha());
            System.out.println(compras.get(posicion2).getEstado());
            System.out.println("------------------------------------");
            System.out.println(" --- Comprador 3 ---");
            for (int j = 0; j < mangas.size(); j++){
                if(isbn3.equals(mangas.get(j).getIsbn())){
                    System.out.println(mangas.get(j).getNombre());
                    System.out.println(mangas.get(j).getPrecio());
                    break;
                }
            }
            for (int j = 0; j < usuarios.size(); j++){
                if (idu3 == usuarios.get(j).getId()){
                    System.out.println(usuarios.get(j).getNombreDeUsuario());
                    break;
                }
            }
            System.out.println(compras.get(posicion3).getFecha());
            System.out.println(compras.get(posicion3).getEstado());
            System.out.println("-------------------------------------");
            break;
        }
    }

    public void actualizarCompra(){
        System.out.println("¿Cual isbn es del manga que quiere cambiar?");
        String isbn = opcion.nextLine();
        actualizarCompra(isbn);
    }
    @Override
    public void actualizarCompra(String isbn) {
        for (int i = 0; i < compras.size(); i++){
            if (isbn.equals(compras.get(i).getIsbn())){
                System.out.println("Avanzando la etapa del pedido");
                if (compras.get(i).getEstado().equals("OBTENIENDO_PRODUCTO")){
                    compras.set(i,compras.get(i)).setEstado("ALISTANDO_EL_PRODUCTO");
                }
                else if(compras.get(i).getEstado().equals("ALISTANDO_EL_PRODUCTO")){
                    compras.set(i,compras.get(i)).setEstado("ENVIANDO_A_DOMICILIO");
                }
                else if(compras.get(i).getEstado().equals("ENVIANDO_A_DOMICILIO")){
                    compras.set(i,compras.get(i)).setEstado("RECIBIDO");
                }
            }
        }
    }

    @Override
    public void estadisticas() {
        //TODO: Completar funcion

       int contador2 = 0;
        for (int i = 0; i < usuarios.size(); i++){
            int contador = 0;
            for (int j = 0; j <  compras.size() ; j++){

                    if (compras.get(j).getId_usuario() == usuarios.get(i).getId()  ){
                    contador += 1;
               }
           }
            if (contador > 5) {
                System.out.println("Usuarios mas frecuentes / compras realizadas ");
                System.out.print("[ ");

                System.out.print(usuarios.get(i).getId());
                System.out.println(contador);
                contador2 += 1;

                System.out.println(" ]");
            }

        }
        System.out.println("porcentaje de usuarios frecuentes " +  (contador2/usuarios.size())*100);

        //TODO: Mostrar el manga con mejor valoracion



        int contador3 = 0;
        for (int i = 0; i < compras.size(); i++){
            if (!compras.get(i).getEstado().equals("RECIBIDO")){
                contador3 += 1;
            }


        }
        System.out.println("porcentaje de productos que tovia no han sido entregados: " + (contador3/compras.size())*100);





    }

    @Override
    public void salir1() {

        Out out = new Out("users.csv");
        for(int i = 0; i < usuarios.size(); i++){
            Usuario usuario = usuarios.get(i);

            String usuariosEnEscrito = usuarios.get(i).getTipoDeUsuario() + "," + usuarios.get(i).getNombreDeUsuario() + "," + usuarios.get(i).getId() + "," + usuarios.get(i).getContrasenia() + "," + usuarios.get(i).getAdministrador_id();

            out.println(usuariosEnEscrito);

        }
        Out out2 = new Out("mangas.csv");
        for(int i = 0; i < mangas.size();i++){

            Manga manga = mangas.get(i);

            String mangasEscrito = mangas.get(i).getIsbn() + ";" + mangas.get(i).getNombre() + ";" + mangas.get(i).getStock() + ";"+ mangas.get(i).getDescripcion() + ";" + mangas.get(i).getPrecio();

            out2.println(mangasEscrito);
        }
        Out out3 = new Out("comments.csv");
        for (int i = 0; i < criticas.size(); i++){
            Critica critica = criticas.get(i);

            for(int j = 0; j < comentarios.size(); j++){
                Comentario comentario = comentarios.get(j);
                String comentariosEscrito = criticas.get(i).getIsbn() + ":" + criticas.get(i).getCantidad_Comentarios() + ":" + "[" + comentarios.get(j).getMensaje() + ";" + comentarios.get(j).getCritica() + "]";
                out3.println(comentariosEscrito);
            }

        }
        Out out4 = new Out("compras.csv");
        for(int i = 0; i < compras.size();i++){

            Compra compra = compras.get(i);

            String comprasEscrito = compras.get(i).getIdNumero() + "," + compras.get(i).getIsbn() + "," + compras.get(i).getId_usuario() + "," + compras.get(i).getEstado() + "," + compras.get(i).getFecha() + "," + compras.get(i).getCantidadCompra();

            out4.println(comprasEscrito);
        }
        System.out.println("adiosito señor administrador ");

    }

    public void buscarManga(){
        System.out.println("ingrese el titulo del manga ");
        String nombre = opcion.nextLine();
        buscarManga(nombre);
    }

    @Override
    public void buscarManga(String titulo) {
        int contador = 0;
        for (int i = 0; i < mangas.size(); i++){
            if (mangas.get(i).getNombre().contains(titulo)){
               contador += 1;

                System.out.print("Nombre: "  + mangas.get(i).getNombre());
                System.out.print("Isbn: "  + mangas.get(i).getIsbn());
                System.out.println("Precio: " + mangas.get(i).getPrecio());
                System.out.println("Stock: " + mangas.get(i).getStock());

            }


        }
        if (contador == 0) {
            System.out.println("No se encontro lo que buscaba intente otra vez");
        }

    }
    @Override
    public void mangasComprados(String nombre) {
        //TODO: Completar funcion
        for (int i = 0; i < usuarios.size(); i++) {
            if (nombre.equals(usuarios.get(i).getNombreDeUsuario())) {
                for (int j = 0; j < compras.size(); j++) {
                    if (usuarios.get(i).getId() == compras.get(j).getId_usuario()){
                        System.out.println(compras.get(j).getIdNumero());
                        for(int k = 0; k < mangas.size(); k++){
                            if (compras.get(j).getIsbn().equals(mangas.get(k).getIsbn())){
                                System.out.println(mangas.get(k).getNombre());
                                System.out.println(compras.get(j).getEstado());
                                System.out.println(mangas.get(k).getPrecio());
                                System.out.println("1.- Siguiente manga");
                                System.out.println("2.- Anterior manga");
                                System.out.println("3.- salir");
                                String pregunta = opcion.nextLine();
                                while(true){
                                    switch (pregunta){

                                        case "1" :
                                            
                                        case "2" :

                                        case "3" :
                                            break;
                                    }
                                    System.out.println("1.- Siguiente manga");
                                    System.out.println("2.- Anterior manga");
                                    System.out.println("3.- Salir");
                                    pregunta = opcion.nextLine();
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("Disculpe, no compro por el momento mangas.");
                    }
                }
            }
        }
    }

    public void valorarManga(){
        System.out.println("Escriba el isbn del manga que desea valorar: ");
        String isbn = opcion.nextLine();
        valorarManga(isbn);
    }

    @Override
    public void valorarManga(String isbn) {
        for(int i = 0; i < criticas.size(); i++){
            if(isbn.equals(criticas.get(i).getIsbn())){
                System.out.println("¿Que comentario quiere hacer al manga?");
                String mensaje = opcion.nextLine();
                if (mensaje.length() <= 255) {
                    System.out.println("¿Que valoracion quiere hacerle?");
                    double valoracion = opcion.nextDouble();
                    if (valoracion >= 1.0 && valoracion <= 5.0) {
                        Comentario comentario = new Comentario(mensaje, valoracion);
                        comentarios.add(comentario);
                        System.out.println("Se completo el agregamiento del comentario");
                    }
                    else{
                        System.out.println("Disculpe la critica tiene que ser positiva y tiene que ser entre 1.0 y 5.0");
                        break;
                    }
                }
                else{
                    System.out.println("Disculpe el mensaje no puede tener mas de 255 caracteres");
                    break;
                }
                break;
            }
        }

        //TODO: Completar funcion

    }

    public void verComentarios(){
        System.out.println("¿Cual es el isbn del manga?");
        String isbn = opcion.nextLine();
        verComentarios(isbn);
        //TODO: Completar funcion

    }

    @Override
    public void verComentarios(String isbn) {
        //TODO: Completar funcion
        System.out.println("------- (Comentarios) --------");
        for (int i = 0; i < criticas.size();i++){
            if (isbn.equals(criticas.get(i).getIsbn())){
                System.out.println(comentarios.size());
                System.out.println("Del manga con isbn: "+ criticas.get(i).getIsbn());
                System.out.println(comentarios.get(i).getMensaje());
            }
        }


    }

    public void comprarManga( ){
        //TODO: Completar funcion
        System.out.println("Escriba el ISBN del manga que desea comprar ");
        String isbn = opcion.nextLine();

        for (int i = 0; i < mangas.size(); i++){
            if (mangas.get(i).getIsbn().equals(isbn)){
                comprarManga(isbn);
            }
        }
        System.out.println("Inserte un ISBN valido ");

    }

    @Override
    public void comprarManga(String isbn) {
        //TODO: Completar funcion


    }

    @Override
    public void salir2() {
        Out out = new Out("users.csv");
        for(int i = 0; i < usuarios.size(); i++){
            Usuario usuario = usuarios.get(i);

            String usuariosEnEscrito = usuarios.get(i).getTipoDeUsuario() + "," + usuarios.get(i).getNombreDeUsuario() + "," + usuarios.get(i).getId() + "," + usuarios.get(i).getContrasenia() + "," + usuarios.get(i).getAdministrador_id();

            out.println(usuariosEnEscrito);

        }
        Out out2 = new Out("mangas.csv");
        for(int i = 0; i < mangas.size();i++){

            Manga manga = mangas.get(i);

            String mangasEscrito = mangas.get(i).getIsbn() + ";" + mangas.get(i).getNombre() + ";" + mangas.get(i).getStock() + ";"+ mangas.get(i).getDescripcion() + ";" + mangas.get(i).getPrecio();

            out2.println(mangasEscrito);
        }
        Out out3 = new Out("comments.csv");
        for (int i = 0; i < criticas.size(); i++){
            Critica critica = criticas.get(i);

            for(int j = 0; j < comentarios.size(); j++){
                Comentario comentario = comentarios.get(j);
                String comentariosEscrito = criticas.get(i).getIsbn() + ":" + criticas.get(i).getCantidad_Comentarios() + ":" + "[" + comentarios.get(j).getMensaje() + ";" + comentarios.get(j).getCritica() + "]";
                out3.println(comentariosEscrito);
            }

        }
        Out out4 = new Out("compras.csv");
        for(int i = 0; i < compras.size();i++){

            Compra compra = compras.get(i);

            String comprasEscrito = compras.get(i).getIdNumero() + "," + compras.get(i).getIsbn() + "," + compras.get(i).getId_usuario() + "," + compras.get(i).getEstado() + "," + compras.get(i).getFecha() + "," + compras.get(i).getCantidadCompra();

            out4.println(comprasEscrito);
        }
        System.out.println("adios ");
        return;

    }
}

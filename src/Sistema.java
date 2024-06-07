public interface Sistema {

    // Menu: Menu principal del programa, este menu se reemplazara con el main y donde se usaran todas las funciones y acciones del programa

    /**
     * Esta funcion permite usarse el menu fuera del main
     */
    void menu();


    // MensajeMenu1: Es el mensaje del menu principal con las opciones de iniciar sesion como usuario o como administrador y el mensaje de opcion salir

    /**
     * Esta funcion permite dar un mensaje con las opciones del menu principal
     */
    void mensajeMenu1();


    // MensajeMenu2: Es el mensaje del menu cuando un usuario inicia sesion, aqui muestran las opciones de lo que puede hacer el usuario.

    /**
     * Esta funcion permite mostrar las opciones del menu usuario como mensajes
     */
    void mensajeMenu2();


    // MensajeMenu3: Es el mensaje del menu cuando un administrador inicia sesion, aqui muestran las opciones que puede usar el administrador

    /**
     * Esta funcion muestra las opciones del menu de administrador cono mensajes.
     */
    void mensajeMenu3();

    // CargarArchivos(): es lo que permite cargar los archivos csv de usuarios llamado users.csv y ademas que esta funcion se pone desde el menu().

    /**
     * Esta funcion permite cargar el archivo csv de usuarios
     */

    void cargarArchivos();

    //registrarManga(): es lo que deja registrar un manga dentro del programa y que tambien se usa la sobrecargar con otra funcion con el mismo nombre

    /**
     * Esta funcion permite registrar un manga dentro del programa
     * @param titulo el titulo del manga
     * @param isbn el isbn del manga
     * @param stock el stock del manga
     * @param descripcion la descripcion del manga
     * @param precio el precio del manga
     */

    void registrarManga(String titulo,String isbn, int stock, String descripcion, int precio);

    //verUltimosMangas(): es lo que permite mostrando mensajes los ultimos mangas que se compraron dentro de la pagina de mangas.

    /**
     * esta funcion permite ver los ultimos mangas comprados
     */

    void verUltimosMangas();

    // actualizarCompra(): esto deja que se pueda actualizar el estado de una compra de un manga para asi pueda avanzar de categoria hasta llegar a RECIBIDO.

    /**
     * esta funcion permite actualizar el estado de la compra de un manga
     * @param isbn el isbn del manga
     */
    void actualizarCompra(String isbn);

    // estadisticas(): las estadisticas de programa entero

    /**
     * esta funcion permite ver la estadisticas de la pagina
     */
    void estadisticas();

    // salir1(): Esta funcion permite guardar lo que hizo el administrador dentro de su cuenta cuando haga algo en la pagina

    /**
     * esta funcion permite guardar los archivos sobreescritos por el administrador en la pagina
     */

    void salir1();

    // buscarManga(): esto hace que se pueda buscar el manga que la persona quiera y ademas que puede buscar los nombres de los mangas aunque no este completo el nombre
    /**
     * esta funcion permite buscar un manga
     * @param titulo el titulo del manga
     */
    void buscarManga(String titulo);

    // mangasComprados(): esto hace que se pueda comprar un manga dentro de la pagina

    /**
     * esta funcion permite ver los mangas que compro el usuario dentro de la pagina
     * @param nombre el nombre del manga
     */

    void mangasComprados(String nombre);

    // valorarManga(): esto hace que se pueda valorar un manga dentro de la tienda usando un isbn para buscarlo y despues valorar.

    /**
     * esta funcion permite valorar un manga en 1.0 y 5.0
     * @param isbn el isbn del manga
     */

    void valorarManga(String isbn);

    // verComentarios(): esto hace que se puedan ver los comentarios de un manga buscandolo primero por su isbn

    /**
     * esta funcion permite ver los comentarios de un manga
     * @param isbn el isbn del manga
     */
    void verComentarios(String isbn);

    // comprarManga(): esto hace que se pueda comprar un manga desde la pagina usando el isbn de ese manga

    /**
     * esta funcion permite comprar un manga
     * @param isbn el isbn del manga
     */
    void comprarManga(String isbn);

    //salir2(): esto hace que se pueda salir desde la cuenta de un administrador y tambien hace que se pueda guardar los archivos.

    /**
     * esta funcion permite salir y guardar los archivos desde la cuenta del administrador
     */
    void salir2();


    
}

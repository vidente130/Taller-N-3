public interface Sistema {

    void menu();

    void mensajeMenu1();

    void mensajeMenu2();

    void mensajeMenu3();

    void mensajeMenu4();

    void mensajeMenu5();

    void cargarArchivos();

    void registrarManga(String titulo,String isbn, int stock, String descripcion, int precio);

    void verUltimosMangas();

    void actualizarCompra(int isbn);

    void estadisticas();

    void salir1();

    void buscarManga(String titulo);

    void mangasComprados();

    void valorarManga(int isbn);

    void verComentarios(int isbn);

    void comprarManga(int isbn);

    void salir2();


    
}

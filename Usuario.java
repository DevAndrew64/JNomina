public class Usuario extends Persona {

    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String apellido, String identificacion, String celular,
                    String usuario, String contrasena) {
        super(nombre, apellido, identificacion, celular);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

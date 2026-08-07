public abstract class Empleado extends Persona {

    private String codigoInterno;
    private String banco;
    private String numeroCuenta;
    private int mesAFacturar;

    public Empleado(String nombre, String apellido, String identificacion, String celular,
                     String codigoInterno, String banco, String numeroCuenta, int mesAFacturar) {
        super(nombre, apellido, identificacion, celular);
        this.codigoInterno = codigoInterno;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.mesAFacturar = mesAFacturar;
    }

    public abstract double getPago(int numeroMes);

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getMesAFacturar() {
        return mesAFacturar;
    }

    public void setMesAFacturar(int mesAFacturar) {
        this.mesAFacturar = mesAFacturar;
    }
}

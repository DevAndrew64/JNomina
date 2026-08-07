public class Fijo extends Empleado implements HrsExtras {

    private String eps;
    private String fondoPension;
    private String fondoCesantias;
    private String arl;
    private double salario;
    private int horasExtras;

    public Fijo(String nombre, String apellido, String identificacion, String celular,
                String codigoInterno, String banco, String numeroCuenta, int mesAFacturar,
                String eps, String fondoPension, String fondoCesantias, String arl,
                double salario, int horasExtras) {
        super(nombre, apellido, identificacion, celular, codigoInterno, banco, numeroCuenta, mesAFacturar);
        this.eps = eps;
        this.fondoPension = fondoPension;
        this.fondoCesantias = fondoCesantias;
        this.arl = arl;
        this.salario = salario;
        this.horasExtras = horasExtras;
    }

    @Override
    public double getPago(int numeroMes) {
        double descuento = salario * 0.08;
        double pagoHorasExtras = horasExtras * VALOR_HORA_EXTRA;
        return salario - descuento + pagoHorasExtras;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getFondoPension() {
        return fondoPension;
    }

    public void setFondoPension(String fondoPension) {
        this.fondoPension = fondoPension;
    }

    public String getFondoCesantias() {
        return fondoCesantias;
    }

    public void setFondoCesantias(String fondoCesantias) {
        this.fondoCesantias = fondoCesantias;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }
}

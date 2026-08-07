public class Proveedor extends Empleado {

    private int horasTrabajadas;
    private double valorHora;

    public Proveedor(String nombre, String apellido, String identificacion, String celular,
                      String codigoInterno, String banco, String numeroCuenta, int mesAFacturar,
                      int horasTrabajadas, double valorHora) {
        super(nombre, apellido, identificacion, celular, codigoInterno, banco, numeroCuenta, mesAFacturar);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    @Override
    public double getPago(int numeroMes) {
        return horasTrabajadas * valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}

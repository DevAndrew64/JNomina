import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        System.out.print("Cantidad de empleados fijos: ");
        int cantidadFijos = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < cantidadFijos; i++) {
            empleados.add(leerFijo(sc));
        }

        System.out.print("Cantidad de proveedores: ");
        int cantidadProveedores = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < cantidadProveedores; i++) {
            empleados.add(leerProveedor(sc));
        }

        System.out.print("Cantidad de consultas de pago: ");
        int cantidadConsultas = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < cantidadConsultas; i++) {
            procesarConsulta(sc, empleados);
        }

        sc.close();
    }

    private static Fijo leerFijo(Scanner sc) {
        System.out.println("Datos del empleado fijo:");
        String nombre = sc.nextLine().trim();
        String apellido = sc.nextLine().trim();
        String identificacion = sc.nextLine().trim();
        String celular = sc.nextLine().trim();
        String codigoInterno = sc.nextLine().trim();
        String banco = sc.nextLine().trim();
        String numeroCuenta = sc.nextLine().trim();
        int mesAFacturar = Integer.parseInt(sc.nextLine().trim());
        String eps = sc.nextLine().trim();
        String fondoPension = sc.nextLine().trim();
        String fondoCesantias = sc.nextLine().trim();
        String arl = sc.nextLine().trim();
        double salario = Double.parseDouble(sc.nextLine().trim());
        int horasExtras = Integer.parseInt(sc.nextLine().trim());

        return new Fijo(nombre, apellido, identificacion, celular, codigoInterno, banco, numeroCuenta,
                mesAFacturar, eps, fondoPension, fondoCesantias, arl, salario, horasExtras);
    }

    private static Proveedor leerProveedor(Scanner sc) {
        System.out.println("Datos del proveedor:");
        String nombre = sc.nextLine().trim();
        String apellido = sc.nextLine().trim();
        String identificacion = sc.nextLine().trim();
        String celular = sc.nextLine().trim();
        String codigoInterno = sc.nextLine().trim();
        String banco = sc.nextLine().trim();
        String numeroCuenta = sc.nextLine().trim();
        int mesAFacturar = Integer.parseInt(sc.nextLine().trim());
        int horasTrabajadas = Integer.parseInt(sc.nextLine().trim());
        double valorHora = Double.parseDouble(sc.nextLine().trim());

        return new Proveedor(nombre, apellido, identificacion, celular, codigoInterno, banco, numeroCuenta,
                mesAFacturar, horasTrabajadas, valorHora);
    }

    private static void procesarConsulta(Scanner sc, List<Empleado> empleados) {
        System.out.print("Identificacion del empleado a liquidar: ");
        String identificacion = sc.nextLine().trim();
        System.out.print("Mes a liquidar: ");
        int mes = Integer.parseInt(sc.nextLine().trim());

        Empleado empleado = buscarPorIdentificacion(empleados, identificacion);
        if (empleado == null) {
            System.out.println("Empleado no encontrado");
            return;
        }

        if (mes != empleado.getMesAFacturar()) {
            System.out.println("Mes sin facturar");
            return;
        }

        if (empleado.isMesFacturado(mes)) {
            System.out.println("Mes ya facturado");
            return;
        }

        double pago = empleado.getPago(mes);
        empleado.marcarMesFacturado(mes);
        System.out.println("El monto a liquidar del empleado: " + empleado.getCodigoInterno() + " es: $" + (long) pago);
    }

    private static Empleado buscarPorIdentificacion(List<Empleado> empleados, String identificacion) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return empleado;
            }
        }
        return null;
    }
}

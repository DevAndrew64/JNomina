import java.util.Scanner;

public class main {

    private static final String[] AUTORES = {
            "Jhon Ponton", "Cristian Castro", "Luna Barreto", "Kenneth Benavides"
    };

    public static void main(String[] args) {
        mostrarAutores();

        Scanner scanner = new Scanner(System.in);
        Consola consola = new Consola(scanner);
        NominaService nomina = new NominaService();

        int cantidadFijos = consola.pedirEntero("Cantidad de empleados fijos: ");
        for (int i = 0; i < cantidadFijos; i++) {
            registrarEmpleado(nomina, leerFijo(consola));
        }

        int cantidadProveedores = consola.pedirEntero("Cantidad de proveedores: ");
        for (int i = 0; i < cantidadProveedores; i++) {
            registrarEmpleado(nomina, leerProveedor(consola));
        }

        int cantidadConsultas = consola.pedirEntero("Cantidad de consultas de pago: ");
        for (int i = 0; i < cantidadConsultas; i++) {
            String identificacion = consola.pedirTexto("Identificacion del empleado a liquidar: ");
            int mes = consola.pedirEntero("Mes a liquidar: ");
            System.out.println(nomina.liquidar(identificacion, mes));
        }

        scanner.close();
    }

    private static void mostrarAutores() {
        System.out.println("JNomina - Reto semanal 03");
        System.out.println("Autores: " + String.join(", ", AUTORES));
        System.out.println();
    }

    private static void registrarEmpleado(NominaService nomina, Empleado empleado) {
        if (!nomina.registrar(empleado)) {
            System.out.println("Ya existe un empleado con la identificacion " + empleado.getIdentificacion());
        }
    }

    private static Fijo leerFijo(Consola consola) {
        System.out.println("Datos del empleado fijo:");
        String nombre = consola.pedirTexto("Nombre: ");
        String apellido = consola.pedirTexto("Apellido: ");
        String identificacion = consola.pedirTexto("Identificacion: ");
        String celular = consola.pedirTexto("Celular: ");
        String codigoInterno = consola.pedirTexto("Codigo interno: ");
        String banco = consola.pedirTexto("Banco: ");
        String numeroCuenta = consola.pedirTexto("Numero de cuenta: ");
        int mesAFacturar = consola.pedirEntero("Mes a facturar: ");
        String eps = consola.pedirTexto("EPS: ");
        String fondoPension = consola.pedirTexto("Fondo de pension: ");
        String fondoCesantias = consola.pedirTexto("Fondo de cesantias: ");
        String arl = consola.pedirTexto("ARL: ");
        double salario = consola.pedirDecimal("Salario: ");
        int horasExtras = consola.pedirEntero("Horas extras: ");

        return new Fijo(nombre, apellido, identificacion, celular, codigoInterno, banco, numeroCuenta,
                mesAFacturar, eps, fondoPension, fondoCesantias, arl, salario, horasExtras);
    }

    private static Proveedor leerProveedor(Consola consola) {
        System.out.println("Datos del proveedor:");
        String nombre = consola.pedirTexto("Nombre: ");
        String apellido = consola.pedirTexto("Apellido: ");
        String identificacion = consola.pedirTexto("Identificacion: ");
        String celular = consola.pedirTexto("Celular: ");
        String codigoInterno = consola.pedirTexto("Codigo interno: ");
        String banco = consola.pedirTexto("Banco: ");
        String numeroCuenta = consola.pedirTexto("Numero de cuenta: ");
        int mesAFacturar = consola.pedirEntero("Mes a facturar: ");
        int horasTrabajadas = consola.pedirEntero("Horas trabajadas: ");
        double valorHora = consola.pedirDecimal("Valor de la hora: ");

        return new Proveedor(nombre, apellido, identificacion, celular, codigoInterno, banco, numeroCuenta,
                mesAFacturar, horasTrabajadas, valorHora);
    }
}

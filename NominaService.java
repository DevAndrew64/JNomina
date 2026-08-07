import java.util.ArrayList;
import java.util.List;

public class NominaService {

    private final List<Empleado> empleados = new ArrayList<>();

    public boolean registrar(Empleado empleado) {
        if (buscarPorIdentificacion(empleado.getIdentificacion()) != null) {
            return false;
        }
        empleados.add(empleado);
        return true;
    }

    public String liquidar(String identificacion, int mes) {
        Empleado empleado = buscarPorIdentificacion(identificacion);
        if (empleado == null) {
            return "Empleado no encontrado";
        }

        if (mes != empleado.getMesAFacturar()) {
            return "Mes sin facturar";
        }

        if (empleado.isMesFacturado(mes)) {
            return "Mes ya facturado";
        }

        double pago = empleado.getPago(mes);
        empleado.marcarMesFacturado(mes);
        return "El monto a liquidar del empleado: " + empleado.getCodigoInterno() + " es: $" + (long) pago;
    }

    private Empleado buscarPorIdentificacion(String identificacion) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return empleado;
            }
        }
        return null;
    }
}

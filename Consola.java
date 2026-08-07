import java.util.Scanner;

public class Consola {

    private final Scanner sc;

    public Consola(Scanner sc) {
        this.sc = sc;
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    public String pedirTextoOpcional(String mensaje) {
        System.out.print(mensaje + " (opcional, Enter para omitir): ");
        String valor = sc.nextLine().trim();
        return valor.isEmpty() ? "No registrado" : valor;
    }

    public int pedirEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido, ingresa un numero entero");
            }
        }
    }

    public double pedirDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido, ingresa un numero");
            }
        }
    }
}

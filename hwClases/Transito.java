package hwClases;
public class Transito {
    private Multa[] multas;
    private int contadorMultas;
    public Transito() {
        multas = new Multa[100];
        contadorMultas = 0;
    }
    public Multa buscarMulta(int codigo) {
        for (int cont = 0; cont < contadorMultas; cont++) {
            if (multas[cont].getCodigo() == codigo) {
                return multas[cont];
            }
        }
        return null;
    }
    public String agregarMulta(int codigo, String nombre, String tipo) {
        if (contadorMultas < multas.length && buscarMulta(codigo) == null) {
            Multa nuevaMulta = new Multa(codigo, nombre, tipo);
            multas[contadorMultas] = nuevaMulta;
            contadorMultas++;
            return "Multa agregada correctamente.";
        } else {
            return "Error, multa no agregada.";
        }
    }

    public String pagarMulta(int codigo) {
        Multa multa = buscarMulta(codigo);
        if (multa != null) {
            multa.pagar();
            return "Multa pagada correctamente.";
        } else {
            return "Error, codigo no existente:  " + codigo;
        }
    }

    public String imprimirMultas() {
        StringBuilder sb = new StringBuilder();
        for (int cont = 0; cont < contadorMultas; cont++) {
            sb.append(multas[cont].imprimirMulta()).append("\n---------\n");
        }
        return sb.toString();
    }

    public String imprimirInfo() {
        int cantidadGenerada = contadorMultas;
        int cantidadPagada = 0;
        int cantidadPendiente = 0;
        double montoPagadas = 0.0;
        double montoPendientes = 0.0;

        for (int i = 0; i < contadorMultas; i++) {
            if (multas[i].estaPagada()) {
                cantidadPagada++;
                montoPagadas += multas[i].getMontoPagar();
            } else {
                cantidadPendiente++;
                montoPendientes += multas[i].getMontoPagar();
            }
        }

        return "Multas generadas: " + cantidadGenerada +
               "\nMultas Pagadas: " + cantidadPagada +
               " - Monto total " + montoPagadas + " Lps." +
               "\nMultas Pendientes: " + cantidadPendiente +
               " - Monto total " + montoPendientes + " Lps.";
    }
}

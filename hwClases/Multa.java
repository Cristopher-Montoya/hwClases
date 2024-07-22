package hwClases;

public class Multa {
    // Atributos públicos
    public static final double TIPO_GRAVE = 100.0;
    public static final double TIPO_MEDIO = 50.0;
    public static final double TIPO_LEVE = 20.0;

    // Atributos privados
    private int codigo;
    private String nombre;
    private String tipo;
    private double montoPagar;
    private boolean pagada;

    // Constructor
    public Multa(int codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo.toUpperCase();
        this.montoPagar = calcularMontoPagar();
        this.pagada = false;
    }

    private double calcularMontoPagar() {
        switch (tipo) {
            case "MEDIO":
                return TIPO_MEDIO;
            case "GRAVE":
                return TIPO_GRAVE;
            default:
                return TIPO_LEVE;
        }
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public boolean estaPagada() {
        return pagada;
    }

    // Imprimir
    public String imprimirMulta() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Tipo de multa: " + tipo + ", Monto a pagar: Lps " + montoPagar +
                ", Estado: " + (pagada ? "Pagada por un monto de Lps " + montoPagar : "Multa pendiente");
    }

    // Pagar
    public void pagar() {
        pagada = true;
    }
}

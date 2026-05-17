public class ColaboradorPJ extends Colaborador {

    private static final double BONUS_PROJETO  = 500.00;
    private static final double DESCONTO_IMPOSTO = 0.15;

    public ColaboradorPJ(int registro, String nome) {
        super(registro, nome);
    }

    @Override
    public double calcularSalario() {
        double subtotal = SALARIO_BASE + BONUS_PROJETO;
        double desconto = subtotal * DESCONTO_IMPOSTO;
        return subtotal - desconto;
    }

    @Override
    public String getTipo() {
        return "PJ";
    }
}

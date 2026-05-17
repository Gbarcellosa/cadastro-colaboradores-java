public class ColaboradorCLT extends Colaborador {

    private static final double ADICIONAL_PERCENTUAL = 0.10;
    private static final double VALE_ALIMENTACAO     = 250.00;
    private static final double DESCONTO_INSS        = 0.08;

    public ColaboradorCLT(int registro, String nome) {
        super(registro, nome);
    }

    @Override
    public double calcularSalario() {
        double adicional  = SALARIO_BASE * ADICIONAL_PERCENTUAL;
        double subtotal   = SALARIO_BASE + adicional + VALE_ALIMENTACAO;
        double desconto   = subtotal * DESCONTO_INSS;
        return subtotal - desconto;
    }

    @Override
    public String getTipo() {
        return "CLT";
    }
}

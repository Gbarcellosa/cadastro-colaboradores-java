public abstract class Colaborador {

    protected int registro;
    protected String nome;
    protected static final double SALARIO_BASE = 2000.00;

    public Colaborador(int registro, String nome) {
        this.registro = registro;
        this.nome = nome;
    }

    public int getRegistro() {
        return registro;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularSalario();

    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format(
            "Registro: %d | Nome: %s | Tipo: %s | Salário Final: R$ %.2f",
            registro, nome, getTipo(), calcularSalario()
        );
    }
}

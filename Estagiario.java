public class Estagiario extends Colaborador {

    private int cargaHoraria; // 4 ou 6 horas

    public Estagiario(int registro, String nome, int cargaHoraria) {
        super(registro, nome);
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public double calcularSalario() {
        double percentual;

        if (cargaHoraria == 6) {
            percentual = 0.80;
        } else {
            percentual = 0.60; // 4 horas
        }

        return SALARIO_BASE * percentual;
    }

    @Override
    public String getTipo() {
        return "Estagiário (" + cargaHoraria + "h)";
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaColaboradores {

    static ArrayList<Colaborador> colaboradores = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiroPositivo("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarColaborador();
                    break;
                case 2:
                    listarColaboradores();
                    break;
                case 3:
                    calcularSalario();
                    break;
                case 4:
                    buscarColaborador();
                    break;
                case 5:
                    removerColaborador();
                    break;
                case 6:
                    System.out.println("\nSistema encerrado. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }

        } while (opcao != 6);

        scanner.close();
    }

    // ─── MENU ────────────────────────────────────────────────────────────────

    static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("      SISTEMA DE COLABORADORES          ");
        System.out.println("========================================");
        System.out.println("1. Cadastrar colaborador");
        System.out.println("2. Listar colaboradores");
        System.out.println("3. Calcular salário de um colaborador");
        System.out.println("4. Buscar colaborador por registro");
        System.out.println("5. Remover colaborador");
        System.out.println("6. Sair");
        System.out.println("========================================");
    }

    // ─── CADASTRAR ────────────────────────────────────────────────────────────

    static void cadastrarColaborador() {
        System.out.println("\n--- CADASTRAR COLABORADOR ---");

        // Registro (único e positivo)
        int registro;
        while (true) {
            registro = lerInteiroPositivo("Número de registro: ");
            if (registroExiste(registro)) {
                System.out.println("Erro: esse número de registro já está cadastrado!");
            } else {
                break;
            }
        }

        // Nome (não vazio)
        String nome;
        while (true) {
            System.out.print("Nome completo: ");
            nome = scanner.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro: o nome não pode ser vazio!");
            } else {
                break;
            }
        }

        // Tipo
        System.out.println("Tipo de colaborador:");
        System.out.println("  1 - CLT");
        System.out.println("  2 - PJ");
        System.out.println("  3 - Estagiário");
        int tipo = lerInteiroPositivo("Escolha o tipo: ");

        Colaborador colaborador = null;

        switch (tipo) {
            case 1:
                colaborador = new ColaboradorCLT(registro, nome);
                break;
            case 2:
                colaborador = new ColaboradorPJ(registro, nome);
                break;
            case 3:
                int carga;
                do {
                    carga = lerInteiroPositivo("Carga horária (4 ou 6 horas): ");
                    if (carga != 4 && carga != 6) {
                        System.out.println("Erro: informe apenas 4 ou 6 horas!");
                    }
                } while (carga != 4 && carga != 6);
                colaborador = new Estagiario(registro, nome, carga);
                break;
            default:
                System.out.println("Tipo inválido! Cadastro cancelado.");
                return;
        }

        colaboradores.add(colaborador);
        System.out.println("\nColaborador cadastrado com sucesso!");
        System.out.println(colaborador);
    }

    // ─── LISTAR ──────────────────────────────────────────────────────────────

    static void listarColaboradores() {
        System.out.println("\n--- LISTA DE COLABORADORES ---");

        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        for (int i = 0; i < colaboradores.size(); i++) {
            System.out.println((i + 1) + ". " + colaboradores.get(i));
        }
    }

    // ─── CALCULAR SALÁRIO ─────────────────────────────────────────────────────

    static void calcularSalario() {
        System.out.println("\n--- CALCULAR SALÁRIO ---");

        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        int registro = lerInteiroPositivo("Informe o número de registro: ");
        Colaborador c = encontrarColaborador(registro);

        if (c == null) {
            System.out.println("Colaborador não encontrado!");
            return;
        }

        System.out.println("\nDetalhes do cálculo:");
        System.out.printf("Nome:          %s%n", c.getNome());
        System.out.printf("Tipo:          %s%n", c.getTipo());
        System.out.printf("Salário base:  R$ %.2f%n", Colaborador.SALARIO_BASE);
        System.out.printf("Salário final: R$ %.2f%n", c.calcularSalario());
    }

    // ─── BUSCAR ──────────────────────────────────────────────────────────────

    static void buscarColaborador() {
        System.out.println("\n--- BUSCAR COLABORADOR ---");

        int registro = lerInteiroPositivo("Informe o número de registro: ");
        Colaborador c = encontrarColaborador(registro);

        if (c == null) {
            System.out.println("Colaborador não encontrado!");
        } else {
            System.out.println("\nColaborador encontrado:");
            System.out.println(c);
        }
    }

    // ─── REMOVER ─────────────────────────────────────────────────────────────

    static void removerColaborador() {
        System.out.println("\n--- REMOVER COLABORADOR ---");

        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        int registro = lerInteiroPositivo("Informe o número de registro: ");
        Colaborador c = encontrarColaborador(registro);

        if (c == null) {
            System.out.println("Colaborador não encontrado!");
            return;
        }

        colaboradores.remove(c);
        System.out.println("Colaborador \"" + c.getNome() + "\" removido com sucesso!");
    }

    // ─── UTILITÁRIOS ─────────────────────────────────────────────────────────

    static boolean registroExiste(int registro) {
        for (Colaborador c : colaboradores) {
            if (c.getRegistro() == registro) {
                return true;
            }
        }
        return false;
    }

    static Colaborador encontrarColaborador(int registro) {
        for (Colaborador c : colaboradores) {
            if (c.getRegistro() == registro) {
                return c;
            }
        }
        return null;
    }

    // Lê um inteiro positivo com validação (não aceita negativos nem letras)
    static int lerInteiroPositivo(String mensagem) {
        int valor = -1;
        do {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.println("Erro: não são permitidos números negativos!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: entrada inválida! Digite um número inteiro.");
            }
        } while (valor < 0);
        return valor;
    }
}

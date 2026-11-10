package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 12: Strategy e Observer ===");

        Aluno bolsista = new Aluno("2024001", "Maria Silva");
        bolsista.setBolsista(true);

        Aluno egresso = new Aluno("2024003", "Ana Pereira");
        egresso.setEgresso(true);

        double valorBase = 800.00;
        GeradorBoleto gerador = new GeradorBoleto();

        System.out.println();
        System.out.println("1) Desconto calculado");

        for (Aluno a : new Aluno[] { bolsista, egresso }) {
            PoliticaDesconto politica = PoliticaDescontoFactory.criar(a);

            Matricula m = new Matricula(a, "DSM-2A", politica);

            System.out.printf("   %-14s matricula: R$ %.2f%n", a.getNome(), m.calcularValor(valorBase));

            gerador.emitir(m, valorBase);
        }

        System.out.println();
        System.out.println("2) Reacoes a matricula, todas dentro da fachada");
        FachadaMatricula fachada = new FachadaMatricula();
        fachada.matricular(bolsista, "DSM-2A", false);

        System.out.println();
        System.out.println("   Agora com a turma lotada, e o aviso a coordenacao falhando:");
        try {
            fachada.matricular(egresso, "DSM-2B", true);
        } catch (IllegalStateException e) {
            System.out.println("   [erro] " + e.getMessage());
        }
        System.out.println("   >> DESLIZE 2: a falha de UMA reacao impediu a auditoria,");
        System.out.println("      que vinha depois dela. E a quinta reacao sera a quinta");
        System.out.println("      alteracao nesta mesma classe.");

        System.out.println();
        System.out.println("Sua tarefa: ver o README.md e a ficha de atividade pratica.");
    }
}

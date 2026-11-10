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
        PublicadorMatricula publicador = new PublicadorMatricula();

        publicador.registrar(new NotificadorEmail());
        publicador.registrar(new PainelVagas());
        publicador.registrar(new AvisoCoordenacao());
        publicador.registrar(new RegistroAuditoria());
        publicador.registrar(new EstatisticaOcupacao());

        FachadaMatricula fachada = new FachadaMatricula(publicador);
        fachada.matricular(bolsista, "DSM-2A", false);

        System.out.println();
        try {
            fachada.matricular(egresso, "DSM-2B", true);
        } catch (IllegalStateException e) {
            System.out.println("   [erro] " + e.getMessage());
        }
    }
}

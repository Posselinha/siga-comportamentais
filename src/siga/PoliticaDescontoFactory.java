package siga;

public class PoliticaDescontoFactory {

    public static PoliticaDesconto criar(Aluno aluno) {

        if (aluno.isBolsista()) {
            return new DescontoBolsista();
        }

        if (aluno.isServidor()) {
            return new DescontoServidor();
        }

        if (aluno.isEgresso()) {
            return new DescontoEgresso();
        }

        return new SemDesconto();
    }
}
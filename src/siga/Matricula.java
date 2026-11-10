package siga;

public class Matricula {

    private final Aluno aluno;
    private final String codigoTurma;
    private final PoliticaDesconto PoliticaDesconto;

    public Matricula(Aluno aluno, String codigoTurma, PoliticaDesconto politicaDesconto) {
        this.aluno = aluno;
        this.codigoTurma = codigoTurma;
        this.politicaDesconto = politicaDesconto;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public PoliticaDesconto getPoliticaDesconto() {
        return politicaDesconto;
    }

    public double calcularValor(double valorBase) {
        return politicaDesconto.aplicar(valorBase);
    }

    @Override
    public String toString() {
        return aluno.getNome() + " em " + codigoTurma;
    }
}

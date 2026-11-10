package siga;

public class AvisoCoordenacao implements OuvinteMatricula {

    @Override
    public void aoMatricular(Matricula matricula) {
        throw new IllegalStateException(
                "servico de aviso indisponivel para "
                + matricula.getCodigoTurma());
    }
}
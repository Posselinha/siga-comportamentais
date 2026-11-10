package siga;

public class EstatisticaOcupacao implements OuvinteMatricula {

    @Override
    public void aoMatricular(Matricula matricula) {
        System.out.println("[estatistica] ocupacao atualizada para a turma "
                + matricula.getCodigoTurma());
    }
}
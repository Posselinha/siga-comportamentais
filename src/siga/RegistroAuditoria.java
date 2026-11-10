package siga;

public class RegistroAuditoria implements OuvinteMatricula {

    @Override
    public void aoMatricular(Matricula matricula) {
        System.out.println("[auditoria] matrícula de "
                + matricula.getAluno().getMatricula()
                + " em " + matricula.getCodigoTurma());
    }
}

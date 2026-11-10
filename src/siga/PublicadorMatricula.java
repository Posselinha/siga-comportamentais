package siga;

import java.util.List;
import java.util.ArrayList;

public class PublicadorMatricula {

    private final List<OuvinteMatricula> ouvintes = new ArrayList<>();

    public void registrar(OuvinteMatricula ouvinte) {
        ouvintes.add(ouvinte);
    }

    public void remover(OuvinteMatricula ouvinte) {
        ouvintes.remove(ouvinte);
    }

    public void publicar(Matricula matricula) {
        for (OuvinteMatricula ouvinte : new ArrayList<>(ouvintes)) {
            try {
                ouvinte.aoMatricular(matricula);
            } catch (RuntimeException e) {
                System.err.println("Ouvinte falhou: " + e.getMessage());
            }
        }
    }
}
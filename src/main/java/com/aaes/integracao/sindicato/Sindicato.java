package com.aaes.integracao.sindicato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ponto central único do sindicato durante a execução da aplicação.
 */
public final class Sindicato {

    private static final Sindicato INSTANCE = new Sindicato();

    private final List<Associado> associados = new ArrayList<>();

    private Sindicato() {
    }

    public static Sindicato getInstance() {
        return INSTANCE;
    }

    public void adicionarAssociado(Associado associado) {
        associados.add(associado);
    }

    public List<Associado> listarAssociados() {
        return Collections.unmodifiableList(associados);
    }

    public SindicatoFactory factoryPara(String categoria) {
        return switch (categoria.toLowerCase()) {
            case "urbano" -> new SindicatoUrbanoFactory();
            case "rural" -> new SindicatoRuralFactory();
            default -> throw new IllegalArgumentException("Categoria de sindicato desconhecida: " + categoria);
        };
    }
}

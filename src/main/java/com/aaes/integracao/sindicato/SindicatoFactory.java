package com.aaes.integracao.sindicato;

/**
 * Abstract Factory da família de produtos de um tipo de sindicato.
 *
 * O método criarAtendimento é o Factory Method: cada fábrica concreta
 * decide qual atendimento compatível deve ser instanciado.
 */
public abstract class SindicatoFactory {

    public abstract CarteiraSindical criarCarteira();

    public abstract ContribuicaoSindical criarContribuicao();

    public final AtendimentoSindical criarAtendimento() {
        return criarAtendimentoConcreto();
    }

    protected abstract AtendimentoSindical criarAtendimentoConcreto();
}

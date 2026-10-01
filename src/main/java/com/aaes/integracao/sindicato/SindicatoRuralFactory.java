package com.aaes.integracao.sindicato;

public final class SindicatoRuralFactory extends SindicatoFactory {

    @Override
    public CarteiraSindical criarCarteira() {
        return new CarteiraRural();
    }

    @Override
    public ContribuicaoSindical criarContribuicao() {
        return new ContribuicaoRural();
    }

    @Override
    protected AtendimentoSindical criarAtendimentoConcreto() {
        return new AtendimentoRural();
    }

    private static final class CarteiraRural implements CarteiraSindical {
        @Override
        public String emitirPara(Associado associado) {
            return "Carteira rural emitida para " + associado.nome();
        }
    }

    private static final class ContribuicaoRural implements ContribuicaoSindical {
        @Override
        public String gerarPara(Associado associado) {
            return "Contribuicao rural gerada para " + associado.nome();
        }
    }

    private static final class AtendimentoRural implements AtendimentoSindical {
        @Override
        public String atender(Associado associado) {
            return "Atendimento rural realizado para " + associado.nome();
        }
    }
}

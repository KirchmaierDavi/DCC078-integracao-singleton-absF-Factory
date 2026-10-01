package com.aaes.integracao.sindicato;

public final class SindicatoUrbanoFactory extends SindicatoFactory {

    @Override
    public CarteiraSindical criarCarteira() {
        return new CarteiraUrbana();
    }

    @Override
    public ContribuicaoSindical criarContribuicao() {
        return new ContribuicaoUrbana();
    }

    @Override
    protected AtendimentoSindical criarAtendimentoConcreto() {
        return new AtendimentoUrbano();
    }

    private static final class CarteiraUrbana implements CarteiraSindical {
        @Override
        public String emitirPara(Associado associado) {
            return "Carteira urbana emitida para " + associado.nome();
        }
    }

    private static final class ContribuicaoUrbana implements ContribuicaoSindical {
        @Override
        public String gerarPara(Associado associado) {
            return "Contribuicao urbana gerada para " + associado.nome();
        }
    }

    private static final class AtendimentoUrbano implements AtendimentoSindical {
        @Override
        public String atender(Associado associado) {
            return "Atendimento urbano realizado para " + associado.nome();
        }
    }
}

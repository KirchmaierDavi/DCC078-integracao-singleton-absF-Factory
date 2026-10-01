package com.aaes.integracao.sindicato;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertSame;

class SindicatoPatternsTest {

    @Test
    void deveManterUmaUnicaInstanciaDoSindicato() {
        assertSame(Sindicato.getInstance(), Sindicato.getInstance());
    }

    @Test
    void deveCriarFamiliaUrbanaCoerentePelaAbstractFactory() {
        Associado associado = new Associado("Ana", "111");
        SindicatoFactory factory = Sindicato.getInstance().factoryPara("urbano");

        assertEquals("Carteira urbana emitida para Ana",
                factory.criarCarteira().emitirPara(associado));
        assertEquals("Contribuicao urbana gerada para Ana",
                factory.criarContribuicao().gerarPara(associado));
    }

    @Test
    void deveCriarAtendimentoDaFamiliaCorretaPeloFactoryMethod() {
        Associado associado = new Associado("Bruno", "222");

        AtendimentoSindical atendimento = Sindicato.getInstance()
                .factoryPara("rural")
                .criarAtendimento();

        assertInstanceOf(AtendimentoSindical.class, atendimento);
        assertEquals("Atendimento rural realizado para Bruno",
                atendimento.atender(associado));
    }

    @Test
    void deveRegistrarAssociadosNoSingleton() {
        Sindicato sindicato = Sindicato.getInstance();
        Associado associado = new Associado("Carla", "333");

        sindicato.adicionarAssociado(associado);

        assertEquals(associado, sindicato.listarAssociados().get(
                sindicato.listarAssociados().size() - 1));
    }

    @Test
    void deveRejeitarCategoriaDesconhecida() {
        assertThrows(IllegalArgumentException.class,
                () -> Sindicato.getInstance().factoryPara("industrial"));
    }
}

package br.com.fiapdelivery.main;

import br.com.fiapdelivery.model.Caminhao;
import br.com.fiapdelivery.model.Moto;
import br.com.fiapdelivery.model.Pacote;
import br.com.fiapdelivery.model.Rota;
import br.com.fiapdelivery.model.Veiculo;

/**
 * Classe de execucao: demonstra o sistema refatorado funcionando.
 */
public class SistemaPrincipal {

    /**
     * Ponto de entrada do FiapDelivery.
     */
    public static void main(String[] args) {

        System.out.println("=== FiapDelivery ===\n");

        /* Veiculos criados por construtor, ja validos. */
        Caminhao caminhao = new Caminhao("ABC1234", 5000.0, 3);
        Moto moto = new Moto("XYZ9A88", 20.0, true);

        System.out.println(caminhao.descrever());
        System.out.println(moto.descrever() + "\n");

        /* Pacotes nascem com status "Pendente". */
        Pacote pacoteGrande = new Pacote("BR999", 350.5);
        Pacote pacotePequeno = new Pacote("BR100", 8.0);

        /* A mesma classe Rota aceita caminhao e moto (polimorfismo). */
        Rota rotaCaminhao = new Rota(pacoteGrande, caminhao);
        Rota rotaMoto = new Rota(pacotePequeno, moto);

        rotaCaminhao.iniciarEntrega();
        rotaCaminhao.finalizarEntrega();
        System.out.println(pacoteGrande.descrever() + "\n");

        rotaMoto.iniciarEntrega();
        rotaMoto.finalizarEntrega();
        System.out.println(pacotePequeno.descrever() + "\n");

        /* A rota recusa carga acima da capacidade do veiculo. */
        new Rota(pacoteGrande, moto).iniciarEntrega();
        System.out.println();

        /* O encapsulamento barra o estado invalido do codigo legado. */
        try {
            Veiculo invalido = new Caminhao("DEF5678", -500.0, 2);
            System.out.println(invalido.descrever());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar veiculo: " + e.getMessage());
        }
    }
}
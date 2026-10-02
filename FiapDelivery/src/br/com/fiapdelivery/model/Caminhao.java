package br.com.fiapdelivery.model;

/**
 * Caminhao: herda placa e capacidade de Veiculo.
 * So declara o que e exclusivo dele: a quantidade de eixos.
 */
public class Caminhao extends Veiculo {

    private int quantidadeEixos;

    /**
     * Construtor: super(...) reaproveita a validacao da classe pai.
     */
    public Caminhao(String placa, double capacidadeCargaKg, int quantidadeEixos) {
        super(placa, capacidadeCargaKg);
        setQuantidadeEixos(quantidadeEixos);
    }

    public int getQuantidadeEixos() {
        return quantidadeEixos;
    }

    /**
     * Define a quantidade de eixos (minimo 2).
     */
    public void setQuantidadeEixos(int quantidadeEixos) {
        if (quantidadeEixos < 2) {
            throw new IllegalArgumentException("Minimo de 2 eixos.");
        }
        this.quantidadeEixos = quantidadeEixos;
    }

    /**
     * Sobrescreve a descricao do pai acrescentando os eixos.
     */
    @Override
    public String descrever() {
        return "Caminhao placa " + getPlaca() + " | " + quantidadeEixos
                + " eixos | " + getCapacidadeCargaKg() + " kg";
    }
}
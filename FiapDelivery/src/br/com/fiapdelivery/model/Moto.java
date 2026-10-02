package br.com.fiapdelivery.model;

/**
 * Moto: herda placa e capacidade de Veiculo.
 * So declara o que e exclusivo dela: a presenca de bau.
 */
public class Moto extends Veiculo {

    private boolean possuiBau;

    /**
     * Construtor: super(...) reaproveita a validacao da classe pai.
     */
    public Moto(String placa, double capacidadeCargaKg, boolean possuiBau) {
        super(placa, capacidadeCargaKg);
        this.possuiBau = possuiBau;
    }

    public boolean isPossuiBau() {
        return possuiBau;
    }

    public void setPossuiBau(boolean possuiBau) {
        this.possuiBau = possuiBau;
    }

    /**
     * Sobrescreve a descricao do pai acrescentando o bau.
     */
    @Override
    public String descrever() {
        return "Moto placa " + getPlaca() + " | " + (possuiBau ? "com bau" : "sem bau")
                + " | " + getCapacidadeCargaKg() + " kg";
    }
}
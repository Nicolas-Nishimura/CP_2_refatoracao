package br.com.fiapdelivery.model;

/**
 * Classe base da frota.
 * Guarda o que Caminhao e Moto tem em comum (placa e capacidade),
 * eliminando a duplicacao de codigo do projeto legado.
 */
public class Veiculo {

    private String placa;
    private double capacidadeCargaKg;

    /**
     * Construtor: o objeto ja nasce em estado valido.
     */
    public Veiculo(String placa, double capacidadeCargaKg) {
        setPlaca(placa);
        setCapacidadeCargaKg(capacidadeCargaKg);
    }

    public String getPlaca() {
        return placa;
    }

    /**
     * Define a placa. Nao aceita valor nulo ou vazio.
     */
    public void setPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("Placa invalida.");
        }
        this.placa = placa.trim().toUpperCase();
    }

    public double getCapacidadeCargaKg() {
        return capacidadeCargaKg;
    }

    /**
     * Define a capacidade em kg.
     * Impede o valor negativo que existia no codigo antigo (cap = -500).
     */
    public void setCapacidadeCargaKg(double capacidadeCargaKg) {
        if (capacidadeCargaKg <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        }
        this.capacidadeCargaKg = capacidadeCargaKg;
    }

    /**
     * Regra de negocio: verifica se o veiculo aguenta o peso informado.
     */
    public boolean suportaCarga(double pesoKg) {
        return pesoKg > 0 && pesoKg <= capacidadeCargaKg;
    }

    /**
     * Texto de exibicao; cada classe filha sobrescreve com seus detalhes.
     */
    public String descrever() {
        return "Veiculo placa " + placa + " (" + capacidadeCargaKg + " kg)";
    }
}
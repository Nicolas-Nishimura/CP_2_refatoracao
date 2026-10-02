package br.com.fiapdelivery.model;

/**
 * Pacote transportado pelo sistema.
 * Codigo e peso vem do construtor; o status so muda pelo metodo proprio.
 */
public class Pacote {

    private String codigo;
    private double pesoKg;
    private String status;

    /**
     * Construtor: todo pacote nasce com status "Pendente".
     */
    public Pacote(String codigo, double pesoKg) {
        setCodigo(codigo);
        setPesoKg(pesoKg);
        this.status = "Pendente";
    }

    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o codigo de rastreio. Nao aceita valor nulo ou vazio.
     */
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Codigo invalido.");
        }
        this.codigo = codigo.trim().toUpperCase();
    }

    public double getPesoKg() {
        return pesoKg;
    }

    /**
     * Define o peso em kg. Precisa ser maior que zero.
     */
    public void setPesoKg(double pesoKg) {
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero.");
        }
        this.pesoKg = pesoKg;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Atualiza o status do pacote.
     * Substitui o antigo muda(String x): nome claro e com validacao.
     */
    public void atualizarStatus(String novoStatus) {
        if (novoStatus == null || novoStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Status invalido.");
        }
        this.status = novoStatus.trim();
    }

    /**
     * Texto de exibicao do pacote.
     */
    public String descrever() {
        return "Pacote " + codigo + " | " + pesoKg + " kg | status: " + status;
    }
}
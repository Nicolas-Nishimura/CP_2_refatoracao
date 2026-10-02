package br.com.fiapdelivery.model;
/**
 * Rota de entrega: associa um Pacote a um Veiculo.
 * O campo e do tipo Veiculo (e nao Caminhao), entao a mesma Rota
 * funciona para moto, caminhao ou qualquer veiculo criado no futuro.
 */
public class Rota {

    private Pacote pacote;
    private Veiculo veiculo;

    /**
     * Construtor: a rota ja nasce com pacote e veiculo definidos.
     */
    public Rota(Pacote pacote, Veiculo veiculo) {
        setPacote(pacote);
        setVeiculo(veiculo);
    }

    public Pacote getPacote() {
        return pacote;
    }

    /**
     * Define o pacote da rota. Nao aceita nulo.
     */
    public void setPacote(Pacote pacote) {
        if (pacote == null) {
            throw new IllegalArgumentException("Pacote obrigatorio.");
        }
        this.pacote = pacote;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * Define o veiculo da rota. Aceita qualquer filho de Veiculo.
     */
    public void setVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veiculo obrigatorio.");
        }
        this.veiculo = veiculo;
    }

    /**
     * Inicia a entrega. Substitui o antigo vai():
     * valida o peso antes de transportar e atualiza o status.
     */
    public boolean iniciarEntrega() {
        if (!veiculo.suportaCarga(pacote.getPesoKg())) {
            System.out.println("Entrega recusada: " + pacote.getCodigo()
                    + " excede a capacidade do veiculo " + veiculo.getPlaca() + ".");
            return false;
        }
        pacote.atualizarStatus("Em transporte");
        System.out.println("Levando o pacote " + pacote.getCodigo()
                + " com o " + veiculo.descrever());
        return true;
    }

    /**
     * Finaliza a entrega marcando o pacote como entregue.
     */
    public void finalizarEntrega() {
        pacote.atualizarStatus("Entregue");
        System.out.println("Pacote " + pacote.getCodigo() + " entregue com sucesso.");
    }
}
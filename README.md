# FiapDelivery — Check Point 2 (Refatoração)

Refatoração do código legado do sistema de logística **FiapDelivery**, aplicando
encapsulamento, herança, associação, construtores, documentação e Clean Code.

## Estrutura

```
FiapDelivery/
├── diagrama/
│   └── FiapDelivery.png   # diagrama de classes exportado do Astah
└── src/
    ├── main/
    │   └── Principal.java # execução / demonstração
    └── model/
        ├── Veiculo.java   # superclasse (placa, capacidade)
        ├── Caminhao.java  # extends Veiculo (eixos)
        ├── Moto.java      # extends Veiculo (bau)
        ├── Pacote.java    # codigo, peso, status
        └── Rota.java      # associa Pacote + Veiculo
```



# Virtual Pet Simulation Game

## Descrição do Projeto
Este projeto em Java simula um jogo interativo de cuidado com um pet virtual. Os usuários podem interagir com o pet virtual, cuidando dele e observando seu desenvolvimento ao longo do tempo. O código é bem organizado em pacotes distintos para facilitar a manutenção e a escalabilidade.

## Estrutura do Projeto
O projeto é dividido nos seguintes pacotes para uma melhor separação das responsabilidades:

- **controllers**: Classes de controle do jogo e da interface gráfica do usuário (GUI).
- **enums**: Classes enum para definir diferentes estados ou tipos, como `Status`, `Disease`, e `Stage`.
- **exceptions**: Classes de exceção para tratamento de erros específicos, como `StatusException`.
- **models**: Classes que representam o pet virtual e seus atributos, como `Pet`.
- **services**: Classes que fornecem serviços relacionados ao gerenciamento do pet virtual, como `PetService`.
- **utils**: Classes utilitárias que auxiliam em operações como gestão de eventos aleatórios e o relógio do jogo.

## Compilação e Execução

Para compilar e executar este projeto, siga os seguintes passos no terminal:

1. Compile o projeto usando:

```bash
javac -d bin -sourcepath src src/enums/.java src/exceptions/.java src/models/.java src/services/.java src/controllers/.java src/utils/.java
```

2. Execute o jogo com:

```bash
java -cp bin src.controllers.App
```

## Principais Classes e Métodos
- **App.java**: Classe principal que inicia o jogo.
- **PetController.java**: Controla as interações do usuário com o pet virtual.
- **PetService.java**: Gerencia a lógica de negócios relacionada ao pet virtual.
- **TamagotchiGUI.java**: Implementa a GUI, mostrando o estado do pet e permitindo interações do usuário.
- **Pet.java**: Representa o pet virtual, incluindo seus atributos e comportamentos.
- **Status.java**, **Disease.java**, **Stage.java**: Enums que definem os estados do pet, doenças e estágios de vida.
- **RandomEvents.java**: Gerencia eventos aleatórios que afetam o pet.
- **PetClock.java**: Relógio do jogo que atualiza o status do pet com o passar do tempo.

## Fluxo do Jogo
1. Início com a criação de um `Pet` e a GUI `TamagotchiGUI`.
2. Interações do usuário com o pet através da GUI.
3. Ações processadas pelo `PetController`, que usa `PetService` para atualizar o estado do pet.
4. `PetService` considera ações do usuário e eventos aleatórios para atualizar o pet.
5. `TamagotchiGUI` mostra o estado atualizado do pet.
6. O jogo termina quando o pet morre, com verificações de estado após cada atualização.

## Exceções e Validações
- **StatusException**: Trata erros de status do pet.
- Validações em `PetService` e `Pet` para manter os atributos dentro de limites seguros.

## Conclusão
Este projeto demonstra a aplicação de conceitos de programação orientada a objetos para desenvolver um jogo de simulação. Utiliza classes, enums, interfaces, e exceções para estruturar o código de forma modular e clara, com uma GUI rica implementada via Swing.

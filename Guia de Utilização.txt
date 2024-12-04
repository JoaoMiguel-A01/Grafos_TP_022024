# Guia para Uso do Trabalho Prático de Algoritmos em Grafos

## Configuração do Ambiente
### Passo 1: Extração dos Arquivos
- Obtenha o arquivo do programa e extraia-o para uma pasta no seu computador.

### Passo 2: Configuração no Visual Studio Code (ou IDE de sua preferência)
- Abra o **Visual Studio Code** e vá em **Arquivo > Abrir Pasta**, selecionando a pasta onde os arquivos foram extraídos.
- Instale as extensões recomendadas para Java, se estiver usando o Visual Studio Code:
  - **Extension Pack for Java**
  - **Debugger for Java**
  - **Test Runner for Java**
  - **Maven for Java**
  - **Project Manager for Java**

### Passo 3: Compilação e Execução
- Utilize a funcionalidade **Run** no Visual Studio Code para compilar e executar o programa.

---

## Interação com o Programa

Assim que o programa for iniciado, você verá um menu principal com três opções:

### 1. Testar Algoritmos de Menor Caminho
- Escolha esta opção para executar os algoritmos:
  - **Dijkstra**
  - **Bellman-Ford**
  - **Floyd-Warshall**
  - **A-Star**
- Você será solicitado a:
  - Informar a quantidade de vértices.
  - Escolher entre buscar a menor distância de:
    - Um único vértice para todos (digite **1**).
    - Todos os vértices para todos (digite **2**).

### 2. Criar Seu Próprio Grafo
Nesta opção, é possível criar e manipular grafos personalizados. Siga os passos abaixo:

#### Configuração Inicial
- Informe a quantidade de vértices.
- Indique se o grafo é direcionado (digite **1** para "Sim").
- Indique se o grafo é ponderado (digite **1** para "Sim").
- Insira os nomes dos vértices.

#### Menu de Funções do Grafo
Após a configuração, você terá acesso a um menu com as seguintes funcionalidades:

1. **Adicionar Aresta:** Insira os vértices de início e fim e, se o grafo for ponderado, o peso.
2. **Remover Aresta:** Insira os vértices de início e fim da aresta a ser removida.
3. **Ver Vizinhos de um Vértice:** Informe o vértice para listar seus vizinhos.
4. **Ver Grau de um Vértice:** Informe o vértice para calcular seu grau.
5. **Ver Grau do Grafo:** Mostra o grau geral do grafo.
6. **Busca em Largura:** Realiza uma busca em largura a partir de um vértice.
7. **Verificar Conexidade:** Verifica se o grafo é conexo.
8. **Verificar Regularidade:** Verifica se todos os vértices têm o mesmo grau.
9. **Verificar Completude:** Determina se o grafo é completo.
10. **Busca em Profundidade:** Realiza uma busca em profundidade.
11. **Encontrar Melhor Caminho:** Insira os vértices de origem e destino.
12. **Exportar para GEXF:** Exporta o grafo no formato GEXF.
13. **Executar Dijkstra:** Executa o algoritmo Dijkstra a partir de um vértice.
14. **Executar Bellman-Ford:** Executa o algoritmo Bellman-Ford a partir de um vértice.
15. **Executar Floyd-Warshall:** Calcula os menores caminhos entre todos os pares.
16. **Executar A-Star:** Executa o algoritmo A-Star.
17. **Matriz de Adjacência:** Exibe o grafo como matriz de adjacência.
18. **Lista de Adjacência:** Exibe o grafo como lista de adjacência.
19. **Verificar Aciclicidade:** Indica se o grafo é acíclico.
20. **Verificar Propriedades Eulerianas:** Determina se o grafo é Euleriano.
21. **Sair da Criação de Grafo:** Retorna ao menu principal.

### 3. Sair
- Escolha esta opção para encerrar o programa.

---
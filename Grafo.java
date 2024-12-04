/**
 * Algoritmos em Grafos
 * Pontifícia Universidade de Minas Gerais
 * Instituto de Ciências Exatas e Informática
 * Engenharia de Computação
 * Última Atualização: 03/12/2024
 * Integrantes: David Lanna de Moraes, João Miguel de Abreu Constâncio e Paulo Ricardo Ferreira Gualberto. 
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class Grafo<TIPO> {
	private int numvertices;
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    Scanner sc = new Scanner (System.in);
    
    /**
     * Construtor da classe Grafo. Inicializa as listas de vértices e arestas.
     */
    public Grafo(){
    	
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
        
    }

     //Adiciona a quantidade de vertices do grafo
      
    void addnumvertices(int numerovertices) {
      
    	this.numvertices = numerovertices;
    	
    }

    // Adiciona um novo vertice ao grafo.
     
    public void adicionarVertice(TIPO dado){
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }

     //Adiciona uma aresta direcionada com peso entre dois vertices.
  
    public void adicionarArestaDir(Double peso, TIPO dadoInicio, TIPO dadoFim){
    	
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        

        if(inicio != null && fim != null ) {
        	
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    	System.out.println("Aresta adicionada!");
        }
        else{
        	System.out.println("Algum vertice informado nao existe!");
        }
    }

     //  Adiciona uma aresta nao direcionada entre dois vertices.
     
    public void adicionarArestaNaoDir(Double peso, TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = getVertice(dadoInicio);
        Vertice<TIPO> fim = getVertice(dadoFim);

        if (inicio != null && fim != null) {
            Aresta<TIPO> aresta1 = new Aresta<TIPO>(peso, inicio, fim);
            Aresta<TIPO> aresta2 = new Aresta<TIPO>(peso, fim, inicio);

            inicio.adicionarArestaSaida(aresta1);
            inicio.adicionarArestaEntrada(aresta2);
            fim.adicionarArestaSaida(aresta2);
            fim.adicionarArestaEntrada(aresta1);

            arestas.add(aresta1);
            arestas.add(aresta2);
        	System.out.println("Aresta adicionada!");

        } else {
            System.out.println("Algum v�rtice informado n�o existe!");
        }
    }

    // Remove uma aresta direcionada
    public void removeraresta(TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
    
        if (inicio != null && fim != null) {
            Aresta<TIPO> arestaParaRemover = null;
    
            // Encontre a aresta correta para remover.
            for (Aresta<TIPO> aresta : inicio.getArestasSaida()) {
                if (aresta.getFim() == fim) {
                    arestaParaRemover = aresta;
                    break;
                }
            }
    
            if (arestaParaRemover != null) {
                inicio.removerArestaSaida(arestaParaRemover);
                fim.removerArestaEntrada(arestaParaRemover);
                this.arestas.remove(arestaParaRemover);
            	System.out.println("Aresta Removida!");

            }
        }
        else {
            System.out.println("Algum vertice informado n�o existe!");
        }
    }

    // Remove uma aresta nao direcionada
    public void removerArestaNaoDir(TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = getVertice(dadoInicio);
        Vertice<TIPO> fim = getVertice(dadoFim);

        if (inicio != null && fim != null) {
            // Remove a primeira direcao da aresta (inicio para fim)
            Aresta<TIPO> aresta1 = new Aresta<TIPO>(null, inicio, fim);
            inicio.removerArestaSaida(aresta1);
            inicio.removerArestaEntrada(aresta1);
            arestas.remove(aresta1);

            // Remove a segunda direcao da aresta (fim para inicio)
            Aresta<TIPO> aresta2 = new Aresta<TIPO>(null, fim, inicio);
            fim.removerArestaSaida(aresta2);
            fim.removerArestaEntrada(aresta2);
            arestas.remove(aresta2);
            System.out.println("Aresta Removida!");
        } else {
            System.out.println("Algum v�rtice informado n�o existe!");
        }
    }

     // Obtem um vertice pelo seu dado associado
    public Vertice<TIPO> getVertice(TIPO dadoInicio){
        Vertice<TIPO> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dadoInicio)){
                vertice = this.vertices.get(i);
            }	
        }
        return vertice;
    }

    // Obtem o numero de vizinhos de um vertice em um grafo direcionado
    public int  getVizinhos(TIPO dado ){

        String vizinhos;
        TIPO test;
        int countVizinhos=0;
                // Se existir uma aresta com um vertice inicial igual ao fornecido, ent�o o vertice final � vizinho
            	for(int i=0; i<this.arestas.size();i++) {
            		test = this.arestas.get(i).getInicio().getDado();
        		    if(test.equals(dado)) {
                       vizinhos = (String) this.arestas.get(i).getFim().getDado();
                       countVizinhos++;
                       System.out.println(countVizinhos + " Vizinho = " + vizinhos);
                       
                    }
                }
 
                if(countVizinhos == 0 ){
                    System.out.println(dado +" nao tem vizinhos");
                }
                
           return countVizinhos;
    }
    
     //Obtem o numero de vizinhos de um vertice em um grafo N direcionado
    public int  getVizinhosNaoDir(TIPO dado ){

        String vizinhos;
        TIPO test;
        int countVizinhos=0;
        
            	for(int i=0; i<this.arestas.size();i++) {
            		test = this.arestas.get(i).getInicio().getDado();
        		    if(test.equals(dado)) {
                       vizinhos = (String) this.arestas.get(i).getFim().getDado();
                       countVizinhos++;
                       System.out.println(countVizinhos + " Vizinho = " + vizinhos);
                       
                    }
                }
            	for(int i=0; i<this.arestas.size();i++) {
            		test = this.arestas.get(i).getFim().getDado();
        		    if(test.equals(dado)) {
                       vizinhos = (String) this.arestas.get(i).getInicio().getDado();
                       countVizinhos++;
                       System.out.println(countVizinhos + " Vizinho = " + vizinhos);
                       
                    }
                }
                if(countVizinhos == 0 ){
                    System.out.println(dado +" nao tem vizinhos");
                }
                
           return countVizinhos;
    }
    
    //Obtem grau do vertice direcionado
    public int getGrauverticeDir(TIPO dado) {
        int grauSaida = 0;
        int grauEntrada = 0;
        // Se o valor for igual ao vertice de entrada da aresta, entao pegar o vertice de saida e somar 1 no grau.
        for (Aresta<TIPO> aresta : this.arestas) {
            if (dado.equals(aresta.getInicio().getDado())) {
                // Aresta de saida do vertice
                grauSaida++;
            }
            if (dado.equals(aresta.getFim().getDado())) {
                // Aresta de entrada para o vertice
                grauEntrada++;
            }
        }

        int grauTotal = grauSaida + grauEntrada;

        System.out.println("Grau de saida do vertice " + dado + ": " + grauSaida);
        System.out.println("Grau de entrada do vertice " + dado + ": " + grauEntrada);
        System.out.println("Grau total do vertice " + dado + ": " + grauTotal);

        return grauTotal;
    }
    
    // Obtem grau de um vertice N direcionado
    public int getGrauVerticeNaoDir(TIPO dado) {
        int grau = 0;
        Set<TIPO> vizinhos = new HashSet<>();
       
        for (Aresta<TIPO> aresta : this.arestas) {
            if (dado.equals(aresta.getInicio().getDado())) {
                // Aresta de sa�da do v�rtice
                TIPO vizinho = aresta.getFim().getDado();
                if (!vizinhos.contains(vizinho)) {
                    grau++;
                    vizinhos.add(vizinho);
                }
            } else if (dado.equals(aresta.getFim().getDado())) {
                // Aresta de entrada para o v�rtice
                TIPO vizinho = aresta.getInicio().getDado();
                if (!vizinhos.contains(vizinho)) {
                    grau++;
                    vizinhos.add(vizinho);
                }
            }
        }
        System.out.println("Grau do vertice " + dado + ": " + grau);
        return grau;
    }
    
    // Obtem o grau do grafo em um grafo direcionado.
    
    public void getGrauGrafoDir() {
        int grauTotal = 0;
        for (Vertice<TIPO> vertice : this.vertices) {
            int grauSaida = 0;
            for (Aresta<TIPO> aresta : vertice.getArestasSaida()) {
                grauSaida++;
            }
            grauTotal += grauSaida;
        }
       System.out.println(" Grau do grafo : "+ grauTotal);
    }
    
     /**
     * Obtém o grau do grafo em um grafo não direcionado.
     */
    public void getGrauGrafoNaoDir() {
        int grauTotal = 0;
        Set<TIPO> verticesProcessados = new HashSet<>();

        for (Aresta<TIPO> aresta : this.arestas) {
            Vertice<TIPO> inicio = aresta.getInicio();
            Vertice<TIPO> fim = aresta.getFim();

            if (!verticesProcessados.contains(inicio.getDado())) {
                grauTotal += getGrauVerticeNaoDir(inicio.getDado());
                verticesProcessados.add(inicio.getDado());
            }

            if (!verticesProcessados.contains(fim.getDado())) {
                grauTotal += getGrauVerticeNaoDir(fim.getDado());
                verticesProcessados.add(fim.getDado());
            }
        }

        System.out.println("Grau do grafo: " + grauTotal);

        return ;
    }
    
     /**
     * Verifica se o grafo � conexo.
     */
    public void conexo() {
        if (vertices.isEmpty()) {
            // Um grafo vazio � considerado conexo por defini��o.
        	System.out.println("O grafo esta vazio !");
            return ;
        }
        
        Vertice<TIPO> primeiroVertice = vertices.get(0);
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        marcados.add(primeiroVertice);
        fila.add(primeiroVertice);
        
        while (!fila.isEmpty()) {
            Vertice<TIPO> visitado = fila.remove(0);
            for (Aresta<TIPO> aresta : visitado.getArestasSaida()) {
                Vertice<TIPO> proximo = aresta.getFim();
                if (!marcados.contains(proximo)) {
                    marcados.add(proximo);
                    fila.add(proximo);
                }
            }
        }
        
        // Se o n�mero de v�rtices marcados � igual ao n�mero total de v�rtices, o grafo � conexo.
        if(marcados.size() == vertices.size()) {
        	System.out.println("O grafo � conexo !");
        }
        else {
        	System.out.println("O grafo � desconexo !");

        }
   
    }
    
    /**
     * Verifica se o grafo direcionado é regular.
     */
    public void regularDir() {
        if (vertices.isEmpty()) {
            System.out.println("Grafo est� vazio");
            return;
        }

        int grauPrimeiroVertice = getGrauverticeDir(vertices.get(0).getDado());
        
        for (Vertice<TIPO> vertice : vertices) {
            int grau = getGrauverticeDir(vertice.getDado());
            if (grau != grauPrimeiroVertice) {
            	System.out.println("O grafo � nao � regular");
                return;
            }
        }
    	System.out.println("O grafo � "+ grauPrimeiroVertice + "regular");

        return;
    }
    
     /**
     * Verifica se o grafo não direcionado é regular.
     */
    public void regularNaoDir() {
        if (vertices.isEmpty()) {
            System.out.println("Grafo est� vazio");
            return ;
        }

        int grauPrimeiroVertice = getGrauVerticeNaoDir(vertices.get(0).getDado());

        for (Vertice<TIPO> vertice : vertices) {
            int grau = getGrauVerticeNaoDir(vertice.getDado());
            if (grau != grauPrimeiroVertice) {
            	System.out.println("O grafo � nao � regular");

                return ;
            }
        }
    	System.out.println("O grafo � "+ grauPrimeiroVertice + "regular");

        return ;
    }
    
    /**
     * Verifica se o grafo não direcionado é completo.
     */
    public void CompletoNaoDir() {
        int totalVertices = vertices.size();
        int totalArestas = arestas.size();

        // O n�mero total de arestas em um grafo completo n�o direcionado � dado por C(n, 2), onde n � o n�mero de v�rtices.
        int arestasCompletas = (totalVertices * (totalVertices - 1)) / 2;
        if(totalArestas == arestasCompletas) {
        	System.out.println("O grafo � completo");
        }
        else {
        	System.out.println("O grafo nao � completo");

        }

        return ;
    }


    public double[][] criarMatrizAdjacencia() {
        int tamanho = vertices.size();
        double[][] matrizAdjacencia = new double[tamanho][tamanho];
    
        // Inicializa a matriz com zeros
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrizAdjacencia[i][j] = 0;
            }
        }
    
        // Preenche a matriz com as conexões entre vértices
        for (Aresta<TIPO> aresta : arestas) {
            Vertice<TIPO> inicio = aresta.getInicio();
            Vertice<TIPO> fim = aresta.getFim();
            double peso = aresta.getPeso();
    
            int indiceInicio = vertices.indexOf(inicio);
            int indiceFim = vertices.indexOf(fim);
    
            // Verifica se os vértices são encontrados na lista
            if (indiceInicio != -1 && indiceFim != -1) {
                // Define a entrada na matriz com peso para indicar uma aresta direcionada
                matrizAdjacencia[indiceInicio][indiceFim] = peso;
            }
            // Adicione um bloco else se desejar lidar com o caso em que os vértices não são encontrados.
        }
    
        return matrizAdjacencia;
    }

    // Imprime a matriz de adjacência.
   
    public void imprimirMatrizAdjacencia() {
        double[][] matriz = criarMatrizAdjacencia();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }


    
     /**
     * Verifica se o grafo direcionado é completo.
     */
    public void CompletoDir() {
        int totalVertices = vertices.size();
        int totalArestas = arestas.size();

        // O n�mero total de arestas em um grafo completo direcionado � n * (n - 1), onde n � o n�mero de v�rtices.
        int arestasCompletas = totalVertices * (totalVertices - 1);
        if(totalArestas == arestasCompletas) {
        	System.out.println("O grafo � completo");
        }
        else {
        	System.out.println("O grafo nao � completo");

        }

        return;
    }
    
    /**
     * Realiza uma busca em largura a partir de um vértice.
     */
    public void buscaEmLargura() {
        System.out.println("Informe o vértice que deseja iniciar a busca:");
        TIPO valor = (TIPO) sc.next();
    
        Vertice<TIPO> verticeInicial = getVertice(valor);
    
        if (verticeInicial == null) {
            System.out.println("O vértice inicial não existe no grafo.");
            return;
        }
    
        Set<Vertice<TIPO>> visitados = new HashSet<>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<>();
        visitados.add(verticeInicial);
        System.out.println("Início: " + verticeInicial.getDado());
        fila.add(verticeInicial);
    
        while (!fila.isEmpty()) {
            Vertice<TIPO> visitado = fila.remove(0);
            System.out.println("Visitando: " + visitado.getDado()); // Mensagem de teste
    
            for (Aresta<TIPO> aresta : visitado.getArestasSaida()) {
                Vertice<TIPO> proximo = aresta.getFim();
                if (!visitados.contains(proximo)) {
                    visitados.add(proximo);
                    System.out.println("Próximo: " + proximo.getDado()); // Mensagem de teste
                    fila.add(proximo);
                }
            }
        }
    }
    
    /**
     * Realiza uma busca em profundidade a partir de um vértice.
     */
    public void buscaEmProfundidade() {
        System.out.println("Qual o vértice que vai iniciar a busca?");
        TIPO teste = (TIPO) sc.next();
        Vertice<TIPO> verticeInicial = getVertice(teste);
    
        if (vertices.isEmpty() || verticeInicial == null) {
            System.out.println("Grafo vazio ou vértice inicial nulo.");
            return;
        }
    
        Set<Vertice<TIPO>> visitados = new HashSet<>();
        System.out.println("Início da busca em profundidade:");
        buscaEmProfundidadeRecursiva(verticeInicial, visitados);
    }
    /**
     * Função recursiva para busca em profundidade.
     */
    private void buscaEmProfundidadeRecursiva(Vertice<TIPO> vertice, Set<Vertice<TIPO>> visitados) {
        visitados.add(vertice);
        System.out.println("Visitando: " + vertice.getDado());
    
        for (Aresta<TIPO> aresta : vertice.getArestasSaida()) {
            Vertice<TIPO> proximo = aresta.getFim();
            if (!visitados.contains(proximo)) {
                System.out.println("Indo para: " + proximo.getDado());
                buscaEmProfundidadeRecursiva(proximo, visitados);
            }
        }
    }
    
    public void encontrarMelhorCaminho(TIPO origem, TIPO destino) {
        Vertice<TIPO> verticeOrigem = getVertice(origem);
        Vertice<TIPO> verticeDestino = getVertice(destino);

        if (verticeOrigem == null || verticeDestino == null) {
            System.out.println("V�rtices de origem ou destino n�o encontrados.");
            return;
        }

        Queue<Vertice<TIPO>> fila = new LinkedList<>();
        fila.add(verticeOrigem);

        // Mapa de visitados para rastrear o caminho
        java.util.HashMap<Vertice<TIPO>, Vertice<TIPO>> mapaDeCaminho = new java.util.HashMap<>();
        mapaDeCaminho.put(verticeOrigem, null);

        boolean encontrado = false;

        while (!fila.isEmpty()) {
            Vertice<TIPO> atual = fila.poll();
            if (atual == verticeDestino) {
                encontrado = true;
                break;
            }

            for (Aresta<TIPO> aresta : atual.getArestasSaida()) {
                Vertice<TIPO> vizinho = aresta.getFim();
                if (!mapaDeCaminho.containsKey(vizinho)) {
                    fila.add(vizinho);
                    mapaDeCaminho.put(vizinho, atual);
                }
            }
        }

        if (encontrado) {
            System.out.println("Caminho mais curto entre " + origem + " e " + destino + ":");
            Stack<TIPO> caminho = new Stack<>();
            Vertice<TIPO> vertice = verticeDestino;
            while (vertice != null) {
                caminho.push(vertice.getDado());
                vertice = mapaDeCaminho.get(vertice);
            }
            while (!caminho.isEmpty()) {
                System.out.print(caminho.pop());
                if (!caminho.isEmpty()) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("N�o h� caminho entre " + origem + " e " + destino + ".");
        }
    }
    
    
    public void exportarParaGEXF() {
        try {
            FileWriter fileWriter = new FileWriter("meuGrafo.gexf");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Escreve o cabe�alho do arquivo GEXF
            printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            printWriter.println("<gexf xmlns=\"http://www.gexf.net/1.2draft\" version=\"1.2\">");
            printWriter.println("<graph mode=\"static\" defaultedgetype=\"directed\">");
            printWriter.println("<nodes>");

            // Escreve informa��es sobre os v�rtices
            for (Vertice<TIPO> vertice : vertices) {
                printWriter.println("<node id=\"" + vertice.getDado() + "\" label=\"" + vertice.getDado() + "\" />");
            }

            printWriter.println("</nodes>");
            printWriter.println("<edges>");

            // Escreve informa��es sobre as arestas
            for (Aresta<TIPO> aresta : arestas) {
                printWriter.println("<edge source=\"" + aresta.getInicio().getDado() + "\" target=\"" + aresta.getFim().getDado() + "\" />");
            }

            printWriter.println("</edges>");
            printWriter.println("</graph>");
            printWriter.println("</gexf>");

            printWriter.close();
            System.out.println("Grafo exportado para o arquivo " + "meuGrafo.gexf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//------------------------------------------------------------------Algoritmo Dijkstra----------------------------------------------------------------------------//

    public void dijkstra(TIPO origem) {
        Vertice<TIPO> verticeOrigem = getVertice(origem);

        if (verticeOrigem == null) {
            System.out.println("Vértice de origem não encontrado.");
            return;
        }

        // Mapa de distâncias mínimas
        Map<Vertice<TIPO>, Double> distancias = new HashMap<>();
        for (Vertice<TIPO> vertice : vertices) {
            distancias.put(vertice, Double.POSITIVE_INFINITY);
        }
        distancias.put(verticeOrigem, 0.0);

        // Mapa de visitados para rastrear os vértices visitados
        Map<Vertice<TIPO>, Boolean> visitados = new HashMap<>();
        for (Vertice<TIPO> vertice : vertices) {
            visitados.put(vertice, false);
        }

        // Fila de prioridade para selecionar o próximo vértice a ser processado
        PriorityQueue<Vertice<TIPO>> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));
        filaPrioridade.add(verticeOrigem);

        while (!filaPrioridade.isEmpty()) {
            Vertice<TIPO> verticeAtual = filaPrioridade.poll();
            visitados.put(verticeAtual, true);

            for (Aresta<TIPO> aresta : verticeAtual.getArestasSaida()) {
                Vertice<TIPO> verticeVizinho = aresta.getFim();
                if (!visitados.get(verticeVizinho)) {
                    double novaDistancia = distancias.get(verticeAtual) + aresta.getPeso();
                    if (novaDistancia < distancias.get(verticeVizinho)) {
                        distancias.put(verticeVizinho, novaDistancia);
                        filaPrioridade.add(verticeVizinho);
                    }
                }
            }
        }

        // Exibindo os caminhos mínimos a partir do vértice de origem
        for (Vertice<TIPO> vertice : vertices) {
            if (vertice != verticeOrigem) {
                System.out.print("Dijkstra | Caminho mínimo de " + origem + " para " + vertice.getDado() + ": ");     //Olhar mais tarde
                Stack<Vertice<TIPO>> caminho = new Stack<>();
                Vertice<TIPO> temp = vertice;
                while (temp != null) {
                    caminho.push(temp);
                    temp = temp.getCaminhoAnterior();
                }
                while (!caminho.isEmpty()) {
                   System.out.print(caminho.pop().getDado());        //Olhar mais tarde
                    if (!caminho.isEmpty()) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println(" (Distância: " + distancias.get(vertice) + ")");    //Olhar mais tarde
            }
        }
    }
//------------------------------------------------------------------Algoritmo Bellman-Ford----------------------------------------------------------------------------//


public void bellmanFord(TIPO origem) {
    Vertice<TIPO> verticeOrigem = getVertice(origem);

    if (verticeOrigem == null) {
        System.out.println("Vértice de origem não encontrado.");
        return;
    }

    // Inicialização: atribui o valor de distância infinita para todos os vértices exceto o vértice de origem
    Map<Vertice<TIPO>, Double> distancias = new HashMap<>();
    for (Vertice<TIPO> vertice : vertices) {
        distancias.put(vertice, Double.POSITIVE_INFINITY);
    }
    distancias.put(verticeOrigem, 0.0);

    // Relaxamento das arestas repetidas V-1 vezes
    int numeroVertices = vertices.size();
    for (int i = 0; i < numeroVertices - 1; i++) {
        for (Aresta<TIPO> aresta : arestas) {
            Vertice<TIPO> u = aresta.getInicio();
            Vertice<TIPO> v = aresta.getFim();
            double peso = aresta.getPeso();
            if (distancias.get(u) + peso < distancias.get(v)) {
                distancias.put(v, distancias.get(u) + peso);
            }
        }
    }

    // Verifica ciclos negativos
    for (Aresta<TIPO> aresta : arestas) {
        Vertice<TIPO> u = aresta.getInicio();
        Vertice<TIPO> v = aresta.getFim();
        double peso = aresta.getPeso();
        if (distancias.get(u) + peso < distancias.get(v)) {
            System.out.println("O grafo contém ciclo negativo.");
            return;
        }
    }

    // Exibindo os caminhos mínimos a partir do vértice de origem
    for (Vertice<TIPO> vertice : vertices) {
        if (vertice != verticeOrigem) {
            System.out.println("Bellman-Ford | Caminho mínimo de " + origem + " para " + vertice.getDado() + ": " + distancias.get(vertice));
        }
    }
}
  
//------------------------------------------------------------------Floyd-Warshall----------------------------------------------------------------------------//


 
 public void floydWarshall() {
    int numVertices = vertices.size();
    double[][] distancias = new double[numVertices][numVertices];

    // Inicializa a matriz de distâncias
    for (int i = 0; i < numVertices; i++) {
        for (int j = 0; j < numVertices; j++) {
            if (i == j) {
                distancias[i][j] = 0;
            } else {
                Vertice<TIPO> verticeI = vertices.get(i);
                Vertice<TIPO> verticeJ = vertices.get(j);
                Aresta<TIPO> aresta = getAresta(verticeI, verticeJ);
                if (aresta != null) {
                    distancias[i][j] = aresta.getPeso();
                } else {
                    distancias[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }

    // Algoritmo de Floyd-Warshall
    for (int k = 0; k < numVertices; k++) {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (distancias[i][k] != Double.POSITIVE_INFINITY &&
                    distancias[k][j] != Double.POSITIVE_INFINITY &&
                    distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                    distancias[i][j] = distancias[i][k] + distancias[k][j];
                }
            }
        }
    }

    // Exibe as distâncias mínimas entre todos os pares de vértices
    for (int i = 0; i < numVertices; ++i) {
        for (int j = 0; j < numVertices; ++j) {
            System.out.print("Floyd-Warshall | Caminho mínimo de " + vertices.get(i).getDado() + " para " + vertices.get(j).getDado() + ": ");
            if (distancias[i][j] == Double.POSITIVE_INFINITY) {
                System.out.println("Não há caminho.");
            } else {
                System.out.println(distancias[i][j]);
            }
        }
    }
}

public Aresta<TIPO> getAresta(Vertice<TIPO> inicio, Vertice<TIPO> fim) {
    for (Aresta<TIPO> aresta : arestas) {
        if (aresta.getInicio().equals(inicio) && aresta.getFim().equals(fim)) {
            return aresta;
        }
    }
    return null; // Retorna null se a aresta não for encontrada
}


// --------------------------- AStar ----------------------------------------------------
public void aStar(TIPO origem) {
   
      
    Vertice<TIPO> verticeOrigem = getVertice(origem);

    if (verticeOrigem == null) {
        System.out.println("Vértice de origem não encontrado.");
        return;
    }

    // Mapa de custos acumulados
    Map<Vertice<TIPO>, Double> custosAcumulados = new HashMap<>();
    for (Vertice<TIPO> vertice : vertices) {
        custosAcumulados.put(vertice, Double.POSITIVE_INFINITY);
    }
    custosAcumulados.put(verticeOrigem, 0.0);

    // Mapa de heurísticas (distâncias estimadas)
    Map<Vertice<TIPO>, Double> heuristica = new HashMap<>();
    for (Vertice<TIPO> vertice : vertices) {
        heuristica.put(vertice, calcularHeuristica(vertice, verticeOrigem));
    }

    // Fila de prioridade para selecionar o próximo vértice a ser processado
    PriorityQueue<Vertice<TIPO>> filaPrioridade = new PriorityQueue<>((v1, v2) ->
            Double.compare(custosAcumulados.get(v1) + heuristica.get(v1),
                           custosAcumulados.get(v2) + heuristica.get(v2)));

    filaPrioridade.add(verticeOrigem);

    // Mapa de visitados para rastrear os vértices visitados
    Set<Vertice<TIPO>> visitados = new HashSet<>();

    while (!filaPrioridade.isEmpty()) {
        Vertice<TIPO> verticeAtual = filaPrioridade.poll();

        visitados.add(verticeAtual);

        for (Aresta<TIPO> aresta : verticeAtual.getArestasSaida()) {
            Vertice<TIPO> verticeVizinho = aresta.getFim();
            if (!visitados.contains(verticeVizinho)) {
                double novoCustoAcumulado = custosAcumulados.get(verticeAtual) + aresta.getPeso();

                if (novoCustoAcumulado < custosAcumulados.get(verticeVizinho)) {
                    custosAcumulados.put(verticeVizinho, novoCustoAcumulado);
                    filaPrioridade.add(verticeVizinho);
                    // Atualizar o vértice anterior para rastrear o caminho
                    verticeVizinho.setCaminhoAnterior(verticeAtual);
                }
            }
        }
    }

    // Printar os resultados
    for (Vertice<TIPO> vertice : vertices) {
        if (vertice != verticeOrigem) {
            System.out.println("A-Star | Caminho mínimo de " + verticeOrigem.getDado() + " para " + vertice.getDado() +
                    ": " + custosAcumulados.get(vertice));
        }
    }
}

private double calcularHeuristica(Vertice<TIPO> verticeAtual, Vertice<TIPO> verticeDestino) {
    // Substitua este método pela sua heurística específica
    // Por exemplo, você pode usar a distância euclidiana entre as coordenadas dos vértices.
    return 0.0;
}

private void reconstruirCaminho(Vertice<TIPO> origem, Vertice<TIPO> destino) {
    Stack<TIPO> caminho = new Stack<>();
    Vertice<TIPO> vertice = destino;

    while (vertice != null) {
        caminho.push(vertice.getDado());
        vertice = vertice.getCaminhoAnterior();
    }

    System.out.print("Caminho encontrado: ");
    while (!caminho.isEmpty()) {
        System.out.print(caminho.pop());
        if (!caminho.isEmpty()) {
            System.out.print(" -> ");
        }
    }
    System.out.println();
}

    

}

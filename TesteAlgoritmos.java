/**
 * Algoritmos em Grafos
 * Pontifícia Universidade de Minas Gerais
 * Instituto de Ciências Exatas e Informática
 * Engenharia de Computação
 * Última Atualização: 03/12/2024
 * Integrantes: David Lanna de Moraes, João Miguel de Abreu Constâncio, 
 * Gabriel El-Dine e Paulo Ricardo Ferreira Gualberto. 
 */


import java.util.HashMap;
import java.util.Random;

public class TesteAlgoritmos {
    
    public static void testarAlgoritmos(Grafo<String> grafo, int[] tamanhos, int opcao) {
        Random random = new Random();
        HashMap<Integer, HashMap<String, Long>> resultados = new HashMap<>();

        for (int tamanho : tamanhos) {
            System.out.println("Testando com " + tamanho + " vértices:");

            HashMap<String, Long> tempos = new HashMap<>();

            // Criar o grafo aleatório
            for (int i = 0; i < tamanho; i++) {
                grafo.adicionarVertice("V" + i);
            }

            // Adicionar arestas aleatórias
            for (int i = 0; i < tamanho * 3; i++) { // dobro de arestas para ser mais denso
                int verticeOrigem = random.nextInt(tamanho);
                int verticeDestino = random.nextInt(tamanho);
                double peso = Math.floor(random.nextDouble() * 10) ; //  pesos aleatórios de 0 a 10

                grafo.adicionarArestaDir(peso, "V" + verticeOrigem, "V" + verticeDestino);
            }

            // Executar e medir o tempo para cada algoritmo
            long startTime, endTime;
            

            // Dijkstra
            startTime = System.currentTimeMillis();
            if(opcao == 1){
            grafo.dijkstra("V0"); 
            }
            if(opcao == 2){
                for (int i = 0; i < tamanho; i++) {
                 grafo.dijkstra("V" + i); 
                }
            }
            endTime = System.currentTimeMillis();
            tempos.put("Dijkstra", endTime - startTime);
            System.out.println("Quantidade de vertices:"+tamanho);
            System.out.println("Tempo para Dijkstra: " + (endTime - startTime) + "ms");

            // Bellman-Ford
            startTime = System.currentTimeMillis();
            if(opcao == 1){
             grafo.bellmanFord("V0"); 
            }
            if(opcao == 2){
                for (int i = 0; i < tamanho; i++) {
                  grafo.bellmanFord("V" + i); 
                }
            }
            endTime = System.currentTimeMillis();
            tempos.put("Bellman-Ford", endTime - startTime);
            System.out.println("Quantidade de vertices:"+tamanho);
            System.out.println("Tempo para Bellman-Ford: " + (endTime - startTime) + "ms");

            // Floyd-Warshall
            startTime = System.currentTimeMillis();
            grafo.floydWarshall();
            endTime = System.currentTimeMillis();
            tempos.put("Floyd-Warshall", endTime - startTime);
            System.out.println("Quantidade de vertices:"+tamanho);
            System.out.println("Tempo para Floyd-Warshall: " + (endTime - startTime) + "ms");


            // A-Star
            startTime = System.currentTimeMillis();
            if(opcao == 1){
             grafo.aStar("V0"); 
            }
            if(opcao == 2){
                for (int i = 0; i < tamanho; i++) {
                  grafo.aStar("V" + i); 
                }
            }
            endTime = System.currentTimeMillis();
            tempos.put("A-Star", endTime - startTime);
            System.out.println("Quantidade de vertices:"+tamanho);
            System.out.println("Tempo para A-Star: " + (endTime - startTime) + "ms");


            resultados.put(tamanho, tempos);
        }

        
        for (int tamanho : resultados.keySet()) {
            System.out.println("\nNumero de vertices: " + tamanho);
            HashMap<String, Long> tempos = resultados.get(tamanho);
            for (String algoritmo : tempos.keySet()) {
                System.out.println(algoritmo + ": " + tempos.get(algoritmo) + "ms");
            }
        }
    }
}

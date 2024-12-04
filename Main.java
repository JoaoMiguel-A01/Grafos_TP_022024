/**
 * Algoritmos em Grafos
 * Pontifícia Universidade de Minas Gerais
 * Instituto de Ciências Exatas e Informática
 * Engenharia de Computação
 * Última Atualização: 03/12/2024
 * Integrantes: David Lanna de Moraes, João Miguel de Abreu Constâncio, 
 * Gabriel El-Dine e Paulo Ricardo Ferreira Gualberto. 
 */



import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grafo<String> grafo = new Grafo<String>();
        int numvertices = 0;
        int testevertices = 0;
        double peso = 1;
        String nomeV, verticeIni, verticeFim;
        Boolean x = true;

        while (x) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Testar Dijkstra | Bellman-Ford | Floyd-Warshall | A-Star ");
            System.out.println("2. Criar seu próprio grafo");
            System.out.println("3. Sair");
            int opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("Informe a quantidade de vertices para o teste: ");
                int quantidade = sc.nextInt();
                System.out.println("Buscar o menor distância da origem  digite (1) ou menor distância de todos para todos digite (2)");
                int op = sc.nextInt();
                int[] tamanhos = {quantidade}; // Tamanhos de grafos para teste
                TesteAlgoritmos.testarAlgoritmos(grafo, tamanhos, op);
            } else if (opcao == 2) {
                
                System.out.print("Informe a quantidade de vértices no grafo: ");
                numvertices = sc.nextInt();
                System.out.print("O grafo é direcionado? (Digite 1 para sim) ");
                int ndd = sc.nextInt();
                System.out.print("O grafo é ponderado? (Digite 1 para sim) ");
                int pon = sc.nextInt();
                grafo.addnumvertices(numvertices);
                for (int i = 0; i < numvertices; i++) {
                    if (testevertices <= numvertices) {
                        System.out.print("Informe o nome do vertice: ");
                        nomeV = sc.next();
                        grafo.adicionarVertice(nomeV);
                        testevertices++;
                    }
                }
                // MENU 
                boolean y = true;
                while (y) {
                    System.out.println("\n<<<<<<<<<<<< Escolha uma opcao >>>>>>>>>>>>");
                    System.out.println("1. Adicionar Aresta");
                    System.out.println("2. Remover aresta");
                    System.out.println("3. Ver vizinhos de um vertice");
                    System.out.println("4. Ver grau de um vertice");
                    System.out.println("5. Ver grau do grafo");
                    System.out.println("6. Busca em largura");
                    System.out.println("7. Verificar se o grafo e conexo");
                    System.out.println("8. Verificar se o grafo e regular");
                    System.out.println("9. Verificar se o grafo e completo");
                    System.out.println("10. Busca em profundidade");
                    System.out.println("11. Encontrar melhor caminho");
                    System.out.println("12. Exportar grafo para GEXF");
                    System.out.println("13. Algoritmo Dijkstra");
                    System.out.println("14. Algoritmo Bellman-Ford");
                    System.out.println("15. Algoritmo Floyd-Warshall");
                    System.out.println("16. Algoritmo AStar");
                    System.out.println("17. Matriz de adjacência");
                    System.out.println("18. Sair da criação de grafo");

                    int opcao1 = sc.nextInt();
            
            if (opcao1 == 1 && ndd == 1) {
                System.out.print("Qual sera o vertice de inicio? ");
                verticeIni = sc.next();
                System.out.print("Qual sera o vertice final? ");
                verticeFim = sc.next();
                if (pon == 1) {
                    System.out.print("Qual o peso da aresta? ");
                    peso = sc.nextDouble();
                }
                grafo.adicionarArestaDir(peso, verticeIni, verticeFim);
            }
            if (opcao1 == 1 && ndd != 1) {
                System.out.print("Qual será o vértice de início? ");
                verticeIni = sc.next();
                System.out.print("Qual será o vértice final? ");
                verticeFim = sc.next();
                if (pon == 1) {
                    System.out.print("Qual o peso da aresta? ");
                    peso = sc.nextDouble();
                }
                grafo.adicionarArestaNaoDir(peso, verticeIni, verticeFim);
            }
            if (opcao1 == 2 && ndd == 1) {
                System.out.print("Qual será o vértice de início? ");
                verticeIni = sc.next();
                System.out.print("Qual será o vértice final? ");
                verticeFim = sc.next();
                grafo.removeraresta(verticeIni, verticeFim);
            }
            if (opcao1 == 2 && ndd != 1) {
                System.out.print("Qual será o vértice de início? ");
                verticeIni = sc.next();
                System.out.print("Qual será o vértice final? ");
                verticeFim = sc.next();
                grafo.removerArestaNaoDir(verticeIni, verticeFim);
            }
            if (opcao1 == 3 && ndd == 1) {
                System.out.print("Informe o vértice: ");
                nomeV = sc.next();
                grafo.getVizinhos(nomeV);
            }
            if (opcao1 == 3 && ndd != 1) {
                System.out.print("Informe o vértice: ");
                nomeV = sc.next();
                grafo.getVizinhosNaoDir(nomeV);
            }
            if (opcao1 == 4 && ndd == 1) {
                System.out.print("Informe o vértice que deseja saber o grau: ");
                nomeV = sc.next();
                grafo.getGrauverticeDir(nomeV);
            }
            if (opcao1 == 4 && ndd != 1) {
                System.out.print("Informe o vértice que deseja saber o grau: ");
                nomeV = sc.next();
                grafo.getGrauVerticeNaoDir(nomeV);
            }
            if (opcao1 == 5 && ndd == 1) {
                grafo.getGrauGrafoDir();
            }
            if (opcao1 == 5 && ndd != 1) {
                grafo.getGrauGrafoNaoDir();
            }
            if (opcao1 == 6) {
                grafo.buscaEmLargura();
            }
            if (opcao1 == 7 && ndd == 1) {
                grafo.conexo();
            }
            if (opcao1 == 7 && ndd != 1) {
                grafo.conexo();
            }
            if (opcao1 == 8 && ndd == 1) {
                grafo.regularDir();
            }
            if (opcao1 == 8 && ndd != 1) {
                grafo.regularNaoDir();
            }
            if (opcao1 == 9 && ndd == 1) {
                grafo.CompletoDir();
            }
            if (opcao1 == 9 && ndd != 1) {
                grafo.CompletoNaoDir();
            }
            if (opcao1 == 10 && ndd == 1) {
                grafo.buscaEmProfundidade();
            }
            if(opcao1 == 11 ) {
            	 System.out.print("Qual sera o vertice de Origem? ");
                 verticeIni = sc.next();
                 System.out.print("Qual sera o vertice de Destino? ");
                 verticeFim = sc.next();
            	 grafo.encontrarMelhorCaminho(verticeIni, verticeFim);

            }
            if(opcao1 == 12 ) {
           	 grafo.exportarParaGEXF();
            }
            if(opcao1 == 13){
                System.out.print("------Dijkstra------");
                System.out.print("Informe o vertice de origem:");
                nomeV = sc.next();
                grafo.dijkstra(nomeV);
            }
           
             if(opcao1 == 14){
                 System.out.print("------Bellman-Ford------");
                 System.out.print("Informe o vertice de origem:");
                 nomeV = sc.next();
                grafo.bellmanFord(nomeV);
            }
             if(opcao1 == 15){
                System.out.print("------floyd-Warshall------");
                grafo.floydWarshall();
            }
            if(opcao1 == 16){
                System.out.print("------A-Star------");
                System.out.print("Informe o vertice de origem:");
                nomeV = sc.next();
                grafo.aStar(nomeV);
            }
            if(opcao1 == 17){
                System.out.println("------ Matriz de Adjacência -------");
                grafo.imprimirMatrizAdjacencia();
            }
            if(opcao1 == 18){
                System.out.print("------ Programa Encerrado -------");
                y = false;
            
            }
        }

               
            } else if (opcao == 3) {
                x = false; // Encerra o loop e sai do programa
            } else {
                System.out.println("Opção inválida. Escolha novamente.");
            }
        }
        System.out.println("Programa encerrado.");
    }
}

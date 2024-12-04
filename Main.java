
/**
 * Algoritmos em Grafos
 * Pontifícia Universidade de Minas Gerais
 * Instituto de Ciências Exatas e Informática
 * Engenharia de Computação
 * Última Atualização: 03/12/2024
 * Integrantes: David Lanna de Moraes, João Miguel de Abreu Constâncio e Paulo Ricardo Ferreira Gualberto. 
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
            System.out.println("1. Testar Dijkstra | Bellman-Ford | Floyd-Warshall | A-Star");
            System.out.println("2. Criar seu próprio grafo");
            System.out.println("3. Sair");
            int opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("Informe a quantidade de vertices para o teste: ");
                int quantidade = sc.nextInt();
                System.out.println(
                        "Buscar o menor distância da origem digite (1) ou menor distância de todos para todos digite (2)");
                int op = sc.nextInt();
                int[] tamanhos = { quantidade }; // Tamanhos de grafos para teste
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
                boolean y = true;
                while (y) {
                    System.out.println("\n<<<<<<<<<<<< Escolha uma opcao >>>>>>>>>>>>");
                    System.out.println("1. Adicionar Aresta");
                    System.out.println("2. Remover aresta");
                    System.out.println("3. Ver vizinhos de um vertice");
                    System.out.println("4. Ver grau de um vertice");
                    System.out.println("5. Ver grau do grafo");
                    System.out.println("6. Busca em largura");
                    System.out.println("7. Verificar se o grafo é conexo");
                    System.out.println("8. Verificar se o grafo é regular");
                    System.out.println("9. Verificar se o grafo é completo");
                    System.out.println("10. Busca em profundidade");
                    System.out.println("11. Encontrar melhor caminho");
                    System.out.println("12. Exportar grafo para GEXF");
                    System.out.println("13. Algoritmo Dijkstra");
                    System.out.println("14. Algoritmo Bellman-Ford");
                    System.out.println("15. Algoritmo Floyd-Warshall");
                    System.out.println("16. Algoritmo AStar");
                    System.out.println("17. Matriz de adjacência");
                    System.out.println("18. Lista de adjacência");
                    System.out.println("19. Verificar se o grafo é acíclico");
                    System.out.println("20. Verificar se o grafo é Euleriano");
                    System.out.println("21. Sair da criação de grafo");

                    int opcao1 = sc.nextInt();

                    switch (opcao1) {
                        case 1:
                            System.out.print("Qual será o vértice de início? ");
                            verticeIni = sc.next();
                            System.out.print("Qual será o vértice final? ");
                            verticeFim = sc.next();
                            if (pon == 1) {
                                System.out.print("Qual o peso da aresta? ");
                                peso = sc.nextDouble();
                            }
                            if (ndd == 1) {
                                grafo.adicionarArestaDir(peso, verticeIni, verticeFim);
                            } else {
                                grafo.adicionarArestaNaoDir(peso, verticeIni, verticeFim);
                            }
                            break;
                        case 2:
                            System.out.print("Qual será o vértice de início? ");
                            verticeIni = sc.next();
                            System.out.print("Qual será o vértice final? ");
                            verticeFim = sc.next();
                            if (ndd == 1) {
                                grafo.removeraresta(verticeIni, verticeFim);
                            } else {
                                grafo.removerArestaNaoDir(verticeIni, verticeFim);
                            }
                            break;
                        case 3:
                            System.out.print("Informe o vértice: ");
                            nomeV = sc.next();
                            if (ndd == 1) {
                                grafo.getVizinhos(nomeV);
                            } else {
                                grafo.getVizinhosNaoDir(nomeV);
                            }
                            break;
                        case 4:
                            System.out.print("Informe o vértice que deseja saber o grau: ");
                            nomeV = sc.next();
                            if (ndd == 1) {
                                grafo.getGrauverticeDir(nomeV);
                            } else {
                                grafo.getGrauVerticeNaoDir(nomeV);
                            }
                            break;
                        case 5:
                            if (ndd == 1) {
                                grafo.getGrauGrafoDir();
                            } else {
                                grafo.getGrauGrafoNaoDir();
                            }
                            break;
                        case 6:
                            grafo.buscaEmLargura();
                            break;
                        case 7:
                            grafo.conexo();
                            break;
                        case 8:
                            if (ndd == 1) {
                                grafo.regularDir();
                            } else {
                                grafo.regularNaoDir();
                            }
                            break;
                        case 9:
                            if (ndd == 1) {
                                grafo.CompletoDir();
                            } else {
                                grafo.CompletoNaoDir();
                            }
                            break;
                        case 10:
                            grafo.buscaEmProfundidade();
                            break;
                        case 11:
                            System.out.print("Qual será o vértice de Origem? ");
                            verticeIni = sc.next();
                            System.out.print("Qual será o vértice de Destino? ");
                            verticeFim = sc.next();
                            grafo.encontrarMelhorCaminho(verticeIni, verticeFim);
                            break;
                        case 12:
                            grafo.exportarParaGEXF();
                            break;
                        case 13:
                            System.out.print("------Dijkstra------");
                            System.out.print("Informe o vértice de origem: ");
                            nomeV = sc.next();
                            grafo.dijkstra(nomeV);
                            break;
                        case 14:
                            System.out.print("------Bellman-Ford------");
                            System.out.print("Informe o vértice de origem: ");
                            nomeV = sc.next();
                            grafo.bellmanFord(nomeV);
                            break;
                        case 15:
                            System.out.print("------Floyd-Warshall------");
                            grafo.floydWarshall();
                            break;
                        case 16:
                            System.out.print("------A-Star------");
                            System.out.print("Informe o vértice de origem: ");
                            nomeV = sc.next();
                            grafo.aStar(nomeV);
                            break;
                        case 17:
                            System.out.println("------ Matriz de Adjacência ------");
                            grafo.imprimirMatrizAdjacencia();
                            break;
                        case 18:
                            grafo.imprimirListaAdjacencia();
                            break;
                        case 19:
                            if (grafo.isAciclico()) {
                                System.out.println("O grafo é acíclico.");
                            } else {
                                System.out.println("O grafo não é acíclico.");
                            }
                            break;
                        case 20:
                            if (grafo.isEuleriano()) {
                                System.out.println("O grafo é Euleriano.");
                            } else {
                                System.out.println("O grafo não é Euleriano.");
                            }
                            break;
                        case 21:
                            System.out.println("------ Programa Encerrado -------");
                            y = false;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
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

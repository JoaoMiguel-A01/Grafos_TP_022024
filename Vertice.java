/**
 * Algoritmos em Grafos
 * Pontifícia Universidade de Minas Gerais
 * Instituto de Ciências Exatas e Informática
 * Engenharia de Computação
 * Última Atualização: 03/12/2024
 * Integrantes: David Lanna de Moraes, João Miguel de Abreu Constâncio e Paulo Ricardo Ferreira Gualberto. 
 */
import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO dado;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;
    private Vertice<TIPO> caminhoAnterior; // Campo para armazenar o vértice anterior no caminho

    public Vertice(TIPO valor) {
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
        this.caminhoAnterior = null; // Inicialmente, não há vértice anterior
    }

    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }

    public void adicionarArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }

    public void removerArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.remove(aresta);
    }

    public void removerArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.remove(aresta);
    }

    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    public Vertice<TIPO> getCaminhoAnterior() {
        return caminhoAnterior;
    }

    public void setCaminhoAnterior(Vertice<TIPO> caminhoAnterior) {
        this.caminhoAnterior = caminhoAnterior;
    }
}

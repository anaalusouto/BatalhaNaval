package battleship;
/**
 * Classe que implementa as caracter�sticas do jogador da aplica��o.
 * <p> Implementa a interface Seriarizable que permite que o objeto jogador seja persistido em arquivo.
 * Implementa a interface Comparable que permite que uma lista com objetos do tipo jogador seja ordenada
 * pelos valores de suas vari�veis.
 * @param nome Nome do jogador ativo na aplica��o.
 * @param pontuacao Pontua��o do jogador no jogo.
 * @author Rodrigo Lima
 */

import java.io.Serializable;

public class Jogador implements Serializable, Comparable<Jogador> {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int pontuacao;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Nome: " + this.nome + " Pontuacao: " + this.pontuacao);
		return str.toString();
	}
	@Override
	public int compareTo(Jogador jog) {
		int compararPontos = ((Jogador) jog).getPontuacao();		
		return compararPontos - this.pontuacao;
	}
}

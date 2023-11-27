package battleship;
/**
 * Classe que adiciona os objetos {@link #Jogador() Jogador} na lista de jogadores,
 * persiste a lista em arquivo e busca no arquivo a lista de jogadores.
 * <p> Implementa o Padr�o Singleton, para que um jogador seja instanciado apenas uma vez e possa
 * realizar v�rios jogos em sequ�ncia. 
 * @author Rodrigo Lima
 * @see Jogador
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Pontuacao {
	
	private static Pontuacao instancia;	
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	public Pontuacao(){
	}

	public static synchronized Pontuacao getInstance(){
		if (instancia == null) {
			instancia = new Pontuacao();
		}
		return instancia;
	}	
	public void adicionaJogador(Jogador jogador){
		jogadores.add(jogador);
	}
	
	
	public void salvaLista(){
		
		// Cria Array tempor�rio para guardar jogadores j� salvos
		ArrayList<Jogador> arquivo = getJogadores();
		
		// Se o arquivo n�o estiver vazio, concatena os novos jogadores com os que existiam
		if (arquivo != null && !arquivo.isEmpty()){
			try {
				FileOutputStream file = new FileOutputStream("ranking.sav");
				ObjectOutputStream stream = new ObjectOutputStream(file);
				// Concatena as listas de jogadores
				jogadores.addAll(arquivo);
				stream.writeObject(jogadores);
				stream.close();
				file.close();
			} catch (Exception e){
				System.out.println("Erro ao acessar o arquivo.");
			}
		}
		
		// Se o arquivo estiver vazio, cria um novo e preenche com a lista de jogadores
		try {
			FileOutputStream file = new FileOutputStream("ranking.sav");
			ObjectOutputStream stream = new ObjectOutputStream(file);
			stream.writeObject(jogadores);
			stream.close();
			file.close();
		} catch (Exception e){
			System.out.println("Erro ao acessar o arquivo.");
		}
	}

	/**
	 * M�todo que busca a lista de jogadores no arquivo.
	 * <p> Este m�todo � utilizado pelo m�todo salvaLista para verificar se 
	 * existe lista j� persistida no arquivo, se n�o houver ele retorna uma lista null.
	 * @return Retorna a lista de jogadores buscada no arquivo, se n�o existir retorna null.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Jogador> getJogadores(){
		ArrayList<Jogador> jog = null;
		try {
			FileInputStream file = new FileInputStream("ranking.sav");
			ObjectInputStream in = new ObjectInputStream(file);
			jog = (ArrayList<Jogador>) in.readObject();
			in.close();
			file.close();
		} catch (Exception e){
		}
		return jog;
	}
}


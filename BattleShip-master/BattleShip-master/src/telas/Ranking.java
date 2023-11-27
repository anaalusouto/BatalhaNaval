package telas;
/**
 * Classe que implementa o ranking do jogo em uma interface gr�fica.
 * <p> A classe extende o utilit�rio de interface swing JFrame e implementa a interface ActionListener,
 * que configura as a��es de intera��o com o usu�rio.
 * <p> Utiliza o m�todo getJogadores da classe Pontuacao para recuperar a lista de jogadores persistidos
 * no arquivo ranking, ordena pela pontua��o mais alta e cria uma String com os nomes e a pontua��o de cada
 * jogador. Por fim mostra para o usu�rio a String em forma de lista com o ranking completo.
 * @see Pontuacao
 * @see Jogador
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import battleship.Jogador;
import battleship.ListaInvalidaException;
import battleship.Pontuacao;
import java.awt.Font;
import java.awt.TextArea;

public class Ranking extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Criando painel para receber elementos
	private JPanel contentPane = new JPanel();
	// Cria��o do bot�o voltar
	private JButton voltar = new JButton("Voltar");
	// Cria��o da label T�tulo
	private JLabel labelTitulo = new JLabel("Ranking Pontua\u00E7\u00E3o");
	// JScrollPane texto = new JScrollPane(caixaDeTexto);
	TextArea textArea = new TextArea();
	
	/**
	 * Construtor da classe Ranking que cria os elementos gr�ficos da janela.
	 */
	public Ranking() {
		
		// Configura o nome da Janela
		setTitle("Ranking");
		// Retira a op��o de redimensionar a janela		
		setResizable(false);
		// Configura o fechamento da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Configura o tamanho da janela
		setBounds(100, 100, 507, 409);
		// Centralizando a tela quando iniciada
		setLocationRelativeTo(null);
		// Retira o layout do painel
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// Bot�o voltar
		voltar.setBounds(396, 332, 95, 31);
		voltar.addActionListener(this);
		contentPane.add(voltar);
		
		// Label t�tulo
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 16));
		labelTitulo.setBounds(172, 11, 170, 29);
		contentPane.add(labelTitulo);		
		
		// Configurando o tamnho da �rea de texto e adicionando no painel
		textArea.setBounds(10, 46, 481, 269);
		contentPane.add(textArea);
		
		// Cria��o da lista com o ranking, buscando direto do arquivo
		ArrayList<Jogador> jogadores = new Pontuacao().getJogadores();
		
		try {
			verificaLista(jogadores);
			
			// Ordenando os jogadores por maior pontua��o com o met�do compareTo()
			Collections.sort(jogadores);
			
			// Cria��o de uma StringBuilder para concatenar todos os jogadores em uma String
			StringBuilder ranking = new StringBuilder();
			
			for (Jogador jog : jogadores){
				ranking.append(jog.getNome() + " 		" + jog.getPontuacao() + "\n");		
			}
			
			String rankingFinal = ranking.toString();
			textArea.setText(rankingFinal);	
			
		} catch (ListaInvalidaException e){
			System.out.println(e.getMessage());
		}			
	}
	
	public void verificaLista(ArrayList<Jogador> jogadores) throws ListaInvalidaException{
		if (jogadores == null || jogadores.isEmpty()){
			throw new ListaInvalidaException("O arquivo est� vazio!");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar){
			this.dispose();
		}
	}
}

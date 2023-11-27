package battleship;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JogoTest {
	
	Jogo jogo;
	int[][] vetor = new int[10][10];	
	
	@Before
	public void setUp() throws Exception{
		jogo = new Jogo();
	}
	
	@Test
	public void testCabeNavioFalse(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		assertEquals(false, jogo.cabeNavio(3, 7, 1, 5, vetor));
	}
	
	@Test
	public void testCabeNavioTrue(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		assertEquals(true, jogo.cabeNavio(3, 2, 1, 3, vetor));
		
	}
}

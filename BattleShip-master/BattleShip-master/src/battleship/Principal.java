package battleship;
import javax.swing.SwingUtilities;
import telas.TelaInicial;

public class Principal {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
			}
		});		
	}

}

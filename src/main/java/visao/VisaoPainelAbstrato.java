package visao;

import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

public abstract class VisaoPainelAbstrato extends JPanel {
	
	private static final long serialVersionUID = 1577480744584164033L;

	public abstract void modeloAtualizacaoPropriedade(PropertyChangeEvent evento);
    
}

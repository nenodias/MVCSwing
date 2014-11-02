package visao;

import java.awt.AWTEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControlePessoa;

public class VisaoPessoa extends VisaoPainelAbstrato {
	
	private ControlePessoa controler;

	public VisaoPessoa(final ControlePessoa controler) {
		this.controler = controler;
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 70, 15);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(100, 10, 114, 19);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(12, 39, 70, 15);
		add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(100, 37, 114, 19);
		add(txtCpf);
		txtCpf.setColumns(10);
		
		txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	txtCpfEvento(evt);
            }
        });
		txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
            	txtCpfEvento(evt);
            }
        });
		
		txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	txtNomeEvento(evt);
            }
        });
		txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
            	txtNomeEvento(evt);
            }
        });
	}

	private static final long serialVersionUID = 6254838327940918706L;
	private JTextField txtNome;
	private JTextField txtCpf;

	@Override
	public void modeloAtualizacaoPropriedade(PropertyChangeEvent evento) {
		if(evento.getPropertyName().equals(ControlePessoa.PROPRIEDADE_NOME)){
			String valorNovo = (String) evento.getNewValue();
			if(!txtNome.getText().equals(valorNovo) ){
				txtNome.setText( valorNovo );
			}
		} else if(evento.getPropertyName().equals(ControlePessoa.PROPRIEDADE_CPF)){
			String valorNovo = (String) evento.getNewValue();
			if(!txtCpf.getText().equals(valorNovo) ){
				txtCpf.setText( valorNovo );
			}
		}
		
		revalidate();
        repaint();
	}
	 
	 private void txtNomeEvento(AWTEvent evt) {
		 try {
			    controler.atualizaPropriedadeNome(txtNome.getText());
		} catch (Exception e) {
			
		}
	 }
	 
	 private void txtCpfEvento(AWTEvent evt) {
		 try {
			 controler.atualizaPropriedadeCPF(txtCpf.getText());
		 } catch (Exception e) {
			 
		 }
	 }
	
}

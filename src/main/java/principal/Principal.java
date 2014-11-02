/*
 * Main.java
 *
 * Created on January 10, 2007, 1:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import modelo.PessoaModelo;
import visao.VisaoPessoa;
import controle.ControlePessoa;

public class Principal {
    
    private JFrame frame;

	public Principal() {
        
		ControlePessoa controle = new ControlePessoa();
        PessoaModelo modelo = new PessoaModelo();
        VisaoPessoa visao = new VisaoPessoa(controle);       
        
        controle.adicionarVisao(visao);
        controle.adicionarModelo(modelo);
        
        modelo.setNome("Juca");
        modelo.setCpf("111.444.777-35");
        
        frame = new JFrame("Principal");
        frame.setBounds(0, 0, 400, 100);
        frame.setContentPane(visao);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				frame.setVisible(true);
			}
		});
        
    }
    
    public static void main(String[] args) {
        new Principal();
    }
    
}

package controle;

public class ControlePessoa extends ControleAbstrato {

	public static final String PROPRIEDADE_NOME = "nome";
	public static final String PROPRIEDADE_CPF = "cpf";
	
	 public void atualizaPropriedadeNome(String nome) {
		 setPropriedadeModelo(PROPRIEDADE_NOME, nome);
	 }
	 
	 public void atualizaPropriedadeCPF(String cpf) {
		 setPropriedadeModelo(PROPRIEDADE_CPF, cpf);
	 }
	
}

package modelo;

import controle.ControlePessoa;

public class PessoaModelo extends ModeloAbstrato {

	private String nome;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		dispararTrocaPropriedade(ControlePessoa.PROPRIEDADE_NOME, this.nome, nome);
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		dispararTrocaPropriedade(ControlePessoa.PROPRIEDADE_CPF, this.cpf, cpf);
		this.cpf = cpf;
	}
	
}

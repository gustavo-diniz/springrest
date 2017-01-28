package br.com.gustavodiniz.rest.to;

public class RestTO {
	
	private String servico;
	private String tipo;
	private String endereco;

	public RestTO() {
	}

	public RestTO(String servico, String tipo, String endereco) {
		this.servico = servico;
		this.tipo = tipo;
		this.endereco = endereco;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}

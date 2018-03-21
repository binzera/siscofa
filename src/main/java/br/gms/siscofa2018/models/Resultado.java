package br.gms.siscofa2018.models;

public class Resultado {
	
	private Object dados;
	private String mensagem;
	private boolean sucesso;
	
	public Resultado(Object dados, String mensagem, boolean sucesso) {
		setDados(dados);
		setMensagem(mensagem);
		setSucesso(sucesso);
	}
	
	public Resultado(Object dados, String mensagem) {
		setDados(dados);
		setMensagem(mensagem);
	}
	
	public Resultado(Object dados) {
		setDados(dados);
	}
	
	public Object getDados() {
		return dados;
	}
	public void setDados(Object dados) {
		this.dados = dados;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public boolean isSucesso() {
		return sucesso;
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades.producao;

/**
 *
 * @author Danilo Bispo
 */
public class AnexoDTO {
    private String nome;
	private String mimeType;
	private byte[] conteudo;
		
	public AnexoDTO() {
		// TODO Auto-generated constructor stub
	}

	public AnexoDTO(String nome, String mimeType, byte[] conteudo) {
		super();
		this.nome = nome;
		this.mimeType = mimeType;
		this.conteudo = conteudo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}
}

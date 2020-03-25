/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

import graficaatual.utilitarios.ControleAcesso;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ProjetoX
 */
@Entity
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codFornecedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codFornecedor;

    @ManyToOne()
    @JoinColumn(name = "pessoa", nullable = false)
    private Pessoa pessoa;

    @ManyToOne()
    @JoinColumn(name = "endereco", nullable = false)
    private Endereco endereco;

    @Column(name = "dataCadastro", nullable = true)
    private Date dataCadastro;

    @Column(name = "dataAtualizacao", nullable = true)
    private Date dataAtualizacao;

    @Column(name = "usuarioCadastro", length = 200)
    private String usuarioCadastro;

    @Column(name = "usuarioAtualizacao", length = 200)
    private String usuarioAtualizacao;
    
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    public Fornecedor() {
 //       this.dataCadastro = new Date();
//        this.usuarioCadastro = ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getPessoa().getNome();
    }

    public Long getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Long codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getUsuarioAtualizacao() {
        return usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(String usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFornecedor != null ? codFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codFornecedor == null && other.codFornecedor != null) || (this.codFornecedor != null && !this.codFornecedor.equals(other.codFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "graficaatual.entidades.[ id=" + codFornecedor + " ]";
    }

}

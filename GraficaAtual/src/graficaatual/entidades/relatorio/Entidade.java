/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graficaatual.entidades.relatorio;



import graficaatual.entidades.Bairro;
import graficaatual.entidades.Cidade;
import graficaatual.entidades.Logradouro;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table; 

/**
 *
 * @author SI10
 * 
 */
@Entity 
@Table(name="Entidade")
public class Entidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="codEntidade")
    private Integer codEntidade;
    
    @Column(name="nome",length=250,nullable=false)
    private String nome="";
    
    @Column(name="cnpj",length=40,nullable=false)
    private String cnpj="";
    
    @Column(name="telefone",length=100)
    private String telefone="";
    
    @Column(name="email",length=250)
    private String email="";
    
    @Column(name="inscEstadual",length=250)
    private String inscEstadual="";
    
    @Column(name="inscMunicipal",length=250)
    private String inscMunicipal="";
   
    @OneToOne()
    @JoinColumn(name="logradouro")
    private Logradouro logradouro;  
    
    @OneToOne()
    @JoinColumn(name="bairro")
    private Bairro bairro;
    
    @OneToOne()
    @JoinColumn(name="cidade")
    private Cidade cidade;
    
    @Column(name="numero")
    private Integer numero;
    
    @Column(name="complemento",length=40)
    private String complemento="";
    
    @Column(name="uf",length=2)
    private String uf="";
    
     @Column(name="cep",length=20)
    private String cep="";
    
    @Column(name="brasao")
    private byte[] brasao;

    public Integer getCodigo() {
        return codEntidade;
    }

    public void setCodigo(Integer codEntidade) {
        this.codEntidade = codEntidade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodEntidade() {
        return codEntidade;
    }

    public void setCodEntidade(Integer codEntidade) {
        this.codEntidade = codEntidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    public String getInscMunicipal() {
        return inscMunicipal;
    }

    public void setInscMunicipal(String inscMunicipal) {
        this.inscMunicipal = inscMunicipal;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public byte[] getBrasao() {
        return brasao;
    }

    public void setBrasao(byte[] brasao) {
        this.brasao = brasao;
    }

    public Entidade() {
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entidade other = (Entidade) obj;
        if (!Objects.equals(this.codEntidade, other.codEntidade)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.codEntidade);
        return hash;
    }
    
    
   
    
}

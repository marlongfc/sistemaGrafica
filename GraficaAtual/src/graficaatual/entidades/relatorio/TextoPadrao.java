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
@Table(name="TextoPadrao")
public class TextoPadrao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="codTextoPadrao")
    private Integer codTextoPadrao;
       
    @Column(name = "textoOrcamento", columnDefinition = "text")
    private String textoOrcamento = "";

    @Column(name = "textoEmail", columnDefinition = "text")
    private String textoEmail = "";

    @Column(name = "emailEnvio")
    private String emailEnvio = "";
    
    @Column(name = "emailSenha")
    private String emailSenha = "";

    public Integer getCodTextoPadrao() {
        return codTextoPadrao;
    }

    public String getEmailSenha() {
        return emailSenha;
    }

    public void setEmailSenha(String emailSenha) {
        this.emailSenha = emailSenha;
    }
    
    

    public String getTextoEmail() {
        return textoEmail;
    }

    public void setTextoEmail(String textoEmail) {
        this.textoEmail = textoEmail;
    }

    public String getEmailEnvio() {
        return emailEnvio;
    }

    public void setEmailEnvio(String emailEnvio) {
        this.emailEnvio = emailEnvio;
    }
    
    

    public void setCodTextoPadrao(Integer codTextoPadrao) {
        this.codTextoPadrao = codTextoPadrao;
    }

    public String getTextoOrcamento() {
        return textoOrcamento;
    }

    public void setTextoOrcamento(String textoOrcamento) {
        this.textoOrcamento = textoOrcamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.codTextoPadrao);
        return hash;
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
        final TextoPadrao other = (TextoPadrao) obj;
        if (!Objects.equals(this.codTextoPadrao, other.codTextoPadrao)) {
            return false;
        }
        return true;
    }
    
   
    
    
   
    
}

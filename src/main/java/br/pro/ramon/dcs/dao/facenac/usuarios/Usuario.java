package br.pro.ramon.dcs.dao.facenac.usuarios;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"id", "nome", "email", "senha", "foto"})
public class Usuario implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private byte[] foto;

    protected Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
    }

    @XmlAttribute
    public Long getId() {
        return id;
    }

    @XmlElement
    public String getNome() {
        return nome;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    @XmlElement
    public String getSenha() {
        return senha;
    }

    @XmlElement
    public byte[] getFoto() {
        return foto;
    }

}

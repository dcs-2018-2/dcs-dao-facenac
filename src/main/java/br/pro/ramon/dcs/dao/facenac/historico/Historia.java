package br.pro.ramon.dcs.dao.facenac.historico;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"id", "usuario", "texto", "foto", "data"})
public class Historia implements Serializable {

    private Long id;
    private Long usuario;
    private String texto;
    private byte[] foto;
    private Date data;

    protected Historia() {
    }

    public Historia(Long id, Long usuario, String texto, byte[] foto, Date data) {
        this.id = id;
        this.usuario = usuario;
        this.texto = texto;
        this.foto = foto;
        this.data = data;
    }

    @XmlAttribute
    public Long getId() {
        return id;
    }

    @XmlElement
    public Long getUsuario() {
        return usuario;
    }

    @XmlElement
    public String getTexto() {
        return texto;
    }

    @XmlElement
    public byte[] getFoto() {
        return foto;
    }

    @XmlElement
    public Date getData() {
        return data;
    }

}

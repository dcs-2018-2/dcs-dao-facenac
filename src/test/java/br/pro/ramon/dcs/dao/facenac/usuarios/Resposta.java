package br.pro.ramon.dcs.dao.facenac.usuarios;

class Resposta {

    public String saida;
    public int statusCode;
    public String location;

    public Resposta(String saida, int statusCode) {
        this.saida = saida;
        this.statusCode = statusCode;
    }

    public Resposta(String saida, int statusCode, String location) {
        this.saida = saida;
        this.statusCode = statusCode;
        this.location = location;
    }

}

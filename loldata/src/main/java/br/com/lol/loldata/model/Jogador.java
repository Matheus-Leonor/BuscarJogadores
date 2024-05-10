package br.com.lol.loldata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.OptionalDouble;
import java.util.OptionalInt;

@Entity
@Table(name = "jogadores")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String contaId;
    private String nome;
    private String puuid;
    private Integer perfilIconId;
    private Long dataDeRevisao;
    private Long nivelDeInvocador;

    public Jogador () {}
    public Jogador (DadosJogador dadosJogador) {
        this.contaId = dadosJogador.contaId();
        this.nome = dadosJogador.nome() ;
        this.puuid = dadosJogador.puuid();
        this.perfilIconId = OptionalInt.of(Integer.valueOf(dadosJogador.perfilIconId())).orElse(0);;
        this.dataDeRevisao = dadosJogador.dataDeRevisao();
        this.nivelDeInvocador = dadosJogador.nivelDeInvocador();

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContaId() {
        return contaId;
    }

    public void setContaId(String contaId) {
        this.contaId = contaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public Integer getPerfilIconId() {
        return perfilIconId;
    }

    public void setPerfilIconId(Integer perfilIconId) {
        this.perfilIconId = perfilIconId;
    }

    public Long getDataDeRevisao() {
        return dataDeRevisao;
    }

    public void setDataDeRevisao(Long dataDeRevisao) {
        this.dataDeRevisao = dataDeRevisao;
    }

    public Long getNivelDeInvocador() {
        return nivelDeInvocador;
    }

    public void setNivelDeInvocador(Long nivelDeInvocador) {
        this.nivelDeInvocador = nivelDeInvocador;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", contaId='" + contaId + '\'' +
                ", nome='" + nome + '\'' +
                ", puuid='" + puuid + '\'' +
                ", perfilIconId=" + perfilIconId +
                ", dataDeRevisao=" + dataDeRevisao +
                ", nivelDeInvocador=" + nivelDeInvocador +
                '}';
    }
}

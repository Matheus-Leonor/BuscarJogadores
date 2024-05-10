package br.com.lol.loldata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosJogador(@JsonAlias("id") String id,
                           @JsonAlias("accountId") String contaId,
                           @JsonAlias("puuid") String puuid,
                           @JsonAlias("name") String nome,
                           @JsonAlias("profileIconId") Integer perfilIconId,
                           @JsonAlias("revisionDate") Long dataDeRevisao,
                           @JsonAlias("summonerLevel") Long nivelDeInvocador) {
}

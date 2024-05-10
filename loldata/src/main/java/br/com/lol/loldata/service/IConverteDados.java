package br.com.lol.loldata.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}

package br.com.lol.loldata.principal;

import br.com.lol.loldata.model.DadosJogador;
import br.com.lol.loldata.model.Jogador;
import br.com.lol.loldata.repository.JogadorRepository;
import br.com.lol.loldata.service.ConsumoApi;
import br.com.lol.loldata.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados  conversor = new ConverteDados();
    private final String ENDERECO  = "https://br1.api.riotgames.com/lol/summoner/v4/summoners/";
    private final String API_KEY = "?api_key=RGAPI-7bd281d3-ee5f-4993-bf63-e04a8a19ccb0";
    private List<DadosJogador> dadosJogador = new ArrayList<>();
    private List <Jogador> jogadoresEncontrados  = new ArrayList<>();

    // o repositorio precisa ser criado na classe aplicattion gerenciada pelo spring  com a notação @Autowired
    private JogadorRepository repositorio;

    public Principal(JogadorRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao =-1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar Jogadores
                    2 - Listar Jogadores buscados
                    0 - Sair
                    """;
            System.out.println(menu);
            opcao  = leitura.nextInt();
            leitura.nextLine();

            switch (opcao)  {
                case 1:
                    BuscarJogadorWeb();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }


    private void BuscarJogadorWeb() {
        DadosJogador dados = getDadosJogador();
        Jogador jogador = new Jogador(dados);
        repositorio.save(jogador);
        System.out.print(dados);
    }

    public DadosJogador getDadosJogador() {
        System.out.println("Digite seu nome de invocador : ");
        var  nomeInvocador = leitura.nextLine();
        var json =  consumo.obterDados(ENDERECO + "by-name/" + nomeInvocador.replace(" ", "+") + API_KEY);
        DadosJogador dados = conversor.obterDados(json, DadosJogador.class);
        return dados;
    }




}

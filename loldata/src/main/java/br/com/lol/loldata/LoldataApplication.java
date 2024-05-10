package br.com.lol.loldata;

import br.com.lol.loldata.principal.Principal;
import br.com.lol.loldata.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoldataApplication implements CommandLineRunner {

	// o repositorio precisa ser criado na classe aplicattion gerenciada pelo spring  com a notação @Autowired

	@Autowired
	private JogadorRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(LoldataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}

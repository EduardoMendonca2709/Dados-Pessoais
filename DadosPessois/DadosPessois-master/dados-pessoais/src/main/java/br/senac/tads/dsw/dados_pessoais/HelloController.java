package br.senac.tads.dsw.dados_pessoais;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mensagem hello() {
		return new Mensagem("Eduardo dos Santos Mendonça Silva", "Olá mundo");
	}

	@GetMapping(value = "/hello-manual", produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloManual() throws JsonProcessingException {
		Mensagem mensagem = new Mensagem("Eduardo dos Santos", "Json gerado manualmente com Object");
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(mensagem);
	}
}

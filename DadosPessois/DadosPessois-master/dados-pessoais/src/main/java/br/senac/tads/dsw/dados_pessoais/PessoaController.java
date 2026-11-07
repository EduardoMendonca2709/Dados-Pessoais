package br.senac.tads.dsw.dados_pessoais;

import java.net.URI;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	private final PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService){
		this.pessoaService = pessoaService;
	}

	@GetMapping
	public List<PessoaDto> obterPessoas() {
		return pessoaService.obterPessoas();
	}

	@GetMapping("/busca")
	public ResponseEntity<List<PessoaDto>> buscarPessoas(@RequestParam("q") String termo) {
		return ResponseEntity.ok(pessoaService.buscarPessoas(termo));
	}

	@GetMapping("/{username}")
	public PessoaDto obterPessoa(@PathVariable("username") String Username){
		Optional<PessoaDto> p = pessoaService.obterPessoa(Username);
		if(p.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return p.get();
	}

	@PostMapping("/sem-validacao")
	public ResponseEntity<PessoaDto> incluirNovo(@RequestBody @Valid PessoaDto pessoa){
		pessoaService.incluirNovaPessoa(pessoa);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().
			path("/pessoas/{Username}").buildAndExpand(pessoa.getUsarname()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{username}")
	public ResponseEntity<?> atualizar(@PathVariable("username") String username,
									   @RequestBody @Valid PessoaAlteracaoDto pessoa){
		PessoaDto pessoaAlterada = pessoaService.alterarPessoa(username, pessoa);
		return ResponseEntity.ok().body(pessoaAlterada);
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<?> remover(@PathVariable("username") String username){
		pessoaService.removerPessoa(username);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<ProblemDetail> tratarExcecao(NaoEncontradoException ex){
		ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), ex.getMessage());
		return ResponseEntity.of(pd).build();
	}
}

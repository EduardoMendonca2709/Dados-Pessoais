package br.senac.tads.dsw.dados_pessoais;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PessoaServiceMapImpl implements PessoaService {

	private AtomicInteger contador = new AtomicInteger(0);
	private Map<String, PessoaDto> mapPessoas = new ConcurrentHashMap<>();

	@PostConstruct
	public void init() {
		mapPessoas.put("fulano", new PessoaDto(
		));
		mapPessoas.put("ciclano", new PessoaDto(
		));
		mapPessoas.put("Beltrano", new PessoaDto(
		));
	}

	@Override
	public List<PessoaDto> obterPessoas() {
		return new ArrayList<>(mapPessoas.values());
	}

	@Override
	public Optional<PessoaDto> obterPessoa(String usarname) {
		return Optional.ofNullable(mapPessoas.get(usarname));
	}

	@Override
	public PessoaDto incluirNovaPessoa(PessoaDto pessoa) {
		return null;
	}


	public PessoaDto incluirPessoa(PessoaDto pessoa){
		pessoa.setId(contador.incrementAndGet());
		mapPessoas.put(pessoa.getUsarname(), pessoa);
		return pessoa;
	}

	@Override
	public PessoaDto alterarPessoa(String username, PessoaAlteracaoDto pessoaAlteracao){
		if (!mapPessoas.containsKey(username)){
			throw new NaoEncontradoException("Pessoa: " + username + " não encontrado");
		}
		PessoaDto pessoaOriginal = mapPessoas.get(username);
		pessoaOriginal.setNome(pessoaAlteracao.getNome());
		pessoaOriginal.setEmail(pessoaAlteracao.getEmail());
		pessoaOriginal.setDataNascimento(pessoaAlteracao.getDataNascimento());
		pessoaOriginal.setTelefone(pessoaAlteracao.getTelefone());
		pessoaOriginal.setConhecimentos(pessoaAlteracao.getConhecimentos());
		return pessoaOriginal;
	}

	@Override
	public void removerPessoa(String username){
		if (!mapPessoas.containsKey(username)){
			throw new NaoEncontradoException("Pessoa: " + username + " não encontrada");
		}
		mapPessoas.remove(username);
	}

	@Override
	public List<PessoaDto> buscarPessoas(String termo) {
		throw new UnsupportedOperationException("Busca não implementada na versão com Map");
	}



}

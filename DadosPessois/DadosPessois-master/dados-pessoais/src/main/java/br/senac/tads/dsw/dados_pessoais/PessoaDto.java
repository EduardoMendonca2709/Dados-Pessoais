package br.senac.tads.dsw.dados_pessoais;


import Validacao.SenhasIguais;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;


@SenhasIguais
public class PessoaDto {

	@NotBlank(message = "O nome é obrigatorio")
	@Size(max = 64)
	private String nome;

	private Integer id;

	@NotBlank(message = "O usarname é obrigatorio")
	@Size(max = 64)
	private String usarname;

	@Size(max = 64)
	@Email
	@NotBlank(message = "O email é obrigatorio")
	private String email;

	private String senha;

	@Size(max = 20)
	private String telefone;

	private String senhaRepeticao;

	private List<String> conhecimentos;

	@NotNull
	@PastOrPresent
	private LocalDate dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsarname() {
		return usarname;
	}

	public void setUsarname(String usarname) {
		this.usarname = usarname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenhaRepeticao() {
		return senhaRepeticao;
	}

	public void setSenhaRepeticao(String senhaRepeticao) {
		this.senhaRepeticao = senhaRepeticao;
	}

	public List<String> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<String> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public PessoaDto() {
	}

	public PessoaDto(String telefone, String email, String usarname, Integer id, String nome, LocalDate dataNascimento) {
		this.telefone = telefone;
		this.email = email;
		this.usarname = usarname;
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

}

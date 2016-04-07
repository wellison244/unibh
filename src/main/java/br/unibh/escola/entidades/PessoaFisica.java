package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="tb_pessoa_fisica")
@Inheritance(strategy=InheritanceType.JOINED)
public class PessoaFisica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank
	@Pattern(regexp="[A-zÀ-ú ]*",message="Deverá ter apenas Letras e Espaço")
	@Size(min=5,max=100)
	@Column (length=100, nullable=false)
	private String nome;
	
	@NotBlank
	@Pattern(regexp="[0-9]*",message="Deverá ter apenas números")
	@Size(min=11,max=11)
	@Column (length=11, nullable=false,unique=true)
	private String cpf;
	
	@Pattern(regexp="\\(\\d{2}\\)\\d{5}-\\d{4}")
	@Column (name="telefone_comercial",length=14)
	private String telefoneComercial;

	@NotBlank
	@Pattern(regexp="\\(\\d{2}\\)\\d{5}-\\d{4}")
	@Column (name="telefone_residencial",length=14)
	private String telefoneResidencial;
	
	@Pattern(regexp="\\(\\d{2}\\)\\d{5}-\\d{4}")
	@Column (name="telefone_celular",length=14)
	private String telefoneCelular;
	
	@Email
	@Max(100)
	@Column (length=100)
	private String email;
	
	@Range(min=18, max=99, message="A idade mínima é 18 anos")
	@Column (nullable=false)
	private int idade; 
	
	@NotNull
	@Past
	@Column (name="data_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
}
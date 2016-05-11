import java.util.Date;

public class Contato {
	
	private String nome;
	private String endereco;
	private String email;
	private Date DataNascimento;
	
	
	public String getNome() {// lindo pelo metodo get
		return nome;
	}
	public void setNome(String nome) {// alterado pelo metodo set
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
	
	
	

}
import javax.swing.JOptionPane;

public class Conta {
	
	private int numero = 0;
	private String digito;
	private double saldo = 0;
	private String senha;
	private double limite = 0;
	private String token;
	private int tentativas = 0;
	private Cliente titular;
	
	public String getNumero() {
		return "" + numero;
	}
	public void setNumero(int numero) {
		this.numero++;
	}
	
	public String getDigito() {
		return digito;
	}
	public boolean setDigito(String digito) {
		if(digito.length() == 1 && digito.matches("^[0-9]*$")) {
			this.digito = digito;
			return true;
		} else {
			return false;
		}
	}
	public double getSaldo() {
		return saldo;
	}
	public boolean setSaldo(int escolha, double saldo) {
		if(escolha == 2) {
			if(this.saldo+limite > saldo) {
				this.saldo = this.saldo-saldo;
				return true;
			} else {
				return false;
			}
		} else if(escolha == 3) {
			if(saldo > 0) {
				this.saldo = saldo;
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean getSenha(String senha) {
		if(this.senha.matches(senha) && tentativas < 3) {
			JOptionPane.showMessageDialog(null, "\nLogin com sucesso!");
			return true;
		} else {
			if(tentativas == 3) {
				JOptionPane.showMessageDialog(null, "Excedeu o limite de tentativas!");
			}
			tentativas++;
			return false;
		}
	}
	public boolean setSenha(String senha1, String senha2) {
		if(!senha1.equals(this.senha) && senha1.matches("(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
				&& senha1.equals(senha2)) {
			this.senha = senha1;
			return true;
		} else if(senha1.equals(this.senha)) {
			JOptionPane.showMessageDialog(null, "A senha deve ser diferente da senha atual.");
			return false;
		} else if(!senha1.equals(senha2)) {
			JOptionPane.showMessageDialog(null, "As senhas novas não são iguais");
			return false;
		} else if(!senha1.matches("(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {
			JOptionPane.showMessageDialog(null, "A senha não é forte o bastante");
			return false;
		}
		return false;
	}
	public double getLimite() {
		return limite;
	}
	public boolean setLimite(double limite) {
		if(limite > 0) {
			this.limite = limite;
			return true;
		} else {
			return false;
		}
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
}
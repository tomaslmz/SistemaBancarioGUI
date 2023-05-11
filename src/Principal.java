import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

public class Principal {
	
	static Cliente cliente = new Cliente();
	static Conta conta = new Conta();
	static int aberto = 1;
	
	public static void abrirConta() {
		Frame frame = new Frame();
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0);
		formatter.setMaximum(9);
		
		JLabel lbNumero = new JLabel("Insira o número de conta: ");
		JFormattedTextField txtNumero = new JFormattedTextField(formatter);
		txtNumero.setColumns(1);
		
		JLabel lbDigito = new JLabel("Insira o seu dígito: ");
		JFormattedTextField txtDigito = new JFormattedTextField(formatter);
		txtDigito.setColumns(1);
		
		JLabel lbSenha = new JLabel("Insira a sua senha: ");
		JPasswordField txtSenha = new JPasswordField();
		
		JLabel lbRepetirSenha = new JLabel("Repita a sua senha: ");
		JPasswordField txtRepetirSenha = new JPasswordField();
		
		JPanel componentes = new JPanel();
		
		JLabel texto = new JLabel("Insira os seus dados");
		JLabel linha = new JLabel(" ");
		
		componentes.add(texto);
		componentes.add(linha);
		componentes.add(lbNumero);
		componentes.add(txtNumero);
		componentes.add(lbDigito);
		componentes.add(txtDigito);
		componentes.add(lbSenha);
		componentes.add(txtSenha);
		componentes.add(lbRepetirSenha);
		componentes.add(txtRepetirSenha);
		
		componentes.setLayout(new BoxLayout(componentes, BoxLayout.Y_AXIS));
		
		String senha1;
		String senha2;
		Object[] options = {"Voltar", "Abrir conta"};
		int abrirconta;
		do {
			abrirconta = JOptionPane.showOptionDialog(
					frame,
					componentes,
					"Abrir conta",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]
					);
			senha1 = new String(txtSenha.getPassword());
			senha2 = new String(txtRepetirSenha.getPassword());
			if(abrirconta == 1) {
				conta.setNumero(Integer.parseInt(txtNumero.getText()));
				conta.setDigito(txtDigito.getText());
				conta.setSenha(senha1, senha2, 1);
			}
		} while(abrirconta == 1 && (!(txtDigito.getText().length() == 1) || !(txtDigito.getText().matches("^[0-9]*$")) || !(senha1.equals(senha2)) || !(senha1.matches("(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$"))));
	}
	
	public static void registrar() {
		Frame frame = new Frame();
		
		JLabel lbNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField();
		
		JLabel lbCpf = new JLabel("CPF: ");
		JFormattedTextField txtCpf = new JFormattedTextField();
		MaskFormatter maskCpf;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			maskCpf.install(txtCpf);
		} catch (ParseException e) {
			
		}
		
		
		JLabel lbDataNasc = new JLabel("Digite a sua data de nascimento: ");
		JFormattedTextField txtDataNasc = new JFormattedTextField();
		MaskFormatter maskDataNasc;
		try {
			maskDataNasc = new MaskFormatter("##/##/####");
			maskDataNasc.install(txtDataNasc);
		} catch (ParseException e) {
			
		}
		
		JLabel lbEndereco = new JLabel("Digite o seu endereço: ");
		JTextField txtEndereco = new JTextField();
		
		JLabel lbTelefone = new JLabel("Digite o seu telefone: ");
		JFormattedTextField txtTelefone = new JFormattedTextField();
		MaskFormatter maskTelefone;
		try {
			maskTelefone = new MaskFormatter("(##) # ####-####");
			maskTelefone.install(txtTelefone);
		} catch(ParseException e) {
			
		}
		
		JLabel lbCodigo = new JLabel("Digite o seu código: ");
		JTextField txtCodigo = new JTextField();
		
		JLabel lbRendaMensal = new JLabel("Digite a sua renda mensal: ");
		JTextField txtRendaMensal = new JTextField();
		
		JLabel lbEmprego = new JLabel("Digite o seu emprego (deixe em branco caso não tenha):");
		JTextField txtEmprego = new JTextField();
		
		JPanel componentes = new JPanel();
		componentes.add(lbNome);
		componentes.add(txtNome);
		componentes.add(lbCpf);
		componentes.add(txtCpf);
		componentes.add(lbDataNasc);
		componentes.add(txtDataNasc);
		componentes.add(lbEndereco);
		componentes.add(txtEndereco);
		componentes.add(lbTelefone);
		componentes.add(txtTelefone);
		componentes.add(lbCodigo);
		componentes.add(txtCodigo);
		componentes.add(lbRendaMensal);
		componentes.add(txtRendaMensal);
		componentes.add(lbEmprego);
		componentes.add(txtEmprego);
		
		Object[] options= {"Voltar", "Registrar"};
		int registro;
		componentes.setLayout(new BoxLayout(componentes, BoxLayout.Y_AXIS));
		//if(!conta.getNumero().equals("-1")) {
		if(true) {
			do {
				registro = JOptionPane.showOptionDialog(
						frame,
						componentes,
						"Registro",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]
					);
				
				if(registro == 1) {
					cliente.setNome(txtNome.getText());
					cliente.setCpf(txtCpf.getText());
					cliente.setDataNasc(txtDataNasc.getText());
					cliente.setEndereco(txtEndereco.getText());
					cliente.setTelefone(txtTelefone.getText());
					cliente.setCodigo(Integer.parseInt(txtCodigo.getText()));
					cliente.setRendaMensal(Float.parseFloat(txtRendaMensal.getText()));
				}
			} while(registro == 1 && (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || !(txtCpf.getText().length() == 14) || !(txtDataNasc.getText().matches("\\d{2}/\\d{2}/\\d{4}")) || txtEndereco.getText().isEmpty() || txtTelefone.getText().isEmpty() || !(txtTelefone.getText().length() >= 16) || !(Integer.parseInt(txtCodigo.getText()) > 0) || !(Float.parseFloat(txtRendaMensal.getText()) > 0)));
			
			conta.setTitular(cliente);
		} else {
			JOptionPane.showMessageDialog(null, "Você precisa abrir uma conta primeiro!");
		}
	}
	
	public static void depositar() {
		Frame frame = new Frame();
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0);
		
		JLabel lbDeposito = new JLabel("Digite o saldo que deseja depositar: ");
		JFormattedTextField txtSaldo = new JFormattedTextField(formatter);
		
		Object[] options = {"Sair", "Depositar"};
		
		JPanel componentes = new JPanel();
		JLabel texto = new JLabel("Saldo: R$" + conta.getSaldo());
		JLabel texto2 = new JLabel("Limite: R$" + conta.getLimite());
		JLabel linha = new JLabel(" ");
		
		componentes.add(texto);
		componentes.add(texto2);
		componentes.add(linha);
		componentes.add(lbDeposito);
		componentes.add(txtSaldo);
		componentes.setLayout(new BoxLayout(componentes, BoxLayout.Y_AXIS));
		
		int deposito = 3;
		
		while(deposito != 0) {
			do {
				if (deposito != 3) {
				    texto.setText("Saldo: R$" + conta.getSaldo()); // Atualiza o texto do componente com o novo saldo
				}
				txtSaldo.setText("");
				
				deposito = JOptionPane.showOptionDialog(
						frame,
						componentes,
						"Depósito",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]
						);
				
				if(txtSaldo.getText().isEmpty()) {
					txtSaldo.setText("0");
				}
			} while(deposito == 1 && !conta.setSaldo(3, Double.parseDouble(txtSaldo.getText())));
		}
	}

	public static void sacar() {
		Frame frame = new Frame();
		
		JLabel texto = new JLabel("Saldo: R$" + conta.getSaldo());
		JLabel texto2 = new JLabel("Limite: R$" + conta.getLimite());
		JLabel linha = new JLabel(" ");
		JLabel lbSaque = new JLabel("Digite o quanto deseja sacar: ");
		JTextField txtSaque = new JTextField();
		
		JPanel componentes = new JPanel();
		
		componentes.setLayout(new BoxLayout(componentes, BoxLayout.Y_AXIS));
		componentes.add(texto);
		componentes.add(texto2);
		componentes.add(linha);
		componentes.add(lbSaque);
		componentes.add(txtSaque);
		
		Object[] options = {"Sair", "Sacar"};
		
		int saque;
		
		do {
			saque = JOptionPane.showOptionDialog(
					frame,
					componentes,
					"Saque",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]);
			
			if(saque == 1) {
				conta.setSaldo(2, Double.parseDouble(txtSaque.getText()));
				texto.setText("Saldo: R$" + conta.getSaldo());
				texto2.setText("Limite: R$" + conta.getLimite());
			}

		} while(saque == 1);
	}
	
	public static void login() {
		
		Frame frame = new Frame();
		
		JLabel lbSenha = new JLabel("Digite a sua senha para realizar o depósito: ");
		JPasswordField txtSenha = new JPasswordField();
		
		JPanel componentes = new JPanel();
		
		componentes.add(lbSenha);
		componentes.add(txtSenha);
		componentes.setLayout(new BoxLayout(componentes, BoxLayout.Y_AXIS));
		
		Object[] options = {"Voltar", "Login"};
		int login;
		
		String senha1;
		
		//if(!conta.getNumero().equals("-1") && cliente.getCodigo() != -1) {
		if(true) {
			do {
				login = JOptionPane.showOptionDialog(
						frame,
						componentes,
						"Login",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE,
						null,
						options,
						options[1]);
				
				senha1 = new String(txtSenha.getPassword());
			} while(login == 2 && (!conta.getSenha(senha1) && conta.getTentativas() < 3));
			
			if(conta.getTentativas() == 3) {
				JOptionPane.showMessageDialog(null, "Excedeu o limite de tentativas!");
				conta.setTentativas(0);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Você precisa abrir uma conta e registrar cliente primeiro!");
		}
		
		if(conta.getSenha(senha1)) {
			Frame frame2 = new Frame();
			
			Object[] opcoes2 = {"Depositar", "Sacar", "Sair"};
			
			int escolher = JOptionPane.showOptionDialog(
					frame,
					"Escolha o que deseja usar",
					"Escolha",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					opcoes2,
					opcoes2[1]);
			
			switch(escolher) {
				case 0:
					depositar();
				break;
				case 1:
					sacar();
				break;
				case 2:
					JOptionPane.showMessageDialog(null, "Saindo...");
			}
		}
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		
		Object[] options = {"Abrir a conta", "Cadastrar o cliente", "Depositar/Sacar", "Sair"};
		do {
			int inicio = JOptionPane.showOptionDialog(
					frame,
					"Seja bem-vindo(a) ao banco\nSelecione a opção que deseja",
					"Sistema Bancário",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[1]);
			
			switch(inicio) {
				case 0:
					abrirConta();
				break;
				case 1:
					registrar();
				break;
				case 2:
					login();
				break;
				case 3:
					aberto = 0;
				break;
			}
			
			
			
		} while(aberto == 1);
	}
}
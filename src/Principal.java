import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class Principal {
	
	static Cliente cliente = new Cliente();
	static Conta conta = new Conta();
	static int aberto = 1;
	
	public static void abrirConta() {
		Frame frame = new Frame();
		
		JLabel lbNumero = new JLabel("Insira o número de conta: ");
		JTextField txtNumero = new JTextField();
		
		JLabel lbDigito = new JLabel("Insira o seu dígito: ");
		JTextField txtDigito = new JTextField();
		
		JLabel lbSenha = new JLabel("Insira a sua senha: ");
		JTextField txtSenha = new JTextField();
		
		JLabel lbRepetirSenha = new JLabel("Repita a sua senha: ");
		JTextField txtRepetirSenha = new JTextField();
		
		JPanel componentes = new JPanel();
		
		componentes.add(lbNumero);
		componentes.add(txtNumero);
		componentes.add(lbDigito);
		componentes.add(txtDigito);
		componentes.add(lbSenha);
		componentes.add(txtSenha);
		componentes.add(lbRepetirSenha);
		componentes.add(txtRepetirSenha);
		
		componentes.setLayout(new BoxLayout(componentes, BoxLayout.Y_AXIS));
		
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
			
			
		} while(abrirconta == 1 && !conta.setDigito(txtDigito.getText()) && !conta.setSenha(txtSenha.getText(), txtRepetirSenha.getText()));
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
		} while(registro == 1 && (!cliente.setNome(txtNome.getText()) || !cliente.setCpf(txtCpf.getText()) || !cliente.setDataNasc(txtDataNasc.getText())
				|| !cliente.setEndereco(txtEndereco.getText()) || !cliente.setTelefone(txtTelefone.getText()) || !cliente.setCodigo(Integer.parseInt(txtCodigo.getText()))
				|| !cliente.setRendaMensal(Float.parseFloat(txtRendaMensal.getText()))));
	}
	
	public static void depositar() {
		
	}
	public static void main(String[] args) {
		Frame frame = new Frame();
		
		Object[] options = {"Abrir a conta", "Cadastrar o cliente", "Sair"};
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
					aberto = 0;
				break;
			}
			
			
			
		} while(aberto == 1);
	}
}
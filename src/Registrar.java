import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrar {
	public static void main(String[] args) {
		Frame frame = new Frame();
		
		JLabel lbNome = new JLabel("Nome: ");
		JTextField txtNome = new JTextField();
		
		JLabel lbSenha = new JLabel("Senha: ");
		JTextField txtSenha = new JTextField();
		
		JLabel lbCpf = new JLabel("CPF: ");
		JTextField txtCpf = new JTextField();
		
		Object[] options = {"Registrar", "Voltar"};
		
		JPanel componentes = new JPanel();
		componentes.add(lbNome);
		componentes.add(txtNome);
		componentes.add(lbSenha);
		componentes.add(txtSenha);
		componentes.add(lbCpf);
		componentes.add(txtCpf);
		
		componentes.setLayout(new BoxLayout(componentes, BoxLayout.Y_AXIS));
		int registro = JOptionPane.showOptionDialog(
				frame,
				componentes,
				"Por favor, preencha os campos.",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				options,
				options[1]
		);
	}
}

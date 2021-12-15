package br.senai.arquivo.arraylist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaContato extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCidade;
	
	//Atributos de instancia de objetos
	//Classe: arquivo
	//classe: contato
	//classe: dados do contato

	private Arquivo objArquivo;
	private Contato objContato;
	private DadosContato objDadosContato;
	private String caminho;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaContato frame = new TelaContato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaContato() {
		
		/* criação dos objetos das classes:
		 * contato
		 * arquivo
		 * dadoscontato
		 */
		
		objContato = new Contato();
		objArquivo = new Arquivo();
		objDadosContato = new DadosContato();
		
		//Configura o caminho do arquivo
		caminho = "C:\\Users\\21276380\\Desktop\\contato\\contatos.txt";
		
		//Exibe o total de contatos cadastrados
		ArrayList<Contato> teste = new ArrayList<Contato>();
		
		teste = objDadosContato.listarContatos();
		System.out.println("total de contatos: " + teste.size());
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroContato = new JLabel("CADASTRO DE CONTATO");
		lblCadastroContato.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroContato.setBounds(49, 11, 177, 14);
		contentPane.add(lblCadastroContato);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(38, 46, 65, 14);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setBounds(38, 71, 65, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setBounds(38, 96, 65, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setBounds(38, 122, 65, 14);
		contentPane.add(lblCidade);
		
		txtNome = new JTextField();
		txtNome.setBounds(131, 46, 223, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(131, 71, 223, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(131, 96, 223, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(131, 122, 223, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Contato> contatos = new ArrayList<Contato>();
				objDadosContato = objArquivo.ler(caminho);
				contatos = objDadosContato.listarContatos();
				
				objContato.setNome(txtNome.getText());
				objContato.setEmail(txtEmail.getText());
				objContato.setTelefone(txtTelefone.getText());
				objContato.setCidade(txtCidade.getText());
				
				objDadosContato.cadastrarContato(objContato);
				
				//Teste de leitura de dados com objetos de contato
				
				contatos.forEach(contato -> {
					
					System.out.println("NOME: " + contato.getNome() + " E-MAIL: " + contato.getEmail() + " TELEFONE: " + contato.getTelefone() + " CIDADE: " + contato.getCidade());
					
				});
				
			}
		});
		btnCadastrar.setBounds(177, 164, 129, 34);
		contentPane.add(btnCadastrar);
		
		JLabel lblTotalContatos = new JLabel("TOTAL DE CONTATOS:");
		lblTotalContatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalContatos.setBounds(38, 239, 129, 14);
		contentPane.add(lblTotalContatos);
		
		JLabel lblQuantidade = new JLabel("0000");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantidade.setBounds(162, 239, 46, 14);
		contentPane.add(lblQuantidade);
	}
}

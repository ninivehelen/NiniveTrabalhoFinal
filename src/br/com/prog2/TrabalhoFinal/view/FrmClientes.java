package br.com.prog2.TrabalhoFinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import br.com.prog2.TrabalhoFinal.controller.ClienteController;
import br.com.prog2.TrabalhoFinal.model.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;


public class FrmClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textcodCliente;
	private JTextField textnomeCliente;
	private JTextField textrgCliente;
	private JTextField textbairroCliente;
	private JTextField textestadoCliente;
	private JTextField textdataNascimentoCliente;
	private JTextField textcidadeCliente;
	private JTextField textcepCliente;
	private JTextField txtenderecoCliente;
	private JTable tblConsulta;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes frame = new FrmClientes();
					frame.setVisible(true);
					frame.setTitle("Cadastro de Clientes");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmClientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(55)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMensagem))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 907, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblMensagem)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 744, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
		);
		
		tblConsulta = new JTable();
		tblConsulta.setFont(new Font("Bodoni MT", Font.PLAIN, 12));
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Cliente", "Nome", "Rg", "Endere\u00E7o", "Bairro", "Cidade", "Estado", "Cep", "Data Nascimento"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class, String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblConsulta.getColumnModel().getColumn(8).setPreferredWidth(93);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
		        ClienteController c = new ClienteController();
				emp.setCodCliente(Integer.parseInt(textcodCliente.getText()));
				emp.setNomeCliente(textnomeCliente.getText());
				emp.setRgCliente(Integer.parseInt(textrgCliente.getText()));
				emp.setEnderecoCliente(txtenderecoCliente.getText());
				emp.setBairroCliente(textbairroCliente.getText());
				emp.setCidadeCliente(textcidadeCliente.getText());
				emp.setEstadoCliente(textestadoCliente.getText());
				emp.setCepCliente(Integer.parseInt(textcepCliente.getText()));
				emp.setNascimentoCliente(textdataNascimentoCliente.getText());
						
				lblMensagem.setText(c.inserir(emp));
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
				ClienteController c = new ClienteController();
				emp.setCodCliente(Integer.parseInt(textcodCliente.getText()));
				emp.setNomeCliente(textnomeCliente.getText());
				emp.setRgCliente(Integer.parseInt(textrgCliente.getText()));
				emp.setEnderecoCliente(txtenderecoCliente.getText());
				emp.setBairroCliente(textbairroCliente.getText());
				emp.setCidadeCliente(textcidadeCliente.getText());
				emp.setEstadoCliente(textestadoCliente.getText());
				emp.setCepCliente(Integer.parseInt(textcepCliente.getText()));
				emp.setNascimentoCliente(textdataNascimentoCliente.getText());
				lblMensagem.setText(c.alterar(emp));
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente emp = new Cliente();
				ClienteController c = new ClienteController();
				emp.setCodCliente(Integer.parseInt(textcodCliente.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
				"Deseja excluir esse empregado: "+textnomeCliente.getText()+"?",
				"Exclusão",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					lblMensagem.setText(c.excluir(emp));
					}
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Cliente> lista = new ArrayList();
				ClienteController c = new ClienteController();
				lista = c.listarTodos();
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
				int i = 0;
				for(Cliente ep : lista){
				tbm.addRow(new String[1]);
				tblConsulta.setValueAt(ep.getCodCliente(), i, 0);
				tblConsulta.setValueAt(ep.getNomeCliente(), i, 1);
				tblConsulta.setValueAt(ep.getRgCliente(), i, 2);
				tblConsulta.setValueAt(ep.getEnderecoCliente(), i, 3);
				tblConsulta.setValueAt(ep.getBairroCliente(), i, 4);
				tblConsulta.setValueAt(ep.getCidadeCliente(), i, 5);
				tblConsulta.setValueAt(ep.getEstadoCliente(), i, 6);
				tblConsulta.setValueAt(ep.getCepCliente(), i, 7);
				tblConsulta.setValueAt(ep.getNascimentoCliente(), i, 8);
				i++;
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                textcodCliente.setText("");
				textnomeCliente.setText("");
				textrgCliente.setText("");
				txtenderecoCliente.setText("");
				textbairroCliente.setText("");
				textcidadeCliente.setText("");
				textestadoCliente.setText("");
				textcepCliente.setText("");
				textdataNascimentoCliente.setText("");
				lblMensagem.setText("");
				
				DefaultTableModel tbm =
				(DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmClientes.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(152)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnInserir)
							.addGap(2)
							.addComponent(btnAlterar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExcluir))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnPesquisar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair)))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnExcluir)
						.addComponent(btnAlterar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPesquisar)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Codigo do Cliente");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		textcodCliente = new JTextField();
		textcodCliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome ");
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Rg ");
		lblNewLabel_2.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		textnomeCliente = new JTextField();
		textnomeCliente.setColumns(10);
		
		textrgCliente = new JTextField();
		textrgCliente.setColumns(10);
		
		textbairroCliente = new JTextField();
		textbairroCliente.setColumns(10);
		
		textestadoCliente = new JTextField();
		textestadoCliente.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Bairro");
		lblNewLabel_3.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		textdataNascimentoCliente = new JTextField();
		textdataNascimentoCliente.addMouseListener(new MouseAdapter() {
			
		});
		textdataNascimentoCliente.setColumns(10);
		
		textcidadeCliente = new JTextField();
		textcidadeCliente.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Endere\u00E7o");
		lblNewLabel_5.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6 = new JLabel("Cidade");
		lblNewLabel_6.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_7 = new JLabel("Cep");
		lblNewLabel_7.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		textcepCliente = new JTextField();
		textcepCliente.setColumns(10);
		
		txtenderecoCliente = new JTextField();
		txtenderecoCliente.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Data Nascimento");
		lblNewLabel_8.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textrgCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textdataNascimentoCliente, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(textbairroCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel_6)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textcidadeCliente))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(textestadoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_7)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textcepCliente, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_5)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtenderecoCliente, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textcodCliente, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textnomeCliente, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addGap(65))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textcodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textnomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textrgCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_8)
						.addComponent(textdataNascimentoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textbairroCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_6)
						.addComponent(textcidadeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textestadoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_7)
						.addComponent(textcepCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(txtenderecoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}

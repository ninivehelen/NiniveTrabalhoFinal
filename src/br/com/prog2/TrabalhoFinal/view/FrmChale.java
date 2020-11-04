package br.com.prog2.TrabalhoFinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.prog2.TrabalhoFinal.controller.ChaleController;
import br.com.prog2.TrabalhoFinal.model.Chale;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmChale extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodChale;
	private JTextField txtvalorAltaEstacao;
	private JTextField txtlocalizacao;
	private JTextField txtcapacidade;
	private JTextField txtvalorBaixaEstacao;
	private JTable tblConsulta;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
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
	public FrmChale() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String codigochale= tblConsulta.getValueAt(linha, 0).toString();
				String localizacao = tblConsulta.getValueAt(linha, 1).toString();
				String capacidade = tblConsulta.getValueAt(linha, 2).toString();
				String valoraltaestacao = tblConsulta.getValueAt(linha, 3).toString();
				String valorbaixaestacao = tblConsulta.getValueAt(linha, 3).toString();
				txtcodChale.setText(codigochale);
				txtlocalizacao.setText(localizacao);
				txtcapacidade.setText(capacidade);
				txtvalorAltaEstacao.setText(valoraltaestacao);
				txtvalorBaixaEstacao.setText(valorbaixaestacao);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Chale", "Localiza\u00E7\u00E3o", "Capacidade", "Valor Alta Esta\u00E7\u00E3o", "Valor Alta Baixa"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(98);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(102);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale emp = new Chale();
				ChaleController ec = new ChaleController();
				emp.setCodChale(Integer.parseInt(txtcodChale.getText()));
				emp.setLocalizacao(txtlocalizacao.getText());
				emp.setCapacidade(Integer.parseInt(txtcapacidade.getText()));
				emp.setValorAltaEstacao(Double.parseDouble(txtvalorAltaEstacao.getText()));
				emp.setValorBaixaEstacao(Double.parseDouble(txtvalorBaixaEstacao.getText()));
				
				lblMensagem.setText(ec.inserir(emp));
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Chale> listaEmp = new ArrayList();
				ChaleController ec = new ChaleController();
				listaEmp = ec.listarTodos();
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
				int i = 0;
				for(Chale ep : listaEmp){
				tbm.addRow(new String[1]);
				tblConsulta.setValueAt(ep.getCodChale(), i, 0);
				tblConsulta.setValueAt(ep.getLocalizacao(), i, 1);
				tblConsulta.setValueAt(ep.getCapacidade(), i, 2);
				tblConsulta.setValueAt(ep.getValorAltaEstacao(), i, 3);
				tblConsulta.setValueAt(ep.getValorBaixaEstacao(), i, 3);
				i++;
				}
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale emp = new Chale();
				ChaleController ec = new ChaleController();
				emp.setCodChale(Integer.parseInt(txtcodChale.getText()));
				emp.setLocalizacao(txtlocalizacao.getText());
				emp.setCapacidade(Integer.parseInt(txtcapacidade.getText()));
				emp.setValorAltaEstacao(Double.parseDouble(txtvalorAltaEstacao.getText()));
				emp.setValorBaixaEstacao(Double.parseDouble(txtvalorBaixaEstacao.getText()));
				lblMensagem.setText(ec.alterar(emp));
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtcodChale.setText("");
				txtlocalizacao.setText("");
				txtcapacidade.setText("");
				txtvalorAltaEstacao.setText("");
				txtvalorBaixaEstacao.setText("");
				lblMensagem.setText("");
				DefaultTableModel tbm =
				(DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale emp = new Chale();
				ChaleController c = new ChaleController();
				emp.setCodChale(Integer.parseInt(txtcodChale.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
				"Deseja excluir esse empregado: "+txtcodChale.getText()+"?",
				"Exclusão",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					lblMensagem.setText(c.excluir(emp));
					}

			}
			
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmChale.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(113)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnInserir)
							.addGap(20)
							.addComponent(btnAlterar))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnPesquisar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLimpar)))
					.addGap(8)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExcluir)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(btnSair)))
					.addContainerGap(280, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPesquisar)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Codigo Cliente");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Valor alta Esta\u00E7\u00E3o");
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Capacidade");
		lblNewLabel_2.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Valor Baixa Esta\u00E7\u00E3o");
		lblNewLabel_3.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Localiza\u00E7\u00E3o");
		lblNewLabel_4.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		txtcodChale = new JTextField();
		txtcodChale.setColumns(10);
		
		txtvalorAltaEstacao = new JTextField();
		txtvalorAltaEstacao.setColumns(10);
		
		txtlocalizacao = new JTextField();
		txtlocalizacao.setColumns(10);
		
		txtcapacidade = new JTextField();
		txtcapacidade.setColumns(10);
		
		txtvalorBaixaEstacao = new JTextField();
		txtvalorBaixaEstacao.setColumns(10);
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_4)
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtcodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtvalorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtcapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtvalorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtlocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(lblMensagem)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addComponent(txtcodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtcapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3)
						.addComponent(txtvalorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtvalorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtlocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblMensagem))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}

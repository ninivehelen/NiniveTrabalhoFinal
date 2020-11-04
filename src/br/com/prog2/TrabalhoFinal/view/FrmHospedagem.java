package br.com.prog2.TrabalhoFinal.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.prog2.TrabalhoFinal.controller.ChaleController;
import br.com.prog2.TrabalhoFinal.controller.HospedagemController;
import br.com.prog2.TrabalhoFinal.model.Chale;
import br.com.prog2.TrabalhoFinal.model.Hospedagem;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class FrmHospedagem extends JFrame {

	private JPanel contentPane;
	private JTextField textEstado;
	private JTextField textcodHospedagem;
	private JTextField textvalorFinal;
	private JTextField textdataInicio;
	private JTextField textdataFim;
	private JTextField textDesconto;
	private JTextField txtCodHospedagem;
	private JTable tblConsulta;
	private JComboBox cbxcodChale;
	private JLabel lblmensagem;
	private List<Chale> listaemp;
	private JTable tblconsulta;
	private JTextField textquantpessoas;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
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
	public FrmHospedagem() {
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
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		
		tblconsulta = new JTable();
		tblconsulta.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		tblconsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Hospedagem", "Codigo Chale", "Estado", "Data Inicio", "Data Fim ", "Quantidade de Pessoas", "Desconto", "Valor Final"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblconsulta.getColumnModel().getColumn(0).setPreferredWidth(110);
		tblconsulta.getColumnModel().getColumn(4).setPreferredWidth(67);
		tblconsulta.getColumnModel().getColumn(5).setPreferredWidth(124);
		scrollPane.setViewportView(tblconsulta);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				Chale  emp = new Chale();
				HospedagemController ec = new HospedagemController();
				Integer pos = 0;
				
				for (Chale e1 : listaemp) {
				if (e1.getCodChale().equals(cbxcodChale.getSelectedItem())) {
				pos = listaemp.indexOf(e1);
				}
				}
				emp.setCodChale(listaemp.get(pos).getCodChale());
				hos.setCodHospedagem(Integer.parseInt(textcodHospedagem.getText()));
				hos.setEstado(textEstado.getText());
				hos.setDataInicio(textdataInicio.getText());
				hos.setDataFim(textdataFim.getText());
				hos.setQuntiPessoas(Integer.parseInt(textquantpessoas.getText()));
				hos.setDesconto(Integer.parseInt(textDesconto.getText()));
				hos.setValorFinal(Double.parseDouble(textvalorFinal.getText()));
				lblmensagem.setText(ec.alterar(hos));
				
				
			}
		});
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			List<Hospedagem> listaEmp = new ArrayList();
			HospedagemController ec = new HospedagemController();
			listaEmp = ec.listarTodos();
			DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
			for(int i = tbm.getRowCount()-1; i >= 0; i--){
			tbm.removeRow(i);
			}
			int i = 0;
			for(Hospedagem ep : listaEmp){
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(ep.getCodHospedagem(), i, 0);
			tblConsulta.setValueAt(ep.getCodChale(), i, 1);
			tblConsulta.setValueAt(ep.getEstado(), i, 2);
			tblConsulta.setValueAt(ep.getDataInicio(), i, 3);
			tblConsulta.setValueAt(ep.getDataFim(), i, 4);
			tblConsulta.setValueAt(ep.getQuntiPessoas(), i, 5);
			tblConsulta.setValueAt(ep.getDesconto(), i, 6);
			tblConsulta.setValueAt(ep.getValorFinal(), i, 7);
			i++;
			}
			}
		});
		btnPesquisar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController ec = new HospedagemController();
				hos.setCodHospedagem(Integer.parseInt(textcodHospedagem.getText()));
				hos.setEstado(textEstado.getText());
				hos.setDataInicio(textdataInicio.getText());
				hos.setDataFim(textdataFim.getText());
				hos.setQuntiPessoas(Integer.parseInt(textquantpessoas.getText()));
				hos.setDesconto(Integer.parseInt(textDesconto.getText()));
				hos.setValorFinal(Double.parseDouble(textvalorFinal.getText()));
				lblmensagem.setText(ec.alterar(hos));
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textcodHospedagem.setText("");
				cbxcodChale.setToolTipText(" ");			
				textEstado.setText("");
				textdataInicio.setText("");
				textdataFim.setText("");
				textquantpessoas.setText("");
				textDesconto.setText("");
				textvalorFinal.setText("");
				
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
				Hospedagem hos = new Hospedagem();
				HospedagemController ec = new HospedagemController();
				hos.setCodHospedagem(Integer.parseInt(textcodHospedagem.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
				"Deseja excluir esse empregado: "+textcodHospedagem.getText()+"?",
				"Exclusão",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					lblmensagem.setText(ec.excluir(hos));
					}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmHospedagem.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnInserir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAlterar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExcluir))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnPesquisar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair)))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPesquisar)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		ChaleController ec = new ChaleController();
		listaemp = ec.listarTodos();
		cbxcodChale = new JComboBox();
		for(Chale e : listaemp){
		cbxcodChale.addItem(e.getCodChale());
		}
		
		JLabel lbl = new JLabel("Codigo Chale");
		lbl.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Codigo Hospedagem");
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Estado");
		lblNewLabel_2.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Data Inicio");
		lblNewLabel_3.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("Data Fim");
		lblNewLabel_4.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade Pessoas");
		lblNewLabel_5.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6 = new JLabel("Valor Final");
		lblNewLabel_6.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel_7 = new JLabel("Desconto");
		lblNewLabel_7.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		
		textcodHospedagem = new JTextField();
		textcodHospedagem.setColumns(10);
		
		textvalorFinal = new JTextField();
		textvalorFinal.setColumns(10);
		
		textdataInicio = new JTextField();
		textdataInicio.setColumns(10);
		
		textdataFim = new JTextField();
		textdataFim.setColumns(10);
		
		textDesconto = new JTextField();
		textDesconto.setColumns(10);
		
		textquantpessoas = new JTextField();
		textquantpessoas.setColumns(10);
		
		JLabel lblmensagem = new JLabel("Mensagem");
		lblmensagem.setFont(new Font("Bodoni MT", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3))
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textvalorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(31)
											.addComponent(lblNewLabel_2)
											.addGap(14)
											.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(18)
											.addComponent(lblNewLabel_7)
											.addGap(18)
											.addComponent(textDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textdataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_5)
									.addGap(18)
									.addComponent(textquantpessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(textdataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textcodHospedagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lbl)
							.addGap(14)
							.addComponent(cbxcodChale, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblmensagem)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textcodHospedagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl)
						.addComponent(cbxcodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblmensagem))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textdataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(textvalorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7)
								.addComponent(textDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(textdataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5)
								.addComponent(textquantpessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}

package br.com.prog2.TrabalhoFinal.persistencia;
import java.util.List;

import javax.swing.JLabel;

import br.com.prog2.TrabalhoFinal.model.Chale;

public interface ChaleInterface {
	public String inserir(Chale emp);
	public String alterar(Chale emp);
	public String excluir(Chale emp);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCodChale(Integer codChale);
	
	
	}



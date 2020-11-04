package br.com.prog2.TrabalhoFinal.persistencia;
import java.util.List;
import br.com.prog2.TrabalhoFinal.model.Cliente;

public interface ClienteInterface {
	public String inserir(Cliente emp);
	public String alterar(Cliente emp);
	public String excluir(Cliente emp);
	public List<Cliente> listarTodos();
	public Cliente pesquisarPorcodCliente(Integer CodCliente);
	}

	



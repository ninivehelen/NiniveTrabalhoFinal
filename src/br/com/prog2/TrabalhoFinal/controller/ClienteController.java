package br.com.prog2.TrabalhoFinal.controller;
import java.util.List;
import br.com.prog2.TrabalhoFinal.model.Cliente;
import br.com.prog2.TrabalhoFinal.persistencia.ClienteInterfaceClasse;
public class ClienteController {

	public String inserir(Cliente emp) {
		 ClienteInterfaceClasse cadastro = new ClienteInterfaceClasse();
		return cadastro.inserir(emp);
	}

	public String alterar(Cliente emp) {
		 ClienteInterfaceClasse cadastro = new ClienteInterfaceClasse();
		return cadastro.alterar(emp);
	}

	public String excluir(Cliente emp) {
		ClienteInterfaceClasse cadastro = new ClienteInterfaceClasse();
		return cadastro.excluir(emp);
	}

public List<Cliente> listarTodos(){
	 ClienteInterfaceClasse cadastro = new  ClienteInterfaceClasse();
return cadastro.listarTodos();
}
public Cliente pesquisarPorcodCliente(Integer codCliente){
	 ClienteInterfaceClasse  cadastro = new  ClienteInterfaceClasse ();
return cadastro.pesquisarPorcodCliente(codCliente);
}
}

package br.com.prog2.TrabalhoFinal.controller;
import java.util.List;
import br.com.prog2.TrabalhoFinal.model.Chale;
import br.com.prog2.TrabalhoFinal.persistencia.ChaleInterfaceClasse;

public class ChaleController {
	public String inserir(Chale emp){
		ChaleInterfaceClasse dao = new ChaleInterfaceClasse();
		return dao.inserir(emp);
		}
		public String alterar(Chale emp) {
		ChaleInterfaceClasse dao = new ChaleInterfaceClasse();
		return dao.alterar(emp);
		}
		public String excluir(Chale emp){
			ChaleInterfaceClasse dao = new ChaleInterfaceClasse();
		return dao.excluir(emp);
		}
		public List<Chale> listarTodos(){
		ChaleInterfaceClasse dao = new ChaleInterfaceClasse();
		return dao.listarTodos();
		}
		public Chale pesquisarPorCodChale(Integer codChale){
			ChaleInterfaceClasse dao = new ChaleInterfaceClasse();
			return dao.pesquisarPorCodChale(codChale);
			}

}

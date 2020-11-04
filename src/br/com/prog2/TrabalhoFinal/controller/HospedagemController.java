package br.com.prog2.TrabalhoFinal.controller;

import java.util.List;

import br.com.prog2.TrabalhoFinal.model.Hospedagem;
import br.com.prog2.TrabalhoFinal.persistencia.HospedagemInterfaceClasse;

public class HospedagemController {
	public String inserir(Hospedagem hos) {
		HospedagemInterfaceClasse dao = new HospedagemInterfaceClasse();
		return dao.inserir(hos);
		}
		public String alterar(Hospedagem hos) {
		HospedagemInterfaceClasse dao = new HospedagemInterfaceClasse();
		return dao.alterar(hos);
		}
		public String excluir(Hospedagem hos) {
		HospedagemInterfaceClasse dao = new HospedagemInterfaceClasse();
		return dao.excluir(hos);
		}
		public List<Hospedagem> listarTodos() {
		HospedagemInterfaceClasse dao = new HospedagemInterfaceClasse();
		return dao.listarTodos();
		}
		public Hospedagem pesquisarPorCodigoHospedagem(Integer codHospedagem) {
		HospedagemInterfaceClasse dao = new HospedagemInterfaceClasse();
		return dao.pesquisarPorCodigoHospedagem(codHospedagem);
		}
		}




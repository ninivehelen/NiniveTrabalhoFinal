package br.com.prog2.TrabalhoFinal.persistencia;

import java.util.List;

import br.com.prog2.TrabalhoFinal.model.Hospedagem;

public interface HospedagemInterface {
	
		public String inserir(Hospedagem hos);
		public String alterar(Hospedagem hos);
		public String excluir(Hospedagem hos);
		public List<Hospedagem> listarTodos();
		public  Hospedagem pesquisarPorCodigoHospedagem(Integer codHospedagem);
	}



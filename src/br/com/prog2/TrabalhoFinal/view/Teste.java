package br.com.prog2.TrabalhoFinal.view;

import java.sql.Connection;
import java.util.List;

import br.com.prog2.TrabalhoFinal.controller.ChaleController;
import br.com.prog2.TrabalhoFinal.controller.ClienteController;
import br.com.prog2.TrabalhoFinal.controller.HospedagemController;
import br.com.prog2.TrabalhoFinal.model.Chale;
import br.com.prog2.TrabalhoFinal.model.Cliente;
import br.com.prog2.TrabalhoFinal.model.Hospedagem;
import br.com.prog2.TrabalhoFinal.persistencia.ConnectionFactory;



public class Teste {
	public static void main(String[] args) {
		
		Connection con = ConnectionFactory.getConnection();
		
		if(con != null){
		System.out.println("Conectou");
		
		}else {
			System.out.println("erro");
		
		}
		
		}
		
		
			
		}
	



		
	




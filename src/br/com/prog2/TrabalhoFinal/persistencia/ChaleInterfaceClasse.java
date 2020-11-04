package br.com.prog2.TrabalhoFinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.TrabalhoFinal.model.Chale;

public class ChaleInterfaceClasse implements ChaleInterface {
	@Override
	public String inserir(Chale emp) {
		String sql = "insert into chale(codChale,localizacao,capacidade,valorAltaEstacao,ValorBaixaEstacao) values (?,?,?,?,?)";
				Connection con = ConnectionFactory.getConnection();
				try{
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, emp.getCodChale());
				pst.setString(2, emp.getLocalizacao());
				pst.setInt(3, emp.getCapacidade());
				pst.setDouble(4, emp.getValorAltaEstacao());
				pst.setDouble(5, emp.getValorBaixaEstacao());
				int res = pst.executeUpdate();
				if(res > 0){
				return "Inserido com sucesso.";
				}else{
				return "Erro ao inserir.";
				}
				}catch(SQLException e){
				return e.getMessage();
				}finally {
				ConnectionFactory.close(con);
				}
				}
	@Override
	public String alterar(Chale emp) {
		String sql = "update chale set localizacao=?,capacidade=?,valorAltaEstacao=?, valorBaixaEstacao=? where codChale=?";
				Connection con = ConnectionFactory.getConnection();
				try{
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, emp.getLocalizacao());
				pst.setInt(2, emp.getCapacidade());
				pst.setDouble(3, emp.getValorAltaEstacao());
				pst.setDouble(4, emp.getValorBaixaEstacao());
				pst.setInt(5, emp.getCodChale());
				int res = pst.executeUpdate();
				if(res > 0){
				return "Alterado com sucesso.";
				}else{
				return "Erro ao alterar.";
				}
				}catch(SQLException e){
				return e.getMessage();
				}finally {
				ConnectionFactory.close(con);
				}
	}
	@Override
	public String excluir(Chale emp) {
		String sql = "delete from chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try{
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, emp.getCodChale());
		int res = pst.executeUpdate();
		if(res > 0){
		return "Excluído com sucesso.";
		}else{
		return "Erro ao excluir.";
		}
		}catch(SQLException e){
		return e.getMessage();
		}finally {
		ConnectionFactory.close(con);
		}
	
	}
	@Override
	public List<Chale> listarTodos() {
		String sql = "select * from chale";
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs != null) {
		while (rs.next()) {
		Chale ep = new Chale();
		ep.setCodChale(rs.getInt(1));
		ep.setLocalizacao(rs.getString(2));
		ep.setCapacidade(rs.getInt(3));
		ep.setValorAltaEstacao(rs.getDouble(4));
		ep.setValorBaixaEstacao(rs.getDouble(5));
		lista.add(ep);
		}
		return lista;
		} else {
		return null;
		}
		} catch (SQLException e) {
		return null;
		} finally {
		ConnectionFactory.close(con);
		}
	}
	@Override
	public Chale pesquisarPorCodChale(Integer codChale) {
		String sql = "select * from chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, codChale);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
		Chale ep = new Chale();
		ep.setCodChale(rs.getInt(1));
		ep.setLocalizacao(rs.getString(2));
		ep.setCapacidade(rs.getInt(3));
		ep.setValorAltaEstacao(rs.getDouble(4));
		ep.setValorBaixaEstacao(rs.getDouble(5));
		return ep;
		} else {
		return null;
		}
		} catch (SQLException e) {
			return null;
		} finally {
		ConnectionFactory.close(con);
		}
		}
}



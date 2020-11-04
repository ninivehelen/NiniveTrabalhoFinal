package br.com.prog2.TrabalhoFinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.TrabalhoFinal.model.Chale;
import br.com.prog2.TrabalhoFinal.model.Hospedagem;

public class HospedagemInterfaceClasse implements HospedagemInterface{
	@Override
	public String inserir(Hospedagem hos) {
		String sql = "insert into hospedagem(codHospedagem,CodChale,estado,dataInicio,dataFim,qtdpessoas,desconto,valorFinal) values (?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try{
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, hos.getCodHospedagem());
		pst.setInt(2, hos.getCodChale());
		pst.setString(3, hos.getEstado());
		pst.setString(4,hos.getDataInicio());
		pst.setString(5,hos.getDataFim());
		pst.setInt(6,hos.getQuntiPessoas());
		pst.setInt(7,hos.getDesconto());
		pst.setDouble(8,hos.getValorFinal());
		
		
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
	public String alterar(Hospedagem hos) {
		String sql = "update hospedagem set CodChale=?,estado=?,dataInicio=?,dataFim=?,qtdpessoas=?,desconto=?,valorFinal=? where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, hos.getCodHospedagem());
			pst.setInt(2, hos.getCodChale());
			pst.setString(3, hos.getEstado());
			pst.setString(4,hos.getDataInicio());
			pst.setString(5,hos.getDataFim());
			pst.setInt(6,hos.getQuntiPessoas());
			pst.setInt(7,hos.getDesconto());
			pst.setDouble(8,hos.getValorFinal());
			int res = pst.executeUpdate();
			if (res > 0) {
			return "Alterado com sucesso.";
			} else {
			return "Erro ao alterar.";
			}
			} catch (SQLException e) {
			return e.getMessage();
			} finally {
			ConnectionFactory.close(con);
			}
			}
	

	@Override
	public String excluir(Hospedagem hos) {
		String sql = "delete from hospedagem where codHospedagem=?";
		Connection con = ConnectionFactory.getConnection();
		try{
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, hos.getCodHospedagem());
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
	public List<Hospedagem> listarTodos() {
		String sql = "select * from hospedagem";
		Connection con = ConnectionFactory.getConnection();
		List<Hospedagem> lista = new ArrayList<>();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs != null) {
		while (rs.next()) {
		Hospedagem ep = new Hospedagem();
		ep.setCodHospedagem(rs.getInt(1));
		ep.setCodChale(rs.getInt(2));
		ep.setEstado(rs.getString(3));
		ep.setDataInicio(rs.getString(4));
		ep.setDataFim(rs.getString(5));
		ep.setQuntiPessoas(rs.getInt(6));
		ep.setDesconto(rs.getInt(7));
		ep.setValorFinal(rs.getDouble(8));
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
	public Hospedagem pesquisarPorCodigoHospedagem(Integer codHospedagem) {
		String sql = "select * from hospedagem where codHospedagem=?";
		Connection con = ConnectionFactory.getConnection();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, codHospedagem);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
		Hospedagem ep = new Hospedagem();
		ep.setCodHospedagem(rs.getInt(1));
		ep.setCodChale(rs.getInt(2));
		ep.setEstado(rs.getString(3));
		ep.setDataInicio(rs.getString(4));
		ep.setDataFim(rs.getString(5));
		ep.setQuntiPessoas(rs.getInt(6));
		ep.setDesconto(rs.getInt(7));
		ep.setValorFinal(rs.getDouble(8));
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
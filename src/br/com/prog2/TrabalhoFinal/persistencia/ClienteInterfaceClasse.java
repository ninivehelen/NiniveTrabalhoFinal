package br.com.prog2.TrabalhoFinal.persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.TrabalhoFinal.model.Cliente;

public class ClienteInterfaceClasse implements ClienteInterface {
	@Override
	public String inserir(Cliente emp) {
		String sql = "insert into cliente(codCliente,nomeCliente,rgCliente,enderecoCliente,bairroCliente,cidadeCliente, estadoCliente,cepCliente,nascimentoCliente) values (?,?,?,?,?,?,?,?,?)";
				Connection con = ConnectionFactory.getConnection();
				try{
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, emp.getCodCliente());
				pst.setString(2, emp.getNomeCliente());
				pst.setInt(3, emp.getRgCliente());
				pst.setString(4, emp.getEnderecoCliente());
				pst.setString(5, emp.getBairroCliente());
				pst.setString(6, emp.getCidadeCliente());
				pst.setString(7, emp.getEstadoCliente());
				pst.setInt(8, emp.getCepCliente());
				pst.setString(9, emp.getNascimentoCliente());
		
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
	public String alterar(Cliente emp) {
			String sql = "update cliente set nomeCliente =?,rgCliente=?,enderecoCliente=?,bairroCliente=?,cidadeCliente=?, estadoCliente=?,cepCliente=?,nascimentoCliente=? where codCliente=?";
			Connection con = ConnectionFactory.getConnection();
			try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, emp.getNomeCliente());
			pst.setString(2, emp.getEnderecoCliente());
			pst.setInt(3, emp.getRgCliente());
			pst.setString(4, emp.getBairroCliente());
			pst.setString(5, emp.getCidadeCliente());
			pst.setString(6, emp.getEstadoCliente());
			pst.setInt(7, emp.getCepCliente());
			pst.setString(8, emp.getNascimentoCliente());
			pst.setInt(9, emp.getCodCliente());
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
	public String excluir(Cliente emp) {
		
			String sql = "delete from cliente where codCliente=?";
			Connection con = ConnectionFactory.getConnection();
			try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, emp.getCodCliente());
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
	public List<Cliente> listarTodos() {
		String sql = "select * from cliente";
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs != null) {
		while (rs.next()) {
		Cliente ep = new Cliente();
		ep.setCodCliente(rs.getInt(1));
		ep.setNomeCliente(rs.getString(2));
		ep.setRgCliente(rs.getInt(3));
		ep.setEnderecoCliente(rs.getString(4));
		ep.setBairroCliente(rs.getString(5));
		ep.setCidadeCliente(rs.getString(6));
		ep.setEstadoCliente(rs.getString(7));
		ep.setCepCliente(rs.getInt(8));
		ep.setNascimentoCliente(rs.getString(9));
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
	public Cliente pesquisarPorcodCliente(Integer CodCliente) {
		String sql = "select * from cliente where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, CodCliente);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
		Cliente ep = new Cliente();
		ep.setCodCliente(rs.getInt(1));
		ep.setNomeCliente(rs.getString(2));
		ep.setRgCliente(rs.getInt(3));
		ep.setEnderecoCliente(rs.getString(4));
		ep.setBairroCliente(rs.getString(5));
		ep.setCidadeCliente(rs.getString(6));
		ep.setEstadoCliente(rs.getString(7));
		ep.setCepCliente(rs.getInt(8));
		ep.setNascimentoCliente(rs.getString(9));
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
	



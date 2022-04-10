package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class Conexao {

	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private String url = "jdbc:mysql://127.0.0.1:3306/dbregistro?useTimezone=true&serverTimezone=UTC";
	
	private String user = "root";
	
	private String password = "admin";
        
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void inserirContrato(Receptor contrato) {
		String create = "insert into contratos (nome, email, fone, horario, datas, vaga) values (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contrato.getNome());
			pst.setString(2, contrato.getEmail());
                        pst.setString(3, contrato.getFone());
                        pst.setString(4, contrato.getHorario());
                        pst.setString(5, contrato.getDatas());
                        pst.setString(6, contrato.getVaga());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<Receptor> listarContratos() {
		ArrayList<Receptor> contratos = new ArrayList<>();
		String read = "select * from contratos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
                                String fone = rs.getString(4);
                                String horario = rs.getString(5);
                                String datas = rs.getString(6);
                                String vaga = rs.getString(7);
				contratos.add(new Receptor(id, nome, email, fone, horario, datas, vaga));
			}
			con.close();
			return contratos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionarContrato(Receptor contrato) {
		String read2 = "select * from contratos where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contrato.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contrato.setId(rs.getString(1));
				contrato.setNome(rs.getString(2));
				contrato.setFone(rs.getString(3));
				contrato.setEmail(rs.getString(4));
                                contrato.setHorario(rs.getString(5));
                                contrato.setDatas(rs.getString(6));
                                contrato.setVaga(rs.getString(7));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void alterarContrato(Receptor contrato) {
		String update = "update contratos set nome=?, email=?, fone=?, horario=?, datas=?, vaga=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contrato.getNome());
			pst.setString(2, contrato.getFone());
			pst.setString(3, contrato.getEmail());
                        pst.setString(4, contrato.getHorario());
                        pst.setString(5, contrato.getDatas());
                        pst.setString(6, contrato.getVaga());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deletarContrato(Receptor contrato) {
		String delete = "delete from contratos where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contrato.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonagemDao {
    public void cadastrar(Personagem per) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into ficha (nome, conceito, caracteristicas, historico, equipamento, defeito, ptheroi, nvsaude, proeza1, proeza2, proeza3, ptproeza1, ptproeza2, ptproeza3) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        comando.setString(1, per.getNome());
        comando.setString(2, per.getConceito());
        comando.setString(3, per.getCaracteristicas());
        comando.setString(4, per.getHistorico());
        comando.setString(5, per.getEquipamento());
        comando.setString(6, per.getDefeito());
        comando.setInt(7, per.getPtheroi());
        comando.setInt(8, per.getNvsaude());
        comando.setString(9, per.getProeza1());
        comando.setString(10, per.getProeza2());
        comando.setString(11, per.getProeza3());
        comando.setInt(12, per.getPtproeza1());
        comando.setInt(13, per.getPtproeza2());
        comando.setInt(14, per.getPtproeza3());
        comando.execute();
        con.close();
    }
    
    public void deletar(Personagem per) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from ficha where id = ?");
        comando.setInt(1, per.getId());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Personagem per) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update ficha set nome = ?, conceito = ?, caracteristicas = ?, historico = ?, equipamento = ?, defeito = ?, ptheroi = ?, nvsaude = ?, proeza1 = ?, proeza2 = ?, proeza3 = ?, ptproeza1 = ?, ptproeza2 = ?, ptproeza3 = ? where id = ?");
        comando.setString(1, per.getNome());
        comando.setString(2, per.getConceito());
        comando.setString(3, per.getCaracteristicas());
        comando.setString(4, per.getHistorico());
        comando.setString(5, per.getEquipamento());
        comando.setString(6, per.getDefeito());
        comando.setInt(7, per.getPtheroi());
        comando.setInt(8, per.getNvsaude());
        comando.setString(9, per.getProeza1());
        comando.setString(10, per.getProeza2());
        comando.setString(11, per.getProeza3());
        comando.setInt(12, per.getPtproeza1());
        comando.setInt(13, per.getPtproeza2());
        comando.setInt(14, per.getPtproeza3());
        comando.setInt(15, per.getId());
        comando.execute();
        con.close();
    }

    public Personagem consultarById(Personagem per) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from ficha where id = ?");
        comando.setInt(1, per.getId());
        ResultSet rs = comando.executeQuery();
        Personagem personagem = new Personagem();
        if (rs.next()){
            personagem.setId(rs.getInt("id"));
            personagem.setNome(rs.getString("nome"));
            personagem.setConceito(rs.getString("conceito"));
            personagem.setCaracteristicas(rs.getString("caracteristicas"));
            personagem.setHistorico(rs.getString("historico"));
            personagem.setEquipamento(rs.getString("equipamento"));
            personagem.setDefeito(rs.getString("defeito"));
            personagem.setPtheroi(rs.getInt("ptheroi"));
            personagem.setNvsaude(rs.getInt("nvsaude"));
            personagem.setProeza1(rs.getString("proeza1"));
            personagem.setProeza2(rs.getString("proeza2"));
            personagem.setProeza3(rs.getString("proeza3"));
            personagem.setPtproeza1(rs.getInt("ptproeza1"));
            personagem.setPtproeza2(rs.getInt("ptproeza2"));
            personagem.setPtproeza3(rs.getInt("ptproeza3"));
        }        
        return personagem;
    }
    
    
    public List<Personagem> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from ficha");
        ResultSet rs = comando.executeQuery();
        
        List<Personagem> lprod = new ArrayList<>();
        while(rs.next()){
            Personagem personagem = new Personagem();
            personagem.setId(rs.getInt("id"));
            personagem.setNome(rs.getString("nome"));
            personagem.setConceito(rs.getString("conceito"));
            personagem.setCaracteristicas(rs.getString("caracteristicas"));
            personagem.setHistorico(rs.getString("historico"));
            personagem.setEquipamento(rs.getString("equipamento"));
            personagem.setDefeito(rs.getString("defeito"));
            personagem.setPtheroi(rs.getInt("ptheroi"));
            personagem.setNvsaude(rs.getInt("nvsaude"));
            personagem.setProeza1(rs.getString("proeza1"));
            personagem.setProeza2(rs.getString("proeza2"));
            personagem.setProeza3(rs.getString("proeza3"));
            personagem.setPtproeza1(rs.getInt("ptproeza1"));
            personagem.setPtproeza2(rs.getInt("ptproeza2"));
            personagem.setPtproeza3(rs.getInt("ptproeza3"));
            
            lprod.add(personagem);
        }        
        return lprod;
    }
}

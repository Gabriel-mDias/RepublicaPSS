package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.collection.EstadoPessoaCollection;
import br.ufes.republica.collection.EstadoRepublicaCollection;
import br.ufes.republica.dao.interfaces.IPessoaDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PessoaDAOSQLite implements IPessoaDAO {

    private SqliteManager manager;
    
    @Override
    public void insert(Pessoa p) throws Exception {
        try {
            String SQL = "INSERT INTO Pessoa(nome, apelido, telefone, cpf, linkRedesSociais, telefoneResponsavel1, telefoneResponsavel2, estado) " + 
                                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1,p.getNome());
            ps.setString(2, p.getApelido());
            ps.setString(3, p.getTelefone());
            ps.setString(4, p.getCPF());
            ps.setString(5, p.getLinkRedeSocial());
            ps.setString(6, p.getTelefoneResponsavel1());
            ps.setString(7, p.getTelefoneResponsavel2());
            ps.setString(8, p.getEstado().toString());
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
            
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    @Override
    public void update(Pessoa p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa getById(Long id) throws Exception {
        try{
            String SQL = "SELECT p.id, p.nome, p.apelido, p.telefone, p.cpf, p.linkRedeSocial, p.telefoneResponsavel1, p.telefoneResponsavel2, p.estado, p.id_republica "+
                    " r.nome, r.vantagens, r.estatuto, r.dataFundacao, r.dataExtincao, r.numTotalVagas, r.estado, r.despesaMediaMorador "+
                    " FROM Pessoa p LEFT JOIN Republica r ON p.id_republica = r.id " + 
                    " WHERE p.id = ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            
            Pessoa morador = new Pessoa();
            Republica republica = new Republica();
            while(rs.next()){
                morador.setId(rs.getLong(1));
                morador.setNome(rs.getString(2));
                morador.setApelido(rs.getString(3));
                morador.setTelefone(rs.getString(4));
                morador.setCPF(rs.getString(5));
                morador.setLinkRedeSocial(rs.getString(6));
                morador.setTelefoneResponsavel1(rs.getString(7));
                morador.setTelefoneResponsavel2(rs.getString(8));
                morador.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(9)));
                
                republica.setId(rs.getLong(10));
                republica.setVantagens(rs.getString(11));
                republica.setEstatuto(rs.getString(12));
                republica.setDataFundacao(rs.getDate(13).toLocalDate());
                republica.setDataExtincao(rs.getDate(14).toLocalDate());
                republica.setNumeroTotalVagas(rs.getInt(15));
                republica.setEstado(EstadoRepublicaCollection.getInstancia().cria(rs.getString(16)));
                republica.setDespesaMediaMorador(rs.getDouble(17));
                
                morador.setRepublicaAtual(republica);
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return morador;
            
        }catch(Exception e){
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }
    
    @Override
    public List<Pessoa> getByIdRepublica(Long idRepublica) throws Exception {
        List<Pessoa> moradores = new ArrayList<>();
        
        try{
            String SQL = "SELECT m.id, m.nome, m.apelido, m.telefone, m.cpf, m.linkRedeSocial, m.telefoneResponsavel1, m.telefoneResponsavel2, m.estado "+
                    " FROM Pessoa m INNER JOIN Republica r ON r.id = p.id_republica" + 
                    " WHERE r.id = ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idRepublica);
            ResultSet rs = ps.executeQuery();
            
            Pessoa morador = new Pessoa();
            while(rs.next()){
                morador.setId(rs.getLong(1));
                morador.setNome(rs.getString(2));
                morador.setApelido(rs.getString(3));
                morador.setTelefone(rs.getString(4));
                morador.setCPF(rs.getString(5));
                morador.setLinkRedeSocial(rs.getString(6));
                morador.setTelefoneResponsavel1(rs.getString(7));
                morador.setTelefoneResponsavel2(rs.getString(8));
                morador.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(9)));
                
                moradores.add(morador);
                //morador = new Pessoa();
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return moradores;
            
        }catch(Exception e){
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public void updateRepublica(Pessoa p) throws Exception {
        try{
            String SQL = "UPDATE Pessoa SET id_republica = ? "+
                    " WHERE id = ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, p.getRepublicaAtual().getId());
            ps.setLong(2, p.getId());
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
            
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao atualizar");
        }    
    }
}

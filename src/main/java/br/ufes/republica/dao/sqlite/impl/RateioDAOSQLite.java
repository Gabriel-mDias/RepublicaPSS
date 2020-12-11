package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.collection.EstadoPessoaCollection;
import br.ufes.republica.dao.interfaces.IRateioDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.enums.Periodicidade;
import br.ufes.republica.enums.TipoLancamento;
import br.ufes.republica.models.Lancamento;
import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Rateio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RateioDAOSQLite implements IRateioDAO {

    private SqliteManager manager;

    public RateioDAOSQLite(SqliteManager manager) {
        if (manager == null) {
            throw new RuntimeException("Manager fornecido é inválido");
        }        
        this.manager = manager;
    }
    
    
    @Override
    public void insert(Rateio rateio) throws Exception {
        try {
            String SQL = "INSERT INTO Rateio(valor, pago, id_pessoa, id_lancamento)"+
                        " VALUES(?, ?, ?, ?);";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setDouble(1, rateio.getValor());
            ps.setBoolean(2, rateio.isPago());
            ps.setLong(3, rateio.getPessoa().getId());
            ps.setLong(4, rateio.getLancamento().getId());
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
    public void update(Rateio rateio) throws Exception {
        try {
            String SQL = "UPDATE Rateio SET valor = ?, pago = ?"+""
                       +" WHERE id=? AND id_pessoa = ? AND id_lancamento = ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setDouble(1, rateio.getValor());
            ps.setBoolean(2, rateio.isPago());
            ps.setLong(3, rateio.getId());
            ps.setLong(4, rateio.getPessoa().getId());
            ps.setLong(5, rateio.getLancamento().getId());
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
    public Rateio getById(Long id) throws Exception {
        try{
            String SQL = "SELECT r.valor, r.pago, r.id_lancamento,  "+
                    " l.id, l.descricao, l.tipoLancamento, l.dataVencimento, l.periodicidade, l.valor, l.aprovado, l.id_republica"+
                    " p.id, , p.nome, p.apelido, p.telefone, p.cpf, p.linkRedeSocial, p.telefoneResponsavel1, p.telefoneResponsavel2, p.estado, p.id_republica"+
                    " FROM Rateio r INNER JOIN Pessoa p ON p.id = r.id_pessoa INNER JOIN Lancamento l ON l.id = r.id_lancamento"+
                    " WHERE r.id=?; ";
           
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            
            
            Rateio rateio = new Rateio();
            Pessoa morador = new Pessoa();
            Lancamento lancamento = new Lancamento();
            while (rs.next()) {
                rateio.setValor(rs.getLong(1));
                rateio.setPago(rs.getBoolean(2));
                
                lancamento.setId(rs.getLong(3));
                lancamento.setDataVencimento(rs.getDate(4).toLocalDate());
                lancamento.setTipoLancamento(TipoLancamento.valueOf(rs.getString(5)));
                lancamento.setDataVencimento(rs.getDate(6).toLocalDate());
                lancamento.setPeriodicidade(Periodicidade.valueOf(rs.getString(7)));
                lancamento.setValor(rs.getDouble(8));
                lancamento.setAprovado(rs.getBoolean(9));
                
                morador.setId(rs.getLong(10));
                morador.setNome(rs.getString(11));
                morador.setApelido(rs.getString(12));
                morador.setTelefone(rs.getString(13));
                morador.setCPF(rs.getString(14));
                morador.setLinkRedeSocial(rs.getString(15));
                morador.setTelefoneResponsavel1(rs.getString(16));
                morador.setTelefoneResponsavel2(rs.getString(17));
                morador.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(18)));
                
                rateio.setLancamento(lancamento);
                rateio.setPessoa(morador);
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return rateio;
            
        }catch(Exception ex){
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public List<Rateio> getByLancamento(Long idLancamento) throws Exception {
        try{
            String SQL = "SELECT r.valor, r.pago, r.id_lancamento,  "+
                    " l.id, l.descricao, l.tipoLancamento, l.dataVencimento, l.periodicidade, l.valor, l.aprovado, l.id_republica"+
                    " p.id, , p.nome, p.apelido, p.telefone, p.cpf, p.linkRedeSocial, p.telefoneResponsavel1, p.telefoneResponsavel2, p.estado, p.id_republica"+
                    " FROM Rateio r INNER JOIN Pessoa p ON p.id = r.id_pessoa INNER JOIN Lancamento l ON l.id = r.id_lancamento"+
                    " WHERE l.id=?; ";
           
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idLancamento);
            ResultSet rs = ps.executeQuery();
            
            List<Rateio> rateios = new ArrayList<>();
            
            Rateio rateio = new Rateio();
            Pessoa morador = new Pessoa();
            Lancamento lancamento = new Lancamento();
            while (rs.next()) {
                rateio.setValor(rs.getLong(1));
                rateio.setPago(rs.getBoolean(2));
                
                lancamento.setId(rs.getLong(3));
                lancamento.setDataVencimento(rs.getDate(4).toLocalDate());
                lancamento.setTipoLancamento(TipoLancamento.valueOf(rs.getString(5)));
                lancamento.setDataVencimento(rs.getDate(6).toLocalDate());
                lancamento.setPeriodicidade(Periodicidade.valueOf(rs.getString(7)));
                lancamento.setValor(rs.getDouble(8));
                lancamento.setAprovado(rs.getBoolean(9));
                
                morador.setId(rs.getLong(10));
                morador.setNome(rs.getString(11));
                morador.setApelido(rs.getString(12));
                morador.setTelefone(rs.getString(13));
                morador.setCPF(rs.getString(14));
                morador.setLinkRedeSocial(rs.getString(15));
                morador.setTelefoneResponsavel1(rs.getString(16));
                morador.setTelefoneResponsavel2(rs.getString(17));
                morador.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(18)));
                
                rateio.setLancamento(lancamento);
                rateio.setPessoa(morador);
                
                rateios.add(rateio);
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return rateios;
            
        }catch(Exception ex){
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public List<Rateio> getByModador(Long idMorador) throws Exception {
        try{
            String SQL = "SELECT r.valor, r.pago, r.id_lancamento,  "+
                    " l.id, l.descricao, l.tipoLancamento, l.dataVencimento, l.periodicidade, l.valor, l.aprovado, l.id_republica"+
                    " p.id, , p.nome, p.apelido, p.telefone, p.cpf, p.linkRedeSocial, p.telefoneResponsavel1, p.telefoneResponsavel2, p.estado, p.id_republica"+
                    " FROM Rateio r INNER JOIN Pessoa p ON p.id = r.id_pessoa INNER JOIN Lancamento l ON l.id = r.id_lancamento"+
                    " WHERE p.id=?; ";
           
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idMorador);
            ResultSet rs = ps.executeQuery();
            
            List<Rateio> rateios = new ArrayList<>();
            
            Rateio rateio = new Rateio();
            Pessoa morador = new Pessoa();
            Lancamento lancamento = new Lancamento();
            while (rs.next()) {
                rateio.setValor(rs.getLong(1));
                rateio.setPago(rs.getBoolean(2));
                
                lancamento.setId(rs.getLong(3));
                lancamento.setDataVencimento(rs.getDate(4).toLocalDate());
                lancamento.setTipoLancamento(TipoLancamento.valueOf(rs.getString(5)));
                lancamento.setDataVencimento(rs.getDate(6).toLocalDate());
                lancamento.setPeriodicidade(Periodicidade.valueOf(rs.getString(7)));
                lancamento.setValor(rs.getDouble(8));
                lancamento.setAprovado(rs.getBoolean(9));
                
                morador.setId(rs.getLong(10));
                morador.setNome(rs.getString(11));
                morador.setApelido(rs.getString(12));
                morador.setTelefone(rs.getString(13));
                morador.setCPF(rs.getString(14));
                morador.setLinkRedeSocial(rs.getString(15));
                morador.setTelefoneResponsavel1(rs.getString(16));
                morador.setTelefoneResponsavel2(rs.getString(17));
                morador.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(18)));
                
                rateio.setLancamento(lancamento);
                rateio.setPessoa(morador);
                
                rateios.add(rateio);
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
           return rateios;
            
        }catch(Exception ex){
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }
    
}

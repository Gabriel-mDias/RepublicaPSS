package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.dao.interfaces.ILancamentoDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.enums.Periodicidade;
import br.ufes.republica.enums.TipoLancamento;
import br.ufes.republica.models.Lancamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LancamentoDAOSQLite implements ILancamentoDAO {

    private SqliteManager manager;

    public LancamentoDAOSQLite(SqliteManager manager) {
        if (manager == null) {
            throw new RuntimeException("Manager fornecido é inválido");
        }        
        this.manager = manager;
    }
    
    @Override
    public void insert(Lancamento lancamento, Long idRepublica) throws Exception {    //TODO: Foreign Key com Republica?
        try {
            String SQL = "INSERT INTO Lancamento(descricao, tipoLancamento, dataVencimento, periodicidade, valor, aprovado"+
                                        " id_republica ) VALUES(?, ?, ?, ?, ?, ?, ?);";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, lancamento.getDescricao());
            ps.setString(2, lancamento.getTipoLancamento().name());
            ps.setDate(3, Date.valueOf(lancamento.getDataVencimento()));
            ps.setString(4, lancamento.getPeriodicidade().name());
            ps.setDouble(5, lancamento.getValor());
            ps.setBoolean(6, lancamento.isAprovado());
            ps.setLong(7, idRepublica);
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
    public void update(Lancamento lancamento) throws Exception {
        try{
            String SQL = "UPDATE Lancamento SET descricao= ?, tipoLancamento= ?, dataVencimento= ?, periodicidade= ?, valor= ?, aprovado= ?"+
                    " WHERE id = ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, lancamento.getDescricao());
            ps.setString(2, lancamento.getTipoLancamento().name());
            ps.setDate(3, Date.valueOf(lancamento.getDataVencimento()));
            ps.setString(4, lancamento.getPeriodicidade().name());
            ps.setDouble(5, lancamento.getValor());
            ps.setBoolean(6, lancamento.isAprovado());
            ps.setLong(7, lancamento.getId());
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao atualizar");
        }
    }

    @Override
    public List<Lancamento> getByIdRepublica(Long idRepublica) throws Exception {
        List<Lancamento> lancamentosRepublica = new ArrayList<>();
        
        try{
            String SQL = "SELECT l.id, l.descricao, l.tipoLancamento, l.dataVencimento, l.periodicidade, l.valor, l.aprovado, l.id_republica "+
                    " FROM Lancamento l INNER JOIN Republica r ON r.id = l.id_republica WHERE r.id=?";
           
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idRepublica);
            ResultSet rs = ps.executeQuery();
            
            
            Lancamento lancamento = new Lancamento();
            while (rs.next()) {
                lancamento.setId(rs.getLong(1));
                lancamento.setDataVencimento(rs.getDate(2).toLocalDate());
                lancamento.setTipoLancamento(TipoLancamento.valueOf(rs.getString(3)));
                lancamento.setDataVencimento(rs.getDate(4).toLocalDate());
                lancamento.setPeriodicidade(Periodicidade.valueOf(rs.getString(5)));
                lancamento.setValor(rs.getDouble(6));
                lancamento.setAprovado(rs.getBoolean(7));
                
                lancamentosRepublica.add(lancamento);
                lancamento = new Lancamento();
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return lancamentosRepublica;
            
        }catch(Exception ex){
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public Lancamento getById(Long id) throws Exception {
        try{
            String SQL = "SELECT l.id, l.descricao, l.tipoLancamento, l.dataVencimento, l.periodicidade, l.valor, l.aprovado "+
                    " FROM Lancamento l WHERE l.id=?";
           
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            
            
            Lancamento lancamento = new Lancamento();
            while (rs.next()) {
                lancamento.setId(rs.getLong(1));
                lancamento.setDataVencimento(rs.getDate(2).toLocalDate());
                lancamento.setTipoLancamento(TipoLancamento.valueOf(rs.getString(3)));
                lancamento.setDataVencimento(rs.getDate(4).toLocalDate());
                lancamento.setPeriodicidade(Periodicidade.valueOf(rs.getString(5)));
                lancamento.setValor(rs.getDouble(6));
                lancamento.setAprovado(rs.getBoolean(7));
                
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return lancamento;
        }catch(Exception ex){
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }
    
}

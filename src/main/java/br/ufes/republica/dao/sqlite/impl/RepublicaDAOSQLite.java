package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.collection.EstadoPessoaCollection;
import br.ufes.republica.collection.EstadoRepublicaCollection;
import br.ufes.republica.dao.interfaces.IRepublicaDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.models.Endereco;
import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepublicaDAOSQLite implements IRepublicaDAO {

    private SqliteManager manager;

    public RepublicaDAOSQLite(SqliteManager manager) {
        if (manager == null) {
            throw new RuntimeException("Manager fornecido é inválido");
        }
        
        this.manager = manager;
    }
    
    
    
    @Override
    public void insert(Republica republica) throws Exception {
        
        try {
            String SQL = "INSERT INTO Endereco(logradouro, cep, bairro, cidade, uf, pontoReferencia, localizacaoGeografica) " + 
                                        "VALUES(?,?,?,?,?,?,?);";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, republica.getEndereco().getLogradouro());
            ps.setString(2, republica.getEndereco().getCep());
            ps.setString(3, republica.getEndereco().getBairro());
            ps.setString(4, republica.getEndereco().getCidade());
            ps.setString(5, republica.getEndereco().getUf());
            ps.setString(6, republica.getEndereco().getPontoReferencia());
            ps.setString(7, republica.getEndereco().getLocalizacaoGeografica());
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
        
        try {
            String SQL = "SELECT MAX(id) FROM Endereco;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                republica.getEndereco().setId(rs.getLong(1));
            }

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
        
        try {
            String SQL = "INSERT INTO Republica(nome, vantagens, estatuto, dataFundacao, id_endereco, numeroTotalVagas, estado, id_representante, despesaMediaMorador ) " + 
                                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, republica.getNome());
            ps.setString(2, republica.getVantagens());
            ps.setString(3, republica.getEstatuto());
            ps.setDate(4, Date.valueOf(republica.getDataFundacao()));
            ps.setLong(5, republica.getEndereco().getId());
            ps.setLong(6, republica.getNumeroTotalVagas());
            ps.setString(7, "EstadoDisponivel");
            ps.setLong(8, republica.getRepresentante().getId());
            ps.setDouble(9, republica.getDespesaMediaMorador());
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
        
        try {
            String SQL = "SELECT MAX(id) FROM Republica;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                republica.setId(rs.getLong(1));
            }

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar o Id da Republica inserida");
        }
    }

    @Override
    public void update(Republica republica) throws Exception {
        try {
            String SQL = "UPDATE Republica SET nome = ?, vantagens = ?, estatuto = ?, dataFundacao = ?,"+
                    " dataExtincao = ?, id_endereco = ?, numeroTotalVagas = ?, estado = ?, despesaMediaMorador = ? WHERE id = ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, republica.getNome());
            ps.setString(2, republica.getVantagens());
            ps.setString(3, republica.getEstatuto());
            ps.setDate(4, Date.valueOf(republica.getDataFundacao()));
            ps.setDate(5, Date.valueOf(republica.getDataExtincao()));
            ps.setLong(6, republica.getEndereco().getId());
            ps.setLong(7, republica.getNumeroTotalVagas());
            ps.setString(8, republica.getEstado().toString());
            ps.setDouble(9, republica.getDespesaMediaMorador());
            ps.setDouble(10, republica.getId());
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
    public void delete(Long id) throws Exception {
        try {
            String SQL = "UPDATE Republica SET estado = ? WHERE id = ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, "EstadoExtincao");  //De acordo com a regra de negócio
            ps.setLong(2, id);
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
    public Republica getById(Long id) throws Exception {
        try {
            String SQL = "SELECT r.nome, r.vantagens, r.estatuto, r.dataFundacao, r.dataExtincao, r.numeroTotalVagas, r.estado, r.despesaMediaMorador, "+
                    " pRep.id, pRep.nome, pRep.apelido, pRep.telefone, pRep.cpf, pRep.linkRedeSocial, pRep.telefoneResponsavel1, pRep.telefoneResponsavel2, pRep.estado, "+
                    " e.id, e.logradouro, e.cep, e.bairro, e.cidade, e.uf, e.pontoReferencia, e.localizacaoGeografica "+
                    " FROM Republica r INNER JOIN Pessoa pRep ON r.id_representante = pRep.id AND r.id = pRep.id_republica "+
                    " INNER JOIN Endereco e ON r.id_endereco = e.id WHERE r.id = ? AND r.estado <> ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ps.setString(2, "EstadoExtincao");
            ResultSet rs = ps.executeQuery();
            
            Republica republica = new Republica();
            Pessoa representante = new Pessoa();
            Endereco endereco = new Endereco();
            
            while (rs.next()) {
                republica.setId(id);
                republica.setNome(rs.getString(1));
                republica.setVantagens(rs.getString(2));
                republica.setEstatuto(rs.getString(3));
                republica.setDataFundacao(rs.getDate(4).toLocalDate());
                republica.setDataExtincao(rs.getDate(5).toLocalDate());
                republica.setNumeroTotalVagas(rs.getInt(6));
                republica.setEstado(EstadoRepublicaCollection.getInstancia().cria(rs.getString(7)));
                republica.setDespesaMediaMorador(rs.getDouble(8));
                
                representante.setId(rs.getLong(9));
                representante.setNome(rs.getString(10));
                representante.setApelido(rs.getString(11));
                representante.setTelefone(rs.getString(12));
                representante.setCPF(rs.getString(13));
                representante.setLinkRedeSocial(rs.getString(14));
                representante.setTelefoneResponsavel1(rs.getString(15));
                representante.setTelefoneResponsavel2(rs.getString(16));
                representante.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(17)));
                
                endereco.setId(rs.getLong(18));
                endereco.setLogradouro(rs.getString(19));
                endereco.setCep(rs.getString(20));
                endereco.setBairro(rs.getString(21));
                endereco.setCidade(rs.getString(22));
                endereco.setUf(rs.getString(23));
                endereco.setPontoReferencia(rs.getString(24));
                endereco.setLocalizacaoGeografica(rs.getString(25));
                
                republica.setRepresentante(representante);
                republica.setEndereco(endereco);
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return republica;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public Republica getByIdMorador(Long idPessoa) throws Exception {
        try {
            String SQL = "SELECT r.nome, r.vantagens, r.estatuto, r.dataFundacao, r.dataExtincao, r.numeroTotalVagas, r.estado, r.despesaMediaMorador, r.id,"+
                    "  pRep.nome, pRep.apelido, pRep.telefone, pRep.cpf, pRep.linkRedeSocial, pRep.telefoneResponsavel1, pRep.telefoneResponsavel2, pRep.estado, "+
                    " e.id, e.logradouro, e.cep, e.bairro, e.cidade, e.uf, e.pontoReferencia, e.localizacaoGeografica "+
                    " FROM Republica r INNER JOIN Pessoa p ON r.id = p.id_republica "+
                    " INNER JOIN Pessoa pRep ON r.id_representante = pRep.id AND r.id = pRep.id_republica"+
                    " INNER JOIN Endereco e ON r.id_endereco = e.id WHERE p.id = ? AND r.estado <> ?;";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idPessoa);
            ps.setString(2, "EstadoExtincao");
            ResultSet rs = ps.executeQuery();
            
            Republica republica = new Republica();
            Pessoa representante = new Pessoa();
            Endereco endereco = new Endereco();
            
            while (rs.next()) {
                republica.setNome(rs.getString(1));
                republica.setVantagens(rs.getString(2));
                republica.setEstatuto(rs.getString(3));
                republica.setDataFundacao(rs.getDate(4).toLocalDate());
                republica.setDataExtincao(rs.getDate(5).toLocalDate());
                republica.setNumeroTotalVagas(rs.getInt(6));
                republica.setEstado(EstadoRepublicaCollection.getInstancia().cria(rs.getString(7)));
                republica.setDespesaMediaMorador(rs.getDouble(8));
                republica.setId(rs.getLong(9));
                
                representante.setNome(rs.getString(10));
                representante.setApelido(rs.getString(11));
                representante.setTelefone(rs.getString(12));
                representante.setCPF(rs.getString(13));
                representante.setLinkRedeSocial(rs.getString(14));
                representante.setTelefoneResponsavel1(rs.getString(15));
                representante.setTelefoneResponsavel2(rs.getString(16));
                representante.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(17)));
                
                endereco.setId(rs.getLong(18));
                endereco.setLogradouro(rs.getString(19));
                endereco.setCep(rs.getString(20));
                endereco.setBairro(rs.getString(21));
                endereco.setCidade(rs.getString(22));
                endereco.setUf(rs.getString(23));
                endereco.setPontoReferencia(rs.getString(24));
                endereco.setLocalizacaoGeografica(rs.getString(25));
                
                republica.setRepresentante(representante);
                republica.setEndereco(endereco);
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return republica;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public List<Republica> getByVagasDisponiveis() throws Exception {
        
        List<Republica> republicasDisponiveis = new ArrayList<>();
        
        try {
            String SQL = "SELECT r.nome, r.vantagens, r.estatuto, r.dataFundacao, r.dataExtincao, r.numeroTotalVagas, r.estado, r.despesaMediaMorador, "+
                    " pRep.id, pRep.nome, pRep.apelido, pRep.telefone, pRep.cpf, pRep.linkRedeSocial, pRep.telefoneResponsavel1, pRep.telefoneResponsavel2, pRep.estado, "+
                    " e.id, e.logradouro, e.cep, e.bairro, e.cidade, e.uf, e.pontoReferencia, e.localizacaoGeografica, "+
                    " r.id "+
                    " FROM Republica r INNER JOIN Pessoa pRep ON r.id_representante = pRep.id AND r.id = pRep.id_republica "+
                    " INNER JOIN Endereco e ON r.id_endereco = e.id WHERE r.estado <> ? "+
                    " AND r.numTotalVagas > (SELECT COUNT(morador) FROM Pessoa morador WHERE morador.id_republica = r.id);";
            
            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, "EstadoExtincao");
            ResultSet rs = ps.executeQuery();
            
            Republica republica = new Republica();
            Pessoa representante = new Pessoa();
            Endereco endereco = new Endereco();
            
            while (rs.next()) {
                republica.setId(rs.getLong(26));
                republica.setNome(rs.getString(1));
                republica.setVantagens(rs.getString(2));
                republica.setEstatuto(rs.getString(3));
                republica.setDataFundacao(rs.getDate(4).toLocalDate());
                republica.setDataExtincao(rs.getDate(5).toLocalDate());
                republica.setNumeroTotalVagas(rs.getInt(6));
                republica.setEstado(EstadoRepublicaCollection.getInstancia().cria(rs.getString(7)));
                republica.setDespesaMediaMorador(rs.getDouble(8));
                
                representante.setId(rs.getLong(9));
                representante.setNome(rs.getString(10));
                representante.setApelido(rs.getString(11));
                representante.setTelefone(rs.getString(12));
                representante.setCPF(rs.getString(13));
                representante.setLinkRedeSocial(rs.getString(14));
                representante.setTelefoneResponsavel1(rs.getString(15));
                representante.setTelefoneResponsavel2(rs.getString(16));
                representante.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(17)));
                
                endereco.setId(rs.getLong(18));
                endereco.setLogradouro(rs.getString(19));
                endereco.setCep(rs.getString(20));
                endereco.setBairro(rs.getString(21));
                endereco.setCidade(rs.getString(22));
                endereco.setUf(rs.getString(23));
                endereco.setPontoReferencia(rs.getString(24));
                endereco.setLocalizacaoGeografica(rs.getString(25));
                
                republica.setRepresentante(representante);
                republica.setEndereco(endereco);
                
                republicasDisponiveis.add(republica);
                republica = new Republica();
            }
            
            this.manager.fechaTransacao();
            this.manager.close();
            
            return republicasDisponiveis;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }
    
    
    
}
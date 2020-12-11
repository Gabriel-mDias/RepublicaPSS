package br.ufes.republica.business;

import br.ufes.republica.dao.collection.PessoaDAOCollection;
import br.ufes.republica.dao.interfaces.IPessoaDAO;
import br.ufes.republica.exception.BusinessException;
import br.ufes.republica.models.Pessoa;
import java.util.List;

public class PessoaBusiness {

    private IPessoaDAO pessoaDAO;

    public PessoaBusiness() {
        this.pessoaDAO = PessoaDAOCollection.getInstancia().cria(System.getProperty("db.name"));
    }

    public Pessoa insert(Pessoa p) throws Exception {
        validate(p);
        return pessoaDAO.insert(p);
    }

    public void update(Pessoa p) throws Exception {
        validate(p);
        if (p.getId() == null) {
            throw new BusinessException("ID da Pessoa informada é inválida!");
        }
        pessoaDAO.update(p);
    }

    public void updateRepublica(Pessoa p) throws Exception {
        if (p == null) {
            throw new BusinessException("Pessoa informada é inválida!");
        } else if (p.getId() == null) {
            throw new BusinessException("ID da Pessoa informada é inválida!");
        }

        pessoaDAO.updateRepublica(p);
    }

    public Pessoa getById(Long id) throws Exception {
        if (id == null) {
            throw new BusinessException("ID da Pessoa informada é inválida!");
        }

        return pessoaDAO.getById(id);
    }

    public List<Pessoa> getByIdRepublica(Long idRepublica) throws Exception {
        if (idRepublica == null) {
            throw new BusinessException("ID da República informada é inválida!");
        }

        return pessoaDAO.getByIdRepublica(idRepublica);
    }
    
    public void delete(Long id) throws Exception {
        if(id == null) {
            throw new BusinessException("ID da República informada é inválida");
        }
        pessoaDAO.delete(id);
    }

    private void validate(Pessoa pessoa) throws Exception {
        if (pessoa == null) {
            throw new BusinessException("Pessoa informada é inválida!");
        }
        if (pessoa.getNome() == null || pessoa.getNome().isBlank()) {
            throw new BusinessException("Nome da pessoa não informado!");
        }
        if (pessoa.getApelido() == null || pessoa.getApelido().isBlank()) {
            throw new BusinessException("Apelido da pessoa não informado!");
        }
        if (pessoa.getTelefone() == null || pessoa.getTelefone().isBlank() || pessoa.getTelefone().equals("(  )      -    ")) {
            throw new BusinessException("Telefone da pessoa não informado!");
        }
        if (pessoa.getCPF() == null || pessoa.getCPF().isBlank() || pessoa.getCPF().equals("   .   .   -  ")) {
            throw new BusinessException("CPF da pessoa não informado!");
        }
        if (pessoa.getEstado() == null) {
            throw new BusinessException("Estado da pessoa não informado!");
        }
    }
}

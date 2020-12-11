package br.ufes.republica.business;

import br.ufes.republica.dao.interfaces.IUsuarioDAO;
import br.ufes.republica.exception.BusinessException;
import br.ufes.republica.models.Usuario;

public class UsuarioBusiness {
    
    private IUsuarioDAO usuarioDAO;
    
    public UsuarioBusiness(IUsuarioDAO usuarioDAO) {
        if (usuarioDAO == null) {
            throw new RuntimeException("DAO fornecida é inválida");
        }
        
        this.usuarioDAO = usuarioDAO;
    }
    
    public void insert(Usuario usuario, Long idPessoa) throws Exception {
        if (usuario == null) {
            throw new BusinessException("Usuário fornecido é inválido");
        } else {
            if (usuario.getId() != null) {
                throw new BusinessException("Usuário para inserção não pode ter ID preenchido");
            }
            
            if (usuario.getLogin() == null || usuario.getLogin().isBlank()) {
                throw new BusinessException("Login fornecido é inválido");
            }
            
            // TODO: Adicionar validador de senha
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                throw new BusinessException("Senha fornecida é inválida");
            }
        }
        
        if (idPessoa == null) {
            throw new BusinessException("ID da pessoa fornecida é inválido");
        }
        
        usuarioDAO.insert(usuario, idPessoa);
    }
    
    public void update(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new BusinessException("Usuário fornecido é inválido");
        } else {
            if (usuario.getId() == null) {
                throw new BusinessException("Usuário para atualização deve ter o ID preenchido");
            }
            
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                throw new BusinessException("Senha fornecida é inválida");
            }
        }
        
        usuarioDAO.update(usuario);
    }
    
    public Usuario getByLogin(String login) throws Exception {
        if (login == null || login.isBlank()) {
            throw new BusinessException("Login fornecido é inválido");
        }
        
        return usuarioDAO.getByLogin(login);
    }
    
    public Usuario getByIdPessoa(Long idPessoa) throws Exception {
        if (idPessoa == null) {
            throw new BusinessException("ID da pessoa fornecida é inválido");
        }
        
        return usuarioDAO.getByIdPessoa(idPessoa);
    }
    
    public void delete(Long id) throws Exception {
        if (id == null) {
            throw new BusinessException("ID fornecido é inválido");
        }
        
        usuarioDAO.delete(id);
    }
    
    public boolean loginExists(String login) throws Exception {
        if (login == null || login.isBlank()) {
            throw new BusinessException("Login fornecido é inválido");
        }
        
        return usuarioDAO.loginExists(login);
    }
    
}

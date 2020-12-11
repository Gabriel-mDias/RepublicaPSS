package br.ufes.republica.models;

public class Usuario {

    private Long id;
    private String login;
    private String senha;
    private Pessoa pessoa;
    private boolean excluido;
    
    public Usuario() {
        this.pessoa = new Pessoa();
    }

    public Usuario(Long id, String login, String senha, Pessoa pessoa) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.pessoa = pessoa;
        this.excluido = false;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

}

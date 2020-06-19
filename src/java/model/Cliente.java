package model;

/**
 *
 * @author caigo
 */
public class Cliente {
    private int idade, id;
    private String nome, telefone, email;

    public Cliente() {
    }

    public Cliente(int idade, String nome, String telefone, String email) {
        this.idade = idade;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}

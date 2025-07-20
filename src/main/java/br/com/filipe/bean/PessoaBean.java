package br.com.filipe.bean;

import br.com.filipe.model.Pessoa;
import br.com.filipe.service.PessoaService;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PessoaBean implements Serializable {
    private Pessoa pessoa = new Pessoa();
    @EJB
    private PessoaService service;

    public void salvar() {
        service.salvar(pessoa);
        pessoa = new Pessoa();
    }

    public void remover(Pessoa p) {
        service.remover(p);
    }

    public List<Pessoa> getPessoas() {
        return service.listar();
    }

    public Pessoa getPessoa() { return pessoa; }
    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
}
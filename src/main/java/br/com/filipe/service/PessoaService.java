package br.com.filipe.service;

import br.com.filipe.model.Pessoa;
import br.com.filipe.repository.PessoaRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class PessoaService {
    @EJB
    private PessoaRepository repo;

    public void salvar(Pessoa pessoa) {
        repo.salvar(pessoa);
    }

    public List<Pessoa> listar() {
        return repo.listar();
    }

    public void remover(Pessoa pessoa) {
        repo.remover(pessoa);
    }
}
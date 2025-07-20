package br.com.filipe.repository;

import br.com.filipe.model.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class PessoaRepository {
    @PersistenceContext
    private EntityManager em;

    public void salvar(Pessoa pessoa) {
        if (pessoa.getId() == null) em.persist(pessoa);
        else em.merge(pessoa);
    }

    public List<Pessoa> listar() {
        return em.createQuery("from Pessoa", Pessoa.class).getResultList();
    }

    public void remover(Pessoa pessoa) {
        Pessoa p = em.merge(pessoa);
        em.remove(p);
    }
}
package com.spring.crudpessoa.service;

import com.spring.crudpessoa.model.Pessoa;
import com.spring.crudpessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    /*
    Aqui de fato temos os metodos do nosso CRUD
    C - Create
    R - Read
    U - Update
    D - Delete
    */

    //METODO QUE CRIA OU ATUALIZA UM OBJETO PESSOA
    //Mesmo a funcao sendo chamada 'save' o JPA eh capaz de saber se estamos atualizando ou criando uma nova Pessoa
    @Transactional(readOnly = false)
    public void salvar(Pessoa pessoa){
        repository.save(pessoa);
    }

    //METODO PARA LISTAR AS PESSOAS CADASTRADAS
    @Transactional(readOnly = true)
    public List<Pessoa> listar(){
        return repository.findAll();
    }

    //METODO PARA BUSCAR PELO 'ID' UMA PESSOA CADASTRADA
    @Transactional(readOnly = true)
    public Pessoa buscarPorId(Long id){
        return repository.findById(id).get();
    }

    //METODO PARA REALIZAR O DELETE DE UMA PESSOA
    @Transactional(readOnly = false)
    public void excluir(Pessoa pessoa){
        repository.delete(pessoa);
    }
}

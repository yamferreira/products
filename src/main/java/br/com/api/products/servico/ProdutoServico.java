package br.com.api.products.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.products.modelo.ProdutoModelo;
import br.com.api.products.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio pr;

    public  Iterable<ProdutoModelo> listar () {
        return pr.findAll();
    }

}

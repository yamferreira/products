package br.com.api.products.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.products.modelo.ProdutoModelo;
import br.com.api.products.modelo.RespostaModelo;
import br.com.api.products.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    public  Iterable<ProdutoModelo> listar () {
        return pr.findAll();
        
    }

    public ResponseEntity<?> cadastrarAlterar (ProdutoModelo pm, String acao) {

        if(pm.getNome().equals("")) {
            rm.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if (pm.getMarca().equals("")) {
            rm.setMensagem("O nome da marca é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
            
        }else{
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
            }
        }
    } 

    public ResponseEntity<RespostaModelo> remover(long codigo) {
        
        pr.deleteById(codigo);

        rm.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }

}

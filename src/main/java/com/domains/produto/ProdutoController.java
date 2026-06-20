package com.domains.produto;
import com.domains.*;

import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

//import jakarta.persistence.*;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.net.URI;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?>cadastrarProduto(@RequestBody @Valid ProdutoRequest produtoRequest, UriComponentsBuilder uriBuilder){
        Produto produto= produtoRequest.toModelo();
        entityManager.persist(produto);
        URI uri=uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoResponse(produto));
    }
}
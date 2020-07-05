package io.github.yasminsouza.repository;

import io.github.yasminsouza.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByDescricaoLikeOrPrecoLike(String descricao, BigDecimal preco);
}

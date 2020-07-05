package io.github.yasminsouza.service;

import io.github.yasminsouza.dto.InformacoesPedidoDTO;
import io.github.yasminsouza.dto.PedidoDTO;
import io.github.yasminsouza.enums.StatusPedido;
import io.github.yasminsouza.model.Pedido;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    InformacoesPedidoDTO obterPedido(Integer codPedido);

    void atualizarStatusPedido(Integer id, StatusPedido statusPedido);
}

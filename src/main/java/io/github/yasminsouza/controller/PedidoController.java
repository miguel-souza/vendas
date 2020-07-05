package io.github.yasminsouza.controller;

import io.github.yasminsouza.dto.AtualizacaoStatusPedidoDTO;
import io.github.yasminsouza.dto.InformacoesPedidoDTO;
import io.github.yasminsouza.dto.PedidoDTO;
import io.github.yasminsouza.enums.StatusPedido;
import io.github.yasminsouza.model.Pedido;
import io.github.yasminsouza.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Integer save(@RequestBody PedidoDTO pedidoDTO){
        Pedido pedido = pedidoService.salvar(pedidoDTO);
        return pedido.getId();
    }

    @GetMapping("/{id}")
    public InformacoesPedidoDTO obterPedido(@PathVariable Integer id){
        return pedidoService.obterPedido(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarStatus(@PathVariable Integer id, @RequestBody AtualizacaoStatusPedidoDTO dto){
        pedidoService.atualizarStatusPedido(id, StatusPedido.valueOf(dto.getNovoStatus()));
    }
}

package io.github.yasminsouza.dto;

import io.github.yasminsouza.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesPedidoDTO {
    private Integer id;
    private String cliente;
    private LocalDate data;
    private StatusPedido status;
    private BigDecimal total;
    private List<InformacoesItemPedidoDTO> itens;
}

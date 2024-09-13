package br.com.mvc.projectmvc.dto;

import java.math.BigDecimal;

import br.com.mvc.projectmvc.enuns.StatusPedidos;
import br.com.mvc.projectmvc.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;
    private BigDecimal valorNegociado;
    private LocalDate dataEntrega;
    private StatusPedidos status;
    private LocalDate dataPedido;

    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setDescricao(descricao);
        pedido.setStatus(status);
        pedido.setValorNegociado(valorNegociado);
        pedido.setDataEntrega(dataEntrega);
        pedido.setDataPedido(dataPedido);
        return pedido;
    }
}

package br.com.mvc.projectmvc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.mvc.projectmvc.enuns.StatusPedidos;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;
    private LocalDate dataPedido;

    @Enumerated(EnumType.STRING)
    private StatusPedidos status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    

    public void setUser(User user){
        this.user = user;
    }

}


package br.com.mvc.projectmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.projectmvc.dto.PedidoDto;
import br.com.mvc.projectmvc.enuns.StatusPedidos;
import br.com.mvc.projectmvc.model.Pedido;
import br.com.mvc.projectmvc.model.User;
import br.com.mvc.projectmvc.repository.PedidoRepository;
import br.com.mvc.projectmvc.repository.UserRepository;
import jakarta.validation.Valid;
import java.time.LocalDate;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/pedido")  // Alterado para singular e adicionado '/'
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/formulario")  // Adicionado '/'
    public String formulario(Model model) {
        model.addAttribute("pedidoDto", new PedidoDto());
        return "pedido/formulario";  // Alterado para singular
    }

    @PostMapping("/novo")
    public String novoPedido(@Valid PedidoDto pedidoDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "pedido/formulario";
        }
        
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        Pedido pedido = pedidoDto.toPedido();
        pedido.setUser(user);
        pedido.setStatus(StatusPedidos.AGUARDANDO);
        pedido.setDataPedido(LocalDate.now()); // Define a data do pedido como a data atual
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }

    @PostMapping("/deletar/{id}")
    public String deletarPedido(@PathVariable Long id){
        pedidoRepository.deleteById(id);
        return "redirect:/home";
    }
}

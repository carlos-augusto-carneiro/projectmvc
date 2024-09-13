package br.com.mvc.projectmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import br.com.mvc.projectmvc.model.Pedido;
import br.com.mvc.projectmvc.model.User;
import br.com.mvc.projectmvc.repository.PedidoRepository;
import br.com.mvc.projectmvc.repository.UserRepository;

@Controller
public class HomeController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println("Usuário autenticado: " + username);
        
        User user = userRepository.findByUsername(username);
        
        if (user != null) {
            List<Pedido> pedidos = pedidoRepository.findByUserId(user.getId());
            model.addAttribute("pedidos", pedidos);
            model.addAttribute("user", user);
            System.out.println("Número de pedidos encontrados: " + (pedidos != null ? pedidos.size() : 0));
        } else {
            model.addAttribute("errorMessage", "Usuário não encontrado");
        }
        
        return "home";
    }
}

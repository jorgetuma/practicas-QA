package com.jorgetuma.practica_2.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class appController {

    @GetMapping("/")
    public String index() {
        return "redirect:login";
    }

    @GetMapping("login")
    public String login() {
        return "/login";
    }

    @GetMapping("contacto")
    public String contacto() {
        return "/contacto";
    }

    @PostMapping("auth")
    public String auth(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("Usuario:"+username);
        System.out.println("Contraseña:"+password);
        return "redirect:contacto";
    }

    @PostMapping("enviar")
    public String enviarContacto(@RequestParam("nombre") String nombre, @RequestParam("email") String email, @RequestParam("mensaje") String mensaje, Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("email", email);
        model.addAttribute("mensaje", mensaje);
        return "/ver-mensaje";
    }
}

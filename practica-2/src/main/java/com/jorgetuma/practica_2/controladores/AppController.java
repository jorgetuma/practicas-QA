package com.jorgetuma.practica_2.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AppController {

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
        if(username.equals("admin") && password.equals("admin") || username.equals("jt") && password.equals("jt")) {
            return "redirect:contacto";
        }
        return "redirect:error-login";
    }

    @PostMapping("enviar")
    public String enviarContacto(@RequestParam("nombre") String nombre, @RequestParam("email") String email, @RequestParam("mensaje") String mensaje, Model model) {
        if(nombre.isBlank() || email.isBlank() || mensaje.isBlank()) {
            return "redirect:error-contacto";
        }
        model.addAttribute("nombre", nombre);
        model.addAttribute("email", email);
        model.addAttribute("mensaje", mensaje);
        return "/ver-mensaje";
    }

    @GetMapping("error-login")
    public String errorLogin(Model model) {
        model.addAttribute("titulo", "Error al iniciar sesión");
        model.addAttribute("mensaje", "Usuario no encontrado. Nombre de usuario o contraseña incorrecta");
        model.addAttribute("boton","volver a intentarlo");
        model.addAttribute("link", "/login");
        return "/error";
    }

    @GetMapping("error-contacto")
    public String errorContacto(Model model) {
        model.addAttribute("titulo", "Error en formulario");
        model.addAttribute("mensaje", "Algunas de los campos del formularios se encuentran vacios");
        model.addAttribute("boton","volver al formulario de contacto");
        model.addAttribute("link", "/contacto");
        return "/error";
    }
}

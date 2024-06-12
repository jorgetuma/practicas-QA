package com.jorgetuma.practica_2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContactoTest extends PlaywrightIT {
    @LocalServerPort
    private int port;
    private String APIUrl = "/contacto";

    /*Probar que la petición a la ruta "/login responde correctamente"*/
    @Test
    void testRespuestaPeticion() {
        assertThat(page.request().get("http://localhost:" + port + APIUrl)).isOK();
    }

    /*Asegurar que la vista se renderiza correctamente. Donde todos sus elmentos sean visibles*/
    @Test
    void testVistaContacto() {
        page.navigate("http://localhost:" + port + APIUrl);
        assertThat(page).hasTitle("Formulario de Contacto");
        assertThat(page.getByText("Nombre")).isVisible();
        assertThat(page.getByText("Correo Electrónico")).isVisible();
        assertThat(page.getByText("Mensaje")).isVisible();
        assertThat(page.getByPlaceholder("Ingrese su nombre")).isVisible();
        assertThat(page.getByPlaceholder("Ingrese su correo electrónico")).isVisible();
        assertThat(page.getByPlaceholder("Ingrese su mensaje")).isVisible();
        assertThat(page.getByText("Enviar")).isVisible();
        assertThat(page).hasURL("http://localhost:" + port + APIUrl);
    }

    /*Probar comportamiento de un formulario valido. Esto es que no hay campos vacios*/
    @Test
    void testFormularioValido() {
        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#nombre", "Jorge Tuma");
        page.fill("#email", "jt@gmail.com");
        page.fill("#mensaje", "Probando Playwright");
        page.click("button[type='submit']");

        assertThat(page).hasURL("http://localhost:" + port + "/enviar");
    }

    /*Probar comportamiento de un formulario valido. Esto es que hay campos vacios*/
    @Test
    void testFormularioinvalido() {
        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#nombre", "");
        page.fill("#email", "jt@gmail.com");
        page.fill("#mensaje", "Probando Playwright");
        page.click("button[type='submit']");

        assertThat(page).hasURL("http://localhost:" + port + "/error-contacto");


        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#nombre", "");
        page.fill("#email", "");
        page.fill("#mensaje", "");
        page.click("button[type='submit']");

        assertThat(page).hasURL("http://localhost:" + port + "/error-contacto");
    }

    /*Probar comportamiento de la pagina de error del formulario de contacto*/
    @Test
    void testPaginaErrorContacto() {
        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#nombre", "");
        page.fill("#email", "");
        page.fill("#mensaje", "");
        page.click("button[type='submit']");

        assertThat(page).hasURL("http://localhost:" + port + "/error-contacto");
        assertThat(page).hasTitle("Error en formulario");
        assertThat(page.getByText("Algunas de los campos del formularios se encuentran vacios")).isVisible();
        assertThat(page.getByText("volver al formulario de contacto")).isVisible();
        page.click("a[id='boton']");
        assertThat(page).hasURL("http://localhost:" + port + "/contacto");
    }
}

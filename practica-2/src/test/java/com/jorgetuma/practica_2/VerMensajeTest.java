package com.jorgetuma.practica_2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class VerMensajeTest extends PlaywrightIT {

    @LocalServerPort
    private int port;
    private String APIUrl = "/enviar";

    /*Simular el envio de un formulario de contacto valido y asegurar que se renderiza la vista para ver dicha info.
    Unica forma en la que se accede a esta vista*/
    @Test
    public void testMensajeRecibido() {
        page.navigate("http://localhost:" + port + "/contacto");
        page.fill("#nombre", "Jorge Tuma");
        page.fill("#email", "jt@gmail.com");
        page.fill("#mensaje", "Probando Playwright");
        page.click("button[type='submit']");

        assertThat(page).hasURL("http://localhost:" + port + "/enviar");
        assertThat(page).hasTitle("Información de Contacto");
        assertThat(page.getByText("Nombre:")).isVisible();
        assertThat(page.getByText("Correo Electrónico:")).isVisible();
        assertThat(page.getByText("Mensaje:")).isVisible();

        assertThat(page.getByText("Jorge Tuma")).isVisible();
        assertThat(page.getByText("jt@gmail.com")).isVisible();
        assertThat(page.getByText("Probando Playwright")).isVisible();
    }

    /*Simular el envio de un formulario de contacto valido y asegurar que se renderiza la vista para ver dicha info.
    Unica forma en la que se accede a esta vista. Esta vez probando que al presionar el boton para volver al formulario este redirecciona a esta vista*/
    @Test
    public void testComportamientoBoton() {
        page.navigate("http://localhost:" + port + "/contacto");
        page.fill("#nombre", "Jorge Tuma");
        page.fill("#email", "jt@gmail.com");
        page.fill("#mensaje", "Probando Playwright");
        page.click("button[type='submit']");

        assertThat(page).hasURL("http://localhost:" + port + "/enviar");
        assertThat(page).hasTitle("Información de Contacto");
        assertThat(page.getByText("Nombre:")).isVisible();
        assertThat(page.getByText("Correo Electrónico:")).isVisible();
        assertThat(page.getByText("Mensaje:")).isVisible();

        assertThat(page.getByText("Jorge Tuma")).isVisible();
        assertThat(page.getByText("jt@gmail.com")).isVisible();
        assertThat(page.getByText("Probando Playwright")).isVisible();

        page.click("button[type='button']");
        assertThat(page).hasURL("http://localhost:" + port + "/contacto");
    }
}

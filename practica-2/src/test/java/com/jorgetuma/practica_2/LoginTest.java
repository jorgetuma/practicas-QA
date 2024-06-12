package com.jorgetuma.practica_2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LoginTest extends PlaywrightIT {

    @LocalServerPort
    private int port;
    private String APIUrl = "/login";

    /*Probar que la petición a la ruta "/login responde correctamente"*/
    @Test
    void testRespuestaPeticion() {
        assertThat(page.request().get("http://localhost:" + port + APIUrl)).isOK();
    }

    /*Asegurar que la vista se renderiza correctamente. Donde todos sus elmentos sean visibles*/
    @Test
    void testVistaLogin() {
        page.navigate("http://localhost:" + port + APIUrl);
        assertThat(page).hasTitle("Inicio de Sesión");
        assertThat(page.getByText("Nombre de Usuario")).isVisible();
        assertThat(page.getByText("Contraseña")).isVisible();
        assertThat(page.getByPlaceholder("Ingrese su nombre de usuario")).isVisible();
        assertThat(page.getByPlaceholder("Ingrese su contraseña")).isVisible();
        assertThat(page.getByText("Iniciar Sesión")).isVisible();
        assertThat(page).hasURL("http://localhost:" + port + APIUrl);
    }

    /*Probar que al acceder a la ruta "/" se redirecciona al login*/
    @Test
    void testIndex() {
        page.navigate("http://localhost:" + port + "/");
        assertThat(page).hasURL("http://localhost:" + port + APIUrl);
    }

    /*Prueba la respuesta y comportamiento del login ante un acceso con credenciales validas.*/
    @Test
    void testLoginCredencialValida() {
        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#username", "admin");
        page.fill("#password", "admin");
        page.click("button[type='submit']");

        // Verifica que se redirecciona correctamente después del inicio de sesión exitoso
        assertThat(page).hasURL("http://localhost:" + port + "/contacto");


        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#username", "jt");
        page.fill("#password", "jt");
        page.click("button[type='submit']");

        // Verifica que se redirecciona correctamente después del inicio de sesión exitoso
        assertThat(page).hasURL("http://localhost:" + port + "/contacto");
    }

    /*Prueba la respuesta y comportamiento del login ante un acceso con credenciales invalidas*/
    @Test
    void testLoginCredencialInvalida() {
        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#username", "admin");
        page.fill("#password", "jt");
        page.click("button[type='submit']");

        // Verifica que se redirecciona correctamente después del inicio de sesión exitoso
        assertThat(page).hasURL("http://localhost:" + port + "/error-login");


        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#username", "");
        page.fill("#password", "");
        page.click("button[type='submit']");

        // Verifica que se redirecciona correctamente después del inicio de sesión exitoso
        assertThat(page).hasURL("http://localhost:" + port + "/error-login");
    }

    /*Probar comportamiento de la pagina de error del login*/
    @Test
    void testPaginaErrorLogin() {
        page.navigate("http://localhost:" + port + APIUrl);
        page.fill("#username", "admin");
        page.fill("#password", "jt");
        page.click("button[type='submit']");

        assertThat(page).hasURL("http://localhost:" + port + "/error-login");
        assertThat(page).hasTitle("Error al iniciar sesión");
        assertThat(page.getByText("Usuario no encontrado. Nombre de usuario o contraseña incorrecta")).isVisible();
        assertThat(page.getByText("volver a intentarlo")).isVisible();
        page.click("a[id='boton']");
        assertThat(page).hasURL("http://localhost:" + port + "/login");
    }
}
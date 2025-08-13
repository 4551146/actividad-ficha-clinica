Feature: Inicio de sesión de médico

    @login
    Scenario: Login exitoso con credenciales válidas
        Given médico está en la página de inicio de sesión
        When ingresa su nombre de usuario "doctor" y contraseña "password" para iniciar sesión 
        Then accede a la ficha clínica donde debería ver el formulario con el título "Registro de Paciente"

    @loginFallido
    Scenario Outline: Login fallido con credenciales inválidas
        Given médico está en la página de inicio de sesión
        When ingresa su nombre de usuario "<usuario>" y contraseña "<clave>" para iniciar sesión
        Then debería mostrar mensaje de error "Credenciales inválidas. Intenta de nuevo."

        Examples:
        | usuario     | clave            |
        | dr chapatin | claveIncorrecta  |
        | dr house    |                  |
        |             | asdagfghh123     |
        |             |                  |
Feature: Carga de ficha clínica

    @ficha
    Scenario: Relleno de formulario exitoso
        Given médico está en la página de para rellenar formulario registro de paciente
        When ingresa su nombre de usuario "doctor" y contraseña "password" para iniciar sesión 
        And completa datos del formulario:
            | campo       | valor                      |
            | nombre      | Sofia                      |
            | diagnostico | Bronquitis                 |
            | edad        | 18                         |
            | tratamiento | Paracetamol, agua y reposo |
        Then se muestra mensaje de confirmación "Ficha registrada con éxito."

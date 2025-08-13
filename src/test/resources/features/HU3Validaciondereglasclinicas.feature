Feature: Validación de reglas clinicas

    @reglas
    Scenario Outline: Llenado y validacion de errores.
        Given médico está en la página de para rellenar formulario registro de paciente
        And médico está en la página de inicio de sesión
        When ingresa su nombre de usuario "doctor" y contraseña "password" para iniciar sesión
        And completa datos del formulario:
            | campo       | valor                      |
            | nombre      | <nombre>                   |
            | diagnostico | <diagnostico>              |
            | edad        | <edad>                     |
            | tratamiento | <tratamiento>              |
        Then se muestra mensaje de confirmación '<error esperado>'
    
    Examples:
      | nombre     | diagnostico | edad  | tratamiento | error esperado                                                                         |
      | Diego      | cancer      | 11    | Pastillas   | Para menores de 12 años, el diagnóstico debe ser "Pediátrico"                          |
      | Diego      | cancer      | 18    |             | Todos los campos son obligatorios/El tratamiento es obligatorio para guardar la ficha. |
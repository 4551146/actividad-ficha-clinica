Feature: Carga de ficha clínica
    @formulario
    Scenario: Relleno de formulario exitoso
        Given médico está en la página de para rellenar formulario registro de paciente.
        When completa los siguientes datos:
            | campo       | valor                      |
            | nombre      | Sofia                      |
            | diagnostico | Bronquitis                 |
            | edad        | 18                         |
            | tratamiento | Paracetamol, agua y reposo |

            Then se muestra mensaje de confirmación "Ficha registrada con éxito.".

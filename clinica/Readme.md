Actividad Modular 5

## Objetivo:
Evaluar la capacidad del estudiante para diseñar, estructurar y desarrollar un proyecto de
automatización de pruebas funcionales utilizando Java, Cucumber, Selenium WebDriver y
Maven. El estudiante deberá aplicar el enfoque BDD mediante la redacción de historias de
usuario en lenguaje Gherkin, integrando múltiples escenarios, datos parametrizados, Tags y
Hooks. Asimismo, se espera la aplicación de buenas prácticas de automatización como el uso
del patrón Page Object Model y WebDriverManager, junto con la generación de reportes y
documentación clara.

## Contexto:
En este proyecto final, pondrás en práctica todos los conceptos aprendidos sobre BDD con Java
y Cucumber, simulando el proceso de automatización de historias de usuario en un sistema de
gestión clínica. Crearás pruebas a nivel funcional para validar flujos críticos como login de
médicos, carga de fichas clínicas, y validación de reglas de negocio.
Tiempo estimado de desarrollo: 3 horas.
Formato de entrega: archivo comprimido .zip o .rar con código fuente y PDF.
Modalidad: grupal.


Requerimientos:

## Un proyecto Maven funcional que contenga:
o Archivos .feature bien redactados usando Gherkin.
o Steps implementados con Java y Selenium WebDriver.
o Uso correcto de Tags para filtrar pruebas.
o Hooks para inicialización, cierre y manejo de errores.
o Escenarios con datos parametrizados y tablas.
o Reporte en formato JSON o HTML.
o Documentación breve de cómo ejecutar las pruebas.

 ## Requisitos funcionales
o Historia de usuario 1 – inicio de sesión de médico
    ▪ Validar login con credenciales válidas.
    ▪ Validar mensaje de error con credenciales inválidas.
o Historia de usuario 2 – Carga de ficha clínica
    ▪ Ingresar nombre, diagnostico, edad y tratamiento.
    ▪ Mostrar mensajes de confirmación.
o Historia de usuario 3 – Validación de reglas clínicas
    ▪ Si la edad es menor de 12, diagnostico debe ser “Pediátrico”.
    ▪ Si no se completa el tratamiento, no se puede guardar.
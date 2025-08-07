// validation.js

document.addEventListener('DOMContentLoaded', () => {
  // LOGIN
  const loginForm = document.getElementById('login-form');
  if (loginForm) {
    loginForm.addEventListener('submit', (e) => {
      e.preventDefault();
      const user = document.getElementById('username').value.trim();
      const pass = document.getElementById('password').value;
      const msg = document.getElementById('login-message');
      msg.innerHTML = '';

      // Credenciales de ejemplo
      if (user === 'doctor' && pass === 'password') {
        window.location.href = 'ficha.html';
      } else {
        msg.innerHTML = '<div class="alert alert-danger" role="alert">Credenciales inválidas. Intenta de nuevo.</div>';
      }
    });
  }

  // FICHA CLÍNICA
  const recordForm = document.getElementById('record-form');
  if (recordForm) {
    recordForm.addEventListener('submit', (e) => {
      e.preventDefault();
      const nombre = document.getElementById('nombre').value.trim();
      const diagnostico = document.getElementById('diagnostico').value.trim();
      const edad = parseInt(document.getElementById('edad').value, 10);
      const tratamiento = document.getElementById('tratamiento').value.trim();
      const msg = document.getElementById('record-message');
      msg.innerHTML = '';

      // Validaciones de reglas de negocio
      const errores = [];
      if (!nombre || !diagnostico || isNaN(edad) || !tratamiento) {
        errores.push('Todos los campos son obligatorios.');
      }
      if (edad < 12 && diagnostico.toLowerCase() !== 'pediátrico') {
        errores.push('Para menores de 12 años, el diagnóstico debe ser "Pediátrico".');
      }
      if (!tratamiento) {
        errores.push('El tratamiento es obligatorio para guardar la ficha.');
      }

      if (errores.length) {
        msg.innerHTML = `<div class="alert alert-danger" role="alert"><ul>${errores.map(e => `<li>${e}</li>`).join('')}</ul></div>`;
      } else {
        msg.innerHTML = '<div class="alert alert-success" role="alert">Ficha registrada con éxito.</div>';
        recordForm.reset();
      }
    });
  }
});

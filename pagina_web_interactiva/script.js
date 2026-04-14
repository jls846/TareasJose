// Esperar a que el DOM esté cargado
document.addEventListener('DOMContentLoaded', () => {
    
    const btnSaludo = document.getElementById('btn-saludo');
    btnSaludo.addEventListener('click', () => {
        alert('¡Hola! Bienvenido a mi proyecto de evaluación web.');
    });


    const btnColor = document.getElementById('btn-cambiar-fondo');
    
    const cambiarColorFondo = () => {
        const caracteres = '0123456789ABCDEF';
        let color = '#';
        for (let i = 0; i < 6; i++) {
            color += caracteres[Math.floor(Math.random() * 16)];
        }
        
        
        document.body.style.backgroundColor = color;
    };

    btnColor.addEventListener('click', cambiarColorFondo);
});
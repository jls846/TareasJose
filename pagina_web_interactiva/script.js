document.addEventListener('DOMContentLoaded', () => {
    
    const btnSaludo = document.getElementById('btn-saludo');
    btnSaludo.addEventListener('click', () => {
        alert('hola tarea 6 .');
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
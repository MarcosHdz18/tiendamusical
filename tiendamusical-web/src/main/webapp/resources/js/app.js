/*========================================
Slider
==========================================*/
if(document.querySelector('.contenedor-slider')){

    let index=1;
    let selectedIndex=1;

    const slides=document.querySelector('.slider');
    const slide=slides.children;
    const slidesTotal=slides.childElementCount;

    const dots=document.querySelector('.dots');
    const prev=document.querySelector('.prev');
    const next=document.querySelector('.next');


    //agregamos los punto de acuerdo a la cantidad de slides
    for (let i = 0; i < slidesTotal; i++) {
        dots.innerHTML +='<span class="dot"></span>';
    }
    
    //ejecutamos la funcion
    mostrarSlider(index);

    //hacemos que nuestro slide sea automatico
    setInterval(()=>{
        mostrarSlider(index=selectedIndex);
    },10000); //representados en milesegundos

    //funcion para mostrar el slider
    function mostrarSlider(num){
        if(selectedIndex > slidesTotal){
            selectedIndex=1;
        }else{
            selectedIndex++;
        }

        if(num > slidesTotal){
            index=1;
        }

        if(num<1){
            index=slidesTotal;
        }

        //removemos la clase active de todos los slide
        for(let i=0; i<slidesTotal;i++){
            slide[i].classList.remove('active');
        }

        //removemos la clase active de los puntos

        for (let x = 0; x < dots.children.length; x++) {
            dots.children[x].classList.remove('active');
        }

        //mostramos el slide
        slide[index-1].classList.add('active');

        //agregamos la clase active al punto donde se encuntra el slide
        dots.children[index-1].classList.add('active');

        
    }

    //evento para nuestro botones prev y next
    next.addEventListener('click',(e)=>{
        mostrarSlider(index +=1);
        selectedIndex=index;
    });

    prev.addEventListener('click',(e)=>{
        mostrarSlider(index +=-1);
        selectedIndex=index;
    });

    //puntos
    for (let y = 0; y < dots.children.length; y++) {
        
        //por cada dot que ecuentre le agregamos el evento click y ejecutamo la funcion de slide
        dots.children[y].addEventListener('click',()=>{
            mostrarSlider(index=y+1);
            selectedIndex=y+1;
        });
    }

}


/*========================================
Tabs Formulario
==========================================*/
const tabLink=document.querySelectorAll('.tab-link');
const formularios=document.querySelectorAll('.formulario');

for (let x = 0; x < tabLink.length; x++) {
    
    tabLink[x].addEventListener('click',()=>{

        //removemos la clase active de todos los tabs encotrados
        tabLink.forEach((tab)=> tab.classList.remove('active'));

        //le agregamos la clase active al tab que se le hizo click
        tabLink[x].classList.add('active');

        //mostramos el formulario correspondiente
        //para los formularios funciona exactamente los mismo que los tabs
        formularios.forEach((form)=>form.classList.remove('active'));
        formularios[x].classList.add('active');
       
    })
}

/*========================================
Mostrar contraseña
==========================================*/
const mostrarClave=document.querySelectorAll('.mostrarPwd');
const inputPass=document.querySelectorAll('.password');

for (let i = 0; i < mostrarClave.length; i++) {
    
    mostrarClave[i].addEventListener('click',()=>{

        if(inputPass[i].type==="password"){

            //cambiamos el tipo password a text
            inputPass[i].setAttribute('type','text');

            //removemos la clase del icono
            mostrarClave[i].classList.remove('fa-eye');

            //agregamos el nuevo icono
            mostrarClave[i].classList.add('fa-eye-slash');

            //le agregamos la clase active
            mostrarClave[i].classList.add('active');

        }else{
            //si el tipo de input es text

            //cambiamos el tipo text a password
            inputPass[i].setAttribute('type','password');

             //removemos la clase del icono
             mostrarClave[i].classList.remove('fa-eye-slash');

             //agregamos el nuevo icono
             mostrarClave[i].classList.add('fa-eye');
 
             //le agregamos la clase active
             mostrarClave[i].classList.remove('active');
 
        }

    });
}

/*========================================
Validamos el formulario de registro
==========================================
let campoNombre,campoEmail,campoPasswordRegistro,cbx_notificaciones,cbx_terminos;

if(document.getElementById('btnRegistro')){

    const btnRegistro=document.getElementById('btnRegistro');

    //evento click al boton registro
    btnRegistro.addEventListener('click',(e)=>{

        e.preventDefault();

        const msError=document.querySelector('#formRegistro .error-text');
        msError.innerHTML="";
        msError.classList.remove('active');

        campoNombre=formRegistro.campoNombre.value.trim();
        campoEmail=formRegistro.campoEmail.value.trim();
        campoPasswordRegistro=formRegistro.campoPasswordRegistro.value.trim();

        cbx_notificaciones=formRegistro.cbx_notificaciones;
        cbx_terminos=formRegistro.cbx_terminos;

        //validamos que los campos cuando estan vacios
        if(campoNombre=="" && campoEmail=="" && campoPasswordRegistro==""){
            
            //mostramos error en pantalla
            mostrarError('Todos los campos son obligatorios',msError);
            
            //le agregamos la clase error a los input
            //le pasamos los datos array
            inputError([formRegistro.campoNombre,formRegistro.campoEmail,formRegistro.campoPasswordRegistro]);
            return false;

        }else{
            //removemos esa clase con la siguente funcion
            inputErrorRemove([formRegistro.campoNombre,formRegistro.campoEmail,formRegistro.campoPasswordRegistro]);
        }


        //validamos a cada input
        if(campoNombre=="" || campoNombre==null){

            mostrarError('Por favor ingrese su nombre',msError);
            inputError([formRegistro.campoNombre]);
            formRegistro.campoNombre.focus(); // fija el foco del cursor en el elemento indicado,
            return false;
        }else{
            //validamos que ingrese un nombre y no numeros
            if(!validarSoloLetras(campoNombre)){
                //si es diferente a true
                mostrarError('Ingrese un nombre válido, no se permiten caracteres especiales',msError);
                inputError([formRegistro.campoNmbre]);
                formRegistro.campoNombre.focus();
                return false;
            }
        }

        //validamos correo
        if(campoEmail==null || campoEmail==""){
            mostrarError('Por favor ingrese su correo',msError);
            inputError([formRegistro.campoEmail]);
            formRegistro.campoEmail.focus();

            return false;
        }else{

            if(!validarCorreo(campoEmail)){
                mostrarError('Por favor ingrese un correo válido',msError);
                inputError([formRegistro.campoEmail]);
                formRegistro.campoEmail.focus();
                return false;
            }
        }

        //validamos password
        if(campoPasswordRegistro=="" || campoPasswordRegistro==null){
            mostrarError('Por favor ingrese una contraseña',msError);
            inputError([formRegistro.campoPasswordRegistro]);
            formRegistro.campoPasswordRegistro.focus();
            return false;
        }else{

            //validamos que la contraseña tenga con minimo 5 cacteres
            if(campoPasswordRegistro.length <=4){
                mostrarError('Contraseña débil, mínimo 5 carácteres',msError);
                inputError([formRegistro.campoPasswordRegistro]);
                formRegistro.campoPasswordRegistro.focus();
                return false;
            }
        }*/

        //validamos el cbx-terminos

		let cbx_notificaciones,cbx_terminos;		
		
		if(document.getElementById('btnRegistro')){

    		const btnRegistro=document.getElementById('btnRegistro');

		    //evento click al boton registro
    		btnRegistro.addEventListener('click',(e)=>{

        	e.preventDefault();

        	const msError=document.querySelector('#formRegistro .error-text');
        	msError.innerHTML="";
        	msError.classList.remove('active');

			cbx_notificaciones=formRegistro.cbx_notificaciones;
        	cbx_terminos=formRegistro.cbx_terminos;

        	if(cbx_terminos.checked==false){
				mostrarError('Por favor aceptar Términos y condiciones',msError);
            
            	//le agreamos un clase error a su elemento padre
            	formRegistro.cbx_terminos.parentNode.classList.add('cbx-error');
            	return false;
        	}else{
            formRegistro.cbx_terminos.parentNode.classList.remove('cbx-error');
        	}

        	//un vez hechas las validaciones enviaremos el formulario para luego recibirlos con php
        	formRegistro.submit();
        	return true;

    	});

    	formRegistro.cbx_terminos.addEventListener('change',(e)=>{
			if(e.target.checked){
				formRegistro.cbx_terminos.parentNode.classList.remove('cbx-error');
        	}
    	})


	}


/*========================================
    Válidamos formulario de login
==========================================
if(document.getElementById('btnLogin')){

    const btnLogin=document.getElementById('btnLogin');

    btnLogin.addEventListener('click',(e)=>{

        e.preventDefault();

        const msError=document.querySelector('#formLogin .error-text');
        msError.innerHTML="";
        msError.classList.remove('active');

        campoUsuario=formLogin.campoUsuario.value.trim();
        campoPassword=formLogin.campoPassword.value.trim();

        if(campoUsuario=="" && campoPassword==""){
            mostrarError('Por favor ingrese su usuario/contraseña', msError);
            inputError([formLogin.campoUsuario,formLogin.campoPassword]);
            return false;
        }else{
            inputErrorRemove([formLogin.campoUsuario,formLogin.campoPassword]);
        }

        if(campoUsuario=="" || campoUsuario==null){
            mostrarError('Por favor ingrese su correo',msError);
            inputError([formLogin.campoUsuario]);
            formLogin.campoUsuario.focus();
            return false;
        }

        if(campoPassword=="" || campoPassword==null){
            mostrarError('Por favor ingrese su contraseña',msError);
            inputError([formLogin.campoPassword]);
            formLogin.campoPassword.focus();
            return false;
        }

        //enviamos el fromulario
        formLogin.submit();
        return true;

    })
}*/

/*
    CREAMOS FUNCIONES PARA MOSTRAR ERROR EN PANTALLA Y ADEMAS VALIDAR SI LOS CAMPOS SON INGRESADOS CORECTAMENTE
*/

/*========================================
Mostrar Error
==========================================*/
function mostrarError(mensaje,msError){

    //agregamos la clase active
    msError.classList.add('active');

    msError.innerHTML='<p>'+mensaje+'</p>';
}

/*========================================
Agregar class error input
==========================================*/
//a esta funcion le pasamos un array

function inputError(datos){
    for (let i = 0; i < datos.length; i++) {

        //a cada input le agregamos una clase error
        datos[i].classList.add('input-error');

    } 
    
}

//a esta funcion le pasamos un array
function inputErrorRemove(datos){
    for (let i = 0; i < datos.length; i++) {
        //removemos la clase
        datos[i].classList.remove('input-error');

    } 
    
}

/*===============================================
    Válidamos solo letras y numeros
================================================*/
function validarLetrasNumeros(valor){
    if(!/^[a-zA-Z0-9]+$/.test(valor)){
        return false;
    }
    return true;
}


/*===============================================
    Válidamos solo letras
================================================*/
function validarSoloLetras(valor){
    if(!/^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]*$/.test(valor)){
        return false;
    }
    return true;
}

/*===============================================
    Válidamos un corrreo valido
================================================*/

function validarCorreo(valor){
    if(!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(valor)){
        return false;
    }

    return true;
}

/*===============================================
    Válidamos solo número
================================================*/

function validarSoloNumeros(valor){
    if(!/^([0-9]{8})*$/.test(valor)){
        return false;
    }
    return true;
}
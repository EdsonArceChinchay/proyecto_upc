#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT085
##GDAP: GDAP-1004
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI12 @Sanity28 @DROP-G05
Característica:AT-DT085_Paquetizacion Duo mas Mono Call Center
  Quiero realizar una paquetizacion por call center

  @PaquetizacionDuoMasMonoPorCallCenter
  Esquema del escenario: Paquetizacion Duo mas Mono Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        selecciono el servicio mono "5010007041" y  el servicio duo "14339051" a paquetizar
    #Y        selecciono el servicio mono "5010001527" y  el servicio duo "14340749" a paquetizar
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton continuar
    #Y        doy click en el boton "Confirmar direccion"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en validar identidad del titular
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento | tipoPlan | nombrePlan                                        | nombrePadre | nombreMadre | distritoNac |
      | usuario externo | userNameCC | passCC | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | DNI           | 76268961  | Trío     | TRÍO MOV. VOZ INTERNET ESTANDAR RA 1D D22 50 MBPS | FRANCISCO   | CELESTINA   | COMBAPATA   |
      #| usuario externo | userNameCC | passCC | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 102040469 | Trío     | TRÍO MOV. VOZ INTERNET ESTANDAR RA 1D D22 50 MBPS | FRANCISCO   | CELESTINA   | COMBAPATA   |
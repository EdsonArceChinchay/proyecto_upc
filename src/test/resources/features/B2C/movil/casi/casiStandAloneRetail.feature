#language:es
##CREADOR: Moises Llamoca
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:AT-DT113
##GDAP:GDAP-1386
##SPRINT CREADO: PI15_SP5
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:Reusable
##ENCARGADO:Brandon
##FECMOD: 06/05/2024

@BERSERKERS @DoneDevOps @casiStandAloneRetail

Característica: AT-DT113_CASI Stand Alone con documento CE por Canal Retail
  Quiero realizar un CASI a un cliente con CE y parque movil

  @casiStandAloneRetail
  Esquema del escenario: Cambio de Simcard a un cliente con CE y parque movil
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro el popup de contraseña Única
    Y        cierro popup de error
    Cuando   doy click en el boton Ver detalle del servicio "920957608"
    Y        selecciono el boton Cambiar Chip
    Y        cierro pop up de Cliente Exonerado
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "False" y CASI:"True" en el response del salesLead
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName    | password | msgHome    | tipoDocumento | documento  | correo            |
      | usuario externo | userNameDLC | passDLC  | Bienvenid@ | CE            | 1042464725 | prueba@prueba.com |

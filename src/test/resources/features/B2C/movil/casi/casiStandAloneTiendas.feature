#language:es
##CREADOR: Moises Llamoca
##APP: DITO
##MODULO: CASI
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:AT-DT112
##GDAP: GDAP-1418
##SPRINT CREADO: PI15_SP4
##FRECUENCIA: DIARIA
##TAG : BERSERKERS
##DATA:Reusable
##ENCARGADO:Brandon
##FECMOD: 26/02/2024

@BERSERKERS @DoneDevOps @casiStandAloneTiendas
Característica: AT-DT112_CASI Stand Alone con documento CE por Canal Tienda
  Quiero realizar un CASI a un cliente con parque movil a un usuario con documento CE

  @casiStandAloneTiendas
  Esquema del escenario: Cambio de Simcard a un cliente con parque movil a un usuario con documento CE por Canal Tienda
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
    Cuando   doy click en el boton Ver detalle del servicio "650027636"
    Y        selecciono el boton Cambiar Chip
    Y        cierro pop up de Cliente Exonerado
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "False" y CASI:"True" en el response del salesLead
    Y        doy clic en continuar
    #Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento  | correo            |
      | usuario externo | userNameST | passST   | Bienvenid@ | CE            | 1042464721 | prueba@prueba.com |

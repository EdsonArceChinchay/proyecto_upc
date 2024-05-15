#language: es
##CREADOR: HENRY
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT099
##GDAP: GDAP-1147
##SPRINT CREADO: PI14
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 31/07/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI14

Característica: AT-DT099_Cambio de plan movil por Canal Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @CambiodeplanmovilCEcallcenter
  Esquema del escenario: cambio de plan movil en call center sin biometria
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "PRUEBAS SIST CALLIN VENTA"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono el boton Ver detalle del servicio "920956624"
    Y        doy click en el boton "Renovar plan"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono boton Cambiar plan
    Y        valido que este en la seccion de registro
    Y        doy click en iniciar registro
    Y        ingreso email "auto-3241@yopmail.com" y lo confirmo
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:

      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento  |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | CE            | 1042465079 |
#


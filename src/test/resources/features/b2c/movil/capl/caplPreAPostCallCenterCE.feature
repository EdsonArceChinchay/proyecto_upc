#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: CAMBIO DE PLAN (CAPL)
##ESTADO: ACTIVO
##CODIGO: AT-DT101
##GDAP: GDAP-962
##SPRINT CREADO: PI14
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDEN EN VUELO)
##ENCARGADO:
##FECMOD: 27/10/2024

@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI11SP5 @CAPL
Característica: AT-DT101_Cambio de plan (CAPL) de Prepago a Postpago a cliente extranjero (CE) por canal Call Center

  @CaplPreAPostCC_CE
  Esquema del escenario: CAPL Prepago a Postpago a cliente extranjero (CE) por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        valido que se presente el canal "Call Center"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        doy click en el boton Ver detalle del servicio "<nroMovil>"
    Y        presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "Plan Ilimitado Mi Movistar S/85"
    Y        valido que este en el resumen de venta
#    Y        doy click en el boton Iniciar registro
#    Y        ingreso correo electronico "automation@gmail.com"
#    Y        ingreso nuevamente el correo electronico "automation@gmail.com"
#    Y        doy click en Validar contrato "Móvil"
#    Y        me muestra en pantalla el contrato solicitado
#    Y        imprimo el texto del contrato solicitado
#    Cuando   doy clic en si acepto
#    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
#    Y        doy click en el boton Continuar
#    Entonces visualizo en pantalla el mensaje de exito de la venta generada
#    Y        doy click en ver detalle del pedido
#    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
#    Y        valido que se muestre el detalle del pedido de "Información adicional"
#    Dado     regreso a la pagina de inicio
#    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
#    Y        me dirijo a la bandeja de Back Office
#    Y        busco por "<documentNumber>"
#    Y        selecciono la solicitud
#    Y        cargo el audio en la web
#    Y        apruebo la solicitud
    Ejemplos:
      | userType     | userName     | userPassword     | documentType | documentNumber | nroMovil  |
#      | userType     | userNameCC   | userPasswordCC   | CE           | 1632547937     | 650028381 |

      | externalUser | userNameQAN2 | userPasswordQAN2 | CE           | 1100000273     | 920321329 |
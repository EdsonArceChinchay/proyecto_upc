#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: LISTO
##CODIGO: AT-DT101
##GDAP: GDAP-962
##SPRINT CREADO: PI14
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 02/11/2023
@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI11SP5
Característica: AT-DT101_Realizar un CAPL con canal Call Center de un Control a Postpago

  @CaplPrepagoPospago1
  Esquema del escenario: CAPL con canal Call Center de un Control CE
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciona el boton de detalle del numero de celular existente "<EncontrarCelular>"
    Y        presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "Plan Ilimitado Mi Movistar S/ 85.9 VI"
    Y        doy click en iniciar registro
    Y        ingreso email "qaAutmator@gmail.com" y lo confirmo
    Y        voy hasta el final de la pagina
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"False", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy clic en continuar
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
      | tipoUsuario     | userName    | password | tipoDocumento | documento  | EncontrarCelular |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | CE            | 1042464638 |                  |
#      | usuario interno | userNameQAN | passQAN  | CE            | 1100000314 | 981637356        |
      | usuario interno | userNameQAN | passQAN  | CE            | 1100000240 | 983610461        |

#      | usuario interno |          |              | CE            | 1100000317 | 981769530        |
#      | usuario interno |          |              | CE            | 1100000273 | 984093119        |
#      | usuario interno |          |              | CE            | 1100000273 | 984093119        |
#      | usuario interno |          |              | CE            | 1100000754 | 985467360        |
#      | usuario interno |          |              | CE            | 221011144  | 978129232        |
#  1100000273
#  1100000808
#  1100000806
#  1100000755


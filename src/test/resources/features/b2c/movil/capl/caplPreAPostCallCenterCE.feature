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
  Esquema del escenario: CAPL Prepago a Postpago a cliente extranjero - por canal Call Center
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA              | HU          | Test        | Transaccion             | Tipo Venta | Tags               |
      | Jesus Abel Tornero Rojas | TIQLT-27352 | TIQLT-27352 | CAPL Prepago a Postpago | Contado    | @CaplPreAPostCC_CE |
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "<userType>"
    Y ingreso el usuario "<userName>"
    Y ingreso el password "<userPassword>"
    Y ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y valido que se presente el canal "<channelType>"
    Cuando selecciono el tipo de documento "<documentType>"
    Y ingreso el documento "<documentNumber>"
    Y doy click en el boton Consultar
    Y selecciona el boton de detalle del numero de celular existente "<nroMovil>"
    Y presiono el boton Renovar Plan
   ## Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y selecciono el boton de eleccion de planes
    Y selecciono el tipo de plan movil "Postpago"
    Y selecciono un plan movil "<planMovil>"
    Y valido que este en el resumen de venta
    Y doy click en el boton Iniciar registro
    Y ingreso correo electronico "<correo>"
    Y ingreso nuevamente el correo electronico "<correo>"
    Y doy click en Validar contrato "Móvil"
    Y me muestra en pantalla el contrato solicitado
    Y imprimo el texto del contrato solicitado
    Cuando doy clic en si acepto
    Y doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y doy click en ver detalle del pedido
    Y valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y valido que se muestre el detalle del pedido de "Información adicional"
    Dado regreso a la pagina de inicio
    Y valido que se presente el canal "<channelType>"
    Y me dirijo a la bandeja de Back Office
    Y busco por "codigo de venta"
    Y selecciono la solicitud
    Y cargo el audio en la web
    Y apruebo la solicitud
    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | channelType | documentType | documentNumber | nroMovil  | correo                   | planMovil                       |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1042464934      | 920955204 | 221011125@mailinator.com | Plan Ilimitado Mi Movistar S/85 |

  ## CE A PROBAR : 1042464934
  ## N° CELULAR A PROBAR  : 920955204
  ##PLAN A PROBAR : Plan Ilimitado Mi Movistar S/114.9VII O Plan Ilimitado Mi Movistar S/85
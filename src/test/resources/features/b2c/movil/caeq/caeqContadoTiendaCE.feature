#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: CAMBIO DE EQUIPO (CAEQ)
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1423
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDEN EN VUELO)
##ENCARGADO:
##FECMOD: 07/11/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: Cambio de equipo (CAEQ) movil al contado a cliente extranjero (CE) por canal Tienda

  @CaeqContadoTienda_CE
  Esquema del escenario: Como usuario <userName> de la Tienda <channelType> deseo consultar el cliente con <documentType>: <documento>
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU         | Test        | Transaccion             | Tipo Venta | Tags                  |
      | Jorge Cancino | TIQLT-xxxx | TIQLT-27346 | Cambio de equipo (CAEQ) | Contado    | @CaeqContadoTienda_CE |
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
    Y        doy click en el boton Ver detalle del servicio "650030368"
    Y presiono el boton Renovar Plan
    Y valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y presiona el boton anadir equipo del mismo plan
    E ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName              |
      | 12 meses    | Al Contado | XIAOMI REDMI NOTE 9 PRO |
    Y valido que existan resultados busqueda de equipos
    Y presiono el boton Ver detalle valido contenido y selecciono
    Y cierro pop up de CU
    Y doy click en el boton "Mantener Plan"
    Y valido que este en el resumen de venta
    Y doy click en el boton Iniciar registro
    Y valido el stock del equipo
    Y ingreso correo electronico "<correo>"
    Y ingreso nuevamente el correo electronico "<correo>"
    Y doy click en validar identidad del titular
    Y ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Y doy click en Validar contrato "Móvil"
    Y me muestra en pantalla el contrato solicitado
    Y imprimo el texto del contrato solicitado
    Cuando doy clic en si acepto
    #Y valido que CAEQ:"True", CAPL: "False" y CASI:"False" en el response del salesLead
    Y doy click en el boton de continuar
    Y doy clic para descargar el contrato
    Y doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y doy click en ver detalle del pedido
    Y valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | numeroPlanMovil | correo                   | nombreMadre | nombrePadre | distritoNac |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 1632547903     | 650030376       | 221011271@mailinator.com | Silvia      | Francisco   | Comas       |


      ## CE A PROBAR : 1042464939
  ## N° CELULAR A PROBAR  : 920955026
  ##NOMBRE DEL EQUIPO : HONOR X8A VERDE CRT-LX3 C/PACK
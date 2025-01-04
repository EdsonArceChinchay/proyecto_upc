#language: es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: ALTA SVA
##ESTADO: ACTIVO
##CODIGO: AT-DT
##GDAP: GDAP-1435
##SPRINT CREADO: PI18_SP2
##FRECUENCIA: SEMANAL
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES)
##ENCARGADO: CARLOS RUIZ
##FECMOD: 17/07/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI18 @AltaSVA @RegresionLegacy
Característica: AT-DT _ Alta SVA a un MT a cliente con CE por canal Call Center

  @SvaMTCE_CC
  Esquema del escenario: Alta SVA a un MT a cliente CE por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la linea con numero "9234912744"
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "ACTUALIZAR DIRECCION"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono boton mantener plan
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        agrego SVA bloque "HBO"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso correo electronico "<emailUser>"
    Y        ingreso nuevamente el correo electronico "<emailUser>"
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documentNumber>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | emailUser        |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 2777000004     | test@hotmail.com |
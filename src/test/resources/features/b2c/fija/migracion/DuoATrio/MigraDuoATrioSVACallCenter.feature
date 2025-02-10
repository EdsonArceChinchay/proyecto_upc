#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT065
##GDAP: GDAP-605
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: CARLOS RUIZ
##FECMOD: 06/05/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @RegresionPangea @Sanity28 @DROP-G05 @RegresionLegacy
Característica: AT-DT065_Migracion de Duo (TV + Internet) a Trio + SVA a cliente con CE por canal Call Center

  @MigracionduoTrioSVACC
  Esquema del escenario:Migracion de Duo a Trio + SVA por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro pop up de CU
    Y        selecciono la linea con numero "5010022353"
    Y        selecciono el boton Mostrar ofertas
#    Y        doy click en el boton "CONFIRMAR DIRECCION"
    Y        doy click en el boton "ACTUALIZAR DIRECCION"
    Y        ingreso la referencia de la direccion "."
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        doy click en Cambiar plan hogar
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA linea "Plan Multidestino 20"
    Y        agrego SVA bloque "HBO"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "hogar"
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
    Y        busco por "codigo de venta"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | correo           | tipoPlanHogar | plan                                |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1101010102     | correo@gmail.com | Trío          | TRÍO MOVISTAR VOZ INTERNET ESTANDAR |

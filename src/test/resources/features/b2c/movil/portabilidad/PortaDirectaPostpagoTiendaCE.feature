#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD: PORTABILIDAD
##ESTADO: ACTIVO
##CODIGO: AT-DT
##GDAP:
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 20/11/2024

@BERSERKERS @DoneDevOps
Característica: AT-DT_Porta Directa solo chip postpago a cliente con CE por canal Tienda

  @PortaDirectaPostST_CE
  Esquema del escenario: Porta Directa solo chip postpago a cliente con CE por canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Y        valido que este activo el flag de Porta Directa
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos    | genero    |
      | JUAN    | PEREZ ZAPATA | masculino |
    Y        doy click en el boton portabilidad
    Y        cierro el popup de contraseña Única
    Y        selecciono el boton Mostrar ofertas
    Y        ingreso numero de telefono para portar "<phoneNumber>"
    Y        escojo tipo de linea "<tipoLinea>"
    Y        escojo tipo de operador "<operador>"
    Y        doy click en el boton Consultar Portabilidad
    Y        valido que este en la seccion Postpago o Prepago
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso correo electronico "jlopez@mail.com"
    Y        ingreso nuevamente el correo electronico "jlopez@mail.com"
    Y        doy click en el boton Validar Codigo de Portabilidad
    Y        doy click en "Activa" y doy click en el boton Confirmar
    Y        obtengo el token
      | documentType   | documentNumber   | phoneNumber   |
      | <documentType> | <documentNumber> | <phoneNumber> |
    Cuando    ingreso el token y doy click en el boton Confirmar
    Entonces  valido el mensaje "Código valido" y doy click en el boton Continuar
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/08/1994 | soltero     | Angola       | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        valido el servicio de status de portabilidad
      | phoneNumber   |
      | <phoneNumber> |
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | phoneNumber | tipoLinea | operador           | tipoPlanMovil | nombrePlan                    |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | C            | 1047497714     | 920956351   | Postpago  | OPERADOR DE PRUEBA | Postpago      | RV Plan Ilimitado Mi Movistar |
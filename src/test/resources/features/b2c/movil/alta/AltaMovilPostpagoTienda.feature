#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT025
##GDAP: GDAP-1007
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 01/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @AltaMovil
Característica: AT-DT025_Alta Movil Postpago a cliente con CE por canal Tienda

  @AltaMovilPostpagoCanalTienda
  Esquema del escenario: Alta Movil Postpago a cliente con CE por canal Tienda
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU         | Test       | Transaccion | Tipo Venta |
      | Jorge Cancino | TIQLT-XXXX | TIQLT-XXXX | ALTA MOVIL  | Contado    |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos | genero   |
      | QAN     | PREPROD   | femenino |
    #Y        valido que muestre el nombre completo del cliente "Estela Rosario Lopez Manrique"
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    #Y        doy click en el boton seleccionar oferta
    #Y        doy click en el boton Linea Nueva
    #Y        valido que este en el resumen de venta
    #Y        doy click en el boton Iniciar registro
    #Y        valido que este en la seccion completa los datos solicitados
    Y        ingreso correo electronico "estelalopez@mail.com"
    Y        ingreso nuevamente el correo electronico "estelalopez@mail.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito   | direccion            |
      | 26/07/1995 | soltero     | Alemania     | LIMA         | LIMA      | SAN MIGUEL | CALLE SAN MARTIN 399 |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | tipoPlanMovil | nombrePlan             |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 1100000112     | Postpago      | Plan Elige Mas S/ 52.9 |
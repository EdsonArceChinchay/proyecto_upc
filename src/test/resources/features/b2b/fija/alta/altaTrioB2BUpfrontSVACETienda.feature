#language:es
##CREADOR:  CARLOS RUIZ
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT
##GDAP: GDAP-1439
##SPRINT CREADO: PI18_SP3
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 12/03/2024

@BERSERKERS @DoneDevOps @PI18_SP3 @RegresionLegacyUpfront @AltaTrioUpfront
Característica: AT-DT0_ Alta Trio B2B Upfront con SVA con representante legal CEX por canal Tienda

  @AltaTrioB2BSVACETienda
  Esquema del escenario: Alta Trío B2B Upfront con SVAs con representante legal CEX por canal Tienda
    Dado     que abro la pagina de movistar
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
    Y        selecciono el ID de Cliente nro "<nro>"
    Y        selecciono el tipo de documento "<tipoDocRepLegal>" del Representante Legal
    E        ingreso el numero de documento "<numDocRepLegal>" del Representante Legal
    Y        doy click en Validar Representa Legal
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        valido si el usuario aplica para upfront
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        selecciono la oferta "<nombrePlan>"
    Y        doy click en el boton Linea Nueva
    Y        valido que este en el resumen de venta
    Y        doy click en añadir SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA bloque "HBO"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento para RUC
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | nro | tipoDocRepLegal | numDocRepLegal | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan                  |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | RUC          | 20000000006    | 1   | CE              | 200000002      | LIMA         | LIMA      | LINCE    | Jiron Julio Cesar Tello 469 | A          | Trío     | TRIO MOV. VOZ INT. ESTANDAR |

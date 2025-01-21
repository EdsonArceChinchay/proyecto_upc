#language:es
##CREADOR: Angel Medina
##APP: DITO
##MODULO: MOVIL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT031
##GDAP: GDAP-959
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Angel Medina
##FECMOD: 01/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROP-G05 @AltaMovil
Característica: AT-DT031_Alta Movil Postpago a cliente con CE por canal Retail

  @AltaMovilPostpagoRetail
  Esquema del escenario: Alta Movil Postpago a cliente con CE por canal Retail
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres  | apellidos      | genero   |
      | Teresita | Collasos Lopez | femenino |
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono el boton de eleccion de planes
    Y        selecciono el tipo de plan movil "Postpago"
    Y        selecciono un plan movil "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        ingreso correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en datos del cliente
    Y        selecciono completar los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad | departamento | provincia | distrito | direccion                   |
      | 12/12/1980 | Casado      | Albania      | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "Móvil"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito del ticket generado
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Cuando   regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la orden
    Y        doy click en el boton de continuar
    E        ingreso el codigo de SIMCARD
    Y        doy click Validar Stock
    E        ingreso el numero de caja "123456"
    E        ingreso el numero de ticket "654321"
    Y        doy click en el boton confirmar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | documentType | documentNumber | nombrePlan                              |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | CE           | 1209454401     | RV Plan Ilimitado Mi Movistar S/ 74.9 V |
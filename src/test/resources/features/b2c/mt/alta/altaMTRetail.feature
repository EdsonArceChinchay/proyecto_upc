#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT034
##GDAP: GDAP-574
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: CARLOS RUIZ
##FECMOD: 05/10/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROPG3
Característica: AT-DT034_Alta MT (Alta Fija + Alta Movil) a cliente con CE por canal Retail

  @AltaMTRetail
  Esquema del escenario: Alta MT (Alta Fija + Alta Movil) a cliente con CE por canal Retail
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos | genero   |
      | Luisa   | Cabello   | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<planType>"
    Y        selecciono un plan Movistar Total "<planName>"
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 11/02/1990 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito del ticket generado
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Cuando   regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la orden
    Y        doy click en el boton continuar
    E        ingreso el codigo de SIMCARD
    Y        doy click Validar Stock
    E        ingreso el numero de caja "123456"
    E        ingreso el numero de ticket "654321"
    Y        doy click en el boton confirmar
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName    | userPassword    | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                   | referencia | planType | planName | correo           |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | Retail      | CE           | 2167100001     | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | INKAFARMA  | Mono MT  | Mono BA  | correo@gmail.com |
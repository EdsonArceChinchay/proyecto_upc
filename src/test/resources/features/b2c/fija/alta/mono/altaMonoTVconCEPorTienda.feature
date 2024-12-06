#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA MONO TV
##ESTADO: ACTIVO
##CODIGO: AT-DT
##GDAP: GDAP-1436
##SPRINT CREADO: PI14_SP1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 08/04/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI14SP1 @RegresionDitoC @AltaFija @AltaMono
Característica: AT-DT _Alta Mono TV con Documento CE en Canal Tienda

  @AltaMonoTVTienda
  Escenario: Alta Mono TV con Documento CE en Canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "userType"
    Y        ingreso el usuario "userNameST"
    Y        ingreso el password "userPasswordST"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "101308710"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos    | genero    |
      | LUIS    | ZAPATA VALLE | MASCULINO |
    Y        selecciono el boton Linea Nueva Hogar
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        completo los datos para consultar la cobertura
      | departamento | provincia | distrito | direccion                | referencia |
      | LIMA         | LIMA      | LINCE    | JR JULIO CESAR TELLO 469 | PARQUE     |
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "Mono"
    Y        selecciono el plan "TV"
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso telefono de contacto
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "test@mail.com"
    Y        ingreso nuevamente el correo electronico "test@mail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 10/11/1994 | Casado      | Alemania     |
    Y        doy click en el boton confirmar
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

#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT041
##GDAP: GDAP-1066
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 15/08/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @AltaMT_Upfront
Característica: AT-DT041_Alta MT (Alta fija + alta movil) Upfront a cliente con CE por canal Tienda

  @AltaMTUpfrontTienda_CE
  Esquema del escenario: Alta MT (Alta fija + alta movil) Upfront a cliente con CE por canal Tienda
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
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos    | genero   |
      | KARINA  | PEREZ ZAPATA | FEMENINO |
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
    Y        "<insertarDireccion>" ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto                 | conjHabit |
      |    |              |                |      |     | URBANIZACION RESIDENCIAL | RISSO     |
    Y        presiono el boton Consultar cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        valido si el usuario aplica para upfront
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<planType>"
    Y        selecciono un plan Movistar Total "<planName>"
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Divorciado  | Alemania     |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato ""
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
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | insertarDireccion | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                   | referencia | planType | planName  | correo           |
      | userType | userNameST | userPasswordST | Bienvenid@ | SI                | Tienda      | CE           | 0674323444     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 | Inkafarma  | Duo MT   | Duo BA TV | correo@gmail.com |
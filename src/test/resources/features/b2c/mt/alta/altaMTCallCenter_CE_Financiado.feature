#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: ALTA
##ESTADO:
##CODIGO: AT-DT
##GDAP: GDAP-1796
##SPRINT CREADO:
##FRECUENCIA:
##TAG :
##DATA:
##ENCARGADO:
##FECMOD: 28/01/2025

@BERSERKERS @DoneDevOps @DoneDevOpsPI17  @AltaMTSVA
Característica: AT-DT0 _Alta MT (Alta fija + alta movil) + Equipo Movil Financiado

  @AltaMTEquipoFinanciado
  Esquema del escenario: Alta MT (Alta fija + alta movil) + Equipo Movil Financiado
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU         | Test      | Transaccion   | Tipo Venta | Tags                    |
      | Jorge Cancino | TIQLT-XXXX | TIQLT-XXX | ALTA FIJA DUO | Contado    | @AltaMTEquipoFinanciado |
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
    Y        ingreso los datos del nuevo cliente
      | nombres  | apellidos           | genero   |
      | QATIPROD | CIENTO NOVENTAYSEIS | Femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        cierro pop up de Cliente Exonerado
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
    Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia     | tipoPago   | equipoName                        |
      | sin permanencia | Al Contado | SAMSUNG GXY A34 NEGRO A346M 128GB |
    Y        doy click en el boton seleccionar
    Y        doy click en el boton Ir a movistar total
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono el boton Consultar ubicacion
    Y        "<insertarDireccion>" ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto                 | conjHabit | lote |
      | A  | TORRE        | ALEX MANCILLA  | 1    | 1   | URBANIZACION RESIDENCIAL | RISSO     | 2    |
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    E        ingreso telefono de contacto "987654321"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy click en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso correo electronico "pruebasqa@gmail.com"
    Y        ingreso nuevamente el correo electronico "pruebasqa@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 10/12/1990 | Divorciado  | Alemania     |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Delivery"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "codigo de venta"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | insertarDireccion | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                         | referencia | planType | planName  |
      | userType | userNameQAN6 | userPasswordQAN6 | Bienvenid@ | SI                | Call Center | CE           | 1100002303     | LIMA         | LIMA      | LINCE    | JR JULIO CESAR TELLO 469 UR RISSO | Inkafarma  | Duo MT   | Duo BA TV |
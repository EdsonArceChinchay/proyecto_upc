#language: es
##CREADOR: Henry
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA TRIO
##ESTADO: ACTIVO
##CODIGO: AT-DT094
##GDAP: GDAP-1146
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @AltaFija @AltaTrio
Característica: AT-DT094_Alta trio con direccion pangea

  @Altatriopangea
  Esquema del escenario: Escenario: Alta trio Por Call Center con direccion pangea
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
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | lote | tipoVivienda | nombreVivienda | piso | int | conjunto                 | conjHabit |
      |    |      |              |                |      |     | URBANIZACION RESIDENCIAL | RISSO     |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "testing-1@tester.com"
    Y        ingreso nuevamente el correo electronico "testing-1@tester.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 02/10/1980 | Divorciado  | Angola       |
    Y        doy click en el boton confirmar
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
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "codigo de venta"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion             | referencia             | tipoPlan | nombrePlan                  |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 166268244      | LIMA         | LIMA      | LINCE    | JULIO CESAR TELLO 469 | AL FRENTE DE LA BOTICA | Trío     | TRIO MOV. VOZ INT. ESTANDAR |
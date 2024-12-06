#language:es
##CREADOR:
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA TRIO
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1165
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 25/04/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @Sanity28 @AltaFija @AltaTrio
Característica: Alta Trio con sva Bloque + sva Internet + sva Linea CANAL CALL CENTER

  @AltaTrioSvaBloqueSvaInternetSvaLineaCallCenter
  Esquema del escenario: Alta Trio con sva Bloque + sva Internet + sva Linea CANAL CALL CENTER
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
      | nombres | apellidos | genero    |
      | Oscar   | Ramos     | masculino |
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
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | D  | EDIFICIO     | Familia Lopez  | 3    | 2   | URBANIZACION POPULAR | conjunto c |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Entonces doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA linea "<svaLinea>"
    Y        agrego SVA bloque "<bloque>"
    Y        agrego SVA internet "<svaInternet>"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "tester_12@tester.com"
    Y        ingreso nuevamente el correo electronico "tester_12@tester.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 08/09/1994 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documentNumber>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito   | direccion            | referencia             | tipoPlan | nombrePlan                  | svaLinea             | bloque         | svaInternet           |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 10000486488    | LIMA         | LIMA      | SAN MIGUEL | CALLE SAN MARTIN 399 | AL FRENTE DE LA BOTICA | Trio     | TRIO MOV. VOZ INT. ESTANDAR | Plan Multidestino 20 | Bloque estelar | PACK ANTIVIRUS MCAFEE |
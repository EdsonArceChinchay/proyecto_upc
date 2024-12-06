#language:es
##CREADOR:Eloy Milla
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA DUO
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1385
##SPRINT CREADO: PI15_SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 14/02/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI15
Característica: Alta Duo (Voz + Internet) + SVA Movistar TV App en canal tienda

  @AltaDuoSvaMovistarTvApp
  Esquema del escenario:  Alta Duo (Voz + Internet) + SVA Movistar TV App en canal tienda
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
      | nombres | apellidos       | genero    |
      | Elvis   | Presley Barrios | masculino |
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
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Agregar SVA
    Entonces valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA Movistar Tv App Max
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "tester_1@tester.com"
    Y        ingreso nuevamente el correo electronico "tester_1@tester.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/10/1994 | Casado      | Albania      |
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

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                | referencia | tipoPlan | nombrePlan                |
      | userType | userNameST | userPasswordST | Bienvenid@ | Tienda      | CE           | 1021303091     | LIMA         | LIMA      | LINCE    | JR JULIO CESAR TELLO 469 | casa       | Duo      | DUO MOVISTAR VOZ INTERNET |
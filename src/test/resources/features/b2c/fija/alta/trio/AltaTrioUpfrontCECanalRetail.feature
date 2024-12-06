#language:es
##CREADOR:
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA TRIO
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-991
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps  @AltaTrio_Upfront_CE @AltaTrioUpfront
Característica: Alta Trio Upfront a cliente con CE por canal Retail

  @AltaTrio_UpfrontCanalRetail
  Esquema del escenario: Alta Trio Upfront con Nuevo Cliente Extranjero
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
      | mz | tipoVivienda  | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | alex mancilla | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | parque    |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<plan_hogar>"
    Y        selecciono el plan "<nombrePlan>"
    Y        doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | nacionalidad | estadoCivil |
      | 01/12/1990 | Alemania     | Casado      |
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
      | userType | userName    | userPassword    | msgHome    | documentType | documentNumber | departamento | provincia | distrito | direccion                | referencia | plan_hogar | nombrePlan                  |
      | userType | userNameDLC | userPasswordDLC | Bienvenid@ | CE           | 1101100011     | LIMA         | LIMA      | LINCE    | JR JULIO CESAR TELLO 469 | INKAFARMA  | Trio       | TRIO MOV. VOZ INT. ESTANDAR |
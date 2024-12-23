#language:es
##CREADOR: Edson Arce
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: CAMBIO
##ESTADO: ACTIVO
##CODIGO: AT-DT054
##GDAP: GDAP-599
##SPRINT CREADO:
##FRECUENCIA: DIARIO
##TAG : BERSERKERS
##DATA: UNICA VEZ
##ENCARGADO: Maria Sanchez
##FECMOD: 08/09/2023

@BERSERKERS @DoneDevOps
Característica:  AT-DT054_Cambio de velocidad dúo Cambio Direccion X,Y + SVA

  @CambioVelocidadDuoSvaCallCenterCambioDireccion @MVP08 @Global @General
  Esquema del escenario: Cambio de velocidad up de dúo Internet estándar 50Mb HFC a la siguiente mayor disponible y anadir sva [alta de repetidor wiffi financiado] con CEX, por canal Call Center, web front end, flujo no biométrico. Cambiar Direccion por coordinadas X,Y
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        doy click en el boton "Ingresar coordenadas"
    Y        ingreso las coordenadas de Longitud X: "<longitud>" y Latitud Y:"<latitud>"
    Y        doy click en el boton "Buscar"
    Y        ingreso la informacion del lugar para la instalacion
      | mz | lote | tipoVivienda | nombreVivienda | bloque | piso | int | conjunto             | conjHabit |
      | M  | 1    | EDIFICIO     | VIVA           | A      | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton Consultar cobertura
    Y        doy click Aceptar en el modal de error
    Y        ingreso la informacion del lugar para la instalacion
      | mz | lote | tipoVivienda | nombreVivienda | bloque | piso | int | conjunto             | conjHabit |
      | M  | 1    | EDIFICIO     | VIVA           | B      | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "Entendido"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        selecciono boton Cambiar plan
    Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Agregar SVA
    Entonces valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA repetidor "Repetidor WIFI PLUS Venta"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | tipoPlanHogar | plan                  | correo            | longitud    | latitud      |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1348959561     | Duo           | DUO INTERNET ESTÁNDAR | tester@tester.com | -77.0381898 | -12.08130997 |
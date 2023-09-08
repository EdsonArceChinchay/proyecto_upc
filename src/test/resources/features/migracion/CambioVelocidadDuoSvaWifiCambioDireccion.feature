#language:es
##CREADOR: Edson Arce
##APP: DITO
##MODULO:
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
  Esquema del escenario: Cambio de velocidad up de dúo Internet estándar 50Mb HFC a la siguiente mayor disponible y anadir sva [alta de repetidor wiffi financiado] con CEX, en canal call center, web front end, flujo no biométrico. Cambiar Direccion por coordinadas X,Y
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        doy click en el boton "Ingresar coordenadas"
    Y        ingreso las coordenadas de Longitud X: "<longitud>" y Latitud Y:"<latitud>"
    Y        doy click en el boton "Buscar"
    Y        ingreso la informacion del lugar para la instalacion
      | mz | lote | tipoVivienda | nombreVivienda | bloque | piso | int | conjunto             | conjHabit |
      | M  | 1    | EDIFICIO     | VIVA           | A      | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
    Y        doy click Aceptar en el modal de error
    Y        ingreso la informacion del lugar para la instalacion
      | mz | lote | tipoVivienda | nombreVivienda | bloque | piso | int | conjunto             | conjHabit |
      | M  | 1    | EDIFICIO     | VIVA           | A      | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
    Y        doy click en el boton "Entendido"
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan Hogar "<tipoPlanHogar>"
    Y        selecciono la oferta "<plan>"
    Y        selecciono boton Cambiar plan
    #Y        doy click en Cambiar plan hogar
    Y        valido que este en la seccion de registro
    Y        doy click en agregar repetidor
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    #Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName | password      | msgHome    | tiendaAsesor              | tipoDocumento | documento  | tipoPlanHogar | plan            | correo            | longitud    | latitud      |
      | usuario externo | jpachaot |  $t3l3f0n1c4$ | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1348959561 | Duo           | RA M23 200 MBPS | tester@tester.com | -77.0381898 | -12.08130997 |
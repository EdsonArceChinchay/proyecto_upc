#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT042
##GDAP: GDAP-595
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 15/08/2024
@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP-G04 @AltaMTSVA
Característica: AT-DT042_Alta MT (Alta Fija + Alta Movil) + SVA con cliente nacional (DNI) por canal Tienda

  @AltaMTSVATienda_DNI
  Esquema del escenario: Alta MT (Alta Fija + Alta Movil) + SVA con cliente nacional (DNI) por canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y     valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | EDIFICIO     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | parque    |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA internet "PACK ANTIVIRUS MCAFEE"
    Y        doy click en el boton Guardar cambios
    Y        doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "tester@tester.com"
    Y        ingreso nuevamente el correo electronico "tester@tester.com"
    Y        doy click en validar identidad del titular
    Y        elijo el tipo de validacion a realizar "<tipoValidacion>"
    Y        ingreso los datos del supervisor
      | numdoc   | user     | password     |
      | 73261531 | vsiguass | $t3l3f0n1c4$ |
#    Y        doy click en el boton continuar
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "Móvil"
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

      | tipoUsuario     | userName   | password | msgHome    | channelType | tipoDocumento | documento  | departamento | provincia | distrito | direccion             | referencia | nombrePlan | tipoValidacion | nombreMadre | nombrePadre | distritoNac |
      | usuario externo | userNameST | passST   | Bienvenid@ | Tienda      | DNI           | 1042464714 | 15           | 1501      | 150116   | JULIO CESAR TELLO 469 | INKAFARMA  | Trio       | discapacitado  | ERMINIA     | APOLONIO    | LURIN       |



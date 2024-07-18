#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT045
##GDAP: GDAP-713
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: AT-DT045_Caeq Mas Capl por call center
  Yo como asesor de call center
  Quiero hacer un cambio de equipo mas cambio de plan a un cliente extranjero con parque movil

  @CaeqCaplCallCenter
  Esquema del escenario: Cambio de equipo mas cambio de plan a cliente extranjero en canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia | tipoPago   | equipoName               |
      | 12 meses    | Al Contado | VIVO V21 NEGRO 5G C/PACK |
    Y        presiono el boton Ver detalle valido contenido y selecciono
    Y        doy click en el boton "Cambiar Plan"
    Y        valido que este en el resumen de venta
    Y        doy click en iniciar registro
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150116"
    Y        ingreso la direccion donde sera la instalacion "Jiron Julio Cesar Tello 469"
    Y        ingreso la referencia de la direccion "Esquina"
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A  | EDIFICIO     | Tello          | 2    | 3   | URBANIZACION POPULAR | A         |
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso el telefono de contacto "952696748"
    Y        ingreso las instrucciones a considerar de la entrega "abc"
    Y        doy clic en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "prueba@prueba.com"
    Y        ingreso nuevamente el correo electronico "prueba@prueba.com"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        valido que CAEQ:"True", CAPL: "True" y CASI:"False" en el response del salesLead
    Y        doy clic en continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Delivery"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor              | tipoDocumento | documento  | tipoPlan | nombrePlan                           |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 1042465134 | Postpago | Plan Movil Movistar Total ilim 26 GB |
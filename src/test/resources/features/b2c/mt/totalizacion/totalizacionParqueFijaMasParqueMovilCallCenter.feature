#language: es
##CREADOR: Henry salas
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: TOTALIZACION
##ESTADO: ACTIVO
##CODIGO: AT-DT110
##GDAP: GDAP-1152
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:  REUSABLE (CANCELAR ORDENES)
##ENCARGADO:
##FECMOD: 20/11/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI14
Característica: AT-DT110_Totalizacion MT (parque fijo + parque movil) a cliente con CE por canal Call Center

  @TotalizacionMTTrioMovilCC
  Escenario: Totalizacion MT (parque fijo + parque movil) a cliente con CE por canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "userType"
    Y        ingreso el usuario "userNameCC"
    Y        ingreso el password "userPasswordCC"
    Y        presiono el boton Continuar hacia el home
    Y        valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042464536"
    Y        doy click en el boton Consultar
    Y        selecciono la cartilla del plan activo
    Y        selecciono el boton de la Linea Movil Existente
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la referencia de la direccion "casa"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        doy click en el boton "ENTENDIDO"
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        luego doy click en la cartilla ir a Movistar Total
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "p@p.com"
    Y        ingreso nuevamente el correo electronico "p@p.com"
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
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "1042464536"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
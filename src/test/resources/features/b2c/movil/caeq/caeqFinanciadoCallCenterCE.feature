#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVÍL
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1420 v1
##GDAP: GDAP-1946 v2
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES EN VUELO)
##ENCARGADO: HIRO MACURI
##FECMOD: 29/05/2026

@BERSERKERS @DoneDevOps @DoneDevOpsPI12
Característica: Cambio de Equipo (CAEQ) a cliente extranjero (CE) por Call Center

  @CaeqFinanciadoCallCenter_CE
  Esquema del escenario: Cambio de Equipo (CAEQ) a cliente extranjero (CE) por Call Center
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU         | Test      | Transaccion | Tipo Venta | Tags                         |
      | Jorge Cancino | TIQLT-xxxx | TIQLT-xxx | CAEQ        | Financiado | @CaeqFinanciadoCallCenter_CE |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
#    Y        selecciona el boton de detalle del numero de celular existente "<EncontrarCelular>"
#    Y        doy click en el boton "Renovar plan"
#    Y        valido que se presente la pantalla con el titulo "Ofertas sugeridas"
#    Y        presiona el boton anadir equipo del mismo plan
#    E        ingreso permanencia, tipo de pago y equipo
#      | permanencia | tipoPago             | equipoName   |
#      | 12 meses    | Financiado 12 cuotas | <equipoName> |
#    Y        valido que existan resultados busqueda de equipos
##    Y        presiono el boton Ver detalle valido contenido y selecciono
#    Y        presiono el boton Ver detalle valido contenido y selecciono el equipo elegido "<equipoName>"
#    Y        visualizo la seleccion en la pantalla de ofertas
#    Y        doy click en el boton "Mantener Plan"
#    Y        valido que este en el resumen de venta
#    Y        doy click en el boton Iniciar registro
#    Y        selecciono el departamento donde sera la instalacion "LIMA"
#    Y        selecciono la provincia donde sera la instalacion "LIMA"
#    Y        selecciono el distrito donde sera la instalacion "LINCE"
#    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
#    Y        ingreso la referencia de la direccion "conjunto b"
#    Y        presiono el boton Consultar ubicacion
#    Y        "<insertarDireccion>" ingreso la informacion del lugar de instalacion
#      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto                 | conjHabit |
#      |    |              |                | 1    | 3   | URBANIZACION RESIDENCIAL | RISSO     |
#    Y        presiono el boton Confirmar ubicacion
#    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
#    Y        selecciono el horario de entrega "3pm-7pm"
#    Y        ingreso telefono de contacto "984093119"
#    Y        ingreso instrucciones de delivery "abc"
#    Y        doy click en confirmar delivery
#   ## Y        selecciono el metodo de pago "Contra entrega"
#   ##  Y        ingreso correo electronico "prueba_qa@gmail.com"
#   ##  Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
#   ##  Y        doy click en validar identidad del titular
#   ##  Y       ingreso los datos solicitados para la validacion del cliente
#   ##    | nombrePadre   | nombreMadre   | distritoNac   |
#   ##    | <nombrePadre> | <nombreMadre> | <distritoNac> |
#    Y        doy click en Validar contrato "Móvil"
#    Y        me muestra en pantalla el contrato solicitado
#    Y        imprimo el texto del contrato solicitado
#    Cuando   doy clic en si acepto
#    #Y        valido que CAEQ:"True", CAPL: "False" y CASI:"FALSE" en el response del salesLead
#    Y        doy click en el boton de continuar
#    Entonces visualizo en pantalla el mensaje de exito de la venta generada
#    Y        doy click en ver detalle del pedido
#    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
#    Y        valido que se muestre el detalle del pedido de "Delivery"
#    Y        valido que se muestre el detalle del pedido de "Información adicional"
#    Dado     regreso a la pagina de inicio
#    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
#    Y        me dirijo a la bandeja de Back Office
#    Y        busco por "codigo de venta"
#    Y        selecciono la solicitud
#    Y        cargo el audio en la web
#    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | insertarDireccion | channelType | documentType | documentNumber | EncontrarCelular | equipoName                  | nombreMadre | nombrePadre | distritoNac |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | SI                | Call Center | CE          | 1042464939       | 920955026        | HONOR X8A VERDE CRT-LX3 C/PACK | SILVIA      | FRANCISCO   | COMAS       |


  ## CE A PROBAR : 1042464939
  ## N° CELULAR A PROBAR  : 920955026
  ##NOMBRE DEL EQUIPO : HONOR X8A VERDE CRT-LX3 C/PACK
  ## NOMBRE DEL Esquema del escenario: : Cambio de Equipo (CAEQ) financiado a cliente extranjero (CE) por Call Center
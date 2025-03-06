#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: MIGRACION
##ESTADO:
##CODIGO: AT-DT081
##GDAP: GDAP-998
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES)
##ENCARGADO:
##FECMOD: 08/07/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11
Característica: AT-DT081_Migracion de Trio a MT por canal Call Center

  @migracionTrioAmtSvaCallCenter
  Esquema del escenario: Migracion de Trio a MT con CE  sin productos asociados sin biometria
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
    #Y        verifico la direccion "JR JULIO CESAR TELLO 469" actual del servicio
    Y        doy click en el boton "Confirmar direccion"
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        luego doy click en la cartilla ir a Movistar Total
    Y        valido que este en el resumen de venta
    Entonces doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA bloque "<bloque>"
    Y        doy click en el boton Guardar cambios
    Cuando   doy click en el boton Iniciar registro
    Y        ingreso la referencia de la direccion "Inkafarma"
    Y        presiono el boton Consultar ubicacion
    Y        "<insertarDireccion>" ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
      | A1 | EDIFICIO     | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    E        ingreso telefono de contacto "998877665"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy click en confirmar delivery
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en validar identidad del titular
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | insertarDireccion | channelType | documentType | documentNumber | correo           | nombreMadre | nombrePadre | distritoNac | bloque         |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | SI                | Call Center | DNI          | 42465007       | correo@gmail.com | MARIA       | SANTOS      | CASCAS      | Bloque HBO+ RV |

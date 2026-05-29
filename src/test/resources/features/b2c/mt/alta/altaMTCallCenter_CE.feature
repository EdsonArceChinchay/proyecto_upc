#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: ALTA
##ESTADO: ACTIVO
##CODIGO: AT-DT038
##GDAP: GDAP-589 v1
##GDAP: GDAP-1949 v2
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 28/05/2026

@BERSERKERS @QAN @DoneDevOps  @AltaMT
Característica: Alta MT a cliente con CE por canal Call Center

  @AltaMTCallCenter_CE
  Esquema del escenario: Alta MT a cliente con CE por canal Call Center
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU          | Test        | Transaccion | Tipo Venta | Tags                 |
      | Jorge Cancino | TIQLT-27971 | TIQLT-20528 | Alta MT     | Contado    | @AltaMTCallCenter_CE |
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
    ##Y        ingreso los datos del nuevo cliente
    ##  | nombres | apellidos | genero   |
    ##  | Pruebas | QAN       | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Cuando   ingreso el tipo de direccion "<tipodireccion>"
    E        ingreso el distrito,provincia y departamento "<direccion>"
    E        ingreso el tipo de via "<tipovia>"
    Y        completamos los datos faltantes de la direccion
             | nombrevia | puerta |manzana|lote|referencia|
             | JULIO CESAR TELLO|469|1|1|test |
    Y        doy click en el boton consultar
    Y        doy click en el boton confimar direccion
   ## Y        selecciono el departamento donde sera la instalacion "<departamento>"
   ## Y        selecciono la provincia donde sera la instalacion "<provincia>"
   ## Y        selecciono el distrito donde sera la instalacion "<distrito>"
   ## Y        ingreso la direccion donde sera la instalacion "<direccion>"
   ## Y        ingreso la referencia de la direccion "<referencia>"
   ## Y        presiono el boton Consultar ubicacion
    ##Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<planType>"
    Y        selecciono un plan Movistar Total "<planName>"
   ## Y        valido que este en el resumen de venta
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono el boton Consultar ubicacion
    Y        "<insertarDireccion>" ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto                 | conjHabit | lote |
      | A  | TORRE        | ALEX MANCILLA  | 1    | 1   | URBANIZACION RESIDENCIAL | RISSO     | 2    |
    Y        presiono el boton Confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    E        ingreso telefono de contacto "984592938"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy click en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 10/12/1990 | Divorciado  | Alemania     |
    Y        doy click en el boton confirmar
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
    Y        valido que se muestre el detalle del pedido de "Delivery"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "codigo de venta"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | insertarDireccion | channelType | documentType | documentNumber |tipodireccion |direccion         |tipovia| planType |planName |
      | userType | userNameCC |userPasswordCC  | Bienvenid@ | SI                | Call Center | CE           | 1042464796     |Casa          | LINCE, LIMA, LIMA|JIRON  | Trío MT  |Trio HD 400 Mbps RA + Ilimitado 120 Gb RA |


  ##CE : 1042464796
##Nombre de plan : Trio HD 400 Mbps RA + Ilimitado 120 Gb RA
## LLAMDADA Esquema del escenario: : Alta MT(Alta fija+ Alta movil) a CE por canal Call Center
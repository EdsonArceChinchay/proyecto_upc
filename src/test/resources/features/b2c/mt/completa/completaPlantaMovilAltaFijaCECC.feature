#language:es
##CREADOR: CARLOS RUIZ
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: COMPLETA FIJA
##ESTADO: ACTIVO
##CODIGO: AT-DT0
##GDAP: GDAP-1434
##SPRINT CREADO: PI18_SP2
##FRECUENCIA:SEMANAL
##TAG : BERSERKERS
##DATA: REUSABLE (CANCELAR ORDENES)
##ENCARGADO: CARLOS RUIZ
##FECMOD: 12/03/2024

@BERSERKERS @DoneDevOps @RegresionLegacy
Característica: Completa Fija MT por canal Call Center

  @CompletaFijaCC
  Esquema del escenario: Completa Fija MT por canal Call Center
    Dado que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA | HU         | Test       | Transaccion                                 | Tipo Venta | Tags            |
      | Eyme Aliaga | TIQLT-XXXX | TIQLT-XXXX | Completa Fija MT (Planta Movil + Alta Fija) | Contado    | @CompletaFijaCC |
    Cuando presiono el boton Iniciar Sesion
    Y selecciono el tipo de usuario "<userType>"
    Y ingreso el usuario "<userName>"
    Y ingreso el password "<userPassword>"
    Y ingreso el captcha
    Y presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y valido que se presente el canal "<channelType>"
    Cuando selecciono el tipo de documento "<documentType>"
    Y ingreso el documento "<documentNumber>"
    Y doy click en el boton Consultar
    Y selecciono la linea con numero "<numeroExistente>"
    Y selecciono el boton Linea Nueva Hogar
    Y selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Cuando   ingreso el tipo de direccion "<tipodireccion>"
    E        ingreso el distrito,provincia y departamento "<direccion>"
    E        ingreso el tipo de via "<tipovia>"
    Y        completamos los datos faltantes de la direccion
      | nombrevia | puerta |manzana|lote|referencia|
      | JULIO CESAR TELLO|469|1|1|test |
    Y        doy click en el boton consultar
    Y        doy click en el boton confimar direccion
    ## Entonces me muestra la pantalla para ingresar la direccion
    ## Y selecciono el departamento donde sera la instalacion "<departamento>"
   ##  Y selecciono la provincia donde sera la instalacion "<provincia>"
   ##  Y selecciono el distrito donde sera la instalacion "<distrito>"
   ##  Y ingreso la direccion donde sera la instalacion "<direccion>"
   ##  Y ingreso la referencia de la direccion "<referencia>"
   ##  Y presiono el boton Consultar ubicacion
   ##  Y presiono el boton Consultar cobertura
    Y selecciono tipo de oferta
    Y selecciono el plan "<nombrePlan>" Movistar Total
    Y doy click en el boton Ir a movistar total
    Cuando doy click en el boton Iniciar registro
    Y valido que me encuentre en la pantalla agendamiento
    Y ingreso los datos de agendamiento
    Y presiono el boton confirmar agendamiento
    Y ingreso correo electronico "<correo>"
    Y ingreso nuevamente el correo electronico "<correo>"
    Y doy click en Validar contrato ""
    Y me muestra en pantalla el contrato solicitado
    Y imprimo el texto del contrato solicitado
    Cuando doy clic en si acepto
    Y doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y doy click en ver detalle del pedido
    Y valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y valido que se muestre el detalle del pedido de "Información adicional"
    Dado regreso a la pagina de inicio
    Y valido que se presente el canal "<channelType>"
    Y me dirijo a la bandeja de Back Office
    Y busco por "codigo de venta"
    Y selecciono la solicitud
    Y cargo el audio en la web
    Y apruebo la solicitud

    Ejemplos:
      | userType | userName     | userPassword     | msgHome    | channelType | documentType | documentNumber | nombrePlan | correo                    | numeroExistente |tipodireccion |direccion         |tipovia|
      | userType | userNameCC   | userPasswordCC   | Bienvenid@ | Call Center | CE           | 1042464796     | Trío MT    | 1632547904@mailinator.com | 920959416       |Casa          | LINCE, LIMA, LIMA|JIRON  |


  ##CE : 1042464796
##Nombre de plan : Trio HD 400 Mbps RA + Ilimitado 120 Gb RA
##Alta MT(Alta fija+ Alta movil) a CE por canal Call Center
  ## llamaDA Esquema del escenario: : Completa Fija MT (Planta Movil + Alta Fija) a cliente con CE por canal Call Center
#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT0
##GDAP: GDAP-1661
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 02/07/2024

@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP-G01
Característica: AT-DT0_Completa Movil ( Planta Fija + Porta Directa Movil) en canal Call Center

  @CompletaPlantaFijaPortabilidadCC
  Esquema del escenario: Completa Planta Fija Porta Directa Movil
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que este activo el flag de Porta Directa
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        selecciono el boton de la Linea Hogar Existente "<numeroExistente>"
    Y        doy click en el boton portabilidad
    Y        selecciono el boton Mostrar ofertas
    Y        ingreso numero de telefono para portar "<numero>"
    Y        escojo tipo de linea "<tipoLinea>"
    Y        escojo tipo de operador "<operador>"
    Y        doy click en el boton Consultar Portabilidad
    Y        valido que este en la seccion Postpago o Prepago
    Y        selecciono el plan "<tipoPlan>" que desea
    Y        doy click en el boton Siguiente
    Entonces me muestra la pantalla para verificar la direccion
    #Y        presiono el boton Confirmar direccion
    Y        doy click en el boton "Actualizar direccion"
    Y        ingreso la referencia de la direccion "casa"
    Y        presiono el boton Consultar Ubicacion
    Y        presiono el boton consultar cobertura
    Y        doy clic en el boton "Entendido"
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Entonces me muestra la pantalla para ingresar la direccion de entrega
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono horario "3pm-7pm"
    E        ingreso telefono del titular "998877665"
    E        ingreso instrucciones de delivery "cerca al parque"
    Y        doy clic en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en el boton confirmar
    Y        doy click en validar identidad del titular
    Y        ingreso los datos solicitados para la validacion del cliente
      | nombrePadre   | nombreMadre   | distritoNac   |
      | <nombrePadre> | <nombreMadre> | <distritoNac> |
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en Finalizar registro
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "<documento>"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud
    Ejemplos:

      | tipoUsuario     | userName   | password | msgHome    | tipoDocumento | documento | numero    | tipoLinea | operador           | departamento | provincia | distrito | direccion                         | referencia | tipoPlan | nombrePlan | nombreMadre | nombrePadre | distritoNac          | numeroExistente |
      | usuario externo | userNameCC | passCC   | Bienvenid@ | DNI           | 74587265  | 920956351 | Postpago  | OPERADOR DE PRUEBA | 15           | 1501      | 150116   | JR JULIO CESAR TELLO 469 | Inkafarma  | Postpago | Trío       | MARIA       | FERNANDO    | JUSTO APU SAHUARAURA | 14352752        |



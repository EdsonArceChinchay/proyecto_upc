#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT096
##GDAP: GDAP-588
##SPRINT CREADO
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: VICTOR CARPIO
##FECMOD: 23/12/2023
@BERSERKERS @QAN @DoneDevOps @DoneDevOpsPI11

Característica: AT-DT096_Alta Movil Postpago CALL CENTER


  Antecedentes:
    Dado     que abro la pagina de movistar

  @MVP_Alta_Postpago_CALL_CENTER
  Esquema del escenario: Alta movil Postpago solo chip
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
#    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero    |
      | QAN     | veinticuatro | masculino |
#    Y        cierro popup de aviso
    Y        valido que muestre el nombre completo del cliente "<nombreCliente>"
    Y        selecciono el boton Linea Nueva Movil
    Y cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Y        valido que este en la pagina de ofertas sugeridas
    Y        selecciono tipo de oferta
#    Y        selecciono el plan_movil Postpago
#    Y        selecciono el boton de eleccion de planes
    #Y        selecciono el plan "Postpago" que desea
    #Y        doy click en el boton Siguiente
    #Y        valido que este en la pagina de ofertas sugeridas
    #Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan movil "<tipoPlanMovil>"
    Y        selecciono un plan movil "<nombrePlan>"
    #Y        valido que este en la seccion de registro "<nombrePlan>"
    Y        doy click en iniciar registro
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
#    Y        selecciono el distrito donde sera la instalacion "150116"
#    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y        selecciono el distrito donde sera la instalacion "150108"
    Y        ingreso la direccion donde sera la instalacion "JIRON JUNO 119"
    Y        ingreso la referencia de la direccion "INKAFARMA"
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Y        doy clic en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "jlopez@mail.com"
    Y        ingreso nuevamente el correo electronico "jlopez@mail.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Divorciado  | Alemania     |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Y        guardo el numero de solicitud
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    #Y        cierro popup de error
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        valido que se muestre el detalle del pedido
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "solicitud"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud


    Ejemplos:
      | tipoUsuario     | userName      | password      | msgHome    | tiendaAsesor                  | nombreCliente              | tipoDocumento | documento  | tipoPlanMovil | nombrePlan                              |
      #| usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | Juan Lopez Anibal |CE            | 1075266100  | Postpago      | Plan Ilimitado |
#      | usuario interno |  | | Bienvenid@ | ntt data qan call in venta cc | QAN veinticuatro | CE            | 1100000824 | Postpago      | RV Plan Ilimitado Mi Movistar S/ 74.9 V |
      | usuario interno |               || Bienvenid@ | ntt data qan call in venta cc | Prueba QAN DCC NOVENTAIUNO | CE            | 1100000791 | Postpago      | RV Plan Ilimitado Mi Movistar S/ 74.9 V |

#chorillos 150108
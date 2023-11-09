#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT033
##GDAP: GDAP-573
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @DROPG3

Característica: AT-DT033_Alta Fija + Alta Movil por Call Center

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaMovilCallCenterDeliveryExpress
  Esquema del escenario: Alta fija mas alta movil por Call Center con DNI sin productos asociados y delivery express
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    #Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero    |
      | Juan    | Lopez Anibal | masculino |
#    Y        cierro popup de aviso
    Y        valido que muestre el nombre completo del cliente "Juan Lopez Anibal"
      ##lineas agregadas
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    #Y cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion

    #Y        ingreso la informacion del lugar de instalacion
     # | mz | lote | vivienda | nombreVivienda   | piso | int | conjunto             | conjHabit  |
     # | A  | 1    | EDIFICIO | Familia Huancari | 1    | 1   | URBANIZACION POPULAR | conjunto b |

    Y        ingreso la informacion del lugar de instalacion
      | mz | vivienda | nombreVivienda   | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO | Familia Huancari | 1    | 1   | URBANIZACION POPULAR | conjunto b |

    Y        presiono el boton consultar cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono Consultar ubicacion

    #Y        ingreso la informacion del lugar de instalacion
     # | mz | lote | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      #| A  | 1    | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |

    Y        ingreso la informacion del lugar de instalacion
      | mz | vivienda | nombreVivienda  | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO | Familia Barreto | 1    | 1   | URBANIZACION POPULAR | conjunto b |

    Y        presiono el boton confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Express"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Y        doy clic en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
      ## paso agregado
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    ##Y        doy click en validar identidad del titular
    #Y        doy click en el boton confirmar validacion
      ##paso descomentado y modificado, a veces aparece el modal y otras no.
    ##Y        ingreso los datos solicitados para la validacion del cliente
      ##| nombreMadre   | nombrePadre   | distritoNac   |
      ##| <nombreMadre> | <nombrePadre> | <distritoNac> |
    ##Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | nacionalidad | estadoCivil |
      | 01/12/1990 | Angola   | Casado   |
    Y        doy click en el boton confirmar
    Y        presiono la opcion validar contrato
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
#    Y        doy clic en finalizar registro
    #Y        doy click en Finalizar registro
      #paso comentado
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:

      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor                 | tipoDocumento | documento | departamento | provincia | distrito | direccion                   | referencia | nombrePlan          | nombreMadre | nombrePadre | distritoNac            |
      | usuario externo | jpachaot | $t3l3f0n1c4$| Bienvenid@ | CANAL ONLINE-CALL CENTER GSS | CE            | 0653434232  | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | av       | Dúo BA TV HD 1 Gb RA + 95 Gb RA | CARMEN      | FRANCISCO   | SAN JUAN DE LURIGANCHO |



  @AltaFijaMovilCallCenterSinProductosDeliveryRegular
  Esquema del escenario: Alta fija mas alta movil por Call Center con DNI sin productos asociados y delivery regular
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero    |
      | Juan    | Lopez Anibal | masculino |
#    Y        cierro popup de aviso
    Y        valido que muestre el nombre completo del cliente "Juan Lopez Anibal"
      ##lineas agregadas
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
      | mz | vivienda | nombreVivienda   | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO | Familia Huancari | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
#    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        valido el detalle de la seleccion
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | vivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO | Familia Ccallo | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton confirmar ubicacion
    Y        selecciono un tipo de entrega "Delivery Regular 48 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso el telefono de contacto "658745259"
    Y        ingreso las instrucciones a considerar de la entrega "En la cuadra 8 a la derecha"
    Y        doy clic en confirmar delivery
    Y        valido que este en la seccion completa los datos solicitados
      ## paso agregado
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    #Y        doy click en validar identidad del titular
    #Y        doy click en el boton confirmar validacion
    ##Y        ingreso los datos solicitados para la validacion del cliente
      ##| nombreMadre   | nombrePadre   | distritoNac   |
      ##| <nombreMadre> | <nombrePadre> | <distritoNac> |
    ##Entonces valido que me muestre el boton con el texto de identidad validada
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Divorciado  | Alemania     |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    ##Y        doy clic en finalizar registro
      #paso comentado
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
      ## pasos agregados
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido

    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor              | tipoDocumento | documento | departamento | provincia | distrito | direccion                   | referencia | nombrePlan          | nombreMadre | nombrePadre | distritoNac            |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | PRUEBAS SIST CALLIN VENTA | CE            | 03212011  | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | 200 Mbps RV + 95 Gb | CARMEN      | FRANCISCO   | SAN JUAN DE LURIGANCHO |



#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1422
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 03/11/2023

@BERSERKERS @DoneDevOps
Característica: CAEQ Financiado con documento CE por Canal Call Center
#CAEQ DROP
  @CaeqFinanciadoCECallcenter
  Esquema del escenario: CAEQ Financiado con documento CE por Canal Call Center
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<numeroDocumento>"
    Y        doy click en el boton consultar
    Y        selecciona el boton de detalle del numero de celular existente "<EncontrarCelular>"
    Y        presiono el boton Renovar Plan
#    Y        selecciono el boton Ver detalle del plan actual y presiono el boton Renovar Plan
    Entonces valido que se presente la pantalla con el titulo "Ofertas sugeridas"
    Y        presiona el boton anadir equipo
    #Y        selecciono el boton de eleccion de planes
    #Y        selecciono el plan movil "Prepago"
    #Y        selecciono la opcion "Prepago con Tarifa Única"
    #Y        doy click en el boton seleccionar oferta
    #Y        selecciono añadir equipos
    E        ingreso permanencia, tipo de pago y equipo
      | permanencia     | tipoPago             | equipoName |
      | Sin permanencia | Financiado 12 cuotas | HONOR      |
    Y        valido que existan resultados busqueda de equipos
    Y        presiono el boton Ver detalle valido contenido y selecciono
    #Y        cierro pop up de Cliente Exonerado
    #Y        doy click en el boton continuar
    Y        doy click en el boton "MANTENER PLAN"
    Y        doy click en iniciar registro
    Y        selecciono el departamento donde sera la instalacion "15"
    Y        selecciono la provincia donde sera la instalacion "1501"
    Y        selecciono el distrito donde sera la instalacion "150116"
    Y        ingreso la direccion donde sera la instalacion "JIRON JULIO CESAR TELLO 469"
    Y        ingreso la referencia de la direccion "conjunto b"
    Y        presiono Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO     | Familia Lopez  | 1    | 1   | URBANIZACION POPULAR | conjunto b |
    Y        presiono el boton consultar cobertura
    Y        selecciono un tipo de entrega "Delivery Regular 24 horas"
    Y        selecciono el horario de entrega "3pm-7pm"
    Y        ingreso el telefono de contacto "956756143"
    Y        ingreso las instrucciones a considerar de la entrega "abc"
    Y        doy clic en confirmar delivery
    Y        selecciono el metodo de pago "Contra entrega"
    Y        ingreso un correo electronico "prueba_qa@gmail.com"
    Y        ingreso nuevamente el correo electronico "prueba_qa@gmail.com"
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "solicitud"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

    Ejemplos:
      | tipoUsuario     | userName   | password | tipoDocumento | numeroDocumento | EncontrarCelular |
      | usuario externo | userNameCC | passCC   | CE            | 1100000765      | 984594042        |
#      | usuario interno | userNameQAN | passQAN  | CE            | 1100000788      | 984594042        |
#      | usuario interno | userNameQAN | passQAN  | CE            | 1100000232      | 963601123        |
#      Prueba error
#      | usuario interno | userNameQAN | passQAN  | CE            | 1100000765      | 985448456        |
#      | usuario interno | userNameQAN | passQAN  | CE            | 1100000529      | 994460680        |
#      | usuario interno | userNameQAN | passQAN  | CE            | 221011126       | 976579464        |


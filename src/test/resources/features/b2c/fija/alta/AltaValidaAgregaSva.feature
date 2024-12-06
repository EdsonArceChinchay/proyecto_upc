#language:es
##CREADOR: Romina Torres
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1403
##SPRINT CREADO:
##FRECUENCIA:
##TAG :
##DATA:
##ENCARGADO: Romina Torres - CATÁLOGO
##FECMOD: 02/08/2023
@BERSERKERS @DoneDevOps
Característica: Agregar SVA - Planes: Monos, dúos, trios

  @AltaMonoBB
  Esquema del escenario: Plan <tipoPlan> Oferta <nombrePlan> + SVA Movistar Tv App
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "<channelType>"
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
	#Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos    | genero   |
      | Lana    | Grey Khalifa | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar para la instalacion
      | mz | lote | tipoVivienda | nombreVivienda | bloque | piso | int | conjunto             | conjHabit |
      | A  | 1    | EDIFICIO     | EDIFICIO       | A      | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    #Y        selecciono el boton Linea Nueva
    Entonces valido en la etapa resumen el nombre del plan escogido "<nombrePlan>"
  #  Y valido la velocidad de internet "<velocidadBB>"
    Y        valido el precio de descuento del componente Internet "<precDescBB>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Agregar SVA
    Y        valido que me encuentre en la pantalla "Añade tus servicios adicionales (SVA's)"
    Y        agrego SVA Movistar Tv App Max
    Y        doy click en el boton Guardar cambios
	#Y        agrego SVA internet "<svaInternet>"
   # Y        valido el precio de descuento del componente TV "<precDescTV>"
    Y        doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "Angel.mf@gmail.com"
    Y        ingreso nuevamente el correo electronico "Angel.mf@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/01/1996 | Divorciado  | Aruba        |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | userType | userName   | userPassword   | msgHome    | channelType | documentType | documentNumber | departamento | provincia | distrito | direccion                   | referencia | plan_hogar | nombrePlan                                | svaTV               | velocidadBB | precDescBB                      | precDescTV                               | bloque | tipoPlan | svaInternet           | bloque |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1022233148     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | INTERNET MOVISTAR RA S23 200 MBPS         | Combo Plus Bonif TV | 200 Mbps    | Descto Plan Internet 50% x 2 ms | Dscto Prom Movistar TV App INT S/80 x 2m | HBO    | Mono     | PACK ANTIVIRUS MCAFEE | HBO    |
     # | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center   | CE            | 1022233148 | LIMA      | LIMA      | LINCE   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TV HOGAR DIGITAL RA M23                        | Combo Plus Bonif TV | 200 Mbps    | Descuento Prom Internet S/40 x 1m | Descuento Prom Movistar TV App TV S/9.90 x 2m | HBO    | Mono     | PACK ANTIVIRUS MCAFEE | HBO    |
   #   | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center   | CE            | 1022233148 | LIMA      | LIMA      | LINCE   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRIO INT TV VOZ RA S23 400 MBPS           | Combo Plus Bonif TV | 600 Mbps    | Descto Plan Internet 50% x 2 ms | Dscto Prom Movistar TV App INT S/80 x 2m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
     # | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center   | CE            | 1022233148 | LIMA      | LIMA      | LINCE   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TV ESTÁNDAR DIGITAL RA M23                     | Combo Plus Bonif TV | 600 Mbps    | Descuento Prom Internet S/40 x 1m | Descuento Prom Movistar TV App TV S/9.90 x 2m | HBO    | Mono     | PACK ANTIVIRUS MCAFEE | HBO    |
      | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center | CE           | 1022234148     | LIMA         | LIMA      | LINCE    | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | DUO MOVISTAR VOZ INTERNET RA S23 600 MBPS | Combo Plus Bonif TV | 200 Mbps    | Descto Plan Internet 50% x 2 ms | Dscto Prom Movistar TV App INT S/80 x 2m | HBO    | Duo      | PACK ANTIVIRUS MCAFEE | HBO    |
     # | userType | userNameCC | userPasswordCC | Bienvenid@ | Call Center   | CE            | 1022233149 | LIMA      | LIMA      | LINCE   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | DUO MOVISTAR VOZ ESTÁNDAR HD RA M23           | Combo Plus Bonif TV | 200 Mbps    | Descuento Prom Internet S/40 x 1m | Descuento Prom Movistar TV App TV S/9.90 x 2m | HBO    | Duo      | PACK ANTIVIRUS MCAFEE | HBO    |

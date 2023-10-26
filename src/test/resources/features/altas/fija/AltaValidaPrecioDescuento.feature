#language:es
##CREADOR: Romina Torres
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT
##GDAP: GDAP-1401
##SPRINT CREADO:
##FRECUENCIA:
##TAG :
##DATA:
##ENCARGADO: Romina Torres - CATÁLOGO
##FECMOD: 02/08/2023

@BERSERKERS @DoneDevOps
Característica: Validar precio de descuento BB - Planes: Duos, trios

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaTrio_VozTVBB
  Esquema del escenario: Validar precio de descuento BB - Planes: Duos, trios
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
	#Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
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
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Y selecciono el boton Linea Nueva
    Entonces valido en la etapa resumen el nombre del plan escogido "<nombrePlan>"
    Y valido la velocidad de internet "<velocidadBB>"
    Y valido el precio de descuento del componente Internet "<precDescBB>"
  #  Y        doy click en añadir SVA
  #  Y        doy click en agregar Bloque "<bloque>"
  #  Y        doy click en Guardar cambios
	#Y        doy click en agregar "<svaInternet>"
    E        inicio su registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "Angel.mf@gmail.com"
    Y        ingreso nuevamente el correo electronico "Angel.mf@gmail.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Divorciado  | Aruba        |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
#    Y        presiono el boton Registrar venta
#	Y        valido que se muestre el detalle del pedido
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | plan_hogar | nombrePlan                                     | svaTV               | velocidadBB | precDescBB                          | bloque | tipoPlan | svaInternet           | bloque |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | DÚO MOVISTAR VOZ INTERNET RA M23 200 MBPS      | Combo Plus Bonif TV | 200 Mbps    | Descuento Prom Internet S/40 x 1m   | HBO    | Duo      | PACK ANTIVIRUS MCAFEE | HBO    |
      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 200 MBPS | Combo Plus Bonif TV | 200 Mbps    | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 100 MBPS  | Combo Plus Bonif TV | 100 Mbps    | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 150 MBPS  | Combo Plus Bonif TV | 150 Mbps    | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 1000 MBPS | Combo Plus Bonif TV | 1000 Mbps   | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
#      | usuario externo | jpachaot | $t3l3f0n1c4$ | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 600 MBPS | Combo Plus Bonif TV | 600 Mbps    | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |



  @AltaMonoBeneficioDescuento
    #Consideraciones del uso del script
    #Ingresar el usuario y su tipo de usuario
    #Flujo construido para validacion con CE
    #Los campos nombre, Apellido y Genero son Obligatorios.
    # En el caso de que el cliente este registrado solo llenar el nombre y apellido para que se valide que es el cliente consultado y dejar el genero en Femenino o Masculino
    #Los campos de instalacion son obligatorios.
    #Tipo de Plan se deja como Mono
    #Ingresar el plan a validar en el campo nombrePlan
    #Ingresar el beneficio aplicado al plan, en caso no se valide el beneficio dejar vacio.
    #Ingresar el Descuento aplicado al plan, en caso no se valide el descuento dejar vacio.
    #El campo ID puede ser llenado en caso de que se encunetre activo se utilizara en caso contrario se saltara el paso.
  Esquema del escenario: Validar planes Beneficios y Descuento Mono Cliente Nuevo Existente - Documento CE
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso la contraseña
    Y        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        valido si el cliente "<nombre>", "<apellido>" con genero "<genero>" ya esta registrado
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde se instalara "<departamento>"
    Y        selecciono la provincia donde se instalara "<provincia>"
    Y        selecciono el distrito donde se instalara "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    #Y        ingreso la informacion del lugar para la instalacion
    #  | mz | lote | tipoVivienda | nombreVivienda | bloque | piso | int | conjunto             | conjHabit |
    #  | A  | 1    | EDIFICIO     | EDIFICIO       | A      | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura nueva
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija elegido "<tipoPlan>"
    Y        selecciono los planes fijos:
      |   escenario | nombrePlan                        | precio                    | beneficioPlan                     | descuentoPlan |
  | 020 Mono| Internet Movistar RA S23 600 MB   | S/ 169.9                  | Bono 1000 Mbps/500 Mbps x 6 meses  | DESCUENTO 1              |
  | 020 Mono| Internet Movistar RA S23 400 MB   | S/ 99.9                  | Bono 200 Mbps/200 Mbps x 6 meses | DESCUENTO 2             |
    Y        Doy click en el boton cerrar
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija elegido "<tipoPlan>"
    Y        selecciono el plan para envio orden "<nombrePlan>"
    E        inicio su registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "Angel.mf@gmail.com"
    Y        ingreso el callId "<Call ID>"
    Y        valido el ingreso de datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Divorciado  | Aruba        |
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:

      | tipoUsuario     | userName | msgHome    | tipoDocumento | documento  | nombre              | apellido           | genero    | departamento | provincia | distrito | direccion                   | referencia | nombrePlan                      | precio   | tipoPlan | beneficioPlan                     | descuentoPlan | Call ID |
      | usuario externo | jpachaot | Bienvenid@ | CE            | 856575424  | MCONewFirstName1405 | MCONewLastName1405 | Femenino  | Lima         | Lima      | Lince    | JIRON JULIO CESAR TELLO 469 | Casa       | Internet Movistar RA S23 100 MB | S/ 99.90 | Mono     | Bono 1000 Mbps/500 Mbps x 6 meses |               | 1234    |
      #| usuario interno | jpachaot | Bienvenid@ | CE            | 1022233148 | Lana                | Grey Khalifa       | Masculino | Lima         | Lima      | Lince    | JIRON JULIO CESAR TELLO 469 | Casa       | Internet Movistar RA S23 1000 MB | S/ 79.90 | Mono     | Bono 200 Mbps/200 Mbps x 6 meses  |               | 123     |

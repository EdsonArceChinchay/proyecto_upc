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
##FECMOD: 06/12/2023

@BERSERKERS @DoneDevOps @ValidacionDescuentos
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
    #Y        selecciono el boton Linea Nueva
    Entonces valido en la etapa resumen el nombre del plan escogido "<nombrePlan>"
    Y        valido la velocidad de internet "<velocidadBB>"
    Y        valido el precio de descuento del componente Internet "<precDescBB>"
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
      | 01/09/1990 | Divorciado  | Aruba        |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
#    Y        presiono el boton Registrar venta
#	Y        valido que se muestre el detalle del pedido
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | plan_hogar | nombrePlan                                     | svaTV               | velocidadBB | precDescBB                      | bloque | tipoPlan | svaInternet           | bloque |
      | usuario externo | userNameCC | passCC | Bienvenid@ | CAJAMARCA    | CE            | 1022233168 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | DUO INTERNET ESTANDAR HD RA S23 600 MBPS       | Combo Plus Bonif TV | 300 Mbps    | Descto Plan Internet 50% x 2 ms | HBO    | Duo      | PACK ANTIVIRUS MCAFEE | HBO    |
      | usuario externo | userNameCC | passCC | Bienvenid@ | CAJAMARCA    | CE            | 1022233169 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRIO MOV. VOZ INT. ESTANDAR HD RA S23 600 MBPS | Combo Plus Bonif TV | 300 Mbps    | Descto Plan Internet 50% x 2 ms | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
#      | usuario externo | userNameCC | passCC | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 100 MBPS  | Combo Plus Bonif TV | 100 Mbps    | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
#      | usuario externo | userNameCC | passCC | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 150 MBPS  | Combo Plus Bonif TV | 150 Mbps    | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
#      | usuario externo | userNameCC | passCC | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 1000 MBPS | Combo Plus Bonif TV | 1000 Mbps   | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
#      | usuario externo | userNameCC | passCC | Bienvenid@ | CAJAMARCA    | CE            | 1022233148 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo        | TRÍO MOV. VOZ INT. ESTANDAR HD RA M23 600 MBPS | Combo Plus Bonif TV | 600 Mbps    | Descuento Prom Internet S/13.5 x 1m | HBO    | Trio     | PACK ANTIVIRUS MCAFEE | HBO    |
##


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
  Esquema del escenario: Validar planes Beneficios y Descuento Mono Cliente Nuevo/Existente - Documento CE
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    #Y        ingreso el captcha
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
    Y        ingreso la informacion del lugar para la instalacion
      | mz | lote | tipoVivienda | nombreVivienda | bloque | piso | int | conjunto             | conjHabit |
      | A  | 1    | EDIFICIO     | EDIFICIO       | A      | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        escojo el plan "<nombrePlan>"
    Y        Valido que el beneficio sea "<beneficioPlan>"
   # Y        Valido que el descuento aplicado sea "<descuentoPlan>"
    Y        selecciono el boton Linea Nueva
    Entonces valido en la etapa resumen el nombre del plan escogido "<nombrePlan>"
    Y        valido el precio establecido sea "<precio>"
    E        inicio su registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "Angel.mf@gmail.com"
  #  Y        ingreso el callId "<Call ID>"
    Y        valido el ingreso de datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/05/1990 | Divorciado  | Aruba        |
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
      | tipoUsuario     | userName | password     | msgHome    | tipoDocumento | documento | nombre              | apellido           | genero   | departamento | provincia | distrito | direccion                   | referencia | nombrePlan                        | precio   | tipoPlan | beneficioPlan                     | descuentoPlan | Call ID |
     # | usuario externo | userNameCC | passCC | Bienvenid@ | CE            | 102223310 | Lana                | Grey Khalifa       | Masculino | Lima         | Lima      | Lince    | JIRON JULIO CESAR TELLO 469 | Casa       | INTERNET MOVISTAR RA S23 400 MBPS | S/139.90 | Mono     | Bono 1000 Mbps/500 Mbps x 6 meses |               | 123     |
      | usuario externo | userNameCC | passCC | Bienvenid@ | CE            | 856575420 | MCONewFirstName1405 | MCONewLastName1405 | Femenino | Lima         | Lima      | Lince    | JIRON JULIO CESAR TELLO 469 | Casa       | INTERNET MOVISTAR RA S23 200 MBPS | S/ 99.90 | Mono     | Bono 1000 Mbps/500 Mbps x 6 meses |               | 1234    |

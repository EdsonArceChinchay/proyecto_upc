#language:es

##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-1186
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: MARIA SANCHEZ
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI14 @Sanity28 @AltaFija
Característica: Alta Trio con sva Modem + sva Linea + sva Internet Canal Retail

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaTrioSvaModemSvaLineaSvaInternetRetail
  Esquema del escenario: Alta Trio con sva Modem + sva Linea + sva Internet Canal Retail
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente extranjero a registrar
      | nombres | apellidos      | genero    |
      | Jose    | Lopez Sanabria | masculino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | D  | EDIFICIO | Familia Lopez  | 3    | 2   | URBANIZACION POPULAR | conjunto c |
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Y        valido que este en la seccion de registro
    Y        doy click en agregar Modem
    Y        doy click en agregar SVA Linea "<svaLinea>"
    Entonces doy click en Agregar Sva
    Y        agrego "<svainternet>"
    Y        doy click en Guardar cambios
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "tester_12_45@tester.com"
    Y        ingreso nuevamente el correo electronico "tester_12_45@tester.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 15/10/1994 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Ejemplos:
      | tipoUsuario     | userName  | password     | msgHome    | tipoDocumento | documento  | departamento | provincia | distrito | direccion            | referencia             | tipoPlan | nombrePlan                                        | svaLinea              | svainternet           |
      | usuario externo | userNameST | passST | Bienvenid@ | CE            | 1059122148 | 15           | 1501      | 150136   | CALLE SAN MARTIN 399 | AL FRENTE DE LA BOTICA | Trio     | TRÍO MOV. VOZ INTERNET ESTANDAR RA 1D D22 50 MBPS | Plan Multidestino  20 | PACK ANTIVIRUS MCAFEE |
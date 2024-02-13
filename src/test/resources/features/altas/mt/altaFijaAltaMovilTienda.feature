#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT036
##GDAP: GDAP-1000
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Sanity28 @DROP-G08

Característica: AT-DT036_Alta Fija + Alta Movil por Tienda

  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaMovilTienda
  Esquema del escenario: Alta fija mas alta movil por Tienda con CE sin productos asociados sin biometria
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
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos | genero   |
      | Luisa   | Cabello   | femenino |
#    Y        cierro popup de aviso
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Linea Nueva Movil
    Y cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda   | piso | int | conjunto                 | conjHabit  |
      | A  | EDIFICIO     | Familia Huancari | 1    | 1   | URBANIZACION RESIDENCIAL | conjunto b |
    Y        presiono el boton consultar cobertura
    Entonces me muestra la pantalla de ofertas sugeridos
    #Y        selecciono el tipo de oferta "<tipoOferta>"
    #Y        selecciono el tipo de plan "<tipoPlan>"
    #Y        valido el detalle de la seleccion
    Y        selecciono tipo de oferta
    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 11/02/1990 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    #Y        valido que se muestre el detalle del pedido
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor      | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | tipoOferta     | nombrePlan                | correo           |
      | usuario externo | userNameST | passST   | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1567400000 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | INKAFARMA  | MOVISTAR TOTAL | HD 500 Mbps RA + 95 Gb RA | correo@gmail.com |
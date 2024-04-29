#language:es
##CREADOR:  HENRY 
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT017
##GDAP: GDAP-979
##SPRINT CREADO: PI
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 13/02/2024

@BERSERKERS @DoneDevOps @AltaSVABloqueHBO @Sanity28 @DROP @AltaFija @AltaTrio

Característica: AT-DT017_Alta Fija Trio con SVA Bloque HBO con documento en CE por Canal Tienda

  @AltaSVABloqueHBO
  Esquema del escenario: Alta Tienda Fija Trio con SVA Bloque HBO sin productos asociados sin biometria
    Dado     que abro la pagina de movistar
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
      | MOISES  | MENDOZA ZAPATA | MASCULINO |
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
    #  | mz | tipoVivienda | nombreVivienda   | piso | int | conjunto                 | conjHabit  |
    #  | A  | EDIFICIO | Familia Huancari | 1    | 1   | URBANIZACION RESIDENCIAL | conjunto b |
    Y        presiono el boton consultar cobertura
#    Entonces me muestra la pantalla de ofertas sugeridos
    Y        selecciono tipo de oferta
#    Y        selecciono un plan Movistar Total "<nombrePlan>"
    Y        selecciono el plan "<nombrePlan>"
#    Y        valido el detalle de la seleccion
    Y        valido que este en la seccion de registro
    Y        doy click en añadir SVA
    Y        doy click en agregar Bloque "<bloque>"
    Y        doy click en Guardar cambios
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1993 | Casado      | Angola       |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato Movil
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor | tipoDocumento | documento | departamento | provincia | distrito | direccion                   | referencia | tipoOferta     | nombrePlan                  | bloque | correo           |
      | usuario externo | userNameST | passST   | Bienvenid@ | CAJAMARCA    | CE            | 102210207 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | PISO 1     | MOVISTAR TOTAL | TRIO MOV. VOZ INT. ESTANDAR | HBO    | correo@gmail.com |



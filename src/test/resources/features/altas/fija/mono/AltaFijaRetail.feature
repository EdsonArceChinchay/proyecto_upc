#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO: AT-DT007
##GDAP: GDAP-576
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO:
##FECMOD: 30/03/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI11 @Regresion_Carlos @DROP-G01
Característica: AT-DT007_Alta Fija Mono Internet por Retail


  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaFijaPorRetail_CE
  Esquema del escenario: Alta fija Retail con Nuevo Cliente Extranjero
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
#    Y        valido que se presente la tienda "<tiendaAsesor>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        completo los datos para consultar la cobertura
      | departamento | provincia | distrito | direccion                   | referencia |
      | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | parque     |
    Y        presiono el boton Consultar Ubicacion
    Y        ingreso la informacion del lugar para la instalacion
      | vivienda | nombreVivienda | conjunto             | conjHabit |
      | CASA     | alex mancilla  | URBANIZACION POPULAR | casa      |
    Y        presiono el boton Consultar Cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso un correo electronico "hola@gmail.com"
    Y        ingreso nuevamente el correo electronico "hola@gmail.com"
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 09/03/1999 | Casado      | Albania      |
    Y        doy click en el boton confirmar
    Y        doy clic para validar contrato hogar
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy clic en continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName     | password     | msgHome    | tiendaAsesor | tipoDocumento | documento  | departamento | provincia | distrito | direccion                     | referencia | tipoPlan | nombrePlan               |
      | usuario externo | evillanuevag | $t3l3f0n1c4$ | Bienvenid@ | MOQUEGUA     | CE            | 2212464816 | 15           | 1501      | 150136   | Calle Condesa de Chinchon 107 | Casa       | Mono     | INTERNET MOVISTAR RA D22 |
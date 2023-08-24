#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO:
##CODIGO:
##GDAP: GDAP-
##SPRINT CREADO: SPRINT 1
##FRECUENCIA:
##TAG : BERSERKERS
##DATA:
##ENCARGADO: Eloy Milla
##FECMOD: 10/07/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI16

Característica: Alta Duo con direccion sugerida por Canal Tiendas
  Antecedentes:
    Dado     que abro la pagina de movistar

  @AltaDuoDireccionSugeridaTienda
  Esquema del escenario: Alta Duo con direccion sugerida
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos    | genero   |
      | Miguel  | Mejia        | Masculino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "<departamento>"
    Y        selecciono la provincia donde sera la instalacion "<provincia>"
    Y        selecciono el distrito donde sera la instalacion "<distrito>"
    Y        ingreso la direccion donde sera la instalacion "<direccion>"
    Y        ingreso la referencia de la direccion "<referencia>"
    Y        presiono el boton Consultar ubicacion
    Y        selecciono una direccion sugerida
    Y        presiono el boton consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "<tipoPlan>"
    Y        selecciono el plan "<nombrePlan>"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso telefono de contacto
    Y        presiono el boton Confirmar agendamiento
    Y        ingreso email "prueba@gmail.com" y lo repito
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | nacionalidad | estadoCivil  |
      | 12/12/1980 | Albania      | Casado       |
    Y        doy click en el boton confirmar
    Y        presiono la opcion validar contrato
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    #Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada

    Ejemplos:
      | tipoUsuario     | userName   | password        | msgHome   | tipoDocumento | documento | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan
      | usuario externo |evillanuevag| $Telefonica2099%|Bienvenid@ | CE            | 123453910 | 15           | 1501      | 150116   | Av. Ignacio Merino 1999-1901 | Casa       | Duo      | DÚO INTERNET ESTÁNDAR HD RA M23 200 MBPS
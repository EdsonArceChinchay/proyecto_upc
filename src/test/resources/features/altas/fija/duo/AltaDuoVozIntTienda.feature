#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO:
##GDAP: GDAP-1384
##SPRINT CREADO: PI15_SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO: Patricia Cabello Huayta
##FECMOD: 30/05/2023

@BERSERKERS @DoneDevOps @DoneDevOpsPI15
Característica: Alta Duo (Voz + Internet) con instalación FTTH con documento CE por Canal Tiendas

  @AltaDuoBByVozFTTHCanalTiendas
  Esquema del escenario: Alta Duo (Voz + Internet) con instalación FTTH con documento CE por Canal Tiendas
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<tipoUsuario>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<password>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Cuando   selecciono el tipo de documento "<tipoDocumento>"
    Y        ingreso el documento "<documento>"
    Y        doy click en el boton consultar
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos | genero    |
      | Miguel  | Mejia     | Masculino |
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
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit  |
      | A  | EDIFICIO     | Flores         | 1    | 1   | URBANIZACION POPULAR | conjunto A |
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
      | fechaNac   | nacionalidad | estadoCivil |
      | 12/12/1992 | Albania      | Casado      |
    Y        doy click en el boton confirmar
    Y        presiono la opcion validar contrato
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Ejemplos:
      | tipoUsuario     | userName   | password | msgHome    | tiendaAsesor      | tipoDocumento | documento  | departamento | provincia | distrito | direccion                   | referencia | tipoPlan | nombrePlan                   |
      | usuario externo | userNameST | passST   | Bienvenid@ | TIENDA SAN MIGUEL | CE            | 1234539198 | 15           | 1501      | 150116   | JIRON JULIO CESAR TELLO 469 | Casa       | Duo      | DUO MOVISTAR VOZ INTERNET RA |
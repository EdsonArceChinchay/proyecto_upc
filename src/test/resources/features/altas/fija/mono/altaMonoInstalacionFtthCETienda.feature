#language:es
##CREADOR:
##APP: DITO
##MODULO:
##FUNCIONALIDAD:
##ESTADO: ACTIVO
##CODIGO: AT-DT011
##GDAP: GDAP-582
##SPRINT CREADO: PI11_SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 12/02/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP4 @Sanity28 @DROP-G04 @LocalDrop @AltaFija
Característica: AT-DT011_Alta de Mono Internet con instalación FTTH con documento CE por Canal tienda

  @AltaMonoFtthTienda
  Escenario: Realizar una Alta de Mono con instalación FTTH por Canal tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "usuario externo"
    Y        ingreso el usuario "userNameST"
    Y        ingreso el password "passST"
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
      #Y        valido que se presente la tienda "TIENDA SAN MIGUEL"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1042464814"
    Y        doy click en el boton consultar
    Y        cierro popup de error
    Y        ingreso los datos del cliente a registrar
      | nombres | apellidos   | genero   |
      | Ana     | Lopez Lopez | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        completo los datos para consultar la cobertura
      | departamento | provincia | distrito | direccion               | referencia |
      | 15           | 1501      | 150136   | CONDESA DE CHINCHON 109 | parque     |
    Y        presiono el boton Consultar Ubicacion
      #Y        ingreso la informacion del lugar para la instalacion
       # | mz | tipoVivienda | nombreVivienda | piso | int | conjunto             | conjHabit |
        #| A  | EDIFICIO | alex mancilla  | 1    | 1   | URBANIZACION POPULAR | casa      |
    Y        presiono el boton Consultar Cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan fija "Mono"
    Y        selecciono el plan "INTERNET MOVISTAR RA O23 100 MBPS"
    Cuando   doy clic a iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso telefono de contacto
    Y        presiono el boton Confirmar agendamiento
    Y        ingreso email "edith@gmail.com" y lo repito
    Y        doy click en datos del cliente
    Y        ingreso los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/12/1980 | Casado      | Aruba        |
    Y        doy click en el boton confirmar
    Y        presiono la opcion validar contrato
    Y        me muestra en pantalla el contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
      #Y        presiono el boton descargar contrato
    Y        presiono el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido del "Servicio Hogar"

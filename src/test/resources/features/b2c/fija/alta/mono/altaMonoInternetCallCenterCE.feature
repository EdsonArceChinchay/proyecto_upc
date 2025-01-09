#language:es
##CREADOR:
##APP: DITO
##MODULO: FIJA
##FUNCIONALIDAD: ALTA MONO INTERNET
##ESTADO: ACTIVO
##CODIGO: AT-DT011
##GDAP: GDAP-582
##SPRINT CREADO: PI11_SP4
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 08/04/2024

@BERSERKERS @DoneDevOps @DoneDevOpsPI11SP4 @Sanity28 @DROP-G04 @LocalDrop @AltaFija @AltaMono
Característica: AT-DT011_Alta de Mono Internet con instalación HFC a cliente con CE por canal Call Center

  @AltaMonoIntHFC @QAN
  Escenario: Realizar una Alta de Mono con instalación HFC por canal Call Center
    Dado     que abro la pagina de movistar
    Y ingreso los datos para la bitacora
      | Analista QA   | HU           | Test        | Transaccion   | Tipo Venta |
      | Lucero Obispo | TIQLT-JR1220 | TIQLT-20528 | ALTA FIJA DUO | Contado    |
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "userType"
    Y        ingreso el usuario "userNameQAN5"
    Y        ingreso el password "userPasswordQAN5"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        valido que se presente el canal "Call Center"
    Cuando   selecciono el tipo de documento "CE"
    Y        ingreso el documento "1100002107"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres   | apellidos    | genero   |
      | ANA MARIA | ZAPATA LOPEZ | FEMENINO |
    Y        selecciono el boton Linea Nueva Hogar
    Y        selecciono el boton Mostrar ofertas
    Entonces me muestra la pantalla para ingresar la direccion
    Y        completo los datos para consultar la cobertura
      | departamento | provincia | distrito   | direccion               | referencia |
      | LIMA         | LIMA      | SAN ISIDRO | AVENIDA CAMINO REAL 155 | parque     |
    Y        presiono el boton Consultar ubicacion
    Y        ingreso la informacion del lugar de instalacion
      | mz | tipoVivienda | nombreVivienda | piso | int | conjunto                 | conjHabit |
      |    |              |                | 1    | 3   | URBANIZACION RESIDENCIAL | RISSO     |
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "Mono"
    Y        selecciono el plan "INTERNET MOVISTAR RA"
    Cuando   doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso telefono de contacto
    Y        presiono el boton Confirmar agendamiento
    Y        ingreso correo electronico "automation@gmail.com"
    Y        ingreso nuevamente el correo electronico "automation@gmail.com"
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 12/02/1990 | Casado      | Aruba        |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato "hogar"
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton Continuar
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Información adicional"
    Dado     regreso a la pagina de inicio
    Entonces valido el login exitoso mediante el mensaje "Bienvenid@"
    Y        me dirijo a la bandeja de Back Office
    Y        busco por "1100002107"
    Y        selecciono la solicitud
    Y        cargo el audio en la web
    Y        apruebo la solicitud

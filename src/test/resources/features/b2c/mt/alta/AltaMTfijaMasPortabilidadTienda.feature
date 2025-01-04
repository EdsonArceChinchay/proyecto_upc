#language:es
##CREADOR:
##APP: DITO
##MODULO: MOVISTAR TOTAL
##FUNCIONALIDAD: Alta MT (fija + portabilidad)
##ESTADO:
##CODIGO: AT-DT080
##GDAP: GDAP-730
##SPRINT CREADO:
##FRECUENCIA:
##TAG : BERSERKERS
##DATA: REUSABLE
##ENCARGADO:
##FECMOD: 14/11/2024

@BERSERKERS @DoneDevOps @AltaMT
Característica: AT-DT080_Alta MT (Alta fija + portabilidad) a cliente CE por canal Tienda

  @AltaMTfijaMasPorta
  Esquema del escenario: Alta MT (Alta fija + portabilidad) a cliente CE por canal Tienda
    Dado     que abro la pagina de movistar
    Cuando   presiono el boton Iniciar Sesion
    Y        selecciono el tipo de usuario "<userType>"
    Y        ingreso el usuario "<userName>"
    Y        ingreso el password "<userPassword>"
    E        ingreso el captcha
    Y        presiono el boton Continuar hacia el home
    Entonces valido el login exitoso mediante el mensaje "<msgHome>"
    Y        valido que se presente el canal "Tienda"
    Y        valido que este activo el flag de Porta Directa
    Cuando   selecciono el tipo de documento "<documentType>"
    Y        ingreso el documento "<documentNumber>"
    Y        doy click en el boton Consultar
    Y        cierro popup de error
    Y        ingreso los datos del nuevo cliente
      | nombres | apellidos        | genero   |
      | MARIA   | MARTINEZ CABELLO | femenino |
    Y        selecciono el boton Linea Nueva Hogar
    Y        doy click en el boton portabilidad
    Y        cierro el popup de validación de estado de contraseña única
    Y        selecciono el boton Mostrar ofertas
    Y        ingreso numero de telefono para portar "<phoneNumber>"
    Y        escojo tipo de linea "Postpago"
    Y        escojo tipo de operador "OPERADOR DE PRUEBA"
    Y        doy click en el boton Consultar Portabilidad
    Y        valido que este en la seccion Postpago o Prepago
    Y        selecciono el plan "Postpago" que desea
    Y        doy click en el boton Siguiente
    Entonces me muestra la pantalla para ingresar la direccion
    Y        selecciono el departamento donde sera la instalacion "LIMA"
    Y        selecciono la provincia donde sera la instalacion "LIMA"
    Y        selecciono el distrito donde sera la instalacion "LINCE"
    Y        ingreso la direccion donde sera la instalacion "Julio Cesar Tello 469"
    Y        ingreso la referencia de la direccion "Casa"
    Y        presiono el boton Consultar ubicacion
    Y        presiono el boton Consultar cobertura
    Y        selecciono tipo de oferta
    Y        selecciono el tipo de plan "<planType>"
    Y        selecciono un plan Movistar Total "<planName>"
    Y        valido que este en el resumen de venta
    Y        doy click en el boton Iniciar registro
    Y        valido que me encuentre en la pantalla agendamiento
    Y        ingreso los datos de agendamiento
    Y        presiono el boton confirmar agendamiento
    Y        ingreso correo electronico "<correo>"
    Y        ingreso nuevamente el correo electronico "<correo>"
    Y        doy click en el boton Validar Codigo de Portabilidad
    Y        doy click en "Activa" y doy click en el boton Confirmar
    Y        obtengo el token
      | documentType   | documentNumber   | phoneNumber   |
      | <documentType> | <documentNumber> | <phoneNumber> |
    Cuando    ingreso el token y doy click en el boton Confirmar
    Entonces  valido el mensaje "Código valido" y doy click en el boton Continuar
    Y        doy click en datos del cliente
    Y        completo los datos del cliente
      | fechaNac   | estadoCivil | nacionalidad |
      | 10/11/1994 | Casado      | Alemania     |
    Y        doy click en el boton confirmar
    Y        doy click en Validar contrato ""
    Y        me muestra en pantalla el contrato solicitado
    Y        imprimo el texto del contrato solicitado
    Cuando   doy clic en si acepto
    Y        doy click en el boton de continuar
    Y        valido el servicio de status de portabilidad
      | phoneNumber   |
      | <phoneNumber> |
    Y        doy clic para descargar el contrato
    Y        doy click en el boton Registrar venta
    Entonces visualizo en pantalla el mensaje de exito de la venta generada
    Y        doy click en ver detalle del pedido
    Y        valido que se muestre el detalle del pedido de "Servicio Hogar"
    Y        valido que se muestre el detalle del pedido de "Dirección de instalación"
    Y        valido que se muestre el detalle del pedido de "Servicio Móvil"
    Y        valido que se muestre el detalle del pedido de "Información adicional"

    Ejemplos:
      | userType     | userName   | userPassword   | msgHome    | documentType | documentNumber | correo           | planType | planName | phoneNumber |
      | externalUser | userNameST | userPasswordST | Bienvenid@ | C            | 424647650      | correo@gmail.com | Trío MT  | TRIO     | 920956351   |

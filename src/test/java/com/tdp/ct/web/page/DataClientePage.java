package com.tdp.ct.web.page;

import com.tdp.ct.web.base.WebBase;
import com.tdp.ct.web.service.util.UtilWeb;
import com.tdp.ct.web.utils.ClienteData;
import com.tdp.ct.web.utils.Utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

import static com.tdp.ct.web.hooks.Hooks.getScenarioContext;
import static com.tdp.ct.web.utils.Utils.*;
import static com.tdp.ct.web.utils.Utils.getHostname;

public class DataClientePage extends WebBase {

    String TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE_CLIENTE, TIPO_PLAN_DEL_CLIENTE, NUM_LINEA, NOMBRE_PLAN, TIPO_PLAN, ESTADO_PLAN, DEUDA, CANTIDAD_DEUDA, PLAN_IPTV, ORDEN_EN_VUELO, CICLO_FACTURACION, ANTIGUEDAD_DATA;
    String ERROR_ZONA_PANGEA = "";

    @FindBy(xpath = "//*[contains(text(), 'Consultar') and @class='buttonConsultar']")
    private WebElement btnConsular;
    @FindBy(xpath = "//div[1]/form/div/div[3]/button")
    private WebElement scroll;
    @FindBy(xpath = "//*[@class='container']/*[@class='detailHogar'] | //*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'] | //*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero']")
    private WebElement contenidoHome;
    @FindBy(xpath = "//*[contains(text(), 'Cargar más')]")
    private WebElement btnCargarMas;
    @FindBy(xpath = "//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line']")
    private WebElement LineasHogarYMovil;
    @FindBy(xpath = "//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line']")
    private List<WebElement> listaLineasHogarYMovil;
    @FindBy(xpath = "//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')]")
    private List<WebElement> listaLineasMovil;
    @FindBy(xpath = "//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and not(starts-with(normalize-space(text()), '9'))] | //*[@class='number_line' and not(starts-with(normalize-space(text()), '9'))]")
    private List<WebElement> listaLineasHogar;
    @FindBy(xpath = "//*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero']")
    private List<WebElement> listaLineaMT;
    @FindBy(xpath = "//*[@class='div-product-name']")
    private WebElement titleMT;
    @FindBy(xpath = "//*[@class='text-info']")
    private WebElement nombreCliente;
    @FindBy(xpath = "//*[@class='div-datos']/*/*[@class='detail-datos3']/*[@class='div-item-info']/span")
    private WebElement nombrePlanHogar;
    @FindBy(xpath = "//*[@class='content']/*/*[@class='flex description']/*[@class='plan']")
    private List<WebElement> listaNombrePlanMovil;
    @FindBy(xpath = "//*[@class='div-datos']/*/*[@class='detail-datos3']/*[@class='div-item-info']/span")
    private WebElement nombrePlanMovil;
    @FindBy(xpath = "(//*[@class='close-modal']/*[@class='icon-close'])[1]")
    private WebElement cerrarVentanaDetalle;
    @FindBy(xpath = "(//*[@class='close-modal']/*[@class='icon-close'])[2]")
    private WebElement cerrarVentanaDetalleMovil;
    @FindBy(xpath = "//*[@name='btnpruebavalidate']")
    private WebElement btnContinuarProd;
    @FindBy(xpath = "//*[@class='button-light-green' and contains(text(), 'Reintentar')]")
    private WebElement btnReintearDeuda;
    @FindBy(xpath = "//*[contains(@class, modal_header)]/*[contains(text(), 'dirección actual')]")
    private WebElement titleCambioDeDireccion;
    @FindBy(xpath = "//*[contains(@class, modal_header)]/*[contains(text(), 'Actualizar dirección')]")
    private WebElement btnActualizarDireccion;
    @FindBy(xpath = "//*[contains(@class, 'info-user')]/*[contains(text(), 'dirección')]")
    private WebElement titleInsertarNuevaDireccion;
    @FindBy(xpath = "//*[@class = 'flex_100 hydrated ng-dirty ng-touched ng-valid' and @formcontrolname = 'reference'] | //*[contains(@class, 'ng-valid') and @formcontrolname = 'reference'] | //*[contains(@class, 'ng-touched') and @formcontrolname = 'reference'] | //*[contains(@class, 'hydrated') and @formcontrolname = 'reference'] | //*[contains(@class, 'ng-dirty') and @formcontrolname = 'reference']")
    private WebElement insertarReferencia;
    @FindBy(xpath = "//*[@class = 'flex_100 hydrated ng-dirty ng-touched ng-valid' and @formcontrolname = 'reference' and string-length(@value) > 0] | //*[contains(@class, 'ng-valid') and @formcontrolname = 'reference' and string-length(@value) > 0] | //*[contains(@class, 'ng-touched') and @formcontrolname = 'reference' and string-length(@value) > 0] | //*[contains(@class, 'hydrated') and @formcontrolname = 'reference' and string-length(@value) > 0] | //*[contains(@class, 'ng-dirty') and @formcontrolname = 'reference' and string-length(@value) > 0]")
    private WebElement verSiTieneReferencia;
    @FindBy(xpath = "//*[@class = 'button_step' and contains(text(), 'Consultar ubicación')] | //*[@class = 'button_step' and contains(text(), 'Consultar ubicacion')] | //*[contains(@class, 'utton') and contains(text(), 'Consultar ubicaci')] | //*[contains(@class, 'utton') and contains(text(), 'Consultar Ubicaci')]")
    private WebElement btnConsultarUbicacion;
    @FindBy(xpath = "//*[contains(@class, 'text-adress') and contains(text(), 'Dirección')]")
    private WebElement titleDireccionInsertada;
    @FindBy(xpath = "//*[@class = 'button_step' and contains(text(), 'Consultar cobertura')] | //*[@class = 'button_step' and contains(text(), 'cobertura')] | //*[contains(@class, 'utton') and contains(text(), 'obertura')]")
    private WebElement btnConsultarCobertura;
    @FindBy(xpath = "//*[contains(@class, 'title') and contains(text(), 'Ofertas sugeridas')]")
    private WebElement titleOfertasSugeridas;
    @FindBy(xpath = "//*[contains(@class, 'coverage') and contains(text(), 'FTTH')]")
    private WebElement titleCoberturaFTTH;
    @FindBy(xpath = "//*[contains(@class, 'return') and contains(text(), 'Regresar')]")
    private WebElement btnRegresar;
    @FindBy(xpath = "//*[contains(@class, 'success') and contains(text(), 'INGRESA NUEVA')]")
    private WebElement btnIngresaNuevaDireccion;
    @FindBy(xpath = "//*[contains(@class, 'ng-touched') and contains(@formcontrolname, 'direction') and string-length(@value) > 0] | //*[contains(@class, 'ng-dirty') and contains(@formcontrolname, 'direction') and string-length(@value) > 0] | //*[contains(@class, 'ng-valid') and contains(@formcontrolname, 'direction') and string-length(@value) > 0] | //*[contains(@class, 'flex_100') and contains(@formcontrolname, 'direction') and string-length(@value) > 0] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'direction') and string-length(@value) > 0]")
    private WebElement modificarDireccion;
    @FindBy(xpath = "//*[contains(@class, 'ng-touched') and contains(@formcontrolname, 'direction') and string-length(@value) = 0] | //*[contains(@class, 'ng-dirty') and contains(@formcontrolname, 'direction') and string-length(@value) = 0] | //*[contains(@class, 'ng-valid') and contains(@formcontrolname, 'direction') and string-length(@value) = 0] | //*[contains(@class, 'flex_100') and contains(@formcontrolname, 'direction') and string-length(@value) = 0] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'direction') and string-length(@value) = 0]")
    private WebElement insertarDireccion;
    @FindBy(xpath = "//*[contains(@class, modal_header)]/*[contains(text(), 'dirección actual')] | //*[contains(@class, 'title') and contains(text(), 'Ofertas sugeridas')]")
    private WebElement titleSiPuedeCambiarDireccion;
    @FindBy(xpath = "//*[contains(@class, 'ng-untouched') and contains(@formcontrolname, 'roadName') and string-length(@value) > 0] | //*[contains(@class, 'ng-pristine') and contains(@formcontrolname, 'roadName') and string-length(@value) > 0] | //*[contains(@class, 'flex_100') and contains(@formcontrolname, 'roadName') and string-length(@value) > 0] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'roadName') and string-length(@value) > 0]")
    private WebElement verInsersionNumeroPuerta;
    @FindBy(xpath = "//*[contains(@class, 'info')]/*[contains(text(), 'Ciclo')]")
    private WebElement cicloFacturacionFija;
    @FindBy(xpath = "//*[contains(@class, 'col')]/*[string-length(normalize-space()) > 5 and contains(text(), 'Ciclo')] | //*[contains(@class, 'padding')]/*[string-length(normalize-space()) > 5 and contains(text(), 'Ciclo')]")
    private WebElement cicloFacturacionMovil;
    @FindBy(xpath = "//*[contains(@class, 'button') and contains(text(), 'Continuar')]")
    private WebElement btnContinuarVerDetalle;
    @FindBy(xpath = "//*[contains(@class, 'success') and contains(text(), 'MODIFICAR DIRECCIÓN')]")
    private WebElement titleDireccionErronea;
    @FindBy(xpath = "//*[contains(text(), 'Encontramos más de una dirección con los datos ingresados')]")
    private WebElement titleMasDeUnaDireccion;
    @FindBy(xpath = "(//*[contains(@id, 'address')])[1]")
    private WebElement radioDireccion;
    @FindBy(xpath = "//*[contains(text(), 'Entendido')]")
    private WebElement btnEntendidoMasDeUnaDireccion;
    @FindBy(xpath = "//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='btn-try-again' and contains(text(), 'Reintentar')]")
    private List<WebElement> cantReintentarDeudas;
    @FindBy(xpath = "(//*[@class='div-product-container g-c--default'] | //*[contains(@class, 'g-c--default')])/*[2]/*[@class='div-chips']/*[@class='chip-fija']/*[@class='icon-drop']/img")
    private WebElement tapCerrarLineaSeleccionada;
    @FindBy(xpath = "//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='button-light-green' and contains(text(), 'Entendido')] | //*[contains(@class, 'button') and contains(text(), 'Entendido')] | //*[contains(text(), 'Tenemos un problema')]/following-sibling::*[contains(text(), 'el servicio Pangea no responde')] | //*[contains(text(), 'Puertos no disponibles')]")
    private WebElement titleEntendidoOReintentar;
    @FindBy(xpath = "//*[contains(text(), 'Encontramos más de una dirección con los datos ingresados')] | //*[contains(@class, 'text-adress') and contains(text(), 'Dirección')] | //*[contains(@class, 'success') and contains(text(), 'MODIFICAR DIRECCIÓN')]")
    private WebElement titleMasDeUnaDireccionODireccion;
    @FindBy(xpath = "//*[contains(@class, modal_header)]/*[contains(text(), 'dirección actual')] | //*[contains(@class, 'title') and contains(text(), 'Ofertas sugeridas')] | //*[contains(@class, 'title') and contains(text(), 'Ofertas sugeridas')] | //*[contains(text(), 'Actualizar dirección') and contains(@class, 'utton')] | //*[contains(@src, 'Cellphone') and contains(@alt, 'celphone')]")
    private WebElement titlesDeInsertarDireccion;
    @FindBy(xpath = "//*[contains(@class, 'div-antiguedad')]/p/strong")
    private WebElement antiguedadLineaMovil;
    @FindBy(xpath = "//*[contains(text(), 'Error en Zona Pangea')]")
    private WebElement titleErrorZonaPangea;
    @FindBy(xpath = "//*[contains(text(), 'Tenemos un problema')]/following-sibling::*[contains(text(), 'el servicio Pangea no responde')] | //*[contains(text(), 'Puertos no disponibles')]")
    private WebElement titleServicioPangeError;
    @FindBy(xpath = "//*[contains(text(), 'CONTINUAR EN HFC')]")
    private WebElement btnContinuarHFC;
    @FindBy(xpath = "//*[contains(text(), 'PLAN NUEVO')]/following-sibling::*/*/*/*[3]/*/*/*/*[2]/*/*[contains(@class, 'smallTitle')] | ((//*[contains(@class, 'title') and string-length(text())>30])[3]/parent::*/parent::*/parent::*/following-sibling::*/*/*/*[2]/*/*[contains(@class,'smallTitle')])[1]")
    private WebElement tecnologiaAMigrarNuevoPlan;
    @FindBy(xpath = "//*[contains(text(), 'PLAN NUEVO')]/following-sibling::*/*/*/*/*[2]/*/*[contains(@class, 'banner-upgrade')]")
    private WebElement etiquetaSaltoCeroNuevoPlan;
    @FindBy(xpath = "//*[@class='detail-MT']/*")
    private WebElement btnVerDetalleMT;
    @FindBy(xpath = "//*[contains(@class, 'icon-phone') and contains(@class, 'iconos')]")
    private WebElement btnDetalleFijaMT;
    @FindBy(xpath = "//*[contains(@class, 'icon-phone-')]/parent::*/parent::*/parent::*/parent::*/parent::*/following-sibling::*/*/*[2]/*[3]/*[1]")
    private WebElement textCicloMTFija;
    @FindBy(xpath = "//*[contains(@class, 'icon-phone-')]/parent::*/parent::*/parent::*/parent::*/following-sibling::*/*/*[2]/*[3]/*[1]")
    private WebElement textCicloMTFija2;
    @FindBy(xpath = "//*[contains(@class, 'icon-celular') and contains(@class, 'iconos')]")
    private WebElement btnDetalleMovilMT;
    @FindBy(xpath = "(//*[contains(@class, 'icon-celular-')]/parent::*/parent::*/parent::*/parent::*/parent::*/following-sibling::*/*/*[2]/*[3]/*[1])[1]")
    private WebElement textCicloMTMovil;
    @FindBy(xpath = "(//*[contains(@class, 'icon-celular-')]/parent::*/parent::*/parent::*/parent::*/following-sibling::*/*/*[2]/*[3]/*[1])[1]")
    private WebElement textCicloMTMovil2;
    @FindBy(xpath = "//*[contains(@class, 'icon-celular') and contains(@class, 'iconos')]/parent::*/parent::*/parent::*/parent::*/following-sibling::*/*/strong")
    private WebElement antiguedadLineaMovilMT;
    @FindBy(xpath = "//*[contains(@class, 'icon-celular') and contains(@class, 'iconos')]/parent::*/parent::*/parent::*/following-sibling::*/*/strong")
    private WebElement antiguedadLineaMovilMT2;
    @FindBy(xpath = "//*[contains(@class, 'icon-celular') and contains(@class, 'iconos')]/parent::*/parent::*/parent::*/parent::*/parent::*/*[@class='close-modal']/*[@class='icon-close']")
    private WebElement cerrarVentanaDetalleMT;
    @FindBy(xpath = "//*[contains(@class, 'icon-celular') and contains(@class, 'iconos')]/parent::*/parent::*/parent::*/parent::*/*[@class='close-modal']/*[@class='icon-close']")
    private WebElement cerrarVentanaDetalleMT2;

    // INSERCIONES DIRECCION
    @FindBy(xpath = "//*[contains(@class, 'flex_100') and contains(@formcontrolname, 'doorNumber')] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'doorNumber')] | //*[contains(@class, 'ng-touched') and contains(@formcontrolname, 'doorNumber')] | //*[contains(@class, 'ng-dirty') and contains(@formcontrolname, 'doorNumber')]")
    private WebElement insertarNumPuerta;
    @FindBy(xpath = "//*[contains(@class, 'flex_100') and contains(@name, 'block')] | //*[contains(@class, 'hydrated') and contains(@name, 'block')] | //*[contains(@class, 'ng-touched') and contains(@name, 'block')] | //*[contains(@class, 'ng-dirty') and contains(@name, 'block')]")
    private WebElement insertarBloque;
    @FindBy(xpath = "//*[contains(@class, 'ng-pristine') and contains(@formcontrolname, 'floor')] | //*[contains(@class, 'ng-valid') and contains(@formcontrolname, 'floor')] | //*[contains(@class, 'flex_100') and contains(@formcontrolname, 'floor')] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'floor')]")
    private WebElement insertarPiso;
    @FindBy(xpath = "//*[contains(@class, 'ng-untouched') and contains(@formcontrolname, 'inside')] | //*[contains(@class, 'ng-pristine') and contains(@formcontrolname, 'inside')] | //*[contains(@class, 'ng-valid') and contains(@formcontrolname, 'inside')] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'inside')]")
    private WebElement insertarInterior;

    // DIRECCION INSERTADA
    @FindBy(xpath = "//*[contains(@class, 'flex_100') and contains(@name, 'block') and string-length(@value) > 0] | //*[contains(@class, 'hydrated') and contains(@name, 'block') and string-length(@value) > 0] | //*[contains(@class, 'ng-touched') and contains(@name, 'block') and string-length(@value) > 0] | //*[contains(@class, 'ng-dirty') and contains(@name, 'block') and string-length(@value) > 0]")
    private WebElement insertarBloqueInsertado;
    @FindBy(xpath = "//*[contains(@class, 'ng-pristine') and contains(@formcontrolname, 'floor') and string-length(@value) > 0] | //*[contains(@class, 'ng-valid') and contains(@formcontrolname, 'floor') and string-length(@value) > 0] | //*[contains(@class, 'flex_100') and contains(@formcontrolname, 'floor') and string-length(@value) > 0] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'floor') and string-length(@value) > 0]")
    private WebElement insertarPisoInsertado;

    // DIRECCION NO INSERTADA
    @FindBy(xpath = "//*[contains(@class, 'flex_100') and contains(@name, 'block') and string-length(@value) = 0] | //*[contains(@class, 'hydrated') and contains(@name, 'block') and string-length(@value) = 0] | //*[contains(@class, 'ng-touched') and contains(@name, 'block') and string-length(@value) = 0] | //*[contains(@class, 'ng-dirty') and contains(@name, 'block') and string-length(@value) = 0]")
    private WebElement insertarBloqueNoInsertado;
    @FindBy(xpath = "//*[contains(@class, 'ng-pristine') and contains(@formcontrolname, 'floor') and string-length(@value) = 0] | //*[contains(@class, 'ng-valid') and contains(@formcontrolname, 'floor') and string-length(@value) = 0] | //*[contains(@class, 'flex_100') and contains(@formcontrolname, 'floor') and string-length(@value) = 0] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'floor') and string-length(@value) = 0]")
    private WebElement insertarPisoNoInsertado;
    @FindBy(xpath = "//*[contains(@class, 'ng-untouched') and contains(@formcontrolname, 'inside') and string-length(@value) = 0] | //*[contains(@class, 'ng-pristine') and contains(@formcontrolname, 'inside') and string-length(@value) = 0] | //*[contains(@class, 'ng-valid') and contains(@formcontrolname, 'inside') and string-length(@value) = 0] | //*[contains(@class, 'hydrated') and contains(@formcontrolname, 'inside') and string-length(@value) = 0]")
    private WebElement insertarInteriorNoInsertado;

    // ERROR EN INSERTAR NUMERO DE PUERTA
    @FindBy(xpath = "//*[contains(@class, 'tdp-light') and contains(text(), 'Se encontraron inconsistencias en la dirección de instalación, la dirección puede contener:')]")
    private WebElement titleErrorNumeroPuerta;
    @FindBy(xpath = "//*[contains(@class, 'button') and contains(text(), 'Aceptar')]")
    private WebElement btnAceptarErrorNumeroPuerta;

    // TIPO VIVIENDA
    @FindBy(xpath = "//*[contains(@name, 'houseType') and contains(@class, 'ng-touched')] | //*[contains(@name, 'houseType') and contains(@class, 'ng-untouched')] | //*[contains(@name, 'houseType') and contains(@class, 'flex_100')]")
    private WebElement tipoVivienda;
    @FindBy(xpath = "//*[contains(@formcontrolname, 'houseName') and contains(@class, 'ng-untouched')] | //*[contains(@formcontrolname, 'houseName') and contains(@class, 'ng-pristine')] | //*[contains(@formcontrolname, 'houseName') and contains(@class, 'ng-untouched')] | //*[contains(@formcontrolname, 'houseName') and contains(@value, '')]")
    private WebElement insetarNombreVivienda;

    // MOSTAR OFERTAS MT
    @FindBy(xpath = "//*[contains(text(), 'Selecciona un servicio')]")
    private WebElement titleSeleccioneServicioMT;
    @FindBy(xpath = "//*[contains(@src, 'Cellphone') and contains(@alt, 'celphone')]")
    private WebElement iconoPhoneMT;
    @FindBy(xpath = "//*[contains(text(), 'Mostrar ofertas')]")
    private WebElement btnMostarOfertas;

    // BARRA CARGANDO
    @FindBy(xpath = "//*[@class='splash']/*[@class='splash-title']/*[@class='image-wrapper'] | //*[contains(text(), 'Telefónica ...')] | //*[contains(@class, 'mdc-card')]/*[contains(@class, 'loadingCard')]")
    private WebElement titleCargando;
    @FindBy(xpath = "//*[contains(@class, 'button') and contains(text(), 'Entendido')] | //*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='button-light-green' and contains(text(), 'Entendido')] | //*[contains(text(), 'REINTENTAR')]")
    private WebElement titlesBtnsCargando;

    // MOSTRAR OFERTAS
    @FindBy(xpath = "(//*[@class='div-product-container g-c--default'] | //*[contains(@class, 'g-c--default')])/*[@class = 'div-product']/*[@class = 'show-offerts']/*[contains(text(), 'Mostrar Ofertas')]")
    private WebElement btnMostrarOfertas;

    // REINTENTAR
    @FindBy(xpath = "//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='button-light-green' and contains(text(), 'Entendido')] | //*[contains(text(), 'REINTENTAR')]")
    private WebElement btnReintentar;

    // ENTENDIDO
    @FindBy(xpath = "//*[contains(@class, 'utton') and contains(text(), 'Entendido')]")
    private WebElement btnEntendido;

    // BOTON ELIMINAR NUMERO SELECCIONADO
    @FindBy(xpath = "//*[contains(@src, 'service') and contains(@alt, 'delete')]")
    private WebElement btnEliminarSeleccion;

    //BOTON INICIO
    @FindBy(xpath = "//*[contains(normalize-space(text()), 'Inicio')]")
    private WebElement btnInicio;

    private final String folderPath = "CapturaData";
    private final String excelName = "capturaData" + getToday().replace("/", "");
    private final String sheetName = "Datos Clientes";

    private final String sheetNameError = "Datos Clientes Error";

    private final String folderPathBitacora = "Bitacoras";
    private final String excelNameBitacora = "bitacora" + getToday().replace("/", "") + "_Masiva";
    private final String sheetNameBitacora = "Datos Bitacora";

    private static final String folderPathWhiteList = "Clientes";
    private static final String excelNameWhiteList = "WhiteList";

    static String pathWhiteList = Paths.get(folderPathWhiteList, excelNameWhiteList).toString() + ".xlsx";

    Utils utils = new Utils();
    Actions action = new Actions(driver());

    List<Integer> totalElementosPlanCliente = new ArrayList<>();
    List<String> tipoPlanCliente = new ArrayList<>();
    List<String> numeroDelPlan = new ArrayList<>();
    List<String> nombreDelPlan = new ArrayList<>();
    List<String> tipoPlanContratado = new ArrayList<>();
    List<String> componentesPlanContratado = new ArrayList<>();
    List<String> estadoDelPlan = new ArrayList<>();
    List<String> deudaDelPlan = new ArrayList<>();
    List<String> cantidadDeudaDelPlan = new ArrayList<>();
    List<String> iptvPlan = new ArrayList<>();
    List<String> ordenVueloPlan = new ArrayList<>();
    List<String> nombreClientes = new ArrayList<>();
    List<String> tecnologiaPlan = new ArrayList<>();
    List<String> velocidadPlan = new ArrayList<>();
    List<String> cuentaConSVAPlan = new ArrayList<>();
    List<String> direccionMigrarFTTH = new ArrayList<>();
    List<String> etiquetaFibra = new ArrayList<>();
    List<String> cicloFacturacion = new ArrayList<>();
    List<String> tiempoCreacionLinea = new ArrayList<>();
    List<String> direccionCliente = new ArrayList<>();
    List<String> estadoDireccion = new ArrayList<>();
    List<String> tecnologiaAMigrar = new ArrayList<>();
    List<String> etiquetaSaltoCero = new ArrayList<>();

    List<String> tipoDocuemtoList = new ArrayList<>();
    List<String> numeroDocumentoList = new ArrayList<>();
    List<String> nombreClienteList = new ArrayList<>();
    List<String> tipoPlanClienteList = new ArrayList<>();
    List<String> numeroLineaList = new ArrayList<>();
    List<String> nombrePlanList = new ArrayList<>();
    List<String> tipoPlanContratadoList = new ArrayList<>();
    List<String> componentesPlanContratadoList = new ArrayList<>();
    List<String> estadoPlanList = new ArrayList<>();
    List<String> deudaClienteList = new ArrayList<>();
    List<String> cantidadDeudaList = new ArrayList<>();
    List<String> planIPTVList = new ArrayList<>();
    List<String> ordenEnVueloList = new ArrayList<>();
    List<String> tecnologiaPlanList = new ArrayList<>();
    List<String> velocidadPlanList = new ArrayList<>();
    List<String> cuentaConSVAPlanList = new ArrayList<>();
    List<String> direccionMigrarFTTHList = new ArrayList<>();
    List<String> etiquetaFibraList = new ArrayList<>();
    List<String> cicloFacturacionList = new ArrayList<>();
    List<String> tiempoCreacionLineaList = new ArrayList<>();
    List<String> direccionClienteList = new ArrayList<>();
    List<String> estadoDireccionList = new ArrayList<>();
    List<String> tecnologiaAMigrarList = new ArrayList<>();
    List<String> etiquetaSaltoCeroList = new ArrayList<>();

    private List<ClienteData> clienteDataList = new ArrayList<>();

    List<Integer> totalElementosPorArray = new ArrayList<>();
    List<String> resultadoList = new ArrayList<>();

    public void clickBtnContinuar() {
        cargarMsgLog(Level.INFO,"Ingreso a dar click al boton Continuar");
        click(btnContinuarProd,5);
        cargarMsgLog(Level.INFO,"Dio click al boton Continuar");
        UtilWeb.waitForSeconds(2);
        barraCargando();
    }

    public void seleccionoTipoDocumento(String tipoDocumento) {
        cargarMsgLog(Level.INFO,"Ingreso a seleccionar el tipo de documento a buscar");
        UtilWeb.waitForSeconds(2);
        WebElement documentoList;
        int cont = 0;
        boolean paso = false;
        while (cont < 3 && !paso) {
            try {
                try {
                    cargarMsgLog(Level.INFO,"Ingreso a seleccionar Tipo Documento");
                    documentoList = find().getElementByCss("div.searchClient div:nth-child(1) > tdp-st-select");
                    cargarMsgLog(Level.INFO, "INGRESO A VISUALIZAR LISTA DOCUMENTOS");
                    js().scrollElementTop(scroll);
                    cargarMsgLog(Level.INFO, "PASO A REALIZAR SCROLL EN TIPO DOCUMENTO");
                    UtilWeb.waitForSeconds(1);
                    click(documentoList,5);
                    cargarMsgLog(Level.INFO, "CLICK LISTA DE DOCUMENTOS");
                    String valueTipoDocumento = "";
                    SearchContext context = sh().getContext(documentoList);
                    switch (tipoDocumento) {
                        case "CE":
                        case "C":
                            valueTipoDocumento = "C";
                            break;
                        case "DNI":
                            valueTipoDocumento = "DNI";
                            break;
                        case "Pasaporte":
                        case "P":
                            valueTipoDocumento = "P";
                            break;
                        case "RUC":
                            valueTipoDocumento = "RUC";
                            break;
                        default:
                            throw new IllegalArgumentException("Tipo de documento no existe " + tipoDocumento);
                    }
                    cargarMsgLog(Level.INFO, "CLICK DOCUMENTO SELECCIONADO");
                    context.findElement(By.cssSelector("[data-value='" + valueTipoDocumento + "']")).click();
                    cargarMsgLog(Level.INFO,"Selecciono el tipo de documento: " + valueTipoDocumento);
                    paso = true;
                } catch (Exception e) {
                    cargarMsgLog(Level.INFO,"Ingreso a seleccionar Tipo Documento - Contingencia");
                    documentoList = find().getElementByXPath("//*[@class='ng-untouched ng-pristine flex_100 hydrated ng-valid'] | //*[contains(@class, 'ng-valid') and @formcontrolname='tipoDoc'] | (//*[contains(@class, 'ng-pristine') and @formcontrolname='tipoDoc'])[1]");
                    cargarMsgLog(Level.INFO, "INGRESO A VISUALIZAR LISTA DOCUMENTOS - CONTINGENCIA");
                    js().scrollElementTop(scroll);
                    cargarMsgLog(Level.INFO, "PASO A REALIZAR SCROLL EN TIPO DOCUMENTO - CONTINGENCIA");
                    UtilWeb.waitForSeconds(1);
                    click(documentoList,5);
                    cargarMsgLog(Level.INFO, "CLICK LISTA DE DOCUMENTOS - CONTINGENCIA");
                    String valueTipoDocumento = "";
                    SearchContext context = sh().getContext(documentoList);
                    switch (tipoDocumento) {
                        case "CE":
                        case "C":
                            valueTipoDocumento = "C";
                            break;
                        case "DNI":
                            valueTipoDocumento = "DNI";
                            break;
                        case "Pasaporte":
                        case "P":
                            valueTipoDocumento = "P";
                            break;
                        case "RUC":
                            valueTipoDocumento = "RUC";
                            break;
                        default:
                            throw new IllegalArgumentException("Tipo de documento no existe " + tipoDocumento);
                    }
                    cargarMsgLog(Level.INFO, "CLICK DOCUMENTO SELECCIONADO - CONTINGENCIA");
                    context.findElement(By.cssSelector("[data-value='" + valueTipoDocumento + "']")).click();
                    cargarMsgLog(Level.INFO,"Selecciono el tipo de documento: " + valueTipoDocumento);
                    paso = true;
                }
            } catch (Exception er) {
                cont++;
                cargarMsgLog(Level.INFO, "NO CARGO SELECCIONAR TIPO DOCUMENTO - REINTENTO - N°" + cont);
                if (cont < 3) {
                    System.out.println("SE PROCEDE A REGRESAR AL INICIO");
                    action.sendKeys(Keys.ESCAPE).build().perform();
                    driver().navigate().refresh();
                    System.out.println("SE PROCEDE A REFRESCAR LA PAGINA");
                    barraCargando();
                    System.out.println("SE PASO LA VALIDACION DE BARRA CARGANDO N°1");
                    action.sendKeys(Keys.ESCAPE).build().perform();
                    barraCargando();
                    System.out.println("SE PASO LA VALIDACION DE BARRA CARGANDO N°2");
                    click(btnInicio,15);
                    clickBtnReintentar();
                    UtilWeb.waitForSeconds(1);
                    Zoom(65);
                } else {
                    driver().quit();
                }
            }
        }
    }

    public void ingresoNumDocumento(String documento) {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a insertar numero de documento");
            WebElement document = find().getElementByXPath("//*[@class='flex_100 hydrated ng-touched ng-dirty ng-invalid' and @id='doc' and @value=''] | //*[@class='ng-untouched ng-pristine ng-invalid flex_100 hydrated' and @id='doc' and @value=''] | //*[contains(@class, 'ng-untouched') and @id='doc' and @value='']");
            click(document,5);
            type(document, documento,5);
            cargarMsgLog(Level.INFO,"Inserto numero de documento");
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"Ingreso a insertar numero de documento - Contingencia");
            WebElement document;
            try {
                document = find().getElementByXPath("(//*[@class='flex_100 hydrated ng-touched ng-dirty ng-invalid' and @id='doc' and string-length(@value) > 0])[1] | (//*[@class='ng-untouched ng-pristine ng-invalid flex_100 hydrated' and @id='doc' and string-length(@value) > 0])[1] | (//*[contains(@class, 'ng-untouched') and @id='doc' and string-length(@value) > 0])[1] | //*[contains(@class, 'ng-valid') and @id='doc' and string-length(@value) > 0] | //*[contains(@class, 'ng-dirty') and @id='doc' and string-length(@value) > 0] | //*[contains(@class, 'ng-touched') and @id='doc' and string-length(@value) > 0]");
                System.out.println("********************");
                System.out.println("Ingreso a dar click");
                System.out.println("********************");
                click(document,5);
                System.out.println("********************");
                System.out.println("Dio clicl doc");
                System.out.println("********************");
                for (int i = 0; i < document.getText().length(); i++) {
                    document.sendKeys(Keys.BACK_SPACE);
                }
                System.out.println("********************");
                System.out.println("limpio doc");
                System.out.println("********************");
            } catch (Exception e2) {
                cargarMsgLog(Level.INFO, "XPATH Erroneo");
            }
            WebElement setDocument = find().getElementByXPath("//*[@class='flex_100 hydrated ng-dirty ng-invalid ng-touched' and @id='doc' and @value=''] | //*[@class='ng-untouched ng-pristine ng-invalid flex_100 hydrated' and @id='doc' and @value=''] | //*[contains(@class, 'ng-touched') and @id='doc' and @value=''] | //*[contains(@class, 'ng-invalid') and @id='doc' and @value='']");
            click(setDocument,5);
            type(setDocument, documento,5);
            cargarMsgLog(Level.INFO,"Inserto numero de documento - Contingencia");
        }
    }

    public void clickBotonConsultar() {
        cargarMsgLog(Level.INFO,"Ingreso a dar click al boton consultar");
        click(btnConsular,5);
        cargarMsgLog(Level.INFO,"Dio click al boton consultar");
        clickBtnReintentar();
        try {
            if (titleCargando.isDisplayed()) {
                cargarMsgLog(Level.INFO,"Se sigue visualizo la barra cargando");
                driver().navigate().refresh();
                UtilWeb.waitForSeconds(4);
                action.sendKeys(Keys.ESCAPE).build().perform();
                barraCargando();
                cargarMsgLog(Level.INFO,"SE APLICA ZOOM - 1");
                Zoom(65);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"No se visualiza la barra cargando");
        }
    }

    public void clickBtnReintentar() {
        barraCargando();
        boolean existe = false;
        int cont = 0;
        while (!existe && cont < 3) {
            try {
                UtilWeb.waitForSeconds(2);
                if (btnReintentar.isDisplayed()) {
                    cont++;
                    cargarMsgLog(Level.INFO,"Se detecto boton Reintentar - Intento N°" + cont);
                    click(btnReintentar,5);
                    barraCargando();
                }
            } catch (Exception e) {
                cargarMsgLog(Level.INFO,"Se cargaron los datos del cliente correctamente");
                existe = true;
            }
        }
    }

    public void visualizaContenidoHome() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar contenido Home");
            UtilWeb.waitForSeconds(3);
            waitUntilElementIsVisible(contenidoHome,6);
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"No visualizo contenido Home");
        }
    }

    public void clickBtnCargarMas() {
        cargarMsgLog(Level.INFO,"Ingreso a dar click al boton Cargar Mas");
        click(btnCargarMas, 5);
        barraCargando();
        cargarMsgLog(Level.INFO,"Dio Click al boton Cargar Mas");
    }

    public void visualizarBtnCargarMas() {
        visualizaContenidoHome();
        cargarMsgLog(Level.INFO,"Ingreso a visualizar boton Cargar Mas");
        boolean noExiste = false;
        int cont = 0;
        while (!noExiste && cont < 5) {
            int cont1 = 1;
            while (cont1 <= 5) {
                utils.hacerScroll("DOWN");
                cargarMsgLog(Level.INFO,"Realizo scroll N°" + cont1);
                cont1++;
            }
            try {
                if (cont > 0) {
                    UtilWeb.waitForSeconds(2);
                }
                if (btnCargarMas.isDisplayed()) {
                    clickBtnCargarMas();
                    visualizaContenidoHome();
                }
            } catch (Exception e) {
                cargarMsgLog(Level.INFO,"Elemento no existe");
                noExiste = true;
                scroolUP();
            }
            cont++;
        }
        contarElementosExistentes();
    }

    public void scroolUP() {
        int cont2 = 1;
        while (cont2 <= 5) {
            utils.hacerScroll("UP");
            cargarMsgLog(Level.INFO,"Realizo scroll N°" + cont2);
            cont2++;
        }
    }

    public void barraCargando() {
        UtilWeb.waitForSeconds(4);
        boolean noExiste = false;
        int cont = 1;
        while (!noExiste && cont <= 15) {
            try {
                if (titleCargando.isDisplayed()) {
                    cargarMsgLog(Level.INFO,"Se visualizo la barra cargando N° " + cont);
                    UtilWeb.waitForSeconds(2);
                    try {
                        if (titlesBtnsCargando.isDisplayed()) {
                            cargarMsgLog(Level.INFO,"CARGANDO ... FIN ...");
                            noExiste = true;
                        }
                    } catch (Exception e) {
                        cargarMsgLog(Level.INFO,"CARGANDO ...");
                    }
                }
                cont++;
            } catch (Exception e) {
                cargarMsgLog(Level.INFO,"No se visualiza la barra cargando");
                noExiste = true;
            }
        }
    }

    public int contarElementosExistentes() {
        int cantidadHogar = 0;
        int cantidadMT = 0;
        int total;
        try {
            cargarMsgLog(Level.INFO, "Ingreso a visualizar la cantidad de lineas hogar y movil");
            if (!listaLineasHogarYMovil.isEmpty()) {
                cantidadHogar = listaLineasHogarYMovil.size();
                cargarMsgLog(Level.INFO, "Cantidad de lineas Hogar y Movil: " + cantidadHogar);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "El cliente no tiene lineas Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO, "Ingreso a visualizar la cantidad de elementos MTs");
            if (!listaLineaMT.isEmpty()) {
                cantidadMT = listaLineaMT.size();
                cargarMsgLog(Level.INFO, "Cantidad de lineas MT: " + cantidadMT);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "El cliente no tiene lineas MTs");
        }
        total = cantidadHogar + cantidadMT;
        cargarMsgLog(Level.INFO, "La cantidad de elementos en el Home es: " + total);
        return total;
    }

    public void almacenarElementosExistentes() {
        int cantidadHogarParaAlmacenar = 0;
        int cantidadMTParaAlmacenar = 0;
        int totalAlmacenado;
        try {
            cargarMsgLog(Level.INFO, "Ingreso a visualizar la cantidad de lineas hogar y movil");
            if (!listaLineasHogarYMovil.isEmpty()) {
                cantidadHogarParaAlmacenar = listaLineasHogarYMovil.size();
                cargarMsgLog(Level.INFO, "Cantidad de lineas Hogar y Movil: " + cantidadHogarParaAlmacenar);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "El cliente no tiene lineas Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO, "Ingreso a visualizar la cantidad de elementos MTs");
            if (!listaLineaMT.isEmpty()) {
                cantidadMTParaAlmacenar = listaLineaMT.size();
                cargarMsgLog(Level.INFO, "Cantidad de lineas MT: " + cantidadMTParaAlmacenar);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "El cliente no tiene lineas MTs");
        }
        totalAlmacenado = cantidadHogarParaAlmacenar + cantidadMTParaAlmacenar;
        cargarMsgLog(Level.INFO, "La cantidad de elementos en el Home es: " + totalAlmacenado);
        System.out.println("**********************************");
        System.out.println("La cantidad almacenda es: " + totalAlmacenado);
        System.out.println("**********************************");
        totalElementosPlanCliente.add(totalAlmacenado);
    }

    public void visualizoPlanesCliente(String tipoDocumentoCliente, String numeroDocumentoCliente) {
        int elementos = contarElementosExistentes();
        TIPO_DOCUMENTO = tipoDocumentoCliente;
        NUMERO_DOCUMENTO = numeroDocumentoCliente;
        try {
            if (nombreCliente.isDisplayed()) {
                NOMBRE_CLIENTE = nombreCliente.getText().substring(8);
                cargarMsgLog(Level.INFO, "Nombre Cliente: " + NOMBRE_CLIENTE);
                nombreClientes.add(NOMBRE_CLIENTE);
                almacenarElementosExistentes();
                sacarNumeroPlan();
                sacarNombrePlanCliente();
                tipoPlan();
                estadoPlan();
                verSiTieneDeuda();
                cantidadDeuda();
                tipoPlanDelCliente(elementos);
                verSiEsPlanIPTV();
                verSiTieneOrdenEnVuelo();
                verSiMigraAFibra();
                clickParaSeleccionarPlanActivo();
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "El cliente es nuevo");
            String text = "SIN REGISTRO";
            nombreClientes.add(text);
            tipoPlanCliente.add(text);
            numeroDelPlan.add("NA");
            nombreDelPlan.add(text);
            tipoPlanContratado.add(text);
            componentesPlanContratado.add(text);
            estadoDelPlan.add(text);
            deudaDelPlan.add(text);
            cantidadDeudaDelPlan.add(text);
            iptvPlan.add(text);
            ordenVueloPlan.add(text);
            tecnologiaPlan.add(text);
            velocidadPlan.add(text);
            cuentaConSVAPlan.add(text);
            direccionMigrarFTTH.add(text);
            etiquetaFibra.add(text);
            cicloFacturacion.add(text);
            tiempoCreacionLinea.add(text);
            direccionCliente.add(text);
            estadoDireccion.add(text);
            tecnologiaAMigrar.add(text);
            etiquetaSaltoCero.add(text);
        }
        Integer[] totalElementosPlanClienteArray = totalElementosPlanCliente.toArray(new Integer[0]);
        String[] tipoPlanArray = tipoPlanCliente.toArray(new String[0]);
        String[] numeroLineaArray = numeroDelPlan.toArray(new String[0]);
        String[] nombrePlanArray = nombreDelPlan.toArray(new String[0]);
        String[] tipoPlanContratadoArray = tipoPlanContratado.toArray(new String[0]);
        String[] componentesPlanContratadoArray = componentesPlanContratado.toArray(new String[0]);
        String[] estadoPlanArray = estadoDelPlan.toArray(new String[0]);
        String[] deudaPlanArray = deudaDelPlan.toArray(new String[0]);
        String[] cantidadDeudaDelPlanArray = cantidadDeudaDelPlan.toArray(new String[0]);
        String[] iptvArray = iptvPlan.toArray(new String[0]);
        String[] ordenVueloArray = ordenVueloPlan.toArray(new String[0]);
        String[] nombreClientesArray = nombreClientes.toArray(new String[0]);
        String[] tecnologiaPlanArray = tecnologiaPlan.toArray(new String[0]);
        String[] velocidadPlanArray = velocidadPlan.toArray(new String[0]);
        String[] cuentaConSVAPlanArray = cuentaConSVAPlan.toArray(new String[0]);
        String[] direccionMigrarFTTHArray = direccionMigrarFTTH.toArray(new String[0]);
        String[] etiquetaFibraArray = etiquetaFibra.toArray(new String[0]);
        String[] cicloFacturacionArray = cicloFacturacion.toArray(new String[0]);
        String[] tiempoCreacionLineaArray = tiempoCreacionLinea.toArray(new String[0]);
        String[] direccionClienteArray = direccionCliente.toArray(new String[0]);
        String[] estadoDireccionArray = estadoDireccion.toArray(new String[0]);
        String[] tecnologiaAMigrarArray = tecnologiaAMigrar.toArray(new String[0]);
        String[] etiquetaSaltoCeroArray = etiquetaSaltoCero.toArray(new String[0]);
        verlistas(tipoPlanCliente, tipoPlanArray, "TIPO PLAN");
        verlistas(numeroDelPlan, numeroLineaArray, "NUMERO DEL PLAN");
        verlistas(nombreDelPlan, nombrePlanArray, "NOMBRE DEL PLAN");
        verlistas(tipoPlanContratado, tipoPlanContratadoArray, "TIPO PLAN CONTRATADO");
        verlistas(componentesPlanContratado, componentesPlanContratadoArray, "COMPONENTES PLAN CONTRATADO");
        verlistas(estadoDelPlan, estadoPlanArray, "ESTADO DEL PLAN");
        verlistas(deudaDelPlan, deudaPlanArray, "SI TIENE DEUDA EL PLAN");
        verlistas(cantidadDeudaDelPlan, cantidadDeudaDelPlanArray, "LA CANTIDAD QUE TIENE DE DEUDA");
        verlistas(iptvPlan, iptvArray, "SI EL PLAN TIENE IPTV");
        verlistas(ordenVueloPlan, ordenVueloArray, "SI EL PLAN TIENE ORDEN EN VUELO");
        verlistasInt(totalElementosPlanCliente, totalElementosPlanClienteArray, "TOTAL ELEMENTOS PLAN CLIENTE");
        verlistas(nombreClientes, nombreClientesArray, "VER NOMBRE CLIENTE");
        verlistas(tecnologiaPlan, tecnologiaPlanArray, "VER TIPO TECNOLOGIA DE RED");
        verlistas(velocidadPlan, velocidadPlanArray, "VER VELOCIDAD DE RED");
        verlistas(cuentaConSVAPlan, cuentaConSVAPlanArray, "VER SI CUENTA CON SVA");
        verlistas(direccionMigrarFTTH, direccionMigrarFTTHArray, "VER SI PUEDE MIGRAR A FIBRA");
        verlistas(etiquetaFibra, etiquetaFibraArray, "VER SI TIENE ETIQUETA FIBRA");
        verlistas(cicloFacturacion, cicloFacturacionArray, "VER CICLOS DE FACTURACION");
        verlistas(tiempoCreacionLinea, tiempoCreacionLineaArray, "VER ANTIGUEDAD DE LINEA");
        verlistas(direccionCliente, direccionClienteArray, "VER DIRECCION DEL CLIENTE");
        verlistas(estadoDireccion, estadoDireccionArray, "VER ESTADO DIRECCION");
        verlistas(tecnologiaAMigrar, tecnologiaAMigrarArray, "VER TECNOLOGIA A MIGRAR");
        verlistas(etiquetaSaltoCero, etiquetaSaltoCeroArray, "VER SI TIENE SALTO 0");
        for (int i = 0; i < tipoPlanArray.length; i++) {
            System.out.println(TIPO_DOCUMENTO + ", " + NUMERO_DOCUMENTO + ", " + nombreClientesArray[0] + ", " + tipoPlanArray[i] + ", " + numeroLineaArray[i] + ", " + nombrePlanArray[i] + ", " + tipoPlanContratadoArray[i] + ", " + componentesPlanContratadoArray[i] + ", " + estadoPlanArray[i] + ", " + deudaPlanArray[i] + ", " + cantidadDeudaDelPlanArray[i] + ", " + iptvArray[i] + ", " + ordenVueloArray[i] + ", " + tecnologiaPlanArray[i] + ", " + velocidadPlanArray[i] + ", " + cuentaConSVAPlanArray[i] + ", " + direccionMigrarFTTHArray[i] + ", " + etiquetaFibraArray[i] + ", " + cicloFacturacionArray[i] + ", " + tiempoCreacionLineaArray[i] + ", " + direccionClienteArray[i] + ", " + estadoDireccionArray[i] + ", " + tecnologiaAMigrarArray[i] + ", " + etiquetaSaltoCeroArray[i]);
            tipoDocuemtoList.add(TIPO_DOCUMENTO);
            numeroDocumentoList.add(NUMERO_DOCUMENTO);
            nombreClienteList.add(nombreClientesArray[0]);
            tipoPlanClienteList.add(tipoPlanArray[i]);
            numeroLineaList.add(numeroLineaArray[i]);
            nombrePlanList.add(nombrePlanArray[i]);
            tipoPlanContratadoList.add(tipoPlanContratadoArray[i]);
            componentesPlanContratadoList.add(componentesPlanContratadoArray[i]);
            estadoPlanList.add(estadoPlanArray[i]);
            deudaClienteList.add(deudaPlanArray[i]);
            cantidadDeudaList.add(cantidadDeudaDelPlanArray[i]);
            planIPTVList.add(iptvArray[i]);
            ordenEnVueloList.add(ordenVueloArray[i]);
            tecnologiaPlanList.add(tecnologiaPlanArray[i]);
            velocidadPlanList.add(velocidadPlanArray[i]);
            cuentaConSVAPlanList.add(cuentaConSVAPlanArray[i]);
            direccionMigrarFTTHList.add(direccionMigrarFTTHArray[i]);
            etiquetaFibraList.add(etiquetaFibraArray[i]);
            cicloFacturacionList.add(cicloFacturacionArray[i]);
            tiempoCreacionLineaList.add(tiempoCreacionLineaArray[i]);
            direccionClienteList.add(direccionClienteArray[i]);
            estadoDireccionList.add(estadoDireccionArray[i]);
            tecnologiaAMigrarList.add(tecnologiaAMigrarArray[i]);
            etiquetaSaltoCeroList.add(etiquetaSaltoCeroArray[i]);

            // INSERTAR DATOS

            clienteDataList.add(new ClienteData(TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE_CLIENTE, tipoPlanArray[i], numeroLineaArray[i], nombrePlanArray[i], tipoPlanContratadoArray[i], componentesPlanContratadoArray[i], estadoPlanArray[i], deudaPlanArray[i], cantidadDeudaDelPlanArray[i], iptvArray[i], ordenVueloArray[i], tecnologiaPlanArray[i], velocidadPlanArray[i], cuentaConSVAPlanArray[i], direccionMigrarFTTHArray[i], etiquetaFibraArray[i], cicloFacturacionArray[i], tiempoCreacionLineaArray[i], direccionClienteArray[i], estadoDireccionArray[i], tecnologiaAMigrarArray[i], etiquetaSaltoCeroArray[i]));
        }

        generarExcel(folderPath, excelName, sheetName);
        generarExcelBitacora(folderPathBitacora, excelNameBitacora, sheetNameBitacora);
        imprimirReporte();
    }

    public void visualizoMasPlanesCliente(String tipoDocumentoCliente, String numeroDocumentoCliente) {
        //String[] tiposDocumentos = tipoDocumentoCliente.split(",\\s");
        String[] tiposNumDocumCliente = numeroDocumentoCliente.split(",\\s");
        //int numElementos = Math.min(tiposDocumentos.length, tiposNumDocumCliente.length);
        int numElementos = tiposNumDocumCliente.length;
        int contarErrorDoc = 0;
        int recorrido = 0;
        for (int j = 0; j < numElementos; j++) {
            recorrido++;
            System.out.println("**********************************");
            System.out.println("SE INICIA RECORRIDO N°" + recorrido);
            System.out.println("**********************************");
            if (recorrido % 5 == 0 && recorrido > 1) {
                cargarMsgLog(Level.INFO,"SE APLICA ZOOM - 0");
                Zoom(65);
            }
            if (recorrido % 25 == 0 && recorrido > 1) {
                cargarMsgLog(Level.INFO,"SE CUMPLIO REQUISITO % 25");
                click(btnInicio,15);
                UtilWeb.waitForSeconds(4);
                clickBtnReintentar();
                UtilWeb.waitForSeconds(2);
                Zoom(65);
            }
            //TIPO_DOCUMENTO = tiposDocumentos[j];
            TIPO_DOCUMENTO = tipoDocumentoCliente;
            System.out.println("Doc Consultado: " + TIPO_DOCUMENTO);
            NUMERO_DOCUMENTO = tiposNumDocumCliente[j];
            System.out.println("Num Doc Consultado: " + NUMERO_DOCUMENTO);
            //seleccionoTipoDocumento(tiposDocumentos[j]);
            seleccionoTipoDocumento(tipoDocumentoCliente);
            ingresoNumDocumento(tiposNumDocumCliente[j]);
            clickBotonConsultar();
            visualizarBtnCargarMas();
            contarElementosExistentes();
            int elementos = contarElementosExistentes();
            try {
                if (nombreCliente.isDisplayed()) {
                    NOMBRE_CLIENTE = nombreCliente.getText().substring(8);
                    cargarMsgLog(Level.INFO, "Nombre Cliente: " + NOMBRE_CLIENTE);
                    nombreClientes.add(NOMBRE_CLIENTE);
                    almacenarElementosExistentes();
                    sacarNumeroPlan();
                    sacarNombrePlanCliente();
                    tipoPlan();
                    estadoPlan();
                    verSiTieneDeuda();
                    cantidadDeuda();
                    tipoPlanDelCliente(elementos);
                    verSiEsPlanIPTV();
                    verSiTieneOrdenEnVuelo();
                    verSiMigraAFibra();
                    clickParaSeleccionarPlanActivo();
                }
            } catch (Exception e) {
                cargarMsgLog(Level.INFO, "El cliente es nuevo");
                String text = "SIN REGISTRO";
                almacenarElementosExistentes();
                nombreClientes.add(text);
                tipoPlanCliente.add(text);
                numeroDelPlan.add("NA");
                nombreDelPlan.add(text);
                tipoPlanContratado.add(text);
                componentesPlanContratado.add(text);
                estadoDelPlan.add(text);
                deudaDelPlan.add(text);
                cantidadDeudaDelPlan.add(text);
                iptvPlan.add(text);
                ordenVueloPlan.add(text);
                tecnologiaPlan.add(text);
                velocidadPlan.add(text);
                cuentaConSVAPlan.add(text);
                direccionMigrarFTTH.add(text);
                etiquetaFibra.add(text);
                cicloFacturacion.add(text);
                tiempoCreacionLinea.add(text);
                direccionCliente.add(text);
                estadoDireccion.add(text);
                tecnologiaAMigrar.add(text);
                etiquetaSaltoCero.add(text);
            }
            Integer[] totalElementosPlanClienteArray = totalElementosPlanCliente.toArray(new Integer[0]);
            String[] tipoPlanArray = tipoPlanCliente.toArray(new String[0]);
            String[] numeroLineaArray = numeroDelPlan.toArray(new String[0]);
            String[] nombrePlanArray = nombreDelPlan.toArray(new String[0]);
            String[] tipoPlanContratadoArray = tipoPlanContratado.toArray(new String[0]);
            String[] componentesPlanContratadoArray = componentesPlanContratado.toArray(new String[0]);
            String[] estadoPlanArray = estadoDelPlan.toArray(new String[0]);
            String[] deudaPlanArray = deudaDelPlan.toArray(new String[0]);
            String[] cantidadDeudaDelPlanArray = cantidadDeudaDelPlan.toArray(new String[0]);
            String[] iptvArray = iptvPlan.toArray(new String[0]);
            String[] ordenVueloArray = ordenVueloPlan.toArray(new String[0]);
            String[] nombreClientesArray = nombreClientes.toArray(new String[0]);
            String[] tecnologiaPlanArray = tecnologiaPlan.toArray(new String[0]);
            String[] velocidadPlanArray = velocidadPlan.toArray(new String[0]);
            String[] cuentaConSVAPlanArray = cuentaConSVAPlan.toArray(new String[0]);
            String[] direccionMigrarFTTHArray = direccionMigrarFTTH.toArray(new String[0]);
            String[] etiquetaFibraArray = etiquetaFibra.toArray(new String[0]);
            String[] cicloFacturacionArray = cicloFacturacion.toArray(new String[0]);
            String[] tiempoCreacionLineaArray = tiempoCreacionLinea.toArray(new String[0]);
            String[] direccionClienteArray = direccionCliente.toArray(new String[0]);
            String[] estadoDireccionArray = estadoDireccion.toArray(new String[0]);
            String[] tecnologiaAMigrarArray = tecnologiaAMigrar.toArray(new String[0]);
            String[] etiquetaSaltoCeroArray = etiquetaSaltoCero.toArray(new String[0]);
            verlistas(tipoPlanCliente, tipoPlanArray, "TIPO PLAN");
            verlistas(numeroDelPlan, numeroLineaArray, "NUMERO DEL PLAN");
            verlistas(nombreDelPlan, nombrePlanArray, "NOMBRE DEL PLAN");
            verlistas(tipoPlanContratado, tipoPlanContratadoArray, "TIPO PLAN CONTRATADO");
            verlistas(componentesPlanContratado, componentesPlanContratadoArray, "COMPONENTES PLAN CONTRATADO");
            verlistas(estadoDelPlan, estadoPlanArray, "ESTADO DEL PLAN");
            verlistas(deudaDelPlan, deudaPlanArray, "SI TIENE DEUDA EL PLAN");
            verlistas(cantidadDeudaDelPlan, cantidadDeudaDelPlanArray, "LA CANTIDAD QUE TIENE DE DEUDA");
            verlistas(iptvPlan, iptvArray, "SI EL PLAN TIENE IPTV");
            verlistas(ordenVueloPlan, ordenVueloArray, "SI EL PLAN TIENE ORDEN EN VUELO");
            verlistasInt(totalElementosPlanCliente, totalElementosPlanClienteArray, "TOTAL ELEMENTOS PLAN CLIENTE");
            verlistas(tecnologiaPlan, tecnologiaPlanArray, "VER TIPO TECNOLOGIA DE RED");
            verlistas(velocidadPlan, velocidadPlanArray, "VER VELOCIDAD DE RED");
            verlistas(cuentaConSVAPlan, cuentaConSVAPlanArray, "VER SI CUENTA CON SVA");
            verlistas(direccionMigrarFTTH, direccionMigrarFTTHArray, "VER SI PUEDE MIGRAR A FIBRA");
            verlistas(nombreClientes, nombreClientesArray, "VER NOMBRE CLIENTE");
            verlistas(etiquetaFibra, etiquetaFibraArray, "VER SI TIENE ETIQUETA FIBRA");
            verlistas(cicloFacturacion, cicloFacturacionArray, "VER CICLOS DE FACTURACION");
            verlistas(tiempoCreacionLinea, tiempoCreacionLineaArray, "VER ANTIGUEDAD DE LINEA");
            verlistas(direccionCliente, direccionClienteArray, "VER DIRECCION DEL CLIENTE");
            verlistas(estadoDireccion, estadoDireccionArray, "VER ESTADO DIRECCION");
            verlistas(tecnologiaAMigrar, tecnologiaAMigrarArray, "VER TECNOLOGIA A MIGRAR");
            verlistas(etiquetaSaltoCero, etiquetaSaltoCeroArray, "VER SI TIENE SALTO 0");
            NOMBRE_CLIENTE = nombreClientesArray[j];
            System.out.println("LONGITUD FOR: " + numeroLineaArray.length);

            addElementosArray(numeroDelPlan, numeroLineaArray, "NUMERO DEL PLAN");
            addElementosArray(nombreDelPlan, nombrePlanArray, "NOMBRE DEL PLAN");
            addElementosArray(tipoPlanContratado, tipoPlanContratadoArray, "TIPO PLAN CONTRATADO");
            addElementosArray(componentesPlanContratado, componentesPlanContratadoArray, "COMPONENTES PLAN CONTRATADO");
            addElementosArray(estadoDelPlan, estadoPlanArray, "ESTADO DEL PLAN");
            addElementosArray(deudaDelPlan, deudaPlanArray, "SI TIENE DEUDA EL PLAN");
            addElementosArray(cantidadDeudaDelPlan, cantidadDeudaDelPlanArray, "LA CANTIDAD QUE TIENE DE DEUDA");
            addElementosArray(iptvPlan, iptvArray, "SI EL PLAN TIENE IPTV");
            addElementosArray(ordenVueloPlan, ordenVueloArray, "SI EL PLAN TIENE ORDEN EN VUELO");
            addElementosArray(tecnologiaPlan, tecnologiaPlanArray, "VER TIPO TECNOLOGIA DE RED");
            addElementosArray(velocidadPlan, velocidadPlanArray, "VER VELOCIDAD DE RED");
            addElementosArray(cuentaConSVAPlan, cuentaConSVAPlanArray, "VER SI CUENTA CON SVA");
            addElementosArray(direccionMigrarFTTH, direccionMigrarFTTHArray, "VER SI PUEDE MIGRAR A FIBRA");
            addElementosArray(etiquetaFibra, etiquetaFibraArray, "VER SI TIENE ETIQUETA FIBRA");
            addElementosArray(cicloFacturacion, cicloFacturacionArray, "VER CICLOS DE FACTURACION");
            addElementosArray(tiempoCreacionLinea, tiempoCreacionLineaArray, "VER ANTIGUEDAD DE LINEA");
            addElementosArray(direccionCliente, direccionClienteArray, "VER DIRECCION DEL CLIENTE");
            addElementosArray(estadoDireccion, estadoDireccionArray, "VER ESTADO DIRECCION");
            addElementosArray(tecnologiaAMigrar, tecnologiaAMigrarArray, "VER TECNOLOGIA A MIGRAR");
            addElementosArray(etiquetaSaltoCero, etiquetaSaltoCeroArray, "VER SI TIENE SALTO 0");

            Integer[] totalElementosPorArrayAll = totalElementosPorArray.toArray(new Integer[0]);

            verlistasInt(totalElementosPorArray, totalElementosPorArrayAll, "CANTIDAD DE ELEMENTOS POR ARRAY");

            String resultado;
            for (int i = 0; i < totalElementosPorArrayAll.length; i++) {
                if (Objects.equals(totalElementosPorArrayAll[0], totalElementosPorArrayAll[i])) {
                    System.out.println("ELEMENTO " + i + " ES IGUAL AL ELEMENTO SIGUIENTE");
                    resultado = "OK";
                    resultadoList.add(resultado);
                } else {
                    System.out.println("ELEMENTO " + i + " NO ES IGUAL AL ELEMENTO SIGUIENTE");
                }
            }

            String[] resultadoListArray = resultadoList.toArray(new String[0]);
            verlistas(resultadoList, resultadoListArray, "VER RESULTADOS");

            System.out.println("CANTIDAD EN LISTA DE RESULTADOS: " + resultadoListArray.length);
            System.out.println("CANTIDAD EN LISTA DE ELEMENTOS POR ARRAY: " + totalElementosPorArrayAll.length);

            if (resultadoListArray.length == totalElementosPorArrayAll.length) {
                for (int i = 0; i < numeroLineaArray.length; i++) {
                    System.out.println(TIPO_DOCUMENTO + ", " + NUMERO_DOCUMENTO + ", " + NOMBRE_CLIENTE + ", " + tipoPlanArray[i] + ", " + numeroLineaArray[i] + ", " + nombrePlanArray[i] + ", " + tipoPlanContratadoArray[i] + ", " + componentesPlanContratadoArray[i] + ", " + estadoPlanArray[i] + ", " + deudaPlanArray[i] + ", " + cantidadDeudaDelPlanArray[i] + ", " + iptvArray[i] + ", " + ordenVueloArray[i] + ", " + tecnologiaPlanArray[i] + ", " + velocidadPlanArray[i] + ", " + cuentaConSVAPlanArray[i] + ", " + direccionMigrarFTTHArray[i] + ", " + etiquetaFibraArray[i] + ", " + cicloFacturacionArray[i] + ", " + tiempoCreacionLineaArray[i] + ", " + direccionClienteArray[i] + ", " + estadoDireccionArray[i] + ", " + tecnologiaAMigrarArray[i] + ", " + etiquetaSaltoCeroArray[i]);
                    tipoDocuemtoList.add(TIPO_DOCUMENTO);
                    numeroDocumentoList.add(NUMERO_DOCUMENTO);
                    nombreClienteList.add(NOMBRE_CLIENTE);
                    tipoPlanClienteList.add(tipoPlanArray[i]);
                    numeroLineaList.add(numeroLineaArray[i]);
                    nombrePlanList.add(nombrePlanArray[i]);
                    tipoPlanContratadoList.add(tipoPlanContratadoArray[i]);
                    componentesPlanContratadoList.add(componentesPlanContratadoArray[i]);
                    estadoPlanList.add(estadoPlanArray[i]);
                    deudaClienteList.add(deudaPlanArray[i]);
                    cantidadDeudaList.add(cantidadDeudaDelPlanArray[i]);
                    planIPTVList.add(iptvArray[i]);
                    ordenEnVueloList.add(ordenVueloArray[i]);
                    tecnologiaPlanList.add(tecnologiaPlanArray[i]);
                    velocidadPlanList.add(velocidadPlanArray[i]);
                    cuentaConSVAPlanList.add(cuentaConSVAPlanArray[i]);
                    direccionMigrarFTTHList.add(direccionMigrarFTTHArray[i]);
                    etiquetaFibraList.add(etiquetaFibraArray[i]);
                    cicloFacturacionList.add(cicloFacturacionArray[i]);
                    tiempoCreacionLineaList.add(tiempoCreacionLineaArray[i]);
                    direccionClienteList.add(direccionClienteArray[i]);
                    estadoDireccionList.add(estadoDireccionArray[i]);
                    tecnologiaAMigrarList.add(tecnologiaAMigrarArray[i]);
                    etiquetaSaltoCeroList.add(etiquetaSaltoCeroArray[i]);

                    // INSERTAR DATOS
                    clienteDataList.clear();
                    clienteDataList.add(new ClienteData(TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE_CLIENTE, tipoPlanArray[i], numeroLineaArray[i], nombrePlanArray[i], tipoPlanContratadoArray[i], componentesPlanContratadoArray[i], estadoPlanArray[i], deudaPlanArray[i], cantidadDeudaDelPlanArray[i], iptvArray[i], ordenVueloArray[i], tecnologiaPlanArray[i], velocidadPlanArray[i], cuentaConSVAPlanArray[i], direccionMigrarFTTHArray[i], etiquetaFibraArray[i], cicloFacturacionArray[i], tiempoCreacionLineaArray[i], direccionClienteArray[i], estadoDireccionArray[i], tecnologiaAMigrarArray[i], etiquetaSaltoCeroArray[i]));
                    generarExcel(folderPath, excelName, sheetName);
                    generarExcelBitacora(folderPathBitacora, excelNameBitacora, sheetNameBitacora);
                }
            } else {
                contarErrorDoc++;
                System.out.println("DOCUMENTOS ERROR: " + contarErrorDoc);
                clienteDataList.clear();
                clienteDataList.add(new ClienteData(TIPO_DOCUMENTO, NUMERO_DOCUMENTO));
                generarExcelError(folderPath, excelName, sheetNameError);
                for (int i = 0; i < numeroLineaArray.length; i++) {
                    // INSERTAR DATOS
                    clienteDataList.clear();
                    clienteDataList.add(new ClienteData(TIPO_DOCUMENTO, NUMERO_DOCUMENTO, numeroLineaArray[i]));
                    generarExcelBitacora(folderPathBitacora, excelNameBitacora, sheetNameBitacora);
                }
                System.out.println("SE REGRESA AL INICIO");
                action.sendKeys(Keys.ESCAPE).build().perform();
                UtilWeb.waitForSeconds(2);
                click(btnInicio,15);
                UtilWeb.waitForSeconds(5);
                clickBtnReintentar();
                UtilWeb.waitForSeconds(2);
                Zoom(65);
            }
            tipoPlanCliente.clear();
            numeroDelPlan.clear();
            nombreDelPlan.clear();
            tipoPlanContratado.clear();
            componentesPlanContratado.clear();
            estadoDelPlan.clear();
            deudaDelPlan.clear();
            cantidadDeudaDelPlan.clear();
            iptvPlan.clear();
            ordenVueloPlan.clear();
            tecnologiaPlan.clear();
            velocidadPlan.clear();
            cuentaConSVAPlan.clear();
            direccionMigrarFTTH.clear();
            etiquetaFibra.clear();
            cicloFacturacion.clear();
            tiempoCreacionLinea.clear();
            direccionCliente.clear();
            estadoDireccion.clear();
            tecnologiaAMigrar.clear();
            etiquetaSaltoCero.clear();

            totalElementosPorArray.clear();
            resultadoList.clear();
        }

        imprimirReporte();
    }

    public void visualizoMasPlanesClienteWhiteList() {
        int cantidad;

        DecimalFormat decimalFormat = new DecimalFormat("#");

        try {
            // Lee el archivo Excel
            FileInputStream fileInputStream = new FileInputStream(pathWhiteList);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Lee la primera hoja
            cantidad = sheet.getLastRowNum();
            System.out.println("CANTIDAD FILAS: " + cantidad);

            fileInputStream.close();

            int contarErrorDoc = 0;
            int contador = 0;
            int paso = 0;

            for (int j = 1; j <= cantidad; j++) {

                Row row = sheet.getRow(j);
                String estado = "";

                if (row != null) {
                    contador++;
                    // Leer Columnas - Tipo Documento | Numero Documento
                    Cell tipoDocumentoCell = row.getCell(0);
                    Cell numeroDocumentoCell = row.getCell(1);
                    Cell estadoCell = row.getCell(2);

                    if (estadoCell == null) {
                        paso++;

                        // Insertar Texto
                        String tipoDocumento = tipoDocumentoCell.getStringCellValue();
                        String numeroDocumento = String.valueOf(decimalFormat.format(numeroDocumentoCell.getNumericCellValue()));

                        System.out.println("******************************************");
                        System.out.println("TIPO DOCUMENTO: " + tipoDocumento);
                        System.out.println("NUMERO DOCUMENTO: " + numeroDocumento);
                        System.out.println("ESTADO PROCESO: " + estado);
                        System.out.println("RECORRIDO N°" + j + " de " + cantidad);
                        System.out.println("INICIO - N°" + paso);
                        System.out.println("******************************************");

                        if (contador % 5 == 0 && contador > 1) {
                            cargarMsgLog(Level.INFO,"SE APLICA ZOOM - 0");
                            Zoom(65);
                        }
                        if (contador % 25 == 0 && contador > 1) {
                            cargarMsgLog(Level.INFO,"SE CUMPLIO REQUISITO % 25");
                            click(btnInicio,15);
                            UtilWeb.waitForSeconds(4);
                            clickBtnReintentar();
                            UtilWeb.waitForSeconds(2);
                            Zoom(65);
                        }
                        //TIPO_DOCUMENTO = tiposDocumentos[j];
                        TIPO_DOCUMENTO = tipoDocumento;
                        System.out.println("Doc Consultado: " + TIPO_DOCUMENTO);
                        NUMERO_DOCUMENTO = numeroDocumento;
                        System.out.println("Num Doc Consultado: " + NUMERO_DOCUMENTO);
                        seleccionoTipoDocumento(tipoDocumento);
                        ingresoNumDocumento(numeroDocumento);
                        clickBotonConsultar();
                        visualizarBtnCargarMas();
                        int elementos = contarElementosExistentes();
                        try {
                            if (nombreCliente.isDisplayed()) {
                                NOMBRE_CLIENTE = nombreCliente.getText().substring(8);
                                cargarMsgLog(Level.INFO, "Nombre Cliente: " + NOMBRE_CLIENTE);
                                nombreClientes.add(NOMBRE_CLIENTE);
                                almacenarElementosExistentes();
                                sacarNumeroPlan();
                                sacarNombrePlanCliente();
                                tipoPlan();
                                estadoPlan();
                                verSiTieneDeuda();
                                cantidadDeuda();
                                tipoPlanDelCliente(elementos);
                                verSiEsPlanIPTV();
                                verSiTieneOrdenEnVuelo();
                                verSiMigraAFibra();
                                clickParaSeleccionarPlanActivo();
                                estado = "EXITOSO";
                            }
                        } catch (Exception e) {
                            cargarMsgLog(Level.INFO, "El cliente es nuevo");
                            String text = "SIN REGISTRO";
                            almacenarElementosExistentes();
                            nombreClientes.add(text);
                            tipoPlanCliente.add(text);
                            numeroDelPlan.add("NA");
                            nombreDelPlan.add(text);
                            tipoPlanContratado.add(text);
                            componentesPlanContratado.add(text);
                            estadoDelPlan.add(text);
                            deudaDelPlan.add(text);
                            cantidadDeudaDelPlan.add(text);
                            iptvPlan.add(text);
                            ordenVueloPlan.add(text);
                            tecnologiaPlan.add(text);
                            velocidadPlan.add(text);
                            cuentaConSVAPlan.add(text);
                            direccionMigrarFTTH.add(text);
                            etiquetaFibra.add(text);
                            cicloFacturacion.add(text);
                            tiempoCreacionLinea.add(text);
                            direccionCliente.add(text);
                            estadoDireccion.add(text);
                            tecnologiaAMigrar.add(text);
                            etiquetaSaltoCero.add(text);
                            estado = "EXITOSO";
                        }

                        Integer[] totalElementosPlanClienteArray = totalElementosPlanCliente.toArray(new Integer[0]);
                        String[] tipoPlanArray = tipoPlanCliente.toArray(new String[0]);
                        String[] numeroLineaArray = numeroDelPlan.toArray(new String[0]);
                        String[] nombrePlanArray = nombreDelPlan.toArray(new String[0]);
                        String[] tipoPlanContratadoArray = tipoPlanContratado.toArray(new String[0]);
                        String[] componentesPlanContratadoArray = componentesPlanContratado.toArray(new String[0]);
                        String[] estadoPlanArray = estadoDelPlan.toArray(new String[0]);
                        String[] deudaPlanArray = deudaDelPlan.toArray(new String[0]);
                        String[] cantidadDeudaDelPlanArray = cantidadDeudaDelPlan.toArray(new String[0]);
                        String[] iptvArray = iptvPlan.toArray(new String[0]);
                        String[] ordenVueloArray = ordenVueloPlan.toArray(new String[0]);
                        String[] nombreClientesArray = nombreClientes.toArray(new String[0]);
                        String[] tecnologiaPlanArray = tecnologiaPlan.toArray(new String[0]);
                        String[] velocidadPlanArray = velocidadPlan.toArray(new String[0]);
                        String[] cuentaConSVAPlanArray = cuentaConSVAPlan.toArray(new String[0]);
                        String[] direccionMigrarFTTHArray = direccionMigrarFTTH.toArray(new String[0]);
                        String[] etiquetaFibraArray = etiquetaFibra.toArray(new String[0]);
                        String[] cicloFacturacionArray = cicloFacturacion.toArray(new String[0]);
                        String[] tiempoCreacionLineaArray = tiempoCreacionLinea.toArray(new String[0]);
                        String[] direccionClienteArray = direccionCliente.toArray(new String[0]);
                        String[] estadoDireccionArray = estadoDireccion.toArray(new String[0]);
                        String[] tecnologiaAMigrarArray = tecnologiaAMigrar.toArray(new String[0]);
                        String[] etiquetaSaltoCeroArray = etiquetaSaltoCero.toArray(new String[0]);
                        verlistas(tipoPlanCliente, tipoPlanArray, "TIPO PLAN");
                        verlistas(numeroDelPlan, numeroLineaArray, "NUMERO DEL PLAN");
                        verlistas(nombreDelPlan, nombrePlanArray, "NOMBRE DEL PLAN");
                        verlistas(tipoPlanContratado, tipoPlanContratadoArray, "TIPO PLAN CONTRATADO");
                        verlistas(componentesPlanContratado, componentesPlanContratadoArray, "COMPONENTES PLAN CONTRATADO");
                        verlistas(estadoDelPlan, estadoPlanArray, "ESTADO DEL PLAN");
                        verlistas(deudaDelPlan, deudaPlanArray, "SI TIENE DEUDA EL PLAN");
                        verlistas(cantidadDeudaDelPlan, cantidadDeudaDelPlanArray, "LA CANTIDAD QUE TIENE DE DEUDA");
                        verlistas(iptvPlan, iptvArray, "SI EL PLAN TIENE IPTV");
                        verlistas(ordenVueloPlan, ordenVueloArray, "SI EL PLAN TIENE ORDEN EN VUELO");
                        verlistasInt(totalElementosPlanCliente, totalElementosPlanClienteArray, "TOTAL ELEMENTOS PLAN CLIENTE");
                        verlistas(tecnologiaPlan, tecnologiaPlanArray, "VER TIPO TECNOLOGIA DE RED");
                        verlistas(velocidadPlan, velocidadPlanArray, "VER VELOCIDAD DE RED");
                        verlistas(cuentaConSVAPlan, cuentaConSVAPlanArray, "VER SI CUENTA CON SVA");
                        verlistas(direccionMigrarFTTH, direccionMigrarFTTHArray, "VER SI PUEDE MIGRAR A FIBRA");
                        verlistas(nombreClientes, nombreClientesArray, "VER NOMBRE CLIENTE");
                        verlistas(etiquetaFibra, etiquetaFibraArray, "VER SI TIENE ETIQUETA FIBRA");
                        verlistas(cicloFacturacion, cicloFacturacionArray, "VER CICLOS DE FACTURACION");
                        verlistas(tiempoCreacionLinea, tiempoCreacionLineaArray, "VER ANTIGUEDAD DE LINEA");
                        verlistas(direccionCliente, direccionClienteArray, "VER DIRECCION DEL CLIENTE");
                        verlistas(estadoDireccion, estadoDireccionArray, "VER ESTADO DIRECCION");
                        verlistas(tecnologiaAMigrar, tecnologiaAMigrarArray, "VER TECNOLOGIA A MIGRAR");
                        verlistas(etiquetaSaltoCero, etiquetaSaltoCeroArray, "VER SI TIENE SALTO 0");
                        int cantidadAlmancenadaNombre = nombreClientesArray.length - 1;
                        NOMBRE_CLIENTE = nombreClientesArray[cantidadAlmancenadaNombre];
                        System.out.println("LONGITUD FOR: " + numeroLineaArray.length);

                        addElementosArray(numeroDelPlan, numeroLineaArray, "NUMERO DEL PLAN");
                        addElementosArray(nombreDelPlan, nombrePlanArray, "NOMBRE DEL PLAN");
                        addElementosArray(tipoPlanContratado, tipoPlanContratadoArray, "TIPO PLAN CONTRATADO");
                        addElementosArray(componentesPlanContratado, componentesPlanContratadoArray, "COMPONENTES PLAN CONTRATADO");
                        addElementosArray(estadoDelPlan, estadoPlanArray, "ESTADO DEL PLAN");
                        addElementosArray(deudaDelPlan, deudaPlanArray, "SI TIENE DEUDA EL PLAN");
                        addElementosArray(cantidadDeudaDelPlan, cantidadDeudaDelPlanArray, "LA CANTIDAD QUE TIENE DE DEUDA");
                        addElementosArray(iptvPlan, iptvArray, "SI EL PLAN TIENE IPTV");
                        addElementosArray(ordenVueloPlan, ordenVueloArray, "SI EL PLAN TIENE ORDEN EN VUELO");
                        addElementosArray(tecnologiaPlan, tecnologiaPlanArray, "VER TIPO TECNOLOGIA DE RED");
                        addElementosArray(velocidadPlan, velocidadPlanArray, "VER VELOCIDAD DE RED");
                        addElementosArray(cuentaConSVAPlan, cuentaConSVAPlanArray, "VER SI CUENTA CON SVA");
                        addElementosArray(direccionMigrarFTTH, direccionMigrarFTTHArray, "VER SI PUEDE MIGRAR A FIBRA");
                        addElementosArray(etiquetaFibra, etiquetaFibraArray, "VER SI TIENE ETIQUETA FIBRA");
                        addElementosArray(cicloFacturacion, cicloFacturacionArray, "VER CICLOS DE FACTURACION");
                        addElementosArray(tiempoCreacionLinea, tiempoCreacionLineaArray, "VER ANTIGUEDAD DE LINEA");
                        addElementosArray(direccionCliente, direccionClienteArray, "VER DIRECCION DEL CLIENTE");
                        addElementosArray(estadoDireccion, estadoDireccionArray, "VER ESTADO DIRECCION");
                        addElementosArray(tecnologiaAMigrar, tecnologiaAMigrarArray, "VER TECNOLOGIA A MIGRAR");
                        addElementosArray(etiquetaSaltoCero, etiquetaSaltoCeroArray, "VER SI TIENE SALTO 0");

                        Integer[] totalElementosPorArrayAll = totalElementosPorArray.toArray(new Integer[0]);

                        verlistasInt(totalElementosPorArray, totalElementosPorArrayAll, "CANTIDAD DE ELEMENTOS POR ARRAY");

                        String resultado;
                        for (int i = 0; i < totalElementosPorArrayAll.length; i++) {
                            if (Objects.equals(totalElementosPorArrayAll[0], totalElementosPorArrayAll[i])) {
                                System.out.println("ELEMENTO " + i + " ES IGUAL AL ELEMENTO SIGUIENTE");
                                resultado = "OK";
                                resultadoList.add(resultado);
                            } else {
                                System.out.println("ELEMENTO " + i + " NO ES IGUAL AL ELEMENTO SIGUIENTE");
                            }
                        }

                        String[] resultadoListArray = resultadoList.toArray(new String[0]);
                        verlistas(resultadoList, resultadoListArray, "VER RESULTADOS");

                        System.out.println("CANTIDAD EN LISTA DE RESULTADOS: " + resultadoListArray.length);
                        System.out.println("CANTIDAD EN LISTA DE ELEMENTOS POR ARRAY: " + totalElementosPorArrayAll.length);

                        if (resultadoListArray.length == totalElementosPorArrayAll.length) {
                            for (int i = 0; i < numeroLineaArray.length; i++) {
                                System.out.println(TIPO_DOCUMENTO + ", " + NUMERO_DOCUMENTO + ", " + NOMBRE_CLIENTE + ", " + tipoPlanArray[i] + ", " + numeroLineaArray[i] + ", " + nombrePlanArray[i] + ", " + tipoPlanContratadoArray[i] + ", " + componentesPlanContratadoArray[i] + ", " + estadoPlanArray[i] + ", " + deudaPlanArray[i] + ", " + cantidadDeudaDelPlanArray[i] + ", " + iptvArray[i] + ", " + ordenVueloArray[i] + ", " + tecnologiaPlanArray[i] + ", " + velocidadPlanArray[i] + ", " + cuentaConSVAPlanArray[i] + ", " + direccionMigrarFTTHArray[i] + ", " + etiquetaFibraArray[i] + ", " + cicloFacturacionArray[i] + ", " + tiempoCreacionLineaArray[i] + ", " + direccionClienteArray[i] + ", " + estadoDireccionArray[i] + ", " + tecnologiaAMigrarArray[i] + ", " + etiquetaSaltoCeroArray[i]);
                                tipoDocuemtoList.add(TIPO_DOCUMENTO);
                                numeroDocumentoList.add(NUMERO_DOCUMENTO);
                                nombreClienteList.add(NOMBRE_CLIENTE);
                                tipoPlanClienteList.add(tipoPlanArray[i]);
                                numeroLineaList.add(numeroLineaArray[i]);
                                nombrePlanList.add(nombrePlanArray[i]);
                                tipoPlanContratadoList.add(tipoPlanContratadoArray[i]);
                                componentesPlanContratadoList.add(componentesPlanContratadoArray[i]);
                                estadoPlanList.add(estadoPlanArray[i]);
                                deudaClienteList.add(deudaPlanArray[i]);
                                cantidadDeudaList.add(cantidadDeudaDelPlanArray[i]);
                                planIPTVList.add(iptvArray[i]);
                                ordenEnVueloList.add(ordenVueloArray[i]);
                                tecnologiaPlanList.add(tecnologiaPlanArray[i]);
                                velocidadPlanList.add(velocidadPlanArray[i]);
                                cuentaConSVAPlanList.add(cuentaConSVAPlanArray[i]);
                                direccionMigrarFTTHList.add(direccionMigrarFTTHArray[i]);
                                etiquetaFibraList.add(etiquetaFibraArray[i]);
                                cicloFacturacionList.add(cicloFacturacionArray[i]);
                                tiempoCreacionLineaList.add(tiempoCreacionLineaArray[i]);
                                direccionClienteList.add(direccionClienteArray[i]);
                                estadoDireccionList.add(estadoDireccionArray[i]);
                                tecnologiaAMigrarList.add(tecnologiaAMigrarArray[i]);
                                etiquetaSaltoCeroList.add(etiquetaSaltoCeroArray[i]);

                                // INSERTAR DATOS
                                clienteDataList.clear();
                                clienteDataList.add(new ClienteData(TIPO_DOCUMENTO, NUMERO_DOCUMENTO, NOMBRE_CLIENTE, tipoPlanArray[i], numeroLineaArray[i], nombrePlanArray[i], tipoPlanContratadoArray[i], componentesPlanContratadoArray[i], estadoPlanArray[i], deudaPlanArray[i], cantidadDeudaDelPlanArray[i], iptvArray[i], ordenVueloArray[i], tecnologiaPlanArray[i], velocidadPlanArray[i], cuentaConSVAPlanArray[i], direccionMigrarFTTHArray[i], etiquetaFibraArray[i], cicloFacturacionArray[i], tiempoCreacionLineaArray[i], direccionClienteArray[i], estadoDireccionArray[i], tecnologiaAMigrarArray[i], etiquetaSaltoCeroArray[i]));
                                generarExcel(folderPath, excelName, sheetName);
                                generarExcelBitacora(folderPathBitacora, excelNameBitacora, sheetNameBitacora);
                            }
                        } else {
                            contarErrorDoc++;
                            System.out.println("DOCUMENTOS ERROR: " + contarErrorDoc);
                            clienteDataList.clear();
                            clienteDataList.add(new ClienteData(TIPO_DOCUMENTO, NUMERO_DOCUMENTO));
                            generarExcelError(folderPath, excelName, sheetNameError);
                            for (int i = 0; i < numeroLineaArray.length; i++) {
                                // INSERTAR DATOS
                                clienteDataList.clear();
                                clienteDataList.add(new ClienteData(TIPO_DOCUMENTO, NUMERO_DOCUMENTO, numeroLineaArray[i]));
                                generarExcelBitacora(folderPathBitacora, excelNameBitacora, sheetNameBitacora);
                            }
                            System.out.println("SE REGRESA AL INICIO");
                            action.sendKeys(Keys.ESCAPE).build().perform();
                            driver().navigate().refresh();
                            System.out.println("REFRESCO LA PAGINA");
                            barraCargando();
                            System.out.println("PASO LA VALIDACION DE BARRA CARGANDO N°1");
                            action.sendKeys(Keys.ESCAPE).build().perform();
                            barraCargando();
                            System.out.println("PASO LA VALIDACION DE BARRA CARGANDO N°2");
                            click(btnInicio,15);
                            clickBtnReintentar();
                            UtilWeb.waitForSeconds(1);
                            Zoom(65);
                            estado = "ERROR";
                        }
                        tipoPlanCliente.clear();
                        numeroDelPlan.clear();
                        nombreDelPlan.clear();
                        tipoPlanContratado.clear();
                        componentesPlanContratado.clear();
                        estadoDelPlan.clear();
                        deudaDelPlan.clear();
                        cantidadDeudaDelPlan.clear();
                        iptvPlan.clear();
                        ordenVueloPlan.clear();
                        tecnologiaPlan.clear();
                        velocidadPlan.clear();
                        cuentaConSVAPlan.clear();
                        direccionMigrarFTTH.clear();
                        etiquetaFibra.clear();
                        cicloFacturacion.clear();
                        tiempoCreacionLinea.clear();
                        direccionCliente.clear();
                        estadoDireccion.clear();
                        tecnologiaAMigrar.clear();
                        etiquetaSaltoCero.clear();

                        totalElementosPorArray.clear();
                        resultadoList.clear();

                        System.out.println("############################################");
                        System.out.println("INGRESO A INSERTAR VALOR A LA COLUMNA ESTADO");
                        // ESCRIBE EN LA COLUMNA C
                        estadoCell = row.createCell(2);

                        if (estado.equals("EXITOSO")) {
                            System.out.println("ESTADO PROCESO ES EXITOSO");
                            estadoCell.setCellValue("EXITOSO");
                        } else {
                            System.out.println("ESTADO PROCESO ES FALLIDO");
                            estadoCell.setCellValue("FALLIDO");
                        }
                        System.out.println("############################################");

                        // Escribir los cambios al archivo
                        try (FileOutputStream outFile = new FileOutputStream(pathWhiteList)){
                            workbook.write(outFile);
                            System.out.println("Se han guardado los cambios en el archivo Excel.");
                        }
                    }
                }
            }

            workbook.close(); // Cerrar el Workbook

        } catch (IOException e) {
            e.printStackTrace();
        }
        imprimirReporte();
    }

    public void imprimirReporte() {
        String[] tipoDocumentoListArray = tipoDocuemtoList.toArray(new String[0]);
        String[] numeroDocumentoListArray = numeroDocumentoList.toArray(new String[0]);
        String[] nombreClienteListArray = nombreClienteList.toArray(new String[0]);
        String[] tipoPlanClienteListArray = tipoPlanClienteList.toArray(new String[0]);
        String[] numeroLineaListArray = numeroLineaList.toArray(new String[0]);
        String[] nombrePlanListArray = nombrePlanList.toArray(new String[0]);
        String[] tipoPlanContratadoListArray = tipoPlanContratadoList.toArray(new String[0]);
        String[] componentesPlanContratadoArray = componentesPlanContratadoList.toArray(new String[0]);
        String[] estadoPlanListArray = estadoPlanList.toArray(new String[0]);
        String[] deudaClienteListArray = deudaClienteList.toArray(new String[0]);
        String[] cantidadDeudaListArray = cantidadDeudaList.toArray(new String[0]);
        String[] planIPTVListArray = planIPTVList.toArray(new String[0]);
        String[] ordenEnVueloListArray = ordenEnVueloList.toArray(new String[0]);
        String[] tecnologiaPlanListArray = tecnologiaPlanList.toArray(new String[0]);
        String[] velocidadPlanListArray = velocidadPlanList.toArray(new String[0]);
        String[] cuentaConSVAPlanListArray = cuentaConSVAPlanList.toArray(new String[0]);
        String[] direccionMigrarFTTHListArray = direccionMigrarFTTHList.toArray(new String[0]);
        String[] etiquetaFibraListArray = etiquetaFibraList.toArray(new String[0]);
        String[] cicloFacturacionListArray = cicloFacturacionList.toArray(new String[0]);
        String[] tiempoCreacionLineaListArray = tiempoCreacionLineaList.toArray(new String[0]);
        String[] direccionClienteListArray = direccionClienteList.toArray(new String[0]);
        String[] estadoDireccionListArray = estadoDireccionList.toArray(new String[0]);
        String[] tecnologiaAMigrarListArray = tecnologiaAMigrarList.toArray(new String[0]);
        String[] etiquetaSaltoCeroListArray = etiquetaSaltoCeroList.toArray(new String[0]);
        verlistas(tipoDocuemtoList,tipoDocumentoListArray,"TIPO DOCUMENTO");
        verlistas(numeroDocumentoList,numeroDocumentoListArray,"NUMERO DOCUMENTO");
        verlistas(nombreClienteList,nombreClienteListArray,"NOMBRE CLIENTE");
        verlistas(tipoPlanClienteList,tipoPlanClienteListArray,"TIPO PLAN DEL CLIENTE");
        verlistas(numeroLineaList,numeroLineaListArray,"NUMERO DE LINEA");
        verlistas(nombrePlanList,nombrePlanListArray,"NOMBRE PLAN");
        verlistas(tipoPlanContratadoList,tipoPlanContratadoListArray,"TIPO PLAN");
        verlistas(componentesPlanContratadoList,componentesPlanContratadoArray,"COMPONETES PLAN");
        verlistas(estadoPlanList,estadoPlanListArray,"ESTADO DE PLAN");
        verlistas(deudaClienteList,deudaClienteListArray,"ESTADO DEUDA");
        verlistas(cantidadDeudaList,cantidadDeudaListArray,"CANTIDAD DE DEUDA");
        verlistas(planIPTVList,planIPTVListArray,"PLAN IPTV");
        verlistas(ordenEnVueloList,ordenEnVueloListArray,"ORDEN EN VUELO");
        verlistas(tecnologiaPlanList, tecnologiaPlanListArray, "VER TIPO TECNOLOGIA DE RED");
        verlistas(velocidadPlanList, velocidadPlanListArray, "VER VELOCIDAD DE RED");
        verlistas(cuentaConSVAPlanList, cuentaConSVAPlanListArray, "VER SI CUENTA CON SVA");
        verlistas(direccionMigrarFTTHList, direccionMigrarFTTHListArray, "VER SI PUEDE MIGRAR A FIBRA");
        verlistas(etiquetaFibraList, etiquetaFibraListArray, "VER SI TIENE ETIQUETA FIBRA");
        verlistas(cicloFacturacionList, cicloFacturacionListArray, "VER CICLOS DE FACTURACION");
        verlistas(tiempoCreacionLineaList, tiempoCreacionLineaListArray, "VER ANTIGUEDAD DE LINEA");
        verlistas(direccionClienteList, direccionClienteListArray, "VER DIRECCION DEL CLIENTE");
        verlistas(estadoDireccionList, estadoDireccionListArray, "VER ESTADO DIRECCION");
        verlistas(tecnologiaAMigrarList, tecnologiaAMigrarListArray, "VER TECNOLOGIA A MIGRAR");
        verlistas(etiquetaSaltoCeroList, etiquetaSaltoCeroListArray, "VER SI TIENE SALTO 0");
        System.out.println("La longitud para el reporte es: " + ordenEnVueloListArray.length);
        System.out.println("TIPO DOCUMENTO, NUMERO DOCUMENTO, NOMBRE CLIENTE, TIPO PLAN DEL CLIENTE, NUMERO DE LINEA, NOMBRE PLAN, TIPO PLAN, COMPONENTES PLAN, ESTADO DE PLAN, ESTADO DEUDA, CANTIDAD DE DEUDA, PLAN IPTV, ORDEN EN VUELO, TECNOLOGIA DEL PLAN, VELOCIDAD RED PLAN, SVA, DIRECCION A FIBRA, VER SI TIENE ETIQUETA FIBRA, CICLO DE FACTURACION");
        for (int i = 0; i < ordenEnVueloListArray.length; i++) {
            System.out.println(tipoDocumentoListArray[i] + ", " + numeroDocumentoListArray[i] + ", " + nombreClienteListArray[i] + ", " + tipoPlanClienteListArray[i] + ", " + numeroLineaListArray[i] + ", " + nombrePlanListArray[i] + ", " + tipoPlanContratadoListArray[i] + ", " + componentesPlanContratadoArray[i] + ", " + estadoPlanListArray[i] + ", " + deudaClienteListArray[i] + ", " + cantidadDeudaListArray[i] + ", " + planIPTVListArray[i] + ", " + ordenEnVueloListArray[i] + ", " + tecnologiaPlanListArray[i] + ", " + velocidadPlanListArray[i] + ", " + cuentaConSVAPlanListArray[i] + ", " + direccionMigrarFTTHListArray[i] + ", " + etiquetaFibraListArray[i] + ", " + cicloFacturacionListArray[i] + ", " + tiempoCreacionLineaListArray[i] + ", " + direccionClienteListArray[i] + ", " + estadoDireccionListArray[i] + ", " + tecnologiaAMigrarListArray[i] + ", " + etiquetaSaltoCeroListArray[i]);
        }
    }

    public void verlistas(List<String> list, String[] array, String nameLista) {
        System.out.println("*********************************");
        System.out.println("Lista del - " + nameLista);
        System.out.println("Contenido Lista: " + list);
        System.out.println("Cantidad de elementos en el array: " + array.length);
        System.out.println("*********************************");
    }

    public void verlistasInt(List<Integer> list, Integer[] array, String nameLista) {
        System.out.println("*********************************");
        System.out.println("Lista del - " + nameLista);
        System.out.println("Contenido Lista: " + list);
        System.out.println("Cantidad de elementos en el array: " + array.length);
        System.out.println("*********************************");
    }

    public void tipoPlanDelCliente(int elementos) {
        cargarMsgLog(Level.INFO,"Cantidad de elementos para tipo de plan cliente es: " + elementos);
        String[] tipoPlanContratadoArray = tipoPlanContratado.toArray(new String[0]);
        int largo = tipoPlanContratadoArray.length;
        for (int i = 0; i < largo; i++) {
            String nombrePlan = tipoPlanContratadoArray[i];
            switch (nombrePlan.trim()) {
                case "Trio": case "Duo TV Fijo": case "Duo Internet Fijo": case "Duo TV Internet": case "Internet": case "TV": case "Fijo":
                    TIPO_PLAN_DEL_CLIENTE = "FIJO";
                    tipoPlanCliente.add(TIPO_PLAN_DEL_CLIENTE);
                    break;
                case "Movistar Total Trío": case "Movistar Total Dúo Internet": case "Movistar Total Dúo Internet + TV": case "Movistar Total Mono Internet":
                    TIPO_PLAN_DEL_CLIENTE = "MT";
                    tipoPlanCliente.add(TIPO_PLAN_DEL_CLIENTE);
                    break;
                case "Postpago": case "Prepago": case "Preplan":
                    TIPO_PLAN_DEL_CLIENTE = "MOVIL";
                    tipoPlanCliente.add(TIPO_PLAN_DEL_CLIENTE);
                    break;
                case "Postpago - MT":
                    TIPO_PLAN_DEL_CLIENTE = "MOVIL - MT";
                    tipoPlanCliente.add(TIPO_PLAN_DEL_CLIENTE);
                    break;
                default:
                    cargarMsgLog(Level.INFO,"Tipo Plan No definido para el plan: " + nombrePlan.trim());
                    break;
            }
        }
    }

    public void sacarNumeroPlan() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Numero Plan Hogar y Moviles");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                int cantidadHogar = listaLineasHogarYMovil.size();
                for (int i = 1; i <= cantidadHogar; i++) {
                    WebElement numeroPlan = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'])["+i+"]");
                    NUM_LINEA = numeroPlan.getText();
                    cargarMsgLog(Level.INFO,"El numero del Plan es: " + NUM_LINEA);
                    numeroDelPlan.add(NUM_LINEA);
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Numero Plan Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                for (int i = 1; i <= cantidadMT; i++) {
                    WebElement numeroPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero'])["+i+"]");
                    NUM_LINEA = numeroPlanMT.getText();
                    cargarMsgLog(Level.INFO,"El numero del Plan MT es: " + NUM_LINEA);
                    numeroDelPlan.add(NUM_LINEA);
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void sacarNombrePlanCliente() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Nombre Planes Hogar y Moviles");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                int cantidadHogar = listaLineasHogarYMovil.size();
                for (int i = 1; i <= cantidadHogar; i++) {
                    WebElement numeroPlan = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'])["+i+"]");
                    String NumeroPlan = numeroPlan.getText();
                    cargarMsgLog(Level.INFO,"El subtring del numero del Plan es: " + NumeroPlan.substring(0, 1));
                    try {
                        if (!NumeroPlan.substring(0, 1).equals("9")) {
                            WebElement btnVerDetalle = find().getElementByXPath("(//*[@class='container']/*[@class='detailHogar']/*)["+i+"]");
                            js().scrollElementTop(btnVerDetalle);
                            UtilWeb.waitForSeconds(1);
                            click(btnVerDetalle,5);
                            barraCargando();
                            UtilWeb.waitForSeconds(5);
                            try {
                                click(btnContinuarVerDetalle);
                            } catch (Exception e) {
                                cargarMsgLog(Level.INFO,"Se continua sin mostrar boton continuar");
                            }
                            NOMBRE_PLAN = nombrePlanHogar.getText();
                            CICLO_FACTURACION = cicloFacturacionFija.getText();
                            click(cerrarVentanaDetalle,10);
                            try {
                                if (cicloFacturacionFija.isDisplayed()) {
                                    action.sendKeys(Keys.ESCAPE).build().perform();
                                }
                            } catch (Exception e1) {
                                cargarMsgLog(Level.INFO,"Se cerro ventana");
                            }
                            UtilWeb.waitForSeconds(2);
                            nombreDelPlan.add(NOMBRE_PLAN);
                            cicloFacturacion.add(CICLO_FACTURACION);
                            tiempoCreacionLinea.add("VALIDAR POR CRM");
                            cargarMsgLog(Level.INFO,"Cantidad Ingresada No Movil es: " + i);
                        } else {
                            cargarMsgLog(Level.INFO,"Ingreso a sacar nombre plan de lineas moviles");
                            UtilWeb.waitForSeconds(1);
                            i = cantidadHogar;
                            int cantidadPlanesMovil = listaNombrePlanMovil.size();
                            int k = i - cantidadPlanesMovil;
                            System.out.println("K: " + k);
                            for (int j = 1; j <= cantidadPlanesMovil; j++) {
                                k++;
                                cargarMsgLog(Level.INFO,"Cantidad Ingresada Movil es: " + j);
                                WebElement nombrePlanMovil = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex description']/*[@class='plan'])["+j+"]");
                                WebElement btnVerDetalle = find().getElementByXPath("(//*[@class='container']/*[@class='detailHogar']/*)["+k+"]");
                                js().scrollElementTop(btnVerDetalle);
                                UtilWeb.waitForSeconds(1);
                                click(btnVerDetalle,5);
                                barraCargando();
                                UtilWeb.waitForSeconds(5);
                                try {
                                    click(btnContinuarVerDetalle);
                                } catch (Exception e) {
                                    cargarMsgLog(Level.INFO,"Se continua sin mostrar boton continuar");
                                }
                                NOMBRE_PLAN = nombrePlanMovil.getText();
                                CICLO_FACTURACION = cicloFacturacionMovil.getText();
                                ANTIGUEDAD_DATA = antiguedadLineaMovil.getText();
                                click(cerrarVentanaDetalleMovil,10);
                                try {
                                    if (cicloFacturacionMovil.isDisplayed()) {
                                        action.sendKeys(Keys.ESCAPE).build().perform();
                                    }
                                } catch (Exception e1) {
                                    cargarMsgLog(Level.INFO,"Se cerro ventana");
                                }
                                UtilWeb.waitForSeconds(2);
                                System.out.println("Ciclo Movil: " + cicloFacturacionMovil.getText());
                                System.out.println("Antiguedad DAta: " + ANTIGUEDAD_DATA);
                                nombreDelPlan.add(NOMBRE_PLAN);
                                cicloFacturacion.add(CICLO_FACTURACION);
                                tiempoCreacionLinea.add(ANTIGUEDAD_DATA);
                            }
                        }
                    } catch (Exception e) {
                        cargarMsgLog(Level.INFO,"Error en sacarNombrePlanCliente");
                        String text = "NO CARGO DETELLA PLAN";
                        if (!NumeroPlan.substring(0, 1).equals("9")) {
                            nombreDelPlan.add(text);
                            cicloFacturacion.add(text);
                            tiempoCreacionLinea.add("VALIDAR POR CRM");
                        } else {
                            nombreDelPlan.add(text);
                            cicloFacturacion.add(text);
                            tiempoCreacionLinea.add(text);
                        }
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Nombre Planes Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                int cantidadLineaMovilMT = 0;
                int cantidadLineaHogarMT;
                for (int i = 1; i <= cantidadMT; i++) {
                    WebElement numeroPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero'])[" + i + "]");
                    String NumeroPlan = numeroPlanMT.getText();
                    if (NumeroPlan.substring(0, 1).equals("9")) {
                        cantidadLineaMovilMT++;
                    }
                }
                System.out.println("CANTIDAD MOVIL MT: " + cantidadLineaMovilMT);
                cantidadLineaHogarMT = cantidadMT - cantidadLineaMovilMT;
                System.out.println("CANTIDAD LINEA HOGAR MT ES: " + cantidadLineaHogarMT);
                if (cantidadLineaHogarMT == 1) {
                    for (int i = 1; i <= cantidadMT; i++) {
                        WebElement numeroPlan = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero'])["+i+"]");
                        String NumeroPlan = numeroPlan.getText();
                        cargarMsgLog(Level.INFO,"El subtring del numero del Plan es: " + NumeroPlan.substring(0,1));
                        try {
                            WebElement nombrePlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='palnMT'])["+i+"]");
                            System.out.println(nombrePlanMT.getText());
                            NOMBRE_PLAN = nombrePlanMT.getText();
                            nombreDelPlan.add(NOMBRE_PLAN);
                        } catch (Exception e) {
                            cargarMsgLog(Level.INFO,"No se considera sacar el nombre del plan de la linea movil MT");
                        }
                    }
                    js().scrollElementTop(btnVerDetalleMT);
                    UtilWeb.waitForSeconds(1);
                    click(btnVerDetalleMT,5);
                    barraCargando();
                    UtilWeb.waitForSeconds(5);
                    int j = 1;
                    for (int i = 1; i <= cantidadMT; i++) {
                        WebElement numeroPlan = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero'])["+i+"]");
                        String NumeroPlan = numeroPlan.getText();
                        cargarMsgLog(Level.INFO,"El subtring del numero del Plan es: " + NumeroPlan.substring(0,1));
                        if (!NumeroPlan.substring(0, 1).equals("9")) {
                            click(btnDetalleFijaMT,5);
                            if (cantidadLineaMovilMT == 2) {
                                CICLO_FACTURACION = textCicloMTFija2.getText();
                            } else {
                                CICLO_FACTURACION = textCicloMTFija.getText();
                            }
                            cicloFacturacion.add(CICLO_FACTURACION);
                            tiempoCreacionLinea.add("MT VALIDAR POR CRM");
                        } else {
                            if (cantidadLineaMovilMT == 2) {
                                WebElement lineaMovil = find().getElementByXPath("(//*[contains(@class, 'icon-celular') and contains(@class, 'iconos')])["+j+"]");
                                click(lineaMovil,5);
                                CICLO_FACTURACION = textCicloMTMovil2.getText();
                                cicloFacturacion.add(CICLO_FACTURACION);
                                String antiguedadLineaMTMovil = antiguedadLineaMovilMT2.getText();
                                tiempoCreacionLinea.add(antiguedadLineaMTMovil);
                                j++;
                            } else {
                                click(btnDetalleMovilMT,5);
                                CICLO_FACTURACION = textCicloMTMovil.getText();
                                cicloFacturacion.add(CICLO_FACTURACION);
                                String antiguedadLineaMTMovil = antiguedadLineaMovilMT.getText();
                                tiempoCreacionLinea.add(antiguedadLineaMTMovil);
                            }
                        }
                    }
                    if (cantidadLineaMovilMT == 2) {
                        System.out.println("INGRESO A CERRAR VENTANA DETALLE MT");
                        click(cerrarVentanaDetalleMT2,10);
                    } else {
                        System.out.println("INGRESO A CERRAR VENTANA DETALLE MT");
                        click(cerrarVentanaDetalleMT,10);
                    }
                    try {
                        if (textCicloMTMovil.isDisplayed() || textCicloMTMovil2.isDisplayed()) {
                            action.sendKeys(Keys.ESCAPE).build().perform();
                        }
                    } catch (Exception e1) {
                        cargarMsgLog(Level.INFO,"Se cerro ventana Detalle MT");
                    }
                    UtilWeb.waitForSeconds(2);
                } else {
                    for (int i = 1; i <= cantidadMT; i++) {
                        try {
                            WebElement nombrePlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='palnMT'])["+i+"]");
                            System.out.println(nombrePlanMT.getText());
                            NOMBRE_PLAN = nombrePlanMT.getText();
                            nombreDelPlan.add(NOMBRE_PLAN);
                            CICLO_FACTURACION = "MT por CRM";
                            cicloFacturacion.add(CICLO_FACTURACION);
                            tiempoCreacionLinea.add("MT VALIDAR POR CRM");
                        } catch (Exception e) {
                            cargarMsgLog(Level.INFO,"No se considera sacar el nombre del plan de la linea movil MT");
                        }
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void tipoPlan() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Componentes Plan Hogar y Moviles");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                int cantidadHogar = listaLineasHogarYMovil.size();
                for (int i = 1; i <= cantidadHogar; i++) {
                    WebElement numeroPlan = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'])["+i+"]");
                    String NumeroPlan = numeroPlan.getText();
                    cargarMsgLog(Level.INFO,"El subtring del numero del Plan es: " + NumeroPlan.substring(0, 1));
                    try {
                        if (!NumeroPlan.substring(0, 1).equals("9")) {
                            WebElement componentesPlanHogarYMovil = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex footer-card']/span[string-length(normalize-space()) > 0])["+i+"]");
                            String componentes = componentesPlanHogarYMovil.getText();
                            cargarMsgLog(Level.INFO,"TIPO PLAN CONTRATADO Movil o Hogar es: " + componentes);
                            switch (componentes.trim()) {
                                case "Voice+Internet+TV":
                                    TIPO_PLAN = "Trio";
                                    cargarMsgLog(Level.INFO,"Nombre del Plan Movil o Hogar es: " + TIPO_PLAN);
                                    tipoPlanContratado.add(TIPO_PLAN);
                                    componentesPlanContratado.add(componentes.trim());
                                    break;
                                case "Voice+TV":
                                    TIPO_PLAN = "Duo TV Fijo";
                                    cargarMsgLog(Level.INFO,"Nombre del Plan Movil o Hogar es: " + TIPO_PLAN);
                                    tipoPlanContratado.add(TIPO_PLAN);
                                    componentesPlanContratado.add(componentes.trim());
                                    break;
                                case "Voice+Internet":
                                    TIPO_PLAN = "Duo Internet Fijo";
                                    cargarMsgLog(Level.INFO,"Nombre del Plan Movil o Hogar es: " + TIPO_PLAN);
                                    tipoPlanContratado.add(TIPO_PLAN);
                                    componentesPlanContratado.add(componentes.trim());
                                    break;
                                case "TV+Internet":
                                    TIPO_PLAN = "Duo TV Internet";
                                    cargarMsgLog(Level.INFO,"Nombre del Plan Movil o Hogar es: " + TIPO_PLAN);
                                    tipoPlanContratado.add(TIPO_PLAN);
                                    componentesPlanContratado.add(componentes.trim());
                                    break;
                                case "Internet":
                                    TIPO_PLAN = "Internet";
                                    cargarMsgLog(Level.INFO,"Nombre del Plan Movil o Hogar es: " + TIPO_PLAN);
                                    tipoPlanContratado.add(TIPO_PLAN);
                                    componentesPlanContratado.add(componentes.trim());
                                    break;
                                case "TV":
                                    TIPO_PLAN = "TV";
                                    cargarMsgLog(Level.INFO,"Nombre del Plan Movil o Hogar es: " + TIPO_PLAN);
                                    tipoPlanContratado.add(TIPO_PLAN);
                                    componentesPlanContratado.add(componentes.trim());
                                    break;
                                case "Voice":
                                    TIPO_PLAN = "Fijo";
                                    cargarMsgLog(Level.INFO,"Nombre del Plan Movil o Hogar es: " + TIPO_PLAN);
                                    tipoPlanContratado.add(TIPO_PLAN);
                                    componentesPlanContratado.add(componentes.trim());
                                    break;
                                default:
                                    cargarMsgLog(Level.INFO,"Plan con componentes - '" + componentes + "' - no definido");
                                    break;
                            }
                        } else {
                            cargarMsgLog(Level.INFO,"Ingreso a sacar nombre plan de lineas moviles");
                            UtilWeb.waitForSeconds(1);
                            int k = i;
                            i = cantidadHogar;
                            int cantidadPlanesMovil = listaNombrePlanMovil.size();
                            for (int j = 1; j <= cantidadPlanesMovil; j++) {
                                cargarMsgLog(Level.INFO,"Cantidad Ingresada Movil es: " + j);
                                WebElement nombrePlanMovil = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex description']/*[@class='plan'])["+j+"]");
                                WebElement componentesPlanHogarYMovil = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex footer-card']/span[string-length(normalize-space()) > 0])["+k+"]");
                                String componentes = componentesPlanHogarYMovil.getText();
                                String nombrePlanM = nombrePlanMovil.getText();
                                k++;
                                switch (nombrePlanM.trim()) {
                                    case "Plan Prepago con Tarifa Única":
                                        TIPO_PLAN = "Prepago";
                                        cargarMsgLog(Level.INFO,"Nombre del Plan Movil es: " + TIPO_PLAN);
                                        tipoPlanContratado.add(TIPO_PLAN);
                                        componentesPlanContratado.add(componentes.trim());
                                        break;
                                    case "Preplan":
                                        TIPO_PLAN = "Preplan";
                                        cargarMsgLog(Level.INFO,"Nombre del Plan Movil es: " + TIPO_PLAN);
                                        tipoPlanContratado.add(TIPO_PLAN);
                                        componentesPlanContratado.add(componentes.trim());
                                        break;
                                    default:
                                        int existeNombre;
                                        existeNombre = nombrePlanM.trim().indexOf("Preplan");
                                        if (existeNombre != -1) {
                                            TIPO_PLAN = "Preplan";
                                            cargarMsgLog(Level.INFO,"Nombre del Plan Movil - '"+ nombrePlanM.trim() + "' - es: " + TIPO_PLAN);
                                            tipoPlanContratado.add(TIPO_PLAN);
                                            componentesPlanContratado.add(componentes.trim());
                                        } else {
                                            TIPO_PLAN = "Postpago";
                                            cargarMsgLog(Level.INFO,"Nombre del Plan Movil - '"+ nombrePlanM.trim() + "' - es: " + TIPO_PLAN);
                                            tipoPlanContratado.add(TIPO_PLAN);
                                            componentesPlanContratado.add(componentes.trim());
                                        }
                                        break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        cargarMsgLog(Level.INFO,"No es numero Movil");
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Componentes Plan Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                for (int i = 1; i <= cantidadMT; i++) {
                    WebElement componentesPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='div-info']/span[string-length(normalize-space()) > 0])["+i+"]");
                    String componentesMT = componentesPlanMT.getText();
                    switch (componentesMT.trim()) {
                        case "Voice+Internet+TV":
                            TIPO_PLAN = "Movistar Total Trío";
                            cargarMsgLog(Level.INFO,"Nombre del Plan es: " + TIPO_PLAN);
                            tipoPlanContratado.add(TIPO_PLAN);
                            componentesPlanContratado.add(componentesMT.trim());
                            break;
                        case "Voice+Internet":
                            TIPO_PLAN = "Movistar Total Dúo Internet";
                            cargarMsgLog(Level.INFO,"Nombre del Plan es: " + TIPO_PLAN);
                            tipoPlanContratado.add(TIPO_PLAN);
                            componentesPlanContratado.add(componentesMT.trim());
                            break;
                        case "TV+Internet":
                            TIPO_PLAN = "Movistar Total Dúo Internet + TV";
                            cargarMsgLog(Level.INFO,"Nombre del Plan es: " + TIPO_PLAN);
                            tipoPlanContratado.add(TIPO_PLAN);
                            componentesPlanContratado.add(componentesMT.trim());
                            break;
                        case "Internet":
                            TIPO_PLAN = "Movistar Total Mono Internet";
                            cargarMsgLog(Level.INFO,"Nombre del Plan es: " + TIPO_PLAN);
                            tipoPlanContratado.add(TIPO_PLAN);
                            componentesPlanContratado.add(componentesMT.trim());
                            break;
                        default:
                            TIPO_PLAN = "Postpago - MT";
                            cargarMsgLog(Level.INFO,"Nombre del Plan Movil MT - '"+ componentesMT.trim() + "' - es: " + TIPO_PLAN);
                            tipoPlanContratado.add(TIPO_PLAN);;
                            componentesPlanContratado.add(componentesMT.trim());
                            break;
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void estadoPlan() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Estado Plan Hogar y Moviles");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                int cantidadHogar = listaLineasHogarYMovil.size();
                for (int i = 1; i <= cantidadHogar; i++) {
                    WebElement estadoPlanHogarYMovil = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex footer-card']/*/*[@class='stl_plan'])["+i+"]");
                    ESTADO_PLAN = estadoPlanHogarYMovil.getText();
                    cargarMsgLog(Level.INFO,"El estado del Plan Movil o Hogar es: " + ESTADO_PLAN);
                    estadoDelPlan.add(ESTADO_PLAN);
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Estado Plan Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                for (int i = 1; i <= cantidadMT; i++) {
                    WebElement estadoPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='div-info']/*/*[@class='stl_plan'])["+i+"]");
                    ESTADO_PLAN = estadoPlanMT.getText();
                    cargarMsgLog(Level.INFO,"El estado del Plan es: " + ESTADO_PLAN);
                    estadoDelPlan.add(ESTADO_PLAN);
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void verSiTieneDeuda() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Deudas Plan Hogar y Moviles");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                cargarMsgLog(Level.INFO,"Ingreso a visualizar Deudas Plan Hogar");
                int cantidadHogar = listaLineasHogar.size();
                System.out.println("Cantidad Lines Hogar - verSiTieneDeuda: " + cantidadHogar);
                for (int i = 1; i <= cantidadHogar; i++) {
                    try {
                        int cont = 0;
                        while (cont < 3) {
                            try {
                                WebElement btnReintentarDeudas = find().getElementByXPath("(//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='btn-try-again' and contains(text(), 'Reintentar')])["+i+"]");
                                cont++;
                                if (btnReintentarDeudas.isDisplayed()) {
                                    System.out.println("**************************");
                                    System.out.println("Boton Reintentar Cargar Deuda Hogar: " + cont);
                                    System.out.println("**************************");
                                    click(btnReintentarDeudas,5);
                                    UtilWeb.waitForSeconds(4);
                                    try {
                                        if (cont == 3) {
                                            DEUDA = "No cargo Deuda";
                                            deudaDelPlan.add(DEUDA);
                                        }
                                    } catch (Exception e ) {
                                        cargarMsgLog(Level.INFO,"Se sigue visualizando el boton reintentar de Deudas - N°" + cont);
                                    }
                                }
                            } catch (Exception e) {
                                cont = 3;
                                int resto = cantidadHogar - cantReintentarDeudas.size();
                                System.out.println("Resto: " + resto);
                                int k = cantidadHogar - resto;
                                System.out.println("K - verSiTieneDeuda - vale: " + k + " N° i vale: " + i);
                                i = cantidadHogar;
                                for (int j = 1; j <= resto; j++) {
                                    cargarMsgLog(Level.INFO,"Ingreso a ver si hay deuda despues de cargar el estado deuda");
                                    WebElement deudaPlanHogarYMovil = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='content']/*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+j+"]");
                                    String estadoDeuda = deudaPlanHogarYMovil.getText();
                                    cargarMsgLog(Level.INFO,"Estado Plan Hogar es: " + estadoDeuda);
                                    int existeNombre;
                                    existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                                    if (existeNombre != -1) {
                                        DEUDA = "Sin Deuda";
                                        deudaDelPlan.add(DEUDA);
                                    } else {
                                        DEUDA = "Con Deuda";
                                        deudaDelPlan.add(DEUDA);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        cargarMsgLog(Level.INFO,"No se detecto boton Cargar para ver deudas Lineas No MT");
                        WebElement deudaPlanHogar = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='content']/*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+i+"]");
                        String estadoDeuda = deudaPlanHogar.getText();
                        cargarMsgLog(Level.INFO,"Estado Plan Hogar es: " + estadoDeuda);
                        int existeNombre;
                        existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                        if (existeNombre != -1) {
                            DEUDA = "Sin Deuda";
                            deudaDelPlan.add(DEUDA);
                        } else {
                            DEUDA = "Con Deuda";
                            deudaDelPlan.add(DEUDA);
                        }
                    }
                }
                cargarMsgLog(Level.INFO,"Ingreso a visualizar Deudas Plan Movil");
                int cantidadMovil = listaLineasMovil.size();
                for (int i = 1; i <= cantidadMovil; i++) {
                    try {
                        int cont = 0;
                        while (cont < 3) {
                            try {
                                WebElement btnReintentarDeudas = find().getElementByXPath("((//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*/*[@class='btn-try-again' and contains(text(), 'Reintentar')] | (//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*/*[@class='button-light-green' and contains(text(), 'Reintentar')])["+i+"]");
                                cont++;
                                if (btnReintentarDeudas.isDisplayed()) {
                                    System.out.println("**************************");
                                    System.out.println("Boton Reintentar Cargar Deuda Movil: " + cont);
                                    System.out.println("**************************");
                                    click(btnReintentarDeudas,5);
                                    UtilWeb.waitForSeconds(4);
                                    try {
                                        if (cont == 3) {
                                            DEUDA = "No cargo Deuda";
                                            deudaDelPlan.add(DEUDA);
                                        }
                                    } catch (Exception e ) {
                                        cargarMsgLog(Level.INFO,"Se sigue visualizando el boton reintentar de Deudas - N°" + cont);
                                    }
                                }
                            } catch (Exception e) {
                                cont = 3;
                                WebElement deudaPlanMovil = find().getElementByXPath("((//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_deuda'] | (//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'])["+i+"]");
                                String estadoDeuda = deudaPlanMovil.getText();
                                cargarMsgLog(Level.INFO,"La deuda del Plan Movil es: " + estadoDeuda);
                                int existeNombre;
                                existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                                if (existeNombre != -1) {
                                    DEUDA = "Sin Deuda";
                                    deudaDelPlan.add(DEUDA);
                                } else {
                                    DEUDA = "Con Deuda";
                                    deudaDelPlan.add(DEUDA);
                                }
                            }
                        }
                    } catch (Exception e) {
                        cargarMsgLog(Level.INFO,"No se detecto boton Cargar para ver deudas Lineas No MT");
                        WebElement deudaPlanHogarYMovil = find().getElementByXPath("((//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_deuda'] | (//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'])["+i+"]");
                        String estadoDeuda = deudaPlanHogarYMovil.getText();
                        cargarMsgLog(Level.INFO,"La deuda del Plan Movil es: " + estadoDeuda);
                        int existeNombre;
                        existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                        if (existeNombre != -1) {
                            DEUDA = "Sin Deuda";
                            deudaDelPlan.add(DEUDA);
                        } else {
                            DEUDA = "Con Deuda";
                            deudaDelPlan.add(DEUDA);
                        }
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Deudas Plan Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                for (int i = 1; i <= cantidadMT; i++) {
                    try {
                        int cont = 0;
                        while (cont < 3) {
                            try {
                                WebElement btnReintentarDeudas = find().getElementByXPath("(//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='btn-try-again' and contains(text(), 'Reintentar')])["+i+"]");
                                cont++;
                                if (btnReintentarDeudas.isDisplayed()) {
                                    click(btnReintentarDeudas,5);
                                    UtilWeb.waitForSeconds(4);
                                    try {
                                        if (cont == 3) {
                                            DEUDA = "No cargo Deuda";
                                            deudaDelPlan.add(DEUDA);
                                        }
                                    } catch (Exception e ) {
                                        cargarMsgLog(Level.INFO,"Se sigue visualizando el boton reintentar de Deudas - N°" + cont);
                                    }
                                }
                            } catch (Exception e) {
                                cont = 3;
                                WebElement deudaPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+i+"]");
                                String estadoDeuda = deudaPlanMT.getText();
                                cargarMsgLog(Level.INFO,"La deuda del Plan MT es: " + estadoDeuda);
                                int existeNombre;
                                existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                                if (existeNombre != -1) {
                                    DEUDA = "Sin Deuda";
                                    deudaDelPlan.add(DEUDA);
                                } else {
                                    DEUDA = "Con Deuda";
                                    deudaDelPlan.add(DEUDA);
                                }
                            }
                        }
                    } catch (Exception e) {
                        cargarMsgLog(Level.INFO,"No se detecto boton Cargar para ver deudas para Lineas MTs");
                        try {
                            int j = i - 1;
                            WebElement btnReintentarDeudas = find().getElementByXPath("(//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='btn-try-again' and contains(text(), 'Reintentar')])["+j+"]");
                            if (btnReintentarDeudas.isDisplayed()) {
                                WebElement deudaPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+j+"]");
                                String estadoDeuda = deudaPlanMT.getText();
                                cargarMsgLog(Level.INFO,"La deuda del Plan MT es: " + estadoDeuda);
                                int existeNombre;
                                existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                                if (existeNombre != -1) {
                                    DEUDA = "Sin Deuda";
                                    deudaDelPlan.add(DEUDA);
                                } else {
                                    DEUDA = "Con Deuda";
                                    deudaDelPlan.add(DEUDA);
                                }
                            }
                        } catch (Exception e2) {
                            WebElement deudaPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+i+"]");
                            String estadoDeuda = deudaPlanMT.getText();
                            cargarMsgLog(Level.INFO,"La deuda del Plan MT es: " + estadoDeuda);
                            int existeNombre;
                            existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                            if (existeNombre != -1) {
                                DEUDA = "Sin Deuda";
                                deudaDelPlan.add(DEUDA);
                            } else {
                                DEUDA = "Con Deuda";
                                deudaDelPlan.add(DEUDA);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total - verSiTieneDeuda");
        }
    }

    public void cantidadDeuda() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Monto Plan Hogar y Moviles");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                cargarMsgLog(Level.INFO,"Ingreso a visualizar Monto Deudas Plan Hogar");
                int cantidadHogar = listaLineasHogar.size();
                for (int i = 1; i <= cantidadHogar; i++) {
                    try {
                        int cont = 0;
                        while (cont < 3) {
                            try {
                                WebElement btnReintentarDeudas = find().getElementByXPath("(//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='btn-try-again' and contains(text(), 'Reintentar')])["+i+"]");
                                cont++;
                                if (btnReintentarDeudas.isDisplayed()) {
                                    click(btnReintentarDeudas,5);
                                    UtilWeb.waitForSeconds(4);
                                    try {
                                        if (cont == 3) {
                                            CANTIDAD_DEUDA = "No se visualizo precio";
                                            cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                        }
                                    } catch (Exception e ) {
                                        cargarMsgLog(Level.INFO,"Se sigue visualizando el boton reintentar de Deudas - N°" + cont);
                                    }
                                }
                            } catch (Exception e) {
                                cont = 3;
                                int resto = cantidadHogar - cantReintentarDeudas.size();
                                System.out.println("Resto: " + resto);
                                int k = cantidadHogar - resto;
                                System.out.println("K - cantidadDeuda - vale: " + k + " N° i vale: " + i);
                                i = cantidadHogar;
                                for (int j = 1; j <= resto; j++) {
                                    WebElement deudaPlanHogarYMovil = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='content']/*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+j+"]");
                                    String estadoDeuda = deudaPlanHogarYMovil.getText();
                                    cargarMsgLog(Level.INFO,"La deuda del Plan Hogar es: " + estadoDeuda);
                                    int existeNombre;
                                    existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                                    if (existeNombre != -1) {
                                        CANTIDAD_DEUDA = "S/0";
                                        cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                    } else {
                                        int inicial = estadoDeuda.trim().indexOf("S/");
                                        CANTIDAD_DEUDA = estadoDeuda.trim().substring(inicial);
                                        cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        cargarMsgLog(Level.INFO,"No se detecto boton Cargar para ver deudas para cantidad de Deuda a Pagar");
                        WebElement deudaPlanHogarYMovil = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='content']/*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+i+"]");
                        String estadoDeuda = deudaPlanHogarYMovil.getText();
                        cargarMsgLog(Level.INFO,"La deuda del Plan Hogar es: " + estadoDeuda);
                        int existeNombre;
                        existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                        if (existeNombre != -1) {
                            CANTIDAD_DEUDA = "S/0";
                            cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                        } else {
                            int inicial = estadoDeuda.trim().indexOf("S/");
                            CANTIDAD_DEUDA = estadoDeuda.trim().substring(inicial);
                            cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                        }
                    }
                    System.out.println("**************************");
                }
                cargarMsgLog(Level.INFO,"Ingreso a visualizar Monto Deudas Plan Movil");
                int cantidadMovil = listaLineasMovil.size();
                for (int i = 1; i <= cantidadMovil; i++) {
                    try {
                        int cont = 0;
                        while (cont < 3) {
                            try {
                                WebElement btnReintentarDeudas = find().getElementByXPath("((//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*/*[@class='btn-try-again' and contains(text(), 'Reintentar')] | (//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*/*[@class='button-light-green' and contains(text(), 'Reintentar')])["+i+"]");
                                cont++;
                                if (btnReintentarDeudas.isDisplayed()) {
                                    click(btnReintentarDeudas,5);
                                    UtilWeb.waitForSeconds(4);
                                    try {
                                        if (cont == 3) {
                                            CANTIDAD_DEUDA = "No se visualizo precio";
                                            cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                        }
                                    } catch (Exception e ) {
                                        cargarMsgLog(Level.INFO,"Se sigue visualizando el boton reintentar de Deudas - N°" + cont);
                                    }
                                }
                            } catch (Exception e) {
                                cont = 3;
                                WebElement deudaPlanHogarYMovil = find().getElementByXPath("((//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_deuda'] | (//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'])["+i+"]");
                                String estadoDeuda = deudaPlanHogarYMovil.getText();
                                cargarMsgLog(Level.INFO,"La deuda del Plan Movil es: " + estadoDeuda);
                                int existeNombre;
                                existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                                if (existeNombre != -1) {
                                    CANTIDAD_DEUDA = "S/0";
                                    cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                } else {
                                    int inicial = estadoDeuda.trim().indexOf("S/");
                                    CANTIDAD_DEUDA = estadoDeuda.trim().substring(inicial);
                                    cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                }
                            }
                        }
                    } catch (Exception e) {
                        cargarMsgLog(Level.INFO,"No se detecto boton Cargar para ver deudas para cantidad de Deuda a Pagar");
                        WebElement deudaPlanHogarYMovil = find().getElementByXPath("((//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_deuda'] | (//*[@class='content']/*/*[@class='flex header']/*[@class='number_line' and starts-with(normalize-space(text()), '9')] | //*[@class='number_line' and starts-with(normalize-space(text()), '9')])/parent::*/parent::*/*[@class='flex footer-card']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'])["+i+"]");
                        String estadoDeuda = deudaPlanHogarYMovil.getText();
                        cargarMsgLog(Level.INFO,"La deuda del Plan Movil es: " + estadoDeuda);
                        int existeNombre;
                        existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                        if (existeNombre != -1) {
                            CANTIDAD_DEUDA = "S/0";
                            cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                        } else {
                            int inicial = estadoDeuda.trim().indexOf("S/");
                            CANTIDAD_DEUDA = estadoDeuda.trim().substring(inicial);
                            cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                        }
                    }
                    System.out.println("**************************");
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Monto Plan Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                for (int i = 1; i <= cantidadMT; i++) {
                    try {
                        int cont = 0;
                        while (cont < 3) {
                            try {
                                WebElement btnReintentarDeudas = find().getElementByXPath("(//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='btn-try-again' and contains(text(), 'Reintentar')])["+i+"]");
                                cont++;
                                if (btnReintentarDeudas.isDisplayed()) {
                                    click(btnReintentarDeudas,5);
                                    UtilWeb.waitForSeconds(4);
                                    System.out.println("**************************");
                                    System.out.println("Boton Reintentar Cargar Deuda - Ver Deuda: " + cont);
                                    System.out.println("**************************");
                                    try {
                                        if (cont == 3) {
                                            CANTIDAD_DEUDA = "No se visualizo precio";
                                            cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                        }
                                    } catch (Exception e ) {
                                        cargarMsgLog(Level.INFO,"Se sigue visualizando el boton reintentar de Deudas - N°" + cont);
                                    }
                                }
                            } catch (Exception e) {
                                cont = 3;
                                WebElement deudaPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+i+"]");
                                String estadoDeuda = deudaPlanMT.getText();
                                cargarMsgLog(Level.INFO,"La deuda del Plan MT es: " + estadoDeuda);
                                int existeNombre;
                                existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                                if (existeNombre != -1) {
                                    CANTIDAD_DEUDA = "S/0";
                                    cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                } else {
                                    int inicial = estadoDeuda.trim().indexOf("S/");
                                    CANTIDAD_DEUDA = estadoDeuda.trim().substring(inicial);
                                    cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                }
                            }
                        }
                    } catch (Exception e) {
                        try {
                            int j = i - 1;
                            WebElement btnReintentarDeudas = find().getElementByXPath("(//*[@class='button-light-green' and contains(text(), 'Reintentar')] | //*[@class='btn-try-again' and contains(text(), 'Reintentar')])["+j+"]");
                            if (btnReintentarDeudas.isDisplayed()) {
                                WebElement deudaPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+j+"]");
                                String estadoDeuda = deudaPlanMT.getText();
                                cargarMsgLog(Level.INFO,"La deuda del Plan MT es: " + estadoDeuda);
                                int existeNombre;
                                existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                                if (existeNombre != -1) {
                                    CANTIDAD_DEUDA = "S/0";
                                    cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                } else {
                                    int inicial = estadoDeuda.trim().indexOf("S/");
                                    CANTIDAD_DEUDA = estadoDeuda.trim().substring(inicial);
                                    cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                                }
                            }
                        } catch (Exception e2) {
                            WebElement deudaPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_sinDeuda'] | //*[@class='div-product-hogar']/*[@class='div-info']/*[@class='cls-deuda']/*[@class='stl_deuda'])["+i+"]");
                            String estadoDeuda = deudaPlanMT.getText();
                            cargarMsgLog(Level.INFO,"La deuda del Plan MT es: " + estadoDeuda);
                            int existeNombre;
                            existeNombre = estadoDeuda.trim().indexOf("Sin Deuda");
                            if (existeNombre != -1) {
                                CANTIDAD_DEUDA = "S/0";
                                cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                            } else {
                                int inicial = estadoDeuda.trim().indexOf("S/");
                                CANTIDAD_DEUDA = estadoDeuda.trim().substring(inicial);
                                cantidadDeudaDelPlan.add(CANTIDAD_DEUDA);
                            }
                        }
                    }
                    System.out.println("**************************");
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void verSiEsPlanIPTV() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar IPTV Plan Hogar y Moviles");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                int cantidadHogar = listaLineasHogarYMovil.size();
                for (int i = 1; i <= cantidadHogar; i++) {
                    try {
                        WebElement planIPTV = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'])["+i+"]/parent::*/*[@class='tdp-col-1']/*[@class='margin-icon']");
                        if (planIPTV.isDisplayed()) {
                            PLAN_IPTV = "SI IPTV";
                            cargarMsgLog(Level.INFO,"IPTV: " + PLAN_IPTV);
                            iptvPlan.add(PLAN_IPTV);
                        }
                    } catch (Exception e) {
                        PLAN_IPTV = "NO IPTV";
                        cargarMsgLog(Level.INFO,"IPTV: " + PLAN_IPTV);
                        iptvPlan.add(PLAN_IPTV);
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar IPTV Plan Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                for (int i = 1; i <= cantidadMT; i++) {
                    PLAN_IPTV = "NO IPTV";
                    cargarMsgLog(Level.INFO,"IPTV: " + PLAN_IPTV);
                    iptvPlan.add(PLAN_IPTV);
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void verSiTieneOrdenEnVuelo() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Orden en Vuelo Plan Hogar y Moviles");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                int cantidadHogar = listaLineasHogarYMovil.size();
                for (int i = 1; i <= cantidadHogar; i++) {
                    try {
                        WebElement ordenEnVueloPlan = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'])["+i+"]/parent::*/*[@class='ordenes']/*/*[@class='stl_deuda']");
                        String ordenVuelo = ordenEnVueloPlan.getText();
                        cargarMsgLog(Level.INFO,"Texto Orden en Vuelo Plan es: " + ordenVuelo);
                        ORDEN_EN_VUELO = "CON ORDEN EN VUELO";
                        cargarMsgLog(Level.INFO,"Orden en Vuelo: " + ORDEN_EN_VUELO);
                        ordenVueloPlan.add(ORDEN_EN_VUELO);
                    } catch (Exception e) {
                        ORDEN_EN_VUELO = "SIN ORDEN EN VUELO";
                        cargarMsgLog(Level.INFO,"Orden en Vuelo: " + ORDEN_EN_VUELO);
                        ordenVueloPlan.add(ORDEN_EN_VUELO);
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Orden en Vuelo Plan Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                for (int i = 1; i <= cantidadMT; i++) {
                    try {
                        WebElement ordenEnVueloPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero'])["+i+"]/parent::*/*[@class='ordenes']/*/*[@class='stl_deuda']");
                        String ordenVueloMT = ordenEnVueloPlanMT.getText();
                        cargarMsgLog(Level.INFO,"Texto Orden en Vuelo Plan MT es: " + ordenVueloMT);
                        ORDEN_EN_VUELO = "CON ORDEN EN VUELO";
                        cargarMsgLog(Level.INFO,"Orden en Vuelo: " + ORDEN_EN_VUELO);
                        ordenVueloPlan.add(ORDEN_EN_VUELO);
                    } catch (Exception e) {
                        ORDEN_EN_VUELO = "SIN ORDEN EN VUELO";
                        cargarMsgLog(Level.INFO,"Orden en Vuelo: " + ORDEN_EN_VUELO);
                        ordenVueloPlan.add(ORDEN_EN_VUELO);
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void verSiMigraAFibra() {
        cargarMsgLog(Level.INFO, "Ingreso a ver si hay etiqueta Fibra en Linea Hogar");
        try {
            String[] numeroLineaArray = numeroDelPlan.toArray(new String[0]);
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            for (int i = 1; i <= numeroLineaArray.length; i++) {
                WebElement numeroPlan = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'])["+i+"]");
                String NumeroPlan = numeroPlan.getText();
                if (!NumeroPlan.substring(0, 1).equals("9")) {
                    try {
                        WebElement etiqueMigracionFibra = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'])["+i+"]/parent::*/preceding-sibling::*/*/*[contains(@class, 'alert')]/*[contains(@alt, 'ftth')]");
                        if (etiqueMigracionFibra.isDisplayed()) {
                            etiquetaFibra.add("MIGRA FIBRA");
                        }
                    } catch (Exception e) {
                        etiquetaFibra.add("NO MIGRA FIBRA");
                    }
                } else {
                    etiquetaFibra.add("NO APLICA MOVIL");
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "No hay lineas hogar");
        }
        try {
            cargarMsgLog(Level.INFO,"Ingreso a visualizar Etiqueta Fibra Plan Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                for (int i = 1; i <= cantidadMT; i++) {
                    etiquetaFibra.add("NO DESARROLLADO");
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void clickParaSeleccionarPlanActivo() {
        try {
            cargarMsgLog(Level.INFO, "Ingreso a dar click para ver velocidad Linea Hogar");
            waitUntilElementIsVisible(LineasHogarYMovil,4);
            if (LineasHogarYMovil.isDisplayed()) {
                String[] ordenVueloArray = ordenVueloPlan.toArray(new String[0]);
                String[] deudaPlanArray = deudaDelPlan.toArray(new String[0]);
                int k = 1;
                for (int i = 0; i < ordenVueloArray.length; i++) {
                    WebElement numeroPlan = find().getElementByXPath("(//*[@class='content']/*/*[@class='flex header']/*[@class='number_line'] | //*[@class='number_line'])["+k+"]");
                    String NumeroPlan = numeroPlan.getText();
                    k++;
                    if (Objects.equals(ordenVueloArray[i], "SIN ORDEN EN VUELO") && Objects.equals(deudaPlanArray[i], "Sin Deuda")) {
                        if (!NumeroPlan.substring(0, 1).equals("9")) {
                            System.out.println("Ingreso a dar click al numero: " + NumeroPlan);
                            deslizar(i);
                            String cargoDireccionHogar = "";
                            System.out.println("CARGO DIRECION HOGAR: " + cargoDireccionHogar);
                            try {
                                click(numeroPlan,5);
                                clickBtnReintentar();
                                cargoDireccionHogar = btnMostrarOfertaReturn();
                                System.out.println("ESTADO CARGO DIRECCION HOGAR: " + cargoDireccionHogar);
                                try {
                                    if (titleCargando.isDisplayed()) {
                                        driver().navigate().refresh();
                                        UtilWeb.waitForSeconds(4);
                                        action.sendKeys(Keys.ESCAPE).build().perform();
                                        cargarMsgLog(Level.INFO,"SE APLICA ZOOM - 2");
                                        Zoom(65);
                                        click(numeroPlan,5);
                                        clickBtnReintentar();
                                        cargoDireccionHogar = btnMostrarOfertaReturn();
                                        System.out.println("ESTADO CARGO DIRECCION HOGAR - CARGANDO: " + cargoDireccionHogar);
                                    }
                                } catch (Exception e) {
                                    cargarMsgLog(Level.INFO, "No se visualiza la barra de carga - Infinito");
                                }
                                try {
                                    if (btnReintentar.isDisplayed()) {
                                        action.sendKeys(Keys.ESCAPE).build().perform();
                                        click(tapCerrarLineaSeleccionada,5);
                                        String texto = "ERROR EN DIRECCION PLAN";
                                        tecnologiaPlan.add(texto);
                                        velocidadPlan.add(texto);
                                        cuentaConSVAPlan.add(texto);
                                        direccionMigrarFTTH.add(texto);
                                        direccionCliente.add(texto);
                                        estadoDireccion.add(texto);
                                        tecnologiaAMigrar.add(texto);
                                        etiquetaSaltoCero.add(texto);
                                    }
                                } catch (Exception e) {
                                    System.out.println("ESTADO CARGO DIRECCION HOGAR - VALIDACION: " + cargoDireccionHogar);
                                    if (Objects.equals(cargoDireccionHogar, "OK")) {
                                        verSiModificaDireccion(NumeroPlan);
                                        clickBtnRegresar();
                                    }
                                }
                            } catch (Exception e) {
                                cargarMsgLog(Level.INFO, "No se visualiza la barra de carga - Hogar - Infinito");
                            }
                        } else {
                            cargarMsgLog(Level.INFO,"Numero Movil");
                            UtilWeb.waitForSeconds(1);
                            String texto = "NO APLICA MOVIL";
                            tecnologiaPlan.add(texto);
                            velocidadPlan.add(texto);
                            cuentaConSVAPlan.add(texto);
                            direccionMigrarFTTH.add(texto);
                            direccionCliente.add(texto);
                            estadoDireccion.add(texto);
                            tecnologiaAMigrar.add(texto);
                            etiquetaSaltoCero.add(texto);
                        }
                    } else {
                        System.out.println("Cliente con ORDENES EN VUELO y Con deuda en todas sus lineas");
                        String texto = "PLAN INHABILITADO";
                        tecnologiaPlan.add(texto);
                        velocidadPlan.add(texto);
                        cuentaConSVAPlan.add(texto);
                        direccionMigrarFTTH.add(texto);
                        direccionCliente.add(texto);
                        estadoDireccion.add(texto);
                        tecnologiaAMigrar.add(texto);
                        etiquetaSaltoCero.add(texto);
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Hogar y Movil");
        }
        try {
            cargarMsgLog(Level.INFO, "Ingreso a dar click para ver velocidad Linea Movistar Total");
            if (titleMT.isDisplayed()) {
                int cantidadMT = listaLineaMT.size();
                String[] ordenVueloArray = ordenVueloPlan.toArray(new String[0]);
                String[] deudaPlanArray = deudaDelPlan.toArray(new String[0]);
                int cantidadLineaMovilMT = 0;
                int cantidadLineaHogarMT;
                int j = 1;
                for (int i = deudaPlanArray.length - cantidadMT; i < ordenVueloArray.length; i++) {
                    WebElement numeroPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero'])[" + j + "]");
                    String NumeroPlan = numeroPlanMT.getText();
                    if (NumeroPlan.substring(0, 1).equals("9")) {
                       cantidadLineaMovilMT++;
                    }
                    j++;
                }
                System.out.println("CANTIDAD MOVIL MT: " + cantidadLineaMovilMT);
                cantidadLineaHogarMT = cantidadMT - cantidadLineaMovilMT;
                System.out.println("CANTIDAD LINEA HOGAR MT ES: " + cantidadLineaHogarMT);
                if (cantidadLineaHogarMT == 1) {
                    int k = 1;
                    for (int i = deudaPlanArray.length - cantidadMT; i < ordenVueloArray.length; i++) {
                        WebElement numeroPlanMT = find().getElementByXPath("(//*[@class='div-product-hogar']/*[@class='flex']/*[@class='numero'])["+k+"]");
                        String NumeroPlan = numeroPlanMT.getText();
                        k++;
                        if (Objects.equals(ordenVueloArray[i], "SIN ORDEN EN VUELO") && Objects.equals(deudaPlanArray[i], "Sin Deuda")) {
                            if (!NumeroPlan.substring(0, 1).equals("9")) {
                                System.out.println("Ingreso a dar click al numero: " + NumeroPlan);
                                deslizar(i);
                                String cargoDireccionMT = "";
                                System.out.println("CARGO DIRECION HOGAR: " + cargoDireccionMT);
                                try {
                                    click(numeroPlanMT,5);
                                    clickBtnReintentar();
                                    cargoDireccionMT = btnMostrarOfertaReturn();
                                    System.out.println("ESTADO CARGO DIRECCION MT: " + cargoDireccionMT);
                                    try {
                                        if (titleCargando.isDisplayed()) {
                                            driver().navigate().refresh();
                                            UtilWeb.waitForSeconds(4);
                                            action.sendKeys(Keys.ESCAPE).build().perform();
                                            cargarMsgLog(Level.INFO,"SE APLICA ZOOM - 3");
                                            Zoom(65);
                                            click(numeroPlanMT,5);
                                            clickBtnReintentar();
                                            cargoDireccionMT = btnMostrarOfertaReturn();
                                            System.out.println("ESTADO CARGO DIRECCION MT - CARGANDO: " + cargoDireccionMT);
                                        }
                                    } catch (Exception e) {
                                        cargarMsgLog(Level.INFO, "No se visualiza la barra de carga");
                                    }
                                    try {
                                        if (btnReintentar.isDisplayed()) {
                                            action.sendKeys(Keys.ESCAPE).build().perform();
                                            click(tapCerrarLineaSeleccionada,5);
                                            String texto = "ERROR EN DIRECCION PLAN";
                                            tecnologiaPlan.add(texto);
                                            velocidadPlan.add(texto);
                                            cuentaConSVAPlan.add(texto);
                                            direccionMigrarFTTH.add(texto);
                                            direccionCliente.add(texto);
                                            estadoDireccion.add(texto);
                                            tecnologiaAMigrar.add(texto);
                                            etiquetaSaltoCero.add(texto);
                                        }
                                    } catch (Exception e) {
                                        verSiModificaDireccion(NumeroPlan);
                                        clickBtnRegresar();
                                    }
                                } catch (Exception e) {
                                    cargarMsgLog(Level.INFO, "No se visualiza la barra de carga - MT - Infinito");
                                }
                            } else {
                                cargarMsgLog(Level.INFO,"Numero Movil");
                                UtilWeb.waitForSeconds(1);
                                String texto = "NO APLICA MOVIL";
                                tecnologiaPlan.add(texto);
                                velocidadPlan.add(texto);
                                cuentaConSVAPlan.add(texto);
                                direccionMigrarFTTH.add(texto);
                                direccionCliente.add(texto);
                                estadoDireccion.add(texto);
                                tecnologiaAMigrar.add(texto);
                                etiquetaSaltoCero.add(texto);
                            }
                        } else {
                            System.out.println("Cliente con ORDENES EN VUELO y Con deuda en todas sus lineas");
                            String texto = "PLAN INHABILITADO";
                            tecnologiaPlan.add(texto);
                            velocidadPlan.add(texto);
                            cuentaConSVAPlan.add(texto);
                            direccionMigrarFTTH.add(texto);
                            direccionCliente.add(texto);
                            estadoDireccion.add(texto);
                            tecnologiaAMigrar.add(texto);
                            etiquetaSaltoCero.add(texto);
                        }
                    }
                } else {
                    System.out.println("CLIENTE MT CON 2 LINEAS HOGAR");
                    String texto = "MT CON 2 LINEAS HOGAR";
                    for (int i = 1; i <= cantidadMT; i++) {
                        tecnologiaPlan.add(texto);
                        velocidadPlan.add(texto);
                        cuentaConSVAPlan.add(texto);
                        direccionMigrarFTTH.add(texto);
                        direccionCliente.add(texto);
                        estadoDireccion.add(texto);
                        tecnologiaAMigrar.add(texto);
                        etiquetaSaltoCero.add(texto);
                    }
                }
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"El cliente no tiene planes Movistar Total");
        }
    }

    public void verSiModificaDireccion(String NumeroPlan) {
        cargarMsgLog(Level.INFO, "Ingreso a visualizar el Titulo de cambio de Direccion");
        try {
            waitUntilElementIsClickable(titlesDeInsertarDireccion,60);
            if (titleCambioDeDireccion.isDisplayed()) {
                cargarMsgLog(Level.INFO,"Se visualizo el Titulo de cambio de Direccion");
                click(btnActualizarDireccion,10);
                insertarDireccion(NumeroPlan);
            }
        } catch (Exception e) {
            try {
                cargarMsgLog(Level.INFO,"Validar si Linea MT con 2 Lineas Moviles");
                if (titleSeleccioneServicioMT.isDisplayed()) {
                    cargarMsgLog(Level.INFO,"Linea MT con 2 Lineas Moviles");
                    click(iconoPhoneMT,5);
                    UtilWeb.waitForSeconds(1);
                    click(btnMostarOfertas,5);
                }
            } catch (Exception er) {
                cargarMsgLog(Level.INFO,"No es Linea MT con 2 Lineas Moviles");
            }
            cargarMsgLog(Level.INFO, "No aplica cambio de Direccion");
            clickBtnReintentar();
            waitUntilElementIsClickable(titleOfertasSugeridas,10);
            tipoTecnologiaRed(NumeroPlan);
            velocidadDeRed(NumeroPlan);
            obtenerSVA(NumeroPlan);
            titleCoberturaFTTH();
            String texto = "FALTA DESARROLLAR";
            direccionCliente.add(texto);
            estadoDireccion.add(texto);
            tecnologiaDelNuevoPlan();
            saltoCero();
        }
    }

    public void insertarReferencia() {
        try {
            if (verSiTieneReferencia.isDisplayed()) {
                cargarMsgLog(Level.INFO, "Tiene Referencia Insertarda");
            }
        } catch (Exception e ){
            click(insertarReferencia,5);
            insertarReferencia.sendKeys(Keys.CONTROL + "a");
            insertarReferencia.sendKeys(Keys.DELETE);
            cargarMsgLog(Level.INFO, "INGRESO REFERENCIA");
            type(insertarReferencia, ".",5);
            cargarMsgLog(Level.INFO, "SE INGRESO REFERENCIA");
        }
    }

    public void insertarNumeroPuerta() {
        insersionDeTextoObligatorio(insertarNumPuerta, ".");
    }

    public void insertarElBloque() {
        String texto = "A";
        insersionDeTextoObligatorio(insertarBloque, texto);
        try {
            cargarMsgLog(Level.INFO,"Ingreso a validar si se inserto el Bloque");
            if (insertarPisoInsertado.isDisplayed() && insertarBloqueNoInsertado.isDisplayed()) {
                click(insertarBloque,5);
                insertarBloque.sendKeys(Keys.CONTROL + "a");
                insertarBloque.sendKeys(Keys.DELETE);
                type(insertarBloque, texto,5);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"Se valido que se inserto el Bloque Correctamente");
        }
    }

    public void insertarElPiso() {
        String texto = "1";
        insersionDeTextoObligatorio(insertarPiso, texto);
        try {
            cargarMsgLog(Level.INFO,"Ingreso a validar si se inserto el Piso");
            if (insertarBloqueInsertado.isDisplayed() && insertarPisoNoInsertado.isDisplayed()) {
                click(insertarPiso,5);
                insertarPiso.sendKeys(Keys.CONTROL + "a");
                insertarPiso.sendKeys(Keys.DELETE);
                type(insertarPiso, texto,5);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"Se valido que se inserto el Piso Correctamente");
        }
    }

    public void insertarElInterior() {
        String texto = "2";
        insersionDeTextoObligatorio(insertarInterior, texto);
        try {
            cargarMsgLog(Level.INFO,"Ingreso a validar si se inserto el Interior");
            if (insertarPisoInsertado.isDisplayed() && insertarInteriorNoInsertado.isDisplayed()) {
                click(insertarInterior,5);
                insertarInterior.sendKeys(Keys.CONTROL + "a");
                insertarInterior.sendKeys(Keys.DELETE);
                type(insertarInterior, texto,5);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"Se valido que se inserto el Interior Correctamente");
        }
    }

    public void insertarTipoVivienda() {
        String texto = ".";
        try {
            SearchContext contexto = sh().getContext(insetarNombreVivienda);
            if (contexto.findElement(By.cssSelector("div > div > div.mdc-text-field-helper-line > p")).isDisplayed()) {
                System.out.println("SE DETECTO INSERSION DE TEXTO OBLIGATORIO");
                click(tipoVivienda,5);
                seleccionarElementoShadow("houseType", "BLK");
                click(insetarNombreVivienda,5);
                insetarNombreVivienda.sendKeys(Keys.CONTROL + "a");
                insetarNombreVivienda.sendKeys(Keys.DELETE);
                type(insetarNombreVivienda, texto,5);
                for (int i = 1; i <= 3; i++) {
                    cargarMsgLog(Level.INFO,"Se detecto insersion tipo vivienda - se procede a validar campos obligatorios");
                    insertarNumeroPuerta();
                    cargarMsgLog(Level.INFO,"Se detecto insersion tipo vivienda - PASO INSERTAR NUMERO PUERTA - N° " + i);
                    insertarElBloque();
                    cargarMsgLog(Level.INFO,"Se detecto insersion tipo vivienda - PASO INSERTAR BLOQUE - N° " + i);
                    insertarElPiso();
                    cargarMsgLog(Level.INFO,"Se detecto insersion tipo vivienda - PASO INSERTAR PISO - N° " + i);
                    insertarElInterior();
                    cargarMsgLog(Level.INFO,"Se detecto insersion tipo vivienda - PASO INSERTAR INTERIOR - N° " + i);
                }
            }
        } catch (Exception e) {
            System.out.println("NO SE DETECTO INSERSION DE TEXTO OBLIGATORIO");
        }
    }

    public void insersionDeTextoObligatorio(WebElement element, String texto) {
        try {
            SearchContext contexto = sh().getContext(element);
            if (contexto.findElement(By.cssSelector("div > div > div.mdc-text-field-helper-line > p")).isDisplayed()) {
                System.out.println("SE DETECTO INSERSION DE TEXTO OBLIGATORIO");
                click(element,5);
                element.sendKeys(Keys.CONTROL + "a");
                element.sendKeys(Keys.DELETE);
                System.out.println("INGRESO A INSERTAR TEXTO OBLIGATORIO");
                type(element, texto,5);
                System.out.println("INSERTO TEXTO OBLIGATORIO");
            }
        } catch (Exception e) {
            System.out.println("NO SE DETECTO INSERSION DE TEXTO OBLIGATORIO");
        }
    }

    public void insertarBloquePisoEInterior() {
        try {
            waitUntilElementIsVisible(verInsersionNumeroPuerta,10);
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "Error en la insersion Numero Puerta");
        }
        insertarNumeroPuerta();
        insertarElBloque();
        insertarElPiso();
        insertarElInterior();
        insertarTipoVivienda();
    }

    public void errorInconsistenciaDireccion() {
        cargarMsgLog(Level.INFO, "Ingreso a validar si se visualiza el mensaje de Incosistencia en la Direccion");
        try {
            if (titleErrorNumeroPuerta.isDisplayed()) {
                click(btnAceptarErrorNumeroPuerta,5);
                try {
                    waitUntilElementIsVisible(verInsersionNumeroPuerta,10);
                } catch (Exception e) {
                    cargarMsgLog(Level.INFO, "Error en la insersion Numero Puerta");
                }
                insertarNumeroPuerta();
                insertarElBloque();
                insertarElPiso();
                insertarElInterior();
                insertarTipoVivienda();
                click(btnConsultarCobertura,5);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "Direccion cargo Correctamente");
        }
    }

    public void tipoTecnologiaRed(String numeroLinea) {
        cargarMsgLog(Level.INFO, "Ingreso a validar el tipo de tecnologia de red");
        try {
            WebElement tipoRed = find().getElementByXPath("//*[contains(@class, 'title') and contains(text(), '" + numeroLinea + "')]/parent::*/parent::*/parent::*/parent::*/*[contains(@class, 'tdp-row')]/*/*/*/*[@class = 'tdp-col-10']/*/*[contains(@class, 'smallTitle') and contains(text(), 'Internet')] | (//*[contains(@class, 'title') and contains(text(), '" + numeroLinea + "')]/parent::*/parent::*/parent::*/parent::*/*[contains(@class, 'tdp-row')]/following-sibling::*[2]/*/*/*[2]/*/*[contains(@class, 'smallTitle')])[1]");
            String tecnoligia = tipoRed.getText().trim();
            String tipoTecnologia;
            try {
                int inicia = tecnoligia.indexOf("HFC");
                tipoTecnologia = tecnoligia.substring(inicia);
                System.out.println("El Tipo de tecnoligia es: " + tipoTecnologia);
                tecnologiaPlan.add(tipoTecnologia);
            } catch (Exception e) {
                int inicia = tecnoligia.indexOf("FTTH");
                tipoTecnologia = tecnoligia.substring(inicia);
                System.out.println("El Tipo de tecnoligia es: " + tipoTecnologia);
                tecnologiaPlan.add(tipoTecnologia);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "No cuenta con tecnoligia de red");
            tecnologiaPlan.add("NO APLICA PLAN HOGAR");
        }
    }

    public void velocidadDeRed(String numeroLinea) {
        cargarMsgLog(Level.INFO, "Ingreso a validar la velocidad de red");
        try {
            WebElement velocidadRed = find().getElementByXPath("//*[contains(@class, 'title') and contains(text(), '" + numeroLinea + "')]/parent::*/parent::*/parent::*/parent::*/*[contains(@class, 'tdp-row')]/*/*/*/*[@class = 'tdp-col-10']/*[@class = 'tdp-row']/*[@class = 'listContent'] | //*[contains(@class, 'title') and contains(text(), '" + numeroLinea + "')]/parent::*/parent::*/parent::*/parent::*/*[contains(@class, 'tdp-row')]/following-sibling::*[2]/*/*/*[2]/*[2]/*[contains(@class, 'listText')]");
            String velocidad = velocidadRed.getText().trim();
            int mbps = velocidad.indexOf("Mbps");
            String velocidadMbps = velocidad.substring(16,mbps).trim();
            System.out.println("La velocidad es: " + velocidadMbps);
            velocidadPlan.add(velocidadMbps + "Mbps");
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "No cuenta con velocidad de red");
            velocidadPlan.add("NO APLICA PLAN HOGAR");
        }
    }

    public void obtenerSVA(String numeroLinea) {
        cargarMsgLog(Level.INFO, "Ingreso a validar si cuenta con SVA contratado");
        try {
            WebElement obtenerSVA = find().getElementByXPath("//*[contains(@class, 'title') and contains(text(), '" + numeroLinea + "')]/parent::*/parent::*/parent::*/parent::*/*[contains(@class, 'tdp-row')]/*/*/*/*[@class = 'tdp-col-10']/*/*[contains(@class, 'smallTitle') and contains(text(), 'SVA')]/parent::*/following-sibling::*/*");
            String SVA = obtenerSVA.getText().trim();
            System.out.println("SVA contratado: " + SVA);
            cuentaConSVAPlan.add(SVA);
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "No cuenta con SVA");
            System.out.println("No tiene SVA");
            cuentaConSVAPlan.add("NO CUENTA CON SVA");
        }
    }

    public void titleCoberturaFTTH() {
        cargarMsgLog(Level.INFO, "Ingreso a visualizar si tiene cobertura a FTTH");
        try {
            if (titleCoberturaFTTH.isDisplayed()) {
                cargarMsgLog(Level.INFO, "Linea puede migrar a fibra");
                direccionMigrarFTTH.add("PUEDE MIGRAR A FIBRA");
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "Linea no puede migrar a fibra");
            direccionMigrarFTTH.add("NO PUEDE MIGRAR A FIBRA");
        }
    }

    public void tecnologiaDelNuevoPlan() {
        try {
            cargarMsgLog(Level.INFO,"Ingreso a validar la tecnologia de red del nuevo plan a migrar");
            if (tecnologiaAMigrarNuevoPlan.isDisplayed()) {
                String tecnologiaNuevoPlan = tecnologiaAMigrarNuevoPlan.getText();
                String nuevaTecnologia = tecnologiaNuevoPlan.substring(8);
                System.out.println("LA NUEVA TECNOLOGIA ES: " + nuevaTecnologia);
                tecnologiaAMigrar.add(nuevaTecnologia);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "No cargo un plan hogar a migrar");
            tecnologiaAMigrar.add("ERROR SCORE");
        }
    }

    public void saltoCero() {
        try {
            cargarMsgLog(Level.INFO, "Plan a migrar tiene etiqueta salto cero");
            if (etiquetaSaltoCeroNuevoPlan.isDisplayed()) {
                etiquetaSaltoCero.add("ETIQUETA SALTO CERO");
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO,"Plan a migrar no tiene etiqueta salto cero");
            etiquetaSaltoCero.add("SIN ETIQUETA SALTO CERO");
        }
    }

    public void clickBtnRegresar() {
        try {
            cargarMsgLog(Level.INFO, "Ingreso a dar click al boton Regresar");
            if (btnRegresar.isDisplayed()) {
                click(btnRegresar,5);
                cargarMsgLog(Level.INFO,"Dio click al boton Regresar");
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "Reintento Retroceder");
            driver().navigate().back();
        }
        clickBtnReintentar();
        clickBotonConsultar();
        visualizarBtnCargarMas();
    }

    public void deslizar(int cantidad) {
        int cont = 0;
        while (cont < cantidad) {
            cont++;
            utils.hacerScroll("DOWN");
        }
        UtilWeb.waitForSeconds(2);
    }

    public void setModificarDireccion() {
        String direccionActual = modificarDireccion.getAttribute("value");
        System.out.println("La direccion Actual es: " + direccionActual);
        direccionCliente.add(direccionActual);
    }

    public void insertarDireccion(String NumeroPlan) {
        String direccionErronea = "";
        String masDeUnaDireccion = "";
        waitUntilElementIsClickable(titleInsertarNuevaDireccion,10);
        setModificarDireccion();
        insertarReferencia();
        click(btnConsultarUbicacion,5);
        clickBtnReintentar();
        try {
            waitUntilElementIsVisible(titleMasDeUnaDireccionODireccion,60);
            if (titleMasDeUnaDireccion.isDisplayed()) {
                masDeUnaDireccion = "SI";
                click(radioDireccion,5);
                click(btnEntendidoMasDeUnaDireccion,5);
            }
        } catch (Exception e) {
            cargarMsgLog(Level.INFO, "No se visualiza titulo de Encontramos mas de una direccion con los datos ingresados");
        }
        try {
            if (titleDireccionErronea.isDisplayed()) {
                direccionErronea = "SI";
            }
        } catch (Exception e) {
            waitUntilElementIsClickable(titleDireccionInsertada,10);
            UtilWeb.waitForSeconds(2);
            insertarBloquePisoEInterior();
            if (masDeUnaDireccion.equals("SI")) {
                insertarTipoVivienda();
            }
            cargarMsgLog(Level.INFO, "Ingreso a dar click consultar cobertura");
            click(btnConsultarCobertura,5);
            cargarMsgLog(Level.INFO, "Dio click consultar cobertura");
            clickBtnReintentar();
            errorInconsistenciaDireccion();
            try {
                UtilWeb.waitForSeconds(2);
                if (btnConsultarCobertura.isDisplayed()) {
                    cargarMsgLog(Level.INFO, "Ingreso a dar click consultar cobertura - contingencia");
                    click(btnConsultarCobertura,5);
                    cargarMsgLog(Level.INFO, "Dio click consultar cobertura - contingencia");
                }
            } catch (Exception e1) {
                cargarMsgLog(Level.INFO, "Si se dio click a consultar cobertura");
            }
            clickBtnReintentar();
        }
        int contador = 0;
        boolean existe = false;
        while (contador < 3 && !existe) {
            contador++;
            try {
                if (btnIngresaNuevaDireccion.isDisplayed()) {
                    click(btnIngresaNuevaDireccion,5);
                    clickBtnReintentar();
                    click(btnConsultarUbicacion,5);
                    clickBtnReintentar();
                    waitUntilElementIsClickable(titleDireccionInsertada,10);
                    UtilWeb.waitForSeconds(2);
                    insertarBloquePisoEInterior();
                    click(btnConsultarCobertura,5);
                    clickBtnReintentar();
                    errorInconsistenciaDireccion();
                }
            } catch (Exception e) {
                UtilWeb.waitForSeconds(2);
                existe = true;
            }
        }
        try {
            System.out.println("Ingreso a visualizar boton de ENTENDIDO o REINTENTAR");
            waitUntilElementIsVisible(titleEntendidoOReintentar,60);
            System.out.println("Visualizo boton de ENTENDIDO o REINTENTAR");
            if (btnReintentar.isDisplayed()) {
                action.sendKeys(Keys.ESCAPE).build().perform();
                String texto = "PROBLEMAS EN MODIFICAR DIRECCION";
                tecnologiaPlan.add(texto);
                velocidadPlan.add(texto);
                cuentaConSVAPlan.add(texto);
                direccionMigrarFTTH.add(texto);
                etiquetaFibra.add(texto);
                direccionCliente.add(texto);
                estadoDireccion.add(texto);
                tecnologiaAMigrar.add(texto);
                etiquetaSaltoCero.add(texto);
            }
        } catch (Exception e) {
            System.out.println("DIRECCION ERRONEA: " + direccionErronea);
            if (direccionErronea.equals("SI")) {
                action.sendKeys(Keys.ESCAPE).build().perform();
                String texto = "DIRECCION ERRONEA";
                tecnologiaPlan.add(texto);
                velocidadPlan.add(texto);
                cuentaConSVAPlan.add(texto);
                direccionMigrarFTTH.add(texto);
                etiquetaFibra.add(texto);
                direccionCliente.add(texto);
                estadoDireccion.add(texto);
                tecnologiaAMigrar.add(texto);
                etiquetaSaltoCero.add(texto);
                action.sendKeys(Keys.ESCAPE).build().perform();
            } else {
                try {
                    cargarMsgLog(Level.INFO, "Igreso a validar la carga correcta de la direccion");
                    click(btnEntendido,10);
                    clickBtnReintentar();
                    estadoDireccion.add("DIRECCION OK");
                } catch (Exception e1) {
                    cargarMsgLog(Level.INFO, "Error en el servicio de direccion");
                    try {
                        if (titleErrorZonaPangea.isDisplayed()) {
                            ERROR_ZONA_PANGEA = "SI";
                            estadoDireccion.add("Error Zona Pangea");
                            clickBtnReintentar();
                            try {
                                if (titleErrorZonaPangea.isDisplayed()) {
                                    cargarMsgLog(Level.INFO, "Persiste el mensaje de Error en Zona Pangea");
                                    action.sendKeys(Keys.ESCAPE).build().perform();
                                }
                            } catch (Exception e2) {
                                cargarMsgLog(Level.INFO, "Se supero el mensaje de Error en Zona Pangea 1");
                                try {
                                    waitUntilElementIsVisible(titleServicioPangeError,10);
                                    if (titleServicioPangeError.isDisplayed()) {
                                        estadoDireccion.add("Servicio Pangea No responde");
                                        click(btnContinuarHFC,5);
                                        click(btnEntendido,10);
                                        clickBtnReintentar();
                                    }
                                } catch (Exception e3) {
                                    cargarMsgLog(Level.INFO, "No se mostro mensaje de Servio Pangea no responde");
                                }
                            }
                        }
                    } catch (Exception e2) {
                        cargarMsgLog(Level.INFO, "Se supero el mensaje de Error en Zona Pangea 2");
                        try {
                            waitUntilElementIsVisible(titleServicioPangeError,10);
                            if (titleServicioPangeError.isDisplayed()) {
                                estadoDireccion.add("Servicio Pangea No responde");
                                click(btnContinuarHFC,5);
                                click(btnEntendido,10);
                                clickBtnReintentar();
                            }
                        } catch (Exception e3) {
                            cargarMsgLog(Level.INFO, "No se mostro mensaje de Servio Pangea no responde");
                        }
                    }
                }
                waitUntilElementIsClickable(titleOfertasSugeridas,10);
                tipoTecnologiaRed(NumeroPlan);
                velocidadDeRed(NumeroPlan);
                obtenerSVA(NumeroPlan);
                titleCoberturaFTTH();
                tecnologiaDelNuevoPlan();
                saltoCero();
            }
        }
    }

    public void mensaje(String mensaje) {
        System.out.println("***********************************");
        System.out.println(mensaje);
        System.out.println("***********************************");
    }

    /**
     * FUNCION BOTON MOSTRAR OFERTAS
     */

    public String btnMostrarOfertaReturn() {
        cargarMsgLog(Level.INFO,"Ingreso a Validar Existencia Boton Mostrar Ofertas");
        String direccionActual = null;
        boolean existe = false;
        boolean presente = false;
        int cont = 0;
        while (!existe && cont < 30) {
            try {
                UtilWeb.waitForSeconds(2);
                if (btnMostrarOfertas.isDisplayed()) {
                    cargarMsgLog(Level.INFO,"Se encontro Boton Mostrar Ofertas");
                    click(btnMostrarOfertas,10);
                    clickBtnReintentar();
                    existe = true;
                    int contador = 0;
                    while (contador < 2 && !presente) {
                        contador++;
                        System.out.println("#########################");
                        System.out.println("CONTADO VALE: " + contador);
                        System.out.println("#########################");
                        try {
                            cargarMsgLog(Level.INFO,"INGRESO A VISUALIZAR CONTENIDO INSERTAR DIRECCION - N°" + contador);
                            waitUntilElementIsClickable(titlesDeInsertarDireccion,10);
                            if (titlesDeInsertarDireccion.isDisplayed()) {
                                cargarMsgLog(Level.INFO,"Ya no se visualiza Boton Mostrar Ofertas");
                                direccionActual = "OK";
                                presente = true;
                                return direccionActual;
                            }
                        } catch (Exception er) {
                            if (btnMostrarOfertas.isDisplayed()) {
                                if (contador < 2) {
                                    System.out.println("SE SIGUE VISUALIZANDO EL BOTON MOSTAR OFERTAS - REINTENTO - N°" + contador);
                                    cargarMsgLog(Level.INFO,"Se encontro Boton Mostrar Ofertas - Contingencia - N°" + contador);
                                    click(btnMostrarOfertas,10);
                                    cargarMsgLog(Level.INFO,"Dio click - Boton Mostrar Ofertas - Contingencia - N°" + contador);
                                    clickBtnReintentar();
                                } else {
                                    System.out.println("SE SIGUE VISUALIZANDO EL BOTON MOSTAR OFERTAS");
                                    cargarMsgLog(Level.INFO, "INGRESO A ELIMINAR ELEMENTO SELECCIONADO");
                                    direccionActual = "FALLO";
                                    System.out.println("SE ELIMINA OPCION SELECCIONANA");
                                    eliminarNumeroSeleccionado();
                                    String texto = "NO CARGO CAMBIAR DIRECCION";
                                    tecnologiaPlan.add(texto);
                                    velocidadPlan.add(texto);
                                    cuentaConSVAPlan.add(texto);
                                    direccionMigrarFTTH.add(texto);
                                    direccionCliente.add(texto);
                                    estadoDireccion.add(texto);
                                    tecnologiaAMigrar.add(texto);
                                    etiquetaSaltoCero.add(texto);
                                    return direccionActual;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                cont ++;
                cargarMsgLog(Level.INFO,"NO SE VISUALIZA EL BOTON MOSTRAR OFERTA - N°" + cont);
            }
        }
        return direccionActual;
    }

    /**
     * FUNCION - ELIMINAR NUMERO SELECCIONADO
     * */

    public void eliminarNumeroSeleccionado() {
        cargarMsgLog(Level.INFO, "Ingreso a visualizar si aun se muestra el plan seleccionado");
        if (btnMostrarOfertas.isDisplayed()) {
            cargarMsgLog(Level.INFO, "Se visualizo que aun existe el numero seleccionado");
            click(btnEliminarSeleccion,10);
            cargarMsgLog(Level.INFO, "Se elimino el numero aun seleccionado");
        }
    }

    /**
     * ZOOM
     * */

    public void Zoom(int zoomLevel){
        String zoomScript = "document.body.style.zoom='" + zoomLevel + "%'";
        ((JavascriptExecutor) driver()).executeScript(zoomScript);
        cargarMsgLog(Level.INFO, "Zoom ajustado al " + zoomLevel + "%.");
    }

    /**
     * FUNCION SHADOW
     * */

    public void seleccionarElementoShadow(String sFormControlName, String sCodigoValue) {
        UtilWeb.waitForSeconds(1);
        System.out.println("seleccionarValueComboShadow(sFormControlName = " + sFormControlName + ", sCodigoValue = " + sCodigoValue + ")");
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver());
        eventFiringWebDriver.executeScript("document.querySelector('[formcontrolname="+sFormControlName+"]') " +
                ".shadowRoot.querySelector('li.mdc-list-item[data-value="+sCodigoValue+"]').click();");
    }

    /**
     * CAPURA DE ELEMENTOS POR ARRAY
     * */

    public void addElementosArray(List<String> list, String[] array, String nameLista) {
        System.out.println("*********************************");
        System.out.println("Lista del - " + nameLista);
        System.out.println("Contenido Lista: " + list);
        System.out.println("Cantidad de elementos en el array: " + array.length);
        totalElementosPorArray.add(array.length);
        System.out.println("*********************************");
    }

    /**
     * FUNCION - CREAR EXCEL
     * */

    public void generarExcel(String folderPath, String fileName, String sheetName) {
        String path = Paths.get(folderPath, fileName).toString() + ".xlsx";
        Workbook workbook = null;
        Sheet sheet = null;

        try {
            // Verificar si el archivo existe
            File file = new File(path);
            if (file.exists()) {
                // Abrir el archivo existente
                try (FileInputStream fileIn = new FileInputStream(path)) {
                    workbook = new XSSFWorkbook(fileIn);
                    sheet = workbook.getSheet(sheetName);
                    if (sheet == null) {
                        sheet = workbook.createSheet(sheetName); // Si la hoja no existe, se crea una nueva
                    }
                }
            } else {
                // Si el archivo no existe, crear un nuevo workbook
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(sheetName);
            }

            // Obtener el índice de la última fila y agregar nuevas filas después de la última fila existente
            int rowIndex = sheet.getPhysicalNumberOfRows();

            // Si el archivo es nuevo, agregar encabezados
            if (rowIndex == 0) {
                String[] headers = {
                        "Tipo Documento", "Número Documento", "Nombre Cliente", "Tipo Plan del Cliente",
                        "Número de Línea", "Nombre Plan", "Tipo Plan", "Componentes Plan", "Estado del Plan",
                        "Estado Deuda", "Cantidad De Deuda", "Plan IPTV", "Orden En Vuelo", "Tecnología del Plan",
                        "Velocidad Red Plan", "SVA", "Dirección a Fibra", "Etiqueta Fibra", "Ciclo de Facturación",
                        "Antigüedad", "Dirección", "Estado Dirección", "Tecnología a Migrar", "Salto Cero"
                };

                // Crear encabezados
                Row headerRow = sheet.createRow(rowIndex++);
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                }
            }

            // Agregar los datos a las filas
            for (ClienteData clienteData : clienteDataList) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(clienteData.getTipoDocumento());
                row.createCell(1).setCellValue(clienteData.getNroDocumento());
                row.createCell(2).setCellValue(clienteData.getNombreCliente());
                row.createCell(3).setCellValue(clienteData.getTipoPlanDelCliente());
                row.createCell(4).setCellValue(clienteData.getNumeroDeLinea());
                row.createCell(5).setCellValue(clienteData.getNombrePlan());
                row.createCell(6).setCellValue(clienteData.getTipoPlan());
                row.createCell(7).setCellValue(clienteData.getComponentesPlan());
                row.createCell(8).setCellValue(clienteData.getEstadoDePlan());
                row.createCell(9).setCellValue(clienteData.getEstadoDeuda());
                row.createCell(10).setCellValue(clienteData.getCantidadDeDeuda());
                row.createCell(11).setCellValue(clienteData.getPlanIPTV());
                row.createCell(12).setCellValue(clienteData.getOrdenEnVuelo());
                row.createCell(13).setCellValue(clienteData.getTecnologiaDelPlan());
                row.createCell(14).setCellValue(clienteData.getVelocidadRedPlan());
                row.createCell(15).setCellValue(clienteData.getSva());
                row.createCell(16).setCellValue(clienteData.getDireccionAFibra());
                row.createCell(17).setCellValue(clienteData.getVerSiTieneEtiquetaFibra());
                row.createCell(18).setCellValue(clienteData.getCicloDeFacturacion());
                row.createCell(19).setCellValue(clienteData.getAntiguedad());
                row.createCell(20).setCellValue(clienteData.getDireccion());
                row.createCell(21).setCellValue(clienteData.getEstadoDireccion());
                row.createCell(22).setCellValue(clienteData.getTecnologiaAMigrar());
                row.createCell(23).setCellValue(clienteData.getSaltoCero());
            }

            // Crear directorio si no existe
            Path paths = Paths.get(folderPath).toAbsolutePath();
            if (!Files.exists(paths)) {
                Files.createDirectories(paths);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Directorio creado en: {0} " + paths.toString());
            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "El directorio ya existe en: {0} " + paths.toString());
            }

            // Escribir el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Archivo Excel creado o actualizado en: {0} " + folderPath + "/" + fileName);
            }

        } catch (IOException e) {
            e.printStackTrace();
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Error al crear o escribir el archivo Excel: " + path);
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void generarExcelError(String folderPath, String fileName, String sheetName) {
        String path = Paths.get(folderPath, fileName).toString() + ".xlsx";
        Workbook workbook = null;
        Sheet sheet = null;

        try {
            // Verificar si el archivo existe
            File file = new File(path);
            if (file.exists()) {
                // Abrir el archivo existente
                try (FileInputStream fileIn = new FileInputStream(path)) {
                    workbook = new XSSFWorkbook(fileIn);
                    sheet = workbook.getSheet(sheetName);
                    if (sheet == null) {
                        sheet = workbook.createSheet(sheetName); // Si la hoja no existe, se crea una nueva
                    }
                }
            } else {
                // Si el archivo no existe, crear un nuevo workbook
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(sheetName);
            }

            // Obtener el índice de la última fila y agregar nuevas filas después de la última fila existente
            int rowIndex = sheet.getPhysicalNumberOfRows();

            // Si el archivo es nuevo, agregar encabezados
            if (rowIndex == 0) {
                String[] headers = {
                        "Tipo Documento", "Número Documento"
                };

                // Crear encabezados
                Row headerRow = sheet.createRow(rowIndex++);
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                }
            }

            // Agregar los datos a las filas
            for (ClienteData clienteData : clienteDataList) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(clienteData.getTipoDocumento());
                row.createCell(1).setCellValue(clienteData.getNroDocumento());
            }

            // Crear directorio si no existe
            Path paths = Paths.get(folderPath).toAbsolutePath();
            if (!Files.exists(paths)) {
                Files.createDirectories(paths);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Directorio creado en: {0} " + paths.toString());
            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "El directorio ya existe en: {0} " + paths.toString());
            }

            // Escribir el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Archivo Excel creado o actualizado en: {0} " + folderPath + "/" + fileName);
            }

        } catch (IOException e) {
            e.printStackTrace();
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Error al crear o escribir el archivo Excel: " + path);
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void generarExcelBitacora(String folderPath, String fileName, String sheetName) {
        String path = Paths.get(folderPath, fileName).toString() + ".xlsx";
        Workbook workbook = null;
        Sheet sheet = null;

        try {
            // Verificar si el archivo existe
            File file = new File(path);
            if (file.exists()) {
                // Abrir el archivo existente
                try (FileInputStream fileIn = new FileInputStream(path)) {
                    workbook = new XSSFWorkbook(fileIn);
                    sheet = workbook.getSheet(sheetName);
                    if (sheet == null) {
                        sheet = workbook.createSheet(sheetName); // Si la hoja no existe, se crea una nueva
                    }
                }
            } else {
                // Si el archivo no existe, crear un nuevo workbook
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(sheetName);
            }

            // Obtener el índice de la última fila y agregar nuevas filas después de la última fila existente
            int rowIndex = sheet.getPhysicalNumberOfRows();

            // Si el archivo es nuevo, agregar encabezados
            if (rowIndex == 0) {
                String[] headers = {
                        "FECHA / CREACIÓN ALTA", "TIPO DE VENTANA" ,"CREADO POR", "TIQLT / CP", "NumDoc", "TIPO DE DOC", "Segmento",
                        "TipoTransaccion", "TipoVenta", "Aplicaciones", "ID DE CLIENTE", "Usuario", "ORDEN",
                        "CÓDIGO DE VENTA / FE - (App/Web Fron end)", "CÓDIGO DE AUTOGESTIÓN - (App/Web Mi movistar)",
                        "CÓDIGO DE RECLAMO", "SIMCARD", "IMEI", "NRO DE LINEA", "ESTADO DE LA ORDEN FINAL", "INVENTARIO PC"
                };

                // Crear encabezados
                Row headerRow = sheet.createRow(rowIndex++);
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                }
            }

            // Agregar los datos a las filas
            for (ClienteData clienteData : clienteDataList) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(getToday());
                row.createCell(1).setCellValue(calcularTipoVentana());
                row.createCell(2).setCellValue((String) getScenarioContext().get("analistaQa"));
                row.createCell(3).setCellValue(getScenarioContext().get("hu") + "/" + getScenarioContext().get("test"));
                row.createCell(4).setCellValue(clienteData.getNroDocumento());
                row.createCell(5).setCellValue(clienteData.getTipoDocumento());
                row.createCell(6).setCellValue("B2C");
                row.createCell(7).setCellValue((String) getScenarioContext().get("transaccion"));
                row.createCell(8).setCellValue((String) getScenarioContext().get("tipoVenta"));
                row.createCell(9).setCellValue("Web FrontEnd");
                row.createCell(10).setCellValue((String) getScenarioContext().get("idCliente"));
                row.createCell(11).setCellValue((String) getScenarioContext().get("usuarioVendedor"));
                row.createCell(12).setCellValue((String) getScenarioContext().get("orden"));
                row.createCell(13).setCellValue((String) getScenarioContext().get("numeroSolicitud"));
                row.createCell(14).setCellValue((String) getScenarioContext().get("codigoAutogestion"));
                row.createCell(15).setCellValue((String) getScenarioContext().get("codigoReclamo"));
                row.createCell(16).setCellValue((String) getScenarioContext().get("simcard"));
                row.createCell(17).setCellValue((String) getScenarioContext().get("imei"));
                row.createCell(18).setCellValue(clienteData.getNumeroDeLinea());
                row.createCell(19).setCellValue((String) getScenarioContext().get("estadoOrden"));
                row.createCell(20).setCellValue(getHostname());
            }

            // Crear directorio si no existe
            Path paths = Paths.get(folderPath).toAbsolutePath();
            if (!Files.exists(paths)) {
                Files.createDirectories(paths);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Directorio creado en: {0} " + paths.toString());
            } else {
                UtilWeb.logger(this.getClass()).log(Level.INFO, "El directorio ya existe en: {0} " + paths.toString());
            }

            // Escribir el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
                UtilWeb.logger(this.getClass()).log(Level.INFO, "Archivo Excel creado o actualizado en: {0} " + folderPath + "/" + fileName);
            }

        } catch (IOException e) {
            e.printStackTrace();
            UtilWeb.logger(this.getClass()).log(Level.SEVERE, "Error al crear o escribir el archivo Excel: " + path);
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
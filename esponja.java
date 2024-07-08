import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class esponja {
    private Scanner esponja = new Scanner(System.in);
    private String apodo;
    public static boolean registrarse = false;
    public static boolean inicio_sesion = false;
    public static List<String> registro_de_usuarios = new ArrayList<>();
    public static List<String> registro_de_contraseñas = new ArrayList<>();
    private static double totalpagar = 0;
    private static String metodo_de_pago_seleccionado = "";
    private static String detalles_pago = "";

    public static void iniciar_sesion() {
        Scanner grinch = new Scanner(System.in);
        String op;
        String correo_valido, contraseña_valida;
        String registro, contraseña, respuesta;

        System.out.println("PARA COMENZAR A REALIZAR PEDIDOS DEBE: (registrese/inicie sesion)");
        System.out.println("1.- REGISTRARSE");
        System.out.println("2.- INICIAR SESION");
        op = grinch.nextLine();

        switch (op) {
            case "1":
                if (!registrarse) {
                    System.out.println("REGISTRO:");
                    System.out.println("registre su correo electronico:");
                    registro = grinch.nextLine();
                    while (!registro.contains("@gmail.com")) {
                        System.out.println("Correo electrónico inválido, por favor vuelva a intentar :).");
                        registro = grinch.nextLine();
                    }
                    registro_de_usuarios.add(registro);
                    System.out.println("cree su contraseña:");
                    contraseña = grinch.nextLine();
                    registro_de_contraseñas.add(contraseña);

                    System.out.println("INICIAR SESIÓN:");
                    do {
                        System.out.println("Ingrese su correo electrónico");
                        correo_valido = grinch.nextLine();
                        System.out.println("Ingrese su contraseña: ");
                        contraseña_valida = grinch.nextLine();

                        for (int i = 0; i < registro_de_usuarios.size(); i++) {
                            if (correo_valido.equals(registro_de_usuarios.get(i)) && contraseña_valida.equals(registro_de_contraseñas.get(i))) {
                                System.out.println("Inicio de sesión, ¡EXITOSO!");
                                registrarse = true;
                                inicio_sesion = true;
                                break;
                            }
                        }
                        if (!inicio_sesion) {
                            System.out.println("Inicio de sesión, ¡FALLIDO!");
                            System.out.println("Correo o contraseña incorrecta.");
                        }
                    } while (!inicio_sesion);
                }
                break;

            case "2":
                System.out.println("INICIAR SESIÓN:");
                System.out.println("ingrese su correo:");
                correo_valido = grinch.nextLine();
                System.out.println("ingrese su contraseña:");
                contraseña_valida = grinch.nextLine();

                for (int i = 0; i < registro_de_usuarios.size(); i++) {
                    if (correo_valido.equals(registro_de_usuarios.get(i)) && contraseña_valida.equals(registro_de_contraseñas.get(i))) {
                        System.out.println("Inicio de sesión, ¡EXITOSO!");
                        inicio_sesion = true;
                        break;
                    }
                }
                if (!inicio_sesion) {
                    System.out.println("Inicio de sesión, ¡FALLIDO!");
                    System.out.println("Correo o contraseña incorrecta.");
                }
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public void menu() {
        System.out.println("---- OECHLE ----");
        System.out.println(":::MENU:::");
        System.out.println("¿QUÉ ESTÁS BUSCANDO HOY?");
        System.out.println("1. MODA MUJER");
        System.out.println("2. MODA HOMBRE");
        System.out.println("3. MODA INFANTIL");
        System.out.println("4. CALZADOS");
        System.out.println("5. TECNOLOGIA");
        int opcion = esponja.nextInt();
        switch (opcion) {
            case 1:
                this.op_moda_mujer();
                break;
            case 2:
                this.op_moda_hombre();
                break;
            case 3:
                this.op_moda_infantil();
                break;
            case 4:
                this.op_moda_calzado();
                break;
            case 5:
                this.op_tecnologia();
                break;
            default:
                System.out.println("OPCION NO VALIDA");
        }
    }

    public String op_moda_mujer() {
        String[] RECIEN_NACIDOS = {"Skinny Jeans pitillo flerchi $119.00", "jean malabar correa $129.00", "joger mujer parada 111 ally $111.50"};
        String[] PERSONAJES_FAVORITOS = {"hypnotic casaca green pit $134.00", "chompa malabar manga larga mel 123.00", "abrigo sfera solapa camel $121.00"};
        String[] ZAPATOS = {"chaleco hypnotic mujer cruce $132.00", "vestido largo hypnotic largo vainilla $123.00", "polo hypnotic mety $121.00"};
        double[] precio = {119.00, 129.00, 111.50, 134.00, 123.00, 121.00, 132.00, 123.00, 121.00};

        double igv, subtotalTotal;
        int[] carrito = new int[RECIEN_NACIDOS.length];
        int[] carrito_PERSONAJES = new int[PERSONAJES_FAVORITOS.length];
        int[] carrito_ZAPATOS = new int[ZAPATOS.length];
        int opcion, cantidad;

        String metodo_de_pago;
        System.out.println("-----------BIENVENIDOS A OECHSLE-----------");
        System.out.println("ENCUENTRA TU STOCK FAVORITO AQUI");
        System.out.println("TENEMOS EN:");
        System.out.println(" 1.- JEANS");
        System.out.println(" 2.- MARCAS MUJER");
        System.out.println(" 3.- NIGHT x HIPNOTIC");

        opcion = esponja.nextInt();
        esponja.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Elige una opción:");
                for (int i = 0; i < RECIEN_NACIDOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + RECIEN_NACIDOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + RECIEN_NACIDOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + RECIEN_NACIDOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + RECIEN_NACIDOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 2:
                System.out.println("Elige una opción:");
                for (int i = 0; i < PERSONAJES_FAVORITOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + PERSONAJES_FAVORITOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[0] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[0] + " de " + PERSONAJES_FAVORITOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[1] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[1] + " de " + PERSONAJES_FAVORITOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[2] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[2] + " de " + PERSONAJES_FAVORITOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 3:
                System.out.println("Elige una opción:");
                for (int i = 0; i < ZAPATOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + ZAPATOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[0] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[0] + " de " + ZAPATOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[1] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[1] + " de " + ZAPATOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[2] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[2] + " de " + ZAPATOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        subtotalTotal = Arrays.stream(carrito).sum() * precio[0] + Arrays.stream(carrito_PERSONAJES).sum() * precio[1] + Arrays.stream(carrito_ZAPATOS).sum() * precio[2];
        igv = subtotalTotal * 0.18;
        totalpagar = subtotalTotal + igv;

        System.out.println("Subtotal JEANS : S/ " + Arrays.stream(carrito).sum() * precio[0]);
        System.out.println("Subtotal MARCAS MUJER : S/ " + Arrays.stream(carrito_PERSONAJES).sum() * precio[1]);
        System.out.println("Subtotal NIGHT x HIPNOTIC : S/ " + Arrays.stream(carrito_ZAPATOS).sum() * precio[2]);
        System.out.println("----------------------------------------");
        System.out.println("Subtotal Total: S/ " + subtotalTotal);
        System.out.println("IGV : S/ " + igv);
        System.out.println("Total a pagar: S/ " + totalpagar);

        System.out.println("Seleccione tipo de pago:");
        System.out.println("1. Tarjeta de crédito");
        System.out.println("2. Efectivo");
        System.out.println("3. Factura");
        metodo_de_pago = esponja.nextLine();

        switch (metodo_de_pago) {
            case "1":
                metodo_de_pago_seleccionado = "Tarjeta de crédito";
                metodopago_tarjeta();
                break;
            case "2":
                metodo_de_pago_seleccionado = "Efectivo";
                metodopago_efectivo();
                break;
            case "3":
                metodo_de_pago_seleccionado = "Factura";
                metodopago_factura();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        exportarFactura("MODA MUJER");
        return null;
    }

    public String op_moda_hombre() {
        String[] RECIEN_NACIDOS = {"Hipnotic casaca Revers hombre negro", "Madison gorra caspre bonber negro", "Pioner gorra traficc Hat hombre verde militar"};
        String[] PERSONAJES_FAVORITOS = {"polo pijama Hipnotic manga larga", "bata Madison Flannel hombre", "bata Madison con pantufla waffle"};
        String[] ZAPATOS = {"lentes skullcandy bold lunas negras", "lentes skullcandy bold lunas rojas", "collar de plata hombre"};
        double[] precio = {154.50, 144.50, 134.50, 124.00, 115.00, 111.00};

        double igv, subtotalTotal;
        int[] carrito = new int[RECIEN_NACIDOS.length];
        int[] carrito_PERSONAJES = new int[PERSONAJES_FAVORITOS.length];
        int[] carrito_ZAPATOS = new int[ZAPATOS.length];
        int opcion, cantidad;

        String metodo_de_pago;
        System.out.println("-----------BIENVENIDOS A OECHSLE-----------");
        System.out.println("ENCUENTRA TU STOCK FAVORITO AQUI");
        System.out.println("TENEMOS EN:");
        System.out.println(" 1.- MARCAS");
        System.out.println(" 2.- PIJAMAS");
        System.out.println(" 3.- ACCESORIOS");

        opcion = esponja.nextInt();
        esponja.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Elige una opción:");
                for (int i = 0; i < RECIEN_NACIDOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + RECIEN_NACIDOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + RECIEN_NACIDOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + RECIEN_NACIDOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + RECIEN_NACIDOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 2:
                System.out.println("Elige una opción:");
                for (int i = 0; i < PERSONAJES_FAVORITOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + PERSONAJES_FAVORITOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[0] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[0] + " de " + PERSONAJES_FAVORITOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[1] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[1] + " de " + PERSONAJES_FAVORITOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[2] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[2] + " de " + PERSONAJES_FAVORITOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 3:
                System.out.println("Elige una opción:");
                for (int i = 0; i < ZAPATOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + ZAPATOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[0] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[0] + " de " + ZAPATOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[1] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[1] + " de " + ZAPATOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[2] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[2] + " de " + ZAPATOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        subtotalTotal = Arrays.stream(carrito).sum() * precio[0] + Arrays.stream(carrito_PERSONAJES).sum() * precio[1] + Arrays.stream(carrito_ZAPATOS).sum() * precio[2];
        igv = subtotalTotal * 0.18;
        totalpagar = subtotalTotal + igv;

        System.out.println("Subtotal MARCAS : S/ " + Arrays.stream(carrito).sum() * precio[0]);
        System.out.println("Subtotal PIJAMAS : S/ " + Arrays.stream(carrito_PERSONAJES).sum() * precio[1]);
        System.out.println("Subtotal ACCESORIOS : S/ " + Arrays.stream(carrito_ZAPATOS).sum() * precio[2]);
        System.out.println("----------------------------------------");
        System.out.println("Subtotal Total: S/ " + subtotalTotal);
        System.out.println("IGV : S/ " + igv);
        System.out.println("Total a pagar: S/ " + totalpagar);

        System.out.println("Seleccione tipo de pago:");
        System.out.println("1. Tarjeta de crédito");
        System.out.println("2. Efectivo");
        System.out.println("3. Factura");
        metodo_de_pago = esponja.nextLine();

        switch (metodo_de_pago) {
            case "1":
                metodo_de_pago_seleccionado = "Tarjeta de crédito";
                metodopago_tarjeta();
                break;
            case "2":
                metodo_de_pago_seleccionado = "Efectivo";
                metodopago_efectivo();
                break;
            case "3":
                metodo_de_pago_seleccionado = "Factura";
                metodopago_factura();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        exportarFactura("MODA HOMBRE");
        return null;
    }

    public String op_moda_infantil() {
        String[] RECIEN_NACIDOS = {"PIJAMA 2 PIEZAS PARA RECIEN NACIDO BABY CIRCUS PANTALON", "PIJAMA PARA RECIEN NACIDO ENTERIZO BABY CIRCUS MAMA", "MANTA PARA RECIEN NACIDO BABY CIRCUS"};
        String[] PERSONAJES_FAVORITOS = {"BARBIE POLO ROSADO NIÑA S/ 34.50", "SPIDERMAN POLO NEGRO NIÑO S/ 34.50", "KUNFU PANDA POLO CELESTE NIÑO 34.50"};
        String[] ZAPATOS = {"zapato de cuero escolar varon S/ 70.00", "zapato de cuero escolar mujer S/ 65.00", "zapatillas deportivas S/ 120.00"};
        double[] precio = {34.50, 34.50, 34.50, 70.00, 65.00, 120.00};

        double igv, subtotalTotal;
        int[] carrito = new int[RECIEN_NACIDOS.length];
        int[] carrito_PERSONAJES = new int[PERSONAJES_FAVORITOS.length];
        int[] carrito_ZAPATOS = new int[ZAPATOS.length];
        int opcion, cantidad;

        String metodo_de_pago;
        System.out.println("-----------BIENVENIDOS A OECHSLE-----------");
        System.out.println("ENCUENTRA TU STOCK FAVORITO AQUI");
        System.out.println("TENEMOS EN:");
        System.out.println(" 1.- RECIEN NACIDOS");
        System.out.println(" 2.- PERSONAJES FAVORITOS");
        System.out.println(" 3.- ZAPATOS");

        opcion = esponja.nextInt();
        esponja.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Elige una opción:");
                for (int i = 0; i < RECIEN_NACIDOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + RECIEN_NACIDOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + RECIEN_NACIDOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + RECIEN_NACIDOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + RECIEN_NACIDOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 2:
                System.out.println("Elige una opción:");
                for (int i = 0; i < PERSONAJES_FAVORITOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + PERSONAJES_FAVORITOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[0] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[0] + " de " + PERSONAJES_FAVORITOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[1] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[1] + " de " + PERSONAJES_FAVORITOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[2] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[2] + " de " + PERSONAJES_FAVORITOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 3:
                System.out.println("Elige una opción:");
                for (int i = 0; i < ZAPATOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + ZAPATOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[0] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[0] + " de " + ZAPATOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[1] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[1] + " de " + ZAPATOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_ZAPATOS[2] += cantidad;
                        System.out.println("Ha pedido " + carrito_ZAPATOS[2] + " de " + ZAPATOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        subtotalTotal = Arrays.stream(carrito).sum() * precio[0] + Arrays.stream(carrito_PERSONAJES).sum() * precio[1] + Arrays.stream(carrito_ZAPATOS).sum() * precio[2];
        igv = subtotalTotal * 0.18;
        totalpagar = subtotalTotal + igv;

        System.out.println("Subtotal RECIEN NACIDOS: S/ " + Arrays.stream(carrito).sum() * precio[0]);
        System.out.println("Subtotal PERSONAJES FAVORITOS: S/ " + Arrays.stream(carrito_PERSONAJES).sum() * precio[1]);
        System.out.println("Subtotal ZAPATOS: S/ " + Arrays.stream(carrito_ZAPATOS).sum() * precio[2]);
        System.out.println("----------------------------------------");
        System.out.println("Subtotal Total: S/ " + subtotalTotal);
        System.out.println("IGV : S/ " + igv);
        System.out.println("Total a pagar: S/ " + totalpagar);

        System.out.println("Seleccione tipo de pago:");
        System.out.println("1. Tarjeta de crédito");
        System.out.println("2. Efectivo");
        System.out.println("3. Factura");
        metodo_de_pago = esponja.nextLine();

        switch (metodo_de_pago) {
            case "1":
                metodo_de_pago_seleccionado = "Tarjeta de crédito";
                metodopago_tarjeta();
                break;
            case "2":
                metodo_de_pago_seleccionado = "Efectivo";
                metodopago_efectivo();
                break;
            case "3":
                metodo_de_pago_seleccionado = "Factura";
                metodopago_factura();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        exportarFactura("MODA INFANTIL");
        return null;
    }

    public String op_moda_calzado() {
        String[] RECIEN_NACIDOS = {"ZAPATILLAS HOMBRE $134.00", "ZAPATILLAS MUJER $124.00", "ZAPATILLAS NIÑOS $114.00"};
        String[] PERSONAJES_FAVORITOS = {"ZAPATILLAS HOMBRE $134.00", "ZAPATILLAS MUJER $124.00", "ZAPATILLAS NIÑOS $114.00"};
        String[] ZAPATOS = {"ZAPATILLAS HOMBRE $134.00", "ZAPATILLAS MUJER $124.00", "ZAPATILLAS NIÑOS $114.00"};
        double[] precio = {134.50, 124.50, 114.50, 134.00, 125.00, 111.00};

        double igv, subtotalTotal;
        int[] carrito = new int[RECIEN_NACIDOS.length];
        int[] carrito_PERSONAJES = new int[PERSONAJES_FAVORITOS.length];
        int[] carrito_ZAPATOS = new int[ZAPATOS.length];
        int opcion, cantidad;

        String metodo_de_pago;
        System.out.println("-----------BIENVENIDOS A OECHSLE-----------");
        System.out.println("ENCUENTRA TU STOCK FAVORITO AQUI");
        System.out.println("TENEMOS EN:");
        System.out.println(" 1.- ZAPATILLAS ADIDAS");
        System.out.println(" 2.- ZAPATILLAS PUMA");
        System.out.println(" 3.- ZAPATILLAS NIKE");

        opcion = esponja.nextInt();
        esponja.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Elige una opción:");
                for (int i = 0; i < RECIEN_NACIDOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + RECIEN_NACIDOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Qué color desea comprar?");
                        System.out.println("1. Rosado S/ 134.50");
                        System.out.println("2. Amarillo S/ 124.50");
                        System.out.println("3. Blanco S/ 114.50");
                        int opcionColor = esponja.nextInt();
                        esponja.nextLine();
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + RECIEN_NACIDOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Qué color desea comprar?");
                        System.out.println("1. Rosado S/ 134.50");
                        System.out.println("2. Celeste S/ 124.50");
                        System.out.println("3. Amarillo S/ 114.50");
                        opcionColor = esponja.nextInt();
                        esponja.nextLine();
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + RECIEN_NACIDOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Qué color desea comprar?");
                        System.out.println("1. Blanco S/ 134.50");
                        System.out.println("2. Negro S/ 125.00");
                        System.out.println("3. Celeste S/ 114.00");
                        opcionColor = esponja.nextInt();
                        esponja.nextLine();
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + RECIEN_NACIDOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 2:
                System.out.println("Elige una opción:");
                for (int i = 0; i < PERSONAJES_FAVORITOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + PERSONAJES_FAVORITOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Qué color desea comprar?");
                        System.out.println("1. Rosado S/ 134.50");
                        System.out.println("2. Amarillo S/ 124.50");
                        System.out.println("3. Blanco S/ 114.50");
                        int opcionColor = esponja.nextInt();
                        esponja.nextLine();
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + PERSONAJES_FAVORITOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Qué color desea comprar?");
                        System.out.println("1. Rosado S/ 134.50");
                        System.out.println("2. Celeste S/ 124.50");
                        System.out.println("3. Amarillo S/ 114.50");
                        opcionColor = esponja.nextInt();
                        esponja.nextLine();
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + PERSONAJES_FAVORITOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Qué color desea comprar?");
                        System.out.println("1. Blanco S/ 134.50");
                        System.out.println("2. Negro S/ 124.00");
                        System.out.println("3. Celeste S/ 114.00");
                        opcionColor = esponja.nextInt();
                        esponja.nextLine();
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + PERSONAJES_FAVORITOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 3:
                System.out.println("Elige una opción:");
                for (int i = 0; i < ZAPATOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + ZAPATOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + ZAPATOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + ZAPATOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Qué talla desea?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + ZAPATOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        subtotalTotal = Arrays.stream(carrito).sum() * precio[0] + Arrays.stream(carrito_PERSONAJES).sum() * precio[1] + Arrays.stream(carrito_ZAPATOS).sum() * precio[2];
        igv = subtotalTotal * 0.18;
        totalpagar = subtotalTotal + igv;

        System.out.println("Subtotal ZAPATILLAS ADIDAS : S/ " + Arrays.stream(carrito).sum() * precio[0]);
        System.out.println("Subtotal ZAPATILLAS PUMA : S/ " + Arrays.stream(carrito_PERSONAJES).sum() * precio[1]);
        System.out.println("Subtotal ZAPATILLAS NIKE : S/ " + Arrays.stream(carrito_ZAPATOS).sum() * precio[2]);
        System.out.println("----------------------------------------");
        System.out.println("Subtotal Total: S/ " + subtotalTotal);
        System.out.println("IGV : S/ " + igv);
        System.out.println("Total a pagar: S/ " + totalpagar);

        System.out.println("Seleccione tipo de pago:");
        System.out.println("1. Tarjeta de crédito");
        System.out.println("2. Efectivo");
        System.out.println("3. Factura");
        metodo_de_pago = esponja.nextLine();

        switch (metodo_de_pago) {
            case "1":
                metodo_de_pago_seleccionado = "Tarjeta de crédito";
                metodopago_tarjeta();
                break;
            case "2":
                metodo_de_pago_seleccionado = "Efectivo";
                metodopago_efectivo();
                break;
            case "3":
                metodo_de_pago_seleccionado = "Factura";
                metodopago_factura();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        exportarFactura("CALZADOS");
        return null;
    }

    public String op_tecnologia() {
        String[] RECIEN_NACIDOS = {"XIAMI T11 $774.00", "XIAMI T12 $994.00", "XIAMI T13 $1114.00"};
        String[] PERSONAJES_FAVORITOS = {"SAMSUMG S21 $1000.00", "SAMSUMG S22 $1524.00", "SAMSUMG S23 $1814.00"};
        String[] ZAPATOS = {"IPHONE 13 $1324.00", "IPHONE 14 $1734.00", "IPHONE 15 $1994.00"};
        double[] precio = {774.50, 944.50, 1114.50, 1344.00, 1235.00, 1121.00};

        double igv, subtotalTotal;
        int[] carrito = new int[RECIEN_NACIDOS.length];
        int[] carrito_PERSONAJES = new int[PERSONAJES_FAVORITOS.length];
        int[] carrito_ZAPATOS = new int[ZAPATOS.length];
        int opcion, cantidad;

        String metodo_de_pago;
        System.out.println("-----------BIENVENIDOS A OECHSLE-----------");
        System.out.println("ENCUENTRA TU STOCK FAVORITO AQUI");
        System.out.println("TENEMOS EN:");
        System.out.println(" 1.- XIAMI");
        System.out.println(" 2.- SAMSUMG");
        System.out.println(" 3.- IPHONE");

        opcion = esponja.nextInt();
        esponja.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Elige una opción:");
                for (int i = 0; i < RECIEN_NACIDOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + RECIEN_NACIDOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + RECIEN_NACIDOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + RECIEN_NACIDOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + RECIEN_NACIDOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 2:
                System.out.println("Elige una opción:");
                for (int i = 0; i < PERSONAJES_FAVORITOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + PERSONAJES_FAVORITOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[0] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[0] + " de " + PERSONAJES_FAVORITOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[1] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[1] + " de " + PERSONAJES_FAVORITOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito_PERSONAJES[2] += cantidad;
                        System.out.println("Ha pedido " + carrito_PERSONAJES[2] + " de " + PERSONAJES_FAVORITOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            case 3:
                System.out.println("Elige una opción:");
                for (int i = 0; i < ZAPATOS.length; i++) {
                    System.out.println("Opción " + (i + 1) + ": " + ZAPATOS[i]);
                }
                opcion = esponja.nextInt();
                esponja.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[0] += cantidad;
                        System.out.println("Ha pedido " + carrito[0] + " de " + ZAPATOS[0]);
                        break;
                    case 2:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[1] += cantidad;
                        System.out.println("Ha pedido " + carrito[1] + " de " + ZAPATOS[1]);
                        break;
                    case 3:
                        System.out.println("¿Cuántos desea comprar?");
                        cantidad = esponja.nextInt();
                        esponja.nextLine();
                        carrito[2] += cantidad;
                        System.out.println("Ha pedido " + carrito[2] + " de " + ZAPATOS[2]);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        subtotalTotal = Arrays.stream(carrito).sum() * precio[0] + Arrays.stream(carrito_PERSONAJES).sum() * precio[1] + Arrays.stream(carrito_ZAPATOS).sum() * precio[2];
        igv = subtotalTotal * 0.18;
        totalpagar = subtotalTotal + igv;

        System.out.println("Subtotal XIAMI : S/ " + Arrays.stream(carrito).sum() * precio[0]);
        System.out.println("Subtotal SAMSUMG : S/ " + Arrays.stream(carrito_PERSONAJES).sum() * precio[1]);
        System.out.println("Subtotal IPHONE : S/ " + Arrays.stream(carrito_ZAPATOS).sum() * precio[2]);
        System.out.println("----------------------------------------");
        System.out.println("Subtotal Total: S/ " + subtotalTotal);
        System.out.println("IGV : S/ " + igv);
        System.out.println("Total a pagar: S/ " + totalpagar);

        System.out.println("Seleccione tipo de pago:");
        System.out.println("1. Tarjeta de crédito");
        System.out.println("2. Efectivo");
        System.out.println("3. Factura");
        metodo_de_pago = esponja.nextLine();

        switch (metodo_de_pago) {
            case "1":
                metodo_de_pago_seleccionado = "Tarjeta de crédito";
                metodopago_tarjeta();
                break;
            case "2":
                metodo_de_pago_seleccionado = "Efectivo";
                metodopago_efectivo();
                break;
            case "3":
                metodo_de_pago_seleccionado = "Factura";
                metodopago_factura();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        exportarFactura("TECNOLOGÍA");
        return null;
    }

    static void metodopago_tarjeta() {
        String metodo, fecha, cvv, nombre, confirmar, volver, volverr, menu;
        boolean valida;
        Scanner esponja = new Scanner(System.in);
        do {
            System.out.println("INGRESE EL NOMBRE Y APELLIDO DEL TITULAR DE LA TARJETA");
            nombre = esponja.nextLine();
            System.out.println("INGRESE SU NUMERO DE TARJETA:  (1234 1234 1234 1234)");
            metodo = esponja.nextLine().trim();
            if (metodo.length() != 19 || !metodo.matches("[4-5]\\d{3} \\d{4} \\d{4} \\d{4}")) {
                System.out.println("Ingreso incorrecto, por favor intente de nuevo.");
            }
            break;
        } while (metodo.length() != 19 || !metodo.matches("[4-5]\\d{3} \\d{4} \\d{4} \\d{4}"));
        do {
            System.out.println("INGRESE LA FECHA DE VENCIMIENTO DE SU TARJETA (MM/AAAA):");
            fecha = esponja.nextLine().trim();
            valida = fecha.matches("\\d{2}/\\d{4}");
            if (valida) {
                String[] partes = fecha.split("/");
                int mes = Integer.parseInt(partes[0]);
                int año = Integer.parseInt(partes[1]);
                valida = (año >= 2024 && mes >= 6) && (año <= 2035 && mes <= 12);
            }
            if (!valida) {
                System.out.println("Por favor, SU TARJETA VENCIÓ, VUELVE A INTENTAR O CAMBIE EL METODO DE PAGO.");
            }
            break;
        } while (!valida);
        do {
            System.out.println("INGRESE SU CODIGO (CVV)");
            cvv = esponja.nextLine().trim();
            if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
                System.out.println("Por favor, CODIGO (CVV) INCORRECTO O NO COINCIDE CON LA TARJETA, VUELVE A INTENTAR.");
            }
            break;
        } while (cvv.length() != 3 || !cvv.matches("\\d{3}"));
        System.out.println("DESEA CONFIRMAR SU METODO DE PAGO:  (SI/NO)");
        confirmar = esponja.nextLine();
        if (confirmar.equals("si") || confirmar.equals("SI")) {
            System.out.println("---------------OECHSLE---------------");
            System.out.println("Oechle----------03:30------08/07/2024");
            System.out.println("---------------caja:12---------------");
            System.out.println("-------------------------------------");
            System.out.println("VENTA:");
            detalles_pago = "PAGO FUE REALIZADO CON EXITO\n"
                    + "LA TRANSACCION FUE REALIZADA POR EL TITULAR: " + nombre
                    + "\nMONTO DESCONTADO A LA TARJETA: " + metodo + " -- " + fecha + " -- XXX";
            System.out.println(detalles_pago);
            System.out.println("-------------------------------------");
            System.out.println("-----GRACIAS POR VISITAR OECHSLE-----");
            System.out.println("-------------------------------------");
            System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
            volver = esponja.nextLine();
            if (volver.equals("si") || volver.equals("SI")) {
                System.out.println("MENU");
            }
        } else if (confirmar.equals("no") || confirmar.equals("NO")) {
            System.out.println("SU PAGO SE HA CANCELADO");
            System.out.println("¿DESEA CAMBIAR DE MÉTODO DE PAGO? (SI/NO)");
            volverr = esponja.nextLine();
            if (volverr.equals("si") || volverr.equals("SI")) {
                metodopago_efectivo();}
            if (volverr.equals("si") || volverr.equals("SI")) {
                metodopago_tarjeta();
            } else {
                System.out.println("SU PEDIDO SE HA CANCELADO");
                System.out.println("DESEA VOLVER AL MENU PRINCIPAL?? (SI/NO)");
                menu = esponja.nextLine();
                if (menu.equals("si") || menu.equals("SI")) {
                    System.out.println("MENU");
                } else {
                    System.out.println("GRACIAS POR VISITAR A OECHSLE");
                }
            }
        }
    }
    static void metodopago_efectivo() {
        Scanner esponja = new Scanner(System.in);
        double montoefectivo;
        System.out.println("INGRESE EL MONTO EN EFECTIVO");
        montoefectivo = esponja.nextDouble();
        System.out.println("------------OECHSLE------------");
        System.out.println("Oechle-----03:30-----08/07/2024");
        System.out.println("------------caja:12------------");
        System.out.println("-------------------------------");
        System.out.println("VENTA:");
        detalles_pago = "PAGO REALIZADO GRACIAS POR SU COMPRA"
                + "\nMonto entregado en efectivo: " + montoefectivo
                + "\nCambio devuelto: " + (montoefectivo - totalpagar);
        System.out.println(detalles_pago);
        System.out.println("-------------------------------");
        System.out.println("--GRACIAS POR VISITAR OECHSLE--");
        System.out.println("-------------------------------");
    }
    static void metodopago_factura() {
        Scanner esponja = new Scanner(System.in);
        double montoefectivo,dni,ruc;
        String name,dire;
        System.out.println("Ingresar su nombre");
        name= esponja.nextLine();
        System.out.println("Ingresar su dni");
        dni= esponja.nextDouble();
        System.out.println("Ingresar su RUC");
        ruc= esponja.nextDouble();
        System.out.println("Ingresar su direccion");
        dire= esponja.nextLine();
        System.out.println("INGRESE EL MONTO EN EFECTIVO");
        montoefectivo = esponja.nextDouble();
        System.out.println("------------OECHSLE------------");
        System.out.println("  JR   TUMBES   391 - JULIACA  ");
        System.out.println("-------------------------------");
        System.out.println("--fECHA DE EMISION:25/06/2024--");
        System.out.println("Nombre: " +name);
        System.out.println("DNI"+dni);
        System.out.println("RUC: " +ruc);
        System.out.println("Direccion:"+dire);
        System.out.println("Tipo de moneda: NUEVOS SOLES ");
        System.out.println("VENTA:");
        detalles_pago = "PAGO REALIZADO GRACIAS POR SU COMPRA\n"
                + "Monto entregado en efectivo: " + montoefectivo
                + "\nCambio devuelto: " + (montoefectivo - totalpagar);
        System.out.println(detalles_pago);
        System.out.println("-------------------------------");
        System.out.println("--GRACIAS POR VISITAR OSCHSLE--");
    }
    public static void exportarFactura(String categoria) {
        try {
            FileWriter factura = new FileWriter("factura.txt");
            factura.write("--------------OECHSLE--------------\n");
            factura.write("Oechle-------03:30-------08/07/2024\n");
            factura.write("--------------caja:12--------------\n");
            factura.write("Numero de perdido    213112515123-1\n");
            factura.write("-----------------------------------\n");
            factura.write("VENTA:\n");
            factura.write("-----------------------------------\n");
            factura.write("Categoría: " + categoria + "\n");
            factura.write("Total a pagar: S/ " + totalpagar + "\n");
            factura.write("Método de pago: " + metodo_de_pago_seleccionado + "\n");
            factura.write(detalles_pago + "\n");
            factura.write("-----------------------------------\n");
            factura.write("Vendedor:\n");
            factura.write("dk1162ef\n");
            factura.write("numero de serie:        11-49616862\n");
            factura.write("cod cajero:                    4230\n");
            factura.write("Nombre de cajero: DimasK.de la Cruz\n");
            factura.write("----------------IZYFAY-------------\n");
            factura.write("ID:                0000151920266314\n");
            factura.write("OECHSLE            JULIACA(1278398)\n");
            factura.write("  JR      TUMBES     391 -  JULIACA\n");
            factura.write("TERM 00614308                B8.652\n");
            factura.write("----GRACIAS POR VISITAR OECHSLE----\n");
            factura.write("-----------------------------------\n");
            factura.close();
            System.out.println("Factura exportada con éxito.");
        } catch (IOException C) {
            System.out.println("Ocurrió un error al exportar la factura.");
            C.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("presione enter");
        esponja frank = new esponja();
        frank.iniciar_sesion();
        frank.menu();
    }
}
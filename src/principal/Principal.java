package principal;

import api.ExchangeRangeApi;
import model.GeneradorArchivo;
import model.MonedaRec;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scannerMon = new Scanner(System.in);
        ExchangeRangeApi exRangeApi = new ExchangeRangeApi();
//        System.out.println("Ingrese Monto: ");

        System.out.println("\nBienvenido al sistema de conversión de monedas");

        System.out.println("\nMenu de opciones:");
        System.out.println("1. Convertir Monedas");
        System.out.println("2. Salir\n");
        System.out.println("Ingrese una opción: ");

        int opcion = scannerMon.nextInt();

        if (opcion == 1){
            try {
                System.out.println("\nIngrese Moneda Origen, max. 3 caracteres: ");
                String monOrigen = scannerMon.next().toUpperCase();
                System.out.println("Ingrese Moneda Destino, max. 3 caracteres: ");
                String monDest = scannerMon.next().toUpperCase();
                System.out.println("Ingrese Monto a Convertir: ");
                Double montoOrigen = scannerMon.nextDouble();
//            var montoLeido = Double.valueOf(leerMonto.nextLine());
                //Double montoDest = 0;

                MonedaRec monedaRec = exRangeApi.buscarMoneda(monOrigen,monDest,montoOrigen);
                //System.out.println(monedaRec);

                GeneradorArchivo generador = new GeneradorArchivo();
                generador.guardarJson(monedaRec);

                NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
                System.out.println("\n" + monOrigen +" $" + nf.format(Math.round(montoOrigen)) + " son " + monDest + " $" + nf.format(Math.round(monedaRec.conversion_result())));

                System.out.println("\n¡Conversión realizada con éxito! =)");

            } catch (RuntimeException | IOException e){
                System.out.println(e.getMessage());
                System.out.println("Error ---> Datos ingresados invalidos. ");
            }

        }else {
            scannerMon.close();
            System.out.println("\nHasta pronto...");
        }

    }
}

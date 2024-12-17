import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){

            int option = 1;

            String menu = """
                1 - Buscar alojamientos disponibles
                2 - Ver habitaciones disponibles
                3 - Crear una reserva
                4 - Ver registro de reservas
                5 - Actualizar una reserva
                                
                0 - Salir
                """;

            do{
                System.out.println("\n---------App Booking Hoteles----------- \n");
                System.out.println("Selecciona una opcion");
                System.out.println(menu);
                try{
                    option = input.nextInt();
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Debes ingresar un numero");
                    option = 7;
                }

                input.nextLine();

                switch (option) {
                    case 1:
                        searchLodging();
                        break;
                    case 0:
                        System.out.println("Cerrando aplicacion...");
                        break;

                    default:
                        System.out.println("opcion invalida");


                }
            }while (option !=0);

    }

    public static void searchLodging(){
        System.out.println("Buscando alojamientos disponibles...");
    }
}
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static List<Lodging> lodgingList = new ArrayList<>();

    public static void main(String[] args) {
        lodgingList = getLodgingList();

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
                        System.out.println("Ingrese la ciudad deseada: ");
                        String city = input.nextLine();
                        System.out.println("Ingrese el tipo del alojamiento deseado(Hotel, Apartamento, Finca, Dia de sol): ");
                        String lodgingName = convertToLodgingType(input.nextLine().toLowerCase());
                        System.out.println("Ingrese el dia de entrada: ");
                        Byte entryDay = input.nextByte();
                        System.out.println("Ingrese el dia de salida: ");
                        Byte endDay = input.nextByte();
                        System.out.println("Ingrese la cantidad de adultos: ");
                        Byte adults = input.nextByte();
                        System.out.println("Ingrese la cantidad de niños: ");
                        Byte children = input.nextByte();

                        searchLodging(city, lodgingName, entryDay, endDay, children, adults);
                        break;
                    case 0:
                        System.out.println("Cerrando aplicacion...");
                        break;

                    default:
                        System.out.println("opcion invalida");


                }
            }while (option !=0);

    }

    private static String convertToLodgingType(String lodgingName){
        if(lodgingName.equalsIgnoreCase("hotel")) {
            return "hotel";
        }else if(lodgingName.equalsIgnoreCase("apartamento")) {
            return "apartment";
        }else if (lodgingName.equalsIgnoreCase("finca")) {
            return "farm";
        }else{
            return "sunnyday";
        }

    }

    public static void searchLodging(String city, String lodgingName, Byte entryDay, Byte endDay, Byte children, Byte adults){
        System.out.println("------- Buscando alojamientos disponibles --------\n");

        for (Lodging lodging : lodgingList) {
            if(lodging.getCity().equalsIgnoreCase(city) && lodging.getClass().getSimpleName().equalsIgnoreCase(lodgingName)){
                System.out.printf("\nOpcion %d%n",lodgingList.indexOf(lodging) + 1);
                lodging.getDetails();
            }
        }
    }

    public static List<Lodging> getLodgingList(){
        List<Lodging> lodgingList = new ArrayList<>();

       lodgingList.add(new Hotel("Sunsol Caribe", "Margarita", 4.7F, 100.00));
       lodgingList.add(new Apartment("Casa Maya Guesthouse", "Margarita", 4.6F, 50.00));
       lodgingList.add(new Farm("Finca Maribel", "Margarita", 4.8F, 40.00));
       lodgingList.add(new Hotel("Hotel Hesperia Isla Margarita", "Margarita", 4.5F, 120.00));
       lodgingList.add(new Hotel("LD Hotel Palm Beach", "Margarita", 4.3F, 80.00));
       lodgingList.add(new Farm("Posada Bequeve", "Margarita", 4.6F, 60.00));
       lodgingList.add(new Apartment("Apartamento Kasa Karibe", "Margarita", 5.0F, 70.00));
       lodgingList.add(new SunnyDay("Cabaña Vacacional Bahía Dorada", "Margarita", 4.8F, 90.00));

       return lodgingList;
    }
}
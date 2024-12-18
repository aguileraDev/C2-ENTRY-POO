import java.time.LocalDate;
import java.util.*;

/**
 * @author Manuel Aguilera
 */
public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static List<Lodging> lodgingList = new ArrayList<>();
    private static Integer lodgingOption = 0;
    private static Room roomOption = null;
    private static Boolean haveLodging = false;
    private static Byte roomsNeeded = 0;

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
                        String lodgingType = convertToLodgingType(input.nextLine().toLowerCase());
                        System.out.println("Ingrese la fecha de inicio de la estadia (yyyy-mm-dd): ");
                        String entryDay = input.nextLine();
                        System.out.println("Ingrese la fecha del fin de la estadia (yyyy-mm-dd): ");
                        String endDay = input.nextLine();
                        System.out.println("Ingrese la cantidad de adultos: ");
                        Byte adults = input.nextByte();
                        System.out.println("Ingrese la cantidad de niños: ");
                        Byte children = input.nextByte();
                        System.out.println("Ingresa la cantidad de habitaciones que necesitas: ");
                        Byte rooms = input.nextByte();

                        searchLodging(city, lodgingType, entryDay, endDay, children, adults, rooms);
                        break;
                    case 2:
                        if(haveLodging){
                            printRoomsByLodging(roomsNeeded);
                        }else{
                            printLodgingList();
                            System.out.println("\n---Ingresa nombre de hospedaje");
                            String lodgingName = input.nextLine().toLowerCase();
                            printRoomsByLodging(lodgingName);
                        }
                        break;
                    case 3:
                        if(haveLodging){
                            registerBooking();
                        }else {
                            System.out.println("Debes seleccionar un alojamiento antes de iniciar una reserva. Selecciona la opcion 1");
                        }
                        break;
                    case 4:
                        printBookings();
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

    public static void searchLodging(String city, String lodgingType, String entryDay, String endDay, Byte children, Byte adults, Byte numberOfRooms){
        System.out.println("------- Buscando alojamientos disponibles --------\n");

        for (Lodging lodging : lodgingList) {
            if(lodging.getCity().equalsIgnoreCase(city) && lodging.getClass().getSimpleName().equalsIgnoreCase(lodgingType)){
                boolean haveRoomAvaibility = lodging.getRooms().stream().anyMatch(room -> room.getAvaibility() >= numberOfRooms);

                if (haveRoomAvaibility){
                System.out.printf("\nOpcion %d%n",lodgingList.indexOf(lodging) + 1);
                lodging.getDetails();
                }
            }
        }

        System.out.println("\nSelecciona una opcion de alojamiento");
        lodgingOption = (input.nextInt() - 1);
        input.nextLine();

        System.out.println("Haz seleccionado");
        System.out.println(lodgingList.get(lodgingOption).toString());
        haveLodging = true;
        roomsNeeded = numberOfRooms;

    }

    public static void printRoomsByLodging(String lodgingName){
        Lodging filteredLodging = lodgingList.stream().filter(lodging -> lodging.getName().equalsIgnoreCase(lodgingName))
                .findFirst()
                .orElse(null);

        if(filteredLodging != null) filteredLodging.getRooms().forEach(System.out::println);

    }

    public static void printRoomsByLodging(Byte numberOfRooms){
        System.out.println("Habitaciones disponibles en el alojamiento seleccionado:");

        List<Room> availableRooms = lodgingList.get(lodgingOption).getRooms().stream()
                .filter(room -> room.getAvaibility() >= numberOfRooms)
                .toList();

        availableRooms.forEach(System.out::println);
    }

    public static void printLodgingList(){
        System.out.println("------- Lista de alojamientos disponibles --------\n");
        for (Lodging lodging : lodgingList) {
            System.out.println(lodging.getName());
        }
    }

    public static void registerBooking(){

        Lodging selectedLodging = lodgingList.get(lodgingOption);

        System.out.print("Ingrese su nombre: ");
        String firstName = input.nextLine();
        System.out.print("Ingrese su apellido: ");
        String lastName = input.nextLine();
        System.out.print("Ingrese su correo electrónico: ");
        String email = input.nextLine();
        System.out.print("Ingrese su nacionalidad: ");
        String nationality = input.nextLine();
        System.out.print("Ingrese su fecha de nacimiento (yyyy-mm-dd): ");
        String birthDate = input.nextLine();
        System.out.print("Ingrese su número de teléfono: ");
        String phoneNumber = input.nextLine();

        System.out.println("------- Lista de habitaciones disponibles --------\n");
        printRoomsByLodging(selectedLodging.getName());

        System.out.println("Ingresa el numero de la habitación deseada: ");
        roomOption = selectedLodging.getRooms().get(input.nextInt() - 1);

        System.out.print("Cuantas habitaciones desea reservar: ");
        Integer numberOfRooms = input.nextInt();
        input.nextLine();

        System.out.print("Ingrese su hora aproximada de llegada (HH:mm): ");
        String estimatedArrivalTime = input.nextLine();


        User user = new User(firstName, lastName, email, nationality, phoneNumber, LocalDate.parse(birthDate));

        Booking booking = new Booking(user, selectedLodging, roomOption, estimatedArrivalTime, numberOfRooms);

        Boolean attemptSaveBooking = booking.reduceRoomAvailability(roomOption.getId(), numberOfRooms);

        String message = attemptSaveBooking ? ("Reserva realizada con exito"):("No se pudo realizar la reserva");

        selectedLodging.addBooking(booking);

        System.out.printf("%s%n", message);

    }

    public static void printBookings(){
        Boolean existBookings = lodgingList.stream().anyMatch(lodging -> !lodging.getBookings().isEmpty());

        if(!existBookings){
            System.out.println("No se encontraron reservas realizadas.");
            return;
        }

        for (Lodging lodging : lodgingList) {
            if(!lodging.getBookings().isEmpty()){
                System.out.println("------- Reservas realizadas en " + lodging.getName() + " --------\n");
                lodging.getBookings().forEach(System.out::println);
            }
        }

    }

    public static List<Lodging> getLodgingList(){
        List<Lodging> lodgingList = new ArrayList<>();

        Hotel sunsol = new Hotel("Sunsol Caribe", "Margarita", 4.7F, 100.00);
        sunsol.addRoom(new Room(1,"Simple", "1 cama sencilla, aire acondicionado, escritorio, TV", 80.00, 10));
        sunsol.addRoom(new Room(2,"Doble", "2 camas dobles, vista al mar, aire acondicionado, TV", 150.00, 8));
        sunsol.addRoom(new Room(3,"Suite", "1 cama King, jacuzzi, minibar, aire acondicionado, TV", 300.00, 5));
        sunsol.addRoom(new Room(4,"Familiar", "3 camas dobles, sala de estar, cocina equipada, aire acondicionado, TV", 250.00, 4));
        sunsol.addRoom(new Room(5,"Premium", "2 camas Queen, terraza privada, jacuzzi, minibar", 400.00, 2));

        lodgingList.add(sunsol);

        Hotel hesperia = new Hotel("Hotel Hesperia Isla Margarita", "Margarita", 4.5F, 120.00);
        hesperia.addRoom(new Room(1,"Estandar", "1 cama Queen, aire acondicionado, escritorio, TV", 100.00, 12));
        hesperia.addRoom(new Room(2,"Deluxe", "1 cama King, balcón con vista al mar, minibar, aire acondicionado", 180.00, 6));
        hesperia.addRoom(new Room(3,"Junior Suite", "1 cama King, sala pequeña, minibar, TV de pantalla plana", 250.00, 4));
        hesperia.addRoom(new Room(4,"Suite Ejecutiva", "1 cama King, sala de estar, jacuzzi, minibar, aire acondicionado", 350.00, 3));
        hesperia.addRoom(new Room(5,"Suite Presidencial", "1 cama King, terraza privada, piscina exclusiva, aire acondicionado", 500.00, 1));

        lodgingList.add(hesperia);


        Farm fincaMaribel = new Farm("Finca Maribel", "Margarita", 4.8F, 40.00);
        fincaMaribel.addRoom(new Room(1,"Rústica Simple", "1 cama sencilla, ventilador, escritorio, baño privado", 50.00, 10));
        fincaMaribel.addRoom(new Room(2,"Rústica Familiar", "2 camas dobles, pequeña cocina, aire acondicionado, TV", 120.00, 5));
        fincaMaribel.addRoom(new Room(3,"Cabaña Rústica", "1 cama Queen, terraza con hamaca, minibar", 150.00, 3));
        fincaMaribel.addRoom(new Room(4,"Cabaña Deluxe", "1 cama King, terraza privada con vista al jardín, cocina equipada", 200.00, 2));
        fincaMaribel.addRoom(new Room(5,"Cabaña Premium", "1 cama King, sala de estar, jacuzzi exterior, minibar", 300.00, 1));

        lodgingList.add(fincaMaribel);


        Apartment casaMaya = new Apartment("Casa Maya Guesthouse", "Margarita", 4.6F, 50.00);
        casaMaya.addRoom(new Room(1,"Estudio", "1 cama Queen, cocina pequeña, aire acondicionado, TV", 90.00, 7));
        casaMaya.addRoom(new Room(2,"Loft", "1 cama King, sala de estar, cocina equipada", 130.00, 5));
        casaMaya.addRoom(new Room(3,"Penthouse", "1 cama King, terraza privada, jacuzzi, cocina equipada", 300.00, 2));
        casaMaya.addRoom(new Room(4,"Dúplex", "2 camas matrimoniales, cocina, sala de estar, aire acondicionado", 180.00, 3));
        casaMaya.addRoom(new Room(5,"Estudio Premium", "1 cama Queen, minibar, aire acondicionado", 120.00, 4));

        lodgingList.add(casaMaya);


        SunnyDay bahiaDorada = new SunnyDay("Cabaña Vacacional Bahía Dorada", "Margarita", 4.8F, 90.00);
        bahiaDorada.addRoom(new Room(1,"Cabaña Básica", "1 cama Queen, ventilador, baño privado, terraza", 80.00, 10));
        bahiaDorada.addRoom(new Room(2,"Cabaña Familiar", "2 camas dobles, sala pequeña, cocina equipada", 150.00, 6));
        bahiaDorada.addRoom(new Room(3,"Cabaña Deluxe", "1 cama King, jacuzzi privado, aire acondicionado, minibar", 200.00, 3));
        bahiaDorada.addRoom(new Room(4,"Cabaña Suite", "1 cama King, terraza privada con hamaca, minibar", 250.00, 2));
        bahiaDorada.addRoom(new Room(5,"Cabaña Presidencial", "1 cama King, terraza exclusiva, piscina privada, jacuzzi", 400.00, 1));

        SunnyDay.Activities snorkeling = new SunnyDay.Activities("Snorkeling", "Explora los arrecifes de coral con guía profesional");
        SunnyDay.Activities kayaking = new SunnyDay.Activities("Kayak", "Disfruta de un recorrido en kayak por la bahía");
        SunnyDay.Activities hiking = new SunnyDay.Activities("Senderismo", "Recorre los senderos naturales de la zona");

        bahiaDorada.addActivity(snorkeling);
        bahiaDorada.addActivity(kayaking);
        bahiaDorada.addActivity(hiking);

        lodgingList.add(bahiaDorada);

        Farm posadaBequeve = new Farm("Posada Bequeve", "Margarita", 4.6F, 60.00);
        posadaBequeve.addRoom(new Room(1,"Habitación Básica", "1 cama Queen, ventilador, baño privado", 70.00, 8));
        posadaBequeve.addRoom(new Room(2,"Habitación Familiar", "2 camas matrimoniales, cocina equipada, aire acondicionado", 140.00, 5));
        posadaBequeve.addRoom(new Room(3,"Cabaña Rústica", "1 cama King, minibar, aire acondicionado", 180.00, 4));
        posadaBequeve.addRoom(new Room(4,"Cabaña Deluxe", "1 cama King, jacuzzi, terraza privada, cocina equipada", 250.00, 2));
        posadaBequeve.addRoom(new Room(5,"Cabaña Premium", "1 cama King, sala de estar, jacuzzi exterior, minibar", 320.00, 1));

        lodgingList.add(posadaBequeve);

        Apartment kasaKaribe = new Apartment("Apartamento Kasa Karibe", "Margarita", 5.0F, 70.00);
        kasaKaribe.addRoom(new Room(1,"Estudio Básico", "1 cama Queen, cocina básica, TV", 90.00, 10));
        kasaKaribe.addRoom(new Room(2,"Loft Familiar", "2 camas matrimoniales, cocina equipada, aire acondicionado", 150.00, 6));
        kasaKaribe.addRoom(new Room(3,"Penthouse", "1 cama King, terraza con vista al mar, jacuzzi", 300.00, 2));
        kasaKaribe.addRoom(new Room(4,"Dúplex", "2 camas matrimoniales, sala y cocina completa", 180.00, 3));
        kasaKaribe.addRoom(new Room(5,"Estudio Premium", "1 cama King, minibar, aire acondicionado, TV", 120.00, 4));

        lodgingList.add(kasaKaribe);

        Hotel ldPalmBeach = new Hotel("LD Hotel Palm Beach", "Margarita", 4.3F, 80.00);
        ldPalmBeach.addRoom(new Room(1,"Económica", "1 cama matrimonial, aire acondicionado, TV", 60.00, 12));
        ldPalmBeach.addRoom(new Room(2,"Estándar", "1 cama Queen, balcón con vista parcial al mar, aire acondicionado", 100.00, 8));
        ldPalmBeach.addRoom(new Room(3,"Deluxe", "1 cama King, minibar, aire acondicionado, vista al mar", 150.00, 6));
        ldPalmBeach.addRoom(new Room(4,"Junior Suite", "1 cama King, sala pequeña, balcón con vista al mar, minibar", 200.00, 3));
        ldPalmBeach.addRoom(new Room(5,"Suite Ejecutiva", "1 cama King, sala de estar, jacuzzi, terraza privada con vista al mar", 300.00, 2));

        lodgingList.add(ldPalmBeach);

        return lodgingList;
    }
}
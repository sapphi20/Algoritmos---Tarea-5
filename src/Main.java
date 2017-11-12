import java.util.Scanner;

public class Main {

    //imprime la tabla de hash despues de haber insertado un valor
    public static String insertAux(Hash dic, int value) {
        try {
            dic.insert(value);
            return dic.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //imprime la tabla de hash despues de hacer eliminado un valor
    public static String deleteAux(Hash dic, int value) {
        try {
            dic.delete(value);
            return dic.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            if (in.isEmpty())
                break;
            String[] input = in.split(" ");
            String hashTec = input[0]; //numero de la tecnica de hash a utilizar
            int m = Integer.parseInt(input[1]); //capacidad de la tabla
            if (hashTec.equals("1")) {
                LinearProbing table = new LinearProbing(m);
                for (int i = 2; i < input.length; i++) {
                    int yo = Integer.parseInt(input[i]);
                    if (yo > 0) {
                        System.out.println(insertAux(table, yo));
                    } else {
                        System.out.println(deleteAux(table, Math.abs(yo)));
                    }
                }
                System.out.println();

            }
            if (hashTec.equals("2")) {
                RobinHood table = new RobinHood(m);
                for (int i = 2; i < input.length; i++) {
                    int yo = Integer.parseInt(input[i]);
                    if (yo > 0) {
                        System.out.println(insertAux(table, yo));
                    } else {
                        System.out.println(deleteAux(table, Math.abs(yo)));
                    }
                }
                System.out.println();
            }
        }
    }
}

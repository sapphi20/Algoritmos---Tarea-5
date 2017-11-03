import java.util.Scanner;

public class Main {

    public static String insert2(Hash dic, int value) {
        try {
            dic.insert(value);
            return dic.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String delete2(Hash dic, int value) {
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
            String[] input = sc.nextLine().split(" ");
            String hashTec = input[0]; //numero de la tecnica de hash a utilizar
            int m = Integer.parseInt(input[1]); //tamaño de la tabla
            if (hashTec.equals("1")) {
                LinearProbing table = new LinearProbing(m);
                for (int i = 2; i < input.length; i++) {
                    int yo = Integer.parseInt(input[i]);
                    if (yo > 0)
                        System.out.println(insert2(table, yo));
                    else
                        System.out.println(delete2(table, Math.abs(yo)));
                }
            }
        }
        //if (hashTec.equals("2")) {
        //hace cosas con Robin Hood
    }
}

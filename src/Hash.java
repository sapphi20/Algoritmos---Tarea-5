public class Hash {
    static String[] values; //los valores de la tabla de hash
    static int elementos; //el numero de espacios ocupados en la tabla de hash
    static int m;

    public Hash(int size) {
        m = size;
        values = new String[size];
        for (int i = 0; i < size; i++)
            values[i] = "0";
    }

    @Override
    public String toString() {
        return String.join(" ", values);
    }


    public void insert(int x) throws Exception {

    }

    public void delete(int x) throws Exception {

    }
}

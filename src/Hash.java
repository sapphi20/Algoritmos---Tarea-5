public class Hash {
    static String[] values; //los valores de la tabla de hash
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

    //verifica si el valor esta en la tabla o no
    //entrega true si esta
    private boolean search(int x, int realx) {
        int i = x % m;
        if (values[i].equals(Integer.toString(realx))) {
            return true;
        } else if (values[i].equals("0")) {
            return false;
        } else {
            return search(x + 1, realx);
        }
    }

    public void insert(int x) throws Exception {

    }

    public void delete(int x) throws Exception {
        delete(x, x);
    }

    /*delete elimina un valor por lazy deletion, dejando una X donde se elimina el valor
    * realx se usa para no perder el valor a eliminar en el llamado recursivo */
    private void delete(int x, int realx) throws Exception {
        int i = x % m;
        if (!search(x, realx)) throw new Exception("ERROR: valor no existe");
        if (values[i].equals(Integer.toString(realx)))
            values[i] = "X";
        else
            delete(x + 1, realx);
    }


}

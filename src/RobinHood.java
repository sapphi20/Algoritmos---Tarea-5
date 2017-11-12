public class RobinHood extends Hash {
    public RobinHood(int size) {
        super(size);
    }

    private void insert(int x, int realx) throws Exception {
        int i = x % m;
        if (values[i].equals("0") || values[i].equals("X")) {
            values[i] = Integer.toString(realx);
        } else if (values[i].equals(Integer.toString(realx))) {
            throw new Exception("ERROR: valor ya existe");
        } else {
            int a = Integer.parseInt(values[i]); //el valor que esta ocupando el casillero
            int b = realx; //el que estoy tratando de insertar
            int da = distance(a, i); //distancia del valor que ya esta en la tabla
            int db = distance(b, i);//distancia del valor que quiero insertar
            if (da > db) {
                //no intercambiar
                insert(x + 1, realx);
            } else {
                //intercambio valores
                int t = a;
                values[i] = "" + b; //a = b
                b = t;
                insert(i + 1, b); //inserto el valor que estaba originalmente en el casillero
            }
        }
    }

    /*entrega la distancia a la que esta x de su posicion original */
    private int distance(int x, int pos) {
        return Math.abs(x % m - pos); //pos es la posicion actual
    }


    @Override
    public void insert(int x) throws Exception {
        insert(x, x);
    }

}

public class RobinHood extends Hash {
    public RobinHood(int size) {
        super(size);
    }

    private void insert(int x, int realx) throws Exception {
        //crear arreglo con llaves/edades/algo que marque distancia, ya que puede dar la vuelta
        int i = x % m;
        if (values[i].equals("0") || values[i].equals("X")) {
            values[i] = Integer.toString(realx);
        } else if (values[i].equals(Integer.toString(realx))) {
            throw new Exception("ERROR: valor ya existe");
        } else {
            //debo insertar?
            //-> swap de los valores
            //-> recursion con valor antiguo
            int a = Integer.parseInt(values[i]); //el valor que esta ocupando el casillero
            int b = realx; //el que estoy tratando de insertar
            int da = distance(a, a % m); //distancia del valor que ya esta en la tabla
            int db = distance(b, b % m);//distancia del valor que quiero insertar
            if (da > db) { //TODO: hacer que tire lo que deberia dar
                //no intercambiar
                insert(x+1, realx);
            } else {
                //swap
                int t = a;
                values[i] = ""+b; //a = b
                b = t;
                insert(b+1 , realx); //insert(b+1,b)
            }
        }

    }

    private int distance(int x, int pos) {
        return Math.abs(x % m - pos); //pos es la posicion actual
    }


    @Override
    public void insert(int x) throws Exception {
        insert(x, x);
    }
}

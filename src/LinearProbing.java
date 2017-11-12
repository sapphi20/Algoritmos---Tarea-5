public class LinearProbing extends Hash {

    LinearProbing(int size) {
        super(size);
    }

    /*insert agrega un valor a la tabla,
        se usa realx para no perder el valor a insertar en caso de llegar al llamado recursivo*/
    private void insert(int x, int realx) throws Exception {
        int i = x % m;
        //valor ya existe
        if (search(realx, realx)) {
            throw new Exception("ERROR: valor ya existe");
        }
        if (values[i].equals("0") || values[i].equals("X")) //casillero esta vacio
        {
            values[i] = Integer.toString(realx);
        } else //casillero esta ocupado por un valor distinto a x
            insert(x + 1, realx);

    }

    @Override
    public void insert(int x) throws Exception {
        insert(x, x);
    }

}

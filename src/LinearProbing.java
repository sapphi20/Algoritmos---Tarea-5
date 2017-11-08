public class LinearProbing extends Hash {

    LinearProbing(int size) {
        super(size);
    }

    /*insert agrega un valor a la tabla,
        se usa realx para no perder el valor a insertar en caso de llegar al llamado recursivo*/
    private void insert(int x, int realx) throws Exception {
        int i = x % m;
        if (values[i].equals(Integer.toString(realx)))
            throw new Exception("ERROR: valor ya existe");
        if (values[i].equals("0") || values[i].equals("X"))
            values[i] = Integer.toString(realx);
        else
            insert(x + 1, realx);

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

    /*delete elimina un valor por lazy deletion, dejando una X donde se elimina el valor
     * realx se usa con el mismo principio que en insert */
    private void delete(int x, int realx) throws Exception {
        int i = x % m;
        if (!search(x, realx)) throw new Exception("ERROR: valor no existe");
        if (values[i].equals(Integer.toString(realx)))
            values[i] = "X";
        else
            delete(x + 1, realx);
    }


    @Override
    public void insert(int x) throws Exception {
        insert(x, x);
    }

    @Override
    public void delete(int x) throws Exception {
        delete(x, x);
    }
}

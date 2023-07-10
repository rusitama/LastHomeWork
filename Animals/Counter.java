package Animals;

// Класс Счетчик
class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add() {
        count++;
    }

    @Override
    public void close() throws Exception {
        if (count == 0) {
            throw new Exception("Ресурс не был закрыт или работа с объектом не была в блоке try-with-resources");
        }
    }
}
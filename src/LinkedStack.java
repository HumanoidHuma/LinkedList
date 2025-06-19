public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        int value = tail.getValue();
        Node prevNode = tail.getPrev();
        tail = prevNode;
        return value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (tail == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (isEmpty()) {
            return "EMPTY";
        }

        StringBuilder sb = new StringBuilder();
        Node prev = tail;
        while (prev != null) {
            sb.append(prev.getValue());
            prev = prev.getPrev(); // 25 -> 15 -> 5
            if (prev != null) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}

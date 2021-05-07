package ru.job4j.tree;
//1. Создать элементарную структуру дерева [#455152]
//import java.util.LinkedList;
//import java.util.Optional;
//import java.util.Queue;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        Optional<Node<E>> rsl = Optional.empty(); //возвращает пустой экземпляр
        Queue<Node<E>> data = new LinkedList<>(); // очередь на связном списке
        int count = 0;
        boolean result = false;
        return result;
    }

    private Optional<Node> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node> rsl = Optional.empty();
        condition.test(root);
        return rsl;

    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Node<E> chTest = new Node<>(child);
        Node<E> pareTest  = new Node<>(parent);
        if (findBy(parent).isPresent() && !findBy(child).isPresent()) {
            findBy(parent).get().children.add(chTest);
            rsl = true;
        } else {
            root.children.add(chTest);
            rsl = true;
        }

        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty(); //возвращает пустой экземпляр
        Queue<Node<E>> data = new LinkedList<>(); // очередь на связном списке
        data.offer(this.root); //добавляем Node в очередь
        while (!data.isEmpty()) { // выполняется пока не пустая
            Node<E> el = data.poll(); // резервная Noda со значением из головы очереди, удаляя его
            if (el.value.equals(value)) { // если в резервной ноде значение равно значению передаваемом в методе
                rsl = Optional.of(el); // оптионал снабжается не нулевым значением
                break; // объект найден стоп
            }
            data.addAll(el.children); // в очередь возвращается значение и помещается в массив с сылкой на ребенока
        }
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTree<?> that = (SimpleTree<?>) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

}

package ru.job4j.tree;
//1. Создать элементарную структуру дерева [#455152]
//2. Добавить метод boolean isBinary() [#1712 #69343]
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

    @Override
    public boolean isBinary() {
        //Predicate<Node<E>> predicate = eNode -> eNode.children.size() > 2;
        //return findByPredicate(predicate).isPresent();
        return !(findByPredicate(eNode -> eNode.children.size() > 2)).isPresent();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parrentNode = findBy(parent);
        if (parrentNode.isPresent() &&  findBy(child).isEmpty()) {
            parrentNode.get().children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
//        Optional<Node<E>> rsl = Optional.empty(); //возвращает пустой экземпляр
//        Queue<Node<E>> data = new LinkedList<>(); // очередь на связном списке
//        Predicate<Node<E>> predicate = eNode -> eNode.value.equals(value);
//        data.offer(this.root); //добавляем Node в очередь
//        while (!data.isEmpty()) { // выполняется пока не пустая
//            Node<E> el = data.poll(); // резервная Noda со значением из головы очереди, удаляя его
//            if (el.value.equals(value)) { // если в резервной ноде значение равно значению передаваемом в методе
//                rsl = Optional.of(el); // оптионал снабжается не нулевым значением
//                break; // объект найден стоп
//            }
//            data.addAll(el.children); // в очередь возвращается значение и помещается в массив с сылкой на ребенока
//        }
//        return rsl;

        return findByPredicate(eNode -> eNode.value.equals(value));
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

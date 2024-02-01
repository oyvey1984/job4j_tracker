package ru.job4j.train.pattern.factory;

import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Collect implements Iterable {
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}

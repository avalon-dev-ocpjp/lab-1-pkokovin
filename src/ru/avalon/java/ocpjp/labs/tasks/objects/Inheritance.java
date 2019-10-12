package ru.avalon.java.ocpjp.labs.tasks.objects;

import java.io.IOException;
import ru.avalon.java.ocpjp.labs.Exercise;
import ru.avalon.java.ocpjp.labs.common.ObjectWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Задание, направленное на изучение следующих тем:
 * 1. наследование;
 * 2. полиморфизм;
 * 3. использование коллекции ArrayList
 */
public final class Inheritance implements Exercise {

    /**
     * Объект, выполняющий сравнение объектов типа
     * {@link Citizen}.
     */
    private Comparator<Citizen> comparator;

    /**
     * Источник случайного набора экземпляров класса
     * {@link Citizen}.
     * <p>
     * Объектов в источнике должно быть случайное количечство
     * в диапазоне от {@code 20} до {@code 30}.
     * <p>
     * Формировать экземпляры следует с использованием данных
     * словарей, расположенных в пакете
     * {@link ru.avalon.java.ocpjp.labs.resources}.
     */
    private Iterable<Citizen> source;

    /**
     * Объект, отвечающий за вывод экземпляров {@link Citizen}
     * в консоль.
     */
    private ObjectWriter<Citizen> writer;

    public Inheritance() throws IOException {
        comparator = new CitizenComparator();
        source = new CitizenSource();
        writer = new CitizenWriter();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        List<Citizen> citizens = new ArrayList<>();

        // Добавлены все элементы, доступные в объекте source, в коллекцию citizens

        // Отсортирован список citizens перед выводом в поток

        // Пользуясь объектом writer выведен список citizens в консоль
        
        for (Citizen citizen : source) {  // Добавлены все элементы, доступные в объекте source, в коллекцию citizens
            citizens.add(citizen);
        }

        Collections.sort(citizens, comparator);  // Отсортирован список citizens перед выводом в поток

        citizens.forEach((citizen) -> {          // Пользуясь объектом writer выведен список citizens в консоль
            try {
                writer.write(citizen);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
}

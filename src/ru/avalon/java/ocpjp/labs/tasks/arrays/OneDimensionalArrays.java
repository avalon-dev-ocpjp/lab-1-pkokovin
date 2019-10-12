package ru.avalon.java.ocpjp.labs.tasks.arrays;

import ru.avalon.java.ocpjp.labs.Exercise;
import ru.avalon.java.ocpjp.labs.common.Factory;
import ru.avalon.java.ocpjp.labs.common.ObjectWriter;

import java.io.IOException;

/**
 * Задание, направленное на получение умений и навыков объявления и
 * использования одномерных массивов.
 */
public final class OneDimensionalArrays implements Exercise {

    /**
     * Фабрика, создающая одномерный массив случайной длины, содержащие
     * случайные числа в интервале от {@code 0} до {@code 100}.
     * <p>
     * Длина массивов должна колебаться в диапазоне от 10, до 20 элементов.
     */
    private Factory<int[]> factory;

    /**
     * Выполняет сортировку одномерного массива по возрастанию.
     */
    private Sort<int[]> sort;

    /**
     * Объект, отвечающий за вывод одномерного массива в консоль.
     * <p>
     * Массив следет выводить в одну строку, разделяя элементы массива запятыми
     * и пробелами. Массив должен быть заключён в квадратные скобки.
     * <p>
     * Например: {@code [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}
     */
    private ObjectWriter<int[]> writer;

    public OneDimensionalArrays() {
        // Выполнена инициализацию полей класса OneDimensionalArrays
        factory = new OneFactoryArrays();
        sort = new SortOneArrays();
        writer = new OneArraysWriter();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        int[] array = factory.create();
        sort.run(array);
        writer.write(array);
    }
    
}

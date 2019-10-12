package ru.avalon.java.ocpjp.labs;

import java.io.IOException;
import java.net.URISyntaxException;

public class Lab {

    /**
     * Точка входа в приложение.
     * <p>
     * При входе в приложение, выполняется создание получение
     * экземпляра задания с использованием фабричного метода
     * {@code create} интерфейса {@link Exercise}.
     *
     * @param args аргументы командной строки
     */
    public static void main(String ... args) throws IOException {
//        String[] ar = {"-e", "Inheritance"};
        Exercise exercise = Exercise.create(args);
        try {
            exercise.run();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        /*
         * Пользуясь терминалом, запусщены все задания лабораторной работы
         * 1. Запустить задание OneDimensionalArrays
         * 2. Запустить задание TwoDimensionalArrays
         * 3. Запустить задание Inheritance
         */
    }
}

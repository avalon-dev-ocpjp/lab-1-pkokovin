package ru.avalon.java.ocpjp.labs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.avalon.java.ocpjp.labs.tasks.arrays.OneDimensionalArrays;
import ru.avalon.java.ocpjp.labs.tasks.arrays.TwoDimensionalArrays;
import ru.avalon.java.ocpjp.labs.tasks.objects.Inheritance;

/**
 * Абстратное представление об упражнении.
 */
public interface Exercise {
    
    final class Patterns {
        public static Pattern EXERCISE;
        
        static {
            EXERCISE = Pattern.compile("^/e|-e|/exercise|-exercise$");
        }
    }

    /**
     * Тело упражнения.
     * <p>
     * Содержит основной код упражнения.
     *
     * @throws Exception в случае возникновения исключительной
     * ситуации
     */
    void run() throws Exception;

    /**
     * Фабричный метод, порождающий задания на основании
     * переданых аргументов командной строки.
     * <p>
     * Пользователь должен передавать название задания,
     * с использованием аргумента {@code /exercise},
     * {@code -exercise}, {@code /e} или {@code -e}.
     * <p>
     * Например:
     * {@code java -jar lab1.jar -e comparison}
     * где: <b>{@code syntax}</b> - название задания, которое
     * следует запустить.
     *
     * @param args аргументы командной строки
     * @return Экземпляр класса, реализующего задание
     */
    static Exercise create(String[] args) throws IOException {
       for (int i = 0; i < args.length; i++) {
            Matcher matcher = Patterns.EXERCISE.matcher(args[i]);
            if (matcher.matches()) {
                if (++i == args.length) {
                    throw new IllegalArgumentException("Something wrong");
                }
                switch (args[i]) {
                    case "OneDimensionalArrays":
                        return new OneDimensionalArrays();
                        
                    case "TwoDimensionalArrays":
                        return new TwoDimensionalArrays();
                     
                    case "Inheritance":
                        return new Inheritance();
                }
            }
        }
        throw new IllegalArgumentException("Something wrong");
    }
}

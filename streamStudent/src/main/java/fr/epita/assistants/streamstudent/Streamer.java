package fr.epita.assistants.streamstudent;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.StreamSupport.stream;

public class Streamer {
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {
        return stream.filter(i -> i.getKey() >= 0 && i.getKey() <= 100).filter(i -> i.getValue().matches("[a-zA-Z]*[" +
                ".|_][a-zA-Z]*"));
    }

    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        stream = stream.sorted((i, j) -> i.getValue().compareTo(j.getValue()));
        return stream.sorted((i, j) -> i.getKey().compareTo(j.getKey()));
    }

    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        return stream.map(i -> {
            if (!(i.getValue().matches("[a-z]*[.|_][a-z]*"))) {
                var pair = new Pair<>(i.getKey() / 2, i.getValue().toLowerCase());
                return pair;
            }
            return i;
        });
    }

    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        return stream.reduce((i, j) -> {
            if (i.getKey() > j.getKey()) {
                return i;
            }
            if (i.getKey() < j.getKey())
                return j;
            if (i.getValue().compareTo(j.getValue()) > 0)
                return j;
            return i;
        });
    }

    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return stream.map(i -> {
            if ((i.getValue().matches("[m|M][a|A].*|[l|L].*[x|X]"))) {
                int grade = i.getKey() * 2;
                if (grade > 100)
                    grade = 100;
                var pair = new Pair<>(grade, i.getValue());
                return pair;
            }
            return i;
        });
    }
    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return stream.map(i-> {String str = i.getValue();
                str =  str.substring(str.length() / 2, str.length()) + str.substring(0, str.length() / 2);
                return new Pair<>(i.getKey(), str);
        });
    }
    public static void main(String[] args) {
        var pair1 = new Pair<>(10, "tigrou_c");
        var pair2 = new Pair<>(60, "login_x");

        Streamer streamer = new Streamer();
        Stream stream = Stream.of(pair1, pair2);
        stream = streamer.encryption(stream);
        stream.forEach(System.out::println);
    }
}

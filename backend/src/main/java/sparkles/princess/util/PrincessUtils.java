package sparkles.princess.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PrincessUtils {
    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}

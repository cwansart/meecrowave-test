package de.cwansart.meecrowave.domain;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class HelloRepository {

    private List<String> names = Arrays.asList(
            "Hello",
            "Hallo",
            "こんにちは",
            "Hallå",
            "Здравствуйте",
            "Hola"
    );

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}

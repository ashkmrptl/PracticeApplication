import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    static class Person {
        private Integer id;

        public Person(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    static class PersonDTO {
        private Integer id;

        public PersonDTO(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        List<PersonDTO> personDTOS = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person(i));
        }
        for (int i = 4; i < 6; i++) {
            personDTOS.add(new PersonDTO(i));
        }
        List<Integer> failedIds = personDTOS.stream()
                .map(personDTO -> personDTO.getId()).collect(Collectors.toList());
        persons.stream().filter(person -> !failedIds.contains(person.getId()))
                .forEach(e -> System.out.print(e.getId() + " "));

    }
}

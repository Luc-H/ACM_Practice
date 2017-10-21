import java.util.*;

public class problemD2 {

    static int n;
    static LinkedList<Person> people;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while ((n = input.nextInt()) != -1) {
            people = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                people.add(new Person());
            }

            for (Person person : people) {
                person.p = input.nextInt();
            }

            Person lastPerson = people.getLast();

            for (Person person : people) {
                person.previous = lastPerson;
                lastPerson.next = person;

                person.t = input.nextInt();
                person.calcTime();

                lastPerson = person;
            }

            Collections.sort(people);

            Person firstPerson = people.getFirst();

            while (people.size() > 0) {
                int time = people.getFirst().time;

                Iterator<Person> iterator = people.iterator();

                Person myPerson;

                while (iterator.hasNext()) {


                    myPerson = iterator.next();
                    if (myPerson.toDelete) {
                        iterator.remove();
                        continue;
                    }

                    if (myPerson.time > time) {
                        break;
                    }

                    myPerson.fallen = true;
                    iterator.remove();
                    myPerson.next.toDelete = true;
                }
            }

            Person currentPerson = firstPerson;

            for (int j = 0; j < n; j++) {
                if (!currentPerson.fallen) {
                    System.out.print(j + " ");
                }

                currentPerson = currentPerson.next;
            }
        }
    }

    private static class Person implements Comparable<Person>{
        int t;
        int p;
        boolean fallen = false;
        int time;
        public Person previous;
        public Person next;

        boolean toDelete = false;

        public void calcTime() {
            time = p * previous.t;
        }

        @Override
        public int compareTo(Person person) {
            return Integer.compare(time, person.time);
        }
    }
}

import java.util.LinkedList;
import java.util.Scanner;

public class problemH {

    static Town[] towns;
    static int n;

    static int routeCount;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while ((n = input.nextInt()) != -1) {

            towns = new Town[n];
            routeCount = 0;

            for (int i = 0; i < n; i++) {
                towns[i] = new Town(input.nextInt());
            }

            for (int i = 0; i < n - 1; i++) {
                int pi = input.nextInt() - 1;
                towns[i].connectedTowns.add(towns[pi]);
                towns[pi].connectedTowns.add(towns[i]);
            }

            for (int i = 0; i < n; i++) {
                visit(towns[i], 2);
                towns[i].startedOn = true;
            }

            System.out.println(routeCount - n);
        }
    }

    private static void visit(Town town, int typeCount) {

        town.visited = true;

        routeCount++;

        for (Town nextTown: town.connectedTowns) {
            if (!nextTown.startedOn && !nextTown.visited) {
                if (town.type == nextTown.type) {
                    if (typeCount > 1) {
                        visit(nextTown, typeCount--);
                    }
                } else {
                    visit(nextTown, 2);
                }
            }
        }

        town.visited = false;
    }

    private static class Town {
        public int type;
        public boolean startedOn;
        public boolean visited;
        public LinkedList<Town> connectedTowns = new LinkedList<>();

        public Town(int type) {
            this.type = type;
            startedOn = false;
            visited = false;
        }
    }
}

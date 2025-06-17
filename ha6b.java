import java.util.Scanner;

public class ha6b {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        d drone = new d();

        while (true) {
            System.out.println("Enter a command:");
            String input = scan.nextLine();

            drone.ha(input);
        }
    }

    interface State {
        void ha(d context, String input);
    }

    public static class d {
        private State state;

        public d() {
            this.state = new DronePad();
        }

        public void ha(String input) {
            state.ha(this, input);
        }

        public void set(State newState) {
            this.state = newState;
        }
    }

    public static class DronePad implements State {

        public void ha(d context, String input) {
            System.out.println("Current state: DronePad");

            if (input.equals("turnon()")) {
                System.out.println("Switching to StandbyMode");
                context.set(new StandbyMode());
            } else {
                System.out.println("Invalid command in DronePad state");
            }
        }
    }

    public static class StandbyMode implements State {

        public void ha(d context, String input) {
            System.out.println("Current state: StandbyMode");

            if (input.equals("turnoff()")) {
                System.out.println("Switching back to DronePad");
                context.set(new DronePad());
            } else if (input.equals("generateRoute()")) {
                context.set(new DroneGenerate());
                System.out.println("Switching to DroneGenerate");
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public static class DroneGenerate implements State {
        public void ha(d context, String input) {
            System.out.println("Current state: DroneGenerate");

            if (input.equals("abort path planning()")) {
                context.set(new StandbyMode());
                System.out.println("Switching to StandbyMode");
            } else if (input.equals("flypath()")) {
                context.set(new Villain());
                System.out.println("Switching to Search for Villain");
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public static class Villain implements State {
        public void ha(d context, String input) {
            System.out.println("Current state: Villain");

            if (input.equals("trackingperson()")) {
                System.out.println("Switching to Tracking the Person");
                context.set(new TrackingPerson());
            } else if (input.equals("tobase()")) {
                context.set(new StandbyMode());
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public static class TrackingPerson implements State {
        public void ha(d context, String input) {
            System.out.println("Current state: TrackingPerson");

            if (input.equals("lost()")) {
                System.out.println("Switching to Search for Villain");
                context.set(new Villain());
            } else if (input.equals("returntobase()")) {
                System.out.println("Switching to Arrives");
                context.set(new Arrives());
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static class Arrives implements State {
        public void ha(d context, String input) {
            System.out.println("Current state: Arrives");

            if (input.equals("landing()")) {
                System.out.println("Switching to StandbyMode");
                context.set(new StandbyMode());
            } else {
                System.out.println("Invalid syntax");
            }
        }
    }
}

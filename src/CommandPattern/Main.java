package CommandPattern;


interface Command {
    public void execute();
}

class Light {
    public void on() { System.out.println("light is on"); }
    public void off() { System.out.println("light is off"); }
}

class GarageDoor {
    public void open() { System.out.println("garage door now open"); }
    public void off() { System.out.println("garage door is closed"); }
}

class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.on(); }
}

class GarageOpenCommand implements Command {
    GarageDoor garageDoor;
    public GarageOpenCommand(GarageDoor garageDoor) { this.garageDoor = garageDoor; }
    public void execute() { garageDoor.open(); }
}

class SimpleRemoteControl {
    Command slot;

    public void setCommand(Command command) { slot = command; }
    public void buttonPressed() { slot.execute(); }
}





public class Main {
    public static void main(String args[]) {
        SimpleRemoteControl sc = new SimpleRemoteControl();

        LightOnCommand lc = new LightOnCommand(new Light());
        sc.setCommand(lc);
        sc.buttonPressed();

        GarageOpenCommand gc = new GarageOpenCommand(new GarageDoor());
        sc.setCommand(gc);
        sc.buttonPressed();
    }
}

package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    private boolean engineStarted = false;

    public void startEngine() {
        this.engineStarted = true;
    }

    public boolean engineIsStarted() {
        return engineStarted;
    }

    public void stopEngine() {
        this.engineStarted = false;
    }

    public abstract void fillUpWithFuel();

    public abstract void chargeBattery();


}

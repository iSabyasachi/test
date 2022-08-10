package test.thread.h20;

class BuildingH2O {

    public static void main(String[] args) throws InterruptedException{
        H2O h1 = new H2O();
        h1.hydrogen(new ReleaseHydrogen());
        h1.hydrogen(new ReleaseHydrogen());
        h1.oxygen(new ReleaseOxygen());
    }
}
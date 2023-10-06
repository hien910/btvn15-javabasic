package entity;

public class Detail {
    private Factory factory;
    private int workDay;

    public Detail(Factory factory, int numWorkDay) {
        this.factory=factory;
        this.workDay =numWorkDay;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "factory=" + factory +
                ", workDay=" + workDay +
                '}';
    }
}

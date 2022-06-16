package mortytheplatypus.Problem1.v1;

public interface Component {
    public String getType(); //i.e., Processor or Display or Communication Channel
    public String getClassification(); //i.e., LCD or LED

    public double getPrice();
}

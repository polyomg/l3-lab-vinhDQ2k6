package poly.edu.model;

public class Report {
    private Object group;
    private Double sum;
    private Long count;

    public Report(Object group, Double sum, Long count) {
        this.group = group;
        this.sum = sum;
        this.count = count;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

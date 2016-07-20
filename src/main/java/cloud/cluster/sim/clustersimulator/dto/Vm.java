package cloud.cluster.sim.clustersimulator.dto;

public class Vm {
    private int requestId;
    private double taskStartTime;
    private double taskEndTime;
    private double taskArrivalTime;

    public Vm() {
    }

    public Vm(int requestId, double taskStartTime, double taskEndTime) {
        this.requestId = requestId;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public double getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(double taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public double getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(double taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public double getTaskArrivalTime() {
        return taskArrivalTime;
    }

    public void setTaskArrivalTime(double taskArrivalTime) {
        this.taskArrivalTime = taskArrivalTime;
    }
}
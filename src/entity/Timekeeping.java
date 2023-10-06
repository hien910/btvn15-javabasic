package entity;

import java.util.List;

public class Timekeeping {
    private Worker worker;
    private List<Detail> detailList;
    private int totalWorkDay;
    private int idMin;

    public int getIdMin() {
        return idMin;
    }

    public void setIdMin() {
        int idMin1 =0;
        for (int i = 0; i < detailList.size(); i++) {
            if (idMin1 < detailList.get(i).getFactory().getId()){
                idMin1 =detailList.get(i).getFactory().getId();
            }
        }
        this.idMin=idMin1;
    }

    public Timekeeping(Worker worker, List<Detail> detailList, int totalWorkDay) {
        this.worker = worker;
        this.detailList = detailList;
        this.totalWorkDay = totalWorkDay;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<Detail> getDetail() {
        return detailList;
    }

    public void setDetail(List<Detail> detailList) {
        this.detailList = detailList;
    }

    public int getTotalWorkDay() {
        return totalWorkDay;
    }

    public void setTotalWorkDay(int totalWorkDay) {
        this.totalWorkDay = totalWorkDay;
    }

    @Override
    public String toString() {
        return "Timekeeping{" +
                "worker=" + worker +
                ", factory=" + detailList +
                ", TotalWorkday=" + totalWorkDay +
                '}';
    }

}

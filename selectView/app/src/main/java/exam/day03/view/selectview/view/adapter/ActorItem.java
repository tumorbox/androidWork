package exam.day03.view.selectview.view.adapter;

public class ActorItem{

    int exImg;
    String exName;
    String exDate;
    String exText;

    public ActorItem(int exImg, String exName, String exDate, String exText) {
        this.exImg = exImg;
        this.exName = exName;
        this.exDate = exDate;
        this.exText = exText;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "exImg=" + exImg +
                ", exName='" + exName + '\'' +
                ", exDate='" + exDate + '\'' +
                ", exText='" + exText + '\'' +
                '}';
    }
}
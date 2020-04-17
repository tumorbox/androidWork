package multi.android.meterial_design_pro2.recycler;

//RecyclerView의 한 항목을 구성하는 데이터를 저장하는 객체(dto)
public class SimpleItem {
    String data;

    public SimpleItem(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "SimpleItem{" +
                "data='" + data + '\'' +
                '}';
    }
}

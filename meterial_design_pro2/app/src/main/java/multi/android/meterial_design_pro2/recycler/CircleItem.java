package multi.android.meterial_design_pro2.recycler;

public class CircleItem {
    int img;

    public CircleItem(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "CircleItem{" +
                "img=" + img +
                '}';
    }
}

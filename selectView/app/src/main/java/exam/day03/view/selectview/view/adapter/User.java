package exam.day03.view.selectview.view.adapter;

//row에 출력할 데이터 정보를 담는 객체
//DTO, get/set 만들어도 된다.
public class User {
    int myImg;
    String name;
    String telNum;

    //User 생성자
    public User(int myImg, String name, String telNum) {
        this.myImg = myImg;
        this.name = name;
        this.telNum = telNum;
    }

    //개발자의 목적 데이터가 제대로 넘어오는지 확인하기 위해. 작업완료 후 삭제


    @Override
    public String toString() {
        return "User{" +
                "myImg=" + myImg +
                ", name='" + name + '\'' +
                ", telNum='" + telNum + '\'' +
                '}';
    }
}

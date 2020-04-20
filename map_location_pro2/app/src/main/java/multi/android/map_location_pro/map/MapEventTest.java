package multi.android.map_location_pro.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import multi.android.map_location_pro.R;


/*
*   지도화면이 출력된 후에 이벤트를 연결할 수 있어야 한다.
*  지도를 클릭하거나 지도를 드래그, 지도를 줌레벨버큰을 이용해서 줌레벨을 변경
*       OnMapClickListener => 지도를 클릭할 때 발생하는 이벤트에 대한처리
*       OnMapLongClickListener => 맵을 길게 눌렀을 때 발생하는 이벤트에대한 처리
*       OnCameraMoveListener => 지도의 위치가 바뀌거나 줌레벨이 변경되어 카메라가이동될때
*                               발생하는 이벤트에 대한 처리
*       OnCameraMoveStartedListener => 지도의 위치가 바뀌거나 줌레벨이 변경되어 카메라가 이동되기
*                                       시작할 때 이벤트에 대한 처리
*          (순서) OnCameraMoveStartedListener -> OnCameraMoveListener
*
* */

public class MapEventTest extends AppCompatActivity implements OnMapReadyCallback,
                                    GoogleMap.OnMapClickListener,
                                    GoogleMap.OnMapLongClickListener,
                                    GoogleMap.OnCameraMoveListener,
                                    GoogleMap.OnCameraMoveStartedListener{
    GoogleMap map;
    MarkerOptions markerOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_event_test);
        //Map프레그먼트로 부터 맵을 얻기
        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)manager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if(map!=null){
            //위도,경도지정
            LatLng latLng= new LatLng(37.5858031,126.9763605);
            //지도 확대축소버튼을 추가
            map.getUiSettings().setZoomControlsEnabled(true);
            //현재 나의 위치를 포인트로 표시 - 위치기반서비스에 대한 퍼미션 체크가 완료되어야 표시
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));


            //멥에 이벤트연결
            map.setOnMapClickListener(this);
            map.setOnMapLongClickListener(this);
            map.setOnCameraMoveListener(this);
            map.setOnCameraMoveStartedListener(this);
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {
        map.clear();
        Toast.makeText(this, "지도를 클릭했습니다. =>"
                + "위도:" + latLng.latitude + "경도:" + latLng.longitude,
                Toast.LENGTH_SHORT).show();
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.strokeWidth(10);
        circleOptions.strokeColor(0);
        circleOptions.fillColor(Color.parseColor("#550000ff"));
        circleOptions.center(latLng);
        circleOptions.radius(500);
        map.addCircle(circleOptions);

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Toast.makeText(this, "지도를 길게 클릭했습니다. =>"
                        + "위도:" + latLng.latitude + "경도:" + latLng.longitude,
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCameraMove() {
        Toast.makeText(this, "카메라가 이동됩니다.",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCameraMoveStarted(int i) {
        Toast.makeText(this, "카메라 이동이 시작됩니다.",Toast.LENGTH_SHORT).show();
    }
}

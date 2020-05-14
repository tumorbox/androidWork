package multi.android.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import multi.android.network.R;

public class MainActivity extends AppCompatActivity {
    TextView clientInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clientInfo = findViewById(R.id.clientInfo);
    }
    public void btn_connect(View v){
        new networkClient().start();
    }

    class networkClient extends Thread{
        @Override
        public void run() {
            Socket socket;
            InputStream is = null;//클라이언트와 input할 수 있는 스트림
            DataInputStream dis = null;//최종적으로 클라이언트와 DataInputStream
            //을 이용해서 클라이언트로 부터 전송되는 데이터를
            //읽기
            OutputStream os = null; //클라이언트와 output할 수 있는 스트림
            DataOutputStream dos = null;
            try {
                socket = new Socket("70.12.116.89", 12345);
                System.out.println("서버접속완료..."+socket);

                //클라이언트에서도 서버와 통신할 수 있는 소켓객체로 부터 input/output
                //스트림을 구한다.
                //InputStream얻기
                is = socket.getInputStream();
                dis = new DataInputStream(is);

                //OutputStream얻기
                os = socket.getOutputStream();
                dos = new DataOutputStream(os);

                //1. 클라이언트<-서버(서버가 보내는 데이터를 읽기 - 2번 연속해서 읽기)
                final String data = dis.readUTF();
                System.out.println("서버가 전송하는 메시지1:"+data);
                final int intdata = dis.readInt();
                System.out.println("서버가 전송하는 메시지2:"+intdata);

                //2. 클라이언트 -> 서버
                dos.writeUTF("안녕하세요 서버님 클라이언트입니다.");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        clientInfo.append(data+"");
                        clientInfo.append(intdata+"");
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  
    
}

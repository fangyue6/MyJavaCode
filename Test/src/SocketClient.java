


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {  
    public static void main(String[] args) throws Exception {  
        Socket socket = new Socket("192.168.191.4", 2370);//114.215.88.247
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        PrintWriter out = new PrintWriter(socket.getOutputStream());  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
        System.out.println(in.readLine());
        while (true) {  
            String msg = reader.readLine();  
            out.println(msg);  
            out.flush();  
            if (msg.equals("end")) {  
                break;  
            }  
            System.out.println(in.readLine().trim());  
        }  
        socket.close();  
    }  
}  
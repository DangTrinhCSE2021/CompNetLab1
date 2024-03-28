package UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Server_2 {
     static int BSCNN (int a, int b, int c)
    {
        int i=a;
      while (!(i%a==0 && i%b==0 && i%c==0))
        {
         i++;
        }
      return i;
    }
    static void gui(String data, InetAddress add, int port, DatagramSocket s) throws IOException
    {
     byte buff[] = data.getBytes();
     DatagramPacket p = new DatagramPacket(buff,buff.length,add,port);
     s.send(p);
    }
    static DatagramPacket nhan(DatagramSocket s) throws IOException
    {
     byte buff[]= new byte[256];
     DatagramPacket p = new DatagramPacket(buff,buff.length);
     s.receive(p);
     return p;
    }
    public static void main(String[] s) throws IOException
    {
     DatagramSocket sv = new DatagramSocket(1234);
     DatagramPacket p1 = nhan(sv);
     String a = new String(p1.getData()).trim();
     int so1 = Integer.parseInt(a);
     DatagramPacket p2 = nhan(sv);
     String b = new String(p2.getData()).trim();
     int so2 = Integer.parseInt(b);
     DatagramPacket p3 = nhan(sv);
     String c = new String(p3.getData()).trim();
     int so3 = Integer.parseInt(c);
     int BSC = BSCNN(so1,so2,so3);
     gui(String.valueOf(BSC),p1.getAddress(),p1.getPort(),sv);
     sv.close();
    }
    
}
    return a;
}
}

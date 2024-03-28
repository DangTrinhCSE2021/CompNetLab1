package UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_Client_2 {
    static void gui(String data, String add, int port, DatagramSocket s) throws IOException
    {
     byte buff[] = data.getBytes();
     InetAddress add_sv = InetAddress.getByName(add);
     DatagramPacket p = new DatagramPacket(buff,buff.length,add_sv,port);
     s.send(p);
    }
    static String nhan(DatagramSocket s) throws IOException
    {
     byte buff[]= new byte[256];
     DatagramPacket p = new DatagramPacket(buff,buff.length);
     s.receive(p);
     String data = new String(p.getData()).trim();
     return data;
    }
    public static void main(String[] s) throws IOException
    {
     DatagramSocket cl = new DatagramSocket();
     Scanner bp = new Scanner(System.in);
     System.out.print("Nhap so 1:");
     int so1 = bp.nextInt();
     gui(String.valueOf(so1),"localhost",1234,cl);
     System.out.print("Nhap so 2:");
     int so2 = bp.nextInt();
     gui(String.valueOf(so2),"localhost",1234,cl);
     System.out.print("Nhap so 3:");
     int so3 = bp.nextInt();
     gui(String.valueOf(so3),"localhost",1234,cl);
     String BSCNN = nhan(cl);
     System.out.println("BSCNN cua 3 so la:"+BSCNN);
     cl.close();
    } 
    
}

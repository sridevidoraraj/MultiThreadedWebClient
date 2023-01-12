import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {

    static Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {

            File file = new File("D:\\Projects\\csweb\\index.html");

            try {

                Socket s = new Socket("localhost", 8080);
                logger.info("\u001B[33m"+"Connected to port : 8080"+"\u001B[0m");
//                System.out.println("[CONNECTED]");

                DataInputStream in = new DataInputStream(s.getInputStream());
                BufferedReader br = new BufferedReader(new FileReader(file));
                String header = "GET / HTTP/1.0\r\n" + file
                        + "Host:localhost\r\n\r\n";
                byte[] byteHeader = header.getBytes();

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.write(byteHeader, 0, header.length());
                dos.writeUTF(header);
                String res = "";

                byte[] buf = new byte[in.available()];
                in.readFully(buf);
                System.out.println("\t[READ PROCESS]");
                System.out.println("\t\tbuff length->" + buf.length);
                for (byte b : buf) {
                    res += (char) b;
                }
                System.out.println("\t[/READ PROCESS]");
                System.out.println("[RES]");
                System.out.println(res);

                BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                String clientMessage="",serverMessage="";
                while(!clientMessage.equals("bye")){
                    clientMessage=br1.readLine();
                    dos.writeUTF(clientMessage);
                    dos.flush();
                    serverMessage=in.readUTF();
                    System.out.println(serverMessage);
                }
                System.out.println("[CONN CLOSE]");
                in.close();
                dos.close();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

}

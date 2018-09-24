import java.io.*;
import java.net.*;
public class TCPClient {
  public static void main(String[] args) throws Exception {
    try{
      Socket socket=new Socket(8888);
      //Ou new Socket(adresse IP, 8888);

      DataInputStream inStream=new DataInputStream(socket.getInputStream());
      DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String clientMessage="",serverMessage="";
      while(!clientMessage.equals("bye")){
        clientMessage=br.readLine();
        outStream.writeUTF(clientMessage);
        outStream.flush();
        serverMessage=inStream.readUTF();
        System.out.println("From Server: "+serverMessage);
      }
      outStream.close();
      outStream.close();
      socket.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }
}


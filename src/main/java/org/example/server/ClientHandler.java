package org.example.server;

import com.google.gson.Gson;
import org.example.shared.Contatore;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Gson gson = new Gson();
        try{
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            Contatore contatore = gson.fromJson(in.readUTF(), Contatore.class);
            System.out.println(contatore);



            out.flush();
            socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

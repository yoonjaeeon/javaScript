package com.yedam.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

public class ServerSocketExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.48", 5001));
			while (true) {
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept();
				System.out.println("[연결 수락");

				// InputStream 처리.
				byte[] buf = null;
				String message = null;
				InputStream is = socket.getInputStream();
				buf = new byte[100];
				int readByte = is.read(buf);
				message = new String(buf, 0, readByte, "UTF-8");
				System.out.println("[데이터 받기 성공]" + message);

				// OutputStream 처리.
				OutputStream os = socket.getOutputStream();
				message = "Hello, Client";
				buf = message.getBytes();
				os.write(buf);
				os.flush();
				System.out.println("[데이터 보내기 성공]");

				os.close();
				is.close();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

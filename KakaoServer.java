import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

//īī�� ����
public class KakaoServer extends UnicastRemoteObject implements KakaoServerInterface
{
	private ArrayList<User> users = new ArrayList<User>(); // ������ ������ ����Ʈ
	private ArrayList<Room> rooms = new ArrayList<Room>(); // �� ������ ������ ����Ʈ


	public KakaoServer() throws RemoteException{} // ����Ʈ ������

	public void setClient(KakaoClientInterface client, String name, String talkName) throws RemoteException{
		User user = new User(client, name, talkName);
		users.add(user); // ������ ���� ����
		System.out.println(name + "���� �����߽��ϴ�. ���� " + users.size() + "���� �������ֽ��ϴ�.");
	}
	public ArrayList<User> getClient() throws RemoteException{
		return users; // ������ ���� ��ȯ
	}

	public void removeClient(int index) throws RemoteException{
		User user = users.get(index); // �� ���Ŀ� �ִ� ������� ��� �ε��� �ϳ��� ����
		users.remove(index);
		System.out.println(user.getName() + "���� ������ �����߽��ϴ�. ���� " + users.size() + "���� �������ֽ��ϴ�.");
	}

	public void setRoom(Room room) throws RemoteException{
		rooms.add(room); // �� ������ ������
	}

	public void setMessage(Room room, String msg) throws Exception{

		//Thread�� ����??
		for(int i = 0 ; i < room.getIndex().size() ; i++){ // �濡 �ִ� ��� ��

			int UserIndex = room.getIndex().get(i); // �ε����� �����ͼ� ������ ã������
			User user = users.get(UserIndex); // �������� �޽��� ����
			try
			{
				KakaoClientInterface kci = user.getClient();
				kci.setMessage(msg);
			}
			catch (ConnectException ce)
			{
				System.out.println("������� �߻�");
				room.getIndex().remove(i);
				i--;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Runtime rt = Runtime.getRuntime();
		rt.exec("rmiregistry");

		KakaoServer kServer = new KakaoServer();
		Naming.rebind("kakao", kServer);
		System.out.println("Server Ready ...");
	}
}
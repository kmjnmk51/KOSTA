import java.awt.*;
import javax.swing.*;
import java.util.*;

public class AddChatRoom extends Panel
{

	JPanel inputPanel;
	JPanel userView;

	JLabel roomName;
	JTextField inputRoomName;

	public AddChatRoom(ArrayList<User> users){

		inputPanel = new JPanel();
		userView = new JPanel();

		roomName = new JLabel("�� �̸� : ");
		inputRoomName = new JTextField(10);

		setSize(150,80);
		setBackground(new Color(255,235,51));
		setLayout(new BorderLayout());

		// �� �̸� �Է� ���
		inputPanel.add(roomName);
		inputPanel.add(inputRoomName);
		inputPanel.setBackground(new Color(255,235,51));

		//���� ��� �ϴ� 
		userView.setLayout(new GridLayout(users.size(), 1));
		userView.setBackground(new Color(255,235,51));
		for(int i = 0 ; i < users.size() ; i++){
			User user = users.get(i);
			userView.add(new JLabel(user.getName()));
		}

		add(inputPanel, "South");
		add(userView, "Center");
	}
}
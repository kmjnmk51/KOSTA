import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class KakaoListEvent implements ActionListener
{
	private KakaoTalk cr;
	public KakaoListEvent(KakaoTalk cr)
	{
		this.cr = cr;
	}
	public void actionPerformed(ActionEvent e)
	{		
		String jb = e.getActionCommand();
		//KakaoList
		if (jb.equals("����"))
		{
			// �ڽ��� �����߿� �ϳ� �����ؼ� �鰡����
			cr.card.show(cr.slide,"kakaoChat");
		}

		if (jb.equals("ģ�����"))
		{
			cr.card.show(cr.slide,"kakaoFriends");
		}
		
		if (jb.equals("ä���߰�"))
		{
			try{
				// �����κ��� ���� ��� ������
				ArrayList<User> users = cr.client.getServer().getClient();

				String[] buttons = {"Ȯ��","���"}; //�ɼǿ� �� ��ư
				AddChatRoom makeRoom = new AddChatRoom(users); // �ɼǿ� ��Ÿ�� ��ü
				int result = JOptionPane.showOptionDialog(cr, makeRoom,"ä���߰�", 0, JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);

				if(result == 0){ // Ȯ�� ��ư
				
				
				}	

			}catch (Exception re){
					re.printStackTrace();
			}
		}
	}
}
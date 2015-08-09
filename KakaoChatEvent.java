import java.awt.event.*;

public class KakaoChatEvent implements ActionListener
{
	private KakaoTalk cr;
	public KakaoChatEvent(KakaoTalk cr)
	{
		this.cr = cr;
	}
	public void actionPerformed(ActionEvent e)
	{		
		String jb = e.getActionCommand();
		String str = cr.chatView.inputField.getText();

		//KakaoChatEvent
		if (jb.equals("����"))		//�ڷΰ���
		{
			cr.card.show(cr.slide, "kakaoList");
		}

		if (jb.equals("������"))		//������
		{
			// �� ������ �ڵ� �ۼ�(�������� ��������)
			cr.card.show(cr.slide, "kakaoList");
		}

		if (jb.equals("����") || str.length() != 0 )		//�۾���
		{
			if (str.length()!= 0)
			{
				// ������ �Ѱܼ� �ٸ� �������� �Ѹ��� �ڵ� �ۼ�
				cr.chatView.textArea.append(cr.chatView.inputField.getText() +"\n");
				cr.chatView.inputField.setText("");
				cr.chatView.inputField.requestFocus();
			}
		}

		if (jb.equals("ģ���ʴ�"))
		{
			cr.card.show(cr.slide, "kakaoInvite");
			// ģ�� �ʴ� �ڵ� �ۼ�
		}
	}
}
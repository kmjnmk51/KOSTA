import javax.swing.*;
import java.awt.event.*;

public class KakaoInviteEvent implements ActionListener
{
	private KakaoTalk cr;
	public KakaoInviteEvent(KakaoTalk cr)
	{
		this.cr = cr;
	}
	public void actionPerformed(ActionEvent e)
	{		
		String jb = e.getActionCommand();
		
		//card5
		if (jb.equals("�ʴ��ϱ�"))
		{
			cr.card.previous(cr.slide);
			cr.card.previous(cr.slide);
		}

		if (jb.equals("���ư���"))
		{
			cr.card.previous(cr.slide);
			cr.card.previous(cr.slide);
		}
	}
}
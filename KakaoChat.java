import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KakaoChat extends JPanel
{
		//panel3
	JPanel controlPanel, inputPanel;
	JButton preButton, exitButton, sendButton,inviteButton;
	JLabel title;
	JTextArea textArea;	//��ȭâ
	JTextField inputField;	 //�Է�â
	JScrollPane scrollPane;
	//card3
	public KakaoChat()
	{
		controlPanel = new JPanel();
		inputPanel = new JPanel();
		preButton = new JButton("����");
		inviteButton = new JButton("ģ���ʴ�");
		exitButton = new JButton("������");
		sendButton = new JButton("����");
		title = new JLabel("      ä�ù� �̸�      ");
		textArea = new JTextArea();
		inputField = new JTextField(20);
		scrollPane = new JScrollPane(textArea);

		setLayout(new BorderLayout());

		controlPanel.add(preButton);
		controlPanel.add(title);
		controlPanel.add(inviteButton);
		controlPanel.add(exitButton);
		inputPanel.add(inputField);
		inputPanel.add(sendButton);

		add("North",controlPanel);
		add("Center",scrollPane);
		add("South",inputPanel);
		
		textArea.setEditable(false);
	}
}

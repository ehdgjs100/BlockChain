package Mining;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;

public class GUI {
	Font font = new Font("¸¼Àº °íµñ",Font.PLAIN, 15);
	
	
	private JFrame frame;
	private JTextField inputDifficulty;
	private JLabel lblData;
	private JTextField InputData;
	private JLabel lblPrevious;
	private JTextField InputPHash;
	private JButton btnErase;
	private JButton btnGenerate;
	private JButton btn_GenerateWallet;
	public static Wallet WalletA;
	public static Wallet WalletB;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputDifficulty = new JTextField();
		inputDifficulty.setBounds(123, 13, 116, 21);
		frame.getContentPane().add(inputDifficulty);
		inputDifficulty.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Difficulty");
		lblNewLabel.setBounds(12, 13, 69, 21);
		lblNewLabel.setFont(font);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		lblData = new JLabel("Data");
		lblData.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblData.setBounds(12, 44, 69, 21);
		frame.getContentPane().add(lblData);
		
		InputData = new JTextField();
		InputData.setColumns(10);
		InputData.setBounds(123, 47, 116, 21);
		frame.getContentPane().add(InputData);
		
		lblPrevious = new JLabel("PreviousHash");
		lblPrevious.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblPrevious.setBounds(12, 75, 99, 21);
		frame.getContentPane().add(lblPrevious);
		
		InputPHash = new JTextField();
		InputPHash.setColumns(10);
		InputPHash.setBounds(123, 78, 116, 21);
		frame.getContentPane().add(InputPHash);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 298, 717, 120);
		frame.getContentPane().add(textArea);
		
		btnErase = new JButton("\uC9C0\uC6B0\uAE30");
		btnErase.setForeground(Color.BLACK);
		btnErase.setBackground(Color.RED);
		btnErase.setBounds(576, 263, 116, 23);
		frame.getContentPane().add(btnErase);
		
		btnGenerate = new JButton("\uBE14\uB85D\uCCB4\uC778 \uC0DD\uC131");
		btnGenerate.setForeground(Color.BLACK);
		btnGenerate.setBackground(Color.RED);
		btnGenerate.setBounds(576, 12, 116, 23);
		frame.getContentPane().add(btnGenerate);
		
		btn_GenerateWallet = new JButton("\uC9C0\uAC11\uC0DD\uC131");
		btn_GenerateWallet.setForeground(Color.BLACK);
		btn_GenerateWallet.setBackground(Color.RED);
		btn_GenerateWallet.setBounds(576, 46, 116, 23);
		frame.getContentPane().add(btn_GenerateWallet);
		
		
		
		
		
		//ºí·Ï Ã¼ÀÎ »ý¼º
		ActionListener btn_BlockGenerate_Click = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Block block = new Block(InputData.getText(), "0");				
				block.mine(Integer.parseInt(inputDifficulty.getText()));
				textArea.append("Ã¤±¼¼º°ø!!" + "  Time : " + Block.timeStamp + "\n");
				textArea.append("nonce °ª : " + Block.nonce + "  hash °ª : " + Block.hash.toString() + "\n");
			}
		};
		btnGenerate.addActionListener(btn_BlockGenerate_Click);	
		
		//TextArea Áö¿ì±â
		ActionListener btn_Erase_click = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.selectAll();
				textArea.replaceSelection("");
			}
		};
		btnErase.addActionListener(btn_Erase_click);	
		
		
		ActionListener btn_GenerateWallet_Click = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				WalletA = new Wallet();
				WalletA.generateKeyPair();
				
				WalletB = new Wallet();
				//WalletB.generateKeyPair();
				
				
				/*textArea.append("Áö°©1 publicKey : " + WalletA.publicKey.toString());
				textArea.append("Áö°©1 privateKey : " + WalletA.privateKey.toString() + "\n");
				textArea.append("Áö°©2 publicKey : " + WalletB.publicKey.toString());
				textArea.append("Áö°©2 privateKey : " + WalletB.privateKey.toString() + "\n");*/
			}
		};
		btn_GenerateWallet.addActionListener(btn_GenerateWallet_Click);
		
	}
}

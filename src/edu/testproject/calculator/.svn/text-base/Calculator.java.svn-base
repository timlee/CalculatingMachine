package edu.testproject.calculator;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener, KeyListener{

	// 儲存所有相關View的排版
	// 24*12 的陣列 是拿來做GridBagLayout用
	private int _buttonAttribute[][] = {
			{ 0, 0, 6, 1, GridBagConstraints.HORIZONTAL,
					GridBagConstraints.CENTER, 1, 1, 0, 0, 3, 0 },
			{ 0, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 3, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 4, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 5, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 0, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 1, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 2, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 3, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 4, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 5, 2, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 0, 3, 1, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 1, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 2, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 3, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 4, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 5, 3, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 1, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 2, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 3, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 4, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 },
			{ 5, 4, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,
					1, 1, 1, 1, 1, 1 }, };
	// 顯示運算結果的view
	private Label resultNumberText = new Label("0", Label.RIGHT);
	// 顯示目前按下的運算元符號的view
	private JTextField _operationText = new JTextField("");
	// 儲存所有相關按鈕物件
	private JButton _buttons[] = { new JButton("7"), new JButton("8"),
			new JButton("9"), new JButton("*"), new JButton("BS"),
			new JButton("CE"), new JButton("4"), new JButton("5"),
			new JButton("6"), new JButton("/"), new JButton("sqrt"),
			new JButton("C"), new JButton("1"), new JButton("2"),
			new JButton("3"), new JButton("-"), new JButton("1/x"),
			new JButton("0"), new JButton("+/-"), new JButton("."),
			new JButton("+"), new JButton("=") };

	// 取得螢幕大小，等等要置中顯示視窗
	private Dimension _screenlocation = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private char _tempOperatorChar = '+';// +-*/暫存
	// +-*/判斷
	private boolean _operatorChar = true;
	// 目前大小
	private double _tempResultNumber = 0;
	// 所顯示的數字
	public String _resultNumber = "0";
	// 有輸入數字嗎?
	private Boolean _isHaveBeingInputedNumber = false;

	// 建構子
	public Calculator() {
		setTitle("簡易計算機");
		// 排版使用GridBagLayout
		setLayout(new GridBagLayout());
		// Label背景顏色(米黃)
		resultNumberText.setBackground(new Color(0xFF, 0xFF, 0xCC));
		// 設定LABEL顯示0
		resultNumberText.setText("0");
		// 設定TEXTFIELD不能更改值
		_operationText.setEditable(false);
		// 背景顏色
		_operationText.setBackground(new Color(0x00, 0xff, 0xff));
		// 設定字型
		Font font = new Font("Arial Unicode MS", 1, 18);
		// 改變字型
		_operationText.setFont(font);

		// 將顯示運算子的view加入視窗
		add(this, resultNumberText, _buttonAttribute[0]);
		// 將顯示運算子的view加入視窗
		add(this, _operationText, _buttonAttribute[1]);
		// 將BUTTON加入到視窗中顯示(利用迴圈)
		for(int i = 0; i < _buttons.length; i++) {
			// buttonAttributes的0跟1是給TEXT用，其它才是button物件屬性
			add(this, _buttons[i], _buttonAttribute[i + 2]);
			// 全部按鈕都要監聽，要不然無法取得按鈕事件
			_buttons[i].addActionListener(this);
		}

		// 讓視窗中X按鈕作用是關閉
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 自動調整視窗成最適當大小
		pack();
		// 不許變動視窗大小
		setResizable(false);
		// 視窗位置 視窗中間 免的都右上角顯示 另外也支援其他解析度
		setLocation((int) ((_screenlocation.width - getWidth()) / 2),
				(int) ((_screenlocation.height - getHeight()) / 2));
	}

	// ADD 元件
	private void add(JFrame f, Component com, int attributes[]) {
		GridBagConstraints cons = new GridBagConstraints();
		// X
		cons.gridx = attributes[0];
		// Y
		cons.gridy = attributes[1];
		// 寬的格數
		cons.gridwidth = attributes[2];
		// 長的格數
		cons.gridheight = attributes[3];
		// 填滿格式
		cons.fill = attributes[4];
		// 元件擺放位置
		cons.anchor = attributes[5];
		// 大小是幾倍
		cons.weightx = attributes[6];
		// 大小是幾倍
		cons.weighty = attributes[7];
		// 增加元件跟位置與其他元件與格線的間距
		cons.insets = new Insets(attributes[8], attributes[9], attributes[10],
				attributes[11]);
		f.add(com, cons);
		// 增加數字鍵的KeyListener
		com.addKeyListener(this);
	}

	private void compute(String num) {
		// 正負變號
		if (num.equals("+/-")) {
			resultNumberText.setText(""
					+ (Double.parseDouble(resultNumberText.getText()) * -1));
		}
		// 倒數
		else if (num.equals("1/x")) {
			resultNumberText.setText("" + 1
					/ (Double.parseDouble(resultNumberText.getText())));
		}
		// 開根號
		else if (num.equals("sqrt")) {
			resultNumberText
					.setText(""
							+ Math.sqrt(Double.parseDouble(resultNumberText
									.getText())));
		}
		// "."
		else if (num.equals(".")) {
			if (_isHaveBeingInputedNumber && !isContainPoint()) {
				_resultNumber += ".";
				resultNumberText.setText(_resultNumber);
			}
		}
		// 退1位
		else if (num.equals("BS")) {
			// 不等於答案才繼續做
			if (!resultNumberText.getText().equals("" + _tempResultNumber)) {
				// 變陣列
				char[] nowN = _resultNumber.toCharArray();
				// 歸""
				_resultNumber = "";
				// 退1位算法
				for (int i = 0; i < nowN.length - 1; i++) {
					_resultNumber += nowN[i];
				}
				// 假如退到都沒數字就顯示0
				if (!_resultNumber.equals("")) {
					resultNumberText.setText(_resultNumber);
				} else {
					resultNumberText.setText("0");
				}
			}
		}
		// 顯示上面歸0
		else if (num.equals("CE")) {
			resultNumberText.setText(_resultNumber = "0");
		}
		// 假如不等於+/- 跟 1/X 跟 sqrt 跟 "." 跟"CE" 跟"BS"鍵進入
		else {
			// 將按鍵內容變成陣列等等SWITCH才可以判斷
			char[] nextNumber = num.toCharArray();
			// 按鈕作用 假如沒有暫存字元又輸入數字就要將nowNumber歸0
			if (!_isHaveBeingInputedNumber
					&& (nextNumber[0] >= '0' && nextNumber[0] <= '9')) {
				// 變空字串
				_resultNumber = "";
			}
			switch(nextNumber[0]) {
			case '1':
				// 改變LABEL數字的副程式
				changeNowResultNumber("1");
				break;
			case '2':
				changeNowResultNumber("2");
				break;
			case '3':
				changeNowResultNumber("3");
				break;
			case '4':
				changeNowResultNumber("4");
				break;
			case '5':
				changeNowResultNumber("5");
				break;
			case '6':
				changeNowResultNumber("6");
				break;
			case '7':
				changeNowResultNumber("7");
				break;
			case '8':
				changeNowResultNumber("8");
				break;
			case '9':
				changeNowResultNumber("9");
				break;
			case '0':
				if (!_resultNumber.equalsIgnoreCase("0")) {
					changeNowResultNumber("0");
				}
				break;
			default:
				// 是特殊字元跟是有數字輸入
				if (_operatorChar && _isHaveBeingInputedNumber) {
					_operatorChar = false;
					switch(_tempOperatorChar) {
					case '/':
						if (_tempResultNumber != 0) {
							_tempResultNumber /= Double
									.parseDouble(resultNumberText.getText());
						}
						break;
					case '*':
						_tempResultNumber *= Double.parseDouble(resultNumberText
								.getText());
						break;
					case '+':
						_tempResultNumber += Double.parseDouble(resultNumberText
								.getText());
						break;
					case '-':
						_tempResultNumber -= Double.parseDouble(resultNumberText
								.getText());
						break;
					}
					resultNumberText.setText("" + _tempResultNumber);
					_isHaveBeingInputedNumber = false;
				} else {
					_resultNumber = "";
				}
				_operatorChar = true;
			}
			// 是特殊字元
			if (_operatorChar) {
				switch(nextNumber[0]) {
				case '/':
					_tempOperatorChar = '/';
					// 改變觀看符號
					_operationText.setText("   " + _tempOperatorChar);
					_tempResultNumber = Double.parseDouble(resultNumberText
							.getText());
					break;
				case '*':
					_tempOperatorChar = '*';
					_operationText.setText("   " + "X");
					_tempResultNumber = Double.parseDouble(resultNumberText
							.getText());
					break;
				case '+':
					_tempOperatorChar = '+';
					_operationText.setText("   " + _tempOperatorChar);
					_tempResultNumber = Double.parseDouble(resultNumberText
							.getText());
					break;
				case '-':
					_tempOperatorChar = '-';
					_operationText.setText("   " + _tempOperatorChar);
					_tempResultNumber = Double.parseDouble(resultNumberText
							.getText());
					break;
				case '=':
					_tempOperatorChar = '=';
					resultNumberText.setText("" + _tempResultNumber);
					break;
				case 'C':
					_tempOperatorChar = '+';
					_resultNumber = "0";
					_tempResultNumber = 0;
					resultNumberText.setText(_resultNumber);
					_operationText.setText("   ");
					_operatorChar = true;
					break;
				case '.':
					if (_isHaveBeingInputedNumber && !isContainPoint()) {
						_resultNumber += ".";
						resultNumberText.setText(_resultNumber);
					}
					break;
				}
			}
		}
	}

	// 按鈕事件
	public void actionPerformed(ActionEvent actionEvent) {
		// 取得BUTTON
		JButton number = (JButton) actionEvent.getSource();
		compute(number.getText());
	}

	// 改變輸入數字
	public void changeNowResultNumber(String nowNum) {
		if (_resultNumber.equals("0")) {
			_resultNumber = "";
		}
		_resultNumber += nowNum;
		resultNumberText.setText("" + _resultNumber);
		_isHaveBeingInputedNumber = true;
	}

	// 看有幾個"."免得會多出"."
	public Boolean isContainPoint() {
		char chars[] = _resultNumber.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if (chars[i] == '.') {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char inputChar = e.getKeyChar();
		int code = e.getKeyCode();
		// 只有鍵盤是以下這些才有用
		if ((inputChar >= '0' && inputChar <= '9') || inputChar == '+'
				|| inputChar == '-' || inputChar == '*' || inputChar == '/'
				|| inputChar == '.') 
		{
			compute(inputChar + "");
		} else if (KeyEvent.getKeyText(code).equals("Enter")) {
			compute("=");
		} else if (KeyEvent.getKeyText(code).equals("Backspace")) {
			compute("BS");
		} else if (KeyEvent.getKeyText(code).equals("Delete")) {
			compute("CE");
		} else if (KeyEvent.getKeyText(code).equals("Escape")) {
			compute("C");
		}
	}

	@Override
	public void keyPressed (KeyEvent e) {
		// TODO
	}

	@Override
	public void keyTyped (KeyEvent e) {
		// TODO
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		//顯示計算機視窗
		calculator.setVisible(true);
	}
}

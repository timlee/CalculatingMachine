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

	// �x�s�Ҧ�����View���ƪ�
	// 24*12 ���}�C �O���Ӱ�GridBagLayout��
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
	// ��ܹB�⵲�G��view
	private Label resultNumberText = new Label("0", Label.RIGHT);
	// ��ܥثe���U���B�⤸�Ÿ���view
	private JTextField _operationText = new JTextField("");
	// �x�s�Ҧ��������s����
	private JButton _buttons[] = { new JButton("7"), new JButton("8"),
			new JButton("9"), new JButton("*"), new JButton("BS"),
			new JButton("CE"), new JButton("4"), new JButton("5"),
			new JButton("6"), new JButton("/"), new JButton("sqrt"),
			new JButton("C"), new JButton("1"), new JButton("2"),
			new JButton("3"), new JButton("-"), new JButton("1/x"),
			new JButton("0"), new JButton("+/-"), new JButton("."),
			new JButton("+"), new JButton("=") };

	// ���o�ù��j�p�A�����n�m����ܵ���
	private Dimension _screenlocation = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private char _tempOperatorChar = '+';// +-*/�Ȧs
	// +-*/�P�_
	private boolean _operatorChar = true;
	// �ثe�j�p
	private double _tempResultNumber = 0;
	// ����ܪ��Ʀr
	public String _resultNumber = "0";
	// ����J�Ʀr��?
	private Boolean _isHaveBeingInputedNumber = false;

	// �غc�l
	public Calculator() {
		setTitle("²���p���");
		// �ƪ��ϥ�GridBagLayout
		setLayout(new GridBagLayout());
		// Label�I���C��(�̶�)
		resultNumberText.setBackground(new Color(0xFF, 0xFF, 0xCC));
		// �]�wLABEL���0
		resultNumberText.setText("0");
		// �]�wTEXTFIELD�������
		_operationText.setEditable(false);
		// �I���C��
		_operationText.setBackground(new Color(0x00, 0xff, 0xff));
		// �]�w�r��
		Font font = new Font("Arial Unicode MS", 1, 18);
		// ���ܦr��
		_operationText.setFont(font);

		// �N��ܹB��l��view�[�J����
		add(this, resultNumberText, _buttonAttribute[0]);
		// �N��ܹB��l��view�[�J����
		add(this, _operationText, _buttonAttribute[1]);
		// �NBUTTON�[�J����������(�Q�ΰj��)
		for(int i = 0; i < _buttons.length; i++) {
			// buttonAttributes��0��1�O��TEXT�ΡA�䥦�~�Obutton�����ݩ�
			add(this, _buttons[i], _buttonAttribute[i + 2]);
			// �������s���n��ť�A�n���M�L�k���o���s�ƥ�
			_buttons[i].addActionListener(this);
		}

		// ��������X���s�@�άO����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �۰ʽվ�������̾A��j�p
		pack();
		// ���\�ܰʵ����j�p
		setResizable(false);
		// ������m �������� �K�����k�W����� �t�~�]�䴩��L�ѪR��
		setLocation((int) ((_screenlocation.width - getWidth()) / 2),
				(int) ((_screenlocation.height - getHeight()) / 2));
	}

	// ADD ����
	private void add(JFrame f, Component com, int attributes[]) {
		GridBagConstraints cons = new GridBagConstraints();
		// X
		cons.gridx = attributes[0];
		// Y
		cons.gridy = attributes[1];
		// �e�����
		cons.gridwidth = attributes[2];
		// �������
		cons.gridheight = attributes[3];
		// �񺡮榡
		cons.fill = attributes[4];
		// �����\���m
		cons.anchor = attributes[5];
		// �j�p�O�X��
		cons.weightx = attributes[6];
		// �j�p�O�X��
		cons.weighty = attributes[7];
		// �W�[������m�P��L����P��u�����Z
		cons.insets = new Insets(attributes[8], attributes[9], attributes[10],
				attributes[11]);
		f.add(com, cons);
		// �W�[�Ʀr�䪺KeyListener
		com.addKeyListener(this);
	}

	private void compute(String num) {
		// ���t�ܸ�
		if (num.equals("+/-")) {
			resultNumberText.setText(""
					+ (Double.parseDouble(resultNumberText.getText()) * -1));
		}
		// �˼�
		else if (num.equals("1/x")) {
			resultNumberText.setText("" + 1
					/ (Double.parseDouble(resultNumberText.getText())));
		}
		// �}�ڸ�
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
		// �h1��
		else if (num.equals("BS")) {
			// �����󵪮פ~�~��
			if (!resultNumberText.getText().equals("" + _tempResultNumber)) {
				// �ܰ}�C
				char[] nowN = _resultNumber.toCharArray();
				// �k""
				_resultNumber = "";
				// �h1���k
				for (int i = 0; i < nowN.length - 1; i++) {
					_resultNumber += nowN[i];
				}
				// ���p�h�쳣�S�Ʀr�N���0
				if (!_resultNumber.equals("")) {
					resultNumberText.setText(_resultNumber);
				} else {
					resultNumberText.setText("0");
				}
			}
		}
		// ��ܤW���k0
		else if (num.equals("CE")) {
			resultNumberText.setText(_resultNumber = "0");
		}
		// ���p������+/- �� 1/X �� sqrt �� "." ��"CE" ��"BS"��i�J
		else {
			// �N���䤺�e�ܦ��}�C����SWITCH�~�i�H�P�_
			char[] nextNumber = num.toCharArray();
			// ���s�@�� ���p�S���Ȧs�r���S��J�Ʀr�N�n�NnowNumber�k0
			if (!_isHaveBeingInputedNumber
					&& (nextNumber[0] >= '0' && nextNumber[0] <= '9')) {
				// �ܪŦr��
				_resultNumber = "";
			}
			switch(nextNumber[0]) {
			case '1':
				// ����LABEL�Ʀr���Ƶ{��
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
				// �O�S��r����O���Ʀr��J
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
			// �O�S��r��
			if (_operatorChar) {
				switch(nextNumber[0]) {
				case '/':
					_tempOperatorChar = '/';
					// �����[�ݲŸ�
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

	// ���s�ƥ�
	public void actionPerformed(ActionEvent actionEvent) {
		// ���oBUTTON
		JButton number = (JButton) actionEvent.getSource();
		compute(number.getText());
	}

	// ���ܿ�J�Ʀr
	public void changeNowResultNumber(String nowNum) {
		if (_resultNumber.equals("0")) {
			_resultNumber = "";
		}
		_resultNumber += nowNum;
		resultNumberText.setText("" + _resultNumber);
		_isHaveBeingInputedNumber = true;
	}

	// �ݦ��X��"."�K�o�|�h�X"."
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
		// �u����L�O�H�U�o�Ǥ~����
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
		//��ܭp�������
		calculator.setVisible(true);
	}
}

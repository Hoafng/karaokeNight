package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Dao_TaiKhoan;
import entity.TaiKhoan;

public class GUI_DoiMatKhau extends JFrame {

	private JPanel contentPane;
	private JTextField txtMKHienTai;
	private JTextField txtMKMoi;
	private JTextField txtXacNhanMK;
	private JButton btnXacNhan;
	private JLabel lblThongBao;
	private Dao_TaiKhoan dao_TaiKhoan = new Dao_TaiKhoan();
	private TaiKhoan tk ;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_DoiMatKhau(TaiKhoan taiKhoan) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		
		tk=taiKhoan;
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Đổi mật khẩu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(199, 10, 200, 39);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(119, 47, 372, 39);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMKHienTai = new JLabel("Mật khẩu hiện tại");
		lblMKHienTai.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMKHienTai.setBounds(10, 0, 120, 40);
		panel.add(lblMKHienTai);

		txtMKHienTai = new JTextField();
		txtMKHienTai.setBounds(135, 0, 237, 39);
		panel.add(txtMKHienTai);
		txtMKHienTai.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setLayout(null);
		panel_1.setBounds(119, 96, 372, 39);
		contentPane.add(panel_1);

		JLabel lblMKMoi = new JLabel("Mật khẩu mới");
		lblMKMoi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMKMoi.setBounds(10, 0, 120, 39);
		panel_1.add(lblMKMoi);

		txtMKMoi = new JTextField();
		txtMKMoi.setColumns(10);
		txtMKMoi.setBounds(135, 0, 237, 39);
		panel_1.add(txtMKMoi);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 128));
		panel_2.setLayout(null);
		panel_2.setBounds(119, 145, 372, 39);
		contentPane.add(panel_2);

		JLabel lblXacNhanMK = new JLabel("Xác nhận mật khẩu");
		lblXacNhanMK.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblXacNhanMK.setBounds(5, 0, 136, 39);
		panel_2.add(lblXacNhanMK);

		txtXacNhanMK = new JTextField();
		txtXacNhanMK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String mkMoi = txtMKMoi.getText();
				String mkXacNhan = txtXacNhanMK.getText();
				if (mkMoi.equals(mkXacNhan) == false)
					lblThongBao.setText("Mật khẩu xác nhận không chính xác");
				else
					lblThongBao.setText("");
			}
		});
		txtXacNhanMK.setBounds(135, 0, 237, 39);
		panel_2.add(txtXacNhanMK);
		txtXacNhanMK.setColumns(10);

		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = 0;
				if (kiemTraMatKhau() == true && kiemTraMatKhauMoi() == true && kiemTraMatKhauXacNhan() == true) {
					a = JOptionPane.showConfirmDialog(null, "Chắc chắn thay đổi mật khẩu", "Warning",
							JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						doiMatKhau();
						txtMKHienTai.setText("");
						txtMKMoi.setText("");
						txtXacNhanMK.setText("");
					}
				}
			}
		});
		btnXacNhan.setForeground(new Color(0, 0, 0));
		btnXacNhan.setBackground(new Color(101, 186, 118));
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(240, 215, 120, 30);
		contentPane.add(btnXacNhan);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(371, 215, 120, 30);
		contentPane.add(btnHuy);

		lblThongBao = new JLabel("");
		lblThongBao.setForeground(new Color(255, 0, 0));
		lblThongBao.setBounds(119, 187, 372, 13);
		contentPane.add(lblThongBao);

	}

	protected void doiMatKhau() {
		String a = txtMKMoi.getText();
		tk.setMatKhau(a);
		dao_TaiKhoan.updateTaiKhoan(tk);
	}

	private boolean kiemTraMatKhau() {
		dao_TaiKhoan = new Dao_TaiKhoan();
		String mk = txtMKHienTai.getText();
		String mkCu = tk.getMatKhau();
		if (mk.equals(mkCu) == false) {
			lblThongBao.setText("Mật khẩu hiện tại không chính xác");
			txtMKHienTai.requestFocus();
			return false;
		} else
			lblThongBao.setText("");
		return true;
	}

	private boolean kiemTraMatKhauMoi() {
		String mkMoi = txtMKMoi.getText();
		if (mkMoi.equals("")) {
			lblThongBao.setText("Chưa nhập mật khẩu mới");
			txtMKMoi.requestFocus();
			return false;
		} else
			lblThongBao.setText("");
		return true;
	}

	private boolean kiemTraMatKhauXacNhan() {
		String mkMoi = txtMKMoi.getText();
		String mkXacNhan = txtXacNhanMK.getText();
		if (mkMoi.equals(mkXacNhan) == false) {
			lblThongBao.setText("Mật khẩu xác nhận không chính xác");
			txtXacNhanMK.requestFocus();
			return false;
		} else
			lblThongBao.setText("");
		return true;
	}
}

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Dao_NhanVien;
import dao.Dao_TaiKhoan;
import entity.TaiKhoan;

public class GUI_QuenMatKhau extends JFrame {

	private JPanel contentPane;
	private JTextField txtSDT;
	private JLabel lblMatKhau;
	private JLabel lblThongBaoSDT;
	private JLabel lblThongBaoEmail;
	private JButton btnDangNhap;
	private JButton btnQuenMatKhau;
	private Dao_TaiKhoan daotk = new Dao_TaiKhoan();
	private Dao_NhanVien dao_NhanVien = new Dao_NhanVien();
	private TaiKhoan tk;
	private JTextField txtTaiKhoan;
	private JLabel lblThongBaoTaiKhoan;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public GUI_QuenMatKhau() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTieuDe = new JLabel("Hệ Thống Quản Lý Karaoke Night");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setBounds(70, 23, 461, 41);
		contentPane.add(lblTieuDe);

		JLabel lblTaiKhoan = new JLabel("Số điện thoại");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTaiKhoan.setBounds(28, 149, 134, 30);
		contentPane.add(lblTaiKhoan);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setBounds(169, 140, 299, 41);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);

		lblMatKhau = new JLabel("Email");
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMatKhau.setBounds(28, 213, 134, 30);
		contentPane.add(lblMatKhau);

		btnDangNhap = new JButton("Quên mật khẩu");
		btnDangNhap.setBackground(new Color(240, 240, 240));
		btnDangNhap.setBackground(new Color(101, 186, 118));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (daotk.getTaiKhoan(txtTaiKhoan.getText()) == null) {
					lblThongBaoTaiKhoan.setText("Tên tài khoản không tồn tại");
				} else if (!dao_NhanVien.getNhanVien(txtTaiKhoan.getText()).getSoDienThoai().equals(txtSDT.getText())) {
					lblThongBaoSDT.setText("Số điện thoại không chính xác");
				} else if (!dao_NhanVien.getNhanVien(txtTaiKhoan.getText()).getEmail().equals(txtEmail.getText())) {
					lblThongBaoEmail.setText("Email không chính xác");
				} else {
					String passwordNew = "";
					Random r = new Random();
					int[] integers = new int[5];
					for (int i = 0; i < integers.length; i++) {
						passwordNew += r.nextInt();
						tk = new TaiKhoan(txtTaiKhoan.getText(), passwordNew);
						daotk.updateTaiKhoan(tk);
						JOptionPane.showMessageDialog(null,"Password mới :" +passwordNew);
					}

				}

			}
		});
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDangNhap.setBounds(171, 267, 176, 41);
		contentPane.add(btnDangNhap);

		btnQuenMatKhau = new JButton("Hủy");
		btnQuenMatKhau.setBackground(new Color(101, 186, 118));
		btnQuenMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				new GUI_DangNhap().setVisible(true);
			}
		});
		btnQuenMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuenMatKhau.setBounds(357, 267, 113, 41);
		contentPane.add(btnQuenMatKhau);

		lblThongBaoSDT = new JLabel("");
		lblThongBaoSDT.setForeground(new Color(255, 0, 0));
		lblThongBaoSDT.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblThongBaoSDT.setBounds(169, 183, 299, 19);
		contentPane.add(lblThongBaoSDT);

		lblThongBaoEmail = new JLabel("");
		lblThongBaoEmail.setForeground(new Color(255, 0, 0));
		lblThongBaoEmail.setBounds(169, 242, 299, 19);
		contentPane.add(lblThongBaoEmail);

		JLabel lblTiKhon = new JLabel("Tài khoản");
		lblTiKhon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTiKhon.setBounds(28, 83, 134, 30);
		contentPane.add(lblTiKhon);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(169, 74, 299, 41);
		contentPane.add(txtTaiKhoan);

		lblThongBaoTaiKhoan = new JLabel("");
		lblThongBaoTaiKhoan.setForeground(Color.RED);
		lblThongBaoTaiKhoan.setBounds(169, 114, 299, 19);
		contentPane.add(lblThongBaoTaiKhoan);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(169, 202, 299, 41);
		contentPane.add(txtEmail);
	}
}

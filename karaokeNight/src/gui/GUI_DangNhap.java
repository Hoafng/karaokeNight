package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Dao_TaiKhoan;
import entity.TaiKhoan;

public class GUI_DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JLabel lblMatKhau;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private JButton btnQuenMatKhau;
	private Dao_TaiKhoan daotk = new Dao_TaiKhoan();
	private TaiKhoan tk;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DangNhap frame = new GUI_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_DangNhap() {
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

		JLabel lblTaiKhoan = new JLabel("Tài Khoản");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTaiKhoan.setBounds(70, 109, 94, 30);
		contentPane.add(lblTaiKhoan);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTaiKhoan.setBounds(171, 100, 299, 41);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		lblMatKhau = new JLabel("Mật Khẩu");
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMatKhau.setBounds(70, 187, 94, 30);
		contentPane.add(lblMatKhau);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(171, 176, 299, 41);
		contentPane.add(txtMatKhau);

		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBackground(new Color(240, 240, 240));
		btnDangNhap.setBackground(new Color(101, 186, 118));
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (daotk.getTaiKhoan(txtTaiKhoan.getText()) == null) {
					lblNewLabel_1.setText("Tên tài khoản không tồn tại");
					
				} else if (daotk.getTaiKhoan(txtTaiKhoan.getText(), new String(txtMatKhau.getPassword())) == null) {
					lblNewLabel_1.setText("Sai Mật Khẩu");
				} else if(daotk.getTaiKhoan(txtTaiKhoan.getText(),  new String(txtMatKhau.getPassword())) != null){
					tk=daotk.getTaiKhoan(txtTaiKhoan.getText(),  new String(txtMatKhau.getPassword()));
					dispose();
					new GUI_TrangChu(tk).setVisible(true);
				}
			}
		});
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDangNhap.setBounds(97, 267, 134, 41);
		contentPane.add(btnDangNhap);

		btnQuenMatKhau = new JButton("Quên Mật Khẩu");
		btnQuenMatKhau.setBackground(new Color(101, 186, 118));
		btnQuenMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				new GUI_QuenMatKhau().setVisible(true);
			}
		});
		btnQuenMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuenMatKhau.setBounds(280, 267, 184, 41);
		contentPane.add(btnQuenMatKhau);

		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(171, 147, 299, 19);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(171, 224, 299, 19);
		contentPane.add(lblNewLabel_1);
	}
}

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entity.TaiKhoan;

public class GUI_TroGiup extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoVaTen;
	private JTextField txtEmail;
	private JTextField txtTieuDe;
	private JTextField txtSoDienThoai;
	private TaiKhoan tk;
	private JLabel lblThongBaoSDT;
	private JLabel lblThongBaoHoTen;
	private JLabel lblThongBaoTieuDe;
	private JLabel lblThongBaoEmail;
	private JLabel lblThongBaoLoiNhan;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_TroGiup(TaiKhoan taiKhoan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(101, 186, 118));
		tk=taiKhoan;
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(5, 1, 420, 20);
		contentPane.add(menuBar);
		
		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ  ");
		mntmTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		mntmTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TrangChu(tk).setVisible(true);
			}
		});
		mntmTrangChu.setFont(UIManager.getFont("MenuBar.font"));
		menuBar.add(mntmTrangChu);


		JMenu mnDanhMuc = new JMenu("  Danh mục");
		mnDanhMuc.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnDanhMuc);

		JMenuItem mntmDanhMucDichVu = new JMenuItem("Dịch vụ");
		mntmDanhMucDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DichVu(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucDichVu);

		JMenuItem mntmDanhMucKhachHang = new JMenuItem("Khách hàng");
		mntmDanhMucKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_KhachHang(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucKhachHang);

		JMenuItem mntmDanhMucPhong = new JMenuItem("Phòng");
		mntmDanhMucPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_Phong(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucPhong);

		JMenuItem mntmDanhMucNhanVien = new JMenuItem("Nhân viên");
		mntmDanhMucNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_NhanVien(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucNhanVien);

		JMenuItem mnXuLi = new JMenuItem("Xử lí");
		mnXuLi.setHorizontalAlignment(SwingConstants.CENTER);
		mnXuLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		mnXuLi.setFont(UIManager.getFont("MenuBar.font"));
		menuBar.add(mnXuLi);

		JMenu mnTimKiem = new JMenu("Tìm kiếm ");
		mnTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnTimKiem);

		JMenuItem mntmTimKiemDichVu = new JMenuItem("Dịch vụ");
		mntmTimKiemDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TimKiemDichVu(tk).setVisible(true);
			}
		});
		mnTimKiem.add(mntmTimKiemDichVu);

		JMenuItem mntmTimKiemHoaDon = new JMenuItem("Hóa đơn");
		mntmTimKiemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TimKiemHoaDon(tk).setVisible(true);
			}
		});
		mnTimKiem.add(mntmTimKiemHoaDon);

		JMenu mnThongKe = new JMenu(" Thống kê ");
		mnThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnThongKe);

		JMenuItem mntmThongKeDoanhThu = new JMenuItem("Doanh thu");
		mntmThongKeDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongKeHoaDon(tk).setVisible(true);
			}
		});
		mnThongKe.add(mntmThongKeDoanhThu);

		JMenuItem mntmThongKeDichVu = new JMenuItem("Dịch vụ");
		mntmThongKeDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongKeDichVu(tk).setVisible(true);
			}
		});
		mnThongKe.add(mntmThongKeDichVu);

		JMenuItem mnTroGiup = new JMenuItem("Trợ giúp ");
		mnTroGiup.setSelected(true);
		mnTroGiup.setHorizontalAlignment(SwingConstants.CENTER);
		mnTroGiup.setFont(UIManager.getFont("MenuBar.font"));
		mnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TroGiup(tk).setVisible(true);
			}
		});
		menuBar.add(mnTroGiup);

		JLabel lblTrangChu = new JLabel("Trang Chủ");
		lblTrangChu.setForeground(new Color(101, 186, 118));
		lblTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangChu.setBounds(588, 44, 300, 50);
		lblTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblTrangChu);

		JLabel lblTitleTroGiup = new JLabel("Hỗ Trợ");
		lblTitleTroGiup.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitleTroGiup.setBounds(304, 10, 188, 54);
		contentPane.add(lblTitleTroGiup);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 60, 302, 532);
		panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		panelLeft.setBackground(new Color(101, 186, 118));

		JLabel lblThongTinLienHe = new JLabel("Thông tin liên hệ");
		lblThongTinLienHe.setBounds(22, 10, 196, 29);
		lblThongTinLienHe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panelLeft.add(lblThongTinLienHe);

		JLabel lblKaraokenightgmailcom = new JLabel("KaraokeNight@gmail.com");
		lblKaraokenightgmailcom.setIcon(new ImageIcon("image\\mail.png"));
		lblKaraokenightgmailcom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKaraokenightgmailcom.setBounds(10, 211, 282, 77);
		panelLeft.add(lblKaraokenightgmailcom);

		JLabel lbl_iconDiaChi = new JLabel("");
		lbl_iconDiaChi.setIcon(new ImageIcon("image\\location.png"));
		lbl_iconDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_iconDiaChi.setBounds(0, 82, 64, 90);
		panelLeft.add(lbl_iconDiaChi);

		JLabel lblKaraokenightgmailcom_1 = new JLabel("0909686868");
		lblKaraokenightgmailcom_1
				.setIcon(new ImageIcon("image\\phone.png"));
		lblKaraokenightgmailcom_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKaraokenightgmailcom_1.setBounds(10, 296, 282, 77);
		panelLeft.add(lblKaraokenightgmailcom_1);

		JTextArea textArea_DiaChi = new JTextArea("28 Khổng Tử, Bình Thọ, Thủ Đức, Thành Phố Hồ Chí Minh");
		textArea_DiaChi.setLineWrap(true);
		textArea_DiaChi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea_DiaChi.setEditable(false);
		textArea_DiaChi.setBounds(62, 66, 208, 106);
		panelLeft.add(textArea_DiaChi);

		JPanel panelRight = new JPanel();
		panelRight.setBounds(304, 60, 456, 532);
		panelRight.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelRight);
		panelRight.setLayout(null);
		panelRight.setBackground(new Color(101, 186, 118));

		JLabel lblGuiLoiNhan = new JLabel("Gửi Lời Nhắn");
		lblGuiLoiNhan.setBounds(138, 10, 185, 29);
		lblGuiLoiNhan.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panelRight.add(lblGuiLoiNhan);

		JLabel lblHoVaTen = new JLabel("Họ và tên");
		lblHoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblHoVaTen.setBounds(10, 49, 196, 29);
		panelRight.add(lblHoVaTen);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtHoVaTen.setBounds(10, 82, 196, 40);
		panelRight.add(txtHoVaTen);
		txtHoVaTen.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmail.setBounds(239, 49, 196, 29);
		panelRight.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(239, 82, 196, 40);
		panelRight.add(txtEmail);

		JLabel lblTitle = new JLabel("Tiêu đề");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTitle.setBounds(10, 163, 196, 29);
		panelRight.add(lblTitle);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoDienThoai.setBounds(239, 163, 196, 29);
		panelRight.add(lblSoDienThoai);

		JLabel lblLoiNhan = new JLabel("Lời nhắn của bạn");
		lblLoiNhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoiNhan.setBounds(10, 278, 196, 29);
		panelRight.add(lblLoiNhan);

		txtTieuDe = new JTextField();
		txtTieuDe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTieuDe.setColumns(10);
		txtTieuDe.setBounds(10, 190, 196, 41);
		panelRight.add(txtTieuDe);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(239, 190, 196, 41);
		panelRight.add(txtSoDienThoai);

		JButton btnGuiTinNhan = new JButton("Gửi tin nhắn");
		btnGuiTinNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnGuiTinNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hehe();
				dispose();
				new GUI_TroGiup(tk).setVisible(true);
			}
		});
		btnGuiTinNhan.setBounds(10, 471, 142, 29);

		panelRight.add(btnGuiTinNhan);

		JTextArea txtLoiNhan = new JTextArea("");
		txtLoiNhan.setLineWrap(true);
		txtLoiNhan.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtLoiNhan.setBounds(10, 317, 425, 106);
		panelRight.add(txtLoiNhan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuy.setBounds(318, 471, 117, 29);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TrangChu(tk).setVisible(true);
			}
		});
		panelRight.add(btnHuy);
		
		JLabel lblThongBaoHoTen = new JLabel("*");
		lblThongBaoHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBaoHoTen.setBounds(10, 124, 196, 40);
		panelRight.add(lblThongBaoHoTen);
		
		JLabel lblThongBaoEmail = new JLabel("*");
		lblThongBaoEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBaoEmail.setBounds(239, 124, 196, 40);
		panelRight.add(lblThongBaoEmail);
		
		JLabel lblThongBaoTieuDe = new JLabel("*");
		lblThongBaoTieuDe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBaoTieuDe.setBounds(10, 228, 196, 40);
		panelRight.add(lblThongBaoTieuDe);
		
		JLabel lblThongBaoSDT = new JLabel("*");
		lblThongBaoSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBaoSDT.setBounds(239, 228, 196, 40);
		panelRight.add(lblThongBaoSDT);
		
		JLabel lblThongBaoLoiNhan = new JLabel("*");
		lblThongBaoLoiNhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBaoLoiNhan.setBounds(10, 421, 196, 40);
		panelRight.add(lblThongBaoLoiNhan);
	}
	
	protected boolean kiemTraDuLieu() {
		String soDienThoai = txtSoDienThoai.getText();
		String hoVaTen = txtHoVaTen.getText();
		String email = txtEmail.getText();
		String tieuDe = txtTieuDe.getText();
		if (soDienThoai.equals("") || !(soDienThoai.matches("^(0){1}[0-9]{9}$"))) {
			lblThongBaoSDT.setText("Nhập số điện thoại 10 số, bắt đầu bằng số 0");
			txtSoDienThoai.requestFocus();
			return false;
		} else
			lblThongBaoSDT.setText("");
		if (!(hoVaTen.length() > 0)) {
			lblThongBaoHoTen.setText("Nhập họ và tên");
			txtHoVaTen.requestFocus();
			return false;
		} else
			lblThongBaoHoTen.setText("");
		if (!(email.length() > 0)) {
			lblThongBaoEmail.setText("Nhập email");
			txtEmail.requestFocus();
			return false;
		} else
			lblThongBaoEmail.setText("");
		if (!(tieuDe.length() > 0)) {
			lblThongBaoTieuDe.setText("Nhập họ và tên");
			txtTieuDe.requestFocus();
			return false;
		} else
			lblThongBaoTieuDe.setText("");
		return true;
		}
	
	private void Hehe() {
		JOptionPane.showMessageDialog(this,"Cảm ơn vì đã gửi hỗ trợ, chúng tôi sẽ xem xét và gửi phản hồi cho bạn trong khoảng thời gian ngắn nhất! ^^ ");
	}
}

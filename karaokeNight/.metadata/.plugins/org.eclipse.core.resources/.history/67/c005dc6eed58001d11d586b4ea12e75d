package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Dao_NhanVien;
import dao.Dao_Phong;
import dao.Dao_TaiKhoan;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_Phong extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField txtMaPhong;
	private JTextField txtGiaPhong;
	private JTable table;
	private DefaultTableModel modelPhong;
	private JScrollPane cpPhong;
	private Dao_Phong dao_phong = new Dao_Phong();
	private Dao_TaiKhoan dao_TaiKhoan = new Dao_TaiKhoan();
	private TaiKhoan tk;
	private Dao_NhanVien dao_NhanVien;
	private JComboBox cbSoLuongNguoi;
	private JComboBox cbLoaiPhong;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnHuy;
	private JLabel lblThongBaoGiaPhong;
	private JLabel lblThongBaoMaPhong;
	private JButton btnThem;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public GUI_Phong(TaiKhoan taiKhoan) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tk=taiKhoan;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 108));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 1, 377, 20);
		contentPane.add(menuBar);

		JMenu mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnTrangChu);

		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ");
		mntmTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_TrangChu(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmTrangChu);

		JMenuItem mntmThongTinTaiKhoan = new JMenuItem("Thông tin tài khoản");
		mntmThongTinTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_ThongTinTaiKhoan(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmThongTinTaiKhoan);

		JMenuItem mntmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mntmDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DoiMatKhau(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmDoiMatKhau);

		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DangNhap().setVisible(true);
			}
		});
		mnTrangChu.add(mntmDangXuat);

		JSeparator separator = new JSeparator();
		mnTrangChu.add(separator);

		JMenu mnDanhMuc = new JMenu("Danh mục");
		menuBar.add(mnDanhMuc);

		JSeparator separator_1 = new JSeparator();
		mnDanhMuc.add(separator_1);

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

		JMenuItem mnXuLi = new JMenuItem(" Xử lí  ");
		mnXuLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		mnXuLi.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnXuLi);

		JMenu mnTimKiem = new JMenu("Tìm kiếm");
		menuBar.add(mnTimKiem);

		JSeparator separator_2 = new JSeparator();
		mnTimKiem.add(separator_2);

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

		JMenu mnThongKe = new JMenu("Thống kê");
		menuBar.add(mnThongKe);

		JSeparator separator_3 = new JSeparator();
		mnThongKe.add(separator_3);

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

		JLabel lblNewLabel = new JLabel("Quản lý phòng");
		lblNewLabel.setBounds(640, 33, 200, 60);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(101, 186, 118));
		panel.setBounds(0, 103, 1480, 207);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel lblMaPhong = new JPanel();
		lblMaPhong.setBounds(330, 25, 300, 30);
		panel.add(lblMaPhong);
		lblMaPhong.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setBounds(0, 0, 61, 30);
		lblMaPhong.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		txtMaPhong = new JTextField();
		txtMaPhong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String maPhong = txtMaPhong.getText();
				Phong p = dao_phong.getPhong(maPhong);
				if (!(maPhong.length() > 0 && maPhong.matches("(P)(Vip)?\\d{6}"))) {
					lblThongBaoMaPhong.setText("Ví dụ mẫu :P001002 hoặc PVip001002");
				} else if (p != null) {
					lblThongBaoMaPhong.setText("Mã phòng đã tồn tại");
				} else
					lblThongBaoMaPhong.setText("");
			}
		});
		txtMaPhong.setEditable(false);
		txtMaPhong.setBounds(140, 0, 160, 30);
		lblMaPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(330, 88, 300, 30);
		panel.add(panel_1_1);

		JLabel lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(0, 0, 130, 30);
		panel_1_1.add(lblLoaiPhong);

		cbLoaiPhong = new JComboBox<String>();
		cbLoaiPhong.setEnabled(false);
		cbLoaiPhong.setModel(new DefaultComboBoxModel<>(new String[] { "Phòng thường", "Phòng vip" }));
		cbLoaiPhong.setBounds(140, 0, 160, 30);
		cbLoaiPhong.setSelectedIndex(0);
		panel_1_1.add(cbLoaiPhong);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(835, 25, 300, 30);
		panel.add(panel_1_2);

		JLabel lblSoLuongNguoi = new JLabel("Số lượng người");
		lblSoLuongNguoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoLuongNguoi.setBounds(0, 0, 130, 30);
		panel_1_2.add(lblSoLuongNguoi);

		cbSoLuongNguoi = new JComboBox<>();
		cbSoLuongNguoi.setEnabled(false);
		cbSoLuongNguoi.setModel(new DefaultComboBoxModel<>(new String[] { "6", "10", "15", "20", "40", "60" }));
		cbSoLuongNguoi.setBounds(140, 0, 160, 30);
		panel_1_2.add(cbSoLuongNguoi);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(835, 88, 300, 30);
		panel.add(panel_1_3);

		JLabel lblGiaPhong = new JLabel("Giá phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiaPhong.setBounds(0, 0, 112, 30);
		panel_1_3.add(lblGiaPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String gp = txtGiaPhong.getText();
				if (!(gp.equals("")) && gp.matches("^[0-9]*$")) {
					lblThongBaoGiaPhong.setText("");
				} else
					lblThongBaoGiaPhong.setText("Nhập giá phòng > 0");
			}
		});
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(140, 0, 160, 30);
		panel_1_3.add(txtGiaPhong);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaPhong.isEditable() == false) {
					txtMaPhong.setText("");
					txtGiaPhong.setText("");
					cbLoaiPhong.setSelectedIndex(0);
					cbSoLuongNguoi.setSelectedIndex(0);
					moKhoaTextField();
					btnHuy.setEnabled(true);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
					removeMouseListenner();
				} else {
					if (kiemTraDuLieu() == true) {
						themPhong();
					}
				}
			}
		});
		btnThem.setBackground(new Color(255, 255, 108));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThem.setBounds(541, 152, 90, 30);
		panel.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 255, 108));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnHuy.isEnabled() == false) {
					btnThem.setEnabled(false);
					btnHuy.setEnabled(true);
					btnSua.setEnabled(false);
				} else {
					xoaPhong();
				}
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXoa.setBounds(664, 152, 90, 30);
		panel.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnHuy.isEnabled() == false) {
					moKhoaTextField();
					txtMaPhong.setEditable(false);
					cbLoaiPhong.setEnabled(false);
					btnThem.setEnabled(false);
					btnHuy.setEnabled(true);
					btnXoa.setEnabled(false);
				} else {
					if (kiemTraDuLieu() == true) {
						suaPhong();
					}
				}
			}
		});
		btnSua.setBackground(new Color(255, 255, 108));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSua.setBounds(784, 152, 90, 30);
		panel.add(btnSua);

		btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoaTextField();
				txtMaPhong.setText("");
				txtGiaPhong.setText("");
				lblThongBaoGiaPhong.setText("");
				lblThongBaoMaPhong.setText("");
				cbLoaiPhong.setSelectedIndex(0);
				cbSoLuongNguoi.setSelectedIndex(0);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(true);
				btnHuy.setEnabled(false);
			}
		});
		btnHuy.setBackground(new Color(255, 255, 108));
		btnHuy.setEnabled(false);
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(909, 152, 90, 30);
		panel.add(btnHuy);

		lblThongBaoMaPhong = new JLabel("");
		lblThongBaoMaPhong.setForeground(new Color(255, 0, 0));
		lblThongBaoMaPhong.setBounds(421, 60, 210, 13);
		panel.add(lblThongBaoMaPhong);

		lblThongBaoGiaPhong = new JLabel("");
		lblThongBaoGiaPhong.setForeground(Color.RED);
		lblThongBaoGiaPhong.setBounds(925, 125, 210, 13);
		panel.add(lblThongBaoGiaPhong);

		String[] colHeader = { "Mã phòng", "Loại phòng", "Giá phòng", "Số lượng người" };
		modelPhong = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelPhong);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(0, 295, 1480, 462);
		cpPhong = new JScrollPane(table);
		cpPhong.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cpPhong.setBounds(0, 310, 1480, 433);
		contentPane.add(cpPhong);
		table.setRowHeight(10);
		dao_NhanVien= new Dao_NhanVien();
		NhanVien nv = dao_NhanVien.getNhanVien(tk.getTenTaiKhoan());
		if(nv.getChucVu().equals("Nhân viên")) {
			btnSua.setEnabled(false);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
		}
		table.addMouseListener(this);
		docDuLieuTuSQL();
	}

	protected void xoaPhong() {
		int row = table.getSelectedRow();

		String maPhong = txtMaPhong.getText();
		String maLoaiPhong = (cbLoaiPhong.getSelectedItem().toString().equalsIgnoreCase("Phòng thường")) ? "PT"
				: "PVip";
		int soLuongNguoi = Integer.parseInt(cbSoLuongNguoi.getSelectedItem().toString());
		double giaPhong = Double.parseDouble(txtGiaPhong.getText());
		LoaiPhong lp = new LoaiPhong(maLoaiPhong);
		Phong p = new Phong(maPhong, "Trống", giaPhong, soLuongNguoi, lp);
		int a = 0;
		a = JOptionPane.showConfirmDialog(null, "Chắc chắn xóa ?", "Warning", JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.YES_OPTION) {
			dao_phong.deletePhong(p);
			modelPhong.removeRow(row);
		}
	}

	protected void suaPhong() {
		int row = table.getSelectedRow();

		String maPhong = txtMaPhong.getText();
		String maLoaiPhong = (cbLoaiPhong.getSelectedItem().toString().equalsIgnoreCase("Phòng thường")) ? "PT"
				: "PVip";
		int soLuongNguoi = Integer.parseInt(cbSoLuongNguoi.getSelectedItem().toString());
		double giaPhong = Double.parseDouble(txtGiaPhong.getText());
		LoaiPhong lp = new LoaiPhong(maLoaiPhong);
		Phong p = new Phong(maPhong, "Trống", giaPhong, soLuongNguoi, lp);
		int a = 0;
		a = JOptionPane.showConfirmDialog(null, "Chắc chắn sửa ?", "Warning", JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.YES_OPTION) {
			dao_phong.updatePhong(p);
			modelPhong.setValueAt(p.getGiaPhong(), row, 2);
			modelPhong.setValueAt(p.getSoLuongNguoi(), row, 3);
		}
	}

	protected void themPhong() {
		String maPhong = txtMaPhong.getText();
		String maLoaiPhong = (cbLoaiPhong.getSelectedItem().toString().equalsIgnoreCase("Phòng thường")) ? "PT"
				: "PVip";
		int soLuongNguoi = Integer.parseInt(cbSoLuongNguoi.getSelectedItem().toString());
		double giaPhong = Double.parseDouble(txtGiaPhong.getText());
		LoaiPhong lp = new LoaiPhong(maLoaiPhong);
		Phong p = new Phong(maPhong, "Trống", giaPhong, soLuongNguoi, lp);
		if (this.dao_phong.insertPhong(p) == false)
			JOptionPane.showMessageDialog(this, "Thất bại" );
		else {
			this.dao_phong.insertPhong(p);
			docDuLieuTuSQL();
			JOptionPane.showMessageDialog(this, "Thêm thành công");
		}
	}

	protected void khoaTextField() {
		txtMaPhong.setEditable(false);
		txtGiaPhong.setEditable(false);
		cbLoaiPhong.setEnabled(false);
		cbSoLuongNguoi.setEnabled(false);
		table.addMouseListener(this);
	}

	protected void removeMouseListenner() {
		table.removeMouseListener(this);
	}

	protected void moKhoaTextField() {
		txtMaPhong.setEditable(true);
		txtGiaPhong.setEditable(true);
		cbLoaiPhong.setEnabled(true);
		cbSoLuongNguoi.setEnabled(true);
	}

	private void docDuLieuTuSQL() {
		int d = modelPhong.getRowCount();
		while (modelPhong.getRowCount() != 0) {
			modelPhong.removeRow(d - 1);
			d = modelPhong.getRowCount();

		}
		dao_phong = new Dao_Phong();
		table.setRowHeight(25);
		for (Phong p : dao_phong.getAllPhong()) {
			Object[] rowData = { p.getMaPhong(), p.getMaLoaiPhong().getTenLoaiPhong(), p.getGiaPhong(),
					p.getSoLuongNguoi() };
			modelPhong.addRow(rowData);
		}
	}

	private boolean kiemTraDuLieu() {
		String maPhong = txtMaPhong.getText();
		if (!(maPhong.length() > 0 && maPhong.matches("(P)(Vip)?\\d{6}"))) {
			txtMaPhong.requestFocus();
			return false;
		}
		String gp = txtGiaPhong.getText();
		if (gp.equals("") || !(gp.matches("^[0-9]*$"))) {
			lblThongBaoGiaPhong.setText("Nhập giá phòng > 0");
			txtGiaPhong.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaPhong.setText(modelPhong.getValueAt(row, 0).toString());
		cbLoaiPhong.setSelectedItem(modelPhong.getValueAt(row, 1).toString());
		txtGiaPhong.setText(modelPhong.getValueAt(row, 2).toString());
		cbSoLuongNguoi.setSelectedItem(modelPhong.getValueAt(row, 3).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

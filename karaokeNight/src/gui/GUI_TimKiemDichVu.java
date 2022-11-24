package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import connectDB.ConnectDB;
import dao.Dao_DichVu;
import dao.Dao_LoaiDichVu;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.TaiKhoan;

public class GUI_TimKiemDichVu extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDichVu;
	private JTextField txtGiaDichVu;
	private DefaultTableModel modelDsDichVu;
	private JTable tblDsDichVu;
	private Dao_DichVu dao_dv;
	private Dao_LoaiDichVu dao_lDv;
	private DefaultComboBoxModel<String> cboLoaiTimKiem;
	private JComboBox<String> cmbLoaiTimKiem;
	JComboBox cbLoaiDichVu;
	private Object btnTimKiemDichVu;
	String oldText;
	String selectedValue = "";
	private TaiKhoan tk;

	List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(3);

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_TimKiemDichVu(TaiKhoan taiKhoan) {
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao_dv = new Dao_DichVu();
		dao_lDv = new Dao_LoaiDichVu();
		tk = taiKhoan;
		// contentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// menuBar
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

		// pnTop

		JPanel pnTop = new JPanel();
		pnTop.setBackground(new Color(101, 186, 118));
		pnTop.setBounds(0, 10, 1466, 52);
		contentPane.add(pnTop);

		JLabel lblTmKimDch = new JLabel("Tìm kiếm dịch vụ");
		lblTmKimDch.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblTmKimDch);
		// pnCenter

		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(new Color(101, 186, 118));
		pnCenter.setBounds(430, 66, 1036, 673);
		contentPane.add(pnCenter);

		String[] cols = { "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Giá", "Số lượng còn" };
		modelDsDichVu = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tblDsDichVu = new JTable(modelDsDichVu);
		JScrollPane scrtbl = new JScrollPane(tblDsDichVu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh sách dịch vụ"));
		scrtbl.setBounds(10, 23, 1016, 640);
		pnCenter.add(scrtbl);

		// pnLefp
		JPanel pnLeft = new JPanel();
		pnLeft.setBackground(new Color(101, 186, 118));
		pnLeft.setBounds(10, 66, 392, 673);
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Nhập thông tin dịch vụ cần tìm"));
		pnLeft.setLayout(null);

		JLabel lblLoaiDichVu = new JLabel("Loại dịch vụ :");
		lblLoaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiDichVu.setBounds(52, 65, 92, 14);
		pnLeft.add(lblLoaiDichVu);
		cbLoaiDichVu = new JComboBox();
		cbLoaiDichVu.setBounds(175, 58, 179, 26);
		pnLeft.add(cbLoaiDichVu);

		cbLoaiDichVu.setEnabled(false);

		JLabel lblTenDichVu = new JLabel("Tên dịch vụ  :");
		lblTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenDichVu.setBounds(52, 121, 92, 19);
		pnLeft.add(lblTenDichVu);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenDichVu.setBounds(175, 117, 179, 26);
		pnLeft.add(txtTenDichVu);
		txtTenDichVu.setColumns(10);

		JLabel lblGiaDichVu = new JLabel("Giá  :");
		lblGiaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiaDichVu.setBounds(104, 183, 40, 19);
		pnLeft.add(lblGiaDichVu);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaDichVu.setColumns(10);
		txtGiaDichVu.setBounds(175, 176, 179, 26);
		pnLeft.add(txtGiaDichVu);

		moKhoaTextfields(false);

		ImageIcon iconTimKiem = new ImageIcon("IMG//iconButton//Search.png");
		JButton btnTimKiemDichVu = new JButton("Tìm kiếm", iconTimKiem);
		btnTimKiemDichVu.setBackground(new Color(255, 255, 140));
		btnTimKiemDichVu.setForeground(new Color(0, 0, 0));
		btnTimKiemDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTimKiemDichVu.setBounds(54, 273, 300, 33);
		pnLeft.add(btnTimKiemDichVu);

		ImageIcon iconLamMoi = new ImageIcon("IMG//iconButton//Refresh.png");
		JButton btnLamMoiDichVu = new JButton("Làm mới", iconLamMoi);
		btnLamMoiDichVu.setBackground(new Color(255, 255, 140));
		btnLamMoiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiDichVu.setBounds(54, 335, 300, 33);
		pnLeft.add(btnLamMoiDichVu);

		// Đưa dữ liệu vào combobox
		ArrayList<LoaiDichVu> loaiDv = dao_lDv.getAllLoaiDichVu();
		for (LoaiDichVu lDv : loaiDv) {
			cbLoaiDichVu.addItem(lDv.getTenLoaiDichVu());
		}

		// load dữ liệu lên table
		DocDuLieuDatabaseVaoTable();

		// Bắt đầu tìm kiếm
		btnTimKiemDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moKhoaTextfields(true);
				cbLoaiDichVu.setEnabled(true);
				btnTimKiemDichVu.setEnabled(false);
			}
		});

		TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(modelDsDichVu);
		cbLoaiDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedValue = (String) cbLoaiDichVu.getSelectedItem();
				RowFilter<Object, Object> temp = RowFilter.regexFilter(selectedValue, 2);
				if (!filters.isEmpty() && filters.indexOf(temp) != -1)
					filters.remove(filters.indexOf(temp));
				filters.add(temp);
				RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter(selectedValue, 2);
				rowSorter.setRowFilter(rf);
			}

		});

		txtTenDichVu.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = txtTenDichVu.getText();
				if (!txtGiaDichVu.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtGiaDichVu.getText().toString(), 3));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 1);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.remove(filters.indexOf(temp));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = txtTenDichVu.getText();
				if (text.trim().length() == 0) {
					RowFilter<DefaultTableModel, Object> rf;
					if (filters.size() == 0) {
						rf = RowFilter.regexFilter("DV", 0);
						rowSorter.setRowFilter(rf);
					} else if (filters.size() == 1) {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						if (!txtGiaDichVu.getText().isBlank()) {
							RowFilter<Object, Object> temp = RowFilter.regexFilter(txtGiaDichVu.getText().toString(),
									3);
							filter.add(temp);
						}
						if (!selectedValue.isBlank()) {
							RowFilter<Object, Object> temp1 = RowFilter.regexFilter(selectedValue, 2);
							filter.add(temp1);
						}
						rf = RowFilter.orFilter(filter);
						rowSorter.setRowFilter(rf);
						if (selectedValue.isBlank())
							filters.remove(0);
					} else {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						RowFilter<Object, Object> temp = RowFilter.regexFilter(txtGiaDichVu.getText().toString(), 3);

						filter.add(temp);
						RowFilter<Object, Object> temp1 = RowFilter.regexFilter(selectedValue, 2);
						filter.add(temp1);
						rf = RowFilter.andFilter(filter);
						rowSorter.setRowFilter(rf);
						filters.remove(0);
					}
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 1);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.remove(filters.indexOf(temp));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}
		});

		txtGiaDichVu.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (!txtTenDichVu.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtTenDichVu.getText().toString(), 1));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				String text = txtGiaDichVu.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 3);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.remove(filters.indexOf(temp));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = txtGiaDichVu.getText();
				if (text.trim().length() == 0) {
					RowFilter<DefaultTableModel, Object> rf;
					if (filters.isEmpty()) {
						rf = RowFilter.regexFilter("DV", 0);
						rowSorter.setRowFilter(rf);
					} else if (filters.size() == 1) {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						if (!txtTenDichVu.getText().isBlank()) {
							RowFilter<Object, Object> temp = RowFilter.regexFilter(txtTenDichVu.getText().toString(),
									1);
							filter.add(temp);
						}
						if (!selectedValue.isBlank()) {
							RowFilter<Object, Object> temp1 = RowFilter.regexFilter(selectedValue, 2);
							filter.add(temp1);
						}
						rf = RowFilter.orFilter(filter);
						rowSorter.setRowFilter(rf);
						if (selectedValue.isBlank())
							filters.remove(0);
					} else {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						RowFilter<Object, Object> temp = RowFilter.regexFilter(txtTenDichVu.getText().toString(), 1);
						filter.add(temp);
						RowFilter<Object, Object> temp1 = RowFilter.regexFilter(selectedValue, 2);
						filter.add(temp1);
						rf = RowFilter.andFilter(filter);
						rowSorter.setRowFilter(rf);
						filters.remove(0);
					}
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 3);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.remove(filters.indexOf(temp));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}
		});
		tblDsDichVu.setRowSorter(rowSorter);
		// Kết thúc tìm kiếm

		// Click dữ liệu trên table đưa vào textFile
		tblDsDichVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblDsDichVu.getSelectedRow();
				if (row >= 0) {
					napDichVuVaoTextfields();
					rowSorter.setRowFilter(null);
				}
			}
		});

		// Thực hiện làm mới
		btnLamMoiDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moKhoaTextfields(false);
				cbLoaiDichVu.setEnabled(false);
				btnTimKiemDichVu.setEnabled(true);
				xoaRongTextfields();
				rowSorter.setRowFilter(null);
			}
		});
	}

	// Lấy dữ liệu từ database để đưa lên table
	public void DocDuLieuDatabaseVaoTable() {
		ArrayList<DichVu> listDV = dao_dv.getAllDichVu();
		for (DichVu dv : listDV) {
			modelDsDichVu
					.addRow(new Object[] { dv.getMaDichVu(), dv.getTenDichVu(), dv.getMaLoaiDichVu().getTenLoaiDichVu(),
							formatNumberForMoney(dv.getGiaDichVu()), dv.getSoLuong(), });
		}
	}

	// Nạp dữ liệu vào TextFile
	private void napDichVuVaoTextfields() {
		int row = tblDsDichVu.getSelectedRow();
		if (row >= 0) {
			if (modelDsDichVu.getValueAt(row, 2) != null) {
				String loaiDV = modelDsDichVu.getValueAt(row, 2).toString();
				cbLoaiDichVu.setSelectedItem(loaiDV);
			} else
				cbLoaiDichVu.setSelectedIndex(2);
			txtTenDichVu.setText(modelDsDichVu.getValueAt(row, 1).toString());
			txtGiaDichVu.setText(modelDsDichVu.getValueAt(row, 3).toString());
		}
	}

	private void moKhoaTextfields(boolean b) {
		txtTenDichVu.setEditable(b);
		txtGiaDichVu.setEditable(b);
	}

	private void xoaRongTextfields() {
		txtTenDichVu.setText("");
		txtGiaDichVu.setText("");
	}

	private String formatNumberForMoney(double money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String str1 = currencyVN.format(Math.round(money));
		str1 = str1.substring(0, str1.length() - 2);
		return str1 + " VND";
	}

}

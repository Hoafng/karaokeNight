package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_CTHoaDon;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_NhanVien;
import dao.Dao_Phong;
import entity.CTHoaDonThuePhong;
import entity.HoaDonThuePhong;
import entity.TaiKhoan;

public class GUI_TimKiemHoaDon extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelDsHoaDon;
	private JTable tblDsHoaDon;
	private JTextField txtTenNhanVienLapHD;
	private JDateChooser dateChooser;
	private JTextField txtTenKhachHang;
	private JTextField txtNgayLapHD;
	private Dao_KhachHang dao_kh;
	private Dao_NhanVien dao_nv;
	private Dao_HoaDon dao_hdt;
	private Dao_CTHoaDon dao_CTHD = new Dao_CTHoaDon();
	private Dao_Phong dao_Phong = new Dao_Phong();
	private TaiKhoan tk;

	List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(3);

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_TimKiemHoaDon(TaiKhoan taiKhoan) {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tk =taiKhoan;
		dao_kh = new Dao_KhachHang();
		dao_nv = new Dao_NhanVien();
		dao_hdt = new Dao_HoaDon();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
				new GUI_KhachHang(tk, null).setVisible(true);
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
		mntmTimKiemHoaDon.setSelected(true);
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
		mnTroGiup.setHorizontalAlignment(SwingConstants.CENTER);
		mnTroGiup.setFont(UIManager.getFont("MenuBar.font"));
		mnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TroGiup(tk).setVisible(true);
			}
		});
		menuBar.add(mnTroGiup);

		JPanel pnTop = new JPanel();
		pnTop.setBounds(0, 10, 1466, 52);
		pnTop.setBackground(new Color(101, 186, 118));
		contentPane.add(pnTop);

		JLabel lblTimKiemHoaDon = new JLabel("Tìm kiếm hóa đơn");
		lblTimKiemHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblTimKiemHoaDon);

		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(430, 66, 1036, 673);
		pnCenter.setBackground(new Color(101, 186, 118));
		contentPane.add(pnCenter);
		String[] cols = { "Mã hóa đơn", "Nhân viên lập hóa đơn", "Tên khách hàng", "Ngày lập hóa đơn", "Thành tiền" };
		modelDsHoaDon = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tblDsHoaDon = new JTable(modelDsHoaDon);
		JScrollPane scrtbl = new JScrollPane(tblDsHoaDon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		scrtbl.setBounds(10, 23, 1016, 640);
		pnCenter.add(scrtbl);

		DocDuLieuDatabaseVaoTable();

		JPanel pnLeft = new JPanel();
		pnLeft.setBounds(10, 66, 392, 673);
		pnLeft.setToolTipText("");
		pnLeft.setBackground(new Color(101, 186, 118));
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Nhập thông tin hóa đơn cần tìm"));
		pnLeft.setLayout(null);

		JLabel lblTenNhanVienLapHD = new JLabel("Tên nhân viên lâp:");
		lblTenNhanVienLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenNhanVienLapHD.setBounds(22, 56, 143, 30);
		pnLeft.add(lblTenNhanVienLapHD);

		txtTenNhanVienLapHD = new JTextField();
		txtTenNhanVienLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenNhanVienLapHD.setBounds(169, 56, 200, 30);
		pnLeft.add(txtTenNhanVienLapHD);
		txtTenNhanVienLapHD.setColumns(10);

		JLabel lblNgaylapHD = new JLabel("Ngày lập hóa đơn:");
		lblNgaylapHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgaylapHD.setBounds(22, 136, 137, 30);
		pnLeft.add(lblNgaylapHD);

		dateChooser = new JDateChooser();
		dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtNgayLapHD.setText(a + "");
				}
			}
		});
		dateChooser.getCalendarButton().setBounds(170, 0, 30, 33);
		dateChooser.setBounds(169, 136, 200, 30);
		pnLeft.add(dateChooser);
		dateChooser.setLayout(null);

		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNgayLapHD.setColumns(10);
		txtNgayLapHD.setBounds(0, 0, 172, 30);
		dateChooser.add(txtNgayLapHD);

		JLabel lblTenKhacHang = new JLabel("Tên khách hàng  :");
		lblTenKhacHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenKhacHang.setBounds(22, 216, 143, 30);
		pnLeft.add(lblTenKhacHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(169, 216, 200, 30);
		pnLeft.add(txtTenKhachHang);

		moKhoaTextfields(false);

		ImageIcon iconLamMoi = new ImageIcon("IMG//iconButton//Refresh.png");
		JButton btnLamMoiHoaDon = new JButton("Làm mới", iconLamMoi);
		btnLamMoiHoaDon.setBackground(new Color(255, 255, 140));
		btnLamMoiHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiHoaDon.setBounds(54, 377, 300, 33);
		pnLeft.add(btnLamMoiHoaDon);

		ImageIcon iconTimKiem = new ImageIcon("IMG//iconButton//Search.png");
		JButton btnTimKiemHoaDon = new JButton("Tìm kiếm", iconTimKiem);
		btnTimKiemHoaDon.setBackground(new Color(255, 255, 140));
		btnTimKiemHoaDon.setForeground(new Color(0, 0, 0));
		btnTimKiemHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTimKiemHoaDon.setBounds(54, 307, 300, 33);
		pnLeft.add(btnTimKiemHoaDon);

		btnTimKiemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moKhoaTextfields(true);
				btnTimKiemHoaDon.setEnabled(false);
			}
		});
		TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(modelDsHoaDon);
		txtTenNhanVienLapHD.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				String text = txtTenNhanVienLapHD.getText();
				if (!txtTenKhachHang.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtTenKhachHang.getText().toString(), 2));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!txtNgayLapHD.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtNgayLapHD.getText().toString(), 3));
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
				String text = txtTenNhanVienLapHD.getText();
				if (text.trim().length() == 0) {
					RowFilter<DefaultTableModel, Object> rf;
					if (filters.size() == 0) {
						rowSorter.setRowFilter(null);
					} else if (filters.size() == 1) {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						if (!txtNgayLapHD.getText().isBlank()) {
							RowFilter<Object, Object> temp = RowFilter.regexFilter(txtNgayLapHD.getText().toString(),
									3);
							filter.add(temp);
						}
						if (!txtTenKhachHang.getText().isBlank()) {
							RowFilter<Object, Object> temp1 = RowFilter
									.regexFilter(txtTenKhachHang.getText().toString(), 2);
							filter.add(temp1);
						}
						rf = RowFilter.orFilter(filter);
						rowSorter.setRowFilter(rf);
						if (txtTenKhachHang.getText().isBlank() || txtTenNhanVienLapHD.getText().isBlank()
								|| txtNgayLapHD.getText().isBlank())
							filters.remove(0);
					} else {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						RowFilter<Object, Object> temp = RowFilter.regexFilter(txtNgayLapHD.getText().toString(), 3);
						filter.add(temp);
						RowFilter<Object, Object> temp1 = RowFilter.regexFilter(txtTenKhachHang.getText().toString(),
								2);
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

		txtNgayLapHD.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = txtNgayLapHD.getText();
				if (!txtTenKhachHang.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtTenKhachHang.getText().toString(), 2));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!txtTenNhanVienLapHD.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtTenNhanVienLapHD.getText().toString(), 1));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
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
				String text = txtNgayLapHD.getText();
				if (text.trim().length() == 0) {
					RowFilter<DefaultTableModel, Object> rf;
					if (filters.size() == 0) {
						rowSorter.setRowFilter(null);
					} else if (filters.size() == 1) {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						if (!txtTenNhanVienLapHD.getText().isBlank()) {
							RowFilter<Object, Object> temp = RowFilter
									.regexFilter(txtTenNhanVienLapHD.getText().toString(), 1);
							filter.add(temp);
						}
						if (!txtTenKhachHang.getText().isBlank()) {
							RowFilter<Object, Object> temp1 = RowFilter
									.regexFilter(txtTenKhachHang.getText().toString(), 2);
							filter.add(temp1);
						}
						rf = RowFilter.orFilter(filter);
						rowSorter.setRowFilter(rf);
						if (txtTenKhachHang.getText().isBlank() || txtTenNhanVienLapHD.getText().isBlank()
								|| txtNgayLapHD.getText().isBlank())
							filters.remove(0);
					} else {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						RowFilter<Object, Object> temp = RowFilter.regexFilter(txtTenNhanVienLapHD.getText().toString(),
								1);
						filter.add(temp);
						RowFilter<Object, Object> temp1 = RowFilter.regexFilter(txtTenKhachHang.getText().toString(),
								2);
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

		txtTenKhachHang.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = txtTenKhachHang.getText();
				if (!txtTenNhanVienLapHD.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtTenNhanVienLapHD.getText().toString(), 1));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!txtNgayLapHD.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtNgayLapHD.getText().toString(), 3));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 2);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.remove(filters.indexOf(temp));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = txtTenKhachHang.getText();
				if (text.trim().length() == 0) {
					RowFilter<DefaultTableModel, Object> rf;
					if (filters.size() == 0) {
						rowSorter.setRowFilter(null);
					} else if (filters.size() == 1) {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						if (!txtTenNhanVienLapHD.getText().isBlank()) {
							RowFilter<Object, Object> temp = RowFilter
									.regexFilter(txtTenNhanVienLapHD.getText().toString(), 1);
							filter.add(temp);
						}
						if (!txtNgayLapHD.getText().isBlank()) {
							RowFilter<Object, Object> temp1 = RowFilter.regexFilter(txtNgayLapHD.getText().toString(),
									3);
							filter.add(temp1);
						}
						rf = RowFilter.orFilter(filter);
						rowSorter.setRowFilter(rf);

						if (txtTenKhachHang.getText().isBlank() || txtTenNhanVienLapHD.getText().isBlank()
								|| txtNgayLapHD.getText().isBlank())
							filters.remove(0);
					} else {
						List<RowFilter<Object, Object>> filter = new ArrayList<>();
						RowFilter<Object, Object> temp = RowFilter.regexFilter(txtTenNhanVienLapHD.getText().toString(),
								1);
						filter.add(temp);
						RowFilter<Object, Object> temp1 = RowFilter.regexFilter(txtNgayLapHD.getText().toString(), 3);
						filter.add(temp1);
						rf = RowFilter.andFilter(filter);
						rowSorter.setRowFilter(rf);
						filters.remove(0);
					}
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 2);
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
		tblDsHoaDon.setRowSorter(rowSorter);

		btnLamMoiHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moKhoaTextfields(false);
				btnTimKiemHoaDon.setEnabled(true);
				xoaRongTextfields();
				rowSorter.setRowFilter(null);
			}
		});

		tblDsHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblDsHoaDon.getSelectedRow();
				if (row >= 0) {
					napHoaDonVaoTextfields();
					rowSorter.setRowFilter(null);
				}
			}
		});

	}
	// Lấy dữ liệu từ database để đưa lên table

	public void DocDuLieuDatabaseVaoTable() {
		ArrayList<HoaDonThuePhong> listHD = dao_hdt.getAllHoaDonDaThanhToan();
		double tdv = 0;
		double tp = 0;
		for (HoaDonThuePhong hd : listHD) {
			for (CTHoaDonThuePhong ct : dao_CTHD.getAllCTHDDichVuDaThanhToan(hd.getMaPhong().getMaPhong())) {
				if (ct != null)
					tdv = tienDichVu(ct.getSoLuongDichVu(), ct.getMaDichVu().getGiaDichVu());
			}
			tp = tongTienPhong(hd.getGioVaoPhong(), hd.getGioRaPhong(),
					dao_Phong.getPhong(hd.getMaPhong().getMaPhong()).getGiaPhong());

			modelDsHoaDon.addRow(new Object[] { hd.getMaHoaDon(), hd.getMaNhanVien().getTenNhanVien(),
					hd.getMaKhachHang().getTenKhachHang(), hd.getNgayLap(), formatNumberForMoney(tongTien(tdv, tp)) });
		}
	}

	// Nạp dữ liệu vào TextFile
	private void napHoaDonVaoTextfields() {
		int row = tblDsHoaDon.getSelectedRow();
		if (row >= 0) {
			txtTenNhanVienLapHD.setText(modelDsHoaDon.getValueAt(row, 1).toString());
			txtTenKhachHang.setText(modelDsHoaDon.getValueAt(row, 2).toString());
			txtNgayLapHD.setText(modelDsHoaDon.getValueAt(row, 3).toString());

		}
	}

	private void moKhoaTextfields(boolean b) {
		txtTenNhanVienLapHD.setEditable(b);
		txtTenKhachHang.setEditable(b);
		txtNgayLapHD.setEditable(b);
		dateChooser.setEnabled(b);
	}

	private void xoaRongTextfields() {
		txtTenKhachHang.setText("");
		txtTenNhanVienLapHD.setText("");
		txtNgayLapHD.setText("");
	}

	public double tongTien(double tienPhong, double tienDichVu) {

		return tienPhong + tienDichVu;
	}

	public double tongTienPhong(Timestamp gioVaoPhong, Timestamp gioRaPhong, double giaPhong) {

		double tongTien = ((gioRaPhong.getTime() - gioVaoPhong.getTime()) / 1000 / 60) * (giaPhong / 60);
		return tongTien;
	}

	public double tienDichVu(int soLuongDichVu, double giaDichVu) {
		double tongTien = soLuongDichVu * giaDichVu * 1.0;
		return tongTien;
	}

	private String formatNumberForMoney(double money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String str1 = currencyVN.format(Math.round(money));
		str1 = str1.substring(0, str1.length() - 2);
		return str1 + " VNĐ";
	}

}

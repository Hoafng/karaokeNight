package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_CTHoaDon;
import dao.Dao_DichVu;
import dao.Dao_LoaiDichVu;
import dao.Dao_ThongKeDichVu;
import entity.CTHoaDonThuePhong;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.TaiKhoan;

public class GUI_ThongKeDichVu extends JFrame implements ActionListener, PropertyChangeListener{

	private JPanel contentPane;
	private DefaultTableModel modelTkDichVu;
	private JTable tblTkDichVu;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JTextField txtTuNgay;
	private JTextField txtDenNgay;
	private Dao_DichVu dao_dv;
	private Dao_CTHoaDon dao_CTHD = new Dao_CTHoaDon();
	private TaiKhoan tk;
	private Dao_ThongKeDichVu dao_tkdv;
	private boolean checkDateChooser = false, checkDateChooser_1 = false;
	private DefaultTableModel TempModelTkDichVu;
	private JLabel lblKqTienDichVuBan;
	private JLabel lblKqDichVuBan;
	private JLabel lblKqDichVuBanChay;
	private Dao_LoaiDichVu dao_lDv;
	String oldText;
	String selectedValue = "";
	List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(3);
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI_ThongKeDichVu(TaiKhoan taiKhoan) {
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao_dv = new Dao_DichVu();
		dao_lDv = new Dao_LoaiDichVu();
		dao_tkdv = new Dao_ThongKeDichVu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1480,780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
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
				new GUI_KhachHang(tk,null).setVisible(true);
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
		mntmThongKeDichVu.setSelected(true);
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
		pnTop.setBounds(0, 35, 1466, 52);
		pnTop.setBackground(new Color(101, 186, 118));
		contentPane.add(pnTop);
		pnTop.setLayout(null);

		JLabel lblThongKeDichVu = new JLabel("Thống kê dịch vụ");
		lblThongKeDichVu.setBounds(731, 10, 224, 35);
		lblThongKeDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblThongKeDichVu);


		JPanel pnLeft = new JPanel();
		pnLeft.setBounds(10, 97, 392, 636);
		pnLeft.setBackground(new Color(101, 186, 118));
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Nhập vào để thống kê"));
		pnLeft.setLayout(null);

		JLabel lblTuNgay = new JLabel("Từ ngày:");
		lblTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTuNgay.setBounds(36, 73, 102, 34);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBounds(169, 0, 31, 30);
		dateChooser.setBounds(159, 77, 200, 30);
		pnLeft.add(dateChooser);
		dateChooser.setLayout(null);

		txtTuNgay = new JTextField();
		txtTuNgay.setBounds(0, 0, 170, 30);
		dateChooser.add(txtTuNgay);
		txtTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTuNgay.setColumns(10);
		pnLeft.add(lblTuNgay);


		JLabel lblDenNgay = new JLabel("Đến ngày:");
		lblDenNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDenNgay.setBounds(36, 142, 102, 30);
		dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBounds(170, 0, 30, 30);
		dateChooser_1.setBounds(159, 142, 200, 30);
		pnLeft.add(dateChooser_1);
		dateChooser_1.setLayout(null);

		txtDenNgay = new JTextField();
		txtDenNgay.setBounds(0, 0, 170, 30);
		dateChooser_1.add(txtDenNgay);
		txtDenNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDenNgay.setColumns(10);
		pnLeft.add(lblDenNgay);

		moKhoaTextfields(false);

		ImageIcon iconLamMoi = new ImageIcon("IMG//iconButton//Refresh.png");
		JButton btnLamMoiDichVu = new JButton("Làm mới", iconLamMoi);
		btnLamMoiDichVu.setBackground(new Color(255, 255, 140));
		btnLamMoiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiDichVu.setBounds(68, 448, 291, 33);
		pnLeft.add(btnLamMoiDichVu);

		ImageIcon iconThongKe = new ImageIcon("IMG//iconButton//statistical.png");
		JButton btnThongKe = new JButton("Thống kê", iconThongKe);
		btnThongKe.setBackground(new Color(255, 255, 140));
		btnThongKe.setForeground(new Color(0, 0, 0));
		btnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThongKe.setBounds(68, 383, 291, 33);
		pnLeft.add(btnThongKe);

		JButton btnInThongKe = new JButton("Biểu đồ dịch vụ", new ImageIcon("IMG//iconButton//print.png"));
		btnInThongKe.setForeground(Color.BLACK);
		btnInThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnInThongKe.setBackground(new Color(255, 255, 140));
		btnInThongKe.setBounds(68, 515, 291, 33);
		pnLeft.add(btnInThongKe);



		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(430, 97, 1036, 636);
		pnCenter.setBackground(new Color(101, 186, 118));
		contentPane.add(pnCenter);
		String[] cols = { "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vu", "Giá", "Số lượng bán ra"};
		modelTkDichVu = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tblTkDichVu = new JTable(modelTkDichVu);
		JScrollPane scrtbl = new JScrollPane(tblTkDichVu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh sách dịch vụ"));
		scrtbl.setBounds(10, 25, 1016, 453);
		pnCenter.add(scrtbl);

		TempModelTkDichVu = new DefaultTableModel(cols, 0);

		JLabel lblTongDichVuBan = new JLabel("Tổng số lượng dịch vụ đã bán: ");
		lblTongDichVuBan.setForeground(new Color(255, 0, 0));
		lblTongDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongDichVuBan.setBounds(757, 497, 196, 26);
		pnCenter.add(lblTongDichVuBan);

		lblKqDichVuBan = new JLabel("");
		lblKqDichVuBan.setForeground(new Color(255, 0, 0));
		lblKqDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqDichVuBan.setBounds(963, 497, 63, 26);
		pnCenter.add(lblKqDichVuBan);

		JLabel lblDichVuBanChayNhat = new JLabel("Dịch vụ bán chạy nhất:");
		lblDichVuBanChayNhat.setForeground(new Color(255, 0, 0));
		lblDichVuBanChayNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDichVuBanChayNhat.setBounds(10, 548, 150, 21);
		pnCenter.add(lblDichVuBanChayNhat);

		lblKqDichVuBanChay = new JLabel("");
		lblKqDichVuBanChay.setForeground(new Color(255, 0, 0));
		lblKqDichVuBanChay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqDichVuBanChay.setBounds(170, 548, 113, 21);
		pnCenter.add(lblKqDichVuBanChay);

		JLabel lblTongTienDichVu = new JLabel("Tổng tiền dịch vụ đã bán: ");
		lblTongTienDichVu.setForeground(new Color(255, 0, 0));
		lblTongTienDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongTienDichVu.setBounds(10, 497, 164, 26);
		pnCenter.add(lblTongTienDichVu);

		lblKqTienDichVuBan = new JLabel("0 VNĐ");
		lblKqTienDichVuBan.setForeground(new Color(255, 0, 0));
		lblKqTienDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqTienDichVuBan.setBounds(182, 500, 143, 21);
		pnCenter.add(lblKqTienDichVuBan);

		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moKhoaTextfields(true);
			}
		});

		dateChooser.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");																																																																																																																																																												
						if ("date".equals(e.getPropertyName())) {
							String a = sf.format(e.getNewValue());		   
							txtTuNgay.setText(a + "");
							checkDateChooser = true;
							if(checkDateChooser && checkDateChooser_1) {
								ArrayList<DichVu> listDV = dao_tkdv.getDichVuDaBan(txtTuNgay.getText().toString(), txtDenNgay.getText().toString());
								DocDuLieuDatabaseVaoTable(listDV, TempModelTkDichVu);
								tblTkDichVu.setModel(TempModelTkDichVu);
								TempModelTkDichVu = new DefaultTableModel(cols, 0);
							}

						}
					}
				});


		dateChooser_1.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");																																																																																																																																																												
						if ("date".equals(e.getPropertyName())) {
							String a = sf.format(e.getNewValue());		   
							txtDenNgay.setText(a + "");
							checkDateChooser_1 = true;
							if(checkDateChooser && checkDateChooser_1) {
								ArrayList<DichVu> listDV = dao_tkdv.getDichVuDaBan(txtTuNgay.getText().toString(), txtDenNgay.getText().toString());
								DocDuLieuDatabaseVaoTable(listDV, TempModelTkDichVu);
								tblTkDichVu.setModel(TempModelTkDichVu);
								TempModelTkDichVu = new DefaultTableModel(cols, 0);
							}
							else if(txtTuNgay.getText().toString() != null && lblDenNgay.getText().toString() != null) {
								TableRowSorter<TableModel> rowSorter
								= new TableRowSorter<>(tblTkDichVu.getModel()) ;
								tblTkDichVu.setRowSorter(rowSorter);
								txtTuNgay.getDocument().addDocumentListener(new DocumentListener() {
									@Override
									public void insertUpdate(DocumentEvent e) {
										String text = txtTuNgay.getText();
										if (text.trim().length() == 0) {
											rowSorter.setRowFilter(null);
										} else {
											rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
										}
									}

									@Override
									public void removeUpdate(DocumentEvent e) {
										String text = txtTuNgay.getText();

										if (text.trim().length() == 0) {
											rowSorter.setRowFilter(null);
										} else {
											rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
										}
									}

									@Override
									public void changedUpdate(DocumentEvent e) {
										throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
									}
								});
							}
						}
					}
				});
	
		ArrayList<DichVu> listDV = dao_tkdv.getAllDichVuDaThanhToan();
		DocDuLieuDatabaseVaoTable(listDV, modelTkDichVu);
		btnLamMoiDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblTkDichVu.setModel(modelTkDichVu);
				lblKqTienDichVuBan.setText("0 VNĐ");
				lblKqDichVuBanChay.setText("");
				lblKqDichVuBan.setText("");
				txtTuNgay.setText("");
				txtDenNgay.setText("");
				moKhoaTextfields(false);
			}
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub


	}
	public void DocDuLieuDatabaseVaoTable(ArrayList<DichVu> listDV, DefaultTableModel modelTkDichVu) {
		double sum =0;
		double sumSl = 0;
		double maxSl = 0;
		String ldv = "";
		for (DichVu dv : listDV) {
			double tdv = tienDV(dv.getGiaDichVu(),dv.getSoLuong());
			double sl = dv.getSoLuong();

			sum = sum + tdv;
			sumSl = sumSl +  sl;
			if(sl >= maxSl) {
				maxSl = sl;
				ldv = dv.getTenDichVu();
			}
			modelTkDichVu.addRow(new Object[] {dv.getMaDichVu(),dv.getTenDichVu(),dv.getMaLoaiDichVu().getTenLoaiDichVu(),formatNumberForMoney(dv.getGiaDichVu()),dv.getSoLuong()});
		}
		lblKqTienDichVuBan.setText(formatNumberForMoney(sum));
		lblKqDichVuBan.setText(sumSl + "");
		lblKqDichVuBanChay.setText(ldv);
	}
	private String formatNumberForMoney(double money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String str1 = currencyVN.format(Math.round(money));
		str1 = str1.substring(0,str1.length() - 2);
		return str1 + " VNĐ";
	}
	private void moKhoaTextfields(boolean b) {
		txtTuNgay.setEditable(b);
		txtDenNgay.setEditable(b);
		dateChooser.setEnabled(b);
		dateChooser_1.setEnabled(b);
	}
	public double tienDV(double giaDichVu, int soluongbanRa) {
		double tienDV = giaDichVu * soluongbanRa;
		return tienDV;
	}

}

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_CTHoaDon;
import dao.Dao_HoaDon;
import dao.Dao_Phong;
import dao.Dao_ThongKeDoanhThu;
import entity.CTHoaDonThuePhong;
import entity.HoaDonThuePhong;
import entity.TaiKhoan;


public class GUI_ThongKeHoaDon extends JFrame{
private JPanel contentPane;
	private DefaultTableModel modelTkHoaDon;
	private JTable tblTkHoaDon;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JTextField txtTuNgay;
	private JTextField txtDenNgay;
	private TaiKhoan tk;
	private Dao_ThongKeDoanhThu dao_tkhd;
	private Dao_CTHoaDon dao_CTHD = new Dao_CTHoaDon();
	private Dao_HoaDon dao_hoaDon = new Dao_HoaDon();
	private boolean checkDateChooser = false, checkDateChooser_1 = false;
	private Dao_Phong dao_Phong = new Dao_Phong();
	private DefaultTableModel TempModelTkDoanhThu;
	JLabel lblTongTienDoanhThu;
	private JLabel lblKqDoanhThu;
	private JLabel lblKqHdCaoNhat;
	private JLabel lblKqHdThapNhat;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_ThongKeHoaDon(TaiKhoan taiKhoan)  {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao_tkhd = new Dao_ThongKeDoanhThu();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1480,780);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		mntmThongKeDoanhThu.setSelected(true);
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
		pnTop.setBackground(new Color(101, 186, 118));
		pnTop.setBounds(0, 10, 1466, 52);
		contentPane.add(pnTop);

		JLabel lblThongKeHoaDon = new JLabel("Thống kê doanh thu");
		lblThongKeHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblThongKeHoaDon);


		JPanel pnLeft = new JPanel();
		pnLeft.setBackground(new Color(101, 186, 118));
		pnLeft.setBounds(10, 66, 392, 673);
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Nhập vào để thống kê"));
		pnLeft.setLayout(null);

		JLabel lblTuNgay = new JLabel("Từ ngày :");
		lblTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTuNgay.setBounds(60, 65, 92, 34);
		dateChooser = new JDateChooser();

		dateChooser.getCalendarButton().setBounds(169, 0, 31, 30);
		dateChooser.setBounds(151, 69, 200, 30);
		pnLeft.add(dateChooser);
		dateChooser.setLayout(null);

		txtTuNgay = new JTextField();
		txtTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTuNgay.setBounds(0, 0, 170, 30);
		dateChooser.add(txtTuNgay);
		txtTuNgay.setColumns(10);
		pnLeft.add(lblTuNgay);


		JLabel lblDenNgay = new JLabel("Đến ngày:");
		lblDenNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDenNgay.setBounds(60, 142, 84, 30);
		dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBounds(170, 0, 30, 30);
		dateChooser_1.setBounds(151, 142, 200, 30);
		pnLeft.add(dateChooser_1);
		dateChooser_1.setLayout(null);

		txtDenNgay = new JTextField();
		txtDenNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDenNgay.setColumns(10);
		txtDenNgay.setBounds(0, 0, 172, 30);
		dateChooser_1.add(txtDenNgay);
		pnLeft.add(lblDenNgay);




		ImageIcon iconLamMoi = new ImageIcon("IMG//iconButton//Refresh.png");
		JButton btnLamMoiHoaDon = new JButton("Làm mới", iconLamMoi);
		btnLamMoiHoaDon.setBackground(new Color(255, 255, 140));
		btnLamMoiHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiHoaDon.setBounds(60, 371, 291, 33);
		pnLeft.add(btnLamMoiHoaDon);

		ImageIcon iconThongKe = new ImageIcon("IMG//iconButton//statistical.png");
		JButton btnThongKeHoaDon = new JButton("Thống kê", iconThongKe);
		btnThongKeHoaDon.setBackground(new Color(255, 255, 140));
		btnThongKeHoaDon.setForeground(new Color(0, 0, 0));
		btnThongKeHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThongKeHoaDon.setBounds(60, 301, 291, 33);
		pnLeft.add(btnThongKeHoaDon);

		JButton btnInThongKeHoaDon = new JButton("Biểu đồ thống kê", new ImageIcon("IMG//iconButton//print.png"));
		btnInThongKeHoaDon.setForeground(Color.BLACK);
		Border roundedBorder = new LineBorder(new Color(210,210,210), 1, true);
		btnInThongKeHoaDon.setBorder(new LineBorder(new Color(210, 210, 210), 1, true));
		btnInThongKeHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnInThongKeHoaDon.setBackground(new Color(255, 255, 140));
		btnInThongKeHoaDon.setBounds(60, 445, 291, 33);
		pnLeft.add(btnInThongKeHoaDon);



		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(new Color(101, 186, 118));
		pnCenter.setBounds(433, 66, 1033, 673);
		contentPane.add(pnCenter);
		String[] cols = { "Mã hóa đơn", "Nhân viên lập hóa đơn", "Ngày lập hóa đơn", "Tên khách hàng","Số điện thoại", "Tổng tiền hóa đơn"};
		modelTkHoaDon = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tblTkHoaDon = new JTable(modelTkHoaDon);
		JScrollPane scrtbl = new JScrollPane(tblTkHoaDon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		scrtbl.setBounds(10, 25, 1013, 454);
		pnCenter.add(scrtbl);

		TempModelTkDoanhThu = new DefaultTableModel(cols, 0);

		JLabel lblDoanhThu = new JLabel("Tổng doanh thu:");
		lblDoanhThu.setForeground(new Color(255, 0, 0));
		lblDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDoanhThu.setBounds(725, 520, 110, 26);
		pnCenter.add(lblDoanhThu);

		lblKqDoanhThu = new JLabel("0 VNĐ");
		lblKqDoanhThu.setForeground(new Color(255, 0, 0));
		lblKqDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqDoanhThu.setBounds(827, 523, 196, 21);
		pnCenter.add(lblKqDoanhThu);

		lblKqHdCaoNhat = new JLabel("");
		lblKqHdCaoNhat.setForeground(new Color(255, 0, 0));
		lblKqHdCaoNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqHdCaoNhat.setBounds(144, 523, 150, 21);
		pnCenter.add(lblKqHdCaoNhat);

		JLabel lblHoaDonCaoNhat = new JLabel("Hóa đơn cao nhất:");
		lblHoaDonCaoNhat.setForeground(new Color(255, 0, 0));
		lblHoaDonCaoNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblHoaDonCaoNhat.setBounds(13, 520, 121, 26);
		pnCenter.add(lblHoaDonCaoNhat);

		JLabel lblHoaDonThapNhat = new JLabel("Hóa đơn thấp nhất:");
		lblHoaDonThapNhat.setForeground(Color.RED);
		lblHoaDonThapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblHoaDonThapNhat.setBounds(10, 556, 121, 26);
		pnCenter.add(lblHoaDonThapNhat);

		lblKqHdThapNhat = new JLabel("0VNĐ");
		lblKqHdThapNhat.setForeground(Color.RED);
		lblKqHdThapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqHdThapNhat.setBounds(144, 559, 150, 21);
		pnCenter.add(lblKqHdThapNhat);
		

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
								ArrayList<HoaDonThuePhong> listHD = dao_tkhd.getHoaDonDalap(txtTuNgay.getText().toString(), txtDenNgay.getText().toString());
								DocDuLieuDatabaseVaoTable(listHD, TempModelTkDoanhThu);
								tblTkHoaDon.setModel(TempModelTkDoanhThu);
								TempModelTkDoanhThu = new DefaultTableModel(cols, 0);
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
								ArrayList<HoaDonThuePhong> listHD = dao_tkhd.getHoaDonDalap(txtTuNgay.getText().toString(), txtDenNgay.getText().toString());
								DocDuLieuDatabaseVaoTable(listHD, TempModelTkDoanhThu);
								tblTkHoaDon.setModel(TempModelTkDoanhThu);
								TempModelTkDoanhThu = new DefaultTableModel(cols, 0);
							}
							else if(txtTuNgay.getText().toString() != null && lblDenNgay.getText().toString() != null) {
								TableRowSorter<TableModel> rowSorter
								= new TableRowSorter<>(tblTkHoaDon.getModel()) ;
								tblTkHoaDon.setRowSorter(rowSorter);
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
		ArrayList<HoaDonThuePhong> listHD = dao_hoaDon.getAllHoaDonDaThanhToan();
		DocDuLieuDatabaseVaoTable(listHD, modelTkHoaDon);
	}
	public void DocDuLieuDatabaseVaoTable(ArrayList<HoaDonThuePhong> listHD, DefaultTableModel modelTkHoaDon) {
		double sum = 0;
		double minDT =0;
		double maxDT = 0;
		double tdv = 0;
		double tp;
		for (HoaDonThuePhong hd : listHD) {
			for (CTHoaDonThuePhong ct : dao_CTHD.getAllCTHDDichVuDaThanhToan(hd.getMaPhong().getMaPhong())) {
				if(ct!=null)
				tdv= tienDichVu(ct.getSoLuongDichVu(), ct.getMaDichVu().getGiaDichVu());
			}
				tp =tongTienPhong(hd.getGioVaoPhong(), hd.getGioRaPhong(), dao_Phong.getPhong(hd.getMaPhong().getMaPhong()).getGiaPhong());

			sum = tp + tdv;
			if(minDT ==0) minDT=sum;
			if(sum >= maxDT) {
				maxDT = sum;
			}
			
			if(sum<=minDT) {
				minDT = sum;
			}
			modelTkHoaDon.addRow(new Object[] {
					hd.getMaHoaDon(),hd.getMaNhanVien().getTenNhanVien(), hd.getNgayLap(), hd.getMaKhachHang().getTenKhachHang(),hd.getMaKhachHang().getSoDienThoai(), formatNumberForMoney(sum)
			});
		}
		lblKqDoanhThu.setText(formatNumberForMoney(sum) );
		lblKqHdCaoNhat.setText(formatNumberForMoney(maxDT) );
		lblKqHdThapNhat.setText(formatNumberForMoney(minDT));
	}
	public double tongTienPhong(Timestamp gioVaoPhong, Timestamp gioRaPhong, double giaPhong) {

		double tongTien = ((gioRaPhong.getTime() - gioVaoPhong.getTime())/1000/60)* (giaPhong/60);
		return  tongTien;
	}
	public double tienDichVu(int soLuongDichVu, double giaDichVu) {
		double tongTien =soLuongDichVu* giaDichVu*1.0;
		return tongTien;
	}

	private String formatNumberForMoney(double money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String str1 = currencyVN.format(Math.round(money));
		str1 = str1.substring(0,str1.length() - 2);
		return str1 + " VNĐ";
	}
}

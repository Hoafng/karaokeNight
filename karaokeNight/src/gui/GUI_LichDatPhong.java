package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_CTHoaDon;
import dao.Dao_DichVu;
import dao.Dao_HoaDon;
import dao.Dao_PhieuDatPhong;
import dao.Dao_Phong;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_LichDatPhong extends JFrame implements ActionListener, PropertyChangeListener{

	private JPanel contentPane;
	private DefaultTableModel modelTkDichVu;
	private JTable tbLichDatPhong;
	private JDateChooser dateChooser;
	private JTextField txtTuNgay;
	private Dao_DichVu dao_DichVu;
	private Dao_CTHoaDon dao_CTHD = new Dao_CTHoaDon();
	private Dao_HoaDon dao_HoaDon = new Dao_HoaDon();
	private Dao_PhieuDatPhong dao_PhieuDatPhong = new Dao_PhieuDatPhong();
	private TaiKhoan tk;
	private JLabel lblKqDichVuBan;
	private Dao_Phong dao_Phong = new Dao_Phong();
	private JComboBox<String> cbMaPhong;
	private JComboBox<Integer> cbGioGioNhanPhong;
	private JComboBox<Integer> cbPhutGioNhanPhong;
	private JComboBox<Integer> cbSoGioDat;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI_LichDatPhong(TaiKhoan taiKhoan) {
		// khởi tạo kết nối đến CSDL
				try {
					ConnectDB.getInstance().connect();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dao_DichVu = new Dao_DichVu();
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
		mntmThongKeDichVu.setSelected(true);
		mntmThongKeDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_LichDatPhong(tk).setVisible(true);
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
		
		JLabel lblThongKeDichVu = new JLabel("Lịch đặt phòng");
		lblThongKeDichVu.setBounds(731, 10, 224, 35);
		lblThongKeDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblThongKeDichVu);
		

		JPanel pnLeft = new JPanel();
		pnLeft.setBounds(10, 97, 392, 636);
		pnLeft.setBackground(new Color(101, 186, 118));
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Chức na"));
		pnLeft.setLayout(null);

	
		
		
		ImageIcon iconLamMoi = new ImageIcon("IMG//iconButton//Refresh.png");
		JButton btnThuePhong = new JButton("Thuê phòng", iconLamMoi);
		btnThuePhong.setBackground(new Color(255, 255, 140));
		btnThuePhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThuePhong.setBounds(60, 482, 291, 33);
		pnLeft.add(btnThuePhong);

		
		ImageIcon iconThongKe = new ImageIcon("IMG//iconButton//statistical.png");
		JButton btnTimKiem = new JButton("Hủy", iconThongKe);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnTimKiem.setBackground(new Color(255, 255, 140));
		btnTimKiem.setForeground(new Color(0, 0, 0));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTimKiem.setBounds(60, 568, 291, 33);
		pnLeft.add(btnTimKiem);
		
		JPanel panel_1_2_2_2_1 = new JPanel();
		panel_1_2_2_2_1.setLayout(null);
		panel_1_2_2_2_1.setBounds(60, 110, 280, 30);
		pnLeft.add(panel_1_2_2_2_1);
		
		JLabel lblGioNhanPhong = new JLabel("Giờ nhận phòng");
		lblGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(10, 0, 102, 30);
		panel_1_2_2_2_1.add(lblGioNhanPhong);
		
		cbGioGioNhanPhong = new JComboBox<Integer>();
		cbGioGioNhanPhong.setBounds(111, 1, 40, 30);
		for (int i = 0; i < 24; i++) {
			cbGioGioNhanPhong.addItem(i);
		}
		panel_1_2_2_2_1.add(cbGioGioNhanPhong);
		
		JLabel lblGioGioNhanPhong = new JLabel("Giờ");
		lblGioGioNhanPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioGioNhanPhong.setBounds(150, 0, 50, 30);
		panel_1_2_2_2_1.add(lblGioGioNhanPhong);
		
		cbPhutGioNhanPhong = new JComboBox<Integer>();
		cbPhutGioNhanPhong.setBounds(200, 1, 40, 30);
		for (int i = 0; i < 60; i++) {
			cbPhutGioNhanPhong.addItem(i);
		}
		panel_1_2_2_2_1.add(cbPhutGioNhanPhong);
		
		JLabel lblPhutGioNhanPhong = new JLabel("Phút");
		lblPhutGioNhanPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhutGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPhutGioNhanPhong.setBounds(230, 0, 50, 30);
		panel_1_2_2_2_1.add(lblPhutGioNhanPhong);
		
		JPanel panel_1_2_2_2_1_2 = new JPanel();
		panel_1_2_2_2_1_2.setLayout(null);
		panel_1_2_2_2_1_2.setBounds(60, 170, 280, 30);
		pnLeft.add(panel_1_2_2_2_1_2);
		
		JLabel lblSoGioDat = new JLabel("Số giờ đặt");
		lblSoGioDat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoGioDat.setBounds(10, 0, 90, 30);
		panel_1_2_2_2_1_2.add(lblSoGioDat);
		
		cbSoGioDat = new JComboBox<Integer>();
		cbSoGioDat.setBounds(170, 1, 50, 30);
		for (int i = 0; i < 24; i++) {
			cbSoGioDat.addItem(i);
		}
		panel_1_2_2_2_1_2.add(cbSoGioDat);
		
		JLabel lblNewLabel_1 = new JLabel("Giờ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(230, 0, 50, 30);
		panel_1_2_2_2_1_2.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 45, 280, 30);
		pnLeft.add(panel);
		panel.setLayout(null);
		
		JLabel lblTuNgay = new JLabel("Ngày");
		lblTuNgay.setBounds(10, 0, 50, 30);
		panel.add(lblTuNgay);
		lblTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtTuNgay = new JTextField();
		txtTuNgay.setBounds(101, 0, 150, 30);
		panel.add(txtTuNgay);
		txtTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTuNgay.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(250, 0, 30, 30);
		panel.add(dateChooser);
		dateChooser.getDateEditor().addPropertyChangeListener(
		    new PropertyChangeListener() {
		        @Override
		        public void propertyChange(PropertyChangeEvent e) {
		        	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");																																																																																																																																																												
		            if ("date".equals(e.getPropertyName())) {
		            	String a = sf.format(e.getNewValue());		   
		            	txtTuNgay.setText(a + "");
		            }
		        }
		    });
		dateChooser.getCalendarButton().setBounds(0, 0, 31, 30);
		dateChooser.setLayout(null);
		
		JButton btnLamMoiDichVu_1 = new JButton("Làm mới", null);
		btnLamMoiDichVu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoiTimKiem();
			}
		});
		btnLamMoiDichVu_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiDichVu_1.setBackground(new Color(255, 255, 140));
		btnLamMoiDichVu_1.setBounds(60, 525, 291, 33);
		pnLeft.add(btnLamMoiDichVu_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(60, 230, 280, 30);
		pnLeft.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(0, 0, 130, 30);
		panel_1.add(lblMaPhong);
		
		cbMaPhong = new JComboBox<String>();
		cbMaPhong.setBounds(130, 0, 150, 30);
		cbMaPhong.addItem("Tất cả");
		for (Phong p : dao_Phong.getAllPhong()) {
			if(p.getTinhTrang().equals("Đã đặt") ||p.getTinhTrang().equals("Đang chờ"))
			cbMaPhong.addItem(p.getMaPhong());
		}
		cbMaPhong.setSelectedIndex(0);
		panel_1.add(cbMaPhong);
		
		JButton btnTimKiem_1 = new JButton("Tìm kiếm", null);
		btnTimKiem_1.setForeground(Color.BLACK);
		btnTimKiem_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTimKiem_1.setBackground(new Color(255, 255, 140));
		btnTimKiem_1.setBounds(60, 439, 291, 33);
		pnLeft.add(btnTimKiem_1);

	
		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(430, 97, 1036, 636);
		pnCenter.setBackground(new Color(101, 186, 118));
		contentPane.add(pnCenter);
		String[] cols = { "Mã phòng","Ngày nhận phòng", "Giờ nhận phòng", "Giờ trả phòng", "Số giờ thuê", "Ngày đặt phòng","Khách hàng","Tình trạng"};
		modelTkDichVu = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tbLichDatPhong = new JTable(modelTkDichVu);
		JScrollPane scrtbl = new JScrollPane(tbLichDatPhong, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh sách đặt phòng"));
		scrtbl.setBounds(10, 10, 1016, 537);
		pnCenter.add(scrtbl);
		
		JLabel lblTongDichVuBan = new JLabel("Tổng số lượng dịch vụ đã bán: ");
		lblTongDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongDichVuBan.setBounds(749, 572, 196, 26);
		pnCenter.add(lblTongDichVuBan);
		
		lblKqDichVuBan = new JLabel("");
		lblKqDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqDichVuBan.setBounds(942, 572, 70, 26);
		pnCenter.add(lblKqDichVuBan);
		
		JLabel lblDichVuBanChayNhat = new JLabel("Dịch vụ bán chạy nhất:");
		lblDichVuBanChayNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDichVuBanChayNhat.setBounds(10, 608, 150, 21);
		pnCenter.add(lblDichVuBanChayNhat);
		
		JLabel lblKqDichVuBanChay = new JLabel("");
		lblKqDichVuBanChay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqDichVuBanChay.setBounds(159, 608, 113, 21);
		pnCenter.add(lblKqDichVuBanChay);
		
		JLabel lblTongTienDichVu = new JLabel("Tổng tiền dịch vụ đã bán: ");
		lblTongTienDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongTienDichVu.setBounds(10, 572, 164, 26);
		pnCenter.add(lblTongTienDichVu);
		
		JLabel lblKqTienDichVuBan = new JLabel("0 VNĐ");
		lblKqTienDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqTienDichVuBan.setBounds(176, 575, 143, 21);
		pnCenter.add(lblKqTienDichVuBan);
		
		DocDuLieuDatabaseVaoTable();
	}

	protected void lamMoiTimKiem() {
		txtTuNgay.setText("");
		cbGioGioNhanPhong.setSelectedIndex(0);
		cbPhutGioNhanPhong.setSelectedIndex(0);
		cbSoGioDat.setSelectedIndex(0);
		cbMaPhong.setSelectedIndex(0);
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
		
	}
	public void DocDuLieuDatabaseVaoTable() {
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");	
		SimpleDateFormat sf2 = new SimpleDateFormat("kk:mm:ss");	
		for (PhieuDatPhong pd : dao_PhieuDatPhong.getAllPhieuDatPhong()) {
			if(pd.isTonTai()) {
				Object[] rowData = { pd.getMaPhong().getMaPhong(),sf1.format(pd.getNgayNhanPhong()),sf2.format(pd.getNgayNhanPhong()),sf2.format(pd.getNgayNhanPhong().getTime()+pd.getSoGioDat()*60*60*1000),pd.getSoGioDat(),sf1.format(pd.getNgayDatPhong()),pd.getMaKhachHang().getTenKhachHang()};
				modelTkDichVu.addRow(rowData);
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

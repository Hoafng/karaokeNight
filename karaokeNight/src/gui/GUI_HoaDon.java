package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Dao_CTHoaDon;
import dao.Dao_DichVu;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_NhanVien;
import dao.Dao_Phong;
import entity.CTHoaDonThuePhong;
import entity.HoaDonThuePhong;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;
import java.awt.SystemColor;

public class GUI_HoaDon extends JFrame implements Printable {

	private JPanel contentPane;
	private JLabel txtMaHoaDon;
	private JLabel txtNgayLap;
	private JLabel txtGiaPhong;
	private JLabel txtMaPhong;
	private JLabel txtVAT;
	private JLabel txtGioVaoPhong;
	private JLabel txtPhutVaoPhong;
	private JLabel txtGioRaPhong;
	private JLabel txtPhutRaPhong;
	private JTable table;
	private JLabel txtThanhTien;
	private DefaultTableModel modelDichVu;
	private double thanhTien = 0;
	private Phong phong;
	private TaiKhoan taikhoan;
	private CTHoaDonThuePhong ctHD;
	private HoaDonThuePhong hd1;
	private Dao_CTHoaDon dao_cthd = new Dao_CTHoaDon();
	private Dao_HoaDon dao_hd = new Dao_HoaDon();
	private Dao_Phong dao_phong = new Dao_Phong();
	private JLabel txtGioHat;
	private JLabel txtTongDichVu;
	private JLabel txtTongTienGio;
	private boolean inHoaDon;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { GUI_ThanhToan frame = new
	 * GUI_ThanhToan(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */

	public GUI_HoaDon(Phong p, TaiKhoan tk) {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(SystemColor.text);

		JLabel lblThanhTon = new JLabel("KARAOKE NIGHT");
		lblThanhTon.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblThanhTon.setBounds(175, 10, 237, 46);
		contentPane.add(lblThanhTon);

		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn");
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaHoaDon.setBounds(10, 676, 120, 40);
		contentPane.add(lblMaHoaDon);

		txtMaHoaDon = new JLabel();
		txtMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaHoaDon.setBounds(115, 676, 158, 40);
		contentPane.add(txtMaHoaDon);

		JLabel lblNgayLap = new JLabel("Ngày lập :");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNgayLap.setBounds(73, 148, 120, 40);
		contentPane.add(lblNgayLap);

		txtNgayLap = new JLabel();
		txtNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNgayLap.setBounds(238, 148, 158, 40);
		contentPane.add(txtNgayLap);

		JLabel lblGiaPhong = new JLabel("Giá Phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(10, 635, 120, 40);
		contentPane.add(lblGiaPhong);

		txtGiaPhong = new JLabel();
		txtGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaPhong.setBounds(115, 635, 158, 40);
		contentPane.add(txtGiaPhong);

		JLabel lblMaPhong = new JLabel("Hóa Đơn Tính Tiền Phòng ");
		lblMaPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaPhong.setBounds(115, 103, 237, 40);
		contentPane.add(lblMaPhong);

		txtMaPhong = new JLabel();
		txtMaPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMaPhong.setBounds(347, 104, 175, 40);
		contentPane.add(txtMaPhong);

		String[] hour = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23" };
		String[] minute = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
				"32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48",
				"49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" };
		JLabel lblGioVaoPhong = new JLabel("Giờ vào phòng :");
		lblGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioVaoPhong.setBounds(73, 189, 120, 40);
		contentPane.add(lblGioVaoPhong);

//		comboBox_GioVaoPhong = new JComboBox(hour);
//		comboBox_GioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_GioVaoPhong.setBounds(152, 373, 54, 40);
//		contentPane.add(comboBox_GioVaoPhong);

		txtGioVaoPhong = new JLabel();
		txtGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGioVaoPhong.setBounds(238, 189, 30, 40);
		contentPane.add(txtGioVaoPhong);

		JLabel lblGio = new JLabel("giờ");
		lblGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio.setBounds(261, 189, 40, 40);
		contentPane.add(lblGio);

//		comboBox_PhutVaoPhong = new JComboBox(minute);
//		comboBox_PhutVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_PhutVaoPhong.setBounds(249, 373, 54, 40);
//		contentPane.add(comboBox_PhutVaoPhong);

		txtPhutVaoPhong = new JLabel();
		txtPhutVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhutVaoPhong.setBounds(292, 189, 40, 40);
		contentPane.add(txtPhutVaoPhong);

		JLabel lblPhut = new JLabel("phút");
		lblPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut.setBounds(323, 189, 40, 40);
		contentPane.add(lblPhut);

		JLabel lblGioRaPhong = new JLabel("Giờ ra phòng :");
		lblGioRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioRaPhong.setBounds(73, 230, 120, 40);
		contentPane.add(lblGioRaPhong);

//		comboBox_GioRaPhong = new JComboBox(hour);
//		comboBox_GioRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_GioRaPhong.setBounds(461, 373, 54, 40);
//		contentPane.add(comboBox_GioRaPhong);
//		

		txtGioRaPhong = new JLabel();
		txtGioRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGioRaPhong.setBounds(238, 230, 30, 40);
		contentPane.add(txtGioRaPhong);

		txtPhutRaPhong = new JLabel();
		txtPhutRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhutRaPhong.setBounds(292, 230, 31, 40);
		contentPane.add(txtPhutRaPhong);

		JLabel lblGio_1 = new JLabel("giờ");
		lblGio_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio_1.setBounds(261, 230, 40, 40);
		contentPane.add(lblGio_1);

//		comboBox_PhutRaPhong = new JComboBox(minute);
//		comboBox_PhutRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_PhutRaPhong.setBounds(558, 373, 54, 40);
//		contentPane.add(comboBox_PhutRaPhong);

		JLabel lblPhut_1 = new JLabel("phút");
		lblPhut_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut_1.setBounds(323, 230, 40, 40);
		contentPane.add(lblPhut_1);

		JLabel lblVAT = new JLabel("VAT");
		lblVAT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblVAT.setBounds(10, 561, 120, 30);
		contentPane.add(lblVAT);

		txtVAT = new JLabel();
		txtVAT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtVAT.setBounds(433, 561, 158, 30);
		contentPane.add(txtVAT);

		JPanel panel = new JPanel();
		panel.setBounds(10, 321, 544, 150);
		panel.setBorder(null);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblThanhTien = new JLabel("Tổng hóa đơn");
		lblThanhTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblThanhTien.setBounds(10, 592, 158, 46);
		contentPane.add(lblThanhTien);

		txtThanhTien = new JLabel();
		txtThanhTien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtThanhTien.setBounds(366, 592, 225, 46);
		contentPane.add(txtThanhTien);

		String[] colHeader = { "Tên dịch vụ", "Số Lượng", "Giá", "ThànhTiền" };
		modelDichVu = new DefaultTableModel(colHeader,0);
		table = new JTable(modelDichVu);
		table.setRowSelectionAllowed(false);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(2, 2, 540, 146);
		panel.add(table);
		JScrollPane cpDichVu = new JScrollPane(table);
		cpDichVu.setBounds(2, 2, 540, 146);
		panel.add(cpDichVu);
		table.setRowHeight(10);

		JLabel lblSGiHt = new JLabel("Số giờ hát");
		lblSGiHt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSGiHt.setBounds(73, 271, 120, 40);
		contentPane.add(lblSGiHt);

		txtGioHat = new JLabel();
		txtGioHat.setText((String) null);
		txtGioHat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGioHat.setBounds(238, 276, 152, 30);
		contentPane.add(txtGioHat);

		JLabel lblKhngT = new JLabel("28 Khổng Tử, Bình Thọ, Thủ Đức, Thành Phố Hồ Chí Minh");
		lblKhngT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblKhngT.setBounds(115, 47, 384, 46);
		contentPane.add(lblKhngT);

		JLabel lblt = new JLabel("ĐT: 0909686868 - 0909909999");
		lblt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblt.setBounds(178, 74, 384, 46);
		contentPane.add(lblt);

		JLabel lblTongDichVu = new JLabel("Tổng dịch vụ :");
		lblTongDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongDichVu.setBounds(10, 476, 120, 40);
		contentPane.add(lblTongDichVu);

		txtTongDichVu = new JLabel();
		txtTongDichVu.setText((String) null);
		txtTongDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTongDichVu.setBounds(433, 476, 158, 40);
		contentPane.add(txtTongDichVu);

		txtTongTienGio = new JLabel();
		txtTongTienGio.setText((String) null);
		txtTongTienGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTongTienGio.setBounds(433, 526, 158, 40);
		contentPane.add(txtTongTienGio);

		JLabel lblTongTienGio = new JLabel("Tổng tiền giờ :");
		lblTongTienGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongTienGio.setBounds(10, 518, 120, 40);
		contentPane.add(lblTongTienGio);

		JLabel lblXin = new JLabel("Xin Cảm Ơn Và Hẹn Gặp Lại Quý Khách!");
		lblXin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblXin.setBounds(89, 713, 384, 40);
		contentPane.add(lblXin);

		taikhoan = tk;
		phong = p;
		docDuLieuTuSQL();
	}

	public boolean isInHoaDon() {
		return inHoaDon;
	}

	public void setInHoaDon(boolean inHoaDon) {
		this.inHoaDon = inHoaDon;
	}

	@SuppressWarnings("deprecation")
	private void docDuLieuTuSQL() {
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		NhanVien nv = dao_nv.getNhanVien(taikhoan.getTenTaiKhoan());
		txtMaPhong.setText(phong.getMaPhong());
		txtGiaPhong.setText(String.valueOf(phong.getGiaPhong()));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		txtNgayLap.setText(sf.format(date));

		String maPhong = phong.getMaPhong();

		Dao_HoaDon dao_hd = new Dao_HoaDon();
		hd1 = dao_hd.getMaHoaDonPhong(phong.getMaPhong());
		txtMaHoaDon.setText(hd1.getMaHoaDon());

		Dao_KhachHang dao_kh = new Dao_KhachHang();
		KhachHang kh = dao_kh.getTheoMa(hd1.getMaKhachHang().getMaKhachHang());

		SimpleDateFormat sf1 = new SimpleDateFormat("kk");
		SimpleDateFormat sf2 = new SimpleDateFormat("mm");
		SimpleDateFormat sf3 = new SimpleDateFormat("MM-dd kk:mm");

		String hour_Vao = sf1.format(hd1.getGioVaoPhong());
		txtGioVaoPhong.setText(hour_Vao);
		String minute_Vao = sf2.format(hd1.getGioVaoPhong());
		txtPhutVaoPhong.setText(minute_Vao);

		txtGioRaPhong.setText(sf1.format(date));
		txtPhutRaPhong.setText(sf2.format(date));

		long gioHat = date.getTime() - hd1.getGioVaoPhong().getTime();
		long gio = gioHat / 1000 / 60 / 60;
		long phut = gioHat / 1000 / 60 % 60;
		DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("vn", "VN"));
		dcf.applyPattern("00");
		txtGioHat.setText(String.valueOf(gio + "h" + dcf.format(phut)));
		double tienDichVu = 0;
		double tongTienDichVu = 0;
		Dao_DichVu dao_dichvu = new Dao_DichVu();
		table.setRowHeight(25);
		for (CTHoaDonThuePhong d : dao_cthd.getAllCTHDDichVu(maPhong)) {
			tienDichVu = d.getMaDichVu().getGiaDichVu() * d.getSoLuongDichVu();
			Object[] rowData = { d.getMaDichVu().getTenDichVu(), d.getMaDichVu().getSoLuong(),
					d.getMaDichVu().getGiaDichVu(), tienDichVu };
			modelDichVu.addRow(rowData);
			tongTienDichVu = tongTienDichVu + tienDichVu;
			tienDichVu = 0;
		}
		txtTongDichVu.setText(String.valueOf(tongTienDichVu));

		double tienHat = 0;
		double tienPhutHat = phong.getGiaPhong() / 60;

		tienHat = tienPhutHat * (gio * 60 + phut);
		txtTongTienGio.setText(String.valueOf(tienHat));

		thanhTien = tienDichVu + tienHat;
		double VAT = 0;
		VAT = thanhTien * 0.1;
		txtVAT.setText(String.valueOf(VAT));
		thanhTien = thanhTien * (1 + 0.1);

		long now = date.getTime();
		if (kh.getLanDungCuoi() != null)
			if (now - kh.getLanDungCuoi().getTime() <= 30 * 24 * 60 * 60 * 1000)
				thanhTien = thanhTien * 9 / 10;
		txtThanhTien.setText(formatNumberForMoney(thanhTien));

	}

	private String formatNumberForMoney(double money) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String str1 = currencyVN.format(Math.round(money));
		str1 = str1.substring(0, str1.length() - 2);
		return str1 + " VNĐ";
	}

	private boolean printFrame() {
		PrinterJob printerJob = PrinterJob.getPrinterJob();

		printerJob.setPrintable(this);
		if (printerJob.printDialog()) {
			try {
				printerJob.print();
				return true;
			} catch (PrinterException e) {

			}
		}else return false;
		return true;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0) {
			return Printable.NO_SUCH_PAGE;
		}
		graphics.translate(50, 0);
		print(graphics);
		return Printable.PAGE_EXISTS;
	}
}

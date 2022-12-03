package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
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
import entity.DichVu;
import entity.HoaDonThuePhong;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_ThanhToan extends JFrame implements Printable {

	private JPanel contentPane;
	private JTextField txtMaHoaDon;
	private JTextField txtNgayLap;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtGiaPhong;
	private JTextField txtMaNhanVien;
	private JTextField txtMaPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtVAT;
	private JTextField txtGioVaoPhong;
	private JTextField txtPhutVaoPhong;
	private JTextField txtGioRaPhong;
	private JTextField txtPhutRaPhong;
	private JTextField txtGioHat;
	private JTextField txtPhutHat;
//	private JComboBox comboBox_GioVaoPhong;
//	private JComboBox comboBox_PhutVaoPhong;
//	private JComboBox comboBox_GioRaPhong;
//	private JComboBox comboBox_PhutRaPhong;
//	private JComboBox comboBox_GioHat;
//	private JComboBox comboBox_PhutHat;
	private JTable table;
	private JTextField txtThanhTien;
	private DefaultTableModel modelDichVu;
	private double thanhTien = 0;
	private Phong phong;
	private TaiKhoan taikhoan;
	private CTHoaDonThuePhong ctHD;
	private HoaDonThuePhong hd1;
	private Dao_CTHoaDon dao_cthd = new Dao_CTHoaDon();
	private Dao_HoaDon dao_hd = new Dao_HoaDon();
	private Dao_Phong dao_phong = new Dao_Phong();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThanhToan frame = new GUI_ThanhToan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public GUI_ThanhToan(Phong p,TaiKhoan tk) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 850);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(101, 186, 118));
		
		
		JLabel lblThanhTon = new JLabel("Thanh Toán");
		lblThanhTon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblThanhTon.setBounds(246, 10, 190, 46);
		contentPane.add(lblThanhTon);
		
		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn");
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaHoaDon.setBounds(47, 84, 120, 40);
		contentPane.add(lblMaHoaDon);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(152, 84, 158, 40);
		contentPane.add(txtMaHoaDon);
		
		JLabel lblNgayLap = new JLabel("Ngày lập");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNgayLap.setBounds(361, 84, 120, 40);
		contentPane.add(lblNgayLap);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setEditable(false);
		txtNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(457, 84, 158, 40);
		contentPane.add(txtNgayLap);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTenKhachHang.setBounds(47, 159, 120, 40);
		contentPane.add(lblTenKhachHang);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(152, 159, 158, 40);
		contentPane.add(txtTenKhachHang);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoDienThoai.setBounds(361, 159, 120, 40);
		contentPane.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(457, 159, 158, 40);
		contentPane.add(txtSoDienThoai);
		
		JLabel lblGiaPhong = new JLabel("Giá Phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(47, 304, 120, 40);
		contentPane.add(lblGiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(152, 304, 158, 40);
		contentPane.add(txtGiaPhong);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaNhanVien.setBounds(47, 229, 120, 40);
		contentPane.add(lblMaNhanVien);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(152, 229, 158, 40);
		contentPane.add(txtMaNhanVien);
		
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong.setBounds(361, 229, 120, 40);
		contentPane.add(lblMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(457, 229, 158, 40);
		contentPane.add(txtMaPhong);
		
		JLabel lblLoaiPhong = new JLabel("Loại Phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong.setBounds(361, 304, 120, 40);
		contentPane.add(lblLoaiPhong);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(457, 304, 158, 40);
		contentPane.add(txtLoaiPhong);
		
		
		String[] hour = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		String[] minute = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
				"21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40",
				"41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
		JLabel lblGioVaoPhong = new JLabel("Giờ vào phòng");
		lblGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioVaoPhong.setBounds(47, 373, 120, 40);
		contentPane.add(lblGioVaoPhong);
		
//		comboBox_GioVaoPhong = new JComboBox(hour);
//		comboBox_GioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_GioVaoPhong.setBounds(152, 373, 54, 40);
//		contentPane.add(comboBox_GioVaoPhong);
		
		txtGioVaoPhong = new JTextField();
		txtGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGioVaoPhong.setEditable(false);
		txtGioVaoPhong.setBounds(152, 373, 54, 40);
		contentPane.add(txtGioVaoPhong);
		
		
		JLabel lblGio = new JLabel("giờ");
		lblGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio.setBounds(210, 373, 40, 40);
		contentPane.add(lblGio);
		
//		comboBox_PhutVaoPhong = new JComboBox(minute);
//		comboBox_PhutVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_PhutVaoPhong.setBounds(249, 373, 54, 40);
//		contentPane.add(comboBox_PhutVaoPhong);
		
		txtPhutVaoPhong = new JTextField();
		txtPhutVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhutVaoPhong.setEditable(false);
		txtPhutVaoPhong.setBounds(249, 373, 54, 40);
		contentPane.add(txtPhutVaoPhong);
		
		JLabel lblPhut = new JLabel("phút");
		lblPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut.setBounds(307, 373, 40, 40);
		contentPane.add(lblPhut);
		
		JLabel lblGioRaPhong = new JLabel("Giờ ra phòng");
		lblGioRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioRaPhong.setBounds(356, 373, 120, 40);
		contentPane.add(lblGioRaPhong);
		
//		comboBox_GioRaPhong = new JComboBox(hour);
//		comboBox_GioRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_GioRaPhong.setBounds(461, 373, 54, 40);
//		contentPane.add(comboBox_GioRaPhong);
//		
		
		txtGioRaPhong = new JTextField();
		txtGioRaPhong.setEditable(false);
		txtGioRaPhong.setBounds(461, 373, 54, 40);
		contentPane.add(txtGioRaPhong);

		
		
		txtPhutRaPhong = new JTextField();
		txtPhutRaPhong.setEditable(false);
		txtPhutRaPhong.setBounds(558, 373, 54, 40);
		contentPane.add(txtPhutRaPhong);
		

		
		
		
		
		
		JLabel lblGio_1 = new JLabel("giờ");
		lblGio_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio_1.setBounds(519, 373, 40, 40);
		contentPane.add(lblGio_1);
		
//		comboBox_PhutRaPhong = new JComboBox(minute);
//		comboBox_PhutRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_PhutRaPhong.setBounds(558, 373, 54, 40);
//		contentPane.add(comboBox_PhutRaPhong);
		
		JLabel lblPhut_1 = new JLabel("phút");
		lblPhut_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut_1.setBounds(616, 373, 40, 40);
		contentPane.add(lblPhut_1);
		
		JLabel lblSoGioHat = new JLabel("Số giờ hát");
		lblSoGioHat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoGioHat.setBounds(47, 436, 120, 40);
		contentPane.add(lblSoGioHat);
		
//		comboBox_GioHat = new JComboBox(hour);
//		comboBox_GioHat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		comboBox_GioHat.setBounds(152, 436, 54, 40);
//		contentPane.add(comboBox_GioHat);
		
		txtGioHat = new JTextField();
		txtGioHat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGioHat.setEditable(false);
		txtGioHat.setBounds(152, 436, 54, 40);
		contentPane.add(txtGioHat);
		
		JLabel lblGio_2 = new JLabel("giờ");
		lblGio_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio_2.setBounds(210, 436, 40, 40);
		contentPane.add(lblGio_2);
		
		txtPhutHat = new JTextField();
		txtPhutHat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhutHat.setBounds(249, 436, 54, 40);
		contentPane.add(txtPhutHat);
		
		JLabel lblPhut_2 = new JLabel("phút");
		lblPhut_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhutHat.setEditable(false);
		lblPhut_2.setBounds(307, 436, 40, 40);
		contentPane.add(lblPhut_2);
		
		JLabel lblVAT = new JLabel("VAT");
		lblVAT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblVAT.setBounds(361, 436, 120, 40);
		contentPane.add(lblVAT);
		
		txtVAT = new JTextField();
		txtVAT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtVAT.setEditable(false);
		txtVAT.setColumns(10);
		txtVAT.setBounds(457, 436, 158, 40);
		contentPane.add(txtVAT);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 510, 581, 145);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThanhTien.setBounds(246, 680, 120, 40);
		contentPane.add(lblThanhTien);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setEditable(false);
		txtThanhTien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(317, 680, 158, 40);
		contentPane.add(txtThanhTien);
		
		JCheckBox chckbx_InHoaDon = new JCheckBox("In hóa đơn");
		chckbx_InHoaDon.setSelected(true);
		chckbx_InHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chckbx_InHoaDon.setBounds(314, 730, 93, 21);
		contentPane.add(chckbx_InHoaDon);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_InHoaDon.isSelected())
					printFrame();
					UpdateData();
					dispose();
					new GUI_XuLy(tk).setVisible(true);
			}
		});
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(199, 762, 123, 40);
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(391, 762, 123, 40);
		contentPane.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			
			}
		});
		
		String[] colHeader = { "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng" };
		modelDichVu = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelDichVu);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(10, 10, 561, 169);
		panel.add(table);
		JScrollPane cpDichVu = new JScrollPane(table);
		cpDichVu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cpDichVu.setBounds(10, 10, 561, 133);
		panel.add(cpDichVu);
		table.setRowHeight(10);

		taikhoan =tk;
		phong =p;
		docDuLieuTuSQL();
	}
	private void docDuLieuTuSQL() {
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		NhanVien nv = dao_nv.getNhanVien(taikhoan.getTenTaiKhoan());	
		txtMaNhanVien.setText(nv.getMaNhanVien());
		txtMaPhong.setText(phong.getMaPhong());
		txtLoaiPhong.setText(phong.getMaLoaiPhong().getTenLoaiPhong());	
		txtGiaPhong.setText(String.valueOf(phong.getGiaPhong()));
		txtVAT.setText("10%");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		txtNgayLap.setText(sf.format(date));
		
		
		String maPhong = phong.getMaPhong();
		String maHoaDon = null;
		
		
		Dao_HoaDon dao_hd = new Dao_HoaDon();
		HoaDonThuePhong hd = dao_hd.getMaHoaDon(maPhong);
		txtMaHoaDon.setText(hd.getMaHoaDon());
		maHoaDon = hd.getMaHoaDon();
		hd1 = dao_hd.getHoaDon(maHoaDon);
		
		Dao_DichVu dao_dichvu = new Dao_DichVu();
		table.setRowHeight(25);
		for (CTHoaDonThuePhong d : dao_cthd.getAllCTHDDichVu(maPhong)) {
			Object[] rowData = { d.getMaDichVu().getMaDichVu(), d.getMaDichVu().getTenDichVu(), d.getMaDichVu().getGiaDichVu(), d.getMaDichVu().getSoLuong()};
			modelDichVu.addRow(rowData);
			thanhTien = d.getMaDichVu().getGiaDichVu() *d.getMaDichVu().getSoLuong()  + thanhTien ;
		}
		
		Dao_KhachHang dao_kh = new Dao_KhachHang();
		KhachHang kh = dao_kh.getKhachHangTuHoaDon(maHoaDon);
		txtTenKhachHang.setText(kh.getTenKhachHang());
		txtSoDienThoai.setText(kh.getSoDienThoai());
		
		
		
		SimpleDateFormat sf1 = new SimpleDateFormat("hh");
		SimpleDateFormat sf2 = new SimpleDateFormat("mm");
		
		String hour_Vao =sf1.format(hd1.getGioVaoPhong());
		txtGioVaoPhong.setText(hour_Vao);
		String minute_Vao =sf2.format(hd1.getGioVaoPhong());
		txtPhutVaoPhong.setText(minute_Vao);
		
		
		
		txtGioRaPhong.setText(sf1.format(date));
		txtPhutRaPhong.setText(sf2.format(date));
		
		
		long gioHat = date.getTime() - hd1.getGioVaoPhong().getTime();
		Time timeStamp = new Time(gioHat);
		txtGioHat.setText(sf1.format(timeStamp));
		txtPhutHat.setText(sf2.format(timeStamp));
	
		
		thanhTien = (thanhTien + phong.getGiaPhong());
		thanhTien = thanhTien + thanhTien*1/10;
		
		Date lanDungCuoi = kh.getLanDungCuoi();
		long now = date.getTime();
		long check = now - lanDungCuoi.getTime();
		if(check<=30*24*60*60*1000)
			thanhTien = thanhTien*9/10;
		txtThanhTien.setText(thanhTien+" vnđ");
	}
	
	private void UpdateData() {
		String maPhong = txtMaPhong.getText();
		String maHoaDon = txtMaHoaDon.getText();
		Date date = new Date(System.currentTimeMillis());
		long gioRaPhong = date.getTime();
		Date ngayLap = Date.valueOf(txtNgayLap.getText());
		Timestamp timeRaPhong = new Timestamp(gioRaPhong);
		Dao_KhachHang dao_kh = new Dao_KhachHang();
		KhachHang kh = dao_kh.getKhachHangTuHoaDon(maHoaDon);
		String maKH = kh.getMaKhachHang();
		dao_kh.updateLanDungCuoi(ngayLap,maKH);
		if (dao_hd.updateThanhToan(timeRaPhong,ngayLap,maHoaDon) == true) {
			dao_phong.updateTinhTrang(maPhong, "Trống");
			JOptionPane.showMessageDialog(this, "Thanh toán thành công");
		} else
			JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
	}
		
	private void printFrame(){
	    PrinterJob printerJob = PrinterJob.getPrinterJob();

	    printerJob.setPrintable(this);
	    if (printerJob.printDialog()) {
	        try {
	            printerJob.print();
	        } catch ( PrinterException e ) {
            }
        }
    }
	
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if ( pageIndex > 0 ){
			return Printable.NO_SUCH_PAGE;
        }
		graphics.translate(50, 0);
		print(graphics);
		return Printable.PAGE_EXISTS;
	}
}
	

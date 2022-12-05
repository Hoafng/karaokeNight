package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_NhanVien;
import entity.NhanVien;
import entity.TaiKhoan;

@SuppressWarnings("serial")
public class GUI_NhanVien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtTenNhanVienTim;
	private JTextField txtSoDienThoaiTim;
	private JTextField txtCMNDTim;
	private JTextField txtTen;
	private JTextField txtCMND;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;
	private JDateChooser dateChooser;
	private JTextField txtTimNgaySinh;
	private JTextField txtNgaySinh;
	private JDateChooser dateChooser_1;
	private DefaultTableModel modelNhanVien;
	private JScrollPane cpNhanVien;
	private Dao_NhanVien daoNhanVien;
	private JTextField txtma;
	private JCheckBox chkcbxGioiTinh;
	private JTextField txtEmail;
	private JComboBox<String> cbxMaNhanVienTim;
	private JComboBox<String> cbxChuVu;
	private JComboBox<String> cbxChuVuTim;
	private JCheckBox chkcbxNamTim;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnTimNhanVien;
	private JButton btnLamMoi;
	private JCheckBox chckbxNuTim;
	private TaiKhoan taiKhoan;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_NhanVien(TaiKhoan taikhoan) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taiKhoan = taikhoan;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
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
				new GUI_TrangChu(taikhoan).setVisible(true);
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
				new GUI_DichVu(taikhoan).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucDichVu);

		JMenuItem mntmDanhMucKhachHang = new JMenuItem("Khách hàng");
		mntmDanhMucKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_KhachHang(taikhoan).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucKhachHang);

		JMenuItem mntmDanhMucPhong = new JMenuItem("Phòng");
		mntmDanhMucPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_Phong(taikhoan).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucPhong);

		JMenuItem mntmDanhMucNhanVien = new JMenuItem("Nhân viên");
		mntmDanhMucNhanVien.setSelected(true);
		mntmDanhMucNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_NhanVien(taikhoan).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucNhanVien);

		JMenuItem mnXuLi = new JMenuItem("Xử lí");
		mnXuLi.setHorizontalAlignment(SwingConstants.CENTER);
		mnXuLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(taikhoan).setVisible(true);
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
				new GUI_TimKiemDichVu(taikhoan).setVisible(true);
			}
		});
		mnTimKiem.add(mntmTimKiemDichVu);

		JMenuItem mntmTimKiemHoaDon = new JMenuItem("Hóa đơn");
		mntmTimKiemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TimKiemHoaDon(taikhoan).setVisible(true);
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
				new GUI_ThongKeHoaDon(taikhoan).setVisible(true);
			}
		});
		mnThongKe.add(mntmThongKeDoanhThu);

		JMenuItem mntmThongKeDichVu = new JMenuItem("Dịch vụ");
		mntmThongKeDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongKeDichVu(taikhoan).setVisible(true);
			}
		});
		mnThongKe.add(mntmThongKeDichVu);

		JMenuItem mnTroGiup = new JMenuItem("Trợ giúp ");
		mnTroGiup.setHorizontalAlignment(SwingConstants.CENTER);
		mnTroGiup.setFont(UIManager.getFont("MenuBar.font"));
		mnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TroGiup(taikhoan).setVisible(true);
			}
		});
		menuBar.add(mnTroGiup);

		JLabel lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNhanVien.setBounds(641, 44, 186, 42);
		contentPane.add(lblNhanVien);
		
		JPanel pnlDanhSachNhanVien = new JPanel();
		pnlDanhSachNhanVien.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		pnlDanhSachNhanVien.setBounds(298, 299, 1158, 434);
		contentPane.add(pnlDanhSachNhanVien);
		pnlDanhSachNhanVien.setLayout(null);
		
		String[] colHeader = { "Mã Nhân Viên", "Tên Nhân Vien", "số Điện Thoại", "Ngày sinh ", "Đia chỉ","Giới Tính","CMND","Chức Vụ ","Email","Tên Tài Khoản"};
		modelNhanVien = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelNhanVien);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		table.setBounds(0, 295, 1480, 462);
		cpNhanVien = new JScrollPane(table);
		cpNhanVien.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cpNhanVien.setBounds(10, 10, 1137, 412);
		pnlDanhSachNhanVien.add(cpNhanVien);
		table.setRowHeight(25);
		docDuLieuTuSQL();
		
		JPanel pnlThongTinNhanVien = new JPanel();
		pnlThongTinNhanVien.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		pnlThongTinNhanVien.setBounds(10, 89, 1446, 200);
		contentPane.add(pnlThongTinNhanVien);
		pnlThongTinNhanVien.setLayout(null);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên");
		lblMaNhanVien.setBounds(214, 23, 118, 25);
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên Nhân Viên");
		lblTenNhanVien.setBounds(435, 23, 130, 25);
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(lblTenNhanVien);
		
		txtTen = new JTextField();
		txtTen.setBounds(565, 22, 292, 25);
		txtTen.setHorizontalAlignment(SwingConstants.CENTER);
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTen.setColumns(10);
		pnlThongTinNhanVien.add(txtTen);
		
		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setBounds(241, 66, 66, 25);
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(lblCMND);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(311, 65, 141, 25);
		txtCMND.setHorizontalAlignment(SwingConstants.CENTER);
		txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCMND.setColumns(10);
		pnlThongTinNhanVien.add(txtCMND);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setBounds(890, 23, 130, 25);
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(1025, 22, 141, 25);
		txtSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		pnlThongTinNhanVien.add(txtSoDienThoai);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setBounds(462, 66, 87, 25);
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(lblGioiTinh);
		
		chkcbxGioiTinh = new JCheckBox("Nam/Nữ");
		chkcbxGioiTinh.setBounds(547, 63, 110, 30);
		chkcbxGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);
		chkcbxGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(chkcbxGioiTinh);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setBounds(680, 66, 87, 25);
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(lblNgaySinh);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(778, 66, 156, 25);
		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser_1.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dateChooser_1.getDateEditor().addPropertyChangeListener(
		    (PropertyChangeListener) new PropertyChangeListener() {
		        @Override
		        public void propertyChange(PropertyChangeEvent e) {
		        	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");																																																																																																																																																												
		            if ("date".equals(e.getPropertyName())) {
		            	String a = sf.format(e.getNewValue());		   
		            	txtNgaySinh.setText(a + "");
		            }
		        }
		    });
		dateChooser_1.getCalendarButton().setBounds(128, 0, 28, 26);
		pnlThongTinNhanVien.add(dateChooser_1);
		dateChooser_1.setLayout(null);
		
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(0, 0, 129, 26);
		dateChooser_1.add(txtNgaySinh);
		
		JLabel lblChucVu = new JLabel("Chức Vụ");
		lblChucVu.setBounds(975, 66, 74, 25);
		lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(lblChucVu);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setBounds(214, 111, 74, 25);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinNhanVien.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(305, 110, 457, 25);
		txtDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		pnlThongTinNhanVien.add(txtDiaChi);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(409, 154, 118, 30);
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
/**/	btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nvthem=new NhanVien(txtma.getText(),txtTen.getText(),txtSoDienThoai.getText(),Date.valueOf(txtNgaySinh.getText()),
						txtDiaChi.getText(),chkcbxGioiTinh.isSelected(),txtCMND.getText(),cbxChuVu.getSelectedItem().toString(),
						txtEmail.getText(),new TaiKhoan(taiKhoan.getTenTaiKhoan()),true);
				daoNhanVien.insertNhanVien(nvthem);
				if(daoNhanVien.insertNhanVien(nvthem)==true) {
				JOptionPane.showInputDialog(this,"Them Thanh Cong");
				}
			}
		});
		pnlThongTinNhanVien.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setBounds(565, 154, 118, 30);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
/**/	btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoNhanVien.getNhanVienTheoMa(txtma.getText())!=null) {
					NhanVien nv1=daoNhanVien.getNhanVienTheoMa(txtma.getText());
					daoNhanVien.deleteNhanVien(nv1.getMaNhanVien());
					JOptionPane.showInputDialog("Xoa thanh cong");
				}
			}
		});
		pnlThongTinNhanVien.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(718, 154, 118, 30);
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
/**/	btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoNhanVien.getNhanVienTheoMa(txtma.getText())!=null) {
					NhanVien nv1=daoNhanVien.getNhanVienTheoMa(txtma.getText());
					daoNhanVien.updateNhanVien(nv1);
					JOptionPane.showInputDialog("Xoa thanh cong");
				}
			}
		});
		pnlThongTinNhanVien.add(btnSua);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(867, 154, 118, 30);
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
/**/	btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoNhanVien.getNhanVienTheoMa(txtma.getText())!=null) {
					NhanVien nv1=daoNhanVien.getNhanVienTheoMa(txtma.getText());
					daoNhanVien.updateNhanVien(nv1);
					JOptionPane.showInputDialog("Xoa thanh cong");
				}
			}
		});
		pnlThongTinNhanVien.add(btnLuu);
		
		txtma = new JTextField();
		txtma.setBounds(342, 23, 86, 25);
		txtma.setHorizontalAlignment(SwingConstants.CENTER);
		txtma.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtma.setColumns(10);
		pnlThongTinNhanVien.add(txtma);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(783, 111, 74, 25);
		pnlThongTinNhanVien.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(867, 110, 299, 25);
		pnlThongTinNhanVien.add(txtEmail);
		
	
		cbxChuVu = new JComboBox<String>();
		cbxChuVu.setModel(new DefaultComboBoxModel<String>(new String[] {"Quản Lý", "Nhân Viên"}));
		cbxChuVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbxChuVu.setBounds(1059, 66, 107, 25);
		pnlThongTinNhanVien.add(cbxChuVu);
		
		JPanel pnlTimKiemNhanVien = new JPanel();
		pnlTimKiemNhanVien.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		pnlTimKiemNhanVien.setBounds(10, 299, 278, 434);
		contentPane.add(pnlTimKiemNhanVien);
		pnlTimKiemNhanVien.setLayout(null);
		
		txtTenNhanVienTim = new JTextField();
		txtTenNhanVienTim.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenNhanVienTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenNhanVienTim.setBounds(10, 129, 258, 25);
		pnlTimKiemNhanVien.add(txtTenNhanVienTim);
		txtTenNhanVienTim.setColumns(10);
		
		JLabel lblMaNhanVienTim = new JLabel("Mã Nhân Viên");
		lblMaNhanVienTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaNhanVienTim.setBounds(10, 53, 118, 25);
		pnlTimKiemNhanVien.add(lblMaNhanVienTim);
		
		JLabel lblTenNhanVienTim = new JLabel("Tên Nhân Viên");
		lblTenNhanVienTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenNhanVienTim.setBounds(10, 94, 130, 25);
		pnlTimKiemNhanVien.add(lblTenNhanVienTim);
		
		JLabel lblSoDienThoaiTim = new JLabel("Số Điện Thoại");
		lblSoDienThoaiTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoaiTim.setBounds(10, 175, 130, 25);
		pnlTimKiemNhanVien.add(lblSoDienThoaiTim);
		
		txtSoDienThoaiTim = new JTextField();
		txtSoDienThoaiTim.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoDienThoaiTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoDienThoaiTim.setColumns(10);
		txtSoDienThoaiTim.setBounds(138, 174, 130, 25);
		pnlTimKiemNhanVien.add(txtSoDienThoaiTim);
		
		JLabel lblCMNDTim = new JLabel("CMND");
		lblCMNDTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCMNDTim.setBounds(10, 303, 66, 25);
		pnlTimKiemNhanVien.add(lblCMNDTim);
		
		txtCMNDTim = new JTextField();
		txtCMNDTim.setHorizontalAlignment(SwingConstants.CENTER);
		txtCMNDTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtCMNDTim.setColumns(10);
		txtCMNDTim.setBounds(86, 302, 182, 25);
		pnlTimKiemNhanVien.add(txtCMNDTim);
		
		JLabel lblTimKiem = new JLabel("Tìm Kiếm Nhân Viên");
		lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimKiem.setBounds(10, 10, 258, 45);
		pnlTimKiemNhanVien.add(lblTimKiem);
		
		JLabel lblNgaySinhTim = new JLabel("Ngày Sinh");
		lblNgaySinhTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgaySinhTim.setBounds(10, 350, 87, 25);
		pnlTimKiemNhanVien.add(lblNgaySinhTim);
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dateChooser.getDateEditor().addPropertyChangeListener(
		    (PropertyChangeListener) new PropertyChangeListener() {
		        @Override
		        public void propertyChange(PropertyChangeEvent e) {
		        	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");																																																																																																																																																												
		            if ("date".equals(e.getPropertyName())) {
		            	String a = sf.format(e.getNewValue());		   
		            	txtTimNgaySinh.setText(a + "");
		            }
		        }
		    });
		dateChooser.getCalendarButton().setBounds(131, 0, 36, 30);
		dateChooser.setBounds(101, 345, 167, 30);
		pnlTimKiemNhanVien.add(dateChooser);
		dateChooser.setLayout(null);
		
		txtTimNgaySinh = new JTextField();
		txtTimNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTimNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimNgaySinh.setBounds(0, 0, 134, 31);
		dateChooser.add(txtTimNgaySinh);
		txtTimNgaySinh.setColumns(10);
		
		btnTimNhanVien = new JButton("Tìm Kiếm");
		btnTimNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTimNhanVien.setBounds(10, 394, 118, 30);
/**/	btnTimNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemNhieuThuocTinh();
			}

		});
		pnlTimKiemNhanVien.add(btnTimNhanVien);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLamMoi.setBounds(150, 394, 118, 30);
/**/	btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxMaNhanVienTim.setSelectedItem("");
				txtTenNhanVienTim.setText("");
				txtSoDienThoaiTim.setText("");
				cbxChuVu.setSelectedItem("Quản Lý");
				txtCMNDTim.setText("");
				txtTimNgaySinh.setText("");
			}
		});
		pnlTimKiemNhanVien.add(btnLamMoi);
		
		JLabel lblChucVuTim = new JLabel("Chức Vụ");
		lblChucVuTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblChucVuTim.setBounds(10, 219, 118, 25);
		pnlTimKiemNhanVien.add(lblChucVuTim);
		
		cbxChuVuTim = new JComboBox<String>();
		cbxChuVuTim.setModel(new DefaultComboBoxModel<String>(new String[] {"Quản Lý", "Nhân Viên"}));
		cbxChuVuTim.setSelectedIndex(0);
		cbxChuVuTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbxChuVuTim.setBounds(138, 219, 130, 25);
		pnlTimKiemNhanVien.add(cbxChuVuTim);
		
		cbxMaNhanVienTim = new JComboBox<String>();
		cbxMaNhanVienTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbxMaNhanVienTim.setBounds(138, 52, 130, 25);
		cbxMaNhanVienTim.setEditable(true);		
		List<NhanVien> dsNV = daoNhanVien.getAllNhanVien();
		for (NhanVien nv : dsNV) {
			cbxMaNhanVienTim.addItem(nv.getMaNhanVien());
		}
		pnlTimKiemNhanVien.add(cbxMaNhanVienTim);
		
		JLabel lblGioiTinhTim = new JLabel("Giới Tính");
		lblGioiTinhTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGioiTinhTim.setBounds(10, 260, 118, 25);
		pnlTimKiemNhanVien.add(lblGioiTinhTim);
		
		chkcbxNamTim = new JCheckBox("Nam");
		chkcbxNamTim.setHorizontalAlignment(SwingConstants.CENTER);
		chkcbxNamTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		chkcbxNamTim.setBounds(118, 255, 74, 30);
		pnlTimKiemNhanVien.add(chkcbxNamTim);
		
		chckbxNuTim = new JCheckBox("Nữ");
		chckbxNuTim.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNuTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		chckbxNuTim.setBounds(194, 255, 74, 30);
		pnlTimKiemNhanVien.add(chckbxNuTim);
		
		
	}

	private void docDuLieuTuSQL() {
		// TODO Auto-generated method stub
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		daoNhanVien = new Dao_NhanVien();
		for (NhanVien nv : daoNhanVien.getAllNhanVien()) {
			Object[] rowData = { nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getSoDienThoai(),sf.format(nv.getNgaySinh()),nv.getDiaChi(),nv.isGioiTinh()==true?"Nam":"Nữ", nv.getCmnd(), nv.getChucVu(),nv.getEmail(),nv.getTenTaiKhoan().getTenTaiKhoan() };
			modelNhanVien.addRow(rowData);
		}
	}
	private void timKiemNhieuThuocTinh() {
		// TODO Auto-generated method stub
		String ma = cbxMaNhanVienTim.getSelectedItem().toString();
		String ten = txtTenNhanVienTim.getText();
		String sdt= txtSoDienThoaiTim.getText();
		String chuVu="";
		String cmnd=txtCMNDTim.getText();
		String gioiTinh="";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String ngaySinh=sf.format(dateChooser).toString();
		if (cbxMaNhanVienTim.getSelectedItem().toString().trim().equals("")) {
			ma="";
		}
		if (txtTenNhanVienTim.getText().trim().equalsIgnoreCase("")) {
			ten="";
		}
		if (txtSoDienThoaiTim.getText().trim().equals("")) {
			sdt="";
		}
		if (cbxChuVuTim.getSelectedIndex()==0) {
			chuVu="Quản lý";
		}
		if (cbxChuVuTim.getSelectedIndex()==1) {
			chuVu="Nhân viên";
		}
		if (txtCMNDTim.getText().trim().equalsIgnoreCase("")) {
			cmnd="";
		}
		if (sf.format(dateChooser).toString().trim().equalsIgnoreCase("")) {
			ngaySinh="";
		}
		if(chkcbxNamTim.isSelected()==true&&chckbxNuTim.isSelected()==true) {
			gioiTinh="";
		}
		if(chkcbxNamTim.isSelected()==true&&chckbxNuTim.isSelected()==false) {
			gioiTinh="1";
		}
		if(chkcbxNamTim.isSelected()==false&&chckbxNuTim.isSelected()==true) {
			gioiTinh="0";
		}
		for (NhanVien nv : daoNhanVien.getTheoNhieuThuocTinh(ma, ten, sdt,ngaySinh,gioiTinh,cmnd,chuVu)) {
			Object[] rowData = { nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getSoDienThoai(),sf.format(nv.getNgaySinh()),nv.getDiaChi(),nv.isGioiTinh()==true?"Nam":"Nữ", nv.getCmnd(), nv.getChucVu(),nv.getEmail(),nv.getTenTaiKhoan().getTenTaiKhoan() };
			modelNhanVien.addRow(rowData);
		}
		
	}
}

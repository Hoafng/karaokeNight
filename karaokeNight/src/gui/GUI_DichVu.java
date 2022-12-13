package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import connectDB.ConnectDB;
import dao.Dao_DichVu;
import dao.Dao_LoaiDichVu;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.TaiKhoan;

public class GUI_DichVu extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaDichVu;
	private JTextField txtTenDichVu;
	private JTextField txtGiaDichVu;
	private JTextField txtSoLuong;
	private Dao_DichVu daoDichVu;
	private Dao_LoaiDichVu daoLoaiDichVu = new Dao_LoaiDichVu();
	private DefaultTableModel modelDichVu;
	private JScrollPane cpDichVu;
	private JComboBox<String> cbxMaLoaiDichVu;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnXuatEXCEL;
	private TaiKhoan tk;
	private JButton btnNhapEXCEL;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_DichVu(TaiKhoan taiKhoan) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		setLocationRelativeTo(null);
		
		tk=taiKhoan;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 140));
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
		mntmDanhMucDichVu.setSelected(true);
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

		JLabel lblDichVu = new JLabel("Dịch Vụ");
		lblDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDichVu.setBounds(641, 24, 186, 42);
		contentPane.add(lblDichVu);
		JPanel pnlDanhSachDichVu = new JPanel();
		pnlDanhSachDichVu.setBounds(60, 279, 1347, 418);
		contentPane.add(pnlDanhSachDichVu);
		
		String[] colHeader = { "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Dịch Vụ", "Số Lượng ","Loại Dịch Vụ"};
		modelDichVu = new DefaultTableModel(colHeader, 0);
		pnlDanhSachDichVu.setLayout(null);
		table = new JTable(modelDichVu);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(0, 295, 1480, 462);
		cpDichVu = new JScrollPane(table);
		cpDichVu.setBounds(10, 10, 1290, 398);
		cpDichVu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnlDanhSachDichVu.add(cpDichVu);
		table.setRowHeight(20);
		docDuLieuTuSQL();
		
		JPanel pnlThongTinDichVu = new JPanel();
		pnlThongTinDichVu.setBackground(new Color(101, 186, 118));
		pnlThongTinDichVu.setBounds(260, 76, 965, 185);
		contentPane.add(pnlThongTinDichVu);
		pnlThongTinDichVu.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoDichVu.getDichVuTheoMa(txtMaDichVu.getText())!=null) {
				DichVu dv=new DichVu(txtMaDichVu.getText(), txtTenDichVu.getText(), Double.parseDouble(txtGiaDichVu.getText()),Integer.parseInt(txtSoLuong.getText()),new LoaiDichVu(cbxMaLoaiDichVu.getSelectedItem().toString()));
				daoDichVu.insertDichVu(dv);
				JOptionPane.showInputDialog(this,"Thêm Thành Công");
				}
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(54, 132, 125, 32);
		pnlThongTinDichVu.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoDichVu.getDichVuTheoMa(txtMaDichVu.getText())!=null) {
					daoDichVu.deleteDichVu(txtMaDichVu.getText());
					JOptionPane.showInputDialog(this,"Xoá Thành Công");
					}
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(235, 132, 125, 32);
		pnlThongTinDichVu.add(btnXoa);
		
		JLabel lblMaDichVu = new JLabel("Mã dịch vụ");
		lblMaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaDichVu.setBounds(90, 20, 98, 25);
		pnlThongTinDichVu.add(lblMaDichVu);

		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoDichVu.getDichVuTheoMa(txtMaDichVu.getText())!=null) {
					DichVu dv=new DichVu(txtMaDichVu.getText(), txtTenDichVu.getText(), Double.parseDouble(txtGiaDichVu.getText()),Integer.parseInt(txtSoLuong.getText()),new LoaiDichVu(cbxMaLoaiDichVu.getSelectedItem().toString()));
					daoDichVu.updateDichVu(dv);
					JOptionPane.showInputDialog(this,"Sửa Thành Công");
					}	
			}
		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(409, 132, 125, 32);
		pnlThongTinDichVu.add(btnSua);
		
		btnNhapEXCEL = new JButton("Nhập File");
		btnNhapEXCEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DichVu dv=new DichVu();
				LoaiDichVu ldv=new LoaiDichVu();
				String command=e.getActionCommand();
				JFileChooser fc=new JFileChooser();
				if(command.equals("Nhập File")) {
					int re=fc.showOpenDialog(btnNhapEXCEL);
					if(re == JFileChooser.APPROVE_OPTION) {
						File file=fc.getSelectedFile();
						String fileName=file.getName();
						if(fileName.endsWith(".xlsx")) {
							XSSFWorkbook wb;
							try {
								wb = new XSSFWorkbook(file);
								XSSFSheet sheet=wb.getSheetAt(0);
								for (Row row:sheet) {
									if(row.getCell(0)!=null) {
										dv.setMaDichVu(row.getCell(0).toString());
									}
									if(row.getCell(1)!=null) {
										dv.setTenDichVu(row.getCell(1).toString());
									}
									if(row.getCell(2)!=null) {
										dv.setGiaDichVu(row.getCell(2).getNumericCellValue());
									}
									if(row.getCell(3)!=null) {
										dv.setSoLuong((int)row.getCell(3).getNumericCellValue());
									}
									if(row.getCell(4)!=null) {
										ldv.setMaLoaiDichVu(row.getCell(4).toString());
									}
									DecimalFormat df= new DecimalFormat("#,##0.00VND");
									Object[] rowData = {dv.getMaDichVu(),dv.getTenDichVu(),df.format(dv.getGiaDichVu()),dv.getSoLuong(),ldv.getTenLoaiDichVu()};
									modelDichVu.addRow(rowData);
								}
								wb.close();
							} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}	
					}
				};
			}
		});
		btnNhapEXCEL.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNhapEXCEL.setBounds(610, 132, 125, 32);
		pnlThongTinDichVu.add(btnNhapEXCEL);
		
		JLabel lblTenDichVu = new JLabel("Tên dịch vụ");
		lblTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenDichVu.setBounds(426, 20, 104, 25);
		pnlThongTinDichVu.add(lblTenDichVu);
		
		JLabel lblGiaDichVu = new JLabel("Giá dịch vụ");
		lblGiaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGiaDichVu.setBounds(54, 75, 110, 25);
		pnlThongTinDichVu.add(lblGiaDichVu);
		
		JLabel lblSoLuong = new JLabel("Số lượng tồn");
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoLuong.setBounds(393, 75, 125, 25);
		pnlThongTinDichVu.add(lblSoLuong);
		
		txtMaDichVu = new JTextField();
		txtMaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaDichVu.setBounds(198, 19, 202, 25);
		pnlThongTinDichVu.add(txtMaDichVu);
		txtMaDichVu.setColumns(10);
		
		txtTenDichVu = new JTextField();
		txtTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenDichVu.setColumns(10);
		txtTenDichVu.setBounds(540, 19, 255, 25);
		pnlThongTinDichVu.add(txtTenDichVu);
		
		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtGiaDichVu.setColumns(10);
		txtGiaDichVu.setBounds(163, 74, 202, 25);
		pnlThongTinDichVu.add(txtGiaDichVu);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(517, 74, 59, 25);
		pnlThongTinDichVu.add(txtSoLuong);
		
		JLabel lblMaLoaiDichVu = new JLabel("Loại dịch vụ");
		lblMaLoaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaLoaiDichVu.setBounds(598, 75, 149, 25);
		pnlThongTinDichVu.add(lblMaLoaiDichVu);
		
		cbxMaLoaiDichVu = new JComboBox<String>();
		cbxMaLoaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbxMaLoaiDichVu.setBounds(757, 75, 100, 30);
		cbxMaLoaiDichVu.setEditable(true);		
		ArrayList<LoaiDichVu> dsLoaiDichVu = daoLoaiDichVu.getAllLoaiDichVu();
		for (LoaiDichVu ldv : dsLoaiDichVu) {
			cbxMaLoaiDichVu.addItem(ldv.getTenLoaiDichVu());
		}
		
		pnlThongTinDichVu.add(cbxMaLoaiDichVu);
		
		btnXuatEXCEL = new JButton("Xuất File");
		btnXuatEXCEL.setBounds(798, 132, 125, 32);
		pnlThongTinDichVu.add(btnXuatEXCEL);
		btnXuatEXCEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//bo sung sau				
			}
		});
		btnXuatEXCEL.setFont(new Font("Times New Roman", Font.BOLD, 15));
	}

	private void docDuLieuTuSQL() {
		// TODO Auto-generated method stub
		DecimalFormat df= new DecimalFormat("#,##0.00VND");
		daoDichVu = new Dao_DichVu();
		for (DichVu dv : daoDichVu.getAllDichVu()) {
			Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(),df.format(dv.getGiaDichVu()),dv.getSoLuong(),dv.getMaLoaiDichVu().getTenLoaiDichVu()};
			modelDichVu.addRow(rowData);
		
	}
	}
	private void NhapFile() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaDichVu.setText(modelDichVu.getValueAt(row, 0).toString());
		txtTenDichVu.setText(modelDichVu.getValueAt(row, 1).toString());
		txtGiaDichVu.setText(modelDichVu.getValueAt(row, 2).toString());
		txtSoLuong.setText(modelDichVu.getValueAt(row, 3).toString());
		cbxMaLoaiDichVu.setSelectedItem(modelDichVu.getValueAt(row, 4).toString());
		// TODO Auto-generated method stub
		
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
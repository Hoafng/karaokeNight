package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import entity.CTHoaDonThuePhong;
import entity.DichVu;
import entity.HoaDonThuePhong;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_ThemDichVu extends JFrame /* implements TableCellRenderer */ {

	private JPanel contentPane;
	private JTable tableLeft;
	private JTable tableRight;
	private JTextField txtMaDichVuSearch;
	private JTextField txtTenDichVuSearch;
	private JTextField txtMaPhong;
	private DefaultTableModel modelDichVu;
	private DefaultTableModel modelDichVuRight;
	private Phong p;
	private TaiKhoan tk;
	private DichVu dv;
	private Dao_DichVu dao_dichvu = new Dao_DichVu();
	private Dao_CTHoaDon dao_CTHD = new Dao_CTHoaDon();
	private Dao_HoaDon dao_HoaDon;
	private JTextField txtSoLuong;
	/**
	 * Launch the application.
	 */
	private JButton btnadd;
	private JButton btnIconxoa;
	private JLabel lblThongBaoSoLuong;

	/**
	 * Create the frame.
	 */
	public GUI_ThemDichVu(Phong phong, TaiKhoan taiKhoan) {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = phong;
		tk = taiKhoan;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(101, 186, 118));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDichVu = new JLabel("Dịch Vụ");
		lblDichVu.setBounds(680, 23, 190, 35);
		lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblDichVu);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 91, 666, 652);
		panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelLeft);

		panelLeft.setLayout(null);
		panelLeft.setBackground(new Color(101, 186, 118));

		JLabel lblTatCaDichVu = new JLabel("Tất cả dịch vụ");
		lblTatCaDichVu.setBounds(273, 6, 186, 35);
		lblTatCaDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelLeft.add(lblTatCaDichVu);

		JPanel panelRight = new JPanel();
		panelRight.setBounds(763, 91, 693, 652);
		panelRight.setBorder(BorderFactory.createLineBorder(Color.black));

		panelRight.setLayout(null);
		panelRight.setBackground(new Color(101, 186, 118));
		tableRight = new JTable();
		tableRight.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tableRight.setBounds(10, 92, 702, 343);
		tableRight.setToolTipText("");
		tableRight.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng" }));

		String[] colHeader = { "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng" };
		modelDichVuRight = new DefaultTableModel(colHeader, 0);
		tableRight = new JTable(modelDichVuRight);
		tableRight.setFillsViewportHeight(true);
		tableRight.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableRight.setBounds(1, 25, 669, 300);
		panelRight.add(tableRight);

		JScrollPane scrollPane1 = new JScrollPane(tableRight);

//		JLabel lblMaDichVuSearch = new JLabel("Mã dịch vụ");
//		lblMaDichVuSearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		lblMaDichVuSearch.setBounds(10, 494, 89, 35);
//		panelLeft.add(lblMaDichVuSearch);
//
//		txtMaDichVuSearch = new JTextField();
//		txtMaDichVuSearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtMaDichVuSearch.setColumns(10);
//		txtMaDichVuSearch.setBounds(100, 489, 158, 40);
//		panelLeft.add(txtMaDichVuSearch);
//
//		JButton btnsearch = new JButton("");
//		btnsearch.setIcon(new ImageIcon("image\\search.png"));
//		btnsearch.setBounds(256, 489, 41, 40);
//		panelLeft.add(btnsearch);
//
//		JLabel lblTendichvuSearch = new JLabel("Tên dịch vụ");
//		lblTendichvuSearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		lblTendichvuSearch.setBounds(349, 494, 89, 35);
//		panelLeft.add(lblTendichvuSearch);
//
//		txtTenDichVuSearch = new JTextField();
//		txtTenDichVuSearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		txtTenDichVuSearch.setColumns(10);
//		txtTenDichVuSearch.setBounds(439, 489, 158, 40);
//		panelLeft.add(txtTenDichVuSearch);
//
//		JButton btnsearch1 = new JButton("");
//		btnsearch1.setIcon(new ImageIcon("image\\search.png"));
//		btnsearch1.setBounds(595, 489, 41, 40);
//		panelLeft.add(btnsearch1);
		scrollPane1.setBounds(10, 92, 673, 343);
		panelRight.add(scrollPane1);

		contentPane.add(panelRight);

		JLabel lblDichVuDaThem = new JLabel("Dịch vụ đã thêm");
		lblDichVuDaThem.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelRight.add(lblDichVuDaThem);

		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong.setBounds(54, 486, 89, 35);
		panelRight.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setEditable(false);
		txtMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(130, 486, 158, 40);
		panelRight.add(txtMaPhong);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(525, 580, 158, 40);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		panelRight.add(btnHuy);

		JLabel lblDichVuThem = new JLabel("Dịch vụ thêm");
		lblDichVuThem.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDichVuThem.setBounds(269, 10, 239, 35);
		panelRight.add(lblDichVuThem);

		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(343, 580, 158, 40);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertData();
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		panelRight.add(btnXacNhan);

		modelDichVu = new DefaultTableModel(colHeader, 0);
		tableLeft = new JTable(modelDichVu);
		tableLeft.setFillsViewportHeight(true);
		tableLeft.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableLeft.setBounds(1, 25, 669, 300);
		panelLeft.add(tableLeft);
		JScrollPane cpDichVuLeft = new JScrollPane(tableLeft);
		cpDichVuLeft.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cpDichVuLeft.setBounds(10, 92, 646, 343);
		panelLeft.add(cpDichVuLeft);
		tableLeft.setRowHeight(10);

		btnadd = new JButton("");
		btnadd.setBounds(689, 246, 53, 35);
		contentPane.add(btnadd);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
		btnadd.setIcon(new ImageIcon("image\\add.png"));

		btnIconxoa = new JButton("");
		btnIconxoa.setBounds(689, 428, 53, 35);
		contentPane.add(btnIconxoa);
		btnIconxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnItem();
			}
		});
		btnIconxoa.setIcon(new ImageIcon("image\\dauTru.png"));

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(680, 332, 73, 40);
		contentPane.add(txtSoLuong);
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoLuong.setColumns(10);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(680, 291, 74, 35);
		contentPane.add(lblSoLuong);
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblThongBaoSoLuong = new JLabel("");
		lblThongBaoSoLuong.setForeground(new Color(255, 0, 0));
		lblThongBaoSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBaoSoLuong.setBounds(668, 371, 97, 35);
		contentPane.add(lblThongBaoSoLuong);
		docDuLieuTuSQL();

	}

	private void docDuLieuTuSQL() {
		txtMaPhong.setText(p.getMaPhong());
		Dao_DichVu dichvuall = new Dao_DichVu();
		tableLeft.setRowHeight(25);
		for (DichVu d : dichvuall.getAllDichVu()) {
			Object[] rowData = { d.getMaDichVu(), d.getTenDichVu(), d.getGiaDichVu(), d.getSoLuong() };
			modelDichVu.addRow(rowData);
		}
		for (CTHoaDonThuePhong cthd : dao_CTHD.getAllCTHDDichVu(txtMaPhong.getText())) {
			Object[] rowData = { cthd.getMaDichVu().getMaDichVu(), cthd.getMaDichVu().getTenDichVu(),
					cthd.getMaDichVu().getGiaDichVu(), cthd.getSoLuongDichVu() };
			modelDichVuRight.addRow(rowData);
		}
	}

	private void InsertData() {
		dao_HoaDon = new Dao_HoaDon();
		String maHoaDon = dao_HoaDon.getMaHoaDonPhong(txtMaPhong.getText()).getMaHoaDon();
		ArrayList<CTHoaDonThuePhong> listCTHD = dao_CTHD.getAllCTHDDichVu(maHoaDon);
		for (int i = 0; i < modelDichVuRight.getRowCount(); i++) {
			CTHoaDonThuePhong ct = new CTHoaDonThuePhong(new HoaDonThuePhong(maHoaDon),
					new DichVu(modelDichVuRight.getValueAt(i, 0).toString()),
					Integer.valueOf(modelDichVuRight.getValueAt(i, 3).toString()));
			if (listCTHD.contains(ct)) {
				dao_CTHD.updateSoLuongThem(Integer.valueOf(modelDichVuRight.getValueAt(i, 3).toString()),
						modelDichVuRight.getValueAt(i, 0).toString(), maHoaDon);

			} else
				dao_CTHD.insertDichVuThem(ct);
		}
		for (int j = 0; j < modelDichVuRight.getRowCount(); j++) {
			dao_dichvu.updateSoLuong(modelDichVu.getValueAt(j, 0).toString(),
					Integer.valueOf(modelDichVu.getValueAt(j, 3).toString()));
		}
	}

	private boolean addItem() {
		int row = tableLeft.getSelectedRow();
		String maDichVu = modelDichVu.getValueAt(row, 0).toString();
		String tenDichVu = modelDichVu.getValueAt(row, 1).toString();
		String gia = modelDichVu.getValueAt(row, 2).toString();
		int soLuong = Integer.valueOf(modelDichVu.getValueAt(row, 3).toString());
		int soLuongThem = 0;
		int soLuongRight = 0;
		if (txtSoLuong.getText().equals("") == false)
			soLuongThem = Integer.valueOf(txtSoLuong.getText());
		Object[] rowData = { maDichVu, tenDichVu, gia, soLuongThem };
		soLuong = soLuong - soLuongThem;
		if (soLuong <= 0) {
			JOptionPane.showMessageDialog(null, "Số lượng dịch vụ không đủ");
			txtSoLuong.requestFocus();
			return false;
		}
		for (int i = 0; i < modelDichVuRight.getRowCount(); i++) {
			if (maDichVu.equals(modelDichVuRight.getValueAt(i, 0))) {
				soLuongRight = Integer.valueOf(modelDichVuRight.getValueAt(row, 3).toString());
				soLuongRight = soLuongRight + soLuongThem;
				modelDichVuRight.setValueAt(soLuongRight, i, 3);
			}
		}
		if (soLuongRight == 0)
			modelDichVuRight.addRow(rowData);
		txtSoLuong.setText("");
		modelDichVu.setValueAt(soLuong, row, 3);
		return true;
	}

	private void returnItem() {
		int row = tableRight.getSelectedRow();
		String maDichVu = modelDichVuRight.getValueAt(row, 0).toString();
		int soLuong = Integer.valueOf(modelDichVuRight.getValueAt(row, 3).toString());
		int soLuongThem = Integer.valueOf(txtSoLuong.getText());
		soLuong = soLuong - soLuongThem;
		if (soLuong < 0) {
			JOptionPane.showMessageDialog(this, "Số lượng xóa phải nhỏ hơn số lượng đã thêm");
		}
		int soLuongReturn = 0;
		modelDichVuRight.setValueAt(soLuong, row, 3);
		int j = 0;
		for (int i = 0; i < modelDichVu.getRowCount(); i++) {
			if (modelDichVu.getValueAt(i, 0).toString().equals(maDichVu)) {
				soLuongReturn = Integer.valueOf(modelDichVu.getValueAt(i, 3).toString());
				j = i;
			}
		}
		modelDichVu.setValueAt(soLuongReturn + soLuongThem, j, 3);
		txtSoLuong.setText("");
	}
}
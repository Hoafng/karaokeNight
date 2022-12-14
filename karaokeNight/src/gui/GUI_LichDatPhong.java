package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_CTHoaDon;
import dao.Dao_DichVu;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_PhieuDatPhong;
import dao.Dao_Phong;
import entity.HoaDonThuePhong;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.TaiKhoan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class GUI_LichDatPhong extends JFrame implements ActionListener, PropertyChangeListener {

	private JPanel contentPane;
	private DefaultTableModel modelTkDichVu;
	private JTable tbLichDatPhong;
	private JDateChooser dateChooser;
	private JTextField txtNgay;
	private Dao_DichVu dao_DichVu;
	private Dao_CTHoaDon dao_CTHD = new Dao_CTHoaDon();
	private Dao_HoaDon dao_HoaDon = new Dao_HoaDon();
	private Dao_PhieuDatPhong dao_PhieuDatPhong = new Dao_PhieuDatPhong();
	private TaiKhoan tk;
	private JLabel lblKqDichVuBan;
	private Dao_Phong dao_Phong = new Dao_Phong();
	private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
	private JComboBox<String> cbMaPhong;
	private JComboBox<String> cbGioGioNhanPhong;
	private JCheckBox ckbDaDat;
	private JCheckBox ckbDangSuDung;
	private JCheckBox ckbTrong;
	protected int selectedValue;
	List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(3);
	List<RowFilter<Object, Object>> filter2s = new ArrayList<RowFilter<Object, Object>>(3);
	private TableRowSorter<DefaultTableModel> rowSorter;
	private Phong p;
	private KhachHang kh;
	private JLabel txtMaPhongDat;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_LichDatPhong(TaiKhoan taiKhoan, Phong phong, KhachHang khachHang) {
		// kh???i t???o k???t n???i ?????n CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao_DichVu = new Dao_DichVu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		tk = taiKhoan;
		kh = khachHang;
		p = phong;
		JPanel pnTop = new JPanel();
		pnTop.setBounds(0, 35, 1466, 52);
		pnTop.setBackground(new Color(101, 186, 118));
		contentPane.add(pnTop);
		pnTop.setLayout(null);

		JLabel lblThongKeDichVu = new JLabel("L???ch ?????t ph??ng");
		lblThongKeDichVu.setBounds(731, 10, 224, 35);
		lblThongKeDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblThongKeDichVu);

		JPanel pnLeft = new JPanel();
		pnLeft.setBounds(10, 97, 392, 427);
		pnLeft.setBackground(new Color(101, 186, 118));
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Ch???c n??ng"));
		pnLeft.setLayout(null);

		ImageIcon iconLamMoi = new ImageIcon("IMG//iconButton//Refresh.png");

		ImageIcon iconThongKe = new ImageIcon("IMG//iconButton//statistical.png");
		JButton btnTimKiem = new JButton("H???y", iconThongKe);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk);
			}
		});
		btnTimKiem.setBackground(new Color(255, 255, 140));
		btnTimKiem.setForeground(new Color(0, 0, 0));
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTimKiem.setBounds(60, 371, 280, 33);
		pnLeft.add(btnTimKiem);

		JPanel panel_1_2_2_2_1 = new JPanel();
		panel_1_2_2_2_1.setLayout(null);
		panel_1_2_2_2_1.setBounds(60, 110, 280, 30);
		pnLeft.add(panel_1_2_2_2_1);

		JLabel lblGioNhanPhong = new JLabel("Gi??? nh???n ph??ng");
		lblGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(10, 0, 102, 30);
		panel_1_2_2_2_1.add(lblGioNhanPhong);
		cbGioGioNhanPhong = new JComboBox<>();
		cbGioGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbGioGioNhanPhong.addItem("Tr???ng");

		cbGioGioNhanPhong.setBounds(111, 1, 120, 30);
		for (int i = 0; i < 24; i++) {
			cbGioGioNhanPhong.addItem(String.valueOf(i));
		}
		panel_1_2_2_2_1.add(cbGioGioNhanPhong);

		JLabel lblGioGioNhanPhong = new JLabel("Gi???");
		lblGioGioNhanPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioGioNhanPhong.setBounds(230, 0, 50, 30);
		panel_1_2_2_2_1.add(lblGioGioNhanPhong);

		JPanel panel = new JPanel();
		panel.setBounds(60, 45, 280, 30);
		pnLeft.add(panel);
		panel.setLayout(null);

		JLabel lblTuNgay = new JLabel("Ng??y nh???n ph??ng");
		lblTuNgay.setBounds(0, 0, 117, 30);
		panel.add(lblTuNgay);
		lblTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		txtNgay = new JTextField();
		txtNgay.setBounds(111, 0, 140, 30);
		panel.add(txtNgay);
		txtNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNgay.setColumns(10);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(250, 0, 30, 30);
		panel.add(dateChooser);
		dateChooser.getCalendarButton().setBounds(0, 0, 31, 30);
		dateChooser.setLayout(null);

		JButton btnLamMoiDichVu_1 = new JButton("L??m m???i", null);
		btnLamMoiDichVu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoiTimKiem();
			}
		});
		btnLamMoiDichVu_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiDichVu_1.setBackground(new Color(255, 255, 140));
		btnLamMoiDichVu_1.setBounds(60, 328, 280, 33);
		pnLeft.add(btnLamMoiDichVu_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(60, 175, 280, 30);
		pnLeft.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaPhong = new JLabel("M?? ph??ng");
		lblMaPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(0, 0, 130, 30);
		panel_1.add(lblMaPhong);

		cbMaPhong = new JComboBox<String>();
		cbMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbMaPhong.setBounds(130, 0, 150, 30);
		cbMaPhong.addItem("T???t c???");
		for (Phong p : dao_Phong.getAllPhong()) {
			if (p.getTinhTrang().equals("???? ?????t") || p.getTinhTrang().equals("??ang ch???"))
				cbMaPhong.addItem(p.getMaPhong());
		}
		panel_1.add(cbMaPhong);

		ckbDaDat = new JCheckBox("???? ?????t");

		ckbDaDat.setSelected(true);
		ckbDaDat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ckbDaDat.setBackground(new Color(101, 186, 118));
		ckbDaDat.setBounds(60, 235, 80, 30);
		pnLeft.add(ckbDaDat);

		ckbDangSuDung = new JCheckBox("??ang s??? d???ng");
		ckbDangSuDung.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ckbDangSuDung.setBackground(new Color(101, 186, 118));
		ckbDangSuDung.setBounds(140, 235, 120, 30);
		pnLeft.add(ckbDangSuDung);

		ckbTrong = new JCheckBox("Tr???ng");
		ckbTrong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ckbTrong.setBackground(new Color(101, 186, 118));
		ckbTrong.setBounds(262, 235, 100, 30);
		pnLeft.add(ckbTrong);

		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(430, 97, 1036, 636);
		pnCenter.setBackground(new Color(101, 186, 118));
		contentPane.add(pnCenter);
		String[] cols = { "M?? ph??ng", "Ng??y nh???n ph??ng", "Gi??? nh???n ph??ng", "Gi??? tr??? ph??ng", "S??? gi??? thu??",
				"Ng??y ?????t ph??ng", "Kh??ch h??ng","S??? ??i???n tho???i", "T??nh tr???ng" };
		modelTkDichVu = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tbLichDatPhong = new JTable(modelTkDichVu);
		tbLichDatPhong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrtbl = new JScrollPane(tbLichDatPhong, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tbLichDatPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = tbLichDatPhong.getSelectedRow();
				txtMaPhongDat.setText(tbLichDatPhong.getValueAt(row, 0).toString());
				p = new Phong(tbLichDatPhong.getValueAt(row, 0).toString());
			}
		});
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh s??ch ?????t ph??ng"));
		scrtbl.setBounds(10, 20, 1016, 606);
		pnCenter.add(scrtbl);
		dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtNgay.setText(a);
				}
			}
		});
		rowSorter = new TableRowSorter<DefaultTableModel>(modelTkDichVu);
		tbLichDatPhong.setRowSorter(rowSorter);

		JPanel pnLeft_1 = new JPanel();
		pnLeft_1.setLayout(null);
		pnLeft_1.setBorder(new TitledBorder("Ch???c n??ng"));
		pnLeft_1.setBackground(new Color(101, 186, 118));
		pnLeft_1.setBounds(10, 534, 392, 199);
		contentPane.add(pnLeft_1);

		JButton btnThuePhong_1 = new JButton("?????t ph??ng", null);
		btnThuePhong_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p != null) {
					dispose();
					new GUI_DatPhong(p, tk, kh).setVisible(true);
				}
			}
		});
		btnThuePhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnThuePhong_1.setBackground(new Color(255, 255, 140));
		btnThuePhong_1.setBounds(60, 93, 280, 33);
		pnLeft_1.add(btnThuePhong_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(60, 32, 280, 30);
		pnLeft_1.add(panel_2_1);

		JLabel lblTuNgay_1_1 = new JLabel("M?? ph??ng:");
		lblTuNgay_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuNgay_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTuNgay_1_1.setBounds(0, 0, 111, 30);
		panel_2_1.add(lblTuNgay_1_1);

		txtMaPhongDat = new JLabel("");
		txtMaPhongDat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaPhongDat.setBounds(121, 0, 159, 30);
		panel_2_1.add(txtMaPhongDat);

		JButton btnHuyPhong = new JButton("H???y ph??ng", null);
		btnHuyPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tbLichDatPhong.getSelectedRow();
				if (row != -1) {
					Timestamp date = Timestamp
							.valueOf(tbLichDatPhong.getValueAt(row, 1) + " " + tbLichDatPhong.getValueAt(row, 2));
					int huy = JOptionPane.showConfirmDialog(null, "X??c nh???n h???y ph??ng", "H???y ph??ng",
							JOptionPane.YES_NO_OPTION);
					if (huy == JOptionPane.YES_OPTION) {
						if(dao_PhieuDatPhong.deletePhieuDatPhong(tbLichDatPhong.getValueAt(row, 0).toString(), date, true,tbLichDatPhong.getValueAt(row, 6).toString())==true) {
							modelTkDichVu.removeRow(row);
							JOptionPane.showMessageDialog(null, "H???y ph??ng th??nh c??ng");
						}
						
					}

				}
			}
		});
		btnHuyPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnHuyPhong.setBackground(new Color(255, 255, 140));
		btnHuyPhong.setBounds(60, 136, 280, 33);
		pnLeft_1.add(btnHuyPhong);
		txtNgay.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = txtNgay.getText();
				if (ckbDaDat.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("???? ?????t", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbDangSuDung.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("??ang s??? d???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbTrong.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("Tr???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (cbGioGioNhanPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbGioGioNhanPhong.getSelectedItem().toString(), 2, 3));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (cbMaPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbMaPhong.getSelectedItem().toString(), 0));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (text.trim().length() == 0) {
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filter2s.removeAll(filter2s);
					filters.removeAll(filters);

				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 8);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filter2s.removeAll(filter2s);
					filters.removeAll(filters);
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = txtNgay.getText();
				if (ckbDaDat.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("???? ?????t", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbDangSuDung.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("??ang s??? d???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbTrong.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("Tr???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (cbGioGioNhanPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbGioGioNhanPhong.getSelectedItem().toString(), 2, 3));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (cbMaPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbMaPhong.getSelectedItem().toString(), 0));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (text.trim().length() == 0) {
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filter2s.removeAll(filter2s);
					filters.removeAll(filters);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 1);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filter2s.removeAll(filter2s);
					filters.removeAll(filters);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}
		});
		cbMaPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String text = (String) cbMaPhong.getSelectedItem();
				if (ckbDaDat.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("???? ?????t", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbDangSuDung.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("??ang s??? d???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbTrong.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("Tr???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (cbGioGioNhanPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbGioGioNhanPhong.getSelectedItem().toString(), 2, 3));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!txtNgay.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtNgay.getText().toString(), 1));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (cbMaPhong.getSelectedIndex() == 0) {
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filter2s.removeAll(filter2s);
					filters.removeAll(filters);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 0);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filter2s.removeAll(filter2s);
					filters.removeAll(filters);
				}

			}
		});
		cbGioGioNhanPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String text = cbGioGioNhanPhong.getSelectedItem().toString();
				if (ckbDaDat.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("???? ?????t", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbDangSuDung.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("??ang s??? d???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbTrong.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("Tr???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (cbMaPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbMaPhong.getSelectedItem().toString(), 0));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!txtNgay.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtNgay.getText().toString(), 1));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (cbGioGioNhanPhong.getSelectedIndex() == 0) {
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filter2s.removeAll(filter2s);
					filters.removeAll(filters);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter(text, 2, 3);
					filters.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filter2s.removeAll(filter2s);
					filters.removeAll(filters);
				}
			}
		});
		ckbDaDat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (ckbDangSuDung.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("??ang s??? d???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbTrong.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("Tr???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (cbGioGioNhanPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbGioGioNhanPhong.getSelectedItem().toString(), 2, 3));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!txtNgay.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtNgay.getText().toString(), 1));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (cbMaPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbMaPhong.getSelectedItem().toString(), 0));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!ckbDaDat.isSelected()) {
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.removeAll(filters);
					filter2s.removeAll(filter2s);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("???? ?????t", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.removeAll(filters);
					filter2s.removeAll(filter2s);
				}
			}
		});
		ckbDangSuDung.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (ckbDaDat.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("???? ?????t", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbTrong.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("Tr???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);

				}
				if (cbGioGioNhanPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbGioGioNhanPhong.getSelectedItem().toString(), 2, 3));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!txtNgay.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtNgay.getText().toString(), 1));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (cbMaPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbMaPhong.getSelectedItem().toString(), 0));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!ckbDangSuDung.isSelected()) {
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.removeAll(filters);
					filter2s.removeAll(filter2s);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("??ang s??? d???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.removeAll(filters);
					filter2s.removeAll(filter2s);
				}
			}
		});
		ckbTrong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (ckbDaDat.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("???? ?????t", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (ckbDangSuDung.isSelected() == true) {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("??ang s??? d???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					rowSorter.setRowFilter(rf);
				}
				if (cbGioGioNhanPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbGioGioNhanPhong.getSelectedItem().toString(), 2, 3));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!txtNgay.getText().toString().isBlank()) {
					filters.add(RowFilter.regexFilter(txtNgay.getText().toString(), 1));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (cbMaPhong.getSelectedIndex() != 0) {
					filters.add(RowFilter.regexFilter(cbMaPhong.getSelectedItem().toString(), 0));
					RowFilter<DefaultTableModel, Object> rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
				}
				if (!ckbTrong.isSelected()) {
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.removeAll(filters);
					filter2s.removeAll(filter2s);
				} else {
					RowFilter<Object, Object> temp = RowFilter.regexFilter("Tr???ng", 8);
					filter2s.add(temp);
					RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
					if (filters.isEmpty() == false)
						rf = RowFilter.andFilter(filters);
					rowSorter.setRowFilter(rf);
					filters.removeAll(filters);
					filter2s.removeAll(filter2s);
				}
			}
		});
		DocDuLieuDatabaseVaoTable();
	}

	protected void lamMoiTimKiem() {
		txtNgay.setText("");
		cbGioGioNhanPhong.setSelectedIndex(0);
		cbMaPhong.setSelectedIndex(0);
		ckbDaDat.setSelected(true);
		ckbDangSuDung.setSelected(false);
		ckbTrong.setSelected(false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

	public void DocDuLieuDatabaseVaoTable() {
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("HH:mm:ss");
		for (PhieuDatPhong pd : dao_PhieuDatPhong.getAllPhieuDatPhong()) {
			if (pd.isTonTai()) {
				Object[] rowData = { pd.getMaPhong().getMaPhong(), sf1.format(pd.getNgayNhanPhong()),
						sf2.format(pd.getNgayNhanPhong()),
						sf2.format(pd.getNgayNhanPhong().getTime() + pd.getSoGioDat() * 60 * 60 * 1000),
						pd.getSoGioDat(), sf1.format(pd.getNgayDatPhong()),
						dao_KhachHang.getTheoMa(pd.getMaKhachHang().getMaKhachHang()).getTenKhachHang(),dao_KhachHang.getTheoMa(pd.getMaKhachHang().getMaKhachHang()).getSoDienThoai(), "???? ?????t" };
				modelTkDichVu.addRow(rowData);
			}
		}
		for (HoaDonThuePhong hd : dao_HoaDon.getAllHoaDon()) {
			if (hd.getNgayLap() == null) {
				Object[] rowData = { hd.getMaPhong().getMaPhong(), sf1.format(hd.getGioVaoPhong()),
						sf2.format(hd.getGioVaoPhong()),
						hd.getGioRaPhong() != null ? sf2.format(hd.getGioRaPhong()) : "", "","",
						dao_KhachHang.getTheoMa(hd.getMaKhachHang().getMaKhachHang()).getTenKhachHang(),dao_KhachHang.getTheoMa(hd.getMaKhachHang().getMaKhachHang()).getSoDienThoai(),
						"??ang s??? d???ng" };
				modelTkDichVu.addRow(rowData);
			}
		}
		for (Phong p : dao_Phong.getAllPhong()) {
			if (p.getTinhTrang().equals("Tr???ng")) {
				Object[] rowData = { p.getMaPhong(), "", "", "", "", "", "","", "Tr???ng" };
				modelTkDichVu.addRow(rowData);
			}
		}
		RowFilter<Object, Object> temp = RowFilter.regexFilter("???? ?????t", 8);
		filter2s.add(temp);
		RowFilter<DefaultTableModel, Object> rf = RowFilter.orFilter(filter2s);
		rowSorter.setRowFilter(rf);
		filter2s.remove(filter2s.indexOf(temp));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

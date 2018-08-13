//setup dbcontext
    private final String serverName = "localhost";
    private final String dbName = "...";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";

//init table
    public void initTable(String sql, DefaultTableModel dftm, JTable table) {
        try {
            ResultSet rs = dao.getData(sql);
            Object[] title = {"StdID", "StdName", "DepartName", "Gender", "Age"};
            dftm.setColumnIdentifiers(title);
            dftm.setRowCount(0);
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString(1));
                vec.add(rs.getString(2));
                vec.add(rs.getString(3));
                vec.add(rs.getBoolean(4));
                vec.add(rs.getInt(5));
                dftm.addRow(vec);
            }
            table.setModel(dftm);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

//load table
	public void loadTable() {
        String sql = "SELECT * FROM dbo.Outcomes";
        initTable(sql, dftm, jTable1);
    }

//load data
    public void loadData() {
        try {
            String sql = "SELECT StdID, StdName,DepartName,Gender,Age\n"
                    + "FROM DepartInfo INNER JOIN\n"
                    + " StudentInfo ON DepartInfo.DepartID = StudentInfo.DepartmentID";
            ResultSet rs = dao.getPS(sql).executeQuery();
            Object[] title = {"StdID", "StdName", "DepartName", "Gender", "Age"};
            form.getCbbColumnSearch().setModel(new DefaultComboBoxModel(title));
            dftm.setColumnIdentifiers(title);
            dftm.setRowCount(0);
            hs.clear();
            while (rs.next()) {
                Vector vec = new Vector();
                vec.add(rs.getString(1));
                hs.add(rs.getString(1));
                vec.add(rs.getString(2));
                vec.add(rs.getString(3));
                vec.add(rs.getBoolean(4));
                vec.add(rs.getInt(5));
                dftm.addRow(vec);
            }
            form.getjTable1().setModel(dftm);
        } catch (Exception ex) {
            System.out.println("Error while connect to Db " + ex.getMessage());
        }
    }

//delete
    public void delete() {
        try {
            String sql = "Delete StudentInfo where stdID = ?";
            PreparedStatement ps = dao.getPS(sql);
            if (form.getTxtStdID().getText().length() > 0) {
                ps.setString(1, form.getTxtStdID().getText());
                ps.executeUpdate();
                loadData();
            }
        } catch (Exception ex) {
            System.out.println("Error while connect to Db " + ex.getMessage());
        }
    }

//update
    public void update() {
        try {
            PreparedStatement ps;
            String sql = "Update StudentInfo set StdName = ?,DepartmentID = ?,Gender = ?, Age = ? where StdID = ?";
            ps = dao.getPS(sql);
            ps.setString(1, form.getTxtStdName().getText());
            ps.setString(2, hm.get(form.getCbbDepartment().getSelectedItem()).toString());
            ps.setBoolean(3, form.getCbxGender().isSelected());
            ps.setInt(4, form.getSlbAge().getValue());
            ps.setString(5, form.getTxtStdID().getText());
            ps.executeUpdate();
            loadData();
        } catch (Exception ex) {

        }
    }

//insert
    public void insert() {
        try {
            PreparedStatement ps;
            String sql = "Insert into StudentInfo values (?, ?, ?, ?, ?)";
            ps = dao.getPS(sql);
            ps.setString(1, form.getTxtStdID().getText());
            ps.setString(2, form.getTxtStdName().getText());
            ps.setString(4, form.getCbxGender().getText().equals(true) ? "1" : "0");
            ps.setString(5, form.getSlbAge().getValue() + "");
            ps.setString(3, hm.get(form.getCbbDepartment().getSelectedItem()).toString());
            ps.executeUpdate();
            loadData();
        } catch (Exception ex) {

        }
    }

//search
    public void search() {
        String searchText = form.getTxtSearch().getText();
        if (form.getCbxSearchAll().isSelected()) {
            String sql = "Select s.StdID, s.StdName, d.DepartName, s.Gender, s.Age from StudentInfo s, DepartInfo d where "
                    + "s.DepartmentID = d.DepartID AND "
                    + "( s.StdID LIKE '%" + searchText + "%' OR s.StdName LIKE '%" + searchText + "%' OR "
                    + "d.DepartName LIKE '%" + searchText + "%' OR s.Gender LIKE '%" + searchText + "%' OR s.Age LIKE '%" + searchText + "%');";
            initTable(sql, dftm2, form.getTblResult());
        } else {
            String columnSelected = form.getCbbColumnSearch().getSelectedItem().toString();
            String sql = "Select s.StdID, s.StdName, d.DepartName, s.Gender, s.Age from StudentInfo s, DepartInfo d where "
                    + "s.DepartmentID = d.DepartID AND "
                    + columnSelected + " LIKE '%" + searchText + "%';";
            initTable(sql, dftm2, form.getTblResult());
        }
    }
	
//pop up messages
	JOptionPane.showMessageDialog( null, "Success");
	
//when date null
	Date date = rs.getDate(4);
    if (date == null) {
        s = "Null";
    } else {
        s = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(4));
    }

//disable key default
	txtArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK), "none");

//add item to combobox
	public void addItemCombobox() {
        try {
            String sql = "SELECT o.battle FROM dbo.Outcomes o";
            ResultSet rs = dao.getData(sql);
            while (rs.next()) {
                cbbSelectBattle.addItem(rs.getString(1)); //to add combobox
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
//click combobox change info other field
	public void clickCombobox() {
        setShip();
        setResult();
        cbbSelectBattle.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                setShip();
                setResult();
            }
        });
    }
	public void setResult() {//example for click combobox
        try {
            String sql = "SELECT o.result FROM dbo.Outcomes o\n"
                    + "WHERE o.battle = '" + cbbSelectBattle.getSelectedItem().toString() + "'";
            ResultSet rs = dao.getData(sql);
            while (rs.next()) {
                tfNewResult.setText(rs.getString(1));
            }
        } catch (SQLException ex) {	
            ex.printStackTrace();
        }
    }

//init properties
    public void initProperties(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberColum = rsmd.getColumnCount();

            for (int i = 1; i <= numberColum; i++) {
                String name = rsmd.getColumnName(i);
                demo.getCbProperties().addItem(name);
            }
        } catch (Exception e) {
        }
    }
	
//change info when user click row
    public void changeInfoClickRowInTable(){
        int currentRout = jTable1.getSelectedRow();
        String battle = jTable1.getValueAt(currentRout , 1).toString();
	}


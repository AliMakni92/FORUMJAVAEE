package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


import Entities.Content;
import Entities.User;
import businessDelegate.AccountManagementServiceDelegate;
import businessDelegate.ContentServicesDelegate;

class TableUserNotAdminandModeratorModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String[] COLUMNS = {"ID","lastname", "username", "role","Enabled"};
    
    private static final int COL_ID = 0;
    private static final int COL_TITLE = 1;

	private String x="user";
List< User> userss=AccountManagementServiceDelegate.findAllUserNotAdminAndModerator(x);
    // ArrayList<User> users=AccountManagementServiceDelegate.dolistAlphabetically((ArrayList<User>) userss);  //list that is injected via constructor or setter method

    public int getRowCount() {
        return userss.size();
    }

    public int getColumnCount() {
        return COLUMNS.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = userss.get(rowIndex);
        switch (columnIndex) {
        	case 0:
        		return user.getId();
            case 1:
                return user.getUsername();
            case 2:
                return user.getPassword();
            case 3:
                return user.getRole();
            case 4 :if(user.getEnabled()==true)
                return "Actif";
            else return "Blocked";
          
                
        }
        return null;
    }
        


    public String getColumnName(int column) {
        return COLUMNS[column];
    }}

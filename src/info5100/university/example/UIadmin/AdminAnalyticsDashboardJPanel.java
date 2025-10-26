/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package info5100.university.example.UIadmin;

import info5100.university.example.Department.Department;
import info5100.university.example.Persona.*;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Calendar;

import info5100.university.example.CourseSchedule.SeatAssignment; 
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Collection;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 陈凯璐
 */
public class AdminAnalyticsDashboardJPanel extends javax.swing.JPanel {
    
    private Department department;
    private JPanel mainpanel;

    /**
     * Creates new form AdminAnalyticsDashboardJPanel
     */
    public AdminAnalyticsDashboardJPanel(Department department, JPanel mainpanel) {
        
        initComponents(); 
        
        this.department = department;
        this.mainpanel = mainpanel;
        
        populateSemesterCombo();
        String selectedsemester = (String) jComboBox1.getSelectedItem().toString();
        populateStudentDetailsTable(selectedsemester); 
        

       
    }

    
  private void refreshAllData() {
        String selectedSemester = (String) jComboBox1.getSelectedItem();

        populateSummaryMetrics(selectedSemester);
        populateRoleTable();
        populateCourseEnrollmentTable(selectedSemester);
        
        
    }
    
    private void populateSemesterCombo() {
        jComboBox1.removeAllItems();
        Calendar calendar = department.getCalendar();
        if (calendar != null && calendar.getAllSemesterNames() != null) {
            Collection<String> semesterNames = calendar.getAllSemesterNames();
            for (String semesterName : semesterNames) {
                jComboBox1.addItem(semesterName);
            }
        }
    }

  
    private void populateCourseEnrollmentTable(String semester) {
        DefaultTableModel model = (DefaultTableModel) tblCourseEnrollment.getModel();
        model.setRowCount(0);

        if (semester == null) {
            model.addRow(new Object[]{"Please select a semester", 0});
            return;
        }

        CourseSchedule schedule = department.getCalendar().getCourseSchedule(semester);

        if (schedule != null && schedule.getSchedule() != null) {
             lblCourseEnrollmentTitle.setText("Enrolled Students per Course (" + semester + ")");
            for (CourseOffer co : schedule.getSchedule()) {
                model.addRow(new Object[]{
                    co.getCourseName(),
                    co.getOcupiedSeatNumber()
                });
            }
        } else {
            lblCourseEnrollmentTitle.setText("Enrolled Students per Course");
            model.addRow(new Object[]{"No schedule found for " + semester, 0});
        }

        tblCourseEnrollment.revalidate();
        tblCourseEnrollment.repaint();
    }
    
    private void populateStudentDetailsTable(String selectedsemster) {
       DefaultTableModel model = (DefaultTableModel)tblStudentDetails.getModel();
       model.setRowCount(0);
       CourseSchedule courseschedule = department.getCalendar().getCourseSchedule(selectedsemster);
       
       for(CourseOffer courseoffer: courseschedule.getSchedule()){ 
          
           Object[] row = new Object[3];
           row[0] = courseoffer.getCourseName(); 
           row[1] = courseoffer.getOcupiedSeatNumber();
           row[2] = courseoffer.getTotalCourseRevenues();
         
          model.addRow(row);
        }
    }

    
    private void clearStudentDetailsTable() {
         DefaultTableModel model = (DefaultTableModel) tblStudentDetails.getModel();
         model.setRowCount(0);
         lblStudentDetailsTitle.setText("Student Details (Select a course above)");
     }


    private void populateSummaryMetrics(String semester) {
        int totalStudents = 0;
        int totalFaculty = 0;
        int totalRegistrar = 0;
        int totalAdmin = 0;

        if (department.getUseraccountdirectory() != null) {
            for (UserAccount ua : department.getUseraccountdirectory().getUserAccountDirectory()) {
                 String role = ua.getRole().toLowerCase();
                 if (role.contains("student")) totalStudents++;
                 else if (role.contains("faculty")) totalFaculty++;
                 else if (role.contains("registrar")) totalRegistrar++;
                 else if (role.contains("admin")) totalAdmin++;
            }
        }

        lblTotalUsersValue.setText(String.valueOf(totalStudents + totalFaculty + totalRegistrar + totalAdmin));
        
        
    }
 
    
    private void populateRoleTable() {
        DefaultTableModel model = (DefaultTableModel) tblSummary.getModel();
        model.setRowCount(0);

        int totalStudents = 0;
        int totalFaculty = 0;
        int totalRegistrar = 0;
        int totalAdmin = 0;

        if (department.getUseraccountdirectory() != null) {
             for (UserAccount ua : department.getUseraccountdirectory().getUserAccountDirectory()) {
                 String role = ua.getRole().toLowerCase();
                 if (role.contains("student")) totalStudents++;
                 else if (role.contains("faculty")) totalFaculty++;
                 else if (role.contains("registrar")) totalRegistrar++;
                 else if (role.contains("admin")) totalAdmin++;
             }
        }

        // Use the hardcoded value '5' as requested previously
        int totalEnrolledStudents = 5;

        double totalTuitionRevenue = 0.0;
        if (department.getStudentdirectory() != null) {
              for (StudentProfile sp : department.getStudentdirectory().getStudentlist()) {
                 ArrayList<PaymentTransaction> transactions = sp.getPaymentHistory();
                 if (transactions != null) {
                     for (PaymentTransaction tx : transactions) {
                         if (tx.getAmount() > 0) {
                             totalTuitionRevenue += tx.getAmount();
                         }
                     }
                 }
             }
        }

        model.addRow(new Object[]{"Student", totalStudents, totalEnrolledStudents, totalStudents - totalEnrolledStudents}); // Active shows "5"
        model.addRow(new Object[]{"Faculty", totalFaculty, totalFaculty, 0});
        model.addRow(new Object[]{"Registrar", totalRegistrar, totalRegistrar, 0});
        model.addRow(new Object[]{"Admin", totalAdmin, totalAdmin, 0});
        model.addRow(new Object[]{"Total Tuition Revenue", "-", "-", "$" + String.format("%,.2f", totalTuitionRevenue)});

        tblSummary.revalidate();
        tblSummary.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblTotalUsers = new javax.swing.JLabel();
        lblTotalUsersValue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSummary = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblSelectSemester = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblCourseEnrollmentTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCourseEnrollment = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudentDetails = new javax.swing.JTable();
        lblStudentDetailsTitle = new javax.swing.JLabel();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        lblTitle.setText("University Analytics Dashboard");

        lblTotalUsers.setText("Total Active Users");

        lblTotalUsersValue.setText("0");

        tblSummary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Role", "Total Users", "Active", "Inactive"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSummary);

        btnRefresh.setText("Refresh Data");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setText(">>Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblSelectSemester.setText("Select Semester");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        lblCourseEnrollmentTitle.setText("Enrolled Students per Course");

        tblCourseEnrollment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Name", "Course Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCourseEnrollment);

        tblStudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Offered", "Enrolled Students", "Tuition Revenue"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStudentDetails);

        lblStudentDetailsTitle.setText("Student Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(205, 205, 205))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotalUsers)
                            .addComponent(lblSelectSemester))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lblTotalUsersValue, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblCourseEnrollmentTitle))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addComponent(btnRefresh)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblStudentDetailsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectSemester)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalUsers)
                    .addComponent(lblTotalUsersValue))
                .addGap(5, 5, 5)
                .addComponent(lblStudentDetailsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCourseEnrollmentTitle)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnBack))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        System.out.println("Refresh button clicked!"); 
        refreshAllData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
       CardLayout layout = (CardLayout) mainpanel.getLayout();
        layout.previous(mainpanel);
        mainpanel.remove(this);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem() != null) {
        populateStudentDetailsTable(jComboBox1.getSelectedItem().toString());
    }
    
        refreshAllData();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCourseEnrollmentTitle;
    private javax.swing.JLabel lblSelectSemester;
    private javax.swing.JLabel lblStudentDetailsTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalUsers;
    private javax.swing.JLabel lblTotalUsersValue;
    private javax.swing.JTable tblCourseEnrollment;
    private javax.swing.JTable tblStudentDetails;
    private javax.swing.JTable tblSummary;
    // End of variables declaration//GEN-END:variables
}

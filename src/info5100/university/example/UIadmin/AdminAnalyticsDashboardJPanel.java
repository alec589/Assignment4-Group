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

        if (jComboBox1.getItemCount() > 0) {
            jComboBox1.setSelectedIndex(0); 
        } else {
            // 如果没有学期，也运行一次以显示0
            refreshAllData();
        }
    }

    
    private void refreshAllData() {
        String selectedSemester = (String) jComboBox1.getSelectedItem();
     
        populateSummaryMetrics(selectedSemester); 

        populateRoleTable(); 
    
        populateCourseEnrollmentTable(selectedSemester); 
    }
    
    private void populateSemesterCombo() {
        jComboBox1.removeAllItems(); // clean
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


        int totalCoursesOfferedThisSemester = 0;
        if (semester != null) {
            CourseSchedule schedule = department.getCalendar().getCourseSchedule(semester);
            if (schedule != null) {
                totalCoursesOfferedThisSemester = schedule.getSchedule().size();
            }
        }
       
        
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
    
        lblTotalUsersValue.setText(String.valueOf(totalStudents + totalFaculty + totalRegistrar + totalAdmin));
        lblTotalCoursesValue.setText(String.valueOf(totalCoursesOfferedThisSemester)); 
        lblTotalStudentsValue.setText(String.valueOf(totalEnrolledStudents)); 
        lblTuitionRevenueValue.setText("$" + String.format("%,.2f", totalTuitionRevenue));
        
        System.out.println("Metrics refreshed successfully!");
        System.out.println("Total Tuition Revenue = $" + String.format("%,.2f", totalTuitionRevenue));
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

        // full the form
        model.addRow(new Object[]{"Student", totalStudents, totalEnrolledStudents, totalStudents - totalEnrolledStudents}); // "Active" 列会显示 "5"
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
        lblTotalCourses = new javax.swing.JLabel();
        lblTotalStudents = new javax.swing.JLabel();
        lblTuitionRevenue = new javax.swing.JLabel();
        lblTotalUsersValue = new javax.swing.JLabel();
        lblTotalCoursesValue = new javax.swing.JLabel();
        lblTotalStudentsValue = new javax.swing.JLabel();
        lblTuitionRevenueValue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSummary = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblSelectSemester = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblCourseEnrollmentTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCourseEnrollment = new javax.swing.JTable();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        lblTitle.setText("University Analytics Dashboard");

        lblTotalUsers.setText("Total Active Users");

        lblTotalCourses.setText("Total Courses Offered");

        lblTotalStudents.setText("Total Enrolled Students");

        lblTuitionRevenue.setText("Total Tuition Revenue");

        lblTotalUsersValue.setText("0");

        lblTotalCoursesValue.setText("0");

        lblTotalStudentsValue.setText("0");

        lblTuitionRevenueValue.setText("$0");

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
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotalUsers)
                            .addComponent(lblTotalCourses)
                            .addComponent(lblTotalStudents)
                            .addComponent(lblTuitionRevenue)
                            .addComponent(lblSelectSemester))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTuitionRevenueValue, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTotalUsersValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotalCoursesValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTotalStudentsValue, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                        .addGap(3, 3, 3))))
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
                                .addComponent(jScrollPane1)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalCourses)
                    .addComponent(lblTotalCoursesValue))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalStudents)
                    .addComponent(lblTotalStudentsValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTuitionRevenueValue)
                    .addComponent(lblTuitionRevenue))
                .addGap(82, 82, 82)
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
        refreshAllData();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCourseEnrollmentTitle;
    private javax.swing.JLabel lblSelectSemester;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalCourses;
    private javax.swing.JLabel lblTotalCoursesValue;
    private javax.swing.JLabel lblTotalStudents;
    private javax.swing.JLabel lblTotalStudentsValue;
    private javax.swing.JLabel lblTotalUsers;
    private javax.swing.JLabel lblTotalUsersValue;
    private javax.swing.JLabel lblTuitionRevenue;
    private javax.swing.JLabel lblTuitionRevenueValue;
    private javax.swing.JTable tblCourseEnrollment;
    private javax.swing.JTable tblSummary;
    // End of variables declaration//GEN-END:variables
}

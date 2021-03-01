package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lms.LMSException;
import lms.LMSGetAnswerBase;
import lms.LMSGetAnswerBaseValue;
import lms.LMSGetCourse;
import lms.LMSGetQuiz;
import lms.LMSLogin;
import lms.LMSUtil;
import lms.pool.LMSPoolGetAnswerBaseValue;
import model.Account;
import model.AnswerBase;
import model.Course;
import model.Quiz;
import model.Server;
import model.ServerName;
import util.MsgBox;
import util.OS;
import util.PoolExec;
import util.Util;

/**
 * @author ThienDepZaii - SystemError
 * @Facebook /ThienDz.SystemError
 * @Gmail ThienDz.DEV@gmail.com
 */
public class FormMain extends javax.swing.JFrame {

    public FormMain() {
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbSlogan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfCookie = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        cbbServer = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnSolution = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbRole = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbHello = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tfRefIdCourse = new javax.swing.JTextField();
        btnGetQuiz = new javax.swing.JButton();
        cbbQuiz = new javax.swing.JComboBox<>();
        btnView = new javax.swing.JButton();
        lbProcess = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbInfo = new javax.swing.JLabel();
        btnContact = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FPL@utoLMS V1.0.0  - 10 Quiz 10 Điểm Easy!");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTitle.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(0, 204, 204));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("FPL@utoLMS");

        lbSlogan.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lbSlogan.setForeground(new java.awt.Color(0, 51, 255));
        lbSlogan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlogan.setText("Version v0.0.0.0 - 10 Quiz 10 Point Easy!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSlogan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbSlogan)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbTitle)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login with cookie:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 11))); // NOI18N

        tfCookie.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        btnLogin.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        cbbServer.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        cbbServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HaNoi", "HoChiMinh", "DaNang", "CanTho", "TayNguyen" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCookie, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbServer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCookie, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbServer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLogin, tfCookie});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solution:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 11))); // NOI18N

        btnSolution.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnSolution.setText("Auto Solution Coming soon");
        btnSolution.setEnabled(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbRole.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lbRole.setText("Role: ...............");

        lbGender.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lbGender.setText("Gender: .............");

        lbEmail.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lbEmail.setText("Email: ..............");

        lbHello.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lbHello.setText("Hello:...............");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHello, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbEmail, lbGender, lbHello, lbRole});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHello, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfRefIdCourse.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tfRefIdCourse.setEnabled(false);

        btnGetQuiz.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnGetQuiz.setText("Get Quiz");
        btnGetQuiz.setEnabled(false);
        btnGetQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetQuizActionPerformed(evt);
            }
        });

        cbbQuiz.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        cbbQuiz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Quiz....", " " }));
        cbbQuiz.setEnabled(false);

        btnView.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnView.setText("View Best Solution");
        btnView.setEnabled(false);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbQuiz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(tfRefIdCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGetQuiz))
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRefIdCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetQuiz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnView, cbbQuiz});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGetQuiz, tfRefIdCourse});

        lbProcess.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lbProcess.setForeground(new java.awt.Color(0, 153, 0));
        lbProcess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProcess.setText("Thiên Đẹp Traii is the best!\n");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProcess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSolution)
                .addGap(112, 112, 112))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lbProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSolution, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 11))); // NOI18N

        lbInfo.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lbInfo.setForeground(new java.awt.Color(255, 0, 0));
        lbInfo.setText("AutoCMS - Code By ThienDepZaii - SystemError");

        btnContact.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnContact.setText("Contact Me");
        btnContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnContact)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbInfo)
                    .addComponent(btnContact))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactActionPerformed
        onclickContact();
    }//GEN-LAST:event_btnContactActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        onclickLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        onclickViewBestSolution();
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnGetQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetQuizActionPerformed
        onclickGetQuiz();
    }//GEN-LAST:event_btnGetQuizActionPerformed

    private void onclickViewBestSolution() {
        if (!checkComboBoxQuiz()) {
            return;
        }
        new Thread(() -> {
            setEnbledAll(false);
            int quizId = cbbQuiz.getSelectedIndex() - 1;
            if (Main.course.getQuizs()[quizId].getAnswerBases() == null) {
                setProcess("Get ansewerbase ...");
                AnswerBase[] answerBases;
                try {
                    answerBases = LMSGetAnswerBase.parse(Main.account, Main.course.getQuizs()[quizId]);
                } catch (LMSException ex) {
                    setProcess("ThienDepZaii is the best.");
                    tfCookie.setEnabled(true);
                    cbbServer.setEnabled(true);
                    btnLogin.setEnabled(true);
                    tfRefIdCourse.setEnabled(true);
                    btnGetQuiz.setEnabled(true);
                    cbbQuiz.setEnabled(true);
                    btnView.setEnabled(true);
                    MsgBox.alert(this, "Không thể get danh sách đáp án {1} !");
                    return;
                }
                int i = 0;
                setProcess("Get ansewerbase value....");
                answerBases = poolExecAnswerbaseValue(Main.account, Main.course.getQuizs()[quizId], answerBases);
                Main.course.getQuizs()[quizId].setAnswerBases(answerBases);
            }
            setEnbledAll(true);
            if (Main.formShow == null) {
                Main.formShow = new FormShow();
            }
            Main.formShow.setQuiz(Main.course.getQuizs()[quizId]);
            Main.formShow.updateComponent();
            Main.formShow.setVisible(true);
            setVisible(false);
            setProcess("ThienDepZaii is the best.");
        }).start();
    }

    private void onclickGetQuiz() {
        if (!checkFormGetQuiz()) {
            return;
        }
        new Thread(() -> {
            setEnbledAll(false);
            int refIdCourse = -1;
            try {
                refIdCourse = Integer.parseInt(tfRefIdCourse.getText().trim());
            } catch (NumberFormatException e) {
                refIdCourse = LMSUtil.parseRefId(tfRefIdCourse.getText().trim());
            }
            Course course = LMSGetCourse.parse(Main.account, refIdCourse);
            setProcess("Get list quiz ...");
            Quiz[] quizs;
            try {
                quizs = LMSGetQuiz.parse(Main.account, course);
            } catch (LMSException ex) {
                setProcess("ThienDepZaii is the best.");
                tfCookie.setEnabled(true);
                cbbServer.setEnabled(true);
                btnLogin.setEnabled(true);
                tfRefIdCourse.setEnabled(true);
                btnGetQuiz.setEnabled(true);
                MsgBox.alertErr(this, "Không thể tải danh sách quiz!");
                return;
            }
            tfCookie.setEnabled(true);
            cbbServer.setEnabled(true);
            btnLogin.setEnabled(true);
            tfRefIdCourse.setEnabled(true);
            btnGetQuiz.setEnabled(true);
            cbbQuiz.setEnabled(true);
            btnView.setEnabled(true);
            course.setQuizs(quizs);
            Main.course = course;
            cbbQuiz.removeAllItems();
            cbbQuiz.addItem("Select quiz...");
            for (Quiz quiz : quizs) {
                cbbQuiz.addItem(quiz.getName());
            }
            setProcess("Get list quiz done.");
        }).start();
    }

    private void onclickLogin() {
        if (!checkFormLogin()) {
            return;
        }
        new Thread(() -> {
            Server server = new Server(parseServerName());
            String cookie = tfCookie.getText().trim();
            setEnbledAll(false);
            setProcess("Login...");
            try {
                Main.account = LMSLogin.parse(server, cookie);
            } catch (LMSException e) {
                setProcess("ThienDepZaii is the best.");
                tfCookie.setEnabled(true);
                cbbServer.setEnabled(true);
                btnLogin.setEnabled(true);
                MsgBox.alertWar(this, "Đăng nhập thất bại!");
                return;
            }
            tfCookie.setEnabled(true);
            cbbServer.setEnabled(true);
            btnLogin.setEnabled(true);
            tfRefIdCourse.setEnabled(true);
            btnGetQuiz.setEnabled(true);
            lbHello.setText("Hello: " + Main.account.getName());
            lbEmail.setText("ID: " + Main.account.getId());
            lbGender.setText("Gender: " + Main.account.getSex());
            lbRole.setText("Role: " + Main.account.getRole());
            setProcess("Login success!");
        }).start();
    }

    private void onclickContact() {
        OS.openTabBrowser(Main.APP_CONTACT);
    }

    private void setEnbledAll(boolean enb) {
        tfCookie.setEnabled(enb);
        cbbServer.setEnabled(enb);
        btnLogin.setEnabled(enb);
        tfRefIdCourse.setEnabled(enb);
        btnGetQuiz.setEnabled(enb);
        cbbQuiz.setEnabled(enb);
        btnView.setEnabled(enb);
    }

    private boolean checkFormLogin() {
        if (tfCookie.getText().trim().equals("")) {
            MsgBox.alertWar(this, "Cookie không được để trống!");
            return false;
        }
        return true;
    }
    
    private static AnswerBase[] poolExecAnswerbaseValue(Account account, Quiz quiz, AnswerBase[] answerBases){
        LMSPoolGetAnswerBaseValue[] lMSPoolGetAnswerBaseValues = new LMSPoolGetAnswerBaseValue[answerBases.length];
        for(int i=0; i<answerBases.length; i++){
            lMSPoolGetAnswerBaseValues[i] = new LMSPoolGetAnswerBaseValue(account, quiz, answerBases[i]);
        }
        PoolExec polExec = new PoolExec(lMSPoolGetAnswerBaseValues);
        polExec.execute();
        while(polExec.isTerminating()){
            Util.sleep(1000);
        }
        List<AnswerBase> alAnswerbase = new ArrayList<>();
        for (LMSPoolGetAnswerBaseValue lMSPoolGetAnswerBaseValue : lMSPoolGetAnswerBaseValues) {
            alAnswerbase.add(lMSPoolGetAnswerBaseValue.getAnswerBase());
        }
        Collections.sort(alAnswerbase);
        for(int i=0; i<alAnswerbase.size(); i++){
            answerBases[i] = alAnswerbase.get(i);
        }
        return answerBases;
    }
    
    private boolean checkFormGetQuiz() {
        try {
            Integer.parseInt(tfRefIdCourse.getText().trim());
        } catch (NumberFormatException e) {
            int id = LMSUtil.parseRefId(tfRefIdCourse.getText().trim());
            if (id == -1) {
                MsgBox.alertWar(this, "RefId không hợp lệ!");
                return false;
            }
        }
        return true;
    }

    private boolean checkComboBoxQuiz() {
        if (cbbQuiz.getSelectedIndex() == 0) {
            MsgBox.alert(this, "Bạn phải chọn 1 quiz!");
            return false;
        }
        return true;
    }

    private ServerName parseServerName() {
        String name = cbbServer.getSelectedItem().toString();
        switch (name) {
            case "HaNoi":
                return ServerName.HaNoi;
            case "HoChiMinh":
                return ServerName.HoChiMinh;
            case "DaNang":
                return ServerName.DaNang;
            case "CanTho":
                return ServerName.CanTho;
            case "TayNguyen":
                return ServerName.TayNguyen;
        }
        return null;
    }

    private void setProcess(String text) {
        lbProcess.setText(text);
    }

    private void init() {
        setTitle(Main.APP_NAME + " v" + Main.APP_VER + " - " + Main.APP_SLOGAN);
        lbTitle.setText(Main.APP_NAME);
        lbSlogan.setText("Version " + Main.APP_VER + " - " + Main.APP_SLOGAN);
        lbInfo.setText(Main.APP_NAME + " - Code By " + Main.APP_AUTHOR + " - " + Main.APP_NICKNAME);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnContact;
    private javax.swing.JButton btnGetQuiz;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSolution;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cbbQuiz;
    private javax.swing.JComboBox<String> cbbServer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbHello;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbProcess;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbSlogan;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextField tfCookie;
    private javax.swing.JTextField tfRefIdCourse;
    // End of variables declaration//GEN-END:variables

}

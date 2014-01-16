/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OtherClases;

/**
 *
 * @author sylar
 */
public class ThesisView {
    
    private String idThesis;
    private String thesisTitle;
    private String thesisSubject;
    private String thesisStatus;
    private String idUser;
    private String userType;
    private String firstName;
    private String lastName;
    private String rut;
    private String idRole;
    private String roleName;

    public ThesisView(String idThesis, String thesisTitle, String thesisSubject, String thesisStatus, String idUser, String idUserType, String firstName, String lastName, String rut, String idRole, String roleName) {
        this.idThesis = idThesis;
        this.thesisTitle = thesisTitle;
        this.thesisSubject = thesisSubject;
        this.thesisStatus = thesisStatus;
        this.idUser = idUser;
        this.userType = idUserType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rut = rut;
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public String getIdThesis() {
        return idThesis;
    }

    public void setIdThesis(String idThesis) {
        this.idThesis = idThesis;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getThesisSubject() {
        return thesisSubject;
    }

    public void setThesisSubject(String thesisSubject) {
        this.thesisSubject = thesisSubject;
    }

    public String getThesisStatus() {
        return thesisStatus;
    }

    public void setThesisStatus(String thesisStatus) {
        this.thesisStatus = thesisStatus;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String idUserType) {
        this.userType = idUserType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}

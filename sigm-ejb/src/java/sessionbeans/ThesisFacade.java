/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import OtherClases.ThesisView;
import entities.Thesis;
import entities.ThesisParticipation;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author mario
 */
@Stateless
public class ThesisFacade extends AbstractFacade<Thesis> implements ThesisFacadeLocal {
    @PersistenceContext(unitName = "sigm-ejbPU")
    private EntityManager em;

    @EJB
    ThesisParticipationFacadeLocal thesisParticipationLocal; 
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ThesisFacade() {
        super(Thesis.class);
    }
    
    @Override
    public void generarExcelParticipacionTesis() throws Exception {

        try {
            //Se traen todas las participaciones. 
            List<ThesisParticipation> tps = thesisParticipationLocal.findAll();
            if (tps.isEmpty()) {
                System.out.println("Lista de Participantes de tesis, vacia.");
            }
            //Se genera la lista de estructura a mostrar.
            List<ThesisView> tv = null;
            
            for (int i = 0; i < tps.size(); i++) {
                tv.add(new ThesisView(                        
                        tps.get(i).getIdThesis().getIdThesis().toString(), 
                        tps.get(i).getIdThesis().getThesisTitle(), 
                        tps.get(i).getIdThesis().getThesisSubject(), 
                        tps.get(i).getIdThesis().getThesisStatus(),
                        tps.get(i).getIdUser().getIdUser().toString(),
                        tps.get(i).getIdUser().getIdUserType().getUserTypeName(),
                        tps.get(i).getIdUser().getFirstName(),
                        tps.get(i).getIdUser().getLastName(),
                        tps.get(i).getIdUser().getRut(),
                        tps.get(i).getIdRole().getIdRole().toString(),
                        tps.get(i).getIdRole().getRoleName()));
            }
            
            Integer count = 1;
            HSSFWorkbook libroReporte = new HSSFWorkbook();
            HSSFSheet hojaReporte = libroReporte.createSheet();
            HSSFCellStyle style = libroReporte.createCellStyle();

            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            HSSFRow cfilaReporteCabecera = hojaReporte.createRow(0);
            HSSFCell IdThesis = cfilaReporteCabecera.createCell(0);
            HSSFCell ThesisTitle = cfilaReporteCabecera.createCell(1);
            HSSFCell ThesisSubject = cfilaReporteCabecera.createCell(2);
            HSSFCell ThesisStatus = cfilaReporteCabecera.createCell(3);
            HSSFCell IdUser = cfilaReporteCabecera.createCell(4);
            HSSFCell UserType = cfilaReporteCabecera.createCell(5);
            HSSFCell FirstName = cfilaReporteCabecera.createCell(6);
            HSSFCell LastName = cfilaReporteCabecera.createCell(7);
            HSSFCell Rut = cfilaReporteCabecera.createCell(8);
            HSSFCell IdRole = cfilaReporteCabecera.createCell(9);
            HSSFCell RoleName = cfilaReporteCabecera.createCell(10);

            IdThesis.setCellValue("N° TESIS");
            ThesisTitle.setCellValue("TITULO TESIS");
            ThesisSubject.setCellValue("MATERIA TESIS");
            ThesisStatus.setCellValue("ESTADO TESIS");
            IdUser.setCellValue("N° USUARIO");
            UserType.setCellValue("TIPO USUARIO");
            FirstName.setCellValue("NOMBRES USUARIO");
            LastName.setCellValue("APELLIDOS USUARIO");
            Rut.setCellValue("RUT USUARIO");
            IdRole.setCellValue("N° ROL");
            RoleName.setCellValue("ROL USUARIO");
            
            
            for (ThesisView v : tv) {
                
                HSSFRow filaReporteCabecera = hojaReporte.createRow(0);
                HSSFCell cIdThesis = cfilaReporteCabecera.createCell(0);
                HSSFCell cThesisTitle = cfilaReporteCabecera.createCell(1);
                HSSFCell cThesisSubject = cfilaReporteCabecera.createCell(2);
                HSSFCell cThesisStatus = cfilaReporteCabecera.createCell(3);
                HSSFCell cIdUser = cfilaReporteCabecera.createCell(4);
                HSSFCell cUserType = cfilaReporteCabecera.createCell(5);
                HSSFCell cFirstName = cfilaReporteCabecera.createCell(6);
                HSSFCell cLastName = cfilaReporteCabecera.createCell(7);
                HSSFCell cRut = cfilaReporteCabecera.createCell(8);
                HSSFCell cIdRole = cfilaReporteCabecera.createCell(9);
                HSSFCell cRoleName = cfilaReporteCabecera.createCell(10);
                
                cIdThesis.setCellValue(v.getIdThesis());
                cThesisTitle.setCellValue(v.getThesisTitle());
                cThesisSubject.setCellValue(v.getThesisSubject());
                cThesisStatus.setCellValue(v.getThesisStatus());
                cIdUser.setCellValue(v.getIdUser());
                cUserType.setCellValue(v.getUserType());
                cFirstName.setCellValue(v.getFirstName());
                cLastName.setCellValue(v.getLastName());
                cRut.setCellValue(v.getRut());
                cIdRole.setCellValue(v.getIdRole());
                cRoleName.setCellValue(v.getRoleName());
                count++;
                
            }

            for (Integer i = 0; i <= 7; i++) {
                hojaReporte.autoSizeColumn(i);
            }

            try {

                String path = System.getProperty("java.home");
                System.out.println(path);
                path = path + File.separator + "reportes_sigm" + File.separator;
                File carpetaUploads = new File(path);
                if (carpetaUploads.mkdir()) {
                    System.out.println("Creado el directorio para almacenar los uploads en: " + path);
                }

                String url = path + "TesisParticipacion" + Calendar.getInstance().getTimeInMillis() + ".xls";
                FileOutputStream archivo = new FileOutputStream(url);

                libroReporte.write(archivo);
                archivo.close();

            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
   
}

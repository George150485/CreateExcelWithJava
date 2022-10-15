package control;

import model.AccessModifier;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {

    public static ByteArrayInputStream mapRows(List<AccessModifier> accessModifiers) throws IOException {
        String[] columns = {"Modifier", "Class", "Subclass", "Package", "World"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ) {
            Sheet sheet = workbook.createSheet("Modifiers");
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }
            int index = 1;
            for (AccessModifier accModifier : accessModifiers) {
                Row row = sheet.createRow(index++);
                row.getCell(0).setCellValue(accModifier.getId());
                row.getCell(1).setCellValue(accModifier.getModifier());
                row.getCell(2).setCellValue(accModifier.getCclass());
                row.getCell(3).setCellValue(accModifier.getSubclass());
                row.getCell(4).setCellValue(accModifier.getPpackage());
                row.getCell(5).setCellValue(accModifier.getWorld());
            }
            workbook.write(byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }

    }

}

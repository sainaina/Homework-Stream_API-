package ManagementSys.service;

import ManagementSys.model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Arrays;
import java.util.List;

public class CourseTable {
    public static void table(List<Course> courseList){
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        String [] columnNames = new String[]{"ID","TITLE","INSTRUCTOR","REQUIREMENT","START DATE"};
        for(String column:  columnNames){
            table.addCell(column,new CellStyle(CellStyle.HorizontalAlign.CENTER));
        }

        for (int i=0;i<5;i++){
            table.setColumnWidth(i,25,35);
        }

        courseList.forEach(e->{
            table.addCell(String.valueOf(e.getId()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(e.getTitle(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(Arrays.toString(e.getInstructorNames()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(Arrays.toString(e.getRequirements()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(e.getStartDate().toString(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
        });
        System.out.println(table.render());
    }
}

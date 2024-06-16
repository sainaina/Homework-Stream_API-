package ManagementSys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;
    private String title;
    private String[] instructorNames; // Renamed from getInstructorName
    private String[] requirements; // Renamed from getRequirements
    private LocalDate startDate;
}
package sorting_algorithm.class_problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeLookup {

    public static class Record {
        public String employeeId;
        public String department;

        public Record(String employeeId, String department) {
            this.employeeId = employeeId;
            this.department = department;
        }
    }

    public static Map<String, String> buildLookup(List<Record> records) {
        Map<String, String> lookupMap = new HashMap<>();
        if (records == null) {
            return lookupMap;
        }
        for (Record record : records) {
            lookupMap.put(record.employeeId, record.department);
        }
        return lookupMap;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        if (lookup == null || !lookup.containsKey(employeeId)) {
            return "Unknown";
        }
        return lookup.get(employeeId);
    }

    public static void main(String[] args) {
        List<Record> records = List.of(
            new Record("E245", "Finance"),
            new Record("E110", "Engineering"),
            new Record("E390", "Marketing"),
            new Record("E101", "Engineering")
        );

        Map<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MatrixTraversal {

    /*static String find_path(List<List<String>> matrix, String target_string) {


    }*/

    public static void main(String[] args) {
        List<List<String>> matrix = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("a");
        row1.add("b");
        row1.add("j");
        row1.add("d");

        List<String> row2 = new ArrayList<>();
        row2.add("n");
        row2.add("j");
        row2.add("k");
        row2.add("m");

        List<String> row3 = new ArrayList<>();
        row3.add("e");
        row3.add("f");
        row3.add("q");
        row3.add("z");


        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        System.out.println(transverse(matrix, "abjfqz", 1, 0, 0));
    }

    static String transverse(List<List<String>> matrix, String target_string, int index, int r, int c) {

        if (r < matrix.size() && c < matrix.get(0).size()) {
            List<String> row = matrix.get(r);
            if (c < row.size() - 1) {
                if (row.get(c + 1).charAt(0) == target_string.charAt(index)) {
                    if (index == target_string.length() - 1) {
                        return "R";
                    }
                    String route = transverse(matrix, target_string, index + 1, r, c + 1);
                    if (route != null) {
                        return "R" + route;
                    }
                }
            }

            if (r < matrix.size() - 1) {
                List<String> nextRow = matrix.get(r + 1);
                if (nextRow.get(c).charAt(0) == target_string.charAt(index)) {
                    String route = transverse(matrix, target_string, index + 1, r + 1, c);
                    if (index == target_string.length() - 1) {
                        return "D";
                    }
                    if (route != null) {
                        return "D" + route;
                    }
                }
            }
        }

        return null;
    }


}

package day04.BTreeEx;

import java.util.ArrayList;
import java.util.List;

public class BTreePrinter
{
    public interface PrintableNode {
        PrintableNode getLeft();

        PrintableNode getMiddle(); // Added for 3rd child

        PrintableNode getRight();

        String getText();
    }

    public static void print(PrintableNode root) {
        List<List<String>> lines = new ArrayList<>();
        List<PrintableNode> level = new ArrayList<>();
        List<PrintableNode> next = new ArrayList<>();
        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;

            for (PrintableNode n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                    next.add(null); // Added for 3rd child
                } else {
                    String aa = n.getText();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();
                    next.add(n.getLeft());
                    next.add(n.getMiddle()); // Added for 3rd child
                    next.add(n.getRight());
                    if (n.getLeft() != null) nn++;
                    if (n.getMiddle() != null) nn++; // Added for 3rd child
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 3 == 1) widest++;

            lines.add(line);

            List<PrintableNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    char c = ' ';
                    if (j % 3 == 1) { // Changed from 2 to 3 for 3rd child
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            //System.out.print("0");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            if(j % 3 == 0) {
                                System.out.print(" ");

                            } else if(j % 3 == 1) {
                                System.out.print(" ");

                            } else if(j % 3 == 2) {
                                System.out.print("─");
                            }
                        }

                        if(j % 3 == 0) {
                            System.out.print("┌");

                        } else if(j % 3 == 1) {
                            System.out.print("|");

                        } else if(j % 3 == 2) {
                            System.out.print("┐");
                        }

                        for (int k = 0; k < hpw; k++) {
                            if(j % 3 == 0) {
                                System.out.print("─");

                            } else if(j % 3 == 1) {
                                System.out.print(" ");

                            } else if(j % 3 == 2) {
                                System.out.print(" ");
                            }
                        }
                    }
                }
                System.out.println();
            }

            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 3f - f.length() / 3f);
                int gap2 = (int) Math.floor(perpiece / 3f - f.length() / 3f);
                int gap3 = (int) Math.floor(perpiece / 3f - f.length() / 3f);

                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }

                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }

            }
            System.out.println();

            perpiece /= 2;
        }
    }
}
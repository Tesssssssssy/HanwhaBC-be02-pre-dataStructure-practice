package day05.AstarMyVer;

public class AstarMain {
    public static void main(String[] args) {
        Integer[][] map = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,3,0,0,0},
                {0,0,0,0,1,0,3,0,2,0},
                {0,0,0,0,0,0,3,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };

        Astar astar = new Astar(map);

        for (int i = 0; i < astar.openList.size(); i++) {
            System.out.println(astar.openList.get(i).x +", " + astar.openList.get(i).y);
        }

        astar.addAdjacentNodes(astar.start);
        System.out.println();

        for (int i = 0; i < astar.openList.size(); i++) {
            System.out.println(astar.openList.get(i).x +", " + astar.openList.get(i).y);
        }

        astar.findPath();
    }
}

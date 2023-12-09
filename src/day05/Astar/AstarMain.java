package day05.Astar;

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

        for (int i = 0; i < astar.openNodes.size(); i++) {
            System.out.println(astar.openNodes.get(i).x +", " + astar.openNodes.get(i).y);
        }

        astar.addAdjacentNodes(astar.start);
        System.out.println();

        for (int i = 0; i < astar.openNodes.size(); i++) {
            System.out.println(astar.openNodes.get(i).x +", " + astar.openNodes.get(i).y);
        }

        astar.findPath();
    }
}

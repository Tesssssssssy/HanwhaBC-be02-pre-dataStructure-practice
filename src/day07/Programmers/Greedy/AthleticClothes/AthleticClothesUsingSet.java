package day07.Programmers.Greedy.AthleticClothes;

import java.util.HashSet;
import java.util.Set;

public class AthleticClothesUsingSet {
    public int solution(int n, int[] lost, int[] reserve) {
        // Set을 사용하여 중복을 허용하지 않는 lostSet과 reserveSet을 선언
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        // 여벌 가져온 사람
        for (int i : reserve) {
            reserveSet.add(i);
        }

        // 체육복을 잃어버린 사람들에 대해 처리
        for (int i : lost) {
            // 여벌 가져온 사람이 잃어버린 경우
            if (reserveSet.contains(i)) {
                // reserveSet에서 제거
                reserveSet.remove(i);
            } else {
                // 잃어버리기만 한 경우 lostSet에 추가
                lostSet.add(i);
            }
        }

        // 잃어버린 사람에게 빌려줄 수 있는 경우
        for (Integer i : reserveSet) {
            // 앞 번호 학생에게 줄 수 있는 경우
            if (lostSet.contains(i - 1)) {
                lostSet.remove(i - 1);
                // 뒷 번호 학생에게 줄 수 있는 경우
            } else if (lostSet.contains(i + 1)) {
                lostSet.remove(i + 1);
            }
        }

        return n - lostSet.size();
    }
}


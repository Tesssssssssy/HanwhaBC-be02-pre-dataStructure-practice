package day07.Programmers.Greedy.AthleticClothes;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 *
 * 순차적으로 배열을 비교할 수 있게 정렬.
 * 여벌 체육복을 가져온 학생이 도난당한 경우, 체육복을 빌려줄 수 없기 때문에 reserve 배열에서 제외.
 * reserve[j]의 값을 -1로 변경
 * lost[i] 의 값도 -1로 변경해 도난당한 대상에서 제외
 * .
 * 여벌 체육복을 가져온 학생이 자기 번호의 앞,뒤 학생에게 체육복을 빌려준다.
 * lost[i]-1 == reserve[j] 또는 lost[i]+1 == reserve[j]
 * 혹은
 * lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1
 *  -> reserve[j]의 값을 -1로 변경
 *
 * lost[] 와 reserve[] 배열의 요소값을 0 이 아닌 -1로 변경해주는 이유는
 * 0으로 변경했을 경우 lost[i]+1 의 값이 1 이 되므로 if문을 타게 될 가능성이 있다.
 *
 * 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정,
 * 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없다.
 */

public class AthleticClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        /*
            answer = 체육수업을 들을 수 있는 학생의 최댓값
            체육수업을 들을 수 있는 학생의 최댓값 = 전체 학생 수 - 체육복을 도난당한 학생의 수
            준비하지 않은 학생들의 수가 빠진 것.
            그리고 나중에 체육복을 빌려주면 answer를 증가시켜준다.
        */

        Arrays.sort(lost);
        Arrays.sort(reserve);
        /*
            순차적으로 배열을 비교할 수 있게 정렬

            lost = {2. 4} or {2, 4, 5}
            reserve = {3, 1} 일 때

            답이 4가 맞는데 3으로 잘못 출력되어
            에러 발생하기 때문에 미리 정렬을 시켜주고 greedy 알고리즘 적용해야 함.

            2 -> 3, 1 => 3이 2한테 빌려주면 answer = 2 + 1 = 3이 되고
            lost = {4, 5}
            reserve = {1}가 되어 더 이상 빌려줄 수 없으므로 최종 3이 된다.

            하지만 lost, reserve 모두 정렬을 해주고 나면

            2 -> 1, 3  => 2 + 1 = 3
            4 -> 3     => 3 + 1 = 4

            정상적으로 올바른 최대 인원이 출력되게 된다.

            따라서 lost, reserve 모두 정렬이 되어 있는 경우가 있을 수 있기 때문에
            둘 다 정렬을 시켜주고 greedy search를 해야 한다.
        */

        /*
            여벌 체육복을 가져온 학생이 도난당한 경우 (reserve -> lost가 되는 경우)\

            체육복 다른 사람에 빌려줄 수 없으며
            answer에 해당 case만큼 추가한다
            더 가져온 내가 잃은 나에게 빌려준다.
        */
        for(int i = 0; i < lost.length; i++){
            // 준비하지 않은 학생들의 수만큼 반복
            for(int j = 0; j < reserve.length; j++){
                // 준비한 학생들의 수만큼 반복

                if(lost[i] == reserve[j]){
                    answer++;
                    /*
                        answer = 체육수업을 들을 수 있는 학생의 최댓값
                        체육수업을 들을 수 있는 학생의 최댓값 = 전체 학생 수 - 체육복을 도난당한 학생의 수 이므로

                        체육복을 준비한 reserve가 lost가 되었으니까 도난당한 학생이 되었음
                        즉 reserve가 lost가 된 것.

                        하지만 나는 원래 reserve였고 내가 체육복을 잃어버린 나에게 빌려준다는 개념이므로
                        참여할 수 있는 인원이 증가한 셈.
                        answer++
                    */
                    lost[i] = -1;
                    reserve[j] = -1;
                    /*
                        도난 당했으므로 전혀 상관 없는 값인 -1로 if문을 돌지 않게 값 변경
                        배열이니까 데이터 삭제가 되지 않으므로 -1로 값 변경
                    */
                    break;
                    // 찾았으면 굳이 더 볼 필요 없고 다른 준비하지 않은 학생 확인
                }
            }
        }

        // 도난당한 학생에게 체육복 빌려주는 경우 (reserve -> lost에게 빌려주는 경우)
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if((lost[i] == reserve[j] - 1) || (lost[i] == reserve[j] + 1)){
                    /*
                        바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있으므로
                        reserve의 바로 앞 번호와 뒷 번호의 학생에게 빌려주면

                        answer = 체육수업을 들을 수 있는 학생의 최댓값
                        체육수업을 들을 수 있는 학생의 최댓값 = 전체 학생 수 - 체육복을 도난당한 학생의 수 이므로

                        체육 수업들 들을 수 있는 학생의 수가 증가한다.
                        따라서 answer++
                    */
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
/*
    n	lost	  reserve	    return
    5	[2, 4]	  [1, 3, 5]	     5
    5	[2, 4]	  [3]	         4
    3	[3]	      [1]	         2
*/
}

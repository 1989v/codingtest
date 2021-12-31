package kr.got.codingtest.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 참가자, 완수자명이 담긴 2개의 배열에서 참가자 중 완수하지 못한 1명을 구하시오.
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 */
public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completions = {"stanko", "ana", "mislav"};

        String solutionWithHashMapResult = solutionWithHashMap(participants, completions);
        String solutionWithArraySortingResult = solutionWithArraySorting(participants, completions);

        System.out.println(solutionWithHashMapResult);
        System.out.println(solutionWithArraySortingResult);
    }

    /**
     * HashMap을 통한 해결
     */
    public static String solutionWithHashMap(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        //  참가자 이름별 인원수(동명이인 고려하여 이름별 인원) 집계
        for (String p : participant) {
            participantMap.put(p, participantMap.get(p) != null ? participantMap.get(p) + 1 : 1);
        }

        // 완수자 이름만큼 참가자 HashMap에서 차감
        for (String c : completion) {
            participantMap.put(c, participantMap.get(c) - 1);
        }

        // 참가자 HashMap에서 남아있는 한명 추출
        return participantMap.keySet().stream()
                .filter(key -> participantMap.get(key) > 0)
                .findFirst()
                .orElse("");
    }

    /**
     * Array의 sort를 통한 해결
     */
    public static String solutionWithArraySorting(String[] participant, String[] completion) {
        // 참가자, 완수자 배열을 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for (i = 0; i < completion.length; i++) {
            // 동일한 인덱스에 참가자,완수자 배열 요소가 다를경우를 찾음
            if (!participant[i].equals(completion[i])) {
                break;
            }
        }
        return participant[i];
    }
}

/**
 * 완주하지 못한 선수
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 	• 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * 	• completion의 길이는 participant의 길이보다 1 작습니다.
 * 	• 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 	• 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 * 입출력 예
 * participant	completion	return
 * ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
 * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
 * ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 *
 * 입출력 예 설명
 * 예제 #1
 * "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 * 예제 #2
 * "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 * 예제 #3
 * "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
 */
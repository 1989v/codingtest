package kr.got.codingtest.stack;

import java.util.Stack;

/**
 * 주어진 괄호 문자열이 적절하게 중첩되었는지 확인하여 맞으면 1, 아니면 0을 반환
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * <p>
 * 괄호({}, (), [])로 구성된 N개의 문자로 구성된 문자열 S가 주어질 때
 * 문자열 S의 괄호 문자가 올바르게 중첩된 경우 1 아니면 0 반환
 * <p>
 * String S = "{[()()]}"; -> return 1;
 * String S = "([)()]"; -> return 0;
 * <p>
 * 제약사항:
 * - N은 0~200,000 범위내의 정수
 * - 문자열 S는 (, {, [, ], }, )로 구성된 문자열
 */
public class Brackets {
    public static void main(String[] args) {
        int result = solution("{[()()]}");
        int result2 = solution("{[)()]}");

        System.out.println(result);
        System.out.println(result2);
    }

    /**
     * 아이디어:
     * 인덱스 요소가 여는 괄호일떄 stack에 push하고,
     * 닫는 괄호일때는 기존 stack에서 pop하여 꺼낸 후 괄호가 쌍으로 일치하는지 비교.
     */
    public static int solution(String value) {
        int result = 1;
        Stack<Character> stack = new Stack<>();

        for (Character c : value.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || '(' != stack.pop()) {
                        result = 0;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || '{' != stack.pop()) {
                        result = 0;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || '[' != stack.pop()) {
                        result = 0;
                    }
                    break;
            }

            if (result == 0) {
                break;
            }
        }

        if (!stack.isEmpty()) {
            result = 0;
        }

        return result;
    }
}

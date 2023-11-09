package com.kglory.signservice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * PackageName 	: com.kglory.signservice
 * FileName 	: algorism
 * Author 		: jhchoi
 * Date 		: 2023-10-17
 * Description 	:
 * ======================================================
 *
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-10-17			jhchoi				최초 생성
 */
public class Algorism {
	public static void main(String[] args) {
		Algorism algorism = new Algorism();
		int[] num_list = {12, 4, 15, 46, 38, 1, 14};
		System.out.println(" = " + algorism.solution(num_list));
	}

	public int[] solution(int[] num_list) {
		int[] answer = {};

		int[] ints = Arrays.stream(num_list).sorted().skip(5).toArray();


		return answer;
	}
}

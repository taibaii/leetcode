package com.mj.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author onlineGenerator-by wuxm4
 * @version V1.0
 * @Title:
 * @Description:
 * @date 2020-1-28
 */
public class Test {
    public static void main(String[] args) {
        LetterCombOfPhone letterCombOfPhone = new LetterCombOfPhone();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入0-9的组合数字");
            String digits = scanner.nextLine();
            List<String> resList = letterCombOfPhone.letterCombinations(digits);
            String[] strings = new String[resList.size()];
            resList.toArray(strings);
            System.out.println("共"+resList.size()+"元素");
            System.out.println("输出结果为:"+ Arrays.toString(strings));
        }
    }
}

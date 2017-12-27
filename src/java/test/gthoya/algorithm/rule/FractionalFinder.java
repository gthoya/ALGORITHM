package gthoya.algorithm.rule;

public class FractionalFinder {
    // orderCount == 1 , i == 1 , sum == 1 , 1/1
    // orderCount == 2 , i == 2 , sum == 3 , 1/2
    // orderCount == 3 , i == 2 , sum == 3 , 2/1
    // orderCount == 4 , i == 3 , sum == 6 , 3/1
    // orderCount == 5 , i == 3 , sum == 6 , 2/2
    // orderCount == 6 , i == 3 , sum == 6 , 1/3
    // orderCount == 7 , i == 4 , sum == 10 , 1/4
    // orderCount == 8 , i == 4 , sum == 10 , 2/3

    // 분모 + 분자 = i + 1
    // i 가 홀수인 경우 ? 분자가 i 부터 시작 (sum - orderCount + 1 / i + 1 - (sum - orderCount + 1)) : 분모가 i 부터 시작 (i + 1 - (sum - orderCount + 1) / sum - orderCount + 1)
}

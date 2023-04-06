import java.util.*;

public class Baseball {
    public static void main(String[] args) {
        int[] com = new int[3]; // 컴퓨터 랜덤 숫자 3개
        Scanner sc = new Scanner(System.in);

        int strike = 0;
        int ball = 0;
        int totalGame = 0;

        // com 랜덤값 추출
        for (int i = 0; i < com.length; i++) {
            com[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (com[i] == com[j]) {
                    i--;
                }
            }
        }

        // com 랜덤값 확인
//        for (int x : com
//        ) {
//            System.out.println(x);
//        }

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        while (true) {
            System.out.print((totalGame + 1) + "번째 시도 : ");

            int num = sc.nextInt();
            int one = num%10;
            int ten = num/10%10;
            int hundred = num/100;
            int[] nums = {hundred, ten, one};

            for(int i=0; i<com.length; i++){
                for(int j=0; j<nums.length;j++){
                    if(com[i]==nums[j] && i ==j){
                        strike++;
                    } else if (com[i]==nums[j] && i !=j) {
                        ball++;
                    }
                }
            }

            if(ball == 3){
                System.out.println(ball + "B");
            }else{
                System.out.println(ball + "B" + strike + "S");
            }
            totalGame++;
            if (strike == 3) {
                System.out.println(strike+"S");
                System.out.println(totalGame + "번 만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }else{
                strike = 0;
                ball = 0;
            }
        }
    }
}


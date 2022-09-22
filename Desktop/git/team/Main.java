package team;

import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stat stat = new Stat();
		Event ev = new Event();
		String yN;
		
		int finish = 0;
		while (finish == 0) {
			
			System.out.println("========================================================");
			System.out.println("<<<<<                  취준생의 하루                   >>>>>");
			System.out.println("========================================================");
			System.out.println("게임을 시작하시겠습니까? (Y/N)");
			yN = sc.next();

			if (yN.equals("Y") || yN.equals("y")) {
				
				stat.rule(Stat.name);	// 게임 규칙, 유저 이름 작성
				System.out.println(Stat.name + "의 기본스탯입니다.");
				stat.stat_show();		// 기본 스탯 보여주기
				for (int i = 1; i < 11; i++) {
					if(finish == 0) {
						if (i == 2) {			// 2일차 이벤트
							ev.day2_ev();
							finish = ev.stress(finish);
						} else if (i == 4) {	// 4일차 이벤트
							ev.day4_ev();
							finish = ev.stress(finish);
						} else if (i == 6) {	// 6일차 이벤트
							ev.day6_ev();
							ev.stat_show();
							finish = ev.stress(finish);
						} else if(i == 8) {		// 8일차 이벤트
							ev.day8_ev();
							ev.stat_show();
							finish = ev.stress(finish);
						} else if(i == 10) {	// 결과(직업선택)
							ev.result();
//							finish++;
						} else {				// 홀수날 이벤트
							System.out.println("\n" + i + "일째 일과를 선택해주세요");
							ev.dailty_ev();
							finish = ev.stress(finish);
						}
					}
				}
			} else if (yN.equals("N") || yN.equals("n")) {
				System.out.println("게임이 종료되었습니다!!");
				break;
			} else {
				System.out.println("잘 못 누르셨습니다. 다시 눌러주세요");
			}

		}

	}

}

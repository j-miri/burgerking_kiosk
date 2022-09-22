package team;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Event {
	Stat stat = new Stat();
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	int ck = 0;

	int choice = 0;

	void lucky() {	// 홀수날 이벤트때 운은 랜덤으로 변함
		int ranNum = (ran.nextInt(3) + 1);
		if (ranNum % 2 == 1) {
			stat.stat[4] += 1;
			System.out.println("오늘은 운이 좋은 하루에요^0^ (운 +2)");
		} else {
			stat.stat[4] -= 1;
			System.out.println("오늘은 운이 안 좋은 하루에요ㅠㅠ (운 -1)");
		}
	}

	void stat_show() {
		stat.stat_show();
	}

	void dailty_ev() {	// 홀수날 이벤트
		while (true) {
			System.out.println("1. 공부하기 \n2. 운동하기\n3. 유튜브보기\n4. 잠자기\n5. 밥먹기  ");
			choice = sc.nextInt();
			if (choice == 1) { // 공부하기
				System.out.println(Stat.name + " : 또 공부야.....지친다...");
				stat.stat[0] += 2; // 지능
				stat.stat[1] -= 1; // 체력
				stat.stat[2] -= 1; // 게으름
				stat.stat[3] += 3; // 스트레스
				break;
			} else if (choice == 2) { // 운동하기
				System.out.println(Stat.name + " : 운동은 몸에 좋지ㅋㅋ");
				stat.stat[0] += 1;
				stat.stat[1] += 2;
				stat.stat[2] -= 1;
				stat.stat[3] += 3;
				break;
			} else if (choice == 3) {	// 유튜브 보기
				System.out.println(Stat.name + " : 딱 하나만 보고 공부하자!!");
				stat.stat[0] -= 1;
				stat.stat[1] -= 1;
				stat.stat[2] += 2;
				stat.stat[3] -= 2;
				break;
			} else if (choice == 4) {	// 잠자기
				System.out.println(Stat.name + " : 딱 30분만 자는거야zzz");
				stat.stat[0] -= 1;
				stat.stat[1] -= 2;
				stat.stat[2] += 2;
				stat.stat[3] -= 2;
				break;
			} else if (choice == 5) {	// 밥먹기
				System.out.println(Stat.name + " : 공부하려면 체력이 중요해!!");
				menu();
				if (ck == 0) {
					stat.stat[0] -= 1;
					stat.stat[1] += 1;
					stat.stat[2] += 2;
					stat.stat[3] -= 2;
					break;
				}
			} else {
				System.out.println("잘 못 고르셨습니다. 다시 선택해주세요~");
			}
		}

		lucky();
		stat_show();
		ck = 0;
	}

	void day2_ev() {	// 2일 이벤트
		while (true) {
			System.out.println("\n2일째 단기 아르바이트 자리가 들어왔습니다.\n아르바이트를 선택하세요");
			System.out.println("1. 공사판 노가다");
			System.out.println("2. 전단지 아르바이트");
			System.out.println("3. 쿠팡 상하차");
			System.out.println("4. 술집 서빙");
			System.out.println("5. 거절하기");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("공사판 노가다를 선택하셨습니다.");
				System.out.println(Stat.name + " : 노가다.. 괜히했나?");
				stat.money += 10000;
				stat.stat[1] += 2;
				stat.stat[3] += 1;
				stat.stat_show();
				break;
			} else if (choice == 2) {
				System.out.println("전단지 아르바이트를 선택하셨습니다.");
				System.out.println(Stat.name + " : 전단지 몰래 버리길 잘했다 ㅎㅎ");
				stat.money += 5000;
				stat.stat[1] += 1;
				stat.stat[3] += 1;
				stat.stat_show();
				break;
			} else if (choice == 3) {
				System.out.println("쿠팡 상하차를 선택하셨습니다.");
				System.out.println(Stat.name + " : 허리가 끊어질것 같다 살려줘..");
				stat.money += 8000;
				stat.stat[1] += 2;
				stat.stat[3] += 1;
				stat.stat_show();
				break;
			} else if (choice == 4) {
				System.out.println("술집 서빙을 선택하셨습니다.");
				System.out.println(Stat.name + " : 맥주 한잔은 괜찮겠지..?");
				stat.money += 6000;
				stat.stat[1] += 1;
				stat.stat[3] += 1;
				stat.stat_show();
				break;
			} else if (choice == 5) {
				System.out.println("쿠팡 상하차를 선택하셨습니다.");
				System.out.println(Stat.name + " : 유튜브나 봐야징 ㅎㅎ");
				stat.money -= 3000;
				stat.stat[1] -= 2;
				stat.stat[3] -= 2;
				stat.stat_show();
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}

	}

	void day4_ev() {	// 4일 이벤트
		while (true) {
			System.out.println("\n4일째 선물이 도착했습니다. 선물을 골라주세요~ (번호입력)");
			System.out.println("=====================선물=======================");
			System.out.print("| ");
			System.out.print("1.비밀ㅋ   2.알려주기시른뎅   3.쉿!  4.골라봥  5.ㅋㅋ |\n");
			System.out.println("==============================================");
			choice = sc.nextInt();
			if (choice == 1) { // 책
				System.out.println("책이 나왔습니다.");
				System.out.println(Stat.name + " : 책이네.... 버릴까???");
				stat.stat[0] += 1; // 지능
				stat_show();
				break;
			} else if (choice == 2) { // 운동기구
				System.out.println("운동기구가 나왔습니다.");
				System.out.println(Stat.name + " : 아.. 땀나는거 싫은데");
				stat.stat[1] += 1;
				stat_show();
				break;
			} else if (choice == 3) { // 테블릿pc
				System.out.println("테블릿PC가 나왔습니다.");
				System.out.println(Stat.name + " : 개꿀!!!!!!");
				stat.stat[2] += 1;
				stat_show();
				break;
			} else if (choice == 4) { // 치킨
				System.out.println("치킨이 나왔습니다.");
				System.out.println(Stat.name + " : 맛있겠다ㅎㅎ");
				stat.stat[2] += 2;
				stat_show();
				break;
			} else if (choice == 5) { // 용돈
				System.out.println("용돈을 10000원 획득했습니다.");
				System.out.println(Stat.name + " : 개꿀!! 예~~!!!");
				stat.stat[4] += 1;
				stat.money += 10000;
				stat_show();
				break;
			} else {
				System.out.println("잘 못 누르셨습니다. 다시 선택해주세요");
			}

		}

	}

	void day6_ev() {	// 6일 이벤트
		System.out.println("\n6일째 친구 정준하에게 오랜만에 연락이 왔습니다.");
		System.out.println("친구와의 일정을 선택해주세요");
		day6While: while (true) {
			System.out.println("1. 술마시기 (소지금 5000원 지참)");
			System.out.println("2. 전시회 가기 (소지금 5000원 지참)");
			System.out.println("3. 놀이공원 가기 (소지금 5000원 지참)");
			System.out.println("4. 공원 산책하기 (소지금 2000원 지참)");
			System.out.println("5. 헌팅하기 (소지금 5000원 지참)");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if(stat.money >= 5000) {
					stat.stat[1] -= 1;
					stat.stat[3] -= 1;
					stat.stat[0] -= 2;
					stat.money -= 5000;
					System.out.println(Stat.name + " : 술을 먹으니까 인생이 더욱 쓰다...");
					break day6While;					
				}else {
					System.out.println("소지금이 부족합니다.");
					System.out.println("다시 선택해주세요.");
					break;
				}
			case 2:
				if(stat.money >= 5000) {
					stat.stat[0] += 2;
					stat.stat[1] -= 1;
					stat.stat[3] -= 1;
					stat.money -= 5000;
					System.out.println(Stat.name + " : 전시회가 너무 재미없다.. 술이나 마실껄");
					break day6While;					
				}else {
					System.out.println("소지금이 부족합니다.");
					System.out.println("다시 선택해주세요.");
					break;
				}
			case 3:
				if(stat.money >= 5000) {
					stat.stat[1] += 1;
					stat.stat[3] -= 1;
					stat.money -= 5000;
					System.out.println(Stat.name + " : 정준하 여기서도 재미없네..");
					break day6While;					
				}else {
					System.out.println("소지금이 부족합니다.");
					System.out.println("다시 선택해주세요.");
					break;
				}
			case 4:
				if(stat.money >= 2000) {
					stat.stat[1] += 2;
					stat.stat[3] -= 1;
					stat.money -= 2000;
					System.out.println(Stat.name + " : 신선한 공기 너무좋다.");
					break day6While;					
				}else {
					System.out.println("소지금이 부족합니다.");
					System.out.println("다시 선택해주세요.");
					break;
				}
			case 5:
				if(stat.money >= 5000) {
					stat.stat[4] += 5;
					stat.stat[3] += 2;
					stat.money -= 5000;
					System.out.println(Stat.name + " : 오늘만을 기다렸다...ㅋ");
					break day6While;					
				}else {
					System.out.println("소지금이 부족합니다.");
					System.out.println("다시 선택해주세요.");
					break;
				}
			default:
				System.out.println("잘 못 누르셨습니다. 다시 선택해주세요~~ 왜그르는 거양!!");
				break;
			}
		}
	}

	void day8_ev() {	// 8일 이벤트
		System.out.println("\n8일째 오랜만에 찾아온 면접기회 당신의 대답은? (번호입력)");
		System.out.println("면접관 : 자네는 돈키호테의 저자를 알고있나?");
		System.out.println("1. 엮은이는 아는데요? 김경식씨....");
		System.out.println("2. 미겔 데 세르반테스");
		System.out.println("3. 라만차");
		System.out.println("4. 프란시스코 데 로블레스");
		System.out.println("5. 잘 모르겠습니다.");
		day8While: while (true) {
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println(Stat.name + " : 무슨 이딴걸 물어보지?..");
				stat.stat[4] += 5;
				break day8While;
			case 2:
				System.out.println(Stat.name + " : 문제가 너무 쉬운걸?");
				stat.stat[0] += 3;
				stat.stat[4] += 5;
				break day8While;
			case 3:
				System.out.println(Stat.name + " : 라..만..차???.. 모르것다");
				stat.stat[0] -= 3;
				break day8While;
			case 4:
				System.out.println(Stat.name + " : 프란.. 머시기 였던것 같은데..");
				stat.stat[0] -= 3;
				break day8While;
			case 5:
				System.out.println(Stat.name + " : 망했따......즈ㅗㅝㅇ먀ㅓ;");
				stat.stat[0] -= 5;
				break day8While;
			default:
				System.out.println("잘 못 눌렸습니다. 다시 선택해주세요~~");
				break;
			}
		}
	}

	void result() {
		System.out.println("\n9일이 지난후.....");
		System.out.println("<<< " + Stat.name + "의 최종 스탯 >>>");
		stat_show();

		int max_stat = 0;
		int cnt = 0;
		ArrayList<String> job = new ArrayList<>();
		ArrayList<String> maxStat = new ArrayList<>();

		for (int i = 0; i < stat.stat.length; i++) {
			if (stat.stat[i] > max_stat) {
				max_stat = stat.stat[i];
			}
		}

		for (int i = 0; i < stat.stat.length; i++) {
			if (stat.stat[i] == max_stat) {
				maxStat.add(stat.stat_name[i][0]);
				job.add(stat.stat_name[i][1]);
				cnt++;
			}
		}
		if (cnt == 1) {
			System.out.println(maxStat.toString() + " 가장 높게 나왔습니다.");
			System.out.println(Stat.name + "의 직업은!!!!!!");
			System.out.println(job.toString() + " 입니다.");
			System.out.println("게임이 종료 되었습니다.");
		} else {
			System.out.println(maxStat.toString() + " 가장 높게 나왔습니다.");
			System.out.println(job.toString() + " 직업 중 랜덤으로 선택됩니다.");
			int job_ind = ran.nextInt(job.size());
			System.out.println(Stat.name + "의 직업은 [" + job.get(job_ind) + "] 입니다.");
			System.out.println("게임이 종료 되었습니다.");
		}

		
//		for (int i = 0; i < stat.stat.length; i++) {	// 게임 스탯 리셋
//			stat.stat[i] = 15;
//		}
//		stat.money = 20000;
	}

	int stress(int finish) {
		if (stat.stat[3] >= 25) {
			System.out.println("스트레스가 25이 넘어 환자가 되어 취업에 실패했습니다.");
			System.out.println("게임이 종료됩니다.");
			System.out.println(Stat.name + " : 이번생은 글렀다..");
			finish++;
			return finish;
		} else if (stat.stat[3] >= 20) {
			System.out.println("!!! <경고> !!!");
			System.out.println("스트레스 지수가 너무 높습니다. 스트레스를 줄여주세요.");
			System.out.println("스트레스가 25가 넘으면 환자가 되어 게임은 종료됩니다.");
		}
		return finish;
	}

	void menu() {
		int menu1 = 5000;
		int menu2 = 4000;
		int menu3 = 4500;
		System.out.println("\n메뉴를 선택해주세요");
		System.out.println("1. 김치찌개 : 5000원");
		System.out.println("2. 돈까스 : 4000원");
		System.out.println("3. 짜장면 : 4500원");
		System.out.println(Stat.name + " : 음... 오늘은 뭘 먹지??");
		int choice = sc.nextInt();
		if (choice == 1) {
			if (stat.money >= 5000) {
				stat.money -= 5000;
				System.out.println(Stat.name + " : 국물이 진하니까 좋구만");
			} else {
				System.out.println("돈이 부족합니다.");
				ck++;
			}

		} else if (choice == 2) {
			if (stat.money >= 4000) {
				stat.money -= 4000;
				System.out.println(Stat.name + " : 바삭 바삭 하니 돈까스 너무 맛있네~~");
			} else {
				System.out.println("돈이 부족합니다.");
				ck++;
			}

		} else if (choice == 3) {
			if (stat.money >= 4500) {
				stat.money -= 4500;
				System.out.println(Stat.name + " : 후루룩~ 후루룩~ 역시 짜장면!!");
			} else {
				System.out.println("돈이 부족합니다.");
				ck++;
			}
		}
	}
}

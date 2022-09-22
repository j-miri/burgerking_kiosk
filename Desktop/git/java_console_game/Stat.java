package team;

import java.util.Scanner;

public class Stat {
	Scanner sc = new Scanner(System.in);

	static String name = " ";	// 유저 이름
	int money = 20000;

	int[] stat = new int[5];
	{
		stat[0] = 15; // 지능
		stat[1] = 15; // 체력
		stat[2] = 15; // 게으름
		stat[3] = 15; // 스트레스
		stat[4] = 15; // 운
	}

	String[][] stat_name = new String[5][2];
	{
		stat_name = new String[][] { { "지능", "개발자" },
			{ "체력", "운동선수" }, { "게으름", "백수" },
			{ "스트레스", "환자" }, { "운", "백만장자" } };
	}

	void stat_show() {	// 스탯 변화
		System.out.println("                                          소지금 : " + money);
		System.out.println("========================= 스 탯 =========================");
		System.out.print("|  ");
		for (int i = 0; i < 5; i++) {
			System.out.print(stat_name[i][0] + " : " + stat[i] + "  ");
		}
		System.out.println(" |");
		System.out.println("========================================================");
	}

	void rule(String name) {	// 게임 룰 / 유저 이름 
		System.out.println("======================= Game Rule ======================");
		System.out.println("          유저의 '스탯'은 기본적으로 15으로 고정되어 있습니다.        ");
		System.out.println("            유저의 소지금은 20000원으로 고정되어 있습니다.          ");
		System.out.println("        이벤트 선택에 따라 스텟이 다양하게 올라가거나 내려갑니다.        ");
		System.out.println("               스탯은 일과 선택 결과에 따라 변동됩니다.             ");
		System.out.println("          스탯 \"운\"은 선택 결과에 따라 랜덤으로 증가됩니다          ");
		System.out.println("             9일이 지난 후 스텟에 따라 직업이 결정됩니다.            ");
		System.out.println("         가장 높은 스탯이 중복될 경우 랜덤으로 직업이 결정됩니다.        ");
		System.out.println("            소지금이 부족할 경우 밥 먹기 선택이 불가능합니다.          ");
		System.out.println("               소지금이 부족 할 경우 약속이 제한됩니다.              ");
		System.out.println("               스트레스가 25이상일때 게임이 종료됩니다.             ");
		System.out.println("========================================================");
		System.out.println("유저의 이름을 적어주세요");
		name = sc.nextLine();
		System.out.println(name + "은(는) 취준생입니다.");
		Stat.name = name;
	}

//	String name() {
//	      String nameOnIt = new String();
//	      nameOnIt= sc.nextLine();
//	      return nameOnIt;
//	}

}

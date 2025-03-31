import customDataTypes.NonNegativeInt;
import enums.QuestType;
import enums.Rarity;
import valueObjects.Quest;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello, World!");

		System.out.println("Args:");
		Arrays.stream(args).forEach(arg -> System.out.println(" -> " + arg));

		var n = NonNegativeInt.of(1);
		System.out.println(n);

		var m = NonNegativeInt.of(17);
		var p = m.plus(n).plus(n).plus(n);
		System.out.println(p);

		var q = new Quest(
			1,
			"Test Quest",
			"This is a quest to make the quests system work!",
			QuestType.BOSS,
			Rarity.LEGENDARY,
			NonNegativeInt.of(1),
			NonNegativeInt.of(1),
			new ArrayList<>()
		);

		System.out.println(q.getRarity().getColor());
	}
}
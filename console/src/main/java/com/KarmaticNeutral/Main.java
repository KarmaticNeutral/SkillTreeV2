package com.KarmaticNeutral;

import com.KarmaticNeutral.customDataTypes.NonNegativeInt;
import com.KarmaticNeutral.enums.QuestType;
import com.KarmaticNeutral.enums.Rarity;
import com.KarmaticNeutral.verbs.CreateQuestVerb;
import com.KarmaticNeutral.verbs.GetActiveQuestsForUserVerb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.KarmaticNeutral.valueObjects.Quest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableAsync
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		CreateQuestVerb createQuestVerb = context.getBean(CreateQuestVerb.class);
		GetActiveQuestsForUserVerb getActiveQuestsForUserVerb = context.getBean(GetActiveQuestsForUserVerb.class);
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

		var res = createQuestVerb.execute(Arrays.stream(args).toList());
		try {
			res.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(q.getRarity().getColor());

		var res2 = getActiveQuestsForUserVerb.execute(List.of("1"));
		try {
			res2.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		context.close();
	}
}
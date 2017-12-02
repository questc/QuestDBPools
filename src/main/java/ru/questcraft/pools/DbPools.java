package ru.questcraft.pools;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DbPools {


    private static QuestPools questPools;

    public static QuestPools getQuestPools() {
        if (questPools == null) throw new IllegalStateException("Pools is not loaded yet.");
        return questPools;
    }
}

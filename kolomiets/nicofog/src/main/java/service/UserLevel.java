package service;

/**
 * Help count user time for next smoke
 */
public enum UserLevel {
    ZERO(0, 100, 0),
    ONE(1, 100, 1),
    TWO(2, 95, 3),
    THREE(3, 90, 10),
    FOUR(4, 80, 17),
    FIVE(5, 67, 24),
    SIX(6, 50, 30),
    SEVEN(7, 30, 36),
    EIGHT(8, 6, 41),
    NINE(9, 0, 45);

    private int value;
    private int percent;
    private int dayAfterRegistration;

    UserLevel(int value, int percent, int dayAfterRegistration) {
        this.value = value;
        this.percent = percent;
        this.dayAfterRegistration = dayAfterRegistration;
    }

    public int getValue() {
        return value;
    }

    public int getPercent() {
        return percent;
    }

    public UserLevel getByValue(int value) {
        for (UserLevel lvl : UserLevel.values()) {
            if (lvl.value == value) {
                return lvl;
            }
        }
        return ZERO;
    }

    public UserLevel getByDays(int days) {
        UserLevel userLevel = ZERO;
        for (UserLevel lvl : UserLevel.values()) {
            if (lvl.value > userLevel.value && lvl.dayAfterRegistration <= days) {
                userLevel = lvl;
            }
        }
        return userLevel;
    }
}

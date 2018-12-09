package entity;

import java.time.LocalDateTime;

/**
 * Represent depend one to one from user.
 * Make extend function for issue by cigarette of user
 */
public class Cigarette {
    public Cigarette() {
    }

    private long id;
    private LocalDateTime lastSmokeTime;
    private int averageTime;
    private int level;
    private int cigarettesPerDay;
    private int allCigarettesSmoke;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getLastSmokeTime() {
        return lastSmokeTime;
    }

    public void setLastSmokeTime(LocalDateTime lastSmokeTime) {
        this.lastSmokeTime = lastSmokeTime;
    }

    public int getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCigarettesPerDay() {
        return cigarettesPerDay;
    }

    public void setCigarettesPerDay(int cigarettesPerDay) {
        this.cigarettesPerDay = cigarettesPerDay;
    }

    public int getAllCigarettesSmoke() {
        return allCigarettesSmoke;
    }

    public void setAllCigarettesSmoke(int allCigarettesSmoke) {
        this.allCigarettesSmoke = allCigarettesSmoke;
    }
}

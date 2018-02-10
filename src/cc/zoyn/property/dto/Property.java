package cc.zoyn.property.dto;

import cc.zoyn.property.PropertyPlugin;

/**
 * @author Zoyn
 * @since 2018-01-20
 */
public class Property {

    private String name;
    private double physicalAttack = PropertyPlugin.getInstance().getConfig().getDouble("option.default.physical-attack");
    private double physicalDefense = PropertyPlugin.getInstance().getConfig().getDouble("option.default.physical-defense");

    private double fireAttack = PropertyPlugin.getInstance().getConfig().getDouble("option.default.fire-attack");
    private double fireDefense = PropertyPlugin.getInstance().getConfig().getDouble("option.default.fire-defense");
    private double woodAttack = PropertyPlugin.getInstance().getConfig().getDouble("option.default.wood-attack");
    private double woodDefense = PropertyPlugin.getInstance().getConfig().getDouble("option.default.wood-defense");
    private double waterAttack = PropertyPlugin.getInstance().getConfig().getDouble("option.default.water-attack");
    private double waterDefense = PropertyPlugin.getInstance().getConfig().getDouble("option.default.water-defense");
    private double lightAttack = PropertyPlugin.getInstance().getConfig().getDouble("option.default.light-attack");
    private double lightDefense = PropertyPlugin.getInstance().getConfig().getDouble("option.default.light-defense");
    private double darkAttack = PropertyPlugin.getInstance().getConfig().getDouble("option.default.dark-attack");
    private double darkDefense = PropertyPlugin.getInstance().getConfig().getDouble("option.default.dark-defense");

    private double health = PropertyPlugin.getInstance().getConfig().getDouble("option.default.health");
    private double healthScala = PropertyPlugin.getInstance().getConfig().getDouble("option.default.health-scala");
    private double suckBlood = PropertyPlugin.getInstance().getConfig().getDouble("option.default.suck-blood");
    private double realAttack = PropertyPlugin.getInstance().getConfig().getDouble("option.default.real-attack");
    // 以下需百分比
    private double dodge = PropertyPlugin.getInstance().getConfig().getDouble("option.default.dodge");
    private double hit = PropertyPlugin.getInstance().getConfig().getDouble("option.default.hit");
    private double expPlus = PropertyPlugin.getInstance().getConfig().getDouble("option.default. exp-plus");
    private double movementSpeed = PropertyPlugin.getInstance().getConfig().getDouble("option.default.movement-speed");

    public Property() {
    }

    public Property(String playerName) {
        if (playerName == null) {
            physicalAttack = 0;
            physicalDefense = 0;
            fireAttack = 0;
            fireDefense = 0;
            woodAttack = 0;
            woodDefense = 0;
            waterAttack = 0;
            waterDefense = 0;
            lightAttack = 0;
            lightDefense = 0;
            darkAttack = 0;
            darkDefense = 0;
            health = 0;
            healthScala = 0;
            suckBlood = 0;
            realAttack = 0;
            dodge = 0;
            hit = 0;
            expPlus = 0;
            movementSpeed = 0;
        } else {
            this.name = playerName;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPhysicalAttack() {
        return physicalAttack;
    }

    public void setPhysicalAttack(double physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public double getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(double physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public double getFireAttack() {
        return fireAttack;
    }

    public void setFireAttack(double fireAttack) {
        this.fireAttack = fireAttack;
    }

    public double getFireDefense() {
        return fireDefense;
    }

    public void setFireDefense(double fireDefense) {
        this.fireDefense = fireDefense;
    }

    public double getWoodAttack() {
        return woodAttack;
    }

    public void setWoodAttack(double woodAttack) {
        this.woodAttack = woodAttack;
    }

    public double getWoodDefense() {
        return woodDefense;
    }

    public void setWoodDefense(double woodDefense) {
        this.woodDefense = woodDefense;
    }

    public double getWaterAttack() {
        return waterAttack;
    }

    public void setWaterAttack(double waterAttack) {
        this.waterAttack = waterAttack;
    }

    public double getWaterDefense() {
        return waterDefense;
    }

    public void setWaterDefense(double waterDefense) {
        this.waterDefense = waterDefense;
    }

    public double getLightAttack() {
        return lightAttack;
    }

    public void setLightAttack(double lightAttack) {
        this.lightAttack = lightAttack;
    }

    public double getLightDefense() {
        return lightDefense;
    }

    public void setLightDefense(double lightDefense) {
        this.lightDefense = lightDefense;
    }

    public double getDarkAttack() {
        return darkAttack;
    }

    public void setDarkAttack(double darkAttack) {
        this.darkAttack = darkAttack;
    }

    public double getDarkDefense() {
        return darkDefense;
    }

    public void setDarkDefense(double darkDefense) {
        this.darkDefense = darkDefense;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealthScala() {
        return healthScala;
    }

    public void setHealthScala(double healthScala) {
        this.healthScala = healthScala;
    }

    public double getSuckBlood() {
        return suckBlood;
    }

    public void setSuckBlood(double suckBlood) {
        this.suckBlood = suckBlood;
    }

    public double getRealAttack() {
        return realAttack;
    }

    public void setRealAttack(double realAttack) {
        this.realAttack = realAttack;
    }

    public double getDodge() {
        return dodge;
    }

    public void setDodge(double dodge) {
        this.dodge = dodge;
    }

    public double getHit() {
        return hit;
    }

    public void setHit(double hit) {
        this.hit = hit;
    }

    public double getExpPlus() {
        return expPlus;
    }

    public void setExpPlus(double expPlus) {
        this.expPlus = expPlus;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    @Override
    public String toString() {
        return "    §7物理攻击: §f" + physicalAttack + "  §7物理防御: §f" + physicalDefense + "  §7火系攻击: §f" + fireAttack + "\n" +
                "    §7火系防御: §f" + fireDefense + "  §7木系攻击: §f" + woodAttack + "  §7木系防御: §f" + woodDefense + "\n" +
                "    §7水系攻击: §f" + waterAttack + "  §7水系防御: §f" + waterDefense + "  §7光系攻击: §f" + lightAttack + "\n" +
                "    §7光系防御: §f" + lightDefense + "  §7暗系攻击: §f" + darkAttack + "  §7暗系防御: §f" + darkDefense + "\n" +
                "    §7血量恢复: §f" + healthScala + "  §7吸血: §f" + suckBlood + "  §7移动速度: §f" + movementSpeed + "%\n" +
                "    §7真实伤害: §f" + realAttack + "  §7闪避几率: §f" + dodge + "%" + "  §7命中几率: §f" + hit + "%\n" +
                "    §7经验加成: §f" + expPlus + "%"
                ;
    }
}
